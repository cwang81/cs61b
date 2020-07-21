
public class LinkedListDeque<Item> implements Deque<Item> {

    private class ListNode {
        public ListNode prev;
        public Item item;
        public ListNode next;

        public ListNode(ListNode prev, Item item, ListNode next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }



    public Item item;
    private ListNode sentinel;
    private int size;

    /**
     * Adds an element at the beginning of the LinkedListDeque.
     */
    @Override
    public void addFirst(Item i) {
        sentinel.next = new ListNode(sentinel, i, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size++;
    }

    /**
     * Adds an element to the end of the LinkedListDeque.
     */
    @Override
    public void addLast(Item i) {
        sentinel.prev = new ListNode(sentinel.prev, i, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size++;
    }

    /**
     * Returns the length of the LinkedListDeque.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Prints out the items of the LinkeListDeque, from first to last.
     */
    @Override
    public void printDeque() {
        ListNode p = sentinel;
        for (int i = 0; i < size; i++) {
            System.out.print(p.next.item + " ");
            p = p.next;
        }
        System.out.println(" ");
        return;
    }

    /**
     * Removes the first item in the LinkedListDeque.
     */
    @Override
    public Item removeFirst() {
        if (size == 0)
            return null;
        Item i = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return i;
    }

    /**
     * Removes the last item in the LinkedListDeque.
     */
    @Override
    public Item removeLast() {
        if (size == 0)
            return null;
        Item i = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size--;
        return i;
    }

    /**
     * Returns the ith value of the LinkedListDeque.
     */
    @Override
    public Item get(int index) {
        ListNode p = sentinel.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.item;
    }

    /**
     * Creates an empty LinkedListDeque.
     */
    public LinkedListDeque() {
        sentinel = new ListNode(null, item, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /**
     * Creates an LinkedListDeque with T item.
     */
    public LinkedListDeque(Item i) {
        sentinel = new ListNode(null, item, null);
        sentinel.next = new ListNode(sentinel, i, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    /**
     * Creates a deep copy of other.
     */
    public LinkedListDeque(LinkedListDeque<Item> other) {
        sentinel = new ListNode(null, item, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;

        for (int i = 0; i < other.size(); i++) {
            addLast(other.get(i));
        }
    }

    /**
     * Returns the ith value of the LinkedListDeque.
     * Same as get, but uses recursion.
     */
    public Item getRecursive(int index) {
        return getRecursiveAssist(index, sentinel.next);
    }

    private Item getRecursiveAssist(int index, ListNode l) {
        if (index == 0) {
            return l.item;
        }
        return getRecursiveAssist(index - 1, l.next);
    }


}
