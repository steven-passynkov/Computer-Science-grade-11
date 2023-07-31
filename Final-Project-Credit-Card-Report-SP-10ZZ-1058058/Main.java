import java.util.Scanner;
import java.io.*;

/**
 * Final-Project-Credit-Card-Report
 * Read file with name, credit card, exp date and print to console and file only
 * expired and about to expire rows with expire status.
 *
 * VARIABLE DICTIONARY:
 * 
 * ANSI_RESET (String) = ANSI to reset to normal text
 * ANSI_RED (String) = ANSI for red color
 * ANSI_YELLOW (String) = ANSI for red yellow
 * sc (Scanner) = Scanner object to read file
 * numRow (int) = number of rows in input file
 * inputFileName (String) = file name to read
 * outputFileName (String) = file name to write
 * today (int) = today date YYYYMM
 * i, j, k (int) = Counting variables
 * lines (String[]) = array of lines in input file
 * writer (PrintWriter) = PrintWriter for output
 * file (PrintWriter) = PrintWriter for output file
 * cons (PrintWriter) = PrintWriter for console
 * format (String) = format string for output
 * expDate (int) = Expire date
 * status (String) = Status of row based on expire date
 * half (String[]) = Half array in merge sort
 * half (int[]) = Half array in merge sort
 * leftSize (int) = Size of left array in merge sort
 * rightSize (int) = Size of right array in merge sort
 * inputLength(int) = Size of expire array in merge sort
 * name(String[]) = Array of names
 * creditNum(String[]) = Array of credit numebers
 * expiry(int[]) = Array of expre dates
 * month(int) = Month of each row
 * year(int) = Year of each row
 * Also look at all functions for them param description
 * 
 * @author Steven Passynkov (#1058058)
 * @since 26 July 2023
 */
class Main {
  // resets to normal text
  final static String ANSI_RESET = "\u001B[0m";
  // makes the color yellow
  final static String ANSI_YELLOW = "\u001B[33m";
  // makes the color red
  final static String ANSI_RED = "\u001B[31m";
  // name of input file
  final static String inputFileName = "data.dat";
  // name of output file
  final static String outputFileName = "output.dat";
  // current yeardate
  // Not verry robust because the date is hard coded. more robust would be:
  // int date = currentDate.getYear() + currentDate.getMonth();
  final static int today = 202307;
  // number of rows in input file
  final static int numRow = 100;

  /**
   * Read lines from file
   *
   * @return Array of lines
   */
  static String[] readData() {
    // array of lines
    String[] lines = new String[numRow];

    try {
      // read from file using Scanner
      Scanner sc = new Scanner(new File(inputFileName));
      // read line by line till numRow and save to array
      for (int i = 0; i < numRow; i++) {
        lines[i] = sc.nextLine();
      }
      // close scnanner
      sc.close();
    } catch (Exception e) {
      // if error show and exit
      System.out.println(e.getMessage());
      System.exit(0);
    }

    // return lines
    return lines;
  }

  /**
   * Return card status depends on expire date
   *
   * @param color   Should status color
   * @param expDate Int value of date
   * @return status if expDate less than date -> EXPIRED; if equal => RENEW
   *         IMMEDIATELY
   */
  static String getStatus(int expDate, boolean color) {
    // if expDate less than today -> EXPIRED
    if (expDate < today) {
      // show in color red if color
      if (color) {
        return ANSI_RED + "EXPIRED" + ANSI_RESET;
      } else {
        return "EXPIRED";
      }
    }
    // if equal => RENEW IMMEDIATELY
    if (expDate == today) {
      // show in color red if color
      if (color) {
        return ANSI_YELLOW + "RENEW IMMEDIATELY" + ANSI_RESET;
      } else {
        return "RENEW IMMEDIATELY";
      }
    }
    return "";
  }

