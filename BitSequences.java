public class BitSequences{
  public static void main(String[] args) {
    listBitSequences(15);
  }
  public static void listBitSequences(int n) {
    String toprint = "";
    String stopcondition = "";
    for (int i = 0; i < n; i++) {
      toprint += "1";
      stopcondition += i%2;
    }
    System.out.println(toprint + "\n" + stopcondition);
  }
}
      
