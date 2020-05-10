package hw2;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestPercolation {

    @Test
    public void test1() {
        Percolation p = new Percolation(5);
        p.open(1, 3);
        p.open(2, 3);
        p.open(3, 3);
        p.open(4, 3);
        assertFalse(p.isFull(4, 3));
        assertEquals(4, p.numberOfOpenSites());
        assertFalse(p.percolates());

    }
}
