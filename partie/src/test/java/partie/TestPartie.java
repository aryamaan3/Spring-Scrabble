package partie;

import joueur.Joueur;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;


public class TestPartie {
    Partie pT;
    ArrayList<Joueur> jT = new ArrayList<>();
    String pivot;

    public void initTest() {
        jT.add(new Joueur(1));
        pT = new Partie(jT);
        pT.setupPartie();
    }

    @Test
    public void testGetMain() {
        initTest();
        pivot = pT.getMain(1);
        assertEquals(pivot, pT.getMain(1));
    }

    @Test
    public void testDemandeJouer() {
        initTest();
        pivot = pT.demandeJouer(1);
        assertEquals(pivot, pT.demandeJouer(1));
    }

    @Test
    public void testAttribuerGetPoints() {
        initTest();
        pT.attribuerPoints(1, "toto");
        assertEquals(10, pT.getPoints(1));
    }

    @Test
    public void testFillMain() {
        initTest();
        pT.fillMain(1);
        pivot = pT.getMain(1);
        assertEquals(pivot, pT.getMain(1));
    }

    /*@Test
    public void testInitMain() {
        initTest();
        Queue<Character> p = pT.initMain(1);
        pivot = pT.getMain(1);
        assertEquals(p, pivot);
    }*/

    @Test
    public void SetupPartie() {
        initTest();
        assertEquals(0, pT.getPoints(1));
        testAttribuerGetPoints();
    }
    
}
