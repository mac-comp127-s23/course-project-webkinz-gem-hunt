import java.awt.Color;

import edu.macalester.graphics.*;
import edu.macalester.graphics.events.Key;
import edu.macalester.graphics.events.MouseButtonEvent;
import edu.macalester.graphics.events.MouseMotionEvent;

public class Game {
    private static MineMap startMap;
    private static Mine mine;
    private static CanvasWindow canvas;
    private static BackgroundManager backgrounds;
    private static Boolean scrollingLeft = false;
    private static Boolean scrollingRight = false;
    private static NewGemPanel newGem;
    private static Player player;

    public static void main(String[] args) {
        canvas = new CanvasWindow("Gem Hunt", 800, 600);
        mine = new Mine();
        startMap = new MineMap();
        backgrounds = new BackgroundManager("Mine", mine, canvas);
        backgrounds.addBackground("Map", startMap);
        newGem = new NewGemPanel();
        GemList.setList();
        activateMap();
        player = new Player("Alex");

        canvas.onClick(event -> {
            if(backgrounds.getCurrentBackgroundName().equals("Mine")){
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

    private static void mineClickables(MouseButtonEvent event){
        if(mine.testBackButton(event, canvas) && !NewGemPanel.isDrawn()){
            activateMap();
        }

        Rock schrodingersRock = mine.testRockHit(canvas, mine);
        if (schrodingersRock != null  && !NewGemPanel.isDrawn()){

            if (Helpers.randomInt(0, 1) == 0){ // 50% of the time, generate slag
                mine.rockDissolve(canvas, schrodingersRock);
                newGem.drawSlagPanel();
                newGem.setUpGemPanel(canvas);
            }

            else {
                mine.rockDissolve(canvas, schrodingersRock);
                Gem receivedGem = mine.generateGem();
                player.newGemFound(receivedGem);
                newGem.drawGemPanel(receivedGem);
                newGem.setUpGemPanel(canvas);
            }
        }
        NewGemPanel.testPanel(event, canvas);
        NewGemPanel.testCrownPanel(event, canvas);
    }

    private static void mapClickables(MouseButtonEvent event){
        if (startMap.getDoors().keySet().contains(canvas.getElementAt(event.getPosition()))){
            activateMine(startMap.getDoors().get(canvas.getElementAt(event.getPosition())));
        }
        if(startMap.checkCollectionButton(event)){
            player.printGemSet();
        }
    }

    private static void mineOnMouseDownEvents(MouseButtonEvent event){
        if(!NewGemPanel.isDrawn()){
            if(mine.testRightButton(event)){
                scrollingRight = true;
            }
            if(mine.testLeftButton(event)){
                scrollingLeft = true;
            }
        }
    }

    private static void mineOnMouseUpEvents(MouseButtonEvent event){
        scrollingLeft = false;
        scrollingRight = false;
    }

    private static void mineAnimateEvents(){
        if(scrollingLeft){
            mine.scrollLeft();
        }
        else if(scrollingRight){
            mine.scrollRight();
        }
    }

    private static void mineMouseMovementEvents(MouseMotionEvent event){
        mine.moveAxe(event);
    }

}
