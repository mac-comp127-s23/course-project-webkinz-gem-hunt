import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Rectangle;

public class CollectionPopUp {
    
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
        collectionBackground = new Rectangle(0, 0, 400, 200);
        collection.add(collectionBackground);
        collection = new GraphicsGroup();
        whiteButton = new GraphicsGroup();
        greenButton = new GraphicsGroup();
        yellowButton = new GraphicsGroup();
        blueButton = new GraphicsGroup();
        redButton = new GraphicsGroup();


    }

    public void drawCollectionPopup(GraphicsGroup group) {
        group.add(collection);
    }


    // for testing purposes:
    public static void main(String[] args) {
        CanvasWindow canvas = new CanvasWindow("Collection Pop-up Window Test", 800, 600);
        

    }

}

