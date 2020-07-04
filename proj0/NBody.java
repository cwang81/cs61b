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

	public static void main(String args[]) {
		In in = new In(args);
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		Body bodies = readBodies(filename);
	}
}






