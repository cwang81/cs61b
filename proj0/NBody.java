public class NBody {

	public static double readRadius(String fileName) {
		In in = new In(fileName);
		in.readInt();
		double radius = in.readDouble();

		return radius;
	}

	public static Body[] readBodies(String fileName) {
		In in = new In(fileName);
		int n_bodies = in.readInt();
		in.readDouble();
		Body[] bodies = new Body[n_bodies];

		for (int i = 0; i < n_bodies; i++) {
			double xP = in.readDouble();
			double yP = in.readDouble();
			double xV = in.readDouble();
			double yV = in.readDouble();
			double m = in.readDouble();
			String img = in.readString();
			bodies[i] = new Body(xP, yP, xV, yV, m, img);
		}

		return bodies;
	}

	public static String imageToDraw = "images/Starfield.jpg";


	public static void main(String args[]) {
		
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double uniRadius = NBody.readRadius(filename);
		Body[] bodies = NBody.readBodies(filename);

		StdDraw.enableDoubleBuffering();
		StdDraw.setScale(-uniRadius, uniRadius);
		StdDraw.clear();

		StdDraw.picture(0, 0, imageToDraw);

		for (Body planet : bodies) 
			planet.draw();
		
		double time = 0.0;

		while (time <= T) {

			double[] xForces = new double[bodies.length];
			double[] yForces = new double[bodies.length];

			for (int i = 0; i < bodies.length; i++) {
					xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
					yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
				}

			for (int j = 0; j < bodies.length; j++) {
				bodies[j].update(dt, xForces[j], yForces[j]);
			}

			StdDraw.picture(0, 0, imageToDraw);

			for (Body body : bodies) {
				body.draw();
			}

			StdDraw.show();
			StdDraw.pause(10);
			time += dt;
		}

		StdOut.printf("%d\n", bodies.length);
		StdOut.printf("%.2e\n", uniRadius);
		for (int i = 0; i < bodies.length; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
						  bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
						  bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);

		}
	}
}






