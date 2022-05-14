package partie;

import org.testng.annotations.Test;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;


public class TestPartie {

    @Test
    public void TestGetMain() {
        ArrayList<Integer> joueursT = new ArrayList<>();
        joueursT.add(1);
        Partie partieT = new Partie(joueursT);
        partieT.getMain(0);
        ArrayList<Character> compare = new ArrayList<>();
        compare.add('S');
        compare.add('L');
        compare.add('O');
        compare.add('Z');
        compare.add('S');
        compare.add('F');
        compare.add('J');
        assertEquals(compare,partieT.getMain(0));
    }
}
