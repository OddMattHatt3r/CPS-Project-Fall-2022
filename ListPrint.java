import java.io.File;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
public class AppTest{
    public static void main(String[] args) {

        //String[] cities = {"union", "union", "piscataway"};

        ArrayList<String> cities = new ArrayList<String>();

        cities.add("Union");
        cities.add("Jersey City");
        cities.add("Union");
        cities.add("Piscataway");
        cities.add("Union");
        cities.add("Piscataway");
        cities.add("Union");


        try{
            File myObj = new File("SearchSummary.txt");
            if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
        } else {
            System.out.println("File already exists, information updated");
        }

        Map<String, Long> counts =
        cities.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        String x = counts.toString();
        x = x.replaceAll(","," times, ");
        String str = x.substring(1, x.length() - 1);
        str = str.replaceAll("="," - ");

        FileWriter myWriter = new FileWriter("SearchSummary.txt");
            myWriter.write("Number of times each city was searched: " + str +" times");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();

    }
  }
}
