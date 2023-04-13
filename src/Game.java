import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;

public class Game {
    private static Mine mine;
    private static Pickaxe axe;
    private static BackgroundManager backgrounds;

        // for testing:
        public static void main(String[] args) {
            mine = new Mine();
            axe = new Pickaxe();
            CanvasWindow canvas = new CanvasWindow("Game", 800, 600);
            backgrounds = new BackgroundManager("Mine", mine, canvas);
    
            mine.addCave(300);
            mine.generateRocks();
            backgrounds.drawBackround("Mine");

            GraphicsObject axeShape = axe.drawAxe();
            canvas.add(axeShape, 100, 100); // arbitrary starting point
            canvas.draw();

            canvas.onMouseMove(event -> {
                axeShape.setPosition(event.getPosition());
            });

            canvas.onClick(event -> {
                axe.mineAnimate(canvas);
            });
    

        }
    
}
