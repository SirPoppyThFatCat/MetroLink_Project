import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class stationScanner {
    public static void main(String[] args) {
        String path = "Metrolink_times_linecolour(in).csv";
        int columnIndex = 0; // Index of the column to read
        List<String> columnData = scanStations(path, columnIndex);
        System.out.println(columnData);
    }

    public static List<String> scanStations(String filePath, int columnIndex) {
        List<String> columnData = new ArrayList<>();
        //ArrayList<String> stationsData = new ArrayList<>(); to be used later. 
        String toSplitBy = ",";
        try (BufferedReader bufReader = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            while ((line = bufReader.readLine()) != null) {
                String[] values = line.split(toSplitBy);
                if (columnIndex < values.length) {
                    columnData.add(values[columnIndex]);
                }
            }
        } catch (IOException e) {
            System.out.println("ahh shit the file doesn't work"); // need to redo the exemption in the future
        }
        return columnData;
    }
}
