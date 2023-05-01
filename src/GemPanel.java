import java.awt.Color;

import edu.macalester.graphics.*;

public class GemPanel extends Panel{
    
    private static GraphicsGroup panel;
    private static Rectangle panelBackground;
    private static GraphicsText name;
    private static Image image;
    private static GraphicsText description;
    private static Rectangle closeRectangle;

    public GemPanel() {
        panelBackground = new Rectangle(0, 0, 200, 100);
        panel = new GraphicsGroup();
        name = new GraphicsText("", 100, 20);
        description = new GraphicsText("", 100, 40);
        closeRectangle = new Rectangle(190, 0, 10, 10);
        closeRectangle.setFillColor(Color.RED);
    }

    public GraphicsGroup draw(Gem gem) {
        panel.removeAll();
        panelBackground.setFillColor(Color.LIGHT_GRAY);
        panel.add(panelBackground);
    
        image = gem.getImage();
        image.setAnchor(5, 5);
        panel.add(image);
    
        name.setText(gem.getName());
        name.setFontStyle(FontStyle.BOLD);
        int nameFontSize = 10;
        name.setFontSize(nameFontSize);
        while(name.getWidth() > 90){
            nameFontSize --;
            description.setFontSize(nameFontSize);
        }
        panel.add(name);

        description.setText(gem.getDescription());
        description.setWrappingWidth(90);
        int descriptionFontSize = 10;
        description.setFontSize(descriptionFontSize);
        while(description.getHeight() > 60){
            descriptionFontSize --;
            description.setFontSize(descriptionFontSize);
        }
        panel.add(description);
        
        panel.add(closeRectangle);

        return panel;
    }

    public Rectangle getClose() {
        return closeRectangle;
    }
    
}
