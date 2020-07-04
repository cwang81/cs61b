public class Body {
	/** the position at x-axis of the body */
	public double xxPos;

	/** the position at y-axis of the body */
	public double yyPos;

	/** the velocity at x-axis */
	public double xxVel;

	/** the velocity at y-axis */
	public double yyVel;

	/** the mass of the body */
	public double mass;

	/** the file name of the img */
	String imgFileName;

	public Body(double xP, double yP, double xV,
				double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Body(Body b) {
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;
	}

	public double calcDistance(Body b) {
		double dx = this.xxPos - b.xxPos;
		double dy = this.yyPos - b.yyPos;
		double r = Math.sqrt(dx * dx + dy * dy);
		
		return r;
	}

	public double calcForceExertedBy(Body b) {
		double distance = this.calcDistance(b);
		double G = 6.67e-11;
		double force = (G * this.mass * b.mass) / (distance * distance);
		
		return force;
	}

	public double calcForceExertedByX(Body b) {
		double dx = b.xxPos - this.xxPos;
		double distance = this.calcDistance(b);
		double force = this.calcForceExertedBy(b);
		double forceX = force * dx / distance;

		return forceX;
	}

	public double calcForceExertedByY(Body b) {
		double dy = b.yyPos - this.yyPos;
		double distance = this.calcDistance(b);
		double force = this.calcForceExertedBy(b);
		double forceY = force * dy / distance;

		return forceY;
	}

	public double calcNetForceExertedByX(Body[] bodys) {
		double sumForceX = 0;

		for (Body b: bodys) {
			if (!b.equals(this))
				sumForceX += this.calcForceExertedByX(b);
			else
				continue;
		}

		return sumForceX;
	}


	public double calcNetForceExertedByY(Body[] bodys) {
		double sumForceY = 0;

		for (Body b: bodys) {
			if (!b.equals(this))
				sumForceY += this.calcForceExertedByY(b);
			else
				continue;
		}

		return sumForceY;
	}

	public void update(double dt, double forceX, double forceY) {
		double accelX = forceX / this.mass;
		double accelY = forceY / this.mass;
		this.xxVel += dt * accelX;
		this.yyVel += dt * accelY;
		this.xxPos += dt * this.xxVel;
		this.yyPos += dt * this.yyVel;
	}
}










