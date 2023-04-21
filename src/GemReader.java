
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/** Retrieves data from a the given csv file */
public class GemReader {
  
    public static void main(String[] args) {
        try {
            File file = new File("res/gem_descriptions.csv");
            List<Gem> gems = new ArrayList<Gem>();
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                Scanner scanLines = new Scanner(data);
                scanLines.useDelimiter(",");
                Gem gem = new Gem();
                gem.setName(scanLines.next());
                gem.setDescription(scanLines.next().replace("@", ","));
                gem.setType(scanLines.next());
                gem.setRarity(Double.parseDouble(scanLines.next())/100.0);
                gem.setRegLowPrice(Integer.parseInt(scanLines.next()));
                gem.setRegHighPrice(Integer.parseInt(scanLines.next()));
                gem.setGemOfDayPrice(Integer.parseInt(scanLines.next()));
                gem.setBlue(scanLines.next());
                gem.setGreen(scanLines.next());
                gem.setRed(scanLines.next());
                gem.setYellow(scanLines.next());
                gem.setWhite(scanLines.next());
                System.out.println(gem.toString());
                gems.add(gem);
                scanLines.close();
                //System.out.println(scanLines.next() + " ");
                
                //gems.add(new Gem());

                //System.out.println(data);
            }
            scanner.close();
        }

        catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
        
    }

    /**
     * Reads through the gem descriptions file and converts it into a list of gems that is returned.
     * @return List of Gems.
     */
    public Set<Gem> readGems(){
        Set<Gem> gems = new HashSet<Gem>();

        try {
            File file = new File("res/gem_descriptions.csv");
            Scanner scanner = new Scanner(file);
            
            scanner.nextLine();//Removes first line of csv, which has labels for categories.

            while (scanner.hasNextLine()) {

                //Takes the first line of the csv and sets the delimiter within each line to a comma.
                Scanner scanLines = new Scanner(scanner.nextLine());
                scanLines.useDelimiter(",");

                //Creates a gem with the data from the csv.
                Gem gem = new Gem();
                gem.setName(scanLines.next());
                gem.setDescription(scanLines.next().replace("@", ","));
                gem.setType(scanLines.next());
                gem.setRarity(Double.parseDouble(scanLines.next())/100.0);
                gem.setRegLowPrice(Integer.parseInt(scanLines.next()));
                gem.setRegHighPrice(Integer.parseInt(scanLines.next()));
                gem.setGemOfDayPrice(Integer.parseInt(scanLines.next()));
                gem.setImage(scanLines.next());
                gem.setBlue(scanLines.next());
                gem.setGreen(scanLines.next());
                gem.setRed(scanLines.next());
                gem.setYellow(scanLines.next());
                gem.setWhite(scanLines.next());
                gems.add(gem);

                scanLines.close();
            }
            scanner.close();
        }

        catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
        //Returns the created list.
        return gems;
    }
    
}
