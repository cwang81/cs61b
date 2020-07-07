public class IntList {
	public int first;
	public IntList rest;

	public IntList(int first, IntList rest) {
		this.first = first;
		this.rest = rest;
	}

	public int Size() {
		/** 
		 * No need to consider (this == null) since calling an null object
		 * will throw a NullPointer error.
		 */
		// base case
		if (rest == null)
			return 1;
		return rest.Size() + 1;
	}

	public int iterativeSize() {
		IntList p = this;
		int totalSize = 0;
		while (p != null) {
			p = p.rest;
			totalSize++;
		}
		return totalSize;
	}

	public int get(int i) {
		// base case
		if (i == 0)
			return first;
		return rest.get(i - 1);
	}
}