import java.util.Comparator;

public class Maximizer {
    public static Comparator max(Comparator[] items, Comparator c) {
        int maxDex = 0;
        for (int i = 1; i < items.length; i++) {
            if (c.compare(items[i], items[maxDex]) > 0) {
                maxDex = i;
            }
        }

        return items[maxDex];
    }
}
