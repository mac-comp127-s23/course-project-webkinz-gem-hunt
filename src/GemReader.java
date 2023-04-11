
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GemReader {
  
    public static void main(String[] args) {
        try {
            File file = new File("res/gem_descriptions.csv");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                System.out.println(data);
            }
            scanner.close();
        }

        catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
        
    }
    
}
