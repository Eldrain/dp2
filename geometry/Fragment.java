package geometry;

/**
 *
 * Class for fragment of ICurve
 * Created by Артём on 14.11.2017.
 */
public class Fragment implements ICurve  {
    private ICurve mCurve;
    private double mStart;
    private double mRange;

    public Fragment(ICurve curve, double tStart, double tFinish) {
        mCurve = curve;
        this.mStart = tStart;
        this.mRange = tFinish - tStart;
    }

    @Override
    public IPoint getPoint(double t) {
        return mCurve.getPoint(mStart + mRange * t);
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
