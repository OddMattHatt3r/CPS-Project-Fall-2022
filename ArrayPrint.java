import java.io.File;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class AppTest{
    public static void main(String[] args) {

        //String[] cities = {"union", "union", "piscataway"};


        try{
            File myObj = new File("SearchSummary.txt");
            if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
        } else {
            System.out.println("File already exists, information updated");
        }

        String[] array = {"Apple","Banana","Apple","Peanut","Banana","Orange","Apple", "Peanut", "Peanut"};

        Map<String, Long> map = Stream.of(array).collect(Collectors.
         groupingBy(Function.identity(), //use groupingBy array element
                 Collectors.counting())); //count number of occurances
        //System.out.println(map);//output the results of the Map

        String x = map.toString();
        x = x.replaceAll(",","");
        String str = x.substring(1, x.length() - 1);
        str = str.replaceAll("=","(");
        str = str.replaceAll(" ", " times) ");

        FileWriter myWriter = new FileWriter("SearchSummary.txt");
            myWriter.write("Number of times each city was searched: " + str +" times)");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();

    }
  }
}
