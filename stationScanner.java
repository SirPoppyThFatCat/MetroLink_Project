import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class stationScanner {

    public static void scanStations() {
        try (BufferedReader bufReader = new BufferedReader(new FileReader("Metrolink_times_linecolour(in).csv"))) { 
            String line;
            while ((line = bufReader.readLine()) != null) {
                String[] values = line.split(",")
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("ahh shit the file doesn't work"); // need to redo the exemption in the future
        }
    }
}

