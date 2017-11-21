package geometry;

/**
 * Created by Артём on 14.11.2017.
 */
public class MoveTo implements ICurve {
    private ICurve mCurve;
    IPoint mVector;

    public MoveTo(ICurve curve, double moveX, double moveY) {
        mCurve = curve;
        mVector = new Point(0, 0);
        mVector.setX(moveX - curve.getPoint(0).getX());
        mVector.setY(moveY - curve.getPoint(0).getY());
    }

    public MoveTo(ICurve curve, IPoint point) {
        mCurve = curve;
        mVector = new Point(0, 0);
        mVector.setX(point.getX() - curve.getPoint(0).getX());
        mVector.setY(point.getY() - curve.getPoint(0).getY());
    }

    @Override
    public IPoint getPoint(double t) {
        return mCurve.getPoint(t).add(mVector.getX(), mVector.getY());
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
