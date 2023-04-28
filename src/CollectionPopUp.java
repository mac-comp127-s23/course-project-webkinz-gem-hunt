import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Rectangle;

public class CollectionPopUp {

    private static final Color BACKGROUND_COLOR = new Color(219, 203, 160);
    
    private GraphicsGroup collection;
    private GraphicsGroup whiteButton;
    private GraphicsGroup greenButton;
    private GraphicsGroup yellowButton;
    private GraphicsGroup blueButton;
    private GraphicsGroup redButton;

    private Rectangle collectionBackground;
    private Rectangle closeRectangle;

    private GraphicsText collectionText;
    private GraphicsText gem1Description;
    private GraphicsText gem2Description;
    private GraphicsText gem3Description;
    private GraphicsText gem4Description;
    private GraphicsText gem5Description;
    private GraphicsText gem6Description;

    private Image gem1;
    private Image gem2;
    private Image gem3;
    private Image gem4;
    private Image gem5;
    private Image gem6;

    public CollectionPopUp() {

        whiteButton = new GraphicsGroup();
        greenButton = new GraphicsGroup();
        yellowButton = new GraphicsGroup();
        blueButton = new GraphicsGroup();
        redButton = new GraphicsGroup();

        collectionBackground = new Rectangle(0, 0, 600, 400);
        collectionBackground.setFillColor(BACKGROUND_COLOR);
        collection = new GraphicsGroup();

        collection.add(collectionBackground);
        collection.setCenter(400, 300);

        Rectangle white = new Rectangle(0, 0, 200, 50);
        white.setFillColor(Color.darkGray);

        GraphicsText whiteText = new GraphicsText("WHITE");
        whiteText.setFont(FontStyle.BOLD, 16);
        whiteText.setFillColor(BACKGROUND_COLOR);
        whiteText.setCenter(100, 25);

        whiteButton.add(white);
        whiteButton.add(whiteText);
        collection.add(whiteButton, 0, 300);

        Rectangle green = new Rectangle(0, 0, 200, 50);
        green.setFillColor(new Color(10, 40, 3));

        GraphicsText greenText = new GraphicsText("GREEN");
        greenText.setFont(FontStyle.BOLD, 16);
        greenText.setFillColor(BACKGROUND_COLOR);
        greenText.setCenter(100, 25);

        greenButton.add(green);
        greenButton.add(greenText);
        collection.add(greenButton, 200, 300);

        Rectangle yellow = new Rectangle(0, 0, 200, 50);
        yellow.setFillColor(new Color(120, 105, 15));

        GraphicsText yellowText = new GraphicsText("YELLOW");
        yellowText.setFont(FontStyle.BOLD, 16);
        yellowText.setFillColor(BACKGROUND_COLOR);
        yellowText.setCenter(100, 25);

        yellowButton.add(yellow);
        yellowButton.add(yellowText);
        collection.add(yellowButton, 400, 300);

        Rectangle blue = new Rectangle(0, 0, 300, 50);
        blue.setFillColor(new Color(9, 1, 64));

        GraphicsText blueText = new GraphicsText("BLUE");
        blueText.setFont(FontStyle.BOLD, 16);
        blueText.setFillColor(BACKGROUND_COLOR);
        blueText.setCenter(150, 25);

        blueButton.add(blue);
        blueButton.add(blueText);
        collection.add(blueButton, 0, 350);

        Rectangle red = new Rectangle(0, 0, 300, 50);
        red.setFillColor(new Color(75, 10, 5));

        GraphicsText redText = new GraphicsText("RED");
        redText.setFont(FontStyle.BOLD, 16);
        redText.setFillColor(BACKGROUND_COLOR);
        redText.setCenter(150, 25);

        redButton.add(red);
        redButton.add(redText);
        collection.add(redButton, 300, 350);

    }

    public void drawCollectionPopup(GraphicsGroup group) {
        group.add(collection);
    }

    public GraphicsGroup getPopup() {
        return collection;
    }


    // for testing purposes:
    public static void main(String[] args) {
        CanvasWindow canvas = new CanvasWindow("Collection Pop-up Window Test", 800, 600);
        
        CollectionPopUp test = new CollectionPopUp();
        canvas.add(test.getPopup());
        canvas.draw();

    }

}

