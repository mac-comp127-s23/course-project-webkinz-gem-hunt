import java.awt.Color;

import edu.macalester.graphics.Image;
import edu.macalester.graphics.Path;
import edu.macalester.graphics.Point;

public class Rock{

    private Path rockShape;
    private static double width = 10;
    private static double height = 20;
    private Color rockColor;  

    /**
     * Creates octagonal rock shape with fill color according to the active mine.
     *
     * @param (x,y) Position from upper left corner of bounding box. 
     * 
     */
    public Rock(double x, double y) {
        rockShape = new Path(new Point(width, 0),
            new Point(width * Math.cos(Math.toRadians(45)), height * Math.sin(Math.toRadians(45))),
            new Point(0, height),
            new Point(-width * Math.cos(Math.toRadians(45)), height * Math.sin(Math.toRadians(45))),
            new Point(-width,0),
            new Point(-width * Math.cos(Math.toRadians(45)), -height * Math.sin(Math.toRadians(45))),
            new Point(0, -height),
            new Point(width * Math.cos(Math.toRadians(45)), -height * Math.sin(Math.toRadians(45))) );

        rockColor = generateColor();
        rockShape.setPosition(x, y);
        rockShape.setFillColor(rockColor);
        rockShape.setStrokeColor(Color.BLACK);
        rockShape.setStrokeWidth(3);
    }

    /**
     * Generates a random hue of the base color of active mine.
     */
    public static Color generateColor() {
        return Helpers.randomColorVariation(Color.BLUE, Helpers.randomInt(50,100));
    }

    public Color getColor() {
        return rockColor;
    }

    public Path getRockShape(){
        return rockShape;
    }

    public Point getPosition(){
        return rockShape.getPosition();
    }

    /**
     * Creates a filled path in shape of the bottom 2/3 of a rock, using same color as original rock.
     *
     * @param (x,y) Position from upper left corner of bounding box. 
     * Shape will be drawn with padding so it aligns with position of a full rock at same (x,y).
     * 
     */
    public Path twoThirdsRock(double x, double y) {

        Path twoThirds = new Path(
            new Point(width, 0),
            new Point(width * Math.cos(Math.toRadians(45)), height * Math.sin(Math.toRadians(45))),
            new Point(0, height),
            new Point(-width * Math.cos(Math.toRadians(45)), height * Math.sin(Math.toRadians(45))),
            new Point(-width,0),
            new Point(-width * Math.cos(Math.toRadians(45)), -height * Math.sin(Math.toRadians(45))),
            new Point(width * Math.cos(Math.toRadians(45)), -height * Math.sin(Math.toRadians(45))) );

        twoThirds.setFillColor(rockColor);
        twoThirds.setStrokeColor(Color.BLACK);
        twoThirds.setStrokeWidth(3);
        twoThirds.setPosition(x, y + ((height) - height * Math.sin(Math.toRadians(45))) );
        
        return twoThirds;

    }

    /**
     * Creates a filled path in shape of the bottom 1/3 of a rock, using same color as original rock.
     *
     * @param (x,y) Position from upper left corner of bounding box. 
     * Shape will be drawn with padding so it aligns with position of a full rock at same (x,y).
     * 
     */
    public Path oneThirdRock(double x, double y) {

        Path oneThird = new Path(
            new Point(width, 0),
            new Point(width * Math.cos(Math.toRadians(45)), height * Math.sin(Math.toRadians(45))),
            new Point(0, height),
            new Point(-width * Math.cos(Math.toRadians(45)), height * Math.sin(Math.toRadians(45))),
            new Point(-width,0) 
            );

        oneThird.setFillColor(rockColor);
        oneThird.setStrokeColor(Color.BLACK);
        oneThird.setStrokeWidth(3);
        oneThird.setPosition(x, y + height);
        
        return oneThird;

    }

}
