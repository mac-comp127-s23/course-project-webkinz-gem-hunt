import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Path;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class Mine {

    private static GraphicsGroup group;
    private static double CANVAS_WIDTH = 800; // change this to pull from canvas settings in game class
    private static double CANVAS_HEIGHT = 600; // change this to pull from canvas settings in game class

    public Mine() {
        GraphicsGroup group = new GraphicsGroup();
    }

    public static GraphicsGroup getGraphicsGroup() {
        return group;
    }

    // for testing:
    public static void main(String[] args) {
        CanvasWindow canvas = new CanvasWindow("Mine", 800, 600);

        addCave(50);
        canvas.add(group);
        canvas.draw();
    }

    /**
     * Creates a stalactites and stalagmites.
     *
     * @param size   The height of each layer of cave rock, and width of each triangle
     * 
     */
    private static void addCave(double size) {
        int layers = 4; // can adjust this or take as input parameter

        for (int layer = layers - 1; layer >= 0; layer--) {
            group.add(createStalagmites(layer * size * 0.2)); // each layer is smaller/shorter according to the layer
            group.add(createStalactites(layer * size * 0.2)); 
        }
    }

    /**
     * Creates one layer of stalagmites.
     * 
     * @param size The maximum height of the peaks
     */
    private static GraphicsGroup createStalagmites(double size) {
        GraphicsGroup group = new GraphicsGroup();

        double layerLeft = Helpers.randomDouble(-size, 0);
        double layerRight = CANVAS_WIDTH + size;
        Color layerColor = Helpers.randomColorVariation(Color.BLUE, 16); // change color to variable based upon instance var

        double x = layerLeft;
        while (x < layerRight) {
            double curHeight = Helpers.randomDouble(size * 0.4, size),
                curWidth = curHeight * Helpers.randomDouble(1.0, 1.6);
            Path peak = Path.makeTriangle(
                x - curWidth, CANVAS_HEIGHT,
                x, CANVAS_HEIGHT - curHeight,
                x + curWidth, CANVAS_HEIGHT);
            peak.setFillColor(layerColor);
            peak.setFilled(true);
            peak.setStroked(false);
            group.add(peak);
            x += curWidth * 0.5;
        }
        return group;
    }

    /**
     * Creates one layer of stalactites.
     * 
     * @param size The maximum height of the peaks
     */
    private static GraphicsGroup createStalactites(double size) {
        GraphicsGroup group = new GraphicsGroup();

        double layerLeft = Helpers.randomDouble(-size, 0);
        double layerRight = CANVAS_WIDTH + size;
        Color layerColor = Helpers.randomColorVariation(Color.BLUE, 16); // change color to variable based upon instance var

        double x = layerLeft;
        while (x < layerRight) {
            double curHeight = Helpers.randomDouble(size * 0.4, size),
                curWidth = curHeight * Helpers.randomDouble(1.0, 1.6);
            Path peak = Path.makeTriangle(
                x - curWidth, 0,
                x, curHeight,
                x + curWidth, 0);
            peak.setFillColor(layerColor);
            peak.setFilled(true);
            peak.setStroked(false);
            group.add(peak);
            x += curWidth * 0.5;
        }
        return group;
    }
    
}
