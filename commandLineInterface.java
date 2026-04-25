
import java.util.Scanner;



public class commandLineInterface {
    public static void main(String[] args) {
        Scanner routeInput = new Scanner(System.in);
        Scanner routeDestination = new Scanner(System.in);
        System.out.println("Enter your start destination");
        String inputStation = routeInput.nextLine();
        String destinationStation = routeDestination.nextline();
        System.out.println("Your input station is: " + inputStation + " yes");
        System.out.println();
    }
}