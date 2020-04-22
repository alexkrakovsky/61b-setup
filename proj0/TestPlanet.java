public class TestPlanet { 
	public static void main (String[] args) {
		Planet p1 = new Planet(25, 30, 6, 5, 200, "Planet 1 picture"); 
		Planet p2 = new Planet(22, 6, -2, -4, 296, "Planet 2 picture"); 
		System.out.println(p1.calcForceExertedBy(p2));
	}
}

