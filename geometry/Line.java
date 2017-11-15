package geometry;

/**
 * Created by Артём on 04.10.2017.
 */
public class Line extends ACurve {

    public Line(IPoint a, IPoint b) {
        super(a, b);
    }

    public Line(double x1, double y1, double x2, double y2) {
        super(new Point(x1, y1), new Point(x2, y2));
    }

    @Override
    public IPoint getPoint(double t) {
        return new Point(0, 0).add(a, 1 - t).add(b, t);
    }
}
