import java.awt.Color;

import edu.macalester.graphics.*;
import edu.macalester.graphics.events.MouseButtonEvent;

public class Game {
    private static MineMap startMap;
    private static Mine mine;
    private static CanvasWindow canvas;
    private static Pickaxe axe;
    private static BackgroundManager backgrounds;
    private static Boolean scrollingLeft = false;
    private static Boolean scrollingRight = false;
    private static NewGemPanel newGem;


    public static void main(String[] args) {
        canvas = new CanvasWindow("Gem Hunt", 800, 600);
        mine = new Mine();
        startMap = new MineMap();
        backgrounds = new BackgroundManager("Mine", mine, canvas);
        backgrounds.addBackground("Map", startMap);
        newGem = new NewGemPanel();
        GemList.setList();
        activateMap();

        // to skip map and do testing within a mine, uncomment this:
        // activateMine(Color.BLUE);
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
    
                if(mine.testBackButton(event, canvas)){
                    activateMap();
                }

                Rock schrodingersRock = mine.testRockHit(canvas, mine);
                if (schrodingersRock != null){
                    mine.rockDissolve(canvas, schrodingersRock);
                    newGem.drawGemPanel(mine.generateGem());
                    newGem.setUpGemPanel(canvas);
                }
                NewGemPanel.testPanel(event, canvas);
                //mine.moveGroup(event, canvas);
            });
            
            canvas.onMouseDown(event -> {
                if(mine.testRightButton(event)){
                    scrollingRight = true;
                }
                if(mine.testLeftButton(event)){
                    scrollingLeft = true;
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

            // // side scrolling lambda, add button presses!
            // canvas.onKeyDown( event -> {
            //     mine.moveGroup(event, canvas);
            // });
    }
}
