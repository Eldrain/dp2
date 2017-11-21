package sample;

import java.util.Random;

import geometry.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import visual.*;
import visual.drawers.Drawer1;
import visual.drawers.Drawer2;
import visual.drawers.SVGDrawer1;
import visual.drawers.SVGDrawer2;

public class Main extends Application {
	
	public static final int RUNONCURVE_STEPS = 1000;
	private static final int CANVAS_WIDTH = 300;
	private static final int CANVAS_HEIGHT = 400;
	private static final String FILE1 = "picture1.svg";
	private static final String FILE2 = "picture2.svg";
    private SVGDrawer1 drawerSvg1;
    private SVGDrawer2 drawerSvg2;
    private Canvas reg1, reg2;
    private visual.Group cr1, cr2;
    private Button btn1, btn2, btn3, btn4;
    private static Text ta;
    private Random rnd;

    @Override
    public void start(Stage primaryStage) throws Exception{
    	rnd = new Random();
    	
        Group root = new Group();
        primaryStage.setTitle("Pattern lab1");
        primaryStage.setScene(new Scene(root, 800, 600));
        
        reg1 = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
        reg2 = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
        reg1.setTranslateX(50);
        reg1.setTranslateY(100);
        reg2.setTranslateX(400);
        reg2.setTranslateY(100);
        
        btn1 = new Button("generate");
        btn1.setTranslateX(50);
        btn1.setTranslateY(520);
        
        btn2 = new Button("generate");
        btn2.setTranslateX(400);
        btn2.setTranslateY(520);

        btn3 = new Button("Save SVG");
        btn3.setTranslateX(150);
        btn3.setTranslateY(520);

        btn4 = new Button("Save SVG");
        btn4.setTranslateX(500);
        btn4.setTranslateY(520);
        
        ta = new Text();
        ta.setTranslateX(400);
        ta.setTranslateY(50);
        
        root.getChildren().add(reg1);
        root.getChildren().add(reg2);
        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        root.getChildren().add(btn3);
        root.getChildren().add(btn4);
        root.getChildren().add(ta);

        primaryStage.show();

        GraphicsContext con1 = reg1.getGraphicsContext2D();
        GraphicsContext con2 = reg2.getGraphicsContext2D();
        con1.rect(0, 0, 300, 400);
        con2.rect(0, 0, 300, 400);
        Drawer1 drawer1 = new Drawer1(con1, 50);
        Drawer2 drawer2 = new Drawer2(con2, 30);
        drawerSvg1 = new SVGDrawer1(CANVAS_WIDTH, CANVAS_HEIGHT, 1000);
        drawerSvg2 = new SVGDrawer2(CANVAS_WIDTH, CANVAS_HEIGHT, 1000);

        cr1 = new visual.Group();
        cr2 = new visual.Group();

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                switch(rnd.nextInt(2)) {
                case 0:
                	cr1.addCurve(new Line(CANVAS_WIDTH * rnd.nextDouble(), CANVAS_HEIGHT* rnd.nextDouble(),
                            CANVAS_WIDTH* rnd.nextDouble(), CANVAS_HEIGHT* rnd.nextDouble()));
                	break;
                case 1:
                	cr1.addCurve(new Bezier(CANVAS_WIDTH * rnd.nextDouble(), CANVAS_HEIGHT* rnd.nextDouble(), CANVAS_WIDTH* rnd.nextDouble(), CANVAS_HEIGHT* rnd.nextDouble(),
                			CANVAS_WIDTH * rnd.nextDouble(), CANVAS_HEIGHT* rnd.nextDouble(), CANVAS_WIDTH* rnd.nextDouble(), CANVAS_HEIGHT* rnd.nextDouble()));
                	break;
                }
                drawer1.draw(cr1);
            }    
        });
        
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                switch(rnd.nextInt(2)) {
                case 0:
                    cr2.addCurve(new Line(CANVAS_WIDTH * rnd.nextDouble(), CANVAS_HEIGHT* rnd.nextDouble(),
                            CANVAS_WIDTH* rnd.nextDouble(), CANVAS_HEIGHT* rnd.nextDouble()));
                	break;
                case 1:
                    cr2.addCurve(new Bezier(CANVAS_WIDTH * rnd.nextDouble(), CANVAS_HEIGHT* rnd.nextDouble(),
                            CANVAS_WIDTH* rnd.nextDouble(), CANVAS_HEIGHT* rnd.nextDouble(), CANVAS_WIDTH * rnd.nextDouble(),
                            CANVAS_HEIGHT* rnd.nextDouble(), CANVAS_WIDTH* rnd.nextDouble(), CANVAS_HEIGHT* rnd.nextDouble()));
                	break;
                }
                drawer2.draw(cr2);
            }    
        });

        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                drawerSvg1.openFile(FILE1);
                drawerSvg1.draw(cr1);
                drawerSvg1.closeFile();
            }
        });
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                drawerSvg2.openFile(FILE2);
                drawerSvg2.draw(cr2);
                drawerSvg2.closeFile();
            }
        });

        Bezier bez = new Bezier(new Point(100, 100), new Point(190, 360), new Point(120, 250), new Point(125, 250));
        Line line = new Line(30, 350, 120, 100);
        Line line2 = new Line(50, 90, 50, 200);


        drawer2.draw(line);
        //1
        Fragment fr1 = new Fragment(bez, 0.5, 1);
        drawer1.draw(fr1);
        //2
        MoveTo moveFrag = new MoveTo(fr1, 40, 40);
        drawer1.draw(moveFrag);
        //3
        Fragment fr2 = new Fragment(line, 0.3, 0.7);
        MoveTo moveFrag2 = new MoveTo(fr2, fr1.getPoint(1));

        drawer2.draw(fr1);
        drawer2.draw(moveFrag2);

        /*Chain chain = new Chain(bez, line);
        Chain chain2 = new Chain(chain, line2);
        VisualCurve cur = new VisualCurve(chain2);

        cur.Draw(drawer1);*/

        //line.DrawPoint(drawer1, line.getParam(line.getLength(0.5)));
        //b1.DrawPoint(drawer2, line.getParam(line.getLength(0.5)));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
