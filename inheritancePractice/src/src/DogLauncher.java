import java.util.Comparator;

public class DogLauncher {
    public static void main(String[] args) {
        Dog chihuahua = new Dog("Chihuahua", 5);
        Dog doge = new Dog("Doge", 15);
        Dog helldog = new Dog("Helldog", 200);
        Dog[] dogs = new Dog[]{chihuahua, doge, helldog};

        Comparator ncName = Dog.getNameComparator();
        if (ncName.compare(chihuahua, doge) > 0) {
            chihuahua.bark();
        } else {
            doge.bark();
        }

        Comparator ncSize = chihuahua.getSizeComparator();
        if (ncSize.compare(doge, helldog) > 0) {
            doge.bark();
        } else {
            helldog.bark();
        }
    }
}
