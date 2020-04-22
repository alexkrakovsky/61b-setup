public class Planet {
	public double xxPos; 
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass; 
	public String imgFileName;
	public static final double g = 6.67e-11;

	public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV; 
		yyVel = yV;
		mass = m; 
		imgFileName = img;
	}
	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;		
	}
	public double calcDistance(Planet p) {
		double dx = xxPos - p.xxPos;
		double dy = yyPos - p.yyPos;
		double r = Math.sqrt(dx*dx + dy*dy);
		return r; 
	}
	public double calcForceExertedBy(Planet p) { 
		double force = g * (mass * p.mass) / (calcDistance(p) * calcDistance(p));
		return force;
	}
	public double calcForceExertedByX(Planet p) { 
		double dx = p.xxPos - xxPos;
		return calcForceExertedBy(p) * dx / calcDistance(p); 
	}
	public double calcForceExertedByY(Planet p) { 
		double dy = p.yyPos - yyPos; 
		return calcForceExertedBy(p) * dy / calcDistance(p); 
	}
	public double calcNetForceExertedByX(Planet[] planets) { 
		double xNet = 0; 
		for (int i = 0; i < planets.length; i += 1) {
			if (this == planets[i]) {
				continue;
			}
			xNet = xNet + calcForceExertedByX(planets[i]);
		}
		return xNet; 
	}
	public double calcNetForceExertedByY(Planet[] planets) { 
		double yNet = 0; 
		for (Planet p : planets) {
			if (this == p) { 
				continue;
			}
			yNet = yNet + calcForceExertedByY(p); 
		}
		return yNet;
	}
	public void update(double dt, double fX, double fY) { 
		double aX = fX / mass;
		double aY = fY / mass;
		xxVel = xxVel + dt * aX;
		yyVel = yyVel + dt * aY; 
		xxPos = xxPos + dt * xxVel;
		yyPos = yyPos + dt * yyVel;
	}
	public void Draw() { 
		StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
	}
}






