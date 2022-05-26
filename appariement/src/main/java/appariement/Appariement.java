package appariement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

@Component
public class Appariement
{
    Queue<Integer> joueursLibres = new LinkedList<>();
    HashMap<Integer, String> joueursUrls = new HashMap<>();
    Queue<String> partiesLibres = new LinkedList<>();
    private static final String kHttp = "http://";

    @Autowired AppariementConsumer app;

    Appariement()
    {}

    void addJoueur(int id, String url)
    {
        joueursLibres.add(id);
        joueursUrls.put(id, url);

        verifieJeuPossible();
    }

    void addPartie(String url)
    {
        partiesLibres.add(url);

        verifieJeuPossible();
    }

    void verifieJeuPossible()
    {
        if (joueursLibres.size() > 0 && partiesLibres.size() > 0)
        {
            //TODO : pour l'instant on prends qu'un joueur
            int j1 = joueursLibres.poll();
            String j1Url = joueursUrls.remove(j1);
            String partie = partiesLibres.poll();
            app.creerPartie(kHttp + partie, j1, j1Url);
        }
    }

}
