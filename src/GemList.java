import java.util.ArrayList;
import java.util.List;

public class GemList {
    private static List<Gem> gems = new ArrayList<Gem>();

    public static void add(Gem gem){
        gems.add(gem);
    }

    //Sets the gem list using gem reader.
    public static void setList(){
        GemReader readGems = new GemReader();
        gems = new ArrayList<Gem>(readGems.readGems());
    }
}
