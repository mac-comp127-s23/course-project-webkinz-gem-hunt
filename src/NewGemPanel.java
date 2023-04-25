
import java.awt.Color;

//import javax.security.auth.callback.TextInputCallback;

import edu.macalester.graphics.*;
import edu.macalester.graphics.events.MouseButtonEvent;
//import edu.macalester.graphics.ui.Button;

public class NewGemPanel {
    
    private static GraphicsGroup panel;
    private static Rectangle panelBackground;
    private static GraphicsText gemName;
    private static GraphicsText gemDescription;
    private static Image gemImage;
    //private static Button closePanel;
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

    public void drawGemPanel(Gem gem){
        panel.removeAll();
        //panelBackground = new Rectangle(0, 0, 200, 100);
        panelBackground.setFillColor(Color.LIGHT_GRAY);
        //panel = new GraphicsGroup((int) position.getX(), (int) position.getY());
        panel.add(panelBackground);
        gemImage = gem.getImage();
        //gemImage.setScale(90, 90);
        gemImage.setAnchor(5, 5);
        panel.add(gemImage);
        //gemName = new GraphicsText(gem.getName(), 100, 20);
        gemName.setText(gem.getName());
        gemName.setFontStyle(FontStyle.BOLD);
        int nameFontSize = 10;
        gemName.setFontSize(nameFontSize);
        while(gemName.getWidth() > 90){
            nameFontSize --;
            gemDescription.setFontSize(nameFontSize);
        }
        panel.add(gemName);
        //gemDescription = new GraphicsText(gem.getDescription(), 100, 40);
        gemDescription.setText(gem.getDescription());
        gemDescription.setWrappingWidth(90);
        int descriptionFontSize = 10;
        gemDescription.setFontSize(descriptionFontSize);
        while(gemDescription.getHeight() > 60){
            descriptionFontSize --;
            gemDescription.setFontSize(descriptionFontSize);
        }
        panel.add(gemDescription);
        // closePanel = new Button("X");
        // closePanel.setPosition(200 - closePanel.getWidth(), 0);
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

    public void removeDuplicatePanel(CanvasWindow canvas){
        if(drawn)
        {
            canvas.remove(panel);
            drawn = false;
        }
    }

    public static void testPanel(MouseButtonEvent event, CanvasWindow canvas){
        if(drawn && panel.testHit(event.getPosition().getX(), event.getPosition().getY())
        && panel.getElementAt(event.getPosition()).equals(closeRectangle)){
            canvas.remove(panel);
            drawn = false;
        }
        
    }


}
