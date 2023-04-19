import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Line;
import edu.macalester.graphics.Path;
import edu.macalester.graphics.events.Key;
import edu.macalester.graphics.events.KeyboardEvent;
import edu.macalester.graphics.events.MouseButtonEvent;

import java.awt.Color;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

public class Mine implements Background{

    private RockManager rocks;
    private Set<Gem> gemSet;

    private static Color color;
    private static GraphicsGroup mineGroup;
    private static GraphicsGroup fullGroup;
    private static double CANVAS_WIDTH = 800; 
    private static double CANVAS_HEIGHT = 600;

    // private static Line leftBound = new Line(-800,0,-800,600);
    // private static Line rightBound = new Line(1600,0,1600,600);

    private static Line leftBound ;
    private static Line rightBound ;
    private static double groupPosition;

    private Minecart minecart;


    public Mine(Color color) {
        Mine.color = color;
        mineGroup = new GraphicsGroup(0,0);
        fullGroup = new GraphicsGroup(0, 0);
    }

    /**
     * Generates visual elements of mine, including cave wall image and rocks.
     */
    public void generateMine() {
        Image icon = new Image(-800, 0);
        icon.setImagePath("BlueCave.png");
        mineGroup.add(icon);

        leftBound = new Line(-800,0,-800,600);
        rightBound = new Line(1600,0,1600,600);
        mineGroup.add(leftBound);
        mineGroup.add(rightBound);
        groupPosition = 400;

        rocks = new RockManager(30, CANVAS_HEIGHT, CANVAS_WIDTH);
        rocks.drawRocks(mineGroup);

        fullGroup.add(mineGroup);
        fullGroup.add(minecart.drawMinecart());
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
            mineGroup.moveBy(5, 0); // change delta x depending on how fast cart should move
            groupPosition -= 5;
        }
        if(Minecart.getMinecart().testHit(event.getPosition().getX(), event.getPosition().getY())
        && Minecart.getMinecart().getElementAt(event.getPosition()).equals(Minecart.getRightButton())){
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
    public void addGemSet(String gemType){
        gemSet = GemList.getGemSet(gemType);
    }

    public GraphicsGroup getGraphicsGroup() {
        return fullGroup;
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
