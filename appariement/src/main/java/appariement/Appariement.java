package appariement;

import data.PlayerDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        //TODO : pour l'instant on prends qu'un joueur
        // à remplacer par > 3
        if (joueursLibres.size() > 0 && partiesLibres.size() > 0)
        {
            var j1 = joueursLibres.poll();
            var j1Url = joueursUrls.remove(j1);
            var partie = partiesLibres.poll();
            ArrayList<Integer> ids = new ArrayList<>();
            ArrayList<String> urls = new ArrayList<>();
            ids.add(j1);
            urls.add(j1Url);
            app.creerPartie(kHttp + partie, new PlayerDetails(ids, urls));
        }
    }

}
