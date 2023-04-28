import java.awt.Color;

import edu.macalester.graphics.*;
import edu.macalester.graphics.events.MouseButtonEvent;

public class NewGemPanel {
    
    private static GraphicsGroup panel;
    private static Rectangle panelBackground;
    private static GraphicsText gemName;
    private static GraphicsText gemDescription;
    private static Image gemImage;
    private static Rectangle closeRectangle;
    private static boolean drawn = false;

    public NewGemPanel(){
        panelBackground = new Rectangle(0, 0, 200, 100);
        panel = new GraphicsGroup();
        gemName = new GraphicsText("", 100, 20);
        gemDescription = new GraphicsText("", 100, 40);
        closeRectangle = new Rectangle(190, 0, 10, 10);
        closeRectangle.setFillColor(Color.RED);
    }

    /**
     * Sets the gem panel to reflect the information contained by a particular gem object.
     * @param gem
     */
    public void drawGemPanel(Gem gem){
        panel.removeAll();
        panelBackground.setFillColor(Color.LIGHT_GRAY);
        panel.add(panelBackground);

        gemImage = gem.getImage();
        gemImage.setAnchor(5, 5);
        panel.add(gemImage);

        gemName.setText(gem.getName());
        gemName.setFontStyle(FontStyle.BOLD);
        int nameFontSize = 10;
        gemName.setFontSize(nameFontSize);
        while(gemName.getWidth() > 90){
            nameFontSize --;
            gemDescription.setFontSize(nameFontSize);
        }
        panel.add(gemName);

        gemDescription.setText(gem.getDescription());
        gemDescription.setWrappingWidth(90);
        int descriptionFontSize = 10;
        gemDescription.setFontSize(descriptionFontSize);
        while(gemDescription.getHeight() > 60){
            descriptionFontSize --;
            gemDescription.setFontSize(descriptionFontSize);
        }
        panel.add(gemDescription);
        
        panel.add(closeRectangle);
    }
    
    /**
     * Adds the gem panel to a canvas and prepares it to be closed.
     */
    public void setUpGemPanel(CanvasWindow canvas){
        canvas.add(panel);
        drawn = true;
        panel.setCenter(canvas.getCenter());
    }

    /**
     * Removes the gem panel from the canvas.
     * @param canvas
     */
    public void removeDuplicatePanel(CanvasWindow canvas){
        if(drawn)
        {
            canvas.remove(panel);
            drawn = false;
        }
    }

    /**
     * Tests whether the exit button on the panel has been hit by any particular click, 
     * and removes the panel if it has.
     * @param event
     * @param canvas
     */
    public static void testPanel(MouseButtonEvent event, CanvasWindow canvas){
        if(drawn && panel.testHit(event.getPosition().getX(), event.getPosition().getY())
        && panel.getElementAt(event.getPosition()).equals(closeRectangle)){
            canvas.remove(panel);
            drawn = false;
        }
        
    }

    /**
     * @return True if a gem panel is currently displayed.
     */
    public static boolean isDrawn() {
        return drawn;
    }


}
