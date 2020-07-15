import java.util.Comparator;

public class Dog implements Comparable<Dog> {
    private String name;
    private int size;

    public Dog(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public void bark() {
        if (size < 10) {
            System.out.println("Dog " + name + " barks: meow!");
        } else if (size < 20) {
            System.out.println("Dog " + name + " barks: woof!");
        } else {
            System.out.println("Dog " + name + " barks: AAARGH!");
        }
    }

    public int compareTo(Dog a) {
        return (this.size - a.size);
    }

    private static class NameComparator implements Comparator<Dog> {
        public int compare(Dog a, Dog b) {
            return a.name.compareTo(b.name);
        }
    }

    public static Comparator<Dog> getNameComparator() {
        return new NameComparator();
    }

    private class SizeComparator implements Comparator<Dog> {
        public int compare(Dog a, Dog b) {
            return a.size - b.size;
        }
    }

    public Comparator<Dog> getSizeComparator() {
        return new SizeComparator();
    }

}
