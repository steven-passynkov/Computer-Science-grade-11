import java.util.Scanner;

/**
 * Assignment-2
 * The Collatz Conjecture. Print Collatz Conjecture sequences for user
 * input number.
 * Print max number in sequence and terms in the seq.
 * Validate that user inputs positive number
 * Do calculation of the Collatz Conjecture in a loop while user decides to stop
 * by saying N
 *
 * <br/>
 * <br/>
 * VARIABLE DICTIONARY:
 * <ul>
 * <li>sc (Scanner) = Scanner object to read input</li>
 * <li>n (int) = User input for number as number</li>
 * <li>terms (int) = Number of terms in sequence</li>
 * <li>max (int) = max number in sequence</li>
 * <li>newN (int) = Next seq number (recursion)</li>
 * <li>newTerm (int) = Next terms value (recursion)</li>
 * <li>newMax (int) = Next max number (recursion)</li>
 *
 * <li>isContinue (String) = user choice to continue or not</li>
 * </ul>
 * 
 * @author Steven Passynkov (#1058058)
 * @since 17 July 2023
 */
public class Main {

  /**
   * Get positive integer number from user. Show a message if user enter not
   * positive number and continue asking.
   * 
   * @param sc Scanner
   * @return positive integer number
   */
  public static int getInput(Scanner sc) {
    // number define
    int n = 0;

    // loop till get positive number
    while (true) {
      // ask to input
      System.out.print("Enter a whole number > 0: ");
      // red input
      n = sc.nextInt();
      // check that number is larger than 0
      if (n > 0) {
        // break while since we get positive number
        break;
      } else {
        // print error message that number should be positive
        System.out.printf("%d is not a valid entry. Please enter a whole number greater then zero.\n", n);
      }
    }

    // return number
    return n;
  }

  /**
   * Print a Collatz collection with just basic while/if.
   *
   * @param n Number
   */
  public static void collatzConjecture(int n) {
    // count for terms
    int terms = 0;
    // max number in sequence
    int max = 1;

    // loop till break
    while (true) {
      // increase number of terms
      terms++;

      // if last just print it
      if (n == 1) {
        System.out.printf("%d ", n);
      } else {
        // if not last one print number with separator
        System.out.printf("%,d; ", n);
      }
      // break at 1 becuase of it get to infinitive loop
      if (n == 1) {
        break;
      }
      // if even. even number is %2 is 0
      if (n % 2 == 0) {
        n = n / 2;
      } else {
        // for odd number
        n = n * 3 + 1;
      }

      // reassign n to keep max
      if (n > max) {
        max = n;
      }
    }

    // print new line after all numbers
    System.out.println();
    // print number of terms
    System.out.printf("Number of terms = %,d \n", terms);
    // print max number
    System.out.printf("Highest value reached = %,d \n", max);
  }

  /**
   * Print a Collatz collection using recursion
   *
   * @param n    Current number in Collatz collection
   * @param term Current term number
   * @param max  Current max number
   */
  public static void collatzConjectureWithRecursion(int n, int term, int max) {
    int newN = n;
    int newTerm = term;
    int newMax = max;

    newTerm++;

    if (n == 1) {
      System.out.printf("%d ", n);
    } else {
      // if not last one print number with separator
      System.out.printf("%,d; ", n);
    }

    if (n == 1) {
      // print new line after all numbers
      System.out.println();
      // print number of terms
      System.out.printf("Number of terms = %,d \n", newTerm);
      // // print max number
      System.out.printf("Highest value reached = %,d \n", newMax);
      // stop recursion
      return;
    } else if (n % 2 == 0) {
      // if even. even number is %2 is 0
      newN = n / 2;
    } else {
      // for odd number
      newN = n * 3 + 1;
    }

    if (newN > max) {
      newMax = n;
    }

    collatzConjectureWithRecursion(newN, newTerm, newMax);
  }

  public static void main(String[] args) {
    // open scanner
    Scanner sc = new Scanner(System.in);
    // loop till user says 'n'
    while (true) {
      // get number
      int n = getInput(sc);

      // print header
      System.out.printf("The Collatz sequence for n = %,d is: ", n);

      // do collatzConjecture call for n using while
      // collatzConjecture(n);

      // !!!! i wrote this myself !!!!!
      // do collatzConjecture call for n using recursion
      // you can uncomment and see.
      collatzConjectureWithRecursion(n, 0, n);

      // ask if he wants to continue
      System.out.print("Do another? (y/n) ");
      // read answer
      String isContinue = sc.next();
      // if user says n or N
      if (isContinue.toLowerCase().equals("n")) {
        // print goobye
        System.out.println("Goodbye!");
        // leab
        break;
      }
    }

    // close scanner
    sc.close();
  }
}