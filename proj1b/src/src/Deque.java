
public interface Deque<Item> {


    /** Adds an element to the beginning of the Deque. */
    void addFirst(Item item);

    /** Adds an element to the end of the Deque. */
    void addLast(Item item);

    /** Checks if the Deque is empty or not. */
    default boolean isEmpty() {
        return (size() == 0);
    };

    /**
     * Returns the length of the tDeque.
     */
    int size();

    /** Prints out the items of the Deque, from first to last. */
    default void printDeque() {
        for (int i = 0; i < size(); i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    };

    /** Removes the first item in the Deque. */
    Item removeFirst();

    /** Removes the last item in the Deque. */
    Item removeLast();

    /** Returns the ith value of the Deque. */
    Item get(int index);

}
