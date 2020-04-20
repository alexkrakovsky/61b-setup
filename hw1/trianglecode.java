 public class TriangleCode {
 /** Specifies code to print out desired triangle. */
 	public static void drawTriangle(int n) {
 	/** Prints a triangle with height n.*/
 		int x = 1; 
 		while (x <= n) {
 			int y = 1; 
 			System.out.println("");
 			while (y <= x) {
 				System.out.print("*"); 
 				y = y + 1; 
 			}
 			x = x + 1; 
 		}
 		System.out.println("");
 	}
	public static void main(String[] args) {
		drawTriangle(10);
}
}
	