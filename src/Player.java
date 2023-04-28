import java.util.HashMap;
import java.util.Set;

public class Player {
    
    private String name;
    private HashMap<Gem, Integer> gems;
    private int rocksMined;
    
    public Player(String name){
        this.name = name;
        gems = new HashMap<>();
        rocksMined = 0;
    }

    public void newGemFound(Gem gem){
        rocksMined ++;
        if(gems.keySet().contains(gem)){
            gems.put(gem, gems.get(gem) + 1);
        }
        else{
           gems.put(gem, 1); 
        }
    }

    public void printGemSet(){
        System.out.println(gems);
    }

    public Set getPlayerGems(){
        return gems.keySet();
    }

    public int getCountForGem(Gem gem){
        if(gems.keySet().contains(gem)){
            return gems.get(gem);
        } 
        else{
            return 0;
        }
    }
}
