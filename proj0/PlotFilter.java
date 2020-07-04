public class PlotFilter {
	public static void main(String args[]) {
		In in = new In("USA.txt");

		double x0 = in.readDouble();
		double y0 = in.readDouble();
		double x1 = in.readDouble();
		double y1 = in.readDouble();
		StdDraw.setXscale(x0, x1);
		StdDraw.setYscale(y0, y1);

		StdDraw.setPenRadius(0.005);

		StdDraw.enableDoubleBuffering();

		double x, y;
		while (!in.isEmpty()) {
			x = in.readDouble();
			y = in.readDouble();
			StdDraw.point(x, y);
		}

		StdDraw.show();
	}
}