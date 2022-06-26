package partieController;

import data.Message;
import data.PartieToJoueur;
import data.PayloadJoueur;
import data.PlayerDetails;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.testng.AssertJUnit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import partie.Partie;
import partie.PartieConsumer;
import partie.PartieController;
import plateau.Placement;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Partie.class, PartieController.class})
public class TestPartieControllerIT
{
    @MockBean
    PartieConsumer partieConsumer;

    @Autowired
    PartieController partieController;

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
    public void initPartieTest()
    {
        List<String> urls = new ArrayList<>();
        urls.add("test");
        urls.add("test");
        urls.add("test");
        urls.add("test");
        partieController.setPartieLinker(partieConsumer);
        when(partieConsumer.jouer(anyString(), any(PartieToJoueur.class))).thenReturn(new PayloadJoueur(getJoueurResponse()));
        assertNotNull(partieController.initPartie(new PlayerDetails(urls)));
    }
}
