package visual;

import geometry.Bezier;
import geometry.IPoint;
import geometry.Point;

/**
 * Created by Артём on 04.10.2017.
 */
public class VisualBezier extends VisualCurve {
    Bezier b;

    public VisualBezier(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        b = new Bezier(new Point(x1, y1), new Point(x2, y2), new Point(x3, y3), new Point(x4, y4));
    }

    public VisualBezier(IPoint a, IPoint b1, IPoint c, IPoint d, int step) {
        b = new Bezier(a, b1, c, d);
    }

    @Override
    public IPoint getPoint(double t) {
        return b.getPoint(t);
    }

    @Override
    public double getLength(double t) {
        return b.getLength(t);
    }

    @Override
    public double getParam(double l) {
        return b.getParam(l);
    }

}
