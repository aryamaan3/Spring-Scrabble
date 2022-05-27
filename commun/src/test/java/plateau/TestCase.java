package plateau;

import org.testng.annotations.Test;
import static org.junit.Assert.*;

public class TestCase {
    int randomInt = 1;
    Case cTest = new Case(randomInt);
    Character c = 'c';
    @Test
    public void testIsEmpty(){
        Case cTest = new Case(randomInt);
        cTest.setValeur(c);
        assertFalse(cTest.isEmpty());
    }

    @Test
    public void testGetType(){
        assertEquals(TypeDeCase.LETTRE_DOUBLE,cTest.getType());
    }


    @Test
    public void testSetGetValeur(){
        cTest.setValeur(c);
        assertEquals(c,cTest.getValeur());
    }


}
