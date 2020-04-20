 public class TriangleCode {
 /** Specifies code to print out desired triangle. */
	public static void main(String[] args) {
		int x = 1; 
		while (x <= 5) {
			int y = 1;
			System.out.println("");
				while (y <= x) {
					System.out.print("*");
				y = y +1; 
			}
			x = x + 1; 
		}
	System.out.println("");
	}

}
	