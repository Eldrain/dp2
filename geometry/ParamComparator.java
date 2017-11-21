package geometry;

/**
 * Created by Артём on 08.11.2017.
 */
public class ParamComparator implements IComparator {
    private double l;

    public ParamComparator(double param) {
        l = param;
    }

    @Override
    public boolean isStopping(double t, double l) {
        if(this.l <= l)
            return true;
        else
            return false;
    }

    @Override
    public double result(double t, double l) {
        return t;
    }
}