
import java.util.Scanner;

public class commandLineInterface {
    public static void main(String[] args) {
        boolean correctStart = false;
        boolean correctDestination = false;
        
            Scanner stations = new Scanner(System.in);
            // vars for the user to input the station
            System.out.println("Enter your starting station: ");
            String inputStation = stations.nextLine().trim().toLowerCase(); // 
            stationScanner input = new stationScanner(inputStation);

          


            //String inputStation = trimmed.toLowerCase(); 
            //  Convert to uppercase
            // then do stationScanner.scanStations(inputStation)

            System.out.println("Enter your destination station: ");
            String destinationStation = stations.nextLine().trim().toLowerCase(); // 
           //String destinationStation= trimmed.toLowerCase(); // Convert to
                                                             // uppercase

            System.out.println("Your starting station is: " + inputStation + " and your destination station is: " + destinationStation); // temporary, sanity checking for myself
            System.out.println("beans");
            // stationScanner.scanStations();

        //} while (!correctStart || !correctDestination == false);
        public String getInputStation(){
            return inputStation;
           }

    }
    


}
