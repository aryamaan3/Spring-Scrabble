package plateau;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestPointLettre {

    @Test
    public void testEnum(){
        assertEquals(PointLettre.valueOf("A").value,"1"); // test retrieving value of enum with a String in input
    }
}
