import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Point;
import edu.macalester.graphics.events.Key;

public class Game {
    private static Mine mine;
    private static Pickaxe axe;
    private static BackgroundManager backgrounds;
    


        // for testing:
        public static void main(String[] args) {

            GemList.setList();
            
            mine = new Mine(Color.BLUE);
            axe = new Pickaxe();
            CanvasWindow canvas = new CanvasWindow("Game", 800, 600);
            backgrounds = new BackgroundManager("Mine", mine, canvas);
            
    
            mine.generateMine();
            backgrounds.drawBackround("Mine");
            mine.addGemSet("Blue");
            
            canvas.add(Minecart.drawMinecart());

            GraphicsObject axeShape = Pickaxe.drawAxe();
            canvas.add(axeShape, 100, 100); // arbitrary starting point
            canvas.draw();

            canvas.onMouseMove(event -> {
                axeShape.setCenter(event.getPosition());
            });

            canvas.onClick(event -> {
                System.out.println(Mine.getLeftBound());
                if (axe.testRockHit(canvas, mine) != null){
                    rockDissolve(canvas, axe.testRockHit(canvas, mine));
                }
                NewGemPanel.testPanel(event, canvas);
            });

            // side scrolling lambda, add button presses!
            canvas.onKeyDown( event -> {
                if(event.getKey() == Key.LEFT_ARROW && Mine.getLeftBound() <= 0){
                    mine.getGraphicsGroup().moveBy(5, 0); // change delta x depending on how fast cart should move
                }
                if(event.getKey() == Key.RIGHT_ARROW && Mine.getRightBound() >= 800) {
                    mine.getGraphicsGroup().moveBy(-5, 0); // change delta x depending on how fast cart should move
                }
            });
    

        }

        private static void rockDissolve(CanvasWindow canvas, Rock rock) {
            Point rockPosition = rock.getPosition();
            GraphicsObject twoThirds = rock.twoThirdsRock(rockPosition.getX(), rockPosition.getY());
            GraphicsObject oneThird = rock.oneThirdRock(rockPosition.getX(), rockPosition.getY());

            // hit #1
            axe.getAxe().rotateBy(90);
            backgrounds.getGraphicsGroup().remove(rock.getRockShape());
            backgrounds.getGraphicsGroup().add(twoThirds);
            canvas.draw();

            canvas.pause(150);
            axe.getAxe().rotateBy(-90);
            canvas.draw();
            canvas.pause(150);

            // hit #2
            axe.getAxe().rotateBy(90);
            backgrounds.getGraphicsGroup().remove(twoThirds);
            backgrounds.getGraphicsGroup().add(oneThird);
            canvas.draw();

            canvas.pause(150);
            axe.getAxe().rotateBy(-90);
            canvas.draw();
            canvas.pause(150);

            // hit #3
            axe.getAxe().rotateBy(90);
            backgrounds.getGraphicsGroup().remove(oneThird);
            canvas.draw();

            canvas.pause(150);
            axe.getAxe().rotateBy(-90);
            canvas.draw();
            canvas.pause(150);

            NewGemPanel newGem = new NewGemPanel(rockPosition, mine.generateGem());
            newGem.setUpGemPanel(canvas);

        }
    
}
