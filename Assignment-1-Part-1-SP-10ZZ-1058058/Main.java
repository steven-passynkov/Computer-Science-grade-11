import java.util.Scanner;

/**
 * Assignment-1-Part-1
 * Program computes the area (integer) of a rectangle.
 * User inputs length and width.
 * <br/>
 * <br/>
 * VARIABLE DICTIONARY:
 * <ul>
 * <li>sc (Scanner) = Scanner object to read input</li>
 * <li>height(int) = height of rectangle</li>
 * <li>width(int) = width of rectangle</li>
 * <li>area(int) = area of rectangle</li>
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
    System.out.println("Welcome to the Rectangle Area Calculator!");
    
    // Prompt user to enter length
    System.out.print("Please enter a length: ");
    // read height as int
    int length = sc.nextInt();
    
    // Prompt user to enter width
    System.out.print("Please enter a width: ");
    // read width as int
    int width = sc.nextInt();
    
    // calculate area
    int area = length * width;
    // print area as int
    System.out.printf(
        "The area of the rectangle of length %d and width %d is %d\n",
        length, width, area);
    
    // close Scanner to free resources
    sc.close();
  }
}