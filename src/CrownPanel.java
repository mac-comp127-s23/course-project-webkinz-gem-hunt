import java.awt.Color;

import edu.macalester.graphics.*;

public class CrownPanel extends Panel {

    private static GraphicsGroup panel;
    private static Rectangle panelBackground;
    private static GraphicsText name;
    private static GraphicsText description;
    private static Image image;
    private static Rectangle closeRectangle;

    public CrownPanel() {
        panelBackground = new Rectangle(0, 0, 320, 120);
        panel = new GraphicsGroup();
        image = new Image(10,10, "Crown_of_Wonder.png");
        image.setMaxHeight(100);
        name = new GraphicsText("Crown of Wonder", 200, 20);
        description = new GraphicsText("CONGRATULATIONS! You have collected all 30 gems!", 200, 40);
        closeRectangle = new Rectangle(310, 0, 10, 10);
        closeRectangle.setFillColor(Color.RED);
    }

    public GraphicsGroup draw(Gem gem) {
        panel.removeAll();
        panelBackground.setFillColor(Color.LIGHT_GRAY);
        panel.add(panelBackground);
        panel.add(image);
        name.setFontStyle(FontStyle.BOLD);
        int nameFontSize = 10;
        name.setFontSize(nameFontSize);
        while(name.getWidth() > 90){
            nameFontSize --;
            description.setFontSize(nameFontSize);
        }
        panel.add(name);
        description.setWrappingWidth(110);
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
