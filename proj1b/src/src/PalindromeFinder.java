import java.util.List;

/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {
    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("../library-sp19/data/words.txt");
        Palindrome palindrome = new Palindrome();
        OffByN offBy4 = new OffByN(4);


        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word, offBy4)) {
                System.out.println(word);
            }
        }

        /*
        Deque<Integer> countList = new ArrayDeque<>();
        for (int i = 0; i < 26; i++) {
            in = new In("../library-sp19/data/words.txt");
            OffByN offByi = new OffByN(i);
            int count = 0;
            while (!in.isEmpty()) {
                String word = in.readString();
                if (word.length() >= minLength && palindrome.isPalindrome(word, offByi)) {
                    count++;
                }
            }
            countList.addLast(count);
            System.out.println(count);
        }
         */
    }
}