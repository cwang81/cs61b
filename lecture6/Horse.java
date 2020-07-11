public class Horse {
	Horse horse;
	String name;

	public Horse(String lee) {
		name = lee;
	}

	public Horse copy(Horse horse) {
		if (this.horse != null) {
			Horse same = horse;
			same.horse = horse;
			same = horse.horse;
		}
		return this.horse.horse;
	}

	public static void main(String[] args) {
		Horse firstHorse = new Horse("you've been");
		Horse secondHorse = new Horse("horsed");
		secondHorse.horse = secondHorse;
		secondHorse = secondHorse.copy(firstHorse);
		System.out.println(secondHorse.name);
		System.out.println(firstHorse.name);
	}
}