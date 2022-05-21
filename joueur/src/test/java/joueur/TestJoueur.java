package joueur;

import org.testng.annotations.Test;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class TestJoueur {
    ArrayList<Joueur> joueursT = new ArrayList<>();
    ArrayList<Integer> idJoueursT = new ArrayList<>();
    ArrayList<Character> random = new ArrayList<>();
    @Test
    public void Testjouer() {
        joueursT.add(new Joueur(1));
        idJoueursT.add(1);
        random.add('S');
        random.add('L');
        random.add('O');
        random.add('Z');
        random.add('S');
        random.add('F');
        random.add('J');
        //assertEquals("OZFS",joueursT.get(0).jouer(random));
    }
}
