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
        if (position == 0) {
            first = new IntNode(x, first);
            return;
        }
        IntNode p = first;
        for (int i = 0; i < position - 1; i++) {
            if (p.next == null) {
                p.next = new IntNode(x, null);
                return;
            }
            p = p.next;
        }
        p.next = new IntNode(x, p.next);
    }

    public void reverse() {
        IntNode p = first;
        IntNode tmp = first;
        int temp;
        int size = this.size();
        for (int count = 0; count < size / 2; count++) {
            for (int i = 0; i < size - 1 - count; i++) {
                tmp = tmp.next;
            }
            temp = tmp.item;
            tmp.item = p.item;
            p.item = temp;
            p = p.next;
            tmp = first;
        }
    }

    public void rev() {
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

    public int size() {
        int size = 0;
        IntNode p = first;
        while (p != null) {
            size++;
            p = p.next;
        }
        return size;
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

        p.rev();
    }
}
