import java.util.Scanner;

class Morse {
  public static String[] codes = { // Letters of the alphabet, expressed as Morse Code
      ".-", // A
      "-...", // B
      "-.-.", // C
      "-..", // D
      ".", // E
      "..-.", // F
      "--.", // G
      "....", // H
      "..", // I
      ".---", // J
      "-.-", // K
      ".-..", // L
      "--", // M
      "-.", // N
      "---", // O
      ".--.", // P
      "--.-", // Q
      ".-.", // R
      "...", // S
      "-", // T
      "..-", // U
      "...-", // V
      ".--", // W
      "-..-", // X
      "-.--", // Y
      "--.." // Z
  };

  public static void main(String[] args) {
    // TASKS A

    // 1 READ the code
    // 2 PREDICT: What does the code display?
    // Type your answer on the line below after the //
    //
    // it will print capital letter from A to Z = morse code for the letter
    //
    // 3 RUN: now click the green Run button above.
    //
    for (int i = (int) 'A'; i <= (int) 'Z'; i++) { // from A to Z (cast as int for the ASCII values)
      int index = i - (int) 'A';
      System.out.printf("%c = %s\n", (char) i, codes[index]);
    }

    // numbers from 0-10
    String[] frenchSpelling = { "zero", "une", "deux", "trois", "quatre", "cinq", "six", "sept", "huit", "neuf",
        "dix" };

    // get the program to display all the numbers up to 10.
    Scanner sc = new Scanner(System.in);
    System.out.print("Please enter a digit (0-10) to spell: ");
    int num = sc.nextInt();

    // program show the correct spelling for the French word for that number.
    System.out.printf("%d - %s\n", num, frenchSpelling[num]);

    /************* End of Code *************/
    sc.close();
  }
}