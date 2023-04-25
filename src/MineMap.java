import edu.macalester.graphics.*;
import edu.macalester.graphics.events.MouseButtonEvent;

import java.awt.Color;
import java.util.*;

public class MineMap implements Background {

    private GraphicsGroup mapGroup;
    Map<Rectangle, Color> mineDoors;

    public static final Color MAP_BACKGROUND = new Color(242, 223, 169);
    private static final Color CAVE_BACKGROUND_BLUE = new Color(9, 1, 64);
    private static final Color CAVE_BACKGROUND_GREEN = new Color(10, 40, 3);
    private static final Color CAVE_BACKGROUND_RED = new Color(75, 10, 5);
    private static final Color CAVE_BACKGROUND_YELLOW = new Color(120, 105, 15);
    private static final Color CAVE_BACKGROUND_WHITE = Color.darkGray;
    private static final Color MAP_LINE_COLOR = new Color(185, 168, 116);
    private static CollectionButton button;


    public MineMap() {
        mapGroup = new GraphicsGroup(0,0);
        button = new CollectionButton();
        button.drawBackButton(mapGroup);
        drawMap();
    }

    public GraphicsGroup getGraphicsGroup(){
        return mapGroup;
    }

    public boolean checkCollectionButton(MouseButtonEvent event){
        return (button.getButton().testHit(event.getPosition().getX(), event.getPosition().getY()));
    }

    // for testing
    public static void main(String[] args) {
        MineMap map = new MineMap();
        CanvasWindow canvas = new CanvasWindow("Mine", 800, 600);
        canvas.setBackground(MAP_BACKGROUND);
    
        //canvas.add(map.drawMap());
        canvas.draw();
    }

    public void drawMap() {
        addMountains();
        addMines();

        mapGroup.add(addCluster(30,300));
        mapGroup.add(addCluster(425,450));
        mapGroup.add(addCluster(325,200));
        mapGroup.add(addCluster(700,250));
        mapGroup.add(addCluster(100,510));

    }

    /**
     * Adds graphical representation of map's mountains to GraphicsGroup of map objects.
     */
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

    /**
     * Generates a GraphicsGroup of Lines which draw a small mountain cluster of fixed size.
     * 
     * @param x horizontal coordinate of upper left corner of cluster's bounding box
     * @param y vertical coordinate of upper left corner of cluster's bounding box
     * @return GraphicsGroup of Lines
     */
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

    /**
     * Adds graphical representation of mine doors to GraphicsGroup of map objects.
     */
    private void addMines() {
        mineDoors = new HashMap<>();

        mapGroup.add(mineDoor(Color.BLUE, CAVE_BACKGROUND_BLUE, 80, 120));
        mapGroup.add(mineDoor(Color.RED, CAVE_BACKGROUND_RED, 570, 140));
        mapGroup.add(mineDoor(Color.GREEN, CAVE_BACKGROUND_GREEN, 280, 250));
        mapGroup.add(mineDoor(Color.YELLOW, CAVE_BACKGROUND_YELLOW, 270, 480));
        mapGroup.add(mineDoor(Color.WHITE, CAVE_BACKGROUND_WHITE, 660, 380));
    }

    /**
     * @return Map of mine doors on map and their colors
     */
    public Map<Rectangle, Color> getDoors() {
        return mineDoors;
    }

    /**
     * Generates graphical representation of mine doors of fixed size
     * 
     * @param mineColor Color of linked Mine
     * @param x horizontal coordinate of upper left corner of door's bounding box
     * @param y vertical coordinate of upper left corner of door's bounding box
     * @return GraphicsGroup with door frame and colored interior
     */
    private GraphicsGroup mineDoor(Color mineColor, Color backColor, double x, double y) {
        GraphicsGroup door = new GraphicsGroup(0, 0);

        Rectangle inside = new Rectangle(x,y, 60, 60);
        inside.setFillColor(backColor);
        door.add(inside);
        mineDoors.put(inside, mineColor);

        Rectangle left = new Rectangle(x-5, y, 5, 60);
        left.setFillColor(MAP_BACKGROUND);
        left.setStrokeColor(MAP_LINE_COLOR);
        left.setStrokeWidth(2);
        door.add(left);

        Rectangle right = new Rectangle(x+60, y, 5, 60);
        right.setFillColor(MAP_BACKGROUND);
        right.setStrokeColor(MAP_LINE_COLOR);
        right.setStrokeWidth(2);
        door.add(right);
        
        Rectangle top = new Rectangle(x-7, y-5, 74, 7);
        top.setFillColor(MAP_BACKGROUND);
        top.setStrokeColor(MAP_LINE_COLOR);
        top.setStrokeWidth(2);
        door.add(top);

        return door;
    }

    
}
