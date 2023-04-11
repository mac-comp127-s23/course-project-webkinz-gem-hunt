import java.awt.Color;

import edu.macalester.graphics.Ellipse;

public class Rock {

    private static Ellipse rockShape;

    public Rock(double x, double y) {
        rockShape = new Ellipse(x, y, 20, 40);

        Color rockColor = Helpers.randomColorVariation(Color.BLUE, Helpers.randomInt(50,100));;
        rockShape.setFillColor(rockColor);
        rockShape.setStrokeColor(Color.BLACK);
        rockShape.setStrokeWidth(3);
    }

    public static Ellipse getRockShape() {
        return rockShape ;
    }

}
