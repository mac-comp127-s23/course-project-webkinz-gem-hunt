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
