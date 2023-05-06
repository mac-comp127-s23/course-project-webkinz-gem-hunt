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
    private Rectangle yellow;
    private Rectangle blue;
    private Rectangle red;

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

        white = new Rectangle(0, 0, 200, 50);
        white.setFillColor(Color.darkGray);

        GraphicsText whiteText = new GraphicsText("WHITE");
        whiteText.setFont(FontStyle.BOLD, 16);
        whiteText.setFillColor(BACKGROUND_COLOR);
        
        collection.add(white, 0, 300);
        collection.add(whiteText, 77, 330);

        green = new Rectangle(0, 0, 200, 50);
        green.setFillColor(new Color(10, 40, 3));

        GraphicsText greenText = new GraphicsText("GREEN");
        greenText.setFont(FontStyle.BOLD, 16);
        greenText.setFillColor(BACKGROUND_COLOR);
        greenText.setCenter(100, 25);

        collection.add(green, 200, 300);
        collection.add(greenText, 275, 330);

        yellow = new Rectangle(0, 0, 200, 50);
        yellow.setFillColor(new Color(120, 105, 15));

        GraphicsText yellowText = new GraphicsText("YELLOW");
        yellowText.setFont(FontStyle.BOLD, 16);
        yellowText.setFillColor(BACKGROUND_COLOR);
        yellowText.setCenter(100, 25);

        collection.add(yellow, 400, 300);
        collection.add(yellowText, 475, 330);

        blue = new Rectangle(0, 0, 300, 50);
        blue.setFillColor(new Color(9, 1, 64));

        GraphicsText blueText = new GraphicsText("BLUE");
        blueText.setFont(FontStyle.BOLD, 16);
        blueText.setFillColor(BACKGROUND_COLOR);
        blueText.setCenter(150, 25);

        blueButton.add(blue);
        blueButton.add(blueText);
        collection.add(blueButton, 0, 350);

        red = new Rectangle(0, 0, 300, 50);
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

    public void testRedButton(MouseButtonEvent event, CanvasWindow canvas) {
        if (collection.testHit(event.getPosition().getX(), event.getPosition().getY()) &&
        collection.getElementAt(event.getPosition()).equals(red)) {
            gem1.setImagePath("Red_Ruby_Heart.png");
            gem1Description.setText("Red Ruby Heart");

            gem2.setImagePath("Ember_Amber.png");
            gem2Description.setText("Ember Amber");

            gem3.setImagePath("Volcano_Viscose.png");
            gem3Description.setText("Volcano Viscose");

            gem4.setImagePath("Flare_Fyca.png");
            gem4Description.setText("Flare Fyca");

            gem5.setImagePath("Torch_Treasure.png");
            gem5Description.setText("Torch Treasure");

            gem6.setImagePath("Lava_Lump.png");
            gem6Description.setText("Lava Lump");

        }
    }

    public void testBlueButton(MouseButtonEvent event, CanvasWindow canvas) {
        if (collection.testHit(event.getPosition().getX(), event.getPosition().getY()) &&
        collection.getElementAt(event.getPosition()).equals(blue)) {
            gem1.setImagePath("Ocean_Sapphire.png");
            gem1Description.setText("Ocean Sapphire");

            gem2.setImagePath("Teardrop_Tower.png");
            gem2Description.setText("Teardrop Tower");

            gem3.setImagePath("Sea_Stone.png");
            gem3Description.setText("Sea Stone");

            gem4.setImagePath("Rainbow_Flower.png");
            gem4Description.setText("Rainbow Flower");

            gem5.setImagePath("River_Ripple.png");
            gem5Description.setText("River Ripple");

            gem6.setImagePath("Aqua_Orb.png");
            gem6Description.setText("Aqua Orb");

        }
    }

    public void testYellowButton(MouseButtonEvent event, CanvasWindow canvas) {
        if (collection.testHit(event.getPosition().getX(), event.getPosition().getY()) &&
        collection.getElementAt(event.getPosition()).equals(yellow)) {
            gem1.setImagePath("Corona_Topaz.png");
            gem1Description.setText("Corona Topaz");

            gem2.setImagePath("Aurora_Rox.png");
            gem2Description.setText("Aurora Rox");

            gem3.setImagePath("Pyramid_Plunder.png");
            gem3Description.setText("Pyramid Plunder");

            gem4.setImagePath("Starlight_Shimmer.png");
            gem4Description.setText("Starlight Shimmer");

            gem5.setImagePath("Lemon_Drop.png");
            gem5Description.setText("Lemon Drop");

            gem6.setImagePath("Carat_Eclipse.png");
            gem6Description.setText("Carat Eclipse");

        }
    }

    public void testGreenButton(MouseButtonEvent event, CanvasWindow canvas) {
        if (collection.testHit(event.getPosition().getX(), event.getPosition().getY()) &&
        collection.getElementAt(event.getPosition()).equals(green)) {
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
        collection.getElementAt(event.getPosition()).equals(white)) {
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

