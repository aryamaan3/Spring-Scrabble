package plateau;

import org.testng.annotations.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TestPlateauFactory {
    private List<List<Case>> pT;

    @Test
    public void testCreerPlateau(){
        pT = PlateauFactory.creerPlateau();
        assertEquals(pT,PlateauFactory.creerPlateau());
    }
}