  /**
   * Write data to PrintWriter
   *
   * @param writer    PrintWriter to write to
   * @param color     Should status color
   * @param expire    Array of expire dates
   * @param name      Array of names
   * @param creditNum Array of credit numbers
   */
  static void writeData(PrintWriter writer, boolean color, int expire[], String name[],
      String creditNum[]) {
    // print header
    writer.println("NAME                Card Number         Expiry   Status");

    // create a format for line. Align to left
    String format = "%-20s%-20s%-9d%-10s\n";
    // loop over array
    for (int i = 0; i < expire.length; i++) {
      // get expire date
      int expDate = expire[i];

      // expDate less than today break since the array is sorted and
      // it means all other data are not expired
      if (expDate > today) {
        break;
      }
      // get status of card by expDate with color or not
      String status = getStatus(expDate, color);
      // print name, credit card, expire date and status
      writer.printf(format, name[i] + ":", "#" + creditNum[i], expDate, status);
    }
  }

  /**
   * Create array String for right side of mergeSort split
   *
   * @param end   End index
   * @param start Start index
   * @param array The whole array where copy from
   * @return Created array
   */
  static String[] getRightString(int end, int start, String[] array) {
    // create array with len = end-start
    String[] half = new String[end - start];
    // copy from start to end from array to half
    for (int i = start; i < end; i++) {
      half[i - start] = array[i];
    }
    // return array
    return half;
  }

  /**
   * Create array int for right side of mergeSort split
   *
   * @param end   End index
   * @param start Start index
   * @param array The whole array where copy from
   * @return Created array
   */
  static int[] getRightInt(int end, int start, int[] array) {
    // create array with len = end-start
    int[] half = new int[end - start];
    // copy from start to end from array to half
    for (int i = start; i < end; i++) {
      half[i - start] = array[i];
    }
    // return array
    return half;
  }

  /**
   * Create array String for left side of mergeSort split
   *
   * @param len   End index to copy left
   * @param array The whole array where copy from
   * @return Created array
   */
  static int[] getLeftInt(int len, int[] array) {
    // create array with len
    int[] half = new int[len];
    // copy from 0 to len from array to half
    for (int i = 0; i < len; i++) {
      half[i] = array[i];
    }
    // return array
    return half;
  }

  /**
   * Create array int for left side of mergeSort split
   *
   * @param len   End index to copy left
   * @param array The whole array where copy from
   * @return Created array
   */
  static String[] getLeftString(int len, String[] array) {
    // create array with len
    String[] half = new String[len];
    // copy from 0 to len from array to half
    for (int i = 0; i < len; i++) {
      half[i] = array[i];
    }
    // return array
    return half;
  }

  /**
   * Merge left and right arrays to array
   *
   * @param expire             Expire date array
   * @param name               Name array
   * @param creditNum          Credit card array
   * @param leftHalfExpire     Left sorted Expire date array to merge
   * @param rightHalfExpire    right sorted Expire date array to merge
   * @param leftHalfName       Left sorted name array to merge
   * @param rightHalfName      Right sorted name array to merge
   * @param leftHalfCreditNum  Left sorted credit card num array to merge
   * @param rightHalfCreditNum Right sorted credit card num array to merge
   */
  static void merge(
      int[] expire, int[] leftHalfExpire, int[] rightHalfExpire,
      String[] name, String[] leftHalfName, String[] rightHalfName,
      String[] creditNum, String[] leftHalfCreditNum, String[] rightHalfCreditNum) {

    // length or leftHalfExpire and rightHalfExpire arrays
    int leftSize = leftHalfExpire.length;
    int rightSize = rightHalfExpire.length;

    // i - index in left array, j = index in right array, k - index in final expire
    // array
    int i = 0, j = 0, k = 0;

    // run over left and right elements till one of them not empty
    while (i < leftSize && j < rightSize) {
      // if left less than right (compare with expire data)
      if (leftHalfExpire[i] <= rightHalfExpire[j]) {
        // use left element since it less

        // add left exp date to final array
        expire[k] = leftHalfExpire[i];
        // add left name to final array
        name[k] = leftHalfName[i];
        // add left credit num to final array
        creditNum[k] = leftHalfCreditNum[i];
        // go to next element in left array
        i++;
      } else {
        // use right element since it less

        // add right exp date to final array
        expire[k] = rightHalfExpire[j];
        // add right name to final array
        name[k] = rightHalfName[j];
        // add right credit num to final array
        creditNum[k] = rightHalfCreditNum[j];
        // go to next elemt in right array
        j++;
      }
      // +1 for final array index
      k++;
    }

    // right array empty . copy rest of leftHalf if did not use it
    while (i < leftSize) {
      expire[k] = leftHalfExpire[i];
      name[k] = leftHalfName[i];
      creditNum[k] = leftHalfCreditNum[i];
      i++;
      k++;
    }

    // left array empty. copy rest of rightHalf if did not use it
    while (j < rightSize) {
      expire[k] = rightHalfExpire[j];
      name[k] = rightHalfName[j];
      creditNum[k] = rightHalfCreditNum[j];
      j++;
      k++;
    }
  }

