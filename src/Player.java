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

    /**
     * Adds a new gem to the player's collection.  If the player has already found that gem,
     * increases the count in the collection.  Otherwise, creates a new entry in the player's collection.
     * @param gem
     */
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

    public Set<Gem> getPlayerGems(){
        return gems.keySet();
    }

    /**
     * Returns the number of a particular gem that a player has, returns zero if the player
     * has not yet discovered that gem.
     * @param gem
     * @return
     */
    public int getCountForGem(Gem gem){
        if(gems.keySet().contains(gem)){
            return gems.get(gem);
        } 
        else{
            return 0;
        }
    }

    public boolean checkCompletion(){
        if(gems.size() == 30){
            return true;
        } 
        else{
            return false;
        }
    }
}
