/* 


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import javax.xml.crypto.Data;

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
System.out.println(txt1.equals(txt2)); use to compare if it's the same  // true

/*int[][] myNumbers = { {1, 4, 2}, {3, 6, 8, 5, 2} };idk

for (int row = 0; row < myNumbers.length; row++) {
  for (int col = 0; col < myNumbers[row].length; col++) {
    System.out.println("myNumbers[" + row + "][" + col + "] = " + myNumbers[row][col]);
  }
} 
adapt for the other array 
            }
        } catch (IOException e) {
            System.out.println("ahh shit the file doesn't work"); // need to redo the exemption in the future
        }
    }
    return columnData;
}
*/