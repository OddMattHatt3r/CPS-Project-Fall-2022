import java.awt.Desktop;
import java.io.*;
import java.net.URI;
import java.util.Scanner;

public class App {
    public static void main(String[] args)
        throws Exception
    {

        Scanner input = new Scanner(System.in);

        //Get user location
        System.out.println("What is your city?");
        String location = input.next();

        System.out.println("What is your State?");
        String state = input.next();


        System.out.println("What is your min and max value");
        String min = input.next();
        String max = input.next();

        String InputLink1 = "https://www.homes.com/"+location+"-"+state+"/?price-min="+min+"&price-max="+max;
        String InputLink2 = "https://www.trulia.com/for_sale/"+location+","+state+"/" + min + "-" + max + "_price/";
        String InputLink3 = "https://www.realtor.com/realestateandhomes-search/"+location+"_"+state+"/price-"+min+"-"+max;
        String[] inputs = {InputLink1, InputLink2, InputLink3};


        for (int i = 0; i < 3; i++) {

            Desktop desk = Desktop.getDesktop();
        
            // now we enter our URL that we want to open in our default browser
            //System.out.println(InputLink);
            String x = inputs[i];

            desk.browse(new URI(x));
        }
    }
}
