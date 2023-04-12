
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
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                Scanner scanLines = new Scanner(data);
                scanLines.useDelimiter(",");
                while(scanLines.hasNext()){
                    System.out.println(scanLines.next() + " ");
                }
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
    
}
