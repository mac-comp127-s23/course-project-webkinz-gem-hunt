import edu.macalester.graphics.*;
import edu.macalester.graphics.events.MouseButtonEvent;

import java.awt.Color;
import java.util.*;

public class MineMap implements Background {

    private GraphicsGroup mapGroup;
    Map<Rectangle, Color> mineDoors;
    Map<Color, String> names;

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
        button.drawCollectionButton(mapGroup);
        createNameMap();
        drawMap();
    }

    public GraphicsGroup getGraphicsGroup(){
        return mapGroup;
    }

    public boolean checkCollectionButton(MouseButtonEvent event){
        return (button.getButton().testHit(event.getPosition().getX(), event.getPosition().getY()));
    }

    /**
     * Adds all graphical objects on map to the map's GraphicsGroup.
     * Includes mountains, clusters, mine doors, and text.
     */
    public void drawMap() {
        addMountains();
        addMines();
        addLabel();
        addAxes();

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
     * Generates title text at top of map
     */
    private void addLabel() {
        GraphicsText labelText = new GraphicsText("Map to the Secret Gem Mines");
        labelText.setFillColor(Color.BLACK);
        labelText.setFont(FontStyle.BOLD, 20);
        labelText.setCenter(400, 40);
        mapGroup.add(labelText);

        Rectangle labelBox = new Rectangle(
            labelText.getCenter().getX() - 0.5*labelText.getWidth() - 10, 
            labelText.getCenter().getY() - 0.5*labelText.getHeight() - 10, 
            labelText.getWidth() + 20, 
            labelText.getHeight() + 20);
        labelBox.setStrokeColor(MAP_LINE_COLOR);  
        labelBox.setStrokeWidth(2);
        mapGroup.add(labelBox);  
        mapGroup.add(addParchmentLines(labelBox, 20));

        GraphicsText descripText = new GraphicsText("Choose which mine to search.");
        descripText.setFillColor(Color.BLACK);
        descripText.setFont(FontStyle.BOLD, 14);
        descripText.setCenter(
            labelText.getCenter().getX(), 
            labelText.getCenter().getY() + labelText.getHeight() + 15);
        mapGroup.add(descripText);

    }

    /**
     * Creates parchment fold lines for a rectangle
     * 
     * @param rect Rectangle to add parchment folds to
     * @param size Size of folds (text padding is a good parameter to use)
     * @return GraphicsGroup containing parchment fold lines
     */
    private GraphicsGroup addParchmentLines(Rectangle rect, double size) {
        GraphicsGroup parchLines = new GraphicsGroup();

        Path leftLine = new Path(
            new Point(rect.getPosition().getX(), rect.getPosition().getY() + rect.getHeight()), 
            new Point(rect.getPosition().getX() + size, rect.getPosition().getY() + rect.getHeight() + 0.5*size), 
            new Point(rect.getPosition().getX() + size, rect.getPosition().getY() + rect.getHeight()));
        leftLine.setStrokeColor(MAP_LINE_COLOR);  
        leftLine.setStrokeWidth(2);
        parchLines.add(leftLine); 
        
        Path rightLine = new Path(
            new Point(rect.getPosition().getX() + rect.getWidth(), rect.getPosition().getY() + rect.getHeight()), 
            new Point(rect.getPosition().getX() + rect.getWidth() - size, rect.getPosition().getY() + rect.getHeight() + 0.5*size), 
            new Point(rect.getPosition().getX() + rect.getWidth() - size, rect.getPosition().getY() + rect.getHeight()));
        rightLine.setStrokeColor(MAP_LINE_COLOR);  
        rightLine.setStrokeWidth(2);
        parchLines.add(rightLine); 

        return parchLines;
    }

    /**
     * Generates decorative axes on either side of the title text on map
     */
    private void addAxes() {
        GraphicsGroup leftAxe = new GraphicsGroup();

        Arc leftBlade = new Arc(-40,-50, 50, 50, 160, -80); 
        leftBlade.setStrokeColor(MAP_LINE_COLOR);
        leftBlade.setStrokeWidth(10);
        leftAxe.add(leftBlade);

        Line leftHandle = new Line(0, 0, -30, -50); 
        leftHandle.setStrokeColor(Color.BLACK);
        leftHandle.setStrokeWidth(7);
        leftAxe.add(leftHandle);

        leftAxe.setCenter(220, 55);
        mapGroup.add(leftAxe);

        GraphicsGroup rightAxe = new GraphicsGroup();

        Arc rightBlade = new Arc(-10,-50, 50, 50, 20, 80); 
        rightBlade.setStrokeColor(MAP_LINE_COLOR);
        rightBlade.setStrokeWidth(10);
        rightAxe.add(rightBlade);

        Line rightHandle = new Line(0, 0, 30, -50); 
        rightHandle.setStrokeColor(Color.BLACK);
        rightHandle.setStrokeWidth(7);
        rightAxe.add(rightHandle);

        rightAxe.setCenter(580, 55);
        mapGroup.add(rightAxe);
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
     * Creates HashMap between Mine colors and string containing Mine name
     */
    private void createNameMap() {
        names = new HashMap<>();

        names.put(Color.BLUE, "Howling Horse Mine");
        names.put(Color.RED, "Muzzle Mouth Mine");
        names.put(Color.GREEN, "Flea Floater Mine");
        names.put(Color.YELLOW, "Barking Mad Mine");
        names.put(Color.WHITE, "Buried Bones Mine");
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
        
        GraphicsText nameText = new GraphicsText(names.get(mineColor));
        nameText.setFillColor(Color.BLACK);
        nameText.setFont(FontStyle.BOLD, 11);
        nameText.setCenter(x+30, y+80);
        door.add(nameText);

        Rectangle textLabel = new Rectangle(
            nameText.getCenter().getX() - 0.5*nameText.getWidth() - 5, 
            y+70, nameText.getWidth() + 10, 20);
        textLabel.setStrokeColor(MAP_LINE_COLOR);  
        textLabel.setStrokeWidth(2);
        door.add(addParchmentLines(textLabel, 10));
        door.add(textLabel);  

        return door;
    }

    
}
