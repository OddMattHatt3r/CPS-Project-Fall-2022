import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void WebMethod(String input1, String input2, Integer input3, Integer input4)
        throws Exception {
        //Generate each link using the given parameters
        String InputLink1 = "https://www.homes.com/"+input1+"-"+input2+"/?price-min="+input3+"&price-max="+input4;
        String InputLink2 = "https://www.realtor.com/realestateandhomes-search/"+input1+"_"+input2+"/price-"+input3+"-"+input4;
        String InputLink3 = "https://www.trulia.com/for_sale/"+ input1.replaceAll("-", "_") +","+input2+"/" + input3 + "-" + input4 + "_price/";
        String[] inputs = {InputLink1, InputLink2, InputLink3};
        
        //Open new tab for each generated url
        for (int i = 0; i < 3; i++) {
            Desktop desk = Desktop.getDesktop();

            //Opens the url for each item in array
            String x = inputs[i];
            desk.browse(new URI(x));
        }
    }
    public static void CitySummaryMethod(ArrayList<String> cities)
        throws Exception{
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
    public static void main(String[] args)
        throws Exception {
            //Define variables
            String city, state, UserLoopReference, UserLoopNo, UserLoopYes;  
            int min, max;
            UserLoopReference = UserLoopYes = "Y";
            UserLoopNo = "N";
            int DoesLoop = 1, TimeCount = 0;
            ArrayList<String> cities = new ArrayList<String>();
            ArrayList<String> states = new ArrayList<String>();
            ArrayList<Integer> mins = new ArrayList<Integer>();
            ArrayList<Integer> maxs = new ArrayList<Integer>();
            Scanner input = new Scanner(System.in);

            //Keep looping until user says no
            while (DoesLoop == 1) {

                //Run programs based off of user input (Y, N, or none)
                switch (UserLoopReference){
                    //Runs 
                    case "Y":{
                        //Get user input for city
                        System.out.print("What is your city? (ex. Louisville): ");
                        //If city is empty, ask city again (fixes problem where it skips city after looping)
                        city = null;
                        while (city == null){
                        city = input.nextLine();
                        }
                        if (city == ""){
                            city = input.nextLine();
                        }
                        cities.add(city);
                        //If user's city input is more than one word, replace space char with _ char
                        city = city.replaceAll(" ", "-");

                        //Get user's state abbreviations 
                        System.out.print("What is your State? (Examples: NJ, KY, AZ): ");
                        state = input.next();
                        state = state.toLowerCase();
                        states.add(state);
                        
                        //Get user's desired minimum price value
                        System.out.println("What is your minimum price range? (ex. 3000000): ");
                        min = input.nextInt();
                        mins.add(min);

                        //Get user's desired maximum price value
                        System.out.println("What is your maximum price range? (ex. 5000000): ");
                        max = input.nextInt();
                        maxs.add(max);
                        
                        //Call Method that creates and opens the links
                        WebMethod(city, state, min, max);

                        //Ask user if they would like to search again
                        System.out.print("Would you like to search again? (Enter Y or N):  ");
                        UserLoopReference = input.next();
                    }
                    break;
                    //Thank user for using program, then terminate loop
                    case "N": {
                        System.out.println("Thank you for using our program :)");
                        DoesLoop = 0;
                        UserLoopReference = "N";
                    }
                    break;
                    //If user does not input "Y" or "N", state as invalid until user inputs Y or N (loop)
                    default:{
                        while (UserLoopReference != UserLoopYes || UserLoopReference != UserLoopNo ){
                        System.out.println("Please input a valid response");
                        System.out.print("Would you like to search again? (Enter Y or N):  ");
                        UserLoopReference = input.next();
                        }
                        DoesLoop = 1;
                        UserLoopReference = "Y";
                    }
                    break;
            
                }
                //Count up each time user searches

                TimeCount = TimeCount++; 

            }
        input.close();
        System.out.println(cities);
        System.out.println(states);
        System.out.println(maxs);
        System.out.println(mins);
        CitySummaryMethod(cities);
    }
}
