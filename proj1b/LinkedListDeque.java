
public class LinkedListDeque<T> {

    private class ListNode {
        public ListNode prev;
        public T item;
        public ListNode next;

        public ListNode(ListNode prev, T item, ListNode next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    public T item;
    private ListNode sentinel;
    private int size;

    /** Adds an element at the beginning of the LinkedListDeque. */
    public void addFirst(T i) {
        sentinel.next = new ListNode(sentinel, i, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size++;
    }

    /** Adds an element to the end of the LinkedListDeque. */
    public void addLast(T i) {
        sentinel.prev = new ListNode(sentinel.prev, i, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size++;
    }

    /** Checks if the LinkedListDeque is empty or not. */
    public boolean isEmpty() {
        return (size == 0);
    }

    /** Returns the length of the LinkedListDeque. */
    public int size() {
        return size;
    }

    /** Prints out the items of the LinkeListDeque, from first to last. */
    public void printDeque() {
        ListNode p = sentinel;
        for (int i = 0; i < size; i++) {
            System.out.print(p.next.item + " ");
            p = p.next;
        }
        System.out.println(" ");
        return;
    }

    /** Removes the first item in the LinkedListDeque. */
    public T removeFirst() {
        if (size == 0)
            return null;
        T i = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return i;
    }

    /** Removes the last item in the LinkedListDeque. */
    public T removeLast() {
        if (size == 0)
            return null;
        T i = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size--;
        return i;
    }

    /** Returns the ith value of the LinkedListDeque. */
    public T get(int index) {
        ListNode p = sentinel.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.item;
    }

    /** Creates an empty LinkedListDeque. */
    public LinkedListDeque() {
        sentinel = new ListNode(null, item, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /** Creates an LinkedListDeque with T item. */
    public LinkedListDeque(T i) {
        sentinel = new ListNode(null, item, null);
        sentinel.next = new ListNode(sentinel, i, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    /** Creates a deep copy of other. */
    public LinkedListDeque(LinkedListDeque<T> other) {
        sentinel = new ListNode(null, item, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;

        for (int i = 0; i < other.size(); i++) {
            addLast(other.get(i));
            addLast(other.get(i));
        }
    }

    /** Returns the ith value of the LinkedListDeque.
     *  Same as get, but uses recursion.
     */
    public T getRecursive(int index) {
        return getRecursiveAssist(index, sentinel.next);
    }

    public T getRecursiveAssist(int index, ListNode l) {
        if (index == 0) {
            return l.item;
        }
        return getRecursiveAssist(index - 1, l.next);
    }


}
