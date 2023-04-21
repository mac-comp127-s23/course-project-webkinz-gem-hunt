import java.awt.Color;

import edu.macalester.graphics.*;

public class Button {
    
    private static GraphicsGroup button;
    private static Ellipse circle;
    private static final Color BUTTON_COLOR = new Color(240, 197, 58);

    // public Button() {}

    public static GraphicsGroup drawBackButton() {
        button = new GraphicsGroup();
        circle = new Ellipse(0, 0, 30, 30);
        circle.setFillColor(BUTTON_COLOR);
        circle.setCenter(30, 25);
        button.add(circle);

        GraphicsText backText = new GraphicsText("X");
        backText.setFillColor(Color.BLACK);
        backText.setFont(FontStyle.BOLD, 18);
        backText.setCenter(30, 25);
        button.add(backText);

        return button;
    }

    public static Ellipse getButton() {
        return circle;
    }

}
