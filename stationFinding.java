import java.io.*;
import java.util.*;

public class stationFinding {

    static void chooseStations() {
        // System.out.println("the station is this station");
        Scanner myScanner = new Scanner(System.in);
        System.out.println("enter the input station: ");
        String inputStation = myScanner.nextLine();

        System.out.println("enter the destination station: ");
        String destinationStation = myScanner.nextLine();
        myScanner.close();

        System.out.println(
                "Your entry station is: " + inputStation + " and your destination station is: " + destinationStation);
    }

    static void searchStations() {
        // parse into an arraylist for easier searching.
        String csvSplittingValue = ",";
        String line = "";
        // using bufferedReader here. checking sodding CSV file
        //List<List<String>> dataList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Metrolink_times_linecolour(in).csv"))) {

            while ((line = br.readLine()) != null) {
                //System.out.println(line);
                String[] values = line.split(csvSplittingValue);
                List<String> row = new ArrayList<>();
                for (String value : values) {
                    row.add(value);
                }
                //dataList.add(row);
            }

        } catch (IOException e) {
            System.out.println("the file is oer");
        }
        for (List<String> row : dataList) {
            System.out.println(row);
        }
    }

    public static void main(String[] args) {
        // chooseStations();
        searchStations();

    }
}
