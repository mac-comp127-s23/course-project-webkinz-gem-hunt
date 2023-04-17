import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Path;

import java.awt.Color;

public class MineGraphics {

    private static Color color;
    private static GraphicsGroup mineGroup;
    private static double CANVAS_WIDTH = 800; // change this to pull from canvas settings in game class
    private static double CANVAS_HEIGHT = 600; // change this to pull from canvas settings in game class


    public MineGraphics(Color color) {
        MineGraphics.color = color;
        mineGroup = new GraphicsGroup(0,0);
    }

    /**
     * Generates graphics associated with Mine, including cave walls and random set of rocks.
     * 
     */
    public void generateMine() {
        addCave(300, color);
    }


    /**
     * Adds stalactites and stalagmites to GraphicsGroup
     *
     * @param size The height of each layer of cave rock, and width of each triangle
     * 
     */
    public void addCave(double size, Color color) {
        int layers = 3; // can adjust this or take as input parameter

        for (int layer = layers ; layer > 0; layer--) {
            mineGroup.add(createStalagmites(layer * size * 0.2, color), 0, 0); // each layer is smaller/shorter according to the layer
            mineGroup.add(createStalactites(layer * size * 0.2, color), 0, 0); 

        }
    }

    /**
     * Creates one layer of stalagmites.
     * 
     * @param size The maximum height of the peaks
     */
    private GraphicsGroup createStalagmites(double size, Color color) {
        GraphicsGroup mitesGroup = new GraphicsGroup();

        double layerLeft = Helpers.randomDouble(-size, 0);
        double layerRight = CANVAS_WIDTH + size;
        Color layerColor = Helpers.randomColorVariation(color, Helpers.randomInt(30, 50)); // change color to variable based upon instance var

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
            x += curWidth * 0.5;
        }
        return mitesGroup;
    }

    /**
     * Creates one layer of stalactites.
     * 
     * @param size The maximum height of the peaks
     */
    private GraphicsGroup createStalactites(double size, Color color) {
        GraphicsGroup titesGroup = new GraphicsGroup();

        double layerLeft = Helpers.randomDouble(-size, 0);
        double layerRight = CANVAS_WIDTH + size;
        Color layerColor = Helpers.randomColorVariation(color, Helpers.randomInt(30, 50)); // change color to variable based upon instance var

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
}
