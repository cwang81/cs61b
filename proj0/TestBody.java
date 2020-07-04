public class TestBody {
	public static void main(String args[]) {
		Body testA = new Body(0, 0, 1, 1, 5, null);
		Body testB = new Body(5, 5, 2, 2, 4, null);

		double fa = testA.calcForceExertedBy(testB);

		System.out.println("The force exerted on A is: " + fa);
	}
}