package geometry;

/**
 * Created by Артём on 04.10.2017.
 */
public class Point implements IPoint {
    private double mX;
    private double mY;

    public Point(double x, double y) {
        mX = x;
        mY = y;
    }

    @Override
    public double getX() {
        return mX;
    }

    @Override
    public double getY() {
        return mY;
    }

    @Override
    public void setX(double x) {
        mX = x;
    }

    @Override
    public void setY(double y) {
        mY = y;
    }

    @Override
    public IPoint add(double x, double y) {
        mX += x;
        mY += y;
        return this;
    }

    public IPoint mult(double t) {
        mX = mX * t;
        mY = mY * t;
        return this;
    }

    public Point add(IPoint p, double mn) {
        mX = mX + mn*p.getX();
        mY = mY + mn*p.getY();
        return this;
    }
}
