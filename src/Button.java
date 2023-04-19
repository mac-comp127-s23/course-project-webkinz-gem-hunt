import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsText;

public class Button {
    
    private static GraphicsGroup button;
    private static final Color BUTTON_COLOR = new Color(240, 197, 58);


    public Button() {

    }

    public static GraphicsGroup drawBackButton() {
        button = new GraphicsGroup();
        Ellipse circle = new Ellipse(0, 0, 30, 30);
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


    //for testing purposes:
    public static void main(String[] args) {
        drawBackButton();

        CanvasWindow canvas = new CanvasWindow("minecrart", 800, 600);
        canvas.add(button);
        canvas.draw();
    }
}
