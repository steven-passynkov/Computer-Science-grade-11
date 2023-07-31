import java.util.Scanner;

/**
 * Assignment-1-Part-3
 * Calculate how long it takes in second for one swing using length as user
 * input.
 * <br/>
 * <br/>
 * VARIABLE DICTIONARY:
 * <ul>
 * <li>scanner (Scanner) = Scanner object to read length</li>
 * <li>g(constant double) = Earth's gravitational constant</li>
 * <li>length(double) = length input</li>
 * <li>period(double) = time for one complete swing</li>
 * </ul>
 * 
 * @author Steven Passynkov (#1058058)
 * @since 8 July 2023
 */
public class Main {
  public static void main(String[] args) {
    // create Scanner object to read from keyboard
    Scanner scanner = new Scanner(System.in);

    // Welcome message
    System.out.println("Pendulum program!");
    // Prompt user to enter length
    System.out.print("Please input the length of your pendulum (m): ");
    // Read double from input
    double length = scanner.nextDouble();

    // constant Earth's gravitational as double
    final double g = 9.8;
    // calculate period
    double period = 2 * Math.PI * Math.sqrt(length / g);

    // Print period with 2 digits after period
    System.out.printf("The period of your pendulum is: %.2f seconds.\n", period);

    // close Scanner to free resources
    scanner.close();
  }
}