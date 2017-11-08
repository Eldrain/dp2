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
        IPoint nextP = null;

        for(; t <= 1; t+=h) {
            if(len.isStopping(t, l))
                return len.result(t, l);
            p = nextP;
            nextP = this.getPoint(t);
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
}
