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

	public static IntList incrList(IntList L, int x) {
        L.first = L.first + x;
        if (L.rest != null) {
            return incrList(L.rest, x);
        }
        else {
            return L;
        }
    }

    public static IntList dincrList(IntList L, int x) {
        IntList tmp = new IntList(L.get(0), null);
        IntList P = tmp;
        int len = L.Size();

        for (int i = 1; i < len; i++) {
            tmp.rest = new IntList(L.get(i), null);
            tmp = tmp.rest;
        }

        tmp = P;
        int i = 0;
        while (i < len) {
            tmp.first += x;
            tmp = tmp.rest;
            i++;
        }
        return P;
    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.rest = new IntList(10, null);
        L.rest.rest = new IntList(15, null);

        incrList(L, 3);
        IntList X = dincrList(L, 3);
    }
}









