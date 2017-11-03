package visual;

import geometry.ICurve;
import geometry.IPoint;

/**
 * Created by Артём on 04.10.2017.
 */
public abstract class VisualCurve implements ICurve, IDrawable {

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
}
