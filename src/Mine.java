import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Path;

import java.awt.Color;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

public class Mine implements Background{

    private RockManager rocks;
    private Set<Gem> gemSet;

    private static Color color;
    private static GraphicsGroup mineGroup;
    private static double CANVAS_WIDTH = 800; // change this to pull from canvas settings in game class
    private static double CANVAS_HEIGHT = 600; // change this to pull from canvas settings in game class


    public Mine(Color color) {
        Mine.color = color;
        mineGroup = new GraphicsGroup(0,0);
    }

    /**
     * Generates visual elements of mine, including cave wall image and rocks.
     */
    public void generateMine() {
        Image icon = new Image(0, 0);
        icon.setImagePath("BlueCave.png");
        mineGroup.add(icon);

        rocks = new RockManager(10, CANVAS_HEIGHT, CANVAS_WIDTH);
        rocks.drawRocks(mineGroup);
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
