import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Path;
import edu.macalester.graphics.Point;

public class Rock{

    private Path rockShape;
    private static double width = 10;
    private static double height = 20;
    // private static Color rockColor;
    private Color rockColor;  //= Helpers.randomColorVariation(Color.BLUE, Helpers.randomInt(50,100));

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

    public Path twoThirdsRock(double x, double y) {
        // double x = getX();
        // double y = getY();

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

    public Path oneThirdRock(double x, double y) {
        // double x = getX();
        // double y = getY();

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

    public static void main(String[] args) {
        CanvasWindow canvas = new CanvasWindow("Game", 800, 600);

        // rockShape = octagon();

        // Color rockColor = Helpers.randomColorVariation(Color.BLUE, Helpers.randomInt(50,100));;
        // rockShape.setFillColor(rockColor);
        // rockShape.setStrokeColor(Color.BLACK);
        // rockShape.setStrokeWidth(3);

        // rockShape.setCenter(100, 200);

        // Path rock = oneThirdRock(100, 200);

        Rock rock = new Rock(100, 200);
        // Path twoThirds = rock.twoThirdsRock();
        // twoThirds.moveBy(40, 0);
        Path twoThirds = rock.twoThirdsRock(140, 200);
        // Path oneThird = rock.oneThirdRock();
        // oneThird.moveBy(80, 0);
        Path oneThird = rock.oneThirdRock(180, 200);

        canvas.add(rock.getRockShape());
        canvas.add(twoThirds);
        canvas.add(oneThird);
        canvas.draw();
        
    }

}
