import java.util.Scanner;

/**
 * Assignment-1-Part-2
 * Program that calculates the volume and the surface area of a cylinder.
 * User inputs radius and height.
 * <br/>
 * <br/>
 * VARIABLE DICTIONARY:
 * <ul>
 * <li>sc (Scanner) = Scanner object to read input</li>
 * <li>radius(double) = radius of cylinder</li>
 * <li>height(double) = width of cylinder</li>
 * <li>squareRadius(double) = square radius</li>
 * <li>volume(double) = volume of cylinder</li>
 * <li>rSurface(double) = surface of cylinder calculation right part</li>
 * <li>lSurface(double) = surface of cylinder calculation left part</li>
 * <li>surface(double) = surface of cylinder</li>
 * </ul>
 * 
 * @author Steven Passynkov (#1058058)
 * @since 8 July 2023
 */
public class Main {
  public static void main(String[] args) {
    // create Scanner object to read from keyboard
    Scanner sc = new Scanner(System.in);

    // Print welcome message
    System.out.println("Cylinder program!");

    // Prompt user to enter radius
    System.out.print("What is the radius of your cylinder (cm)? ");
    // read radius as double
    double radius = sc.nextDouble();

    // Prompt user to enter height
    System.out.print("What is the height of your cylinder (cm)? ");
    // read height as double
    double height = sc.nextDouble();

    // square radius and use it in valume and surface formula
    double squareRadius = Math.pow(radius, 2);
    // calculate volume
    double volume = Math.PI * squareRadius * height;
    // calculate surface: left part
    double lSurface = 2 * Math.PI * radius * height;
    // calculate surface: right part
    double rSurface = 2 * Math.PI * squareRadius;
    // calculate surface: final sum
    double surface = lSurface + rSurface;

    // print volume as double with 2 digits
    System.out.printf("The volume of your cylinder is: %.2f cubic cm\n", volume);
    // print surface area as double with 2 digits
    System.out.printf("The surface area of your cylinder is: %.2f square cm\n", surface);

    // close Scanner to free resources
    sc.close();
  }
}