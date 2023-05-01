import java.awt.Color;


import edu.macalester.graphics.*;

/** Minecart used in the Webkinz Gem Hunt with buttons to implement side-scrolling */
public class Minecart {

    private GraphicsGroup minecart;
    private GraphicsGroup leftButtonGroup;
    private GraphicsGroup rightButtonGroup;
    private static final Color CART_COLOR = new Color(22, 0, 117);
    private static final Color BUTTON_COLOR = new Color(240, 197, 58);
    private static Path leftButton;
    private static Path rightButton;

    /** Constructs the minecart and its buttons through three separate graphics groups. */
    public Minecart() {
        
        minecart = new GraphicsGroup();
        leftButtonGroup = new GraphicsGroup();
        rightButtonGroup = new GraphicsGroup();

        Path cart = new Path(new Point(0,0), new Point(150,0), new Point(125,80), new Point(25,80));
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


        leftButton = new Path(new Point(-10,15), new Point(0,0), new Point(75,0), new Point(75,30), new Point(0,30));
        leftButton.setCenter(280, 550);
        leftButton.setFillColor(BUTTON_COLOR);

        GraphicsText leftText = new GraphicsText("LEFT");
        leftText.setFont(FontStyle.BOLD_ITALIC, 12);
        leftText.setCenter(282, 550);

        leftButtonGroup.add(leftButton);
        leftButtonGroup.add(leftText);

        minecart.add(leftButtonGroup);

        rightButton = new Path(new Point(0,0), new Point(75,0), new Point(85, 15), new Point(75,30), new Point(0,30));
        rightButton.setFillColor(BUTTON_COLOR);
        rightButton.setCenter(520, 550);
        

        GraphicsText rightText = new GraphicsText("RIGHT");
        rightText.setFont(FontStyle.BOLD_ITALIC, 12);
        rightText.setCenter(517, 550);
        
        rightButtonGroup.add(rightButton);
        rightButtonGroup.add(rightText);
        
        minecart.add(rightButtonGroup);

    }

    /** 
     * Creates a minecart graphics group and buttons with callback functions
     * to create side-scrolling within gameplay
     */
    public void drawMinecart(GraphicsGroup group) {
        group.add(minecart);
    }

    public GraphicsGroup getMinecart(){
        return minecart;
    }

    public GraphicsGroup getLeftButton(){
        return leftButtonGroup;
    }

    public GraphicsGroup getRightButton(){
        return rightButtonGroup;
    }

    //for testing
    public static void main(String[] args) {

        CanvasWindow canvas = new CanvasWindow("minecrart", 800, 600);
        Minecart cart = new Minecart();
        canvas.add(cart.getMinecart());
        canvas.draw();
    }
    
}
