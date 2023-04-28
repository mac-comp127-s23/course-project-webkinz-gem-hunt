import java.util.*;

public class GemList {
    private static Set<Gem> gems = new HashSet<Gem>();
    private static Set<Gem> gemSet = new HashSet<>();

    public static void add(Gem gem){
        gems.add(gem);
    }

    /**
     * Sets the gem list using gem reader.
     */
    public static void setList(){
        GemReader readGems = new GemReader();
        gems = new HashSet<Gem>(readGems.readGems());
    }

    /**
     * Creates a set of gems based on whether they appear in a particular mine in the webkinz game.
     */
    public static Set<Gem> getGemSet(String type){
        for(Gem gem : gems){
            if (type.equals("Blue")){
                if(gem.getBlue()){
                    gemSet.add(gem);
                }
            }

            if (type.equals("Green")){
                if(gem.getGreen()){
                    gemSet.add(gem);
                }
            }

            if (type.equals("Red")){
                if(gem.getRed()){
                    gemSet.add(gem);
                }
            }

            if (type.equals("Yellow")){
                if(gem.getYellow()){
                    gemSet.add(gem);
                }
            }

            if (type.equals("White")){
                if(gem.getWhite()){
                    gemSet.add(gem);
                }
            }
        }

        return gemSet;
    }

}
