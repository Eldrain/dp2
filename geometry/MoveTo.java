package geometry;

/**
 * Created by Артём on 14.11.2017.
 */
public class MoveTo implements ICurve {
    private ICurve mCurve;
    IPoint mStartPoint;

    public MoveTo(ICurve curve, double moveX, double moveY) {
        mCurve = curve;
        mStartPoint.setX(moveX);// = moveX;
        mStartPoint.setY(moveY);//mY = moveY;
    }

    @Override
    public IPoint getPoint(double t) {
        return mCurve.getPoint(t).add(mStartPoint.getX(), mStartPoint.getY());
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
