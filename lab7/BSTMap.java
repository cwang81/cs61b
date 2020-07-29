import java.util.*;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    private Node root;

    private class Node {
        private int size;
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public BSTMap() {}

    /**
     * Removes all of the mappings from this map.
     */
    @Override
    public void clear() {
        root = null;
    }

    /**
     * Returns the number of key-value mappings in this map.
     */
    @Override
    public int size() {
        return size(root);
    }

    /**
     * Helper method for the size method.
     */
    private int size(Node x) {
        if (x == null) {
            return 0;
        }
        return x.size;
    }

    /**
     * Return true if the map is empty.
     */
    public boolean isEmpty() {
        return size(root) == 0;
    }

    /**
     * Returns true if this map contains a mapping for the specified key.
     */
    @Override
    public boolean containsKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        return containsKey(root, key);
    }

    /**
     * Helper method for the containsKey method.
     */
    private boolean containsKey(Node x, K key) {
        if (x == null) {
            return false;
        }

        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            return containsKey(x.right, key);
        } else if (cmp < 0) {
            return containsKey(x.left, key);
        } else {
            return true;
        }
    }

    /**
     * Associates the specified value with the specified key in this map.
     */
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

    /**
     * Helper method for the put method.
     */
    private Node put(Node x, K key, V value) {
        if (x == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else {
            x.val = value;
        }
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        return get(root, key);
    }

    /**
     * Helper method for the get method.
     */
    private V get(Node x, K key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            return get(x.right, key);
        } else if (cmp < 0) {
            return get(x.left, key);
        } else {
            return x.val;
        }
    }

    /**
     * Removes the mapping for the specified key from this map if present.
     * Not required for Lab 8. If you don't implement this, throw an
     * UnsupportedOperationException.
     */
    @Override
    public V remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        if (!containsKey(key)) {
            return null;
        }
        V ret = get(key);
        root = remove(root, key);
        return ret;
    }

    /**
     * Helper method for the remove methods.
     */
    private Node remove(Node x, K key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            x.right = remove(x.right, key);
        } else if (cmp < 0) {
            x.left = remove(x.left, key);
        } else {
            if (x.left == null) {
                return x.right;
            }
            if (x.right == null) {
                return x.left;
            }
            Node tmp = x;
            x = min(tmp.right);
            x.right = deleteMin(tmp.right);
            x.left = tmp.left;
        }
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    /**
     * Finds the minimum among the children of x.
     * @return the Node with minimum key
     */
    private Node min(Node x) {
        while (x.left != null) {
            return min(x.left);
        }
        return x;
    }

    /**
     * Delete the minimum Node among the children of x.
     */
    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    /**
     * Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 8. If you don't implement this,
     * throw an UnsupportedOperationException.
     */
    @Override
    public V remove(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        if (!containsKey(key)) {
            return null;
        }
        V ret = get(key);
        if (!ret.equals(value)) {
            return null;
        } else {
            root = remove(root, key);
            return ret;
        }
    }

    /**
     * Answer from Leetcode 173.
     */
    @Override
    public Iterator<K> iterator() {
        return new BSTMapIterator(root);
    }

    private class BSTMapIterator implements Iterator<K> {
        private Stack<Node> nodeStack;

        public BSTMapIterator(Node root) {
            nodeStack = new Stack<Node>();
            leftMostInorder(root);
        }

        private void leftMostInorder(Node root) {
            while (root != null) {
                nodeStack.push(root);
                root = root.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !nodeStack.isEmpty();
        }

        @Override
        public K next() {
            Node topMostNode = nodeStack.pop();

            if (topMostNode.right != null) {
                leftMostInorder(topMostNode.right);
            }

            return topMostNode.key;
        }
    }


    /**
     * Returns a Set view of the keys contained in this map.
     */
    @Override
    public Set<K> keySet() {
        // TODO
        throw new UnsupportedOperationException();
    }

}
