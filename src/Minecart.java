import java.awt.Color;


import edu.macalester.graphics.*;

/** Minecart used in the Webkinz Gem Hunt with buttons to implement side-scrolling */
public class Minecart {

    private static GraphicsGroup minecart;
    private static final Color CART_COLOR = new Color(22, 0, 117);
    private static final Color BUTTON_COLOR = new Color(240, 197, 58);

    public Minecart() {
    }

    /** Creates a minecart graphics group and buttons with callback functions
     * to create side-scrolling within gameplay
     */
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

        Path slag = new Path(new Point(3,0), new Point(48,-70), new Point(67,-50), new Point(95,-48), new Point(147,0));
        slag.setFillColor(Color.DARK_GRAY);
        slag.setCenter(400, 475);
        minecart.add(slag);


        Path leftButton = new Path(new Point(-10,15), new Point(0,0), new Point(75,0), new Point(75,30), new Point(0,30));
        leftButton.setCenter(280, 550);
        leftButton.setFillColor(BUTTON_COLOR);

        GraphicsText leftText = new GraphicsText("LEFT");
        leftText.setFont(FontStyle.BOLD_ITALIC, 12);
        leftText.setCenter(282, 550);

        minecart.add(leftButton);
        minecart.add(leftText);

        Path rightButton = new Path(new Point(0,0), new Point(75,0), new Point(85, 15), new Point(75,30), new Point(0,30));
        rightButton.setFillColor(BUTTON_COLOR);
        rightButton.setCenter(520, 550);
        minecart.add(rightButton);

        GraphicsText rightText = new GraphicsText("RIGHT");
        rightText.setFont(FontStyle.BOLD_ITALIC, 12);
        rightText.setCenter(517, 550);
        minecart.add(rightText);
        
        
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
