import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Stack;

public class BSTMap2<K extends Comparable<K>, V> implements Map61B<K, V> {
    private Node root;

    private class Node {
        public K key;
        public V value;
        public int size;
        public Node left;
        public Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.size = 1;
        }
    }

    public BSTMap2() {}

    /** Removes all of the mappings from this map. */
    @Override
    public void clear() {
        root.size = 0;
        root = null;
    }

    /* Returns true if this map contains a mapping for the specified key. */
    @Override
    public boolean containsKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        return containsKey(root, key);
    }

    private boolean containsKey(Node n, K key) {
        if (n == null) {
            return false;
        } else {
            int cmp = key.compareTo(n.key);
            if (cmp > 0) {
                return containsKey(n.right, key);
            } else if (cmp < 0) {
                return containsKey(n.left, key);
            } else {
                return true;
            }
        }
    }

    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        return get(root, key);
    }

    private V get(Node n, K key) {
        if (n == null) {
            return null;
        } else {
            int cmp = key.compareTo(n.key);
            if (cmp > 0) {
                return get(n.right, key);
            } else if (cmp < 0) {
                return get(n.left, key);
            } else {
                return n.value;
            }
        }
    }

    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
        return size(root);
    }

    private int size(Node n) {
        if (n == null) {
            return 0;
        }
        return n.size;
    }

    public boolean isEmpty() {
        return size(root) == 0;
    }

    /* Associates the specified value with the specified key in this map. */
    @Override
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        if (value == null) {
            remove(key);
        }
        root = put(root, key, value);
    }

    private Node put(Node n, K key, V value) {
        if (n == null) {
            return new Node(key, value);
        } else {
            int cmp = key.compareTo(n.key);
            if (cmp > 0) {
                n.right = put(n.right, key, value);
            } else if (cmp < 0) {
                n.left = put(n.left, key, value);
            } else {
                n.value = value;
            }
            n.size = size(n.left) + size(n.right) + 1;
            return n;
        }
    }

    /* Returns a Set view of the keys contained in this map. */
    @Override
    public Set<K> keySet() {
        return null;
    }

    /* Removes the mapping for the specified key from this map if present.
     * Not required for Lab 8. If you don't implement this, throw an
     * UnsupportedOperationException. */
    @Override
    public V remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }

        V ret = get(key);
        if (ret != null) {
            root = remove(root, key);
            return ret;
        } else {
            throw new NoSuchElementException();
        }
    }

    private Node remove(Node n, K key) {
        int cmp = key.compareTo(n.key);
        if (cmp > 0) {
            n.right = remove(n.right, key);
        } else if (cmp < 0) {
            n.left = remove(n.left, key);
        } else {
            if (n.left == null) {
                return n.right;
            }
            if (n.right == null) {
                return n.left;
            }
            Node tmp = n;
            n = max(tmp.left);
            n.left = deleteMax(tmp.left);
            n.right = tmp.right;
        }
        n.size = size(n.left) + size(n.right) + 1;
        return n;
    }

    private Node max(Node n) {
        if (n.right != null) {
            return max(n.right);
        }
        return n;
    }

    private Node deleteMax(Node n) {
        if (n.right == null) {
            return n.left;
        }
        n.right = deleteMax(n.right);
        n.size = size(n.left) + size(n.right) + 1;
        return n;
    }

    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 8. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    @Override
    public V remove(K key, V value) {
        if (key == null) {
            return null;
        }

        V ret = get(key);
        if (ret.equals(value)) {
            root = remove(root, key);
            return ret;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public Iterator<K> iterator() {
        return new BSTMap2Iterator(root);
    }

    private class BSTMap2Iterator implements Iterator {
        private Stack<Node> nodesStack;

        public BSTMap2Iterator(Node root) {
            nodesStack = new Stack<>();
            pushLeftMost(root);
        }

        private void pushLeftMost(Node n) {
            if (n != null) {
                nodesStack.push(n);
                n = n.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !nodesStack.isEmpty();
        }

        @Override
        public Object next() {
            Node n = nodesStack.pop();
            if (n.right != null) {
                pushLeftMost(n.right);
            }
            return n.key;
        }
    }


    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(Node n) {
        if (n == null) {
            return;
        }
        printInOrder(n.left);
        System.out.println(n.key);
        printInOrder(n.right);
    }
}
