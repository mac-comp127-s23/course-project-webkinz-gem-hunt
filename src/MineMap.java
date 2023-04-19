import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Line;
import edu.macalester.graphics.Rectangle;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class MineMap {

    private static GraphicsGroup mapGroup;
    private static List<GraphicsGroup> doors;
    private static double CANVAS_WIDTH = 800; 
    private static double CANVAS_HEIGHT = 600;
    private static final Color MAP_BACKGROUND = new Color(242, 223, 169);
    private static final Color CAVE_BACKGROUND_BLUE = new Color(9, 1, 64);
    private static final Color CAVE_BACKGROUND_GREEN = new Color(10, 40, 3);
    private static final Color CAVE_BACKGROUND_RED = new Color(75, 10, 5);
    private static final Color CAVE_BACKGROUND_YELLOW = new Color(120, 105, 15);
    private static final Color CAVE_BACKGROUND_WHITE = Color.darkGray;
    private static final Color MAP_LINE_COLOR = new Color(185, 168, 116);


    public MineMap() {
        mapGroup = new GraphicsGroup(0,0);
    }

    public static void main(String[] args) {
        MineMap map = new MineMap();
        CanvasWindow canvas = new CanvasWindow("Mine", 800, 600);
        canvas.setBackground(MAP_BACKGROUND);
    
        map.drawMap();

        canvas.add(mapGroup);
        canvas.draw();
    }

    private void drawMap() {
        addMountains();
        addMines();

        mapGroup.add(addCluster(30,300));
        mapGroup.add(addCluster(425,450));
        mapGroup.add(addCluster(325,200));
        mapGroup.add(addCluster(700,250));
        mapGroup.add(addCluster(100,510));
    }

    private void addMountains() {
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
            l.setStrokeColor(MAP_LINE_COLOR);
            l.setStrokeWidth(5);
            mapGroup.add(l);
        }

    }

    private GraphicsGroup addCluster(double x, double y) {
        GraphicsGroup cluster = new GraphicsGroup(x,y);
        List<Line> clusterList = new ArrayList<>();

        Line lineA = new Line(0,12, 19,0);
        clusterList.add(lineA);
        Line lineB = new Line(19,0, 38,12);
        clusterList.add(lineB);
        Line lineC = new Line(47,12, 66,0);
        clusterList.add(lineC);
        Line lineD = new Line(66,0, 85,12);
        clusterList.add(lineD);
        Line lineE = new Line(30,0, 42.5,-7);
        clusterList.add(lineE);
        Line lineF = new Line(42.5,-7, 55,0);
        clusterList.add(lineF);

        for (Line l: clusterList){
            l.setStrokeColor(MAP_LINE_COLOR);
            l.setStrokeWidth(3);
            cluster.add(l);
        }

        return cluster;

    }

    private void addMines() {
        doors = new ArrayList<>();

        doors.add(mineDoor(CAVE_BACKGROUND_BLUE, 80, 120));
        doors.add(mineDoor(CAVE_BACKGROUND_RED, 570, 140));
        doors.add(mineDoor(CAVE_BACKGROUND_GREEN, 280, 250));
        doors.add(mineDoor(CAVE_BACKGROUND_YELLOW, 270, 480));
        doors.add(mineDoor(CAVE_BACKGROUND_WHITE, 660, 380));

        for (GraphicsGroup d : doors){
            mapGroup.add(d);
        }

    }

    private List<GraphicsGroup> getDoors() {
        return doors;
    }

    private GraphicsGroup mineDoor(Color mineColor, double x, double y) {
        GraphicsGroup door = new GraphicsGroup(x, y);

        Rectangle inside = new Rectangle(0,0, 60, 60);
        inside.setFillColor(mineColor);
        door.add(inside);

        Rectangle left = new Rectangle(-5, 0, 5, 60);
        left.setFillColor(MAP_BACKGROUND);
        left.setStrokeColor(MAP_LINE_COLOR);
        left.setStrokeWidth(2);
        door.add(left);

        Rectangle right = new Rectangle(60, 0, 5, 60);
        right.setFillColor(MAP_BACKGROUND);
        right.setStrokeColor(MAP_LINE_COLOR);
        right.setStrokeWidth(2);
        door.add(right);
        
        Rectangle top = new Rectangle(-7, -5, 74, 7);
        top.setFillColor(MAP_BACKGROUND);
        top.setStrokeColor(MAP_LINE_COLOR);
        top.setStrokeWidth(2);
        door.add(top);

        return door;
    }

    
}
