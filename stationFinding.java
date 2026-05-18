
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class stationFinding {

    @SuppressWarnings("resource")
    static void chooseStations() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("----------------------------------------------------------");
        System.out.println("Enter your starting station: ");
        String inputStation = myScanner.nextLine();

        System.out.println("----------------------------------------------------------");

        System.out.println("----------------------------------------------------------");

        System.out.println("Enter your ending station: ");
        String destinationStation = myScanner.nextLine();

        System.out.println("----------------------------------------------------------");

        System.out.println("----------------------------------------------------------");

        stationScanning(inputStation, destinationStation);
    }
    // ----------------------------------------------- wooo spooky linebreak wooo
    // spooooooky woooo spoooooky new feature

    static void stationScanning(String inputStation, String destinationStation) {
        try {
            File stationFilePath = new File("Metrolink_times_linecolour(in).csv");
            ArrayList<Connection> connections = new ArrayList<Connection>();

            Scanner stationScanner = new Scanner(stationFilePath);
            String firstline = stationScanner.nextLine(); // ignore
            String currentLineColour = null;

            while (stationScanner.hasNextLine()) {
                String line = stationScanner.nextLine();
                String[] fields = line.split(",", -1);
                if (fields.length < 3) {
                    continue;
                }

                if (fields[1].trim().isEmpty() && fields[2].trim().isEmpty()) {
                    currentLineColour = fields[0].trim();
                    continue;
                }

                String cameFromStation = fields[0];
                String goingToStation = fields[1];
                double time = Double.parseDouble(fields[2]); // cheeky typecast

                Connection c = new Connection(currentLineColour, cameFromStation, goingToStation, time);
                connections.add(c);
            }
                GraphList<String> graph = new GraphList<String>();
                graph.buildGraph(connections);
                // graph.print();

                // ---------------------------------------- build djikstra
                List<String> path = Djikstra.djikstraPath(graph, inputStation, destinationStation);
                double totalTime = Djikstra.computeJourneyTime(graph, path);
                List<String> lineChangeInstructions = Djikstra.computeLineInstructions(graph, path);

                System.out.println("Shortest Time Route:");
                for (String station : path) {
                    System.out.println(station);
                }

                System.out.println("Total journey time with line changes is: " + totalTime);
                System.out.println("\nLine Instructions:");
                for (String s : lineChangeInstructions) {
                    System.out.println(" - " + s);
                }

            
            if (stationExists(inputStation, connections)) {
                System.out.println("Your starting station is: " + inputStation);
            } else {
                System.out.println("Your starting Station: " + inputStation
                        + " has not been found in the network. Please try again");
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                }
                chooseStations();
            }

            if (stationExists(destinationStation, connections)) {
                System.out.println("Your destination station is: " + destinationStation + "");
                System.out.println("----------------------------------------------------------");
                System.out.println("Your journey will be between " + inputStation + " and " + destinationStation);

            } else {
                System.out.println("Your destination Station: " + destinationStation
                        + " has not been found in the network. Please try again");
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
            if (c.getFromStation().equalsIgnoreCase(station) || c.getDestinationStation().equalsIgnoreCase(station)) {
                return true;
            }
        }
        return false;

        // ----------------------------------------------- wooo spooky linebreak wooo
        // spooooooky woooo spoooooky new feature
    }

    public static void main(String[] args) {
        chooseStations();
    }
}
