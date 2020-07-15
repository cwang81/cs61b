import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestArrayDequeGold {

    @Test
    public void testStudentArrayDeque() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();

        // addLast
        for (int i = 0; i < 10; i++) {
            int random = StdRandom.uniform(100);
            ads.addLast(random);
            sad.addLast(random);
        }
        for (int i = 0; i < 10; i++) {
            Integer actual = ads.get(i);
            Integer expected = sad.get(i);
            assertEquals("Oh noooo!\nThis is bad in addLast():\n   Random number " + actual
                            + " not equal to " + expected + "!",
                    expected, actual);
        }

        // addFirst
        for (int i = 0; i < 10; i++) {
            int random = StdRandom.uniform(100);
            ads.addFirst(random);
            sad.addFirst(random);
        }
        for (int i = 0; i < 10; i++) {
            Integer actual = ads.get(i);
            Integer expected = sad.get(i);
            assertEquals("Oh noooo!\nThis is bad in addFirst():\n   Random number " + actual
                            + " not equal to " + expected + "!",
                    expected, actual);
        }

        // removeFirst
        ArrayDequeSolution<Integer> actualList = new ArrayDequeSolution<>();
        ArrayDequeSolution<Integer> expectedList = new ArrayDequeSolution<>();
        for (int i = 0; i < 10; i++) {
            actualList.add(ads.removeFirst());
            expectedList.add(sad.removeFirst());
        }
        for (int i = 0; i < 10; i++) {
            Integer actual = ads.get(i);
            Integer expected = sad.get(i);
            assertEquals("Oh noooo!\nThis is bad in removeFirst():\n   Random number " + actual
                            + " not equal to " + expected + "!",
                    expected, actual);
        }


        // removeLast
        actualList.clear();
        expectedList.clear();
        for (int i = 0; i < 10; i++) {
            actualList.add(ads.removeLast());
            expectedList.add(sad.removeLast());
        }
        int actual = ads.size();
        int expected = sad.size();
        assertEquals("Oh noooo!\nThis is bad in removeLast():\n   actual size " + actual
                        + " not equal to " + expected + "!",
                expected, actual);
        for (int i = 0; i < 10; i++) {
            assertEquals("Oh noooo!\nThis is bad in removeLast():\n   Random number " + actualList.get(i)
                            + " not equal to " + expectedList.get(i) + "!",
                    expectedList.get(i), actualList.get(i));
        }

    }

    @Test
    public void testArrayDeque2() {
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        int random = StdRandom.uniform(100);
        ads.addFirst(random);
        sad.addFirst(random);
        assertEquals("addFirst(" + random + ")", ads.get(0), sad.get(0));
        System.out.println("addFirst(" + random + ")");

        random = StdRandom.uniform(100);
        ads.addLast(random);
        sad.addLast(random);
        assertEquals("addLast(" + random + ")", ads.get(1), sad.get(1));
        System.out.println("addLast(" + random + ")");
    }

}
