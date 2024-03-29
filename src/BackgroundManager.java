import java.util.HashMap;
import java.util.Map;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
/**
 * Class used to keep track of and draw different backgrounds to the canvas.
 */
public class BackgroundManager {
    
    private Map<String, Background> backgrounds = new HashMap<>(); //Map of existing backgrounds.
    private Background currentBackground; //Background being displayed now.
    private CanvasWindow canvas; //Game canvas window
    private String currentBackgroundName;

    /**
     * Creates a Background Manager with a starting background and canvas.
     * @param key                 How the background will be referred to in the code
     * @param startingBackground  The background that will be featured as the game begins
     * @param canvas              The game canvas
     */
    public BackgroundManager(String key, Background startingBackground, CanvasWindow canvas){
        currentBackground = startingBackground;
        this.addBackground(key, startingBackground);
        this.canvas = canvas;
        canvas.add(currentBackground.getGraphicsGroup());
    }


    public void addBackground(String key, Background background){
        backgrounds.put(key, background);
    }

    /**
     * Changes the displayed background to teh one specified by the key, removing the previous one.
     */
    public void drawBackround(String key){
        currentBackgroundName = key;
        canvas.removeAll();
        currentBackground = backgrounds.get(key);
        canvas.add(currentBackground.getGraphicsGroup());
        canvas.draw();
    }

    /**
     * Gets the current, drawn graphics group.
     * @return graphics group
     */
    public GraphicsGroup getGraphicsGroup(){
        return currentBackground.getGraphicsGroup();
    }

    public String getCurrentBackgroundName(){
        return currentBackgroundName;
    }
}
