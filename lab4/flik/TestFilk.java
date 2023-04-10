package flik;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestFilk {
    @Test
    public void filkTest() {
        int a = 129;
        int b = 129;

        boolean flag = Flik.isSameNumber(a, b);
        assertTrue(flag);
    }

}
