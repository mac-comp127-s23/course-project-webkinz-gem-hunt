import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Path;
import java.util.*;

public class RockManager {
    
    private Map<Path, Rock> rocks = new HashMap<>();

    public RockManager(int numRocks, double canvasHeight, double canvasWidth){

        double totalWidth = canvasWidth; // can be modified if scrolling implemented

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

    public void drawRocks(GraphicsGroup group){
        for(Path rock : rocks.keySet()){
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
