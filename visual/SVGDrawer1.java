package visual;

import geometry.IPoint;

import java.io.IOException;

/**
 * Created by Артём on 03.11.2017.
 */
public class SVGDrawer1 extends ASVGDrawer {

    public SVGDrawer1(double width, double height, String filename) {
        super(width, height, filename);
    }

    @Override
    public void line(IPoint from, IPoint to) {
        try {
            file.append("<line stroke=\"#000\" x1=\"" + from.getX() + "\" y1=\"" + from.getY() +
                    "\" x2=\"" + to.getX() + "\" y2=\"" + to.getY() + "\" />");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startP(IPoint p) {

    }

    @Override
    public void finishP(IPoint prevP, IPoint lastP) {

    }
}
