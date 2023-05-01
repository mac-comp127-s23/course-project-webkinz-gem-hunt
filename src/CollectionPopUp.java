import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Rectangle;

/** A window that pops up during the main game when the player clicks on the collection button.
 * This displays the amount of gems (separated via color) that the player has currently found. */
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

    private GraphicsText gem1Count;
    private GraphicsText gem2Count;
    private GraphicsText gem3Count;
    private GraphicsText gem4Count;
    private GraphicsText gem5Count;
    private GraphicsText gem6Count;

    private Image gem1;
    private Image gem2;
    private Image gem3;
    private Image gem4;
    private Image gem5;
    private Image gem6;

    /** Creates the collection pop up window where each button is its own graphics group that is later added onto
     * the overall collection graphics group. The image/text descriptions are added and their coordinates are set.
     */
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

        closeRectangle = new Rectangle(0, 0, 20, 20);
        closeRectangle.setFillColor(Color.RED);

        collection.add(closeRectangle, 580, 0);

        collectionText = new GraphicsText("GEM COLLECTION");
        collectionText.setFont(FontStyle.BOLD, 24);
        collection.add(collectionText, 185, 25);

        gem1 = new Image(50, 36);
        gem1.setImagePath("Earth_Emerald.png");
        gem1.setScale(1);
        collection.add(gem1);

        gem2 = new Image(250, 36);
        gem2.setImagePath("Moss_Marble.png");
        gem2.setScale(1);
        collection.add(gem2);

        gem3 = new Image(450, 36);
        gem3.setImagePath("Cat_Eye_Glint.png");
        gem3.setScale(1);
        collection.add(gem3);

        gem4 = new Image(50, 172);
        gem4.setImagePath("Jaded_Envy.png");
        gem4.setScale(1);
        collection.add(gem4);

        gem5 = new Image(250, 172);
        gem5.setImagePath("Pearl_Egg.png");
        gem5.setScale(1);
        collection.add(gem5);

        gem6 = new Image(450, 172);
        gem6.setImagePath("Terra_Tectonic.png");
        gem6.setScale(1);
        collection.add(gem6);

        gem1Description = new GraphicsText("Earth Emerald");
        gem1Description.setCenter(100, 145);
        collection.add(gem1Description);

        gem2Description = new GraphicsText("Moss Marble");
        gem2Description.setCenter(300, 145);
        collection.add(gem2Description);

        gem3Description = new GraphicsText("Cat's Eye Glint");
        gem3Description.setCenter(500, 145);
        collection.add(gem3Description);

        gem4Description = new GraphicsText("Jaded Envy");
        //gem4.setCenter(100, 400);
        collection.add(gem4Description);


    }

    /** Creates the gemstone collection pop-window that displays the player's current gemstone count
     * for the color of the button they have clicked. */
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

