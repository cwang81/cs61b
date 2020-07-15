import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();
    static CharacterComparator offByN = new OffByN(5);

    // Your tests go here.
    @Test
    public void testOffByOne() {
        assertTrue(offByOne.equalChars('x', 'y'));
        assertFalse(offByOne.equalChars('x', 'X'));
        assertTrue(offByOne.equalChars('a', 'b'));
        assertFalse(offByOne.equalChars('a', 'a'));
        assertFalse(offByOne.equalChars('a', 'e'));
        assertFalse(offByOne.equalChars('z', 'a'));
    }

    @Test
    public void testOffByN() {
        assertTrue(offByN.equalChars('a', 'f'));
        assertTrue(offByN.equalChars('f', 'a'));
        assertFalse(offByN.equalChars('a', 'b'));
        assertFalse(offByN.equalChars('a', 'a'));
        assertFalse(offByN.equalChars('a', 'e'));
        assertFalse(offByN.equalChars('z', 'a'));
    }
}