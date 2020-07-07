public class IntList {
	public int first;
	public IntList rest;

	public IntList(int first, IntList rest) {
		this.first = first;
		this.rest = rest;
	}

	public int size() {
		// base case
		if (this.rest == null)
			return 1;
		return this.rest.size() + 1;
	}

	public int iterativeSize() {
		IntList P = this;
		int size = 0;
		while (P != null) {
			size++;
			P = P.rest;
		}
		return size;
	}

	public int get(int i) {
		// base case
		if (i == 0)
			return first;
		return rest.get(i - 1);
	}
}