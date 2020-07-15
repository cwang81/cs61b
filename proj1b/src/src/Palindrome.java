
public class Palindrome {

    /** Converts a word into strings in ArrayDeque. */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> wordDeque = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            wordDeque.addLast(word.charAt(i));
        }

        return wordDeque;
    }

    /** Determine if a word is Palindrome. (noon, racecar are Palindromes.) */
    public boolean isPalindrome(String word) {
        Deque<Character> wordDeque = wordToDeque(word);

        while(wordDeque.size() > 1) {
            Character first = wordDeque.removeFirst();
            Character last = wordDeque.removeLast();
            if (first != last) {
                return false;
            }
        }

        return true;
    }

    /** Overloads the above method. */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> wordDeque = wordToDeque(word);

        while (wordDeque.size() > 1) {
            Character first = wordDeque.removeFirst();
            Character last = wordDeque.removeLast();
            if (!cc.equalChars(first, last)) {
                return false;
            }
        }

        return true;
    }

}
