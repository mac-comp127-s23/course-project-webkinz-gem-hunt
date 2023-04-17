
import java.awt.Color;

import edu.macalester.graphics.*;
import edu.macalester.graphics.ui.Button;

public class NewGemPanel {
    
    private GraphicsGroup panel;
    private Rectangle panelBackground;
    private GraphicsText gemName;
    private GraphicsText gemDescription;
    private Image gemImage;
    private Button closePanel;

    public NewGemPanel(Point position, Gem gem){
        panelBackground = new Rectangle(0, 0, 200, 100);
        panelBackground.setFillColor(Color.LIGHT_GRAY);
        panel = new GraphicsGroup((int) position.getX(), (int) position.getY());
        panel.add(panelBackground);
        gemImage = gem.getImage();
        //gemImage.setScale(90, 90);
        gemImage.setAnchor(5, 5);
        panel.add(gemImage);
        gemName = new GraphicsText(gem.getName(), 100, 20);
        gemName.setFontStyle(FontStyle.BOLD);
        gemName.setFontSize(10);
        panel.add(gemName);
        gemDescription = new GraphicsText(gem.getDescription(), 100, 40);
        gemDescription.setWrappingWidth(90);
        gemDescription.setFontSize(10);
        panel.add(gemDescription);
        closePanel = new Button("X");
        closePanel.setPosition(200 - closePanel.getWidth(), 0);
        panel.add(closePanel);
    }
    
    /**
     * Adds the gem panel to a canvas and prepares it to be closed.
     */
    public void setUpGemPanel(CanvasWindow canvas){
        canvas.add(panel);
        panel.setCenter(canvas.getCenter());
        closePanel.onClick((() -> canvas.remove(panel)));
    }


}
