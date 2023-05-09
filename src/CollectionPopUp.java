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

    Player player;
    
    private GraphicsGroup collection;

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


    /** Creates the collection pop up window where each button is its own graphics group that is later added onto
     * the overall collection graphics group. The image/text descriptions are added and their coordinates are set.
     */
    public CollectionPopUp(Player player) {
        this.player = player;
    }

    public GraphicsGroup draw(Gem gem) {

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

        collection.add(blue, 0, 350);
        collection.add(blueText, 121, 380);

        red = new Rectangle(0, 0, 300, 50);
        red.setFillColor(new Color(75, 10, 5));

        GraphicsText redText = new GraphicsText("RED");
        redText.setFont(FontStyle.BOLD, 16);
        redText.setFillColor(BACKGROUND_COLOR);
        redText.setCenter(150, 25);

        collection.add(red, 300, 350);
        collection.add(redText, 435, 380);

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

        gem1Description.setCenter(25, 150);
        collection.add(gem1Description);

        gem2Description.setCenter(245, 150);
        collection.add(gem2Description);

        gem3Description.setCenter(425, 150);
        collection.add(gem3Description);

        gem4Description.setCenter(25, 285);
        collection.add(gem4Description);

        gem5Description.setCenter(245, 285);
        collection.add(gem5Description);

        gem6Description.setCenter(425, 285);
        collection.add(gem6Description);

        Panel.drawn = true;
        return collection;
    }

    
    public void test(MouseButtonEvent event, CanvasWindow canvas) {
        if(Panel.drawn && collection.testHit(event.getPosition().getX(), event.getPosition().getY())
        && collection.getElementAt(event.getPosition()).equals(closeRectangle)){
            canvas.remove(collection);
            drawn = false;
            Panel.drawn = false;
        }
    }

    /** Tests whether the red button has been clicked, and updates images and descriptions if it has. */
    public void testRedButton(MouseButtonEvent event, CanvasWindow canvas) {
        if (Panel.drawn && collection.testHit(event.getPosition().getX(), event.getPosition().getY()) &&
        collection.getElementAt(event.getPosition()).equals(red)) {
            gem1.setImagePath("Red_Ruby_Heart.png");
            gem1Description.setText("Red Ruby Heart (x" + player.getCountForGem(GemList.getGemByName("Red Ruby Heart")) + ")");

            gem2.setImagePath("Ember_Amber.png");
            gem2Description.setText("Ember Amber (x" + player.getCountForGem(GemList.getGemByName("Ember Amber")) + ")");

            gem3.setImagePath("Volcano_Viscose.png");
            gem3Description.setText("Volcano Viscose (x" + player.getCountForGem(GemList.getGemByName("Volcano Viscose")) + ")");

            gem4.setImagePath("Flare_Fyca.png");
            gem4Description.setText("Flare Fyca (x" + player.getCountForGem(GemList.getGemByName("Flare Fyca")) + ")");

            gem5.setImagePath("Torch_Treasure.png");
            gem5Description.setText("Torch Treasure (x" + player.getCountForGem(GemList.getGemByName("Torch Treasure")) + ")");

            gem6.setImagePath("Lava_Lump.png");
            gem6Description.setText("Lava Lump (x" + player.getCountForGem(GemList.getGemByName("Lava Lump")) + ")");

        }
    }

    /** Tests whether the blue button has been clicked, and updates images and descriptions if it has. */
    public void testBlueButton(MouseButtonEvent event, CanvasWindow canvas) {
        if (Panel.drawn && collection.testHit(event.getPosition().getX(), event.getPosition().getY()) &&
        collection.getElementAt(event.getPosition()).equals(blue)) {
            gem1.setImagePath("Ocean_Sapphire.png");
            gem1Description.setText("Ocean Sapphire (x" + player.getCountForGem(GemList.getGemByName("Ocean Sapphire")) + ")");

            gem2.setImagePath("Teardrop_Tower.png");
            gem2Description.setText("Teardrop Tower (x" + player.getCountForGem(GemList.getGemByName("Teardrop Tower")) + ")");

            gem3.setImagePath("Sea_Stone.png");
            gem3Description.setText("Sea Stone (x" + player.getCountForGem(GemList.getGemByName("Sea Stone")) + ")");

            gem4.setImagePath("Rainbow_Flower.png");
            gem4Description.setText("Rainbow Flower (x" + player.getCountForGem(GemList.getGemByName("Rainbow Flower")) + ")");

            gem5.setImagePath("River_Ripple.png");
            gem5Description.setText("River Ripple (x" + player.getCountForGem(GemList.getGemByName("River Ripple")) + ")");

            gem6.setImagePath("Aqua_Orb.png");
            gem6Description.setText("Aqua Orb (x" + player.getCountForGem(GemList.getGemByName("Aqua Orb")) + ")");

        }
    }

    /** Tests whether the yellow button has been clicked, and updates images and descriptions if it has. */
    public void testYellowButton(MouseButtonEvent event, CanvasWindow canvas) {
        if (Panel.drawn && collection.testHit(event.getPosition().getX(), event.getPosition().getY()) &&
        collection.getElementAt(event.getPosition()).equals(yellow)) {
            gem1.setImagePath("Corona_Topaz.png");
            gem1Description.setText("Corona Topaz (x" + player.getCountForGem(GemList.getGemByName("Corona Topaz")) + ")");

            gem2.setImagePath("Aurora_Rox.png");
            gem2Description.setText("Aurora Rox (x" + player.getCountForGem(GemList.getGemByName("Aurora Rox")) + ")");

            gem3.setImagePath("Pyramid_Plunder.png");
            gem3Description.setText("Pyramid Plunder (x" + player.getCountForGem(GemList.getGemByName("Pyramid Plunder")) + ")");

            gem4.setImagePath("Starlight_Shimmer.png");
            gem4Description.setText("Starlight Shimmer (x" + player.getCountForGem(GemList.getGemByName("Starlight Shimmer")) + ")");

            gem5.setImagePath("Lemon_Drop.png");
            gem5Description.setText("Lemon Drop (x" + player.getCountForGem(GemList.getGemByName("Lemon Drop")) + ")");

            gem6.setImagePath("Carat_Eclipse.png");
            gem6Description.setText("Carat Eclipse (x" + player.getCountForGem(GemList.getGemByName("Carat Eclipse")) + ")");

        }
    }

    /** Tests whether the green button has been clicked, and updates images and descriptions if it has. */
    public void testGreenButton(MouseButtonEvent event, CanvasWindow canvas) {
        if (Panel.drawn && collection.testHit(event.getPosition().getX(), event.getPosition().getY()) &&
        collection.getElementAt(event.getPosition()).equals(green)) {
            gem1.setImagePath("Earth_Emerald.png");
            gem1Description.setText("Earth Emerald (x" + player.getCountForGem(GemList.getGemByName("Earth Emerald")) + ")");

            gem2.setImagePath("Moss_Marble.png");
            gem2Description.setText("Moss Marble (x" + player.getCountForGem(GemList.getGemByName("Moss Marble")) + ")");

            gem3.setImagePath("Cat_Eye_Glint.png");
            gem3Description.setText("Cat's Eye Glint (x" + player.getCountForGem(GemList.getGemByName("Cat's Eye Glint")) + ")");

            gem4.setImagePath("Jaded_Envy.png");
            gem4Description.setText("Jaded Envy (x" + player.getCountForGem(GemList.getGemByName("Jaded Envy")) + ")");

            gem5.setImagePath("Pearl_Egg.png");
            gem5Description.setText("Pearl Egg (x" + player.getCountForGem(GemList.getGemByName("Pearl Egg")) + ")");

            gem6.setImagePath("Terra_Tectonic.png");
            gem6Description.setText("Terra Tectonic (x" + player.getCountForGem(GemList.getGemByName("Terra Tectonic")) + ")");

        }
    }

    /** Tests whether the white button has been clicked, and updates images and descriptions if it has. */
    public void testWhiteButton(MouseButtonEvent event, CanvasWindow canvas) {
        if (Panel.drawn && collection.testHit(event.getPosition().getX(), event.getPosition().getY()) &&
        collection.getElementAt(event.getPosition()).equals(white)) {
            gem1.setImagePath("Webkinz_Diamond.png");
            gem1Description.setText("Webkinz Diamond (x" + player.getCountForGem(GemList.getGemByName("Webkinz Diamond")) + ")");

            gem2.setImagePath("Unicorn_Horn.png");
            gem2Description.setText("Unicorn Horn (x" + player.getCountForGem(GemList.getGemByName("Unicorn Horn")) + ")");

            gem3.setImagePath("Yum_Zum_Sparkle.png");
            gem3Description.setText("Yum Zum Sparkle (x" + player.getCountForGem(GemList.getGemByName("Yum Zum Sparkle")) + ")");

            gem4.setImagePath("Zingoz_Zincoz.png");
            gem4Description.setText("Zingoz Zincoz (x" + player.getCountForGem(GemList.getGemByName("Zingoz Zincoz")) + ")");

            gem5.setImagePath("Goober_Glitter.png");
            gem5Description.setText("Goober Glitter (x" + player.getCountForGem(GemList.getGemByName("Goober Glitter")) + ")");

            gem6.setImagePath("Booger_Nugget.png");
            gem6Description.setText("Booger Nugget (x" + player.getCountForGem(GemList.getGemByName("Booger Nugget")) + ")");

        }
    }

    public Rectangle getCloseButton () {
        return closeRectangle;
    }

    public GraphicsGroup getPopup() {
        return collection;
    }

}

