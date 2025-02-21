public class TowerOfHanoi {
	public static void main(String[] args) {
		towerOfHanoi(4);
		towerOfHanoi(3);
	}
	public static void towerOfHanoi(int n) {
		System.out.println(tOH(n, 1, 3, 2));
	}		
				
	private static String tOH(int n, int first, int third, int middle) {
		String toreturn = "";
		if (n == 0) {
			return toreturn;
		}
		toreturn += tOH(n-1, first, middle, third);
		toreturn += first + "->" + third + " ";
		toreturn += tOH(n-1, middle, third, first);
		return toreturn;
	}
}
