import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class stationFinding {

    static void chooseStations() {
        // System.out.println("the station is this station");
        Scanner myScanner = new Scanner(System.in);
        System.out.println("enter the input station: ");
        String inputStation = myScanner.nextLine();

        System.out.println("enter the destination station: ");
        String destinationStation = myScanner.nextLine();
        // myScanner.close();

        System.out.println(
                "Your entry station is: " + inputStation + " and your destination station is: " + destinationStation);
        stationScanning(inputStation, destinationStation);
    }

    static void stationScanning(String inputStation, String destinationStation) {
        try {
            File stationFilePath = new File("Metrolink_times_linecolour(in).csv");
            // System.out.println("Beans");
            ArrayList<String> stationArray = new ArrayList<String>();
            ArrayList<Connection> connections = new ArrayList<Connection>();

            Scanner stationScanner = new Scanner(stationFilePath);

            while (stationScanner.hasNextLine()) {
                //System.out.println("");
            }

            if (stationArray.contains(destinationStation)) {
                System.out.println("Your destination station is " + destinationStation);
            } else {
                System.out.println("This feature currently is being worked on");
            }
            // System.out.println(stationArray);
        } catch (FileNotFoundException e) {
            System.out.println("bomboclaat no file found");
        }
    }

    public static void main(String[] args) {
        chooseStations();
        // stationScanning();

    }
}