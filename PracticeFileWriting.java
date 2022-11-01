import java.io.File;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
public class AppTest{
    public static void main(String[] args) {
        try{
            File myObj = new File("SearchSummary.txt");
            if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
        } else {
            System.out.println("File already exists, information updated");
        }
        FileWriter myWriter = new FileWriter("SearchSummary.txt");
            myWriter.write("Files in Java might be tricky, but it is simple enough!");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();

    }
  }
}
