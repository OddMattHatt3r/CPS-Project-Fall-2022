import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {
    public static void WebGenMethod
        (String input1, String input2, Double input3, Double input4, Integer input5, Integer input6)
        throws Exception {
        //Generate each link using the given parameters
        String InputLink1 = "https://www.homes.com/"+input1+"-"+input2+"/"+input5+"-bedroom/"+"?bath="+input6+"&price-min="+input3+"&price-max="+input4;
        String InputLink2 = "https://www.realtor.com/realestateandhomes-search/"+input1+"_"+input2+"/beds-"+input5+"/baths-"+input6+"/price-"+input3+"-"+input4;
        String InputLink3 = "https://www.trulia.com/for_sale/"+ input1.replaceAll("-", "_") +","+input2+"/" +input5+"p_beds/"+input6+"p_baths/"+input3+"-" +input4+"_price/";
        String[] inputs = {InputLink1, InputLink2, InputLink3};
        
        //Open new tab for each generated url
        for (int i = 0; i < 3; i++) {
            Desktop desk = Desktop.getDesktop();

            //Opens the url for each item in array
            String x = inputs[i];
            desk.browse(new URI(x));
        }
    }
    public static void SummaryMethod
    (ArrayList<String> cities, ArrayList<String> states,ArrayList<Double> maxes,ArrayList<Double> mins, int timeCount, ArrayList<Integer> beds, ArrayList<Integer> baths)
        throws Exception{
            try{
                File myObj = new File("SearchSummary.txt");
                if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists, information updated");
            }
            //Print the cities
            Map<String, Long> counts =
            cities.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
    
            String x = counts.toString();
            x = x.replaceAll(","," times\n");
            String cityStr = x.substring(1, x.length() - 1);
            cityStr = cityStr.replaceAll("="," - ");

            //Print the states
            Map<String, Long> counts2 =
            states.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
    
            String y = counts2.toString();
            y = y.replaceAll(","," times\n");
            String stateStr = y.substring(1, y.length() - 1);
            stateStr = stateStr.replaceAll("="," - ");

            //Min prices
            Double totalMax = 0.0;
            int maxLeng = maxes.size();
            for (int i = 0; i < maxLeng; i++){
                totalMax = totalMax + maxes.get(i);
            }
            Double avgMax = totalMax/maxLeng;
            String Maxvalue = String.format("%.1f", avgMax);

            //Find average minimum prices
            Double totalMin = 0.0;
            int minLeng = mins.size();
            for (int i = 0; i < minLeng; i++){
                totalMin = totalMin + mins.get(i);
            }
            Double avgMin = totalMin/minLeng;
            String Minvalue = String.format("%.1f", avgMin);

            //Find average number of beds
            int totalBeds = 0;
            int bedLeng = beds.size();
            for (int i = 0; i < bedLeng; i++){
                totalBeds = totalBeds + beds.get(i);
            }
            float avgBed = Math.round((totalBeds/bedLeng)+.1);

            //Find average number of beds
            int totalBaths = 0;
            int bathLeng = baths.size();
            for (int i = 0; i < bathLeng; i++){
                totalBaths = totalBaths + baths.get(i);
            }
            float avgBaths = (totalBaths/bathLeng);
            
            //Print results into text document
            FileWriter myWriter = new FileWriter("SearchSummary.txt");
                myWriter.write("The program was run " + (timeCount) +" times\n");
                myWriter.write("\nNumber of times each state was searched");
                myWriter.write("\n----------------------------------------\n ");
                myWriter.write(stateStr +" times");
                myWriter.write("\n\nNumber of times each city was searched");
                myWriter.write("\n----------------------------------------\n ");
                myWriter.write(cityStr +" times\n");
                myWriter.write("\nAverages");
                myWriter.write("\n----------------------------------------");
                myWriter.write("\n The average maximum price was: $" + Maxvalue + "0");
                myWriter.write("\n The average minimum price was: $" + Minvalue + "0");
                myWriter.write("\n The average number of beds was: " + avgBed);
                myWriter.write("\n The average number of baths was: " + avgBaths);
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            }
    }
    public static String ConvertState(String state){
        //Replaces state name with abbreviation
        switch(state){
            case "alabama":{
                state = "AL";
            } break;

            case "alaska":{
                state = "AK";
            } break;

            case "arizona":{
                state = "AZ";
            } break;

            case "arkansas":{
                state = "AR";
            } break;

            case "california":{
                state = "CA";
            } break;

            case "colorado":{
                state = "CO";
            } break;

            case "connecticut":{
                state = "CT";
            } break;

            case "delaware":{
                state = "DE";
            } break;

            case "florida":{
                state = "FL";
            } break;

            case "georgia":{
                state = "GA";
            } break;

            case "hawaii":{
                state = "HI";
            } break;

            case "idaho":{
                state = "ID";
            } break;

            case "illinois":{
                state = "IL";
            } break;

            case "indiana":{
                state = "IN";
            } break;
                            
            case "iowa":{
                state = "IA";
            } break;

            case "kansas":{
                state = "KS";
            } break;

            case "kentucky":{
                state = "KY";
            } break;

            case "louisiana":{
                state = "LA";
            } break;

            case "maine":{
                state = "ME";
            } break;

            case "maryland":{
                state = "MD";
            } break;

            case "massachusetts":{
                state = "MA";
            } break;

            case "michigan":{
                state = "MI";
            } break;

            case "minnesota":{
                state = "MN";
            } break;

            case "mississippi":{
                state = "MS";
            } break;

            case "missouri":{
                state = "MO";
            } break;

            case "montana":{
                state = "MT";
            } break;

            case "nebraska":{
                state = "NE";
            } break;

            case "nevada":{
                state = "NV";
            } break;

            case "new hampshire":{
                state = "NH";
            } break;

            case "new jersey":{
                state = "NJ";
            } break;

            case "new mexico":{
                state = "NM";
            } break;

            case "new york":{
                state = "NY";
            } break;

            case "north carolina":{
                state = "NC";
            } break;

            case "north dakota":{
                state = "ND";
            } break;

            case "ohio":{
                state = "OH";
            } break;

            case "oklahoma":{
                state = "OK";
            } break;

            case "oregon":{
                state = "OR";
            } break;

            case "pennsylvania":{
                state = "PA";
            } break;

            case "rhode island":{
                state = "RI";
            } break;

            case "south carolina":{
                state = "SC";
            } break;

            case "south dakota":{
                state = "SD";
            } break;

            case "tennessee":{
                state = "TN";
            } break;

            case "texas":{
                state = "TX";
            } break;

            case "utah":{
                state = "UT";
            } break;

            case "vermont":{
                state = "VT";
            } break;

            case "virginia":{
                state = "VA";
            } break;

            case "washington":{
                state = "WA";
            } break;

            case "west virginia":{
                state = "WV";
            } break;

            case "wisconsin":{
                state = "WI";
            } break;

            case "wyoming":{
                state = "WY";
            }
        }
        return state;
    }
    public static int StringInputCheckInt(String input){
        int isntNumber = 0;
        for (int i = 0; i < input.length();i++){
            Character x = input.charAt(i);
            if (x >= 48 && x<58){
                isntNumber = isntNumber+ 0;
            }
            else if (x < 48 || x>=58){
                isntNumber = isntNumber+ 1;
            }
        }
        return isntNumber;
    }
    public static int StringInputCheckNoInt(String input){
        int isntString = 0;
        for (int i = 0; i < input.length();i++){
            Character x = input.charAt(i);
            if (x >= 97 && x<123){
                isntString = isntString + 0;
            }
            else if (x < 97 || x>=123){
                isntString = isntString+ 1;
            }
        }
        return isntString;
    }
    
    public static void main(String[] args)
        throws Exception {
            //Define variables
            String city, state, UserLoopReference, UserLoopNo, UserLoopYes, minString, maxString, bedString, bathString;  
            Double maxInt, minInt; 
            int bedInt, bathInt;
            UserLoopReference = UserLoopYes = "Y";
            UserLoopNo = "N";
            int DoesLoop = 1, TimeCount = -1;
            ArrayList<String> cities = new ArrayList<String>();
            ArrayList<String> states = new ArrayList<String>();
            ArrayList<Double> mins = new ArrayList<Double>();
            ArrayList<Double> maxs = new ArrayList<Double>();
            ArrayList<Integer> beds = new ArrayList<Integer>();
            ArrayList<Integer> baths = new ArrayList<Integer>();
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
                        //Make sure input is allowed
                        String city2 = city.replaceAll(" ", "").toLowerCase();
                        city2 = city2.toLowerCase();
                        int isntString = StringInputCheckNoInt(city2);
                        while (isntString >= 1){
                            System.out.println("Please enter a valid city name");
                            city = input.nextLine();
                            city2 = city.replaceAll(" ", "").toLowerCase();
                            isntString = StringInputCheckNoInt(city2);
                        }

                        //Properly capitalize city name
                        city = city.substring(0,1).toUpperCase() + city.substring(1,city.length());
                        cities.add(city);
                        //If user's city input is more than one word, replace space char with _ char
                        city = city.replaceAll(" ", "-");

                        //Get user's state abbreviations 
                        System.out.print("What is your State? (Examples: NJ, KY, AZ): ");
                        state = null;
                        while (state == null){
                        state = input.nextLine();
                        }
                        if (state == ""){
                            state = input.nextLine();
                        }

                        //Make sure input is only letters
                        state = state.toLowerCase();
                        String state2 = state.replaceAll(" ", "").toLowerCase();
                        isntString = StringInputCheckNoInt(state2);
                        while (isntString >= 1){
                            System.out.println("Please enter a valid state name");
                            state = input.nextLine();
                            state2 = state.replaceAll(" ", "").toLowerCase();
                            isntString = StringInputCheckNoInt(state2);
                        }
                        state = (ConvertState(state)).toUpperCase();
                        states.add(state);

                        //Get user's desired minimum price value
                        System.out.println("What is your minimum price range? (ex. 3000000): ");
                        minString = null;
                        while (minString == null){
                        minString = input.nextLine();
                        }
                        if (minString == ""){
                            minString = input.nextLine();
                        }
                        int isntNumber = StringInputCheckInt(minString);
                        while (isntNumber >= 1){
                            System.out.println("Please enter a valid price");
                            minString = input.nextLine();
                            isntNumber = StringInputCheckInt(minString);
                        }
                        minInt = Double.valueOf(minString);
                        mins.add(minInt);

                        //Get user's desired maximum price value
                        System.out.println("What is your maximum price range? (ex. 5000000): ");
                        maxString = null;
                        while (maxString == null){
                        maxString = input.nextLine();
                        }
                        if (maxString == ""){
                            maxString = input.nextLine();
                        }
                        isntNumber = StringInputCheckInt(maxString);
                        while (isntNumber >= 1){
                            System.out.println("Please enter a valid price");
                            maxString = input.nextLine();
                            isntNumber = StringInputCheckInt(maxString);
                        }
                        maxInt = Double.valueOf(maxString);
                        maxs.add(maxInt);
                        
                        //Get user input for minimum number of bedrooms
                        System.out.println("What is your desired number of bedrooms? (ex. 3): ");
                        bedString = null;
                        while (bedString == null){
                        bedString = input.nextLine();
                        }
                        if (bedString == ""){
                            bedString = input.nextLine();
                        }
                        isntNumber = StringInputCheckInt(bedString);
                        while (isntNumber >= 1){
                            System.out.println("Please enter a valid number");
                            bedString = input.nextLine();
                            isntNumber = StringInputCheckInt(bedString);
                        }
                        bedInt = Integer.valueOf(bedString);

                        //not sure bout this
                        beds.add(bedInt);

                        //Get user input for minimum number of baths
                        System.out.println("What is your desired number of baths? (ex. 2): ");
                        bathString = null;
                        while (bathString == null){
                            bathString = input.nextLine();
                        }
                        if (bathString == ""){
                            bathString = input.nextLine();
                        }
                        isntNumber = StringInputCheckInt(bathString);
                        while (isntNumber >= 1){
                            System.out.println("Please enter a valid number");
                            bathString = input.nextLine();
                            isntNumber = StringInputCheckInt(bathString);
                        }
                        bathInt = Integer.valueOf(bathString);
                        
                        //Max number to 5 so it works with websites
                        baths.add(bathInt);

                        //Call Method that creates and opens the links
                        WebGenMethod(city, state, minInt, maxInt, bedInt, bathInt);

                        //Ask user if they would like to search again
                        System.out.print("Would you like to search again? (Enter Y or N):  ");
                        UserLoopReference = input.next().toUpperCase();
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
                        if (UserLoopReference == "Y"){
                            DoesLoop = 1;
                            UserLoopReference = "Y";
                        }
                        else {
                            System.out.println("Thank you for using our program :)");
                            DoesLoop = 0;
                            UserLoopReference = "N";
                        }
                    }
                    break;
                }
                //Count up each time user searches
                TimeCount++; 

            }
        input.close();
        SummaryMethod(cities,states,maxs,mins,TimeCount,beds, baths);
    }
}
