
import edu.macalester.graphics.*;

/** Information for each gemstone */
public class Gem {
    
    private String name;
    private String description;
    private int regLowPrice;
    private int regHighPrice;
    private int gemOfDayPrice;
    private String type;
    private double rarity;
    private Image image;

    public Gem() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setRegLowPrice(int regLowPrice) {
        this.regLowPrice = regLowPrice;
    }

    public int getRegLowPrice() {
        return this.regLowPrice;
    }

    public void setRegHighPrice(int regHighPrice) {
        this.regHighPrice = regHighPrice;
    }

    public int getRegHighPrice() {
        return this.regHighPrice;
    }

    public void setGemOfDayPrice(int gemOfDayPrice) {
        this.gemOfDayPrice = gemOfDayPrice;
    }

    public int getGemOfDayPrice() {
        return this.gemOfDayPrice;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setRarity(double rarity) {
        this.rarity = rarity;
    }

    public double getRarity() {
        return this.rarity;
    }

    public void setImage(String imageFile) {
        this.image = new Image(imageFile);
    }

    public Image getImage() {
        return this.image;
    }

    public String toString(){
        return "Name: " + name + "\n Description: " + description + "\n Type: "
        + type + "\n Low Price: " + regLowPrice + "\n High Price: " + regHighPrice 
        + "\n Gem of the Day Price: " + gemOfDayPrice + "\n Rarity: " + rarity;
    }
}
