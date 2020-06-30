public class Dog {
	public static int weightInPounds;

	public void makeNoise() {
		if (weightInPounds < 10) {
			System.out.println("yip!");
		}
		else if (weightInPounds < 30) {
			System.out.println("bark!");
		}
		else {
			System.out.println("woooof!");
		}
	}
}