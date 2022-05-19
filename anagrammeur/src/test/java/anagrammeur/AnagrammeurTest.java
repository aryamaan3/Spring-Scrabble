package anagrammeur;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AnagrammeurTest {
    Anagrammeur anagrammeur = new Anagrammeur();

    AnagrammeurTest() throws IOException {
    }

    @Test
    public void TestinitialiseDictionnaire() {
        ArrayList<String> dictionnaire = anagrammeur.getDictionnaire();
        assertEquals("Aaron", dictionnaire.get(0), "ok");
    }

    @Test
    public void TestGetMotPossible() {
        ArrayList<String> listemot = anagrammeur.getMotPossible("Aaron");
        assertEquals(22739, anagrammeur.getDictionnaire().size());
        listemot = anagrammeur.getMotPossible("abat-jour");
        assertEquals(22738, anagrammeur.getDictionnaire().size());
    }

}
