package appariement;

import joueur.Joueur;

import joueur.*;
import partie.Partie;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;


public class TestAppariement {
    ArrayList<Joueur> joueursT = new ArrayList<>();
    ArrayList<Integer> idJoueursT = new ArrayList<>();
    Partie partieT = new Partie(idJoueursT);
    Appariement linkerT = new Appariement(partieT, joueursT);

    @Test
    public void TestGetMain() {
        joueursT.add(new Joueur(1));
        idJoueursT.add(1);
        ArrayList<Character> compare = new ArrayList<>();
        compare.add('S');
        compare.add('L');
        compare.add('O');
        compare.add('Z');
        compare.add('S');
        compare.add('F');
        compare.add('J');
        assertEquals(compare,linkerT.getMain(1));
    }

    @Test
    public void TestDemanderJoueur() {
        joueursT.add(new Joueur(1));
        idJoueursT.add(1);
        assertEquals("OZFS",linkerT.demanderJouer(1));
    }


}
