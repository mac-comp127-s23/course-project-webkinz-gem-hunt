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

    private static GraphicsGroup crownPanel;
    private static Rectangle crownPanelBackground;
    private static GraphicsText crownName;
    private static GraphicsText crownDescription;
    private static Image crownImage;
    private static Rectangle closeCrownRectangle;

    public NewGemPanel(){
        panelBackground = new Rectangle(0, 0, 200, 100);
        panel = new GraphicsGroup();
        gemName = new GraphicsText("", 100, 20);
        gemDescription = new GraphicsText("", 100, 40);
        closeRectangle = new Rectangle(190, 0, 10, 10);
        closeRectangle.setFillColor(Color.RED);


        crownPanelBackground = new Rectangle(0, 0, 320, 120);
        crownPanel = new GraphicsGroup();
        crownImage = new Image(10,10, "Crown_of_Wonder.png");
        crownImage.setMaxHeight(100);
        crownName = new GraphicsText("Crown of Wonder", 200, 20);
        crownDescription = new GraphicsText("CONGRATULATIONS! You have collected all 30 gems!", 200, 40);
        closeCrownRectangle = new Rectangle(310, 0, 10, 10);
        closeCrownRectangle.setFillColor(Color.RED);
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

    public void drawSlagPanel(){
        panel.removeAll();
        panelBackground.setFillColor(Color.LIGHT_GRAY);
        panel.add(panelBackground);
        // gemImage = gem.getImage();
        // gemImage.setAnchor(5, 5);
        // panel.add(gemImage);
        gemName.setText("SLAG");
        gemName.setFontStyle(FontStyle.BOLD);
        int nameFontSize = 10;
        gemName.setFontSize(nameFontSize);
        while(gemName.getWidth() > 90){
            nameFontSize --;
            gemDescription.setFontSize(nameFontSize);
        }
        panel.add(gemName);
        gemDescription.setText("You have found SLAG.");
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

    public void drawCrownPanel(){
        crownPanel.removeAll();
        crownPanelBackground.setFillColor(Color.LIGHT_GRAY);
        crownPanel.add(crownPanelBackground);
        crownPanel.add(crownImage);
        crownName.setFontStyle(FontStyle.BOLD);
        int nameFontSize = 10;
        crownName.setFontSize(nameFontSize);
        while(crownName.getWidth() > 90){
            nameFontSize --;
            crownDescription.setFontSize(nameFontSize);
        }
        crownPanel.add(crownName);
        crownDescription.setWrappingWidth(110);
        int descriptionFontSize = 10;
        crownDescription.setFontSize(descriptionFontSize);
        while(crownDescription.getHeight() > 60){
            descriptionFontSize --;
            crownDescription.setFontSize(descriptionFontSize);
        }
        crownPanel.add(crownDescription);
        crownPanel.add(closeCrownRectangle);
    }
    
    /**
     * Adds the gem panel to a canvas and prepares it to be closed.
     */
    public void setUpGemPanel(CanvasWindow canvas){
        canvas.add(panel);
        drawn = true;
        panel.setCenter(canvas.getCenter());
    }

    public void setUpCrownPanel(CanvasWindow canvas){
        canvas.add(crownPanel);
        drawn = true;
        crownPanel.setCenter(canvas.getCenter());
    }

    public void setUpCrownPanel(CanvasWindow canvas){
        canvas.add(crownPanel);
        drawn = true;
        crownPanel.setCenter(canvas.getCenter());
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

    public static void testCrownPanel(MouseButtonEvent event, CanvasWindow canvas){
        if(drawn && crownPanel.testHit(event.getPosition().getX(), event.getPosition().getY())
        && crownPanel.getElementAt(event.getPosition()).equals(closeCrownRectangle)){
            canvas.remove(crownPanel);
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
