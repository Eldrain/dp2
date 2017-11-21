package geometry;

/**
 * Created by Артём on 08.11.2017.
 */
public class LengthComparator implements IComparator {
    private double t;

    public LengthComparator(double param) {
        t = param;
    }

    @Override
    public boolean isStopping(double t, double l) {
        if(this.t <= t)
            return true;
        else
            return false;
    }

    @Override
    public double result(double t, double l) {
        return l;
    }
}
