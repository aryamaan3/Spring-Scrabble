package partie;

import data.PartieToJoueur;
import data.PlayerDetails;
import factory.PlateauFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import plateau.Placement;
import plateau.Plateau;
import plateau.PointLettre;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class Partie
{
    ArrayList<Integer> joueurs = new ArrayList<>();
    HashMap<Integer, String> joueursUrls = new HashMap<>();
    Map<Integer, Integer> joueurPoints = new TreeMap<>();
    HashMap<Integer, Queue<Character>> main = new HashMap<>();
    Pioche pioche = new Pioche();
    Plateau board = new Plateau(PlateauFactory.creerPlateau());
    static final int kTailleMain = 7;
    static final String kRepiocheMot = "imout";
    private static final String kHttp = "http://";

    @Autowired
    PartieConsumer linker;

    public Partie()
    {}

    void setJoueurs(ArrayList<Integer> joueurs, ArrayList<String> urls)
    {
        this.joueurs = joueurs;
        this.joueursUrls.clear();
        for (int i = 0; i < urls.size(); i++)
        {
            this.joueursUrls.put(joueurs.get(i), urls.get(i));
        }
        lancerPartie();
    }

    void setJoueurs(PlayerDetails playerData)
    {
        setJoueurs(playerData.getIds(), playerData.getUrls());
    }

    ArrayList<Placement> appelJoueur(int id)
    {
        String url = joueursUrls.get(id);
        return linker.jouer(kHttp + url, new PartieToJoueur(board, getMain(id))).getPayloadJoueur();
    }

    /**
     * Transfome la queue de char en String pour l'envoi au
     * Joueur
     * @param id du joueurApplication.joueur
     * @return La main du joueurApplication.joueur
     */
    String getMain(int id)
    {
        return this.main.get(id).stream()
                .map(Object::toString)
                .reduce((acc, e) -> acc + e)
                .get();
    }

    /**
     * Demande le joueurApplication.joueur avec l'id de choisir un mot
     * afin de jouer
     * @param id du joueurApplication.joueur en question
     * @return le mot choisi
     */
    String demandeJouer(int id)
    {
        fillMain(id);
        var motChoisie = appelJoueur(id);
        var mot = caseToString(motChoisie);
        if (Objects.equals(mot, kRepiocheMot))
        {
            //TODO : this means player wants to pick new letters
        }
        if (verifierMot(mot))
        {
            updateMain(id, mot);
            placerMot(motChoisie);
            attribuerPoints(id, motChoisie);
            return mot;
        }
        // Si verifieMot renvoie false refaire tous le process avec appelJoueur
        //TODO : reinitialiser la main du joueur avant de recommencer
        return demandeJouer(id);
    }

    String caseToString(ArrayList<Placement> listCase)
    {
        StringBuilder mot = new StringBuilder();
        for (Placement aCase : listCase)
        {
            mot.append(aCase.getLettre());
        }
        return mot.toString();
    }

    void updateMain(int id, String mot)
    {
        for (Character c : mot.toCharArray())
        {
            removeFromMain(id, c);
        }
    }

    void removeFromMain(int id, Character c)
    {
        Queue<Character> ref = new LinkedList<>();
        var q = this.main.get(id);
        var s = q.size();
        int cnt = 0;

        while (!q.isEmpty() && q.peek() != c)
        {
            ref.add(q.peek());
            q.remove();
            cnt++;
        }

        if (q.isEmpty())
        {
            while (!ref.isEmpty())
            {
                // Pushing all the elements back into q
                q.add(ref.peek());
                ref.remove();
            }
        }

        else
        {
            q.remove();
            while (!ref.isEmpty())
            {
                // Pushing all the elements back into q
                q.add(ref.peek());
                ref.remove();
            }
            var k = s - cnt - 1;
            while (k-- >0)
            {
                // Pushing elements from front of q to its back
                var p = q.peek();
                q.remove();
                q.add(p);
            }
        }

        this.main.put(id, q);
    }

    /**
     * On place le mot sur le plateau
     * @param mot choisi par le joueurApplication.joueur
     */
    void placerMot(ArrayList<Placement> mot)
    {
        for (Placement aCase : mot)
        {
            board.setCase(aCase.getX(), aCase.getY(), aCase.getLettre());
        }
    }

    /**
     * Ajoute les points obtenus grace au mot placé
     * au score du joueurApplication.joueur
     * @param id du joueurApplication.joueur
     * @param mot placé par le joueurApplication.joueur
     */
    void attribuerPoints(int id, ArrayList<Placement> mot)
    {
        int points = 0;
        for (Placement lettre : mot)
        {
            points += PointLettre.valueOf(lettre.getLettre().toString().toUpperCase()).value;
        }
        joueurPoints.put(id, joueurPoints.get(id) + points);
    }

    /**
     * Dans le cas où le joueurApplication.joueur trouve qu'il ne peut pas faire un mot
     * il demande de changer sa main
     * @param id du joueurApplication.joueur en question
     */
    void RepiocheLettres(int id)
    {
        //TODO
    }

    /**
     * Verifie si le mot choisi est dans le fichier liste_francais
     * @param mot choisi par le joueurApplication.joueur
     * @return vrai si le mot existe
     */
    boolean verifierMot(String mot)
    {
        //TODO : check if mot is okay and if it can be placed on board
        return true;
    }

    /**
     * Rempli la main du joueurApplication.joueur
     * @param id du joueurApplication.joueur
     */
    void fillMain(int id)
    {
        if (this.main.get(id).size() != kTailleMain)
        {
            while (this.main.get(id).size() != kTailleMain) {
                this.main.get(id).add(pioche.piocher());
            }
        }
    }

    /**
     * Initialise la main du joueurApplication.joueur
     * @return Main du joueurApplication.joueur
     */
    Queue<Character> initMain()
    {
        Queue<Character> main = new LinkedList<>();
        for (int i = 0; i < kTailleMain; i++)
        {
            main.add(pioche.piocher());
        }
        return main;
    }

    /**
     * Initialise la PartieApplication.partie
     * 1. Rempli les mains de chaque joueurApplication.joueur
     */
    void setupPartie()
    {
        for (Integer id : this.joueurs)
        {
            this.main.put(id, initMain());
            this.joueurPoints.put(id, 0);
        }
    }

    int getPoints(int id)
    {
        return this.joueurPoints.get(id);
    }

    boolean isGameOn()
    {
        //sort joueursPoints by value
        this.joueurPoints = sortByValue(joueurPoints);

        for (int id : joueurs)
        {
            if (joueurPoints.get(id) > 50)
            {
                return false;
            }
        }

        return true;

    }

    private Map<Integer, Integer> sortByValue(Map<Integer, Integer> map)
    {
        //sort tree map by value

        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }


    String classement()
    {
        StringBuilder output = new StringBuilder();
        output.append("Classement\n");
        this.joueurPoints = sortByValue(this.joueurPoints);
        // get keys
        List<Integer> keys = new ArrayList<>(this.joueurPoints.keySet());

        // reverse iterate on keys
        for (int i = keys.size() - 1; i >= 0; i--)
        {
            output.append("Joueur ").append(i + 1).append(" - ").append(this.joueurPoints.get(keys.get(i))).append("\n");
        }

        return output.toString();
    }

    List<Integer> getWinners()
    {
        List<Integer> winners = new ArrayList<>();
        for (int id : joueurs)
        {
            if (joueurPoints.get(id) > 50)
            {
                winners.add(id);
            }
        }
        return winners;
    }

    /**
     * Lance la PartieApplication.partie
     */
    public void lancerPartie()
    {
        setupPartie();
        System.out.println("Le jeu commence");
        System.out.println("Il y a " + joueurs.size() + " joueurs");
        System.out.println("------------------------------------");
        int round = 1;
        while (isGameOn())
        {
            //if (round == 3) loop = false;
            System.out.println("Starting round : " + round);
            for (int id : joueurs)
            {
                System.out.println("Le joueur " + id + " va commencer par choisir un mot");
                int pointsBefore = getPoints(id);
                System.out.println("Le joueur " + id + " a choisi le mot : " + demandeJouer(id));
                System.out.println("Ce mot vaut " + (getPoints(id) - pointsBefore) + " points");
            }
            round ++;
            System.out.println("------------------------------------");
            System.out.println(classement());
        }
        System.out.println("-----------------Fin----------------");
        System.out.println("Le[s] gagnant[s] : " + getWinners());
    }
}
