import java.awt.Desktop;
import java.net.URI;
import java.util.Scanner;

public class App {
    public static void WebMethod(String input1, String input2, String input3, String input4)
        throws Exception {
        //Generate each link using the given parameters
        String InputLink1 = "https://www.homes.com/"+input1+"-"+input2+"/?price-min="+input3+"&price-max="+input4;
        String InputLink2 = "https://www.realtor.com/realestateandhomes-search/"+input1+"_"+input2+"/price-"+input3+"-"+input4;
        String InputLink3 = "https://www.trulia.com/for_sale/"+ input1.replaceAll("-", "_") +","+input2+"/" + input3 + "-" + input4 + "_price/";
        String[] inputs = {InputLink1, InputLink2, InputLink3};
        
        //Open new tab for each generated url
        for (int i = 0; i < 3; i++) {
            Desktop desk = Desktop.getDesktop();

            // now we enter our URL that we want to open in our default browser
            String x = inputs[i];
            desk.browse(new URI(x));
        }
    }
    public static void main(String[] args)
        throws Exception {
            //Define variables
            String city, state, min, max, UserLoopReference, UserLoopNo, UserLoopYes;  
            UserLoopReference = UserLoopYes = "Y";  
            UserLoopNo = "N";
            int DoesLoop = 1;
            int TimeCount = 0;
            Scanner input = new Scanner(System.in);

            //Keep looping until user says no
            while (DoesLoop == 1) {

                //Run programs based off of user input (Y, N, or none)
                switch (UserLoopReference){
                    //Runs 
                    case "Y":{
                        //Get user input for city
                        System.out.println("What is your city? (ex. Louisville): ");
                        //If city is empty, ask city again (fixes problem where it skips city after looping)
                        city = null;
                        while (city == null){
                        city = input.nextLine();
                        }
                        if (city == ""){
                            city = input.nextLine();
                        }
                        
                        //If user's city input is more than one word, replace space char with _ char
                        city = city.replaceAll(" ", "-");

                        //Get user's state abbreviations 
                        System.out.print("What is your State? (Examples: NJ, KY, AZ): ");
                        state = input.next();
                        
                        //Get user's desired minimum and maximum price value
                        System.out.println("What is your min and max value");
                        min = input.next();
                        max = input.next();
                        
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
    }
}
