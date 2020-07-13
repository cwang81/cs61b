import static org.junit.Assert.*;
import org.junit.Test;

public class FlikTest {
    @Test
    public void flikTest() {
        int a = 128;
        int b = 128;
        int c = 127;
        int d = 127;

        assertEquals(c, d);
        assertTrue(Flik.isSameNumber(c, d));
        assertEquals(a, b);
        assertTrue(Flik.isSameNumber(a, b));
    }
}
