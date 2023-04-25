import java.util.HashMap;

public class Player {
    
    private String name;
    private HashMap<Gem, Integer> gems;
    private int rocksMined;
    
    public Player(String name){
        this.name = name;
        gems = new HashMap<>();
        rocksMined = 0;
    }
}