  /**
   * Merge Sort for expire array. Pass name and creditNum arrays to move elements
   * so exp date corresponds to name and credit card number.
   * It would be so much easy to pass just class that has all data or 2D array but
   *
   * @param expire    Expire date array
   * @param name      Name array
   * @param creditNum Credit card array
   */
  static void mergeSort(int[] expire, String[] name, String[] creditNum) {
    int inputLength = expire.length;
    // array size 1; nothing to do; already sorted
    if (inputLength < 2) {
      return;
    }

    // divide the list into upper and lower halves
    int midIndex = inputLength / 2;
    // upper gets elements from A[0] to A[r / 2]
    int[] leftHalfExpire = getLeftInt(midIndex, expire);
    // lower gets the rest of array A
    int[] rightHalfExpire = getRightInt(inputLength, midIndex, expire);

    // devide name array as well
    String[] leftHalfName = getLeftString(midIndex, name);
    String[] rightHalfName = getRightString(inputLength, midIndex, name);

    // devide creditNum array as well
    String[] leftHalfCreditNum = getLeftString(midIndex, creditNum);
    String[] rightHalfCreditNum = getRightString(inputLength, midIndex, creditNum);

    // continue mergeSort left arrays
    mergeSort(leftHalfExpire, leftHalfName, leftHalfCreditNum);
    // continue mergeSort right arrays
    mergeSort(rightHalfExpire, rightHalfName, rightHalfCreditNum);

    // upper and lower are sorted - merge
    merge(expire, leftHalfExpire, rightHalfExpire,
        name, leftHalfName, rightHalfName,
        creditNum, leftHalfCreditNum, rightHalfCreditNum);
  }

  public static void main(String[] args) {
    // read lines from file
    String[] lines = readData();

    // array of names
    String[] name = new String[numRow];
    // array of credit numbers
    String[] creditNum = new String[numRow];
    // array of expire dates
    int[] expiry = new int[numRow];

    // loop over lines
    for (int i = 0; i < lines.length; i++) {
      // split line by ","
      String[] tokens = lines[i].split(",");
      // tokens[0] save to name array
      name[i] = tokens[0];
      // tokens[1] ave to creditNum array
      creditNum[i] = tokens[1];

      // parse int as tokens[2] - this is month
      int month = Integer.parseInt(tokens[2]);
      // parse int as tokens[3] - this is year
      int year = Integer.parseInt(tokens[3]);
      // calculate date as YYYYMM and put in expire array
      expiry[i] = year * 100 + month;
    }

    // do mergeSort, compare exp date.
    // pass other arrays to move elements so exp date corresponds to name and credit
    // card number
    mergeSort(expiry, name, creditNum);

    try {
      // open file
      PrintWriter file = new PrintWriter(outputFileName);
      // print data into file
      writeData(file, false, expiry, name, creditNum);
      // close file
      file.close();

      // open console
      PrintWriter cons = new PrintWriter(System.out, true);
      // print data into console
      writeData(cons, true, expiry, name, creditNum);
    } catch (IOException e) {
      // if failed to write output
      System.out.println(e.getMessage());
    }
  }
}