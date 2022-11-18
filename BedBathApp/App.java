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

    public static void WebMethod(String input1, String input2, Integer input3, Integer input4, Integer input5, Integer input6)
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
            int min, max, bed, bath;
            UserLoopReference = UserLoopYes = "Y";
            UserLoopNo = "N";
            int DoesLoop = 1, TimeCount = 0;
            ArrayList<String> cities = new ArrayList<String>();
            ArrayList<String> states = new ArrayList<String>();
            ArrayList<Integer> mins = new ArrayList<Integer>();
            ArrayList<Integer> maxs = new ArrayList<Integer>();
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
                        cities.add(city);
                        //If user's city input is more than one word, replace space char with _ char
                        city = city.replaceAll(" ", "-");

                        //Get user's state (both abbreviation and state name accepted) 
                        System.out.print("What is your State? (Examples: NJ or New Jersey): ");
                        state = input.nextLine();

                        //Replaces state name with abbreviation
                        switch(state){
                            case "Alabama":{
                                state = "AL";
                            } break;

                            case "Alaska":{
                                state = "AK";
                            } break;

                            case "Arizona":{
                                state = "AZ";
                            } break;

                            case "Arkansas":{
                                state = "AR";
                            } break;

                            case "California":{
                                state = "CA";
                            } break;

                            case "Colorado":{
                                state = "CO";
                            } break;

                            case "Connecticut":{
                                state = "CT";
                            } break;

                            case "Delaware":{
                                state = "DE";
                            } break;

                            case "Florida":{
                                state = "FL";
                            } break;

                            case "Georgia":{
                                state = "GA";
                            } break;

                            case "Hawaii":{
                                state = "HI";
                            } break;

                            case "Idaho":{
                                state = "ID";
                            } break;

                            case "Illinois":{
                                state = "IL";
                            } break;

                            case "Indiana":{
                                state = "IN";
                            } break;
                            
                            case "Iowa":{
                                state = "IA";
                            } break;

                            case "Kansas":{
                                state = "KS";
                            } break;

                            case "Kentucky":{
                                state = "KY";
                            } break;

                            case "Louisiana":{
                                state = "LA";
                            } break;

                            case "Maine":{
                                state = "ME";
                            } break;

                            case "Maryland":{
                                state = "MD";
                            } break;

                            case "Massachusetts":{
                                state = "MA";
                            } break;

                            case "Michigan":{
                                state = "MI";
                            } break;

                            case "Minnesota":{
                                state = "MN";
                            }

                            case "Mississippi":{
                                state = "MS";
                            } break;

                            case "Missouri":{
                                state = "MO";
                            } break;

                            case "Montana":{
                                state = "MT";
                            } break;

                            case "Nebraska":{
                                state = "NE";
                            } break;

                            case "Nevada":{
                                state = "NV";
                            } break;

                            case "New Hampshire":{
                                state = "NH";
                            } break;

                            case "New Jersey":{
                                state = "NJ";
                            } break;

                            case "New Mexico":{
                                state = "NM";
                            } break;

                            case "New York":{
                                state = "NY";
                            } break;

                            case "North Carolina":{
                                state = "NC";
                            } break;

                            case "North Dakota":{
                                state = "ND";
                            } break;

                            case "Ohio":{
                                state = "OH";
                            } break;

                            case "Oklahoma":{
                                state = "OK";
                            } break;

                            case "Oregon":{
                                state = "OR";
                            } break;

                            case "Pennsylvania":{
                                state = "PA";
                            } break;

                            case "Rhode Island":{
                                state = "RI";
                            } break;

                            case "South Carolina":{
                                state = "SC";
                            } break;

                            case "South Dakota":{
                                state = "SD";
                            } break;

                            case "Tennessee":{
                                state = "TN";
                            } break;

                            case "Texas":{
                                state = "TX";
                            } break;

                            case "Utah":{
                                state = "UT";
                            } break;

                            case "Vermont":{
                                state = "VT";
                            } break;

                            case "Virginia":{
                                state = "VA";
                            } break;

                            case "Washington":{
                                state = "WA";
                            } break;

                            case "West Virginia":{
                                state = "WV";
                            } break;

                            case "Wisconsin":{
                                state = "WI";
                            } break;

                            case "Wyoming":{
                                state = "WY";
                            }
                        }
                        states.add(state);
                        
                        //Get user's desired minimum price value
                        System.out.println("What is your minimum price range? (ex. 3000000): ");
                        min = input.nextInt();
                        mins.add(min);

                        //Get user's desired maximum price value
                        System.out.println("What is your maximum price range? (ex. 5000000): ");
                        max = input.nextInt();
                        maxs.add(max);

                        //Get user input for minimum number of bedrooms
                        System.out.println("What is your desired number of bedrooms? (ex. 3): ");
                        bed = input.nextInt();
                        //not sure bout this
                        if(bed > 5){
                            bed = 5;
                        }
                        beds.add(bed);

                        //Get user input for minimum number of baths
                        System.out.println("What is your desired number of baths? (ex. 2): ");
                        bath = input.nextInt();
                        //not sure bout this
                        if(bath > 5){
                            bath = 5;
                        }
                        baths.add(bath);

                        //Call Method that creates and opens the links
                        WebMethod(city, state, min, max, bed, bath);

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
        System.out.println(beds);
        System.out.println(baths);
        CitySummaryMethod(cities);
    }
}
