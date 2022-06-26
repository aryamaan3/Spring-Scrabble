package partie;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import factory.PiocheFactory;
import org.junit.Test;

public class TestPioche {
    private List<Character> pT;
    Pioche pioche = new Pioche();

    @Test
    public void testCreerPioche(){
        pT = PiocheFactory.creerPioche();
        assertEquals(pT,PiocheFactory.creerPioche());
    }

    @Test
    public void testPiocher(){
        pT = PiocheFactory.creerPioche();
        char a = pioche.piocher();
        String s = "abcdefghijklmnopqrstuvxyz";
        int b = s.indexOf(a);
        assertNotEquals(-1, b);
    }
}
