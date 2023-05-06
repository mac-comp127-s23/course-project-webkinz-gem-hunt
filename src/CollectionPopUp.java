import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.events.MouseButtonEvent;

/** A window that pops up during the main game when the player clicks on the collection button.
 * This displays the amount of gems (separated via color) that the player has currently found. */
public class CollectionPopUp extends Panel {

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

    private Rectangle white;
    private Rectangle green;

    private static boolean drawn = false;


    /** Creates the collection pop up window where each button is its own graphics group that is later added onto
     * the overall collection graphics group. The image/text descriptions are added and their coordinates are set.
     */
    public CollectionPopUp(CanvasWindow canvas) {

        whiteButton = new GraphicsGroup();
        greenButton = new GraphicsGroup();
        yellowButton = new GraphicsGroup();
        blueButton = new GraphicsGroup();
        redButton = new GraphicsGroup();

        white = new Rectangle(0, 0, 200, 50);
        white.setFillColor(Color.darkGray);

        green = new Rectangle(0, 0, 200, 50);
        green.setFillColor(new Color(10, 40, 3));

    }

    public GraphicsGroup draw(Gem gem) {
        drawn = true;

        collection = new GraphicsGroup();

        collectionBackground = new Rectangle(0, 0, 600, 400);

        gem1Description = new GraphicsText(null);
        gem2Description = new GraphicsText(null);
        gem3Description = new GraphicsText(null);
        gem4Description = new GraphicsText(null);
        gem5Description = new GraphicsText(null);
        gem6Description = new GraphicsText(null);


        gem1 = new Image(50, 36);
        gem2 = new Image(250, 36);
        gem3 = new Image(450, 36);
        gem4 = new Image(50, 172);
        gem5 = new Image(250, 172);
        gem6 = new Image(450, 172);

        collectionBackground.setFillColor(BACKGROUND_COLOR);
        collection.add(collectionBackground);
        collection.setCenter(400, 300);

        GraphicsText whiteText = new GraphicsText("WHITE");
        whiteText.setFont(FontStyle.BOLD, 16);
        whiteText.setFillColor(BACKGROUND_COLOR);
        whiteText.setCenter(100, 25);

        whiteButton.add(white);
        whiteButton.add(whiteText);
        collection.add(whiteButton, 0, 300);

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

        gem1.setScale(1);
        collection.add(gem1);

        gem2.setScale(1);
        collection.add(gem2);

        gem3.setScale(1);
        collection.add(gem3);

        gem4.setScale(1);
        collection.add(gem4);

        gem5.setScale(1);
        collection.add(gem5);

        gem6.setScale(1);
        collection.add(gem6);

        gem1Description.setCenter(50, 150);
        collection.add(gem1Description);

        gem2Description.setCenter(270, 150);
        collection.add(gem2Description);

        gem3Description.setCenter(450, 150);
        collection.add(gem3Description);

        gem4Description.setCenter(50, 285);
        collection.add(gem4Description);

        gem5Description.setCenter(270, 285);
        collection.add(gem5Description);

        gem6Description.setCenter(450, 285);
        collection.add(gem6Description);


        return collection;
    }

    @Override
    public void test(MouseButtonEvent event, CanvasWindow canvas) {
        if(drawn && collection.testHit(event.getPosition().getX(), event.getPosition().getY())
        && collection.getElementAt(event.getPosition()).equals(closeRectangle)){
            canvas.remove(collection);
            drawn = false;
        }
    }

    public void testGreenButton(MouseButtonEvent event, CanvasWindow canvas) {
        if (collection.testHit(event.getPosition().getX(), event.getPosition().getY()) &&
        collection.getElementAt(event.getPosition()).equals(getGreenButton())) {
            gem1.setImagePath("Earth_Emerald.png");
            gem1Description.setText("Earth Emerald");

            gem2.setImagePath("Moss_Marble.png");
            gem2Description.setText("Moss Marble");

            gem3.setImagePath("Cat_Eye_Glint.png");
            gem3Description.setText("Cat's Eye Glint");

            gem4.setImagePath("Jaded_Envy.png");
            gem4Description.setText("Jaded Envy");

            gem5.setImagePath("Pearl_Egg.png");
            gem5Description.setText("Pearl Egg");

            gem6.setImagePath("Terra_Tectonic.png");
            gem6Description.setText("Terra Tectonic");

        }
    }

    public void testWhiteButton(MouseButtonEvent event, CanvasWindow canvas) {
        if (collection.testHit(event.getPosition().getX(), event.getPosition().getY()) &&
        collection.getElementAt(event.getPosition()).equals(getWhiteButton())) {
            gem1.setImagePath("Webkinz_Diamond.png");
            gem1Description.setText("Webkinz Diamond");

            gem2.setImagePath("Unicorn_Horn.png");
            gem2Description.setText("Unicorn Horn");

            gem3.setImagePath("Yum_Zum_Sparkle.png");
            gem3Description.setText("Yum Zum Sparkle");

            gem4.setImagePath("Zingoz_Zincoz.png");
            gem4Description.setText("Zingoz Zincoz");

            gem5.setImagePath("Goober_Glitter.png");
            gem5Description.setText("Goober Glitter");

            gem6.setImagePath("Booger_Nugget.png");
            gem6Description.setText("Booger Nugget");

            //canvas.draw();
        }
    }

    public boolean testYellowButton(MouseButtonEvent event) {
        return (getYellowButton().testHit(event.getPosition().getX(), event.getPosition().getY()));
    }

    public boolean testBlueButton(MouseButtonEvent event) {
        return (getBlueButton().testHit(event.getPosition().getX(), event.getPosition().getY()));
    }

    public boolean testRedButton(MouseButtonEvent event) {
        return (getRedButton().testHit(event.getPosition().getX(), event.getPosition().getY()));
    }

    public boolean testExitButton(MouseButtonEvent event) {
        return (getCloseButton().testHit(event.getPosition().getX(), event.getPosition().getY()))
    }

    public Rectangle getWhiteButton() {
        return white;
    }

    public Rectangle getGreenButton() {
        return green;
    }

    public GraphicsGroup getYellowButton() {
        return yellowButton;
    }

    public GraphicsGroup getBlueButton() {
        return blueButton;
    }

    public GraphicsGroup getRedButton() {
        return redButton;
    }

    public Rectangle getCloseButton () {
        return closeRectangle;
    }

    public GraphicsGroup getPopup() {
        return collection;
    }

}

