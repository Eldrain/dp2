package visual;

import geometry.IPoint;

/**
 * Created by Артём on 13.10.2017.
 */
public interface IDrawer {
    void line(IPoint from, IPoint to);
    void startP(IPoint p);
    void finishP(IPoint prevP, IPoint lastP);
    //void clear();
}
