import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Path;

import java.awt.Color;
import java.util.*;

public class RockManager {
    
    private Map<Path, Rock> rocks = new HashMap<>();

    /**
     * Map of rocks that can handle rock interactions.
     * @param numRocks Number of rocks to be drawn.
     * @param canvasHeight Height of rock range.
     * @param canvasWidth Width of rock range.
     */
    public RockManager(int numRocks, Color color, double canvasHeight, double canvasWidth){

        double totalWidth = 2400; // 2400 is length of entire canvas, with scrolling

        for (int i = 0; i < numRocks; i++){
            Rock topRock = new Rock(
                color,
                (i * (totalWidth / numRocks) + Helpers.randomDouble(50, 100)) 
                    - 800, // shift rock set to start at far left of mine
                Helpers.randomDouble(10, 100));
            rocks.put(topRock.getRockShape(), topRock);

            Rock bottomRock = new Rock(
                color,
                (i * (totalWidth / numRocks) + Helpers.randomDouble(50, 100)) 
                    - 800, // shift rock set to start at far left of mine
                canvasHeight - Helpers.randomDouble(50, 150));
            rocks.put(bottomRock.getRockShape(), bottomRock);
        }
    }

    /**
     * Draws rocks onto a given graphics group.
     * @param group
     */
    public void drawRocks(GraphicsGroup group){
        for(Path rock : rocks.keySet()){
            group.add(rock);
        }
    }

    public Set<Path> getRockShapes(){
        return rocks.keySet();
    }

    public Rock getRock(Path rockShape){
        return rocks.get(rockShape);
    }
    
}
