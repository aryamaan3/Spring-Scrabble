package plateau;

import org.testng.annotations.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TestPlateau {
    private List<List<Case>> pT;
    Plateau pLT = new Plateau();

    @Test
    public void testSetGetPlateau(){
        System.out.println(pLT.toString());
        //assertEquals(pT,pLT.getPlateau());
    }


}
