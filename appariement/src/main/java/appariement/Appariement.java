package appariement;

import data.PlayerDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Appariement
{
    List<String> joueursLibres = new ArrayList<>();
    Queue<String> partiesLibres = new LinkedList<>();
    Queue<String> anagrammeursLibres = new LinkedList<>();

    @Autowired AppariementConsumer app;

    Appariement()
    {}

    void addJoueur(String url)
    {
        joueursLibres.add(url);

        verifieJeuPossible();
    }

    void addPartie(String url)
    {
        partiesLibres.add(url);

        verifieJeuPossible();
    }

    void addAnagrammeur(String url)
    {
        anagrammeursLibres.add(url);
    }

    String getFreeAnagrammeur()
    {
        return anagrammeursLibres.peek();
    }

    void verifieJeuPossible()
    {
        //TODO : pour l'instant on prends qu'un joueur
        // à remplacer par > 3
        if (joueursLibres.size() > 3 && partiesLibres.size() > 0)
        {
            var partie = partiesLibres.poll();
            app.creerPartie(partie, new PlayerDetails(joueursLibres));
        }
    }

}
