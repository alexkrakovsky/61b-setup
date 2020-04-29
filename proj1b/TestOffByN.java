import static org.junit.Assert.*;
import org.junit.Test;

public class TestOffByN {

    @Test
    public void testEqualChars() {
        CharacterComparator ob3 = new OffByN(3);
        assertTrue(ob3.equalChars('a', 'd'));
        assertTrue(ob3.equalChars('d', 'a'));
        assertFalse(ob3.equalChars('c', 'z'));
        assertFalse(ob3.equalChars('A', 'A'));
    }
}
