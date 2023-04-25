import java.awt.Color;

import edu.macalester.graphics.*;

public class Button {
    
    private GraphicsGroup button;
    private Ellipse circle;
    private final Color BUTTON_COLOR = new Color(240, 197, 58);
    private GraphicsText backText;

    public Button() {
        button = new GraphicsGroup();
        circle = new Ellipse(0, 0, 30, 30);
        circle.setFillColor(BUTTON_COLOR);
        circle.setCenter(30, 25);
        button.add(circle);
        backText = new GraphicsText("X");
        backText.setFillColor(Color.BLACK);
        backText.setFont(FontStyle.BOLD, 18);
        backText.setCenter(30, 25);
        button.add(backText);
    }

    public void drawBackButton(GraphicsGroup group) {
        group.add(button);
    }

    public Ellipse getButton() {
        return circle;
    }

}
