import java.util.Scanner;

public class stationFinding {

    static void chooseStations() {
        //System.out.println("the station is this station");
        Scanner myScanner = new Scanner(System.in);
        System.out.println("enter the input station: ");
        String inputStation = myScanner.nextLine();
        System.out.println("enter the destination station: ");
        String destinationStation = myScanner.nextLine();
        myScanner.close();
        System.out.println("Your entry station is: " + inputStation + " and your destination station is: " + destinationStation);
    }
    static void searchStations(){

    }

    public static void main(String[] args) {
        chooseStations();
        searchStations();
    }

}
