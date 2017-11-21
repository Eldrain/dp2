package visual.drawers;

import geometry.IPoint;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import visual.drawers.ADrawer;

/**
 * Created by Артём on 20.10.2017.
 */
public class Drawer2 extends ADrawer {
    //private final int R = 50000;
    GraphicsContext c;
    int i;

    public Drawer2(GraphicsContext c, double h) {
        super(h);
        this.c = c;
    }
    
    @Override
    public void line(IPoint from, IPoint to) {
        i++;
        /*if(i > R)
            i = -R;*/
        //if(i >= 0) {
        c.setStroke(Color.BLACK);
        c.moveTo(from.getX(), from.getY());
        c.lineTo(to.getX(), to.getY());
        c.stroke();
        /*} else
            return;*/
    }

    @Override
    public void startP(IPoint p) {
        c.setFill(Color.BLACK);
        c.fillRect(p.getX() - 3, p.getY() - 3, 6, 6);
    }

    @Override
    public void finishP(IPoint prevP, IPoint lastP) {
        c.setFill(Color.BLACK);
        c.fillRect(lastP.getX() - 3, lastP.getY() - 3, 6, 6);
    }
    
}
