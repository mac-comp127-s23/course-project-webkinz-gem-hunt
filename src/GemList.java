import java.util.ArrayList;
import java.util.List;

public class GemList {
    private List<Gem> gems = new ArrayList<Gem>();

    public void add(Gem gem){
        gems.add(gem);
    }

    //Sets the gem list using gem reader.
    public void setList(){
        GemReader readGems = new GemReader();
        gems = new ArrayList<Gem>(readGems.readGems());
    }
}
