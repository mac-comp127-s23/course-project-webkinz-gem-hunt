import edu.macalester.graphics.*;
import edu.macalester.graphics.events.*;

import java.awt.Color;
import java.util.*;

public class Mine implements Background{

    private RockManager rocks;
    private Set<Gem> gemSet;
    Map<Color, String> mines;

    private static Color color;
    private static GraphicsGroup mineGroup;
    private static double CANVAS_WIDTH = 800; 
    private static double CANVAS_HEIGHT = 600;

    private static Line leftBound ;
    private static Line rightBound ;
    private static double groupPosition;

    public Mine(Color color) {
        Mine.color = color;
        mineGroup = new GraphicsGroup(0,0);
        createMineMap();
    }

    /**
     * Creates HashMap between Mine colors and their respective background images in res folder.
     */
    public void createMineMap() {
        mines = new HashMap<>();

        mines.put(Color.BLUE, "BlueCave.png");
        mines.put(Color.RED, "RedCave.png");
        mines.put(Color.GREEN, "GreenCave.png");
        mines.put(Color.YELLOW, "YellowCave.png");
        mines.put(Color.WHITE, "WhiteCave.png");
    }

    /**
     * Generates visual elements of mine, including cave wall image, rocks, and minecart.
     */
    public void generateMine() {
        Image icon = new Image(-800, 0);
        icon.setImagePath(mines.get(color));
        mineGroup.add(icon);

        leftBound = new Line(-800,0,-800,600);
        rightBound = new Line(1600,0,1600,600);
        mineGroup.add(leftBound);
        mineGroup.add(rightBound);
        groupPosition = 400;

        rocks = new RockManager(30, color, CANVAS_HEIGHT, CANVAS_WIDTH);
        rocks.drawRocks(mineGroup);

        Minecart.drawMinecart();
        mineGroup.add(Button.drawBackButton());
    }

    public static double getLeftBound() {
        return leftBound.getX();
    }

    public static double getRightBound() {
        return rightBound.getX();
    }

    // public void moveGroup(KeyboardEvent event, CanvasWindow canvas){
    //     if(event.getKey() == Key.LEFT_ARROW && groupPosition >= -350){
    //         this.getGraphicsGroup().moveBy(5, 0); // change delta x depending on how fast cart should move
    //         groupPosition -= 5;
    //     }
    //     if(event.getKey() == Key.RIGHT_ARROW && groupPosition <= 1150) {
    //         this.getGraphicsGroup().moveBy(-5, 0); // change delta x depending on how fast cart should move
    //         groupPosition += 5;
    //     }
    // }

    public void moveGroup(MouseButtonEvent event, CanvasWindow canvas){
        if(Minecart.getMinecart().testHit(event.getPosition().getX(), event.getPosition().getY())
        && Minecart.getMinecart().getElementAt(event.getPosition()).equals(Minecart.getLeftButton())){
            mineGroup.moveBy(50, 0); // change delta x depending on how fast cart should move
            Minecart.getMinecart().moveBy(-50, 0);
            groupPosition -= 5;
        }
        if(Minecart.getMinecart().testHit(event.getPosition().getX(), event.getPosition().getY())
        && Minecart.getMinecart().getElementAt(event.getPosition()).equals(Minecart.getRightButton())){
            mineGroup.moveBy(-50, 0); // change delta x depending on how fast cart should move
            Minecart.getMinecart().moveBy(50, 0);
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
    public void addGemSet(String gemType){
        gemSet = GemList.getGemSet(gemType);
    }

    public GraphicsGroup getGraphicsGroup() {
        return mineGroup;
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
