import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Path;
import java.util.*;

public class RockManager {
    
    private Map<Path, Rock> rocks = new HashMap<>();

    /**
     * Map of rocks that can handle rock interactions.
     * @param numRocks Number of rocks to be drawn.
     * @param canvasHeight Height of rock range.
     * @param canvasWidth Width of rock range.
     */
    public RockManager(int numRocks, double canvasHeight, double canvasWidth){

        double totalWidth = 2400; // 2400 is length of entire canvas, with scrolling

        for (int i = 0; i < numRocks; i++){
            Rock topRock = new Rock(
                i * (totalWidth / numRocks) + Helpers.randomDouble(50, 100), 
                Helpers.randomDouble(10, 100));
            rocks.put(topRock.getRockShape(), topRock);

            Rock bottomRock = new Rock(
                i * (totalWidth / numRocks) + Helpers.randomDouble(50, 100), 
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
            rock.moveBy(-800, 0); // shift rock set to start at far left of mine
            group.add(rock);
        }
    }

    public Set getRockShapes(){
        return rocks.keySet();
    }

    public Rock getRock(Path rockShape){
        return rocks.get(rockShape);
    }
    
}
