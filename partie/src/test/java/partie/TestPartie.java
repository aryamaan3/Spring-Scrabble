package partie;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import plateau.Case;
import plateau.Plateau;


import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Partie.class })
public class TestPartie
{
    @MockBean
    PartieConsumer partieConsumer;

    static ArrayList<Case> getJoueurResponse()
    {
        String MainDuJoueur = "axbfrhl";
        ArrayList<Case> List = new ArrayList<>();
        Case center = new Case(5);
        center.setX(6);
        center.setY(7);
        center.setValeur(MainDuJoueur.charAt(0));
        List.add(center);
        for (int i = 1; i < 3; i++) {
            Case c = new Case(0);
            c.setX(center.getX()+i);
            c.setY(center.getY());
            c.setValeur(MainDuJoueur.charAt(i));
            List.add(c);
        }
        return List;
    }

    @Test
    public void testPartie()
    {
        assertNotNull(partieConsumer);
        ArrayList<Integer> j = new ArrayList<>();
        j.add(1);
        j.add(2);
        j.add(3);
        ArrayList<String> urls = new ArrayList<>();
        urls.add("test");
        urls.add("test");
        urls.add("test");
        Partie p = new Partie();
        p.linker = partieConsumer;
        when(partieConsumer.jouer(anyString(), any(Plateau.class), anyString())).thenReturn(getJoueurResponse());
        p.setJoueurs(j, urls);
    }
    
}
