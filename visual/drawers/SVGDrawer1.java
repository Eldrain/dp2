package visual.drawers;

import geometry.IPoint;

import java.io.IOException;

/**
 * Created by Артём on 03.11.2017.
 */
public class SVGDrawer1 extends ASVGDrawer {

    public SVGDrawer1(double width, double height, double h) {
        super(width, height, h);
    }

    @Override
    public void line(IPoint from, IPoint to) {
        try {
            file.append("\n<line stroke=\"green\" x1=\"" + from.getX() + "\" y1=\"" + from.getY() +
                    "\" x2=\"" + to.getX() + "\" y2=\"" + to.getY() + "\" />");
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startP(IPoint p) {
        try {
            file.append("\n<circle fill=\"green\" cx=\"" + p.getX() + "\" cy=\"" + p.getY() +
                    "\" r=\"3\"/>");
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void finishP(IPoint prevP, IPoint lastP) {
        try {
            file.append("\n<circle fill=\"green\" cx=\"" + lastP.getX() + "\" cy=\"" + lastP.getY() +
                    "\" r=\"3\"/>");
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
