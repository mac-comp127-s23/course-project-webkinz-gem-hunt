import java.awt.Color;

import edu.macalester.graphics.*;

public class SlagPanel extends Panel {

    private static GraphicsGroup panel;
    private static Rectangle panelBackground;
    private static GraphicsText name;
    private static GraphicsText description;
    private static Rectangle closeRectangle;

    public SlagPanel() {
        panelBackground = new Rectangle(0, 0, 200, 100);
        panel = new GraphicsGroup();
        name = new GraphicsText("SLAG", 10, 20);
        description = new GraphicsText("You have found SLAG.", 10, 40);
        closeRectangle = new Rectangle(190, 0, 10, 10);
        closeRectangle.setFillColor(Color.RED);
    }

    public GraphicsGroup draw(Gem gem) {
        panel.removeAll();
        panelBackground.setFillColor(Color.LIGHT_GRAY);
        panel.add(panelBackground);
        name.setFontStyle(FontStyle.BOLD);
        int nameFontSize = 10;
        name.setFontSize(nameFontSize);
        while(name.getWidth() > 90){
            nameFontSize --;
            description.setFontSize(nameFontSize);
        }
        panel.add(name);
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
