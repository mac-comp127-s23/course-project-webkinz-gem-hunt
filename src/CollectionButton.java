import java.awt.Color;

import edu.macalester.graphics.*;

public class CollectionButton {

    private GraphicsGroup button;
    private Rectangle rectangle;
    private final Color BUTTON_COLOR = new Color(240, 197, 58);
    private GraphicsText backText;

    public CollectionButton() {
        button = new GraphicsGroup(0,570);
        rectangle = new Rectangle(0, 0, 100, 30);
        rectangle.setFillColor(BUTTON_COLOR);
        button.add(rectangle);
        backText = new GraphicsText("Collection");
        backText.setFillColor(Color.BLACK);
        backText.setFont(FontStyle.BOLD, 18);
        backText.setCenter(rectangle.getCenter());
        button.add(backText);
    }

    public void drawCollectionButton(GraphicsGroup group) {
        group.add(button);
    }

    public GraphicsGroup getButton() {
        return button;
    }

}

