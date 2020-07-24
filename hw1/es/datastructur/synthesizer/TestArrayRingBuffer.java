package es.datastructur.synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void emptyFullTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(4);

        boolean emptyActual = arb.isEmpty();
        assertTrue(emptyActual);

        arb.enqueue(3);
        boolean emptyActual2 = arb.isEmpty();
        assertFalse(emptyActual2);

        boolean fullActual = arb.isFull();
        assertFalse( fullActual);

        arb.enqueue(4);
        arb.enqueue(5);
        arb.enqueue(6);
        boolean fullActual2 = arb.isFull();
        assertTrue(fullActual2);
    }

    @Test
    public void enqueueDequeueTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(4);
        arb.enqueue(3);

        int enqueueExpected = 3;
        int enqueueActual = (int) arb.peek();
        assertEquals(enqueueExpected, enqueueActual);

        arb.enqueue(4);
        int enqueueExpected2 = 3;
        int enqueueActual2 = (int) arb.peek();
        assertEquals(enqueueExpected2, enqueueActual2);

        int dequeueExpected = 3;
        int dequeueActual = (int) arb.dequeue();
        assertEquals(dequeueExpected, dequeueActual);
    }
}
