package partie;

import data.PartieToJoueur;
import data.PayloadJoueur;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import plateau.Placement;


import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Partie.class })
public class TestPartieUT
{
    @MockBean
    PartieConsumer partieConsumer;

    static ArrayList<Placement> getJoueurResponse()
    {
        String MainDuJoueur = "tacherr";
        ArrayList<Placement> List = new ArrayList<>();
        Placement center = new Placement(MainDuJoueur.charAt(0), 6, 7);
        List.add(center);
        for (int i = 1; i < 5; i++) {
            Placement c = new Placement(MainDuJoueur.charAt(i), center.getX()+i, center.getY());
            List.add(c);
        }
        return List;
    }

    @Test
    public void testPartie()
    {
        assertNotNull(partieConsumer);
        ArrayList<String> urls = new ArrayList<>();
        urls.add("test");
        urls.add("test");
        urls.add("test");
        urls.add("test");
        Partie p = new Partie();
        p.linker = partieConsumer;
        when(partieConsumer.jouer(anyString(), any(PartieToJoueur.class))).thenReturn(new PayloadJoueur(getJoueurResponse()));
        assertTrue(p.setJoueurs(urls));
    }

}
