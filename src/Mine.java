import edu.macalester.graphics.*;
import edu.macalester.graphics.events.*;

import java.awt.Color;
import java.util.*;

public class Mine implements Background{

    private RockManager rocks;
    private Set<Gem> gemSet;
    Map<Color, String> images;
    Map<Color, String> colors;

    private static Color color;
    private static GraphicsGroup mineGroup;
    private static GraphicsGroup mineUI;
    private static GraphicsGroup fullMine;
    private static double CANVAS_WIDTH = 800; 
    private static double CANVAS_HEIGHT = 600;

    private static Line leftBound ;
    private static Line rightBound ;
    private static double groupPosition;

    public Mine(Color color) {
        Mine.color = color;
        mineGroup = new GraphicsGroup(0,0);
        mineUI = new GraphicsGroup(0,0);
        fullMine = new GraphicsGroup(0,0);
        createImageMap();
        createColorMap();
    }

    /**
     * Creates HashMap between Mine colors and their respective background images in res folder.
     */
    public void createImageMap() {
        images = new HashMap<>();

        images.put(Color.BLUE, "BlueCave.png");
        images.put(Color.RED, "RedCave.png");
        images.put(Color.GREEN, "GreenCave.png");
        images.put(Color.YELLOW, "YellowCave.png");
        images.put(Color.WHITE, "WhiteCave.png");
    }

     /**
     * Creates HashMap between Mine colors and string containing color (for use by gem classes)
     */
    public void createColorMap() {
        colors = new HashMap<>();

        colors.put(Color.BLUE, "Blue");
        colors.put(Color.RED, "Red");
        colors.put(Color.GREEN, "Green");
        colors.put(Color.YELLOW, "Yellow");
        colors.put(Color.WHITE, "White");
    }

    /**
     * Generates visual elements of mine, including cave wall image, rocks, and minecart.
     */
    public void generateMine() {
        Image icon = new Image(-800, 0);
        icon.setImagePath(images.get(color));
        mineGroup.add(icon);

        leftBound = new Line(-800,0,-800,600);
        rightBound = new Line(1600,0,1600,600);
        mineGroup.add(leftBound);
        mineGroup.add(rightBound);
        groupPosition = 400;

        rocks = new RockManager(30, color, CANVAS_HEIGHT, CANVAS_WIDTH);
        rocks.drawRocks(mineGroup);

        mineUI.add(Minecart.drawMinecart());
        mineUI.add(Button.drawBackButton());
        fullMine.add(mineGroup);
        fullMine.add(mineUI);
    }

    public static GraphicsGroup getMineGroup(){
        return mineGroup;
    }

    public static double getLeftBound() {
        return leftBound.getX();
    }

    public static double getRightBound() {
        return rightBound.getX();
    }

    public boolean testLeftButton(MouseButtonEvent event){
        return Minecart.getMinecart().testHit(event.getPosition().getX(), event.getPosition().getY())
        && Minecart.getMinecart().getElementAt(event.getPosition()).equals(Minecart.getLeftButton());
    }

    public boolean testRightButton(MouseButtonEvent event){
        return Minecart.getMinecart().testHit(event.getPosition().getX(), event.getPosition().getY())
        && Minecart.getMinecart().getElementAt(event.getPosition()).equals(Minecart.getRightButton());
    }

    public void scrollLeft(){
        if(groupPosition > -400){
            mineGroup.moveBy(5, 0); // change delta x depending on how fast cart should move
            groupPosition -= 5;
        }
    }

    public void scrollRight(){
        if(groupPosition < 1200){
        mineGroup.moveBy(-5, 0); // change delta x depending on how fast cart should move
        groupPosition += 5;
        }
    }

    public static double getGroupPosition()
    {
        return groupPosition;
    }

    /**
     * Adds a set of gems to this mine that all share a gem type.
     * @param gemType
     */
    public void addGemSet(Color color){
        String gemType = colors.get(color);
        gemSet = GemList.getGemSet(gemType);
    }

    public GraphicsGroup getGraphicsGroup() {
        return fullMine;
    }

    /**
     * Checks if the given graphics object is a rock shape.
     * @param Graphics object hit by pickaxe
     * @return  returns true if the graphics object passed in corresponds to a rock managed by this class.
     */
    public boolean hasRock(GraphicsObject rock){
        if(rocks.getRockShapes().contains(rock)){
            return true;
        }
        return false;
    }

    public Rock getRock(Path rockShape){
        return rocks.getRock(rockShape);
    }

    /**
     * Picks a gem from this mine's gem set (Probabilities not implemented yet).
     * @return Gem that the player has gained from breaking a rock.
     */
    public Gem generateGem(){
        List<Gem> gemProbs = new ArrayList<>(gemSet);
        return gemProbs.get(Helpers.randomInt(0, gemProbs.size() - 1));
    }


}
