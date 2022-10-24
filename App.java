import java.awt.Desktop;
import java.io.*;
import java.net.URI;
import java.util.Scanner;

class App {
    public static void main(String[] args)
             throws Exception
    {

        Scanner input = new Scanner(System.in);

        System.out.println("What is your min and max value");
        String min = input.next();
        String max = input.next();

        String InputLink1 = "https://www.zillow.com/homes/for_sale/?searchQueryState=%7B%22usersSearchTerm%22%3A%22Piscataway%2C+NJ%22%2C%22mapBounds%22%3A%7B%22west%22%3A-74.58253935009765%2C%22east%22%3A-74.34564664990233%2C%22south%22%3A40.46220710136461%2C%22north%22%3A40.64089872385952%7D%2C%22regionSelection%22%3A%5B%7B%22regionId%22%3A398893%2C%22regionType%22%3A6%7D%5D%2C%22filterState%22%3A%7B%22price%22%3A%7B%22min%22%3A" + min + "%2C%22max%22%3A" + max + "%7D%2C%22mp%22%3A%7B%22min%22%3A1036%2C%22max%22%3A2590%7D%2C%22sort%22%3A%7B%22value%22%3A%22globalrelevanceex%22%7D%2C%22ah%22%3A%7B%22value%22%3Atrue%7D%7D%2C%22mapZoom%22%3A12%2C%22savedSearchEnrollmentId%22%3A%22X1-SSh5n3squressa0000000000_8uv2g%22%7D";
        String InputLink2 = "https://www.trulia.com/for_sale/Union,NJ/" + min + "-" + max + "_price/";
        String InputLink3 = "https://www.realtor.com/realestateandhomes-search/Piscataway_NJ/price-"+min+"-"+max;
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
