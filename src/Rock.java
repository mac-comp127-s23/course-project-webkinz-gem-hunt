import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;

import edu.macalester.graphics.Path;
import edu.macalester.graphics.Point;

public class Rock {

    private static Path rockShape;
    private static double width = 10;
    private static double height = 20;
    private static Color rockColor = Helpers.randomColorVariation(Color.BLUE, Helpers.randomInt(50,100));

    public Rock(double x, double y) {
        rockShape = octagon();
        rockShape.setPosition(x, y);

        rockShape.setFillColor(rockColor);
        rockShape.setStrokeColor(Color.BLACK);
        rockShape.setStrokeWidth(3);
    }

    public static Path octagon() {

        Path oct = new Path(
            new Point(width, 0),
            new Point(width * Math.cos(Math.toRadians(45)), height * Math.sin(Math.toRadians(45))),
            new Point(0, height),
            new Point(-width * Math.cos(Math.toRadians(45)), height * Math.sin(Math.toRadians(45))),
            new Point(-width,0),
            new Point(-width * Math.cos(Math.toRadians(45)), -height * Math.sin(Math.toRadians(45))),
            new Point(0, -height),
            new Point(width * Math.cos(Math.toRadians(45)), -height * Math.sin(Math.toRadians(45))) );

        return oct; 
    }

    public static Path getRockShape() {
        return rockShape ;
    }

    public static Path twoThirdsRock(double x, double y) {

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
        twoThirds.setPosition(x, y + ((y/2) - height * Math.sin(Math.toRadians(45))) );
        
        return twoThirds;

    }

    public static Path oneThirdRock(double x, double y) {

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
        oneThird.setPosition(x, y + ((y/2) - height * Math.sin(Math.toRadians(45))) );
        
        return oneThird;

    }

    public static void main(String[] args) {
        CanvasWindow canvas = new CanvasWindow("Game", 800, 600);

        // rockShape = octagon();

        // Color rockColor = Helpers.randomColorVariation(Color.BLUE, Helpers.randomInt(50,100));;
        // rockShape.setFillColor(rockColor);
        // rockShape.setStrokeColor(Color.BLACK);
        // rockShape.setStrokeWidth(3);

        // rockShape.setCenter(100, 200);

        Path rock = oneThirdRock(100, 200);

        canvas.add(rock);
        canvas.draw();
        
    }

}
