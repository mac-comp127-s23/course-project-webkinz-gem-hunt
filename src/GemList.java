import java.util.*;

public class GemList {
    private static Set<Gem> gems = new HashSet<Gem>();

    public static void add(Gem gem){
        gems.add(gem);
    }

    //Sets the gem list using gem reader.
    public static void setList(){
        GemReader readGems = new GemReader();
        gems = new HashSet<Gem>(readGems.readGems());
    }

    //Creates a set of gems
    public Set<Gem> getGemSet(String type){
        Set<Gem> gemSet = new HashSet<>();
        for(Gem gem : gems){
            if(gem.getType().equals(type)){
                gemSet.add(gem);
            }
        }
        return gemSet;
    }
}
