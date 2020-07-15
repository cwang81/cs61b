import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("jump"));
        assertFalse(palindrome.isPalindrome("Noon"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("noon"));
    }

    @Test
    public void testIsPalindrome2() {
        OffByOne obo = new OffByOne();

        assertTrue(palindrome.isPalindrome("flake", obo));
        assertFalse(palindrome.isPalindrome("cat", obo));
        assertFalse(palindrome.isPalindrome("noon", obo));
        assertFalse(palindrome.isPalindrome("racecar", obo));
        assertTrue(palindrome.isPalindrome("", obo));
        assertTrue(palindrome.isPalindrome("a", obo));
    }

    @Test
    public void testIsPalindrome3() {
        OffByN offByN = new OffByN(5);

        assertTrue(palindrome.isPalindrome("unzip", offByN));
        assertTrue(palindrome.isPalindrome("tinny", offByN));
        assertTrue(palindrome.isPalindrome("styx", offByN));
        assertFalse(palindrome.isPalindrome("cat", offByN));
        assertFalse(palindrome.isPalindrome("noon", offByN));
        assertFalse(palindrome.isPalindrome("racecar", offByN));
        assertTrue(palindrome.isPalindrome("", offByN));
        assertTrue(palindrome.isPalindrome("a", offByN));
    }
}