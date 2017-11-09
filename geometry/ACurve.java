package geometry;

import sample.Main;

/**
 * Created by Артём on 04.10.2017.
 */
public abstract class ACurve implements ICurve {
    IPoint a, b;

    public ACurve(IPoint a, IPoint b) {
        this.a = a;
        this.b = b;
    }

    protected double runOnCurve(IComparator len) {
        double t = 0;
        double h = (double)1/ Main.RUNONCURVE_STEPS;
        double l = 0;
        IPoint p = this.getPoint(0);
        IPoint nextP = p;

        for(; t <= 1; t+=h) {
            p = nextP;
            nextP = this.getPoint(t);
            l += distance(p, nextP);

            if(len.isStopping(t, l))
                return len.result(t, l);
        }
        return len.result(t, l);
    }

    @Override
    public double getLength(double t) {
        return runOnCurve(new LengthComparator(t));
    }

    @Override
    public double getParam(double l) {
        return runOnCurve(new ParamComparator(l));
    }

    private double distance(IPoint p1, IPoint p2) {
        return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
    }
}
