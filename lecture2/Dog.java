package lecture2;

public class Dog {
	public static int weightInPounds;
	// public int weightInPounds;

	public Dog (int x) {
		this.weightInPounds = x;
	}

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

	public static Dog largerDog (Dog d1, Dog d2) {
		if (d1.weightInPounds > d2.weightInPounds)
			return d1;
		return d2;
		}


}