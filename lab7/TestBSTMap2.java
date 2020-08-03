import static org.junit.Assert.*;
import org.junit.Test;

/** Tests by Brendan Hu, Spring 2015, revised for 2016 by Josh Hug */
public class TestBSTMap2 {

    @Test
    public void sanityGenericsTest() {
        try {
            BSTMap2<String, String> a = new BSTMap2<String, String>();
            BSTMap2<String, Integer> b = new BSTMap2<String, Integer>();
            BSTMap2<Integer, String> c = new BSTMap2<Integer, String>();
            BSTMap2<Boolean, Integer> e = new BSTMap2<Boolean, Integer>();
        } catch (Exception e) {
            fail();
        }
    }

    //assumes put/size/containsKey/get work
    @Test
    public void sanityClearTest() {
        BSTMap2<String, Integer> b = new BSTMap2<String, Integer>();
        for (int i = 0; i < 455; i++) {
            b.put("hi" + i, 1+i);
            //make sure put is working via containsKey and get
            assertTrue( null != b.get("hi" + i) && (b.get("hi"+i).equals(1+i))
                    && b.containsKey("hi" + i));
        }
        assertEquals(455, b.size());
        b.clear();
        assertEquals(0, b.size());
        for (int i = 0; i < 455; i++) {
            assertTrue(null == b.get("hi" + i) && !b.containsKey("hi" + i));
        }
    }

    // assumes put works
    @Test
    public void sanityContainsKeyTest() {
        BSTMap2<String, Integer> b = new BSTMap2<String, Integer>();
        assertFalse(b.containsKey("waterYouDoingHere"));
        b.put("waterYouDoingHere", 0);
        assertTrue(b.containsKey("waterYouDoingHere"));
    }

    // assumes put works
    @Test
    public void sanityGetTest() {
        BSTMap2<String, Integer> b = new BSTMap2<String, Integer>();
        assertEquals(null,b.get("starChild"));
        assertEquals(0, b.size());
        b.put("starChild", 5);
        assertTrue(((Integer) b.get("starChild")).equals(5));
        b.put("KISS", 5);
        assertTrue(((Integer) b.get("KISS")).equals(5));
        assertNotEquals(null,b.get("starChild"));
        assertEquals(2, b.size());
    }

    // assumes put works
    @Test
    public void sanitySizeTest() {
        BSTMap2<String, Integer> b = new BSTMap2<String, Integer>();
        assertEquals(0, b.size());
        b.put("hi", 1);
        assertEquals(1, b.size());
        for (int i = 0; i < 455; i++)
            b.put("hi" + i, 1);
        assertEquals(456, b.size());
    }

    //assumes get/contains key work
    @Test
    public void sanityPutTest() {
        BSTMap2<String, Integer> b = new BSTMap2<String, Integer>();
        b.put("hi", 1);
        assertTrue(b.containsKey("hi") && b.get("hi") != null);
    }

    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests(TestBSTMap2.class);
    }
}
