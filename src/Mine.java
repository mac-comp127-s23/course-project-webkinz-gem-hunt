import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Path;

import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

public class Mine {

    private static GraphicsGroup group;
    private static List<Path> rocksList;
    private static double CANVAS_WIDTH = 800; // change this to pull from canvas settings in game class
    private static double CANVAS_HEIGHT = 600; // change this to pull from canvas settings in game class


    public Mine() {
        group = new GraphicsGroup();
        addCave(300);
    }

    public static GraphicsGroup getGraphicsGroup() {
        return group;
    }

    /**
     * Adds stalactites and stalagmites to GraphicsGroup
     *
     * @param size The height of each layer of cave rock, and width of each triangle
     * 
     */
    public static void addCave(double size) {
        int layers = 3; // can adjust this or take as input parameter

        for (int layer = layers ; layer > 0; layer--) {
            group.add(createStalagmites(layer * size * 0.2), 0, 0); // each layer is smaller/shorter according to the layer
            group.add(createStalactites(layer * size * 0.2), 0, 0); 

        }
    }

    /**
     * Creates one layer of stalagmites.
     * 
     * @param size The maximum height of the peaks
     */
    private static GraphicsGroup createStalagmites(double size) {
        GraphicsGroup mitesGroup = new GraphicsGroup();

        double layerLeft = Helpers.randomDouble(-size, 0);
        double layerRight = CANVAS_WIDTH + size;
        Color layerColor = Helpers.randomColorVariation(Color.BLUE, Helpers.randomInt(30, 50)); // change color to variable based upon instance var

        double x = layerLeft;
        while (x < layerRight) {
            double curHeight = Helpers.randomDouble(size * 0.4, size),
                curWidth = curHeight * 0.2*Helpers.randomDouble(1.0, 1.6);
            Path peak = Path.makeTriangle(
                x - curWidth, CANVAS_HEIGHT,
                x, CANVAS_HEIGHT - curHeight,
                x + curWidth, CANVAS_HEIGHT);
            peak.setFillColor(layerColor);
            peak.setFilled(true);
            peak.setStroked(false);
            mitesGroup.add(peak);
            group.add(peak);
            x += curWidth * 0.5;
        }
        return mitesGroup;
    }

    /**
     * Creates one layer of stalactites.
     * 
     * @param size The maximum height of the peaks
     */
    private static GraphicsGroup createStalactites(double size) {
        GraphicsGroup titesGroup = new GraphicsGroup();

        double layerLeft = Helpers.randomDouble(-size, 0);
        double layerRight = CANVAS_WIDTH + size;
        Color layerColor = Helpers.randomColorVariation(Color.BLUE, Helpers.randomInt(30, 50)); // change color to variable based upon instance var

        double x = layerLeft;
        while (x < layerRight) {
            double curHeight = Helpers.randomDouble(size * 0.4, size),
                curWidth = curHeight * 0.2*Helpers.randomDouble(1.0, 1.6);
            Path peak = Path.makeTriangle(
                x - curWidth, 0,
                x, curHeight,
                x + curWidth, 0);
            peak.setFillColor(layerColor);
            peak.setFilled(true);
            peak.setStroked(false);
            titesGroup.add(peak);
            x += curWidth * 0.5;
        }
        return titesGroup;
    }

    public static void generateRocks() {
        rocksList = new ArrayList<>();

        int numRocks = 10; // number of rocks across top and bottom

        double totalWidth = CANVAS_WIDTH; // can be modified if scrolling implemented

        for (int i = 0; i < numRocks; i++){
            Rock topRock = new Rock(
                i * (totalWidth / numRocks) + Helpers.randomDouble(50, 100), 
                Helpers.randomDouble(10, 100));
            group.add(topRock.getRockShape());
            rocksList.add(topRock.getRockShape());

            Rock bottomRock = new Rock(
                i * (totalWidth / numRocks) + Helpers.randomDouble(50, 100), 
                CANVAS_HEIGHT - Helpers.randomDouble(50, 150));
            group.add(bottomRock.getRockShape());
            rocksList.add(bottomRock.getRockShape());
        }

    }

    public static List<Path> getRockList() {
        return rocksList ;
    }

    
    // // for testing:
    // public static void main(String[] args) {
    //     group = new GraphicsGroup();
    //     CanvasWindow canvas = new CanvasWindow("Mine", 800, 600);

    //     addCave(300);
    //     canvas.add(group);
    //     canvas.draw();

    //     generateRocks();
    //     canvas.draw();
    // }
    
}
