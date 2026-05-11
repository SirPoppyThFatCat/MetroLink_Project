import java.io.FileReader;
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
    }

    static void stationScanning() {
        String stationFilePath = ("Metrolink_times_linecolour(in).csv");
        System.out.println("Beans");
        ArrayList<String> stationArray = new ArrayList<String>();
        Scanner stationScanner = new Scanner(new FileReader("Metrolink_times_linecolour(in).csv"))
.useDelimiter(",");
        String line = stationScanner.nextLine();
        


        
        

        System.out.println(stationArray);
    }

    public static void main(String[] args) {
        // chooseStations();
        stationScanning();

    }
}