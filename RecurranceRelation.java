public class RecurrenceRelation {
  public static void main(String[] args) {
    int a_1 = 5;
    int a_0 = 3;
    int c_1 = 4;
    int c_2 = 8;
    System.out.println(getRecRel(8, c_1, c_2, a_0, a_1));
  }
  public static int getRecRel(int k, int c_1, int c_2, int a_sub2, int a_sub1) {
    if (k == 0) {
      return a_sub2;
    } else if (k == 1) {
      return a_sub1;
    }
    int a_n = 0;
    for (int i = 2; i <= k; i++) {
      a_n = c_1 * a_sub1 + c_2 * a_sub2;
      a_sub2 = a_sub1;
      a_sub1 = a_n;
    }
    return a_n;
  }
}
