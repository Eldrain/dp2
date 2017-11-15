package visual;

import geometry.ICurve;
import geometry.IPoint;

/**
 * Created by Артём on 04.10.2017.
 */
public class VisualCurve implements ICurve, IDrawable {
    private ICurve mCurve;

    public VisualCurve(ICurve curve) {
        mCurve = curve;
    }

    @Override
    public void Draw(IDrawer drawer) {
        double h = (double)1/100;
        IPoint p = this.getPoint(0), nextP = this.getPoint(h);

        drawer.startP(p);
        for(double t = 0; t <= 1; t+=h) {
            p = nextP;
            nextP = this.getPoint(t);
            drawer.line(p, nextP);
        }
        drawer.finishP(p, nextP);
    }

    public void DrawPoint(IDrawer drawer, double param) {
        drawer.startP(getPoint(param));
    }

    @Override
    public IPoint getPoint(double t) {
        return mCurve.getPoint(t);
    }

    @Override
    public double getLength(double t) {
        return mCurve.getLength(t);
    }

    @Override
    public double getParam(double l) {
        return mCurve.getParam(l);
    }
}
