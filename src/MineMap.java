import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Line;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class MineMap {

    private static Color color;
    private static GraphicsGroup mapGroup;
    private static double CANVAS_WIDTH = 800; 
    private static double CANVAS_HEIGHT = 600;
    private static final Color MAP_BACKGROUND = new Color(242, 223, 169);


    public MineMap() {
        mapGroup = new GraphicsGroup(0,0);
    }

    // running main method will produce and save a background image for the mine in the uncommented color scheme
    public static void main(String[] args) {
        MineMap map = new MineMap();
        CanvasWindow canvas = new CanvasWindow("Mine", 800, 600);
        canvas.setBackground(MAP_BACKGROUND);

        map.addMountains();
        canvas.add(mapGroup);
        canvas.draw();
        // canvas.screenShot("WhiteCave.png");
    }

    private static void addMountains() {
        List<Line> lineList = new ArrayList<>();

        Line line1 = new Line(-50, 200, 110, 75);
        lineList.add(line1);
        Line line2 = new Line(110, 75, 270, 200);
        lineList.add(line2);
        Line line3 = new Line(180, 500, 300, 450);
        lineList.add(line3);
        Line line4 = new Line(300, 450, 420, 500);
        lineList.add(line4);
        Line line5 = new Line(375, 260, 600, 100);
        lineList.add(line5);
        Line line6 = new Line(600, 100, 875, 260);
        lineList.add(line6);

        for (Line l: lineList){
            l.setStrokeColor(new Color(185, 168, 116));
            l.setStrokeWidth(5);
            mapGroup.add(l);
        }

    }

    
}
