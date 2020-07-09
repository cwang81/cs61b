public class IntList {
	public int item;
	public IntList next;

	public IntList(int i, IntList n) {
		item = i;
		next = n;
	}

	/** If 2 numbers in a row are the same, add them together
	 * and make one larger node.
	 */
	public void addAdjacent() {
		IntList p = this;
		IntList s = p;
		while (s.next != null) {
			if (s.item == s.next.item) {
				s.item = s.item * 2;
				s.next = s.next.next;
				s = p;
			} else
				s = s.next;
		}
	}

	public int size() {
		// base case
		if (this.next == null)
			return 1;
		return this.next.size() + 1;
	}

	public int get(int i) {
		// base case
		if (i == 0)
			return this.item;
		return this.next.get(i - 1);
	}

	public void addLast(int x) {
		IntList p = this;
		IntList s = new IntList(47, null);
		IntList last = new IntList(x, null);
		int size = this.size();
		int i = 0;
		while (i < size - 1) {
			s = new IntList(p.item * p.item, null);
			s.next = p.next;
			p.next = s;
			p = p.next.next;
			i++;
		}
		s = new IntList(p.item * p.item, last);
		p.next = s;
	}

	public static void main(String[] args) {
		IntList L = new IntList(1, null);
		L.next = new IntList(1, null);
		L.next.next = new IntList(2, null);
		L.next.next.next = new IntList(4, null);
		L.next.next.next.next = new IntList(5, null);
		L.addLast(7);
		/*
		L.next.next.next = new IntList(3, null);
		L.next.next.next.next = new IntList(4, null);
		L.next.next.next.next.next = new IntList(4, null);
		 */
	}
}