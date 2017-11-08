package geometry;

/**
 * Created by Артём on 04.10.2017.
 */
public interface ICurve {

    IPoint getPoint(double t);

    double getLength(double t);

    double getParam(double l);
}
