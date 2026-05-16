import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class stationFinding {

    static void chooseStations() {
        // System.out.println("the station is this station");
        Scanner myScanner = new Scanner(System.in);
        System.out.println("----------------------------------------------------------");
        System.out.println("Enter your starting station: ");

        String inputStation = myScanner.nextLine();
        System.out.println("----------------------------------------------------------");

        System.out.println("enter the destination station: ");
        String destinationStation = myScanner.nextLine();
        System.out.println("----------------------------------------------------------");

        myScanner.close();

        // System.out.println("Your entry station is: " + inputStation + " and your
        // destination station is: " + destinationStation);
        stationScanning(inputStation, destinationStation);
    }

    static void stationScanning(String inputStation, String destinationStation) {
        try {
            File stationFilePath = new File("Metrolink_times_linecolour(in).csv");
            // System.out.println("Beans");
            ArrayList<String> stationArray = new ArrayList<String>();
            ArrayList<Connection> connections = new ArrayList<Connection>();

            Scanner stationScanner = new Scanner(stationFilePath);
            String firstline = stationScanner.nextLine();
            String currentLineColour = null;

            while (stationScanner.hasNextLine()) {
                String line = stationScanner.nextLine();
                String[] fields = line.split(",");
                if (fields.length < 3) {
                    continue;
                }

                if (fields[1].isEmpty() && fields[2].isEmpty()) {
                    currentLineColour = fields[0];
                    continue;
                }

                String cameFromStation = fields[0];
                String goingToStation = fields[1];
                double time = Double.parseDouble(fields[2]); // cheeky typecast

                Connection c = new Connection(currentLineColour, cameFromStation, goingToStation, time);
                connections.add(c);

            }
            if (stationExists(inputStation, connections)) {
                System.out.println("Your starting station is: " + inputStation);
            } else {
                System.out.println("Your starting Station: " + inputStation + " has not been found in the network. Please try again" + "\n\n");
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                }
                chooseStations();
            }


            if (stationExists(destinationStation, connections)) {
                System.out.println("Your destination station is " + destinationStation + "\n\n");
            } else {
                System.out.println("Your destination Station: " + destinationStation + " has not been found in the network. Please try again" + "\n\n");
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                }
                chooseStations();
            }

        } catch (FileNotFoundException e) {
            System.out.println("impressive gambit sir, you have managed to not have a file");
        }
    }

    static boolean stationExists(String station, ArrayList<Connection> connections) {
        for (Connection c : connections) {
            if (c.getFromStation().equalsIgnoreCase(station) ||
                    c.getDestinationStation().equalsIgnoreCase(station)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        chooseStations();
        // stationScanning();

    }
}