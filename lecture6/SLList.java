public class SLList {
    private class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    private IntNode first;

    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    public void insert(int x, int position) {
        if (first == null || position == 0) {
            first = new IntNode(x, first);
            return;
        }

        IntNode p = first;
        while (position > 1 && p.next != null) {
            position--;
            p = p.next;
        }
        p.next = new IntNode(x, p.next);
    }

    public void reverse() {
        IntNode frontOfReversed = null;
        IntNode nextNodeToAdd = first;
        while (nextNodeToAdd != null) {
            IntNode remainderOfOriginal = nextNodeToAdd.next;
            nextNodeToAdd.next = frontOfReversed;
            frontOfReversed = nextNodeToAdd;
            nextNodeToAdd = remainderOfOriginal;
        }
        first = frontOfReversed;
    }

    public void reverseRecursive() {
        first = reverseRecursiveHelper(first);
    }

    private IntNode reverseRecursiveHelper(IntNode front) {
        if (front == null || front.next == null) {
            return front;
        } else {
            IntNode reversed = reverseRecursiveHelper(front.next);
            front.next.next = front;
            front.next = null;
            return reversed;
        }
    }

    public static void main(String[] args) {
        SLList p = new SLList();

        p.insert(5, 0);
        p.insert(10, 1);
        p.insert(15, 2);
        p.insert(99, 1);
        p.insert(10, 55);
        p.insert(12, 55);
        p.insert(13, 55);

        p.reverseRecursive();
    }
}
