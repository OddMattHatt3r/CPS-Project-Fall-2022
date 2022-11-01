  // Import the IOException class to handle errors
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class Main{
    public static void main(String[] args) {

        String[] array = {"Apple","Banana","Orange","Apple","Peanut","Banana","Orange","Apple", "Peanut", "Peanut"};

        Map<String, Long> map = Stream.of(array).collect(Collectors.
            groupingBy(Function.identity(), //use groupingBy array element
                 Collectors.counting())); //count number of occurances
        //System.out.println(map);//output the results of the Map

        String x = map.toString();
        x = x.replaceAll(",","");
        String str = x.substring(1, x.length() - 1);
        str = str.replaceAll("=",":");

        System.out.println("\n"+ str);

        

    }
  }
