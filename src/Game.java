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


    public static void main(String[] args) {
        canvas = new CanvasWindow("Gem Hunt", 800, 600);
        activateMap();

        // to skip map and do testing within a mine, uncomment this:
        // activateMine(Color.BLUE);
    }

    /**
     * Generates map graphics and components on canvas.
     */
    private static void activateMap() {
        startMap = new MineMap();
        canvas.setBackground(MineMap.MAP_BACKGROUND);
        canvas.add(startMap.drawMap());
        canvas.draw();

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
        canvas.removeAll();

        mine = new Mine(color);
        backgrounds = new BackgroundManager("Mine", mine, canvas);
        mine.generateMine();
        backgrounds.drawBackround("Mine");
        GemList.setList();
        mine.addGemSet(color);

        axe = new Pickaxe();
        GraphicsObject axeShape = Pickaxe.drawAxe();
            canvas.add(axeShape, 400, 300); // arbitrary starting point
            canvas.draw();

            canvas.add(Minecart.getMinecart());

            canvas.onMouseMove(event -> {
                axeShape.setCenter(event.getPosition());
            });

            canvas.onClick(event -> {
                if (canvas.getElementAt(event.getPosition()) == Button.getButton()){
                    canvas.removeAll();
                    activateMap();
                }

                if (axe.testRockHit(canvas, mine) != null){
                    rockDissolve(canvas, axe.testRockHit(canvas, mine));
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
    
    /**
         * Destroys rock by dissolving its graphics and animating pickaxe. 
         * Generates a gem from the dissolved rock.
         * 
         * @param canvas Canvas containing rock being dissolved
         * @param rock Rock being dissolved
         */
        private static void rockDissolve(CanvasWindow canvas, Rock rock) {
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

            NewGemPanel newGem = new NewGemPanel(rockPosition, mine.generateGem());
            newGem.setUpGemPanel(canvas);

        }
}
