package plateau;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestPointLettre {

    @Test
    public void testEnum(){
        assertEquals(1, (int) PointLettre.valueOf("A").value); // test retrieving value of enum with a String in input
        assertSame(PointLettre.valueOf("A").value, 1); // to check if it's same type 

    }
}
