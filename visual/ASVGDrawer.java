package visual;

import geometry.IPoint;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by Артём on 03.11.2017.
 */
public abstract class ASVGDrawer implements IDrawer {
    private double width, height;
    protected FileWriter file;

    public ASVGDrawer(double width, double height, String filename) {
        this.width = width;
        this.height = height;
        try {
            file = new FileWriter(filename);
            file.append("<svg width=\"" + width + "\" height=\"" + height + "\" xmlns=\"http://www.w3.org/2000/svg\">");
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void save() {
        try {
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
