
import java.util.Scanner;

public class commandLineInterface {
    public static void main(String[] args) {
        boolean correctStart = false;
        boolean correctDestination = false;
        do {
            Scanner stations = new Scanner(System.in);
            // vars for the user to input the station
            System.out.println("Enter your starting station: ");
            String inputStation = stations.nextLine().trim().toLowerCase(); // 
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

        } while (!correctStart || !correctDestination == false);

    }
}

/*
 * public class stationScanner {
 * public static void scanStations() {
 * try (BufferedReader bufReader = new BufferedReader(new
 * FileReader("Metrolink_times_linecolour(in).csv"))) {
 * String line;
 * while ((line = bufReader.readLine()) != null) {
 * System.out.println(line);
 * }
 * } catch (IOException e) {
 * System.out.println("ahh shit the file doesn't work"); // need to redo the
 * exemption in the future
 * }
 * }
 * }
 * 
 */