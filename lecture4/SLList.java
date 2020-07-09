public class SLList {
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;

    /** Creates an empty SLList. */
    public SLList() {
        sentinel = new IntNode(47, null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(47, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public SLList(int[] a) {
        sentinel = new IntNode(47, null);
        IntNode p = sentinel;
        int i = 0;
        while (i < a.length) {
            p.next = new IntNode(a[i], null);
            p = p.next;
            i++;
        }
        size = a.length;
    }

    /** Add an item to the first of the list. */
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size++;
    }

    /** Return the first number of the list. */
    public int getFirst() {
        return sentinel.next.item;
    }

    /** Add an item to the end of the list. */
    public void addLast(int x) {
        IntNode p = sentinel;
        while (p.next != null)
            p = p.next;
        p.next = new IntNode(x, null);
        size++;
    }

    /** Return the size of the list. */
    public int size() {
        return size;
    }

    /** Deletes the first element in the SLList. */
    public void deleteFirst() {
        sentinel.next = sentinel.next.next;
    }


    public static void main(String[] args) {
        int[] a = new int[] {1, 1, 2, 3, 4};
        SLList L = new SLList(a);
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(20);
        System.out.println(L.size());
    }
}
