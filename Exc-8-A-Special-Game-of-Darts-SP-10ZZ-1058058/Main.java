/**
 * Exc-8-A-Special-Game-of-Darts
 * Do A Special Game of Darts using recursion
 * 
 * @author Steven Passynkov (#1058058)
 * @since 21 July 2023
 */
class Main {
  // win number
  static int win = 0;
  // maximum wins
  final static int maxWin = 8;

  /**
   * Print sequence with + between
   *
   * @param seq Array of int
   */
  static void printSeq(int[] seq) {
    for (int i = 0; i < seq.length; i++) {
      if (i < seq.length - 1) {
        System.out.print(seq[i] + " + ");
      } else {
        System.out.print(seq[i]);
      }
    }
    System.out.print(" = 100\n");
  }

  static void find100(int[] numbers, int sum, int[] seq, int size, int index) {
    if (sum == 100) {
      printSeq(seq);

      win++;
      if (win == maxWin) {
        System.exit(0);
      }
      return;
    }

    for (int i = index; i < numbers.length; i++) {
      if (size == numbers.length) {
        return;
      }
      if (size != 0 && numbers[i] < seq[size-1]) {
        System.exit(0);
      }
      seq[size] = numbers[i];
      // for (int j : seq) {
      // System.out.print(j + ";");
      // }
      // System.out.println();
      // System.out.printf(" sum %d, %d %d\n", size, sum, numbers[i]);
      find100(numbers, sum + numbers[i], seq, size + 1, i);
    }
  }

  public static void main(String[] args) {
    int numbers[] = { 7, 15, 19, 23, 29, 37 };
    find100(numbers, 0, new int[numbers.length], 0, 0);
  }
}