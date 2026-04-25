
import java.util.Scanner;



public class commandLineInterface {
    public static void main(String[] args) {
        Scanner routeInput = new Scanner(System.in);
        Scanner routeDestination = new Scanner(System.in);
        // vars for the user to input the station
        System.out.println("Enter your starting station: ");
        String inputStation = routeInput.nextLine();

        System.out.println("Enter your destination station: ");
        String destinationStation = routeDestination.nextLine();

        System.out.println("Your starting station is: " + inputStation + " and your destination station is: " + destinationStation); // temporary, sanity checking for myself
        System.out.println("beans");
    }
}