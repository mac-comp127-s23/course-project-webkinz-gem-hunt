
import edu.macalester.graphics.*;

/** Information for each gemstone */
public class Gem {

    // parameters from Webkinz
    private String name;
    private String description;
    private int regLowPrice;
    private int regHighPrice;
    private int gemOfDayPrice;
    private String type;
    private double rarity;
    private Image image;

    // indicators of whether gem is found in the mine of that color (T/F)
    private boolean blue;
    private boolean green;
    private boolean red;
    private boolean yellow;
    private boolean white;

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

    public void setBlue(String indic) {
        this.blue = (indic.equals("Y"));
    }

    public boolean getBlue() {
        return this.blue;
    }

    public void setGreen(String indic) {
        this.green = (indic.equals("Y"));
    }

    public boolean getGreen() {
        return this.green;
    }

    public void setRed(String indic) {
        this.red = (indic.equals("Y"));
    }

    public boolean getRed() {
        return this.red;
    }

    public void setYellow(String indic) {
        this.yellow = (indic.equals("Y"));
    }

    public boolean getYellow() {
        return this.yellow;
    }

    public void setWhite(String indic) {
        this.white = (indic.equals("Y"));
    }

    public boolean getWhite() {
        return this.white;
    }

    @Override
    public String toString() {
        return "Gem [name=" + name + ", description=" + description + ", regLowPrice=" + regLowPrice + ", regHighPrice="
            + regHighPrice + ", gemOfDayPrice=" + gemOfDayPrice + ", type=" + type + ", rarity=" + rarity + ", image="
            + image + ", blue=" + blue + ", green=" + green + ", red=" + red + ", yellow=" + yellow + ", white=" + white
            + "]";
    }
    
}
