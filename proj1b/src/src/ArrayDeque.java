
public class ArrayDeque<Item> implements Deque<Item> {

    private Item[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int initSize = 8;
    private double usageFactor = 0.25;

    /** Constructor. */
    public ArrayDeque() {
        items = (Item[]) new Object[initSize];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    /** Checks if the Deque is full. */
    private boolean isFull() {
        return (size == items.length);
    }

    /** Checks if the Deque needs to be downsized. */
    private boolean isSparse() {
        return (size >= 16 && ((double) size / items.length < usageFactor));
    }

    /** Doubles the Deque size. */
    private void increaseSize() {
        Item[] newItems = (Item[]) new Object[size * 2];
        for (int i = 0; i < size; i++) {
            newItems[i] = get(i);
        }

        items = newItems;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    /** Cuts half the Deque size. */
    private void decreaseSize() {
        Item[] newItems = (Item[]) new Object[size / 2];
        for(int i = 0; i < size; i++) {
            newItems[i] = get(i);
        }

        items = newItems;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    /** Helper method to locate the nextFirst or nextLast pointer. */
    private int minusOne(int index) {
        if (index == 0) {
            return items.length - 1;
        }
        return (index - 1);
    }

    /** Helper method to locate the nextFirst or nextLast pointer. */
    private int plusOne(int index) {
        return (index + 1) % items.length;
    }


    /** Returns the size of the Deque. */
    @Override
    public int size() {
        return size;
    }


    /** Adds item i to the left of the Deque.
     * @param i The item to be added.
     */
    @Override
    public void addFirst(Item i) {
        if (isFull()) {
            increaseSize();
        }

        items[nextFirst] = i;
        nextFirst = minusOne(nextFirst);
        size++;
    }

    /** Adds item i to the right of the Deque.
     * @param i The item to be added.
     */
    @Override
    public void addLast(Item i) {
        if (isFull()) {
            increaseSize();
        }

        items[nextLast] = i;
        nextLast = plusOne(nextLast);
        size++;
    }

    /** Returns the item of the given index. */
    @Override
    public Item get(int index) {
        if (index >= size || index < 0) {
            return null;
        }

        int firstIndex = plusOne(nextFirst);
        int targetIndex = (firstIndex + index) % items.length;

        return items[targetIndex];
    }

    /** Removes and pops the "leftmost" item of the Deque.
     * @return The removed item.
     */
    @Override
    public Item removeFirst() {
        int indexOfRemoval = plusOne(nextFirst);
        Item toBeRemove = items[indexOfRemoval];
        items[indexOfRemoval] = null;
        nextFirst = indexOfRemoval;
        size--;

        if (isSparse()) {
            decreaseSize();
        }

        return toBeRemove;
    }

    /** Removes and pops the "rightmost" item of the Deque.
     * @return The removed item.
     */
    @Override
    public Item removeLast() {
        int indexOfRemoval = minusOne(nextLast);
        Item toBeRemove = items[indexOfRemoval];
        items[indexOfRemoval] = null;
        nextLast = indexOfRemoval;
        size--;

        if (isSparse()) {
            decreaseSize();
        }

        return toBeRemove;
    }

    /** Prints out the items in the Deque. */
    @Override
    public void printDeque() {
       for (int i = 0; i < size; i++) {
            System.out.println(get(i) + " ");
        }
        System.out.println();
    }

    /** Creates a deep copy of other. */
    public ArrayDeque(ArrayDeque other) {
        Item[] copyOfOther = (Item[]) new Object[size];

        for (int i = 0; i < size; i++) {
            copyOfOther[i] = items[i];
        }
    }

}
