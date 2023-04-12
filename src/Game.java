import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;

public class Game {
    private static Mine mine;
    private static Pickaxe axe;
    private static Minecart minecart;
    private static final Color CAVE_BACKGROUND = new Color(9, 1, 64);

        // for testing:
        public static void main(String[] args) {
            mine = new Mine();
            axe = new Pickaxe();
            minecart = new Minecart();
            CanvasWindow canvas = new CanvasWindow("Game", 800, 600);
            canvas.setBackground(CAVE_BACKGROUND);
    
            mine.addCave(300);
            mine.generateRocks();
            canvas.add(mine.getGraphicsGroup());
            canvas.draw();

            canvas.add(minecart.drawMinecart());

            GraphicsObject axeShape = axe.drawAxe();
            canvas.add(axeShape, 100, 100); // arbitrary starting point
            canvas.draw();

            canvas.onMouseMove(event -> {
                axeShape.setCenter(event.getPosition());
            });

            canvas.onClick(event -> {
                axe.mineAnimate(canvas);
            });
    

        }
    
}
