package geometry;

/**
 * Created by Артём on 04.10.2017.
 */
public interface IPoint {
    double getX();

    double getY();

    void setX(double x);

    void setY(double y);

    IPoint add(double x, double y);

}
