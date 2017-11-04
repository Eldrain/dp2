package visual;

import geometry.IPoint;

import java.io.IOException;

/**
 * Created by Артём on 03.11.2017.
 */
public class SVGDrawer2 extends ASVGDrawer {

    public SVGDrawer2(double width, double height) {
        super(width, height);
    }

    @Override
    public void line(IPoint from, IPoint to) {
        try {
            file.append("\n<line stroke=\"black\" x1=\"" + from.getX() + "\" y1=\"" + from.getY() +
                    "\" x2=\"" + to.getX() + "\" y2=\"" + to.getY() + "\" />");
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startP(IPoint p) {
        try {
            file.append("\n<rect fill=\"black\" x=\"" + (p.getX() - 3) + "\" y=\"" + (p.getY() - 3) +
                    "\" width=\"6\" height=\"6\" />");
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void finishP(IPoint prevP, IPoint lastP) {
        try {
            file.append("\n<rect fill=\"black\" x=\"" + (lastP.getX() - 3) + "\" y=\"" + (lastP.getY() - 3) +
                    "\" width=\"6\" height=\"6\" />");
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
