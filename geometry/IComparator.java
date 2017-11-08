package geometry;

/**
 * Created by Артём on 08.11.2017.
 */
public interface IComparator {

    boolean isStopping(double t, double l);

    double result(double t, double l);
}
