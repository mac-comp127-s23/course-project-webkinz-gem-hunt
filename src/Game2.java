import java.awt.Color;

import edu.macalester.graphics.*;
import edu.macalester.graphics.events.*;

public class Game2 {
    private static MineMap startMap;
    private static CanvasWindow canvas;
    private static Pickaxe axe;
    private static BackgroundManager backgrounds;


    public static void main(String[] args) {
        startMap = new MineMap();
        canvas = new CanvasWindow("Gem Hunt", 800, 600);

        canvas.setBackground(MineMap.MAP_BACKGROUND);
    
        canvas.add(startMap.drawMap());
        canvas.draw();

        System.out.println(startMap.getDoors());

        canvas.onClick(event -> {
            if (startMap.getDoors().keySet().contains(canvas.getElementAt(event.getPosition()))){
                activateMine(startMap.getDoors().get(canvas.getElementAt(event.getPosition())));
            }
        });

    }

    private static void activateMine(Color color) {
        Mine mine = new Mine(color);
        canvas.removeAll();
        backgrounds = new BackgroundManager("Mine", mine, canvas);
        mine.generateMine();
        backgrounds.drawBackround("Mine");

    }
    
}
