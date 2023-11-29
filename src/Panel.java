import edu.macalester.graphics.*;
import edu.macalester.graphics.events.MouseButtonEvent;

public class Panel {
    
    private static GraphicsGroup panel;
    private static Rectangle closeRectangle;
    protected static boolean drawn = false;

    public Panel() {
        panel = new GraphicsGroup();
    }

    /**
     * Generates graphical components of panel windows.
     * @param gem Randomly generated gem or null for slag/crown
     * @return GraphicsGroup with all graphic components.
     */
    public GraphicsGroup draw(Gem gem){
        return panel;
    }

    /**
     * @return Rectangle corresponding to close button
     */
    public Rectangle getClose(){
        return closeRectangle;
    }

    /**
     * Adds the panel to a canvas and prepares it to be closed.
     */
    public void setUp(CanvasWindow canvas, Gem gem) {
        panel = draw(gem);
        closeRectangle = getClose();
        canvas.add(panel);
        drawn = true;
        panel.setCenter(canvas.getCenter());
    }

    /**
     * Tests whether the exit button on the panel has been hit by any particular click, 
     * and removes the panel if it has.
     * @param event
     * @param canvas
     */
    public void test(MouseButtonEvent event, CanvasWindow canvas) {
        if(drawn && panel.testHit(event.getPosition().getX(), event.getPosition().getY())
        && panel.getElementAt(event.getPosition()).equals(closeRectangle)){
            canvas.remove(panel);
            drawn = false;
        }
    }

    /**
     * @return True if a panel is currently displayed.
     */
    public static boolean isDrawn() {
        return drawn;
    }

}
