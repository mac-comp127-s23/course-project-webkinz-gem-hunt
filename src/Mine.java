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

    private static double groupPosition;
    private static Button backButton;
    private static Minecart minecart;
    private static Pickaxe axe;

    public Mine() {
        mineGroup = new GraphicsGroup(0,0);
        mineUI = new GraphicsGroup(0,0);
        fullMine = new GraphicsGroup(0,0);
        backButton = new Button();
        minecart = new Minecart();
        axe = new Pickaxe();
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
    public void generateMine(Color color) {
        mineGroup.removeAll();
        mineUI.removeAll();
        fullMine.removeAll();
        this.color = color;
        Image icon = new Image(-800, 0);
        icon.setImagePath(images.get(color));
        mineGroup.add(icon);
        groupPosition = 400;

        rocks = new RockManager(30, color, CANVAS_HEIGHT, CANVAS_WIDTH);
        rocks.drawRocks(mineGroup);

        minecart.drawMinecart(mineUI);
        backButton.drawBackButton(mineUI);
        axe.drawAxe(mineUI);
        fullMine.add(mineGroup);
        fullMine.add(mineUI);
    }

    public static GraphicsGroup getMineGroup(){
        return mineGroup;
    }

    public boolean testLeftButton(MouseButtonEvent event){
        return minecart.getMinecart().testHit(event.getPosition().getX(), event.getPosition().getY())
        && minecart.getMinecart().getElementAt(event.getPosition()).equals(minecart.getLeftButton());
    }

    public boolean testRightButton(MouseButtonEvent event){
        return minecart.getMinecart().testHit(event.getPosition().getX(), event.getPosition().getY())
        && minecart.getMinecart().getElementAt(event.getPosition()).equals(minecart.getRightButton());
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
        List<Gem> weightList = new ArrayList<>();

        for (Gem g : gemSet){
            int weight = (int) (g.getRarity() * 1000);

            for (int i = 0; i < weight; i++){
                weightList.add(g);
            }
        }

        return weightList.get(Helpers.randomInt(0, weightList.size() - 1));

    }

    public boolean testBackButton(MouseButtonEvent event, CanvasWindow canvas){
        return (backButton.getButton().testHit(event.getPosition().getX(), event.getPosition().getY()));
    }

    public void moveAxe(MouseMotionEvent event){
        axe.getAxe().setCenter(event.getPosition());
    }

    /**
     * Checks what rock object the pickaxe has intersected with.
     *
     * @param canvas CanvasWindow to locate an object on.
     * @param currentMine Mine whose objects are tested for intersection.
     * 
     * @return null if no rock is found.
     * 
     */
    public Rock testRockHit(CanvasWindow canvas, Mine currentMine) {
        Point p = axe.getAxe().getCenter();
        Point testP = new Point(p.getX() - 5, p.getY()); // move the test point slightly off center so the pickaxe isn't detected
        GraphicsObject rock = canvas.getElementAt(testP);
        if(rock instanceof Path && currentMine.hasRock(rock)){
            return currentMine.getRock((Path) rock);
        }

        return null;
    }

    /**
     * Animates axe motion and rock disintegration from intersection.
     * 
     * @param canvas Canvas where dissolving rock will be drawn
     * @param rock Rock being hit
     */
    public void rockDissolve(CanvasWindow canvas, Rock rock) {
        Point rockPosition = rock.getPosition();
        GraphicsObject twoThirds = rock.twoThirdsRock(rockPosition.getX(), rockPosition.getY());
        GraphicsObject oneThird = rock.oneThirdRock(rockPosition.getX(), rockPosition.getY());

        // hit #1
        axe.getAxe().rotateBy(90);
        Mine.getMineGroup().remove(rock.getRockShape());
        Mine.getMineGroup().add(twoThirds);
        canvas.draw();

        canvas.pause(150);
        axe.getAxe().rotateBy(-90);
        canvas.draw();
        canvas.pause(150);

        // hit #2
        axe.getAxe().rotateBy(90);
        Mine.getMineGroup().remove(twoThirds);
        Mine.getMineGroup().add(oneThird);
        canvas.draw();

        canvas.pause(150);
        axe.getAxe().rotateBy(-90);
        canvas.draw();
        canvas.pause(150);

        // hit #3
        axe.getAxe().rotateBy(90);
        Mine.getMineGroup().remove(oneThird);
        canvas.draw();

        canvas.pause(150);
        axe.getAxe().rotateBy(-90);
        canvas.draw();
        canvas.pause(150);

    }


}
