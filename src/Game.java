import java.awt.Color;

import edu.macalester.graphics.*;
import edu.macalester.graphics.events.MouseButtonEvent;
import edu.macalester.graphics.events.MouseMotionEvent;

public class Game {
    private static MineMap startMap;
    private static Mine mine;
    private static CanvasWindow canvas;
    private static BackgroundManager backgrounds;
    private static Boolean scrollingLeft = false;
    private static Boolean scrollingRight = false;
    private static GemPanel gemPopUp;
    private static CrownPanel crownPopUp;
    private static SlagPanel slagPopUp;
    private static Player player;
    private static boolean shownCrown = false;
    private static CollectionPopUp collection;

    public static void main(String[] args) {
        canvas = new CanvasWindow("Gem Hunt", 800, 600);
        mine = new Mine();
        startMap = new MineMap();
        backgrounds = new BackgroundManager("Mine", mine, canvas);
        backgrounds.addBackground("Map", startMap);
        gemPopUp = new GemPanel();
        slagPopUp = new SlagPanel();
        crownPopUp = new CrownPanel();
        player = new Player("Alex");
        collection = new CollectionPopUp(player);
        GemList.setList();
        activateMap();

        canvas.onClick(event -> {
            if(backgrounds.getCurrentBackgroundName().equals("Mine")){
                System.out.println("im clicking");
                mineClickables(event);
            }
            if(backgrounds.getCurrentBackgroundName().equals("Map")){
                mapClickables(event);
            }
        });

        canvas.onMouseDown(event -> {
            if(backgrounds.getCurrentBackgroundName().equals("Mine")){
                mineOnMouseDownEvents(event);
            }
        });

        canvas.onMouseUp(event -> {
            if(backgrounds.getCurrentBackgroundName().equals("Mine")){
                mineOnMouseUpEvents(event);
            }
        });

        canvas.animate(() -> {
            if(backgrounds.getCurrentBackgroundName().equals("Mine")){
                mineAnimateEvents();
            }
        });

        canvas.onMouseMove(event -> {
            if(backgrounds.getCurrentBackgroundName().equals("Mine")){
                mineMouseMovementEvents(event);
            }
        });
    }

    /**
     * Generates map graphics and components on canvas.
     */
    private static void activateMap() {
        canvas.setBackground(MineMap.MAP_BACKGROUND);
        backgrounds.drawBackround("Map");
    }

    /**
     * Generates mine graphics and components, and activates mine gameplay by enabling
     * lambdas and rock dissolving methods.
     * 
     * @param color Color of mine player is in
     */
    private static void activateMine(Color color) {
        mine.generateMine(color);
        backgrounds.drawBackround("Mine");
        mine.addGemSet(color);
    }

    /**
     * Tests all clickable objects in the mine gamestate, including the back button, rocks, 
     * and exit buttons for popup panels.
     * 
     * @param event
     */
    private static void mineClickables(MouseButtonEvent event){

        Rock schrodingersRock = mine.testRockHit(event);
        if (schrodingersRock != null  && !Panel.isDrawn()){
            if (Helpers.randomInt(0, 1) == 0){ // 50% of the time, generate slag
                mine.rockDissolve(canvas, schrodingersRock);
                slagPopUp.draw(null);
                slagPopUp.setUp(canvas, null);
            }

            else {
                mine.rockDissolve(canvas, schrodingersRock);
                Gem receivedGem = mine.generateGem();
                player.newGemFound(receivedGem);
                gemPopUp.draw(receivedGem);
                gemPopUp.setUp(canvas, receivedGem);
            }
        }
        slagPopUp.test(event, canvas);
        gemPopUp.test(event, canvas);
        crownPopUp.test(event, canvas);

        if(mine.testBackButton(event, canvas) && !Panel.isDrawn()){
            if(player.checkCompletion() && !shownCrown){
                crownPopUp.draw(null);
                crownPopUp.setUp(canvas, null);
                shownCrown = true;
            }
            else{
                activateMap();
            }
        }
    }

    /**
     * Tests all clickable objects in the map gamestate, 
     * including different mines and the collection button
     * 
     * @param event
     */
    private static void mapClickables(MouseButtonEvent event){
        if(startMap.checkCollectionButton(event)){
            collection.draw(null);
            collection.setUp(canvas, null);
            player.printGemSet();
        }

        collection.testWhiteButton(event, canvas);
        collection.testGreenButton(event, canvas);
        collection.testYellowButton(event, canvas);
        collection.testBlueButton(event, canvas);
        collection.testRedButton(event, canvas);
        collection.test(event, canvas);

        if (startMap.getDoors().keySet().contains(canvas.getElementAt(event.getPosition()))){
            activateMine(startMap.getDoors().get(canvas.getElementAt(event.getPosition())));
        }

    }

    /**
     * Tests for any on mouse down actions in the mine gamestate, currently 
     * only used for the minecart buttons.
     * 
     * @param event
     */
    private static void mineOnMouseDownEvents(MouseButtonEvent event){
        if(!Panel.isDrawn()){
            if(mine.testRightButton(event)){
                scrollingRight = true;
            }
            if(mine.testLeftButton(event)){
                scrollingLeft = true;
            }
        }
    }

    /**
     * Tests for any on mouse Up actions in the mine gamestate, currently 
     * only used for the minecart buttons.
     * 
     * @param event
     */
    private static void mineOnMouseUpEvents(MouseButtonEvent event){
        scrollingLeft = false;
        scrollingRight = false;
    }

    /**
     * Runs any animate events while game is in the mine state, currently only
     * used for sidescrolling.
     * 
     * @param event
     */
    private static void mineAnimateEvents(){
        if(scrollingLeft){
            mine.scrollLeft();
        }
        else if(scrollingRight){
            mine.scrollRight();
        }
    }

    /**
     * Runs any on mouse move events while game is in the mine state, currently only
     * used for pickaxe movement.
     * 
     * @param event
     */
    private static void mineMouseMovementEvents(MouseMotionEvent event){
        mine.moveAxe(event);
    }

}
