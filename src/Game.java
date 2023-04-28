import java.awt.Color;

import edu.macalester.graphics.*;
import edu.macalester.graphics.events.Key;

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
    }

    /**
     * Generates map graphics and components on canvas.
     */
    private static void activateMap() {
        canvas.setBackground(MineMap.MAP_BACKGROUND);
        backgrounds.drawBackround("Map");

        canvas.onClick(event -> {
            if (startMap.getDoors().keySet().contains(canvas.getElementAt(event.getPosition()))){
                activateMine(startMap.getDoors().get(canvas.getElementAt(event.getPosition())));
            }
            if(startMap.checkCollectionButton(event)){
                player.printGemSet();
            }
        });
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

            canvas.onMouseMove(event -> {
                mine.moveAxe(event);
            });

            canvas.onClick(event -> {
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
            });
            
            canvas.onMouseDown(event -> {
                if(!NewGemPanel.isDrawn()){
                    if(mine.testRightButton(event)){
                        scrollingRight = true;
                    }
                    if(mine.testLeftButton(event)){
                        scrollingLeft = true;
                    }
                }
            });
            

            canvas.onMouseUp(event -> {
                scrollingLeft = false;
                scrollingRight = false;
            });

            canvas.animate(() -> {
                if(scrollingLeft){
                    mine.scrollLeft();
                }
                else if(scrollingRight){
                    mine.scrollRight();
                }
            });

            canvas.onKeyDown(event -> {
                if(event.getKey() == Key.RETURN_OR_ENTER ) {
                    newGem.drawCrownPanel();
                    newGem.setUpCrownPanel(canvas);
                }
            }  );
    }
}
