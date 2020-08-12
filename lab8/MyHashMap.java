import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;

public class MyHashMap<K, V> implements Map61B<K, V> {
    private int initialSize = 16;
    private float loadFactor = 0.75f;
    private int numOfPairs;
    private Node<K, V>[] bins;

    public MyHashMap() {
        bins = new Node[initialSize];
    }

    public MyHashMap(int initialSize) {
        if (initialSize < 1) {
            throw new IllegalArgumentException();
        }
        this.initialSize = initialSize;
        bins = new Node[initialSize];
    }

    public MyHashMap(int initialSize, float loadFactor) {
        if (initialSize < 1 || loadFactor < 0) {
            throw new IllegalArgumentException();
        }
        this.initialSize = initialSize;
        this.loadFactor = loadFactor;
        bins = new Node[initialSize];
    }

    /**
     * Return the number of key-value pairs in the table.
     */
    @Override
    public int size() {
        return numOfPairs;
    }

    /**
     * Return true if there is no key-value pairs in the table,
     * false otherwise.
     */
    public boolean isEmpty() {
        return numOfPairs == 0;
    }

    @Override
    public boolean containsKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        return this.get(key) != null;
    }

    /**
     * Calculate the bucket number the key should be put in.
     */
    private int hash(K key) {
        if (key == null) {
            return 0;
        }
        return (key.hashCode() & 0x7FFFFFFF) % bins.length;
    }

    /**
     * Destroy the current MyHashMap and create an empty one.
     */
    @Override
    public void clear() {
        bins = new Node[initialSize];
        numOfPairs = 0;
    }

    /**
     * Put the key-value pair in bins. If the key already
     * exists, update the value.
     */
    @Override
    public void put(K key, V value) {
        int i = hash(key);
        Node targetNode = bins[i];

        if (targetNode == null) {
            bins[i] = new Node(key, value);
        } else if (targetNode.key.equals(key)){
            targetNode.val = value;
            return;
        } else {
            Node nextNode = targetNode.next;
            while (nextNode != null) {
                if (nextNode.key.equals(key)) {
                    nextNode.val = value;
                    return;
                }
                targetNode = targetNode.next;
                nextNode = nextNode.next;
            }
            targetNode.next = new Node(key, value);
        }

        numOfPairs += 1;
        if (numOfPairs / bins.length > loadFactor) {
            grow();
        }
    }

    /**
     * Increase the size by creating a new MyHashMap,
     * and copy all the items from the original MyHashMap
     * to the new one. Then reference the bins to the new
     * bins.
     */
    private void grow() {
        MyHashMap newMap = new MyHashMap(bins.length * 2);
        for (int i = 0; i < bins.length; i += 1) {
            Node<K, V> node = bins[i];
            while (node != null) {
                newMap.put(node.key, node.val);
                node = node.next;
            }
        }
        bins = newMap.bins;
    }

    @Override
    public V get(K key) {
        int i = hash(key);
        Node<K, V> node = bins[i];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.val;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int i = hash(key);
        Node<K, V> p = bins[i];
        if (p == null) {
            return null;
        } else if (p.key.equals(key)) {
            bins[i] = p.next;
            numOfPairs -= 1;
            return p.val;
        } else {
            Node<K, V> n = p.next;
            while (n != null) {
                if (n.key.equals(key)) {
                    p.next = p.next.next;
                    numOfPairs -= 1;
                    return n.val;
                }
                p = p.next;
                n = n.next;
            }
            return null;
        }
    }

    @Override
    public V remove(K key, V value) {
        int i = hash(key);
        Node<K, V> p = bins[i];
        if (p == null) {
            return null;
        } else if (p.key.equals(key) && p.val.equals(value)) {
            bins[i] = p.next;
            numOfPairs -= 1;
            return p.val;
        } else {
            Node<K, V> n = p.next;
            while (n != null) {
                if (n.key.equals(key) && n.val.equals(value)) {
                    p.next = p.next.next;
                    numOfPairs -= 1;
                    return n.val;
                }
                p = p.next;
                n = n.next;
            }
            return null;
        }
    }

    @Override
    public Set<K> keySet() {
        Set<K> keySet = new HashSet<>();
        for (int i = 0; i < bins.length; i += 1) {
            Node<K, V> node = bins[i];
            while (node != null) {
                keySet.add(node.key);
                node = node.next;
            }
        }
        return keySet;
    }

    @Override
    public Iterator<K> iterator() {
        return keySet().iterator();
    }

    private class Node<K, V> {
        private K key;
        private V val;
        private Node<K, V> next;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }

        public boolean equals(Object o) {
            if (o == null) {
                return false;
            }
            if (this == o) {
                return true;
            }
            if (this.getClass() != o.getClass()) {
                return false;
            }

            K otherKey = (K) o;
            if (this.key.hashCode() == otherKey.hashCode()) {
                return true;
            }
            return false;
        }
    }

}
