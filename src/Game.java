import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Point;

public class Game {
    private static Mine mine;
    private static Pickaxe axe;
    private static BackgroundManager backgrounds;
    
    private static Minecart minecart;

    private static CanvasWindow canvas;

    private static final Color CAVE_BACKGROUND_BLUE = new Color(9, 1, 64);


        // for testing:
        public static void main(String[] args) {
            mine = new Mine(Color.BLUE);
            axe = new Pickaxe();
            CanvasWindow canvas = new CanvasWindow("Game", 800, 600);
    
            mine.addCave(300);
            mine.generateRocks();
            canvas.add(mine.getGraphicsGroup());
            canvas.draw();

            GraphicsObject axeShape = Pickaxe.drawAxe();
            canvas.add(axeShape, 100, 100); // arbitrary starting point
            canvas.draw();

            canvas.onMouseMove(event -> {
                axeShape.setCenter(event.getPosition());
            });

            canvas.onClick(event -> {
                if (axe.testRockHit(canvas) != null){
                    rockDissolve(canvas, axe.testRockHit(canvas));
                }
            });
    

        }

        private static void rockDissolve(CanvasWindow canvas, GraphicsObject rock) {
            Point rockPosition = rock.getPosition();

            // hit #1
            axe.getAxe().rotateBy(90);
            // canvas.remove(rock);
            canvas.add(Rock.twoThirdsRock(rockPosition.getX(), rockPosition.getY()));
            // canvas.add(Rock.twoThirdsRock());
            // rock.twoThirds();
            canvas.draw();

            canvas.pause(150);
            axe.getAxe().rotateBy(-90);
            canvas.draw();
            canvas.pause(150);

            // hit #2
            axe.getAxe().rotateBy(90);
            // canvas.remove(twoThirds);
            canvas.add(Rock.oneThirdRock(rockPosition.getX(), rockPosition.getY()));
            // canvas.add(oneThird);
            canvas.draw();

            canvas.pause(150);
            axe.getAxe().rotateBy(-90);
            canvas.draw();
            canvas.pause(150);

            // hit #3
            axe.getAxe().rotateBy(90);
            // canvas.remove(Rock.oneThirdRock(rockPosition.getX(), rockPosition.getY()));
            canvas.draw();

            canvas.pause(150);
            axe.getAxe().rotateBy(-90);
            canvas.draw();
            canvas.pause(150);

        }
    
}
