package geometry;

/**
 * Created by Артём on 17.11.2017.
 */
public class Chain implements ICurve {
    private ICurve mFirstCurve;
    private ICurve mSecondCurve;

    public Chain(ICurve curve1, ICurve curve2) {
        mFirstCurve = curve1;
        mSecondCurve = new MoveTo(curve2, mFirstCurve.getPoint(1));
    }

    @Override
    public IPoint getPoint(double t) {
        IPoint point = null;
        if(t <= 0.5)
            point = mFirstCurve.getPoint(t * 2);
        else {
            point = mSecondCurve.getPoint((t - 0.5)*2);
        }
        return point;
    }

    @Override
    public double getLength(double t) {
        double length = 0;

        if(t <= 0.5)
            length = mFirstCurve.getLength(t * 2);
        if(t > 0.5){
            length += mSecondCurve.getLength((t - 0.5)*2);
        }
        return length;
    }

    @Override
    public double getParam(double l) {
        double param = 0;
        double length1 = mFirstCurve.getLength(1);

        if(l <= length1)
            param = mFirstCurve.getParam(l);
        else {
            param = 0.5 + mSecondCurve.getParam(l - length1)/2;
        }
        return param;
    }
}
