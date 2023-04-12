import java.awt.Color;

import edu.macalester.graphics.*;

public class Minecart {

    private static GraphicsGroup minecart;
    private static final Color CART_COLOR = new Color(22, 0, 117);

    public Minecart(CanvasWindow canvas) {
    }

    public static GraphicsGroup drawMinecart() {
        minecart = new GraphicsGroup();
        Point p1 = new Point(0, 0);
        Point p2 = new Point(150, 0);
        Point p3 = new Point(125, 80);
        Point p4 = new Point(25, 80);
        Path cart = new Path(p1, p2, p3, p4);
        cart.setFillColor(CART_COLOR);
        cart.setStrokeWidth(3);
        cart.setStrokeColor(Color.BLACK);
        cart.setCenter(400, 550);
        minecart.add(cart);

        Ellipse wheel1 = new Ellipse(0, 0, 30, 30);
        wheel1.setFillColor(Color.GRAY);
        wheel1.setCenter(380, 590);
        minecart.add(wheel1);

        Ellipse wheel2 = new Ellipse(0, 0, 30, 30);
        wheel2.setFillColor(Color.GRAY);
        wheel2.setCenter(420, 590);
        minecart.add(wheel2);

        return minecart;
    }

    //for testing

    public static void main(String[] args) {
        drawMinecart();

        CanvasWindow canvas = new CanvasWindow("minecrart", 800, 600);
        canvas.add(minecart);
        canvas.draw();
    }
    
}
