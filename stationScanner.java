import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;

public class stationScanner {

   public static void main(String[] args) {
    scanStations("pomona"); // temporary test
}


    public static void scanStations(String InputStation) {
        
        String path = "Metrolink_times_linecolour(in).csv";

        try (BufferedReader bufReader = Files.newBufferedReader(Paths.get(path))) {
            String line = "";
            while ((line = bufReader.readLine()) != null) {
                
                String[] values = line.split(",");
                if(values.length>2){ //use for-each loop?
                System.out.println(values[0].trim().toLowerCase().contains(commandLineInterface.InputStation));}//use switch case?
//System.out.println(txt1.equals(txt2));  // true


            }
        } catch (IOException e) {
            System.out.println("ahh shit the file doesn't work"); // need to redo the exemption in the future
        }
    }
    // return columnData;
}
