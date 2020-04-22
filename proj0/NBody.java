public class NBody { 
	public static double readRadius(String fileName) {
		In in = new In(fileName); 
		in.readInt();
		return in.readDouble(); 
	}
	public static Planet[] readPlanets(String fileName) { 
		In in = new In(fileName); 
		int n = in.readInt(); 
		in.readDouble();
		Planet[] planets = new Planet[n];
		for (int i = 0; i < n; i += 1) {
			double xP = in.readDouble();
			double yP = in.readDouble();
			double xV = in.readDouble();
			double yV = in.readDouble();
			double m = in.readDouble(); 
			String img = in.readString();
			planets[i] = new Planet(xP, yP, xV, yV, m, img);  
		}
		return planets; 
	}
	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		Planet[] planets = readPlanets(filename);
		double radius = readRadius(filename);
		StdDraw.setScale(-radius, radius);
		StdDraw.picture(0, 0, "images/starfield.jpg"); 
		for (Planet p: planets) {
			p.Draw();
		}
		StdDraw.enableDoubleBuffering();
		int numPlanets = planets.length; 
		for (int t = 0; t <= T; t += dt) { 
			double[] xForces = new double[numPlanets];
			double[]yForces = new double[numPlanets];
			for (int k = 0; k < numPlanets; k += 1) {
				xForces[k] = planets[k].calcNetForceExertedByX(planets); 
				yForces[k] = planets[k].calcNetForceExertedByY(planets);  
				planets[k].update(dt, xForces[k], yForces[k]); 
				StdDraw.picture(0, 0, "images/starfield.jpg"); 
				for (Planet p: planets) { 
					p.Draw(); 
				}
				StdDraw.show();
				StdDraw.pause(10);
			}

		}
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);

		}
	}
}