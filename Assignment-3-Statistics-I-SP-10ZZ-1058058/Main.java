import java.io.*;
import java.util.Scanner;

/**
 * Assignment-3-Statistics
 * Read values from data.dat file, sort using exchange sort, print Average,
 * Medium, Tallest, Shortest values.
 *
 * VARIABLE DICTIONARY:
 * 
 * scanner (Scanner) = Scanner object to read file
 * numRows (int) = number of rows in file
 * fileName (String) = file name
 * sum (double) = sum of numbers in array
 * temp (double) = swap value
 * average (double) = average of numbers in array
 * medium (double) = medium of array
 * hights (double[]) = array of nymbers from file
 * hight (double) = double number in read file loop
 * index (int) = index in loop read
 * midLowIndex (int) = Index of array split of 2 and firt array and last index
 * midHighIndex (int) = Index of array split of 2 and second array and first
 * index
 * i, j (int) = Conting variable
 * 
 * @author Steven Passynkov (#1058058)
 * @since 26 July 2023
 */
class Main {
  // number of rows in file
  final static int numRows = 50;
  // file name
  final static String fileName = "heights.dat";

  /**
   * Get medium of sorted array using algorithm for even and odd array sizes
   *
   * @param array sorted array
   * @return medium
   */
  static double medium(double[] array) {
    double medium = 0;

    if (array.length % 2 != 0) {
      // odd size - middle value
      medium = array[(array.length / 2)];
    } else {
      // even size
      // Index of array split of 2 and firt array and last index
      int midLowIndex = array.length / 2 - 1;
      // Index of array split of 2 and second array and first index
      int midHighIndex = array.length / 2;
      // average them
      medium = (array[midLowIndex] + array[midHighIndex]) / 2;
    }

    // return medium
    return medium;
  }

  /**
   * Calculate average
   *
   * @param array Array of double
   * @return average
   */
  static double average(double[] array) {
    double sum = 0;

    // loop over array
    for (int i = 0; i < array.length; i++) {
      // sum values
      sum = sum + array[i];
    }

    // average them
    double average = sum / numRows;
    // return average
    return average;
  }

  /**
   * Exchange sort of array
   *
   * @param array Array of double
   * @return sorted array
   */
  static void sort(double[] array) {
    // swap value
    double temp = 0;

    // loop i from 0 to n-1
    for (int i = 0; i < array.length - 1; i++) {
      // loop j from i+1 to n-1
      for (int j = i + 1; j < array.length - 1; j++) {
        if (array[i] > array[j]) {
          // swap ia[i] for ia[j]
          temp = array[i];
          array[i] = array[j];
          array[j] = temp;
        }
      }
    }
  }

  /**
   * Read file to array and return array
   *
   * @return array of heights from file
   */
  static double[] readHights() {
    double[] hights = new double[numRows];

    try {
      // open scanner with file
      Scanner sc = new Scanner(new File(fileName));
      // index of array
      int index = 0;
      // while read line
      while (sc.hasNextLine()) {
        // get double height
        double hight = sc.nextDouble();
        // put height to array
        hights[index] = hight;
        // increase index
        index++;
      }
      // close Scanner
      sc.close();
    } catch (Exception e) {
      // print exception if error
      System.out.println(e.getMessage());
      // exit since can't read file
      System.exit(0);
    }

    return hights;
  }

  public static void main(String[] args) {
    // read file to array
    double[] hights = readHights();
    // sort array
    sort(hights);

    // Print average
    System.out.printf("Average: %.1f cm \n", average(hights));
    // Print medium
    System.out.printf("Medium: %.1f cm \n", medium(hights));
    // Print Tallest that is last element in sorted array
    System.out.printf("Tallest: %.1f cm \n", hights[hights.length - 1]);
    // Print Shortest that is first element in sorted array
    System.out.printf("Shortest: %.1f cm \n", hights[0]);
  }
}