package visual.drawers;

import geometry.ICurve;
import geometry.IPoint;

public abstract class ADrawer implements IDrawer {
    protected double mH;

    public ADrawer(double h) {
        mH = h;
    }

    @Override
    public void draw(ICurve curve) {
        IPoint p = curve.getPoint(0);
        IPoint nextP = curve.getPoint(mH);

        this.startP(p);
        for(double t = 0; t <= 1; t += mH) {
            p = nextP;
            nextP = curve.getPoint(t);
            this.line(p, nextP);
        }
        this.finishP(p, nextP);
    }

}
