package factory;

import org.testng.annotations.Test;
import plateau.Case;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class TestPlateauFactory {
    private List<List<Case>> pT;

    @Test
    public void testCreerPlateau(){
        pT = PlateauFactory.creerPlateau();
        assertEquals(pT,PlateauFactory.creerPlateau());
    }
}
