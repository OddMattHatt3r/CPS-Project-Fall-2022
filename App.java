import java.awt.Desktop;
import java.net.URI;
import java.util.Scanner;
//hi
public class App {
    public static void MyMethod(String input1, String input2, String input3, String input4)
        throws Exception {
        String InputLink1 = "https://www.homes.com/"+input1+"-"+input2+"/?price-min="+input3+"&price-max="+input4;
        String InputLink2 = "https://www.realtor.com/realestateandhomes-search/"+input1+"_"+input2+"/price-"+input3+"-"+input4;
        String InputLink3 = "https://www.trulia.com/for_sale/"+ input1.replaceAll("-", "_") +","+input2+"/" + input3 + "-" + input4 + "_price/";
        String[] inputs = {InputLink1, InputLink2, InputLink3};

        for (int i = 0; i < 3; i++) {
            Desktop desk = Desktop.getDesktop();

            // now we enter our URL that we want to open in our default browser
            String x = inputs[i];
            desk.browse(new URI(x));
        }
    }
    public static void main(String[] args)
        throws Exception {

            String city, state, min, max, UserLoopReference, UserLoopNo, UserLoopYes;  
            UserLoopReference = UserLoopYes = "Y";  
            UserLoopNo = "N";
            int DoesLoop = 1;
            Scanner input = new Scanner(System.in);

            while (DoesLoop == 1) {

                switch (UserLoopReference){
                    case "Y":{
                        System.out.println("What is your city?");
                        city = input.nextLine();
                        city = city.replaceAll(" ", "-");

                        System.out.println("What is your State? (Examples: NJ, KY, AZ): ");
                        state = input.next();
    
                        System.out.println("What is your min and max value");
                        min = input.next();
                        max = input.next();
    
                        MyMethod(city, state, min, max);

                        System.out.print("Would you like to search again? (Enter Y or N):  ");
                        UserLoopReference = input.next();
                    }
                    break;
                    case "N": {
                        System.out.println("Thank you for using our program :)");
                        DoesLoop = 0;
                        UserLoopReference = "N";
                    }
                    break;
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

            
        }
        input.close();
    }
}
