package partie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Partie {
    ArrayList<Integer> joueurs = new ArrayList<>();
    //TODO : peut etre à remplacer par des classes ?
    HashMap<Integer, String> joueursUrls = new HashMap<>();
    HashMap<Integer, Integer> joueurPoints = new HashMap<>();
    HashMap<Integer, Queue<Character>> main = new HashMap<>();
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
        //TODO : loop on urls and set in hashmap instead of hardcoding 1st player
        this.joueursUrls.put(joueurs.get(0), urls.get(0));
        appelJoueur(1);
    }

    void appelJoueur(int id)
    {
        String url = joueursUrls.get(id);
        System.out.println(linker.jouer(kHttp + url));
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
        //String mot = this.joueurs.get(id).jouer(getMain(id));
        String mot = "ss";
        if (Objects.equals(mot, kRepiocheMot))
        {
            //TODO : this means player wants to pick new letters
        }
        if (verifierMot(mot))
        {
            placerMot(mot);
            attribuerPoints(id, mot);
            return mot;
        }
        return demandeJouer(id);
    }

    /**
     * On place le mot sur le plateau
     * @param mot choisi par le joueurApplication.joueur
     */
    void placerMot(String mot) //TODO : String à remplacer
    {

    }

    /**
     * Ajoute les points obtenus grace au mot placé
     * au score du joueurApplication.joueur
     * @param id du joueurApplication.joueur
     * @param mot placé par le joueurApplication.joueur
     */
    void attribuerPoints(int id, String mot) //TODO : String à remplacer par Lettre
    {
        this.joueurPoints.put(id, this.joueurPoints.get(id) + 10);
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
    boolean verifierMot(String mot) //TODO : String à remplacer par Lettre
    {
        return true;
    }

    /**
     * trouver une lettre au hasard depuis la banque des mots
     * @return une lettre
     */
    private Character getRandomLetter()
    {
        //TODO : on devrait prendre une lettre disponible parmis une banque pre-établis
        Random r = new Random();
        return (char)(r.nextInt(26) + 'a');
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
                // TODO : add.(new Lettre(getRandomLetter)) quand Lettre est crée
                this.main.get(id).add(getRandomLetter());
            }
        }
    }

    /**
     * Initialise la main du joueurApplication.joueur
     * @param id du joueurApplication.joueur
     * @return Main du joueurApplication.joueur
     */
    Queue<Character> initMain(int id)
    {
        Queue<Character> main = new LinkedList<>();
        for (int i = 0; i < kTailleMain; i++)
        {
            main.add(getRandomLetter());
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
            this.main.put(id, initMain(id));
            this.joueurPoints.put(id, 0);
        }
    }

    int getPoints(int id)
    {
        return joueurPoints.get(id);
    }

    /**
     * Lance la PartieApplication.partie
     */
    public void lancerPartie() {
        setupPartie();
        System.out.println("Le jeu commence");
        System.out.println("Il y a " + joueurs.size() + " joueurs");
        System.out.println("------------------------------------");
        System.out.println("Le joueurApplication.joueur " + 1 + " va commencer par choisir un mot");
        System.out.println("Le joueurApplication.joueur " + 1 + " a choisi le mot : " + demandeJouer(1));
        System.out.println("Le joueurApplication.joueur " + 1 + " a desormais " + getPoints(1) + " points");
        System.out.println("-----------------Fin----------------");
    }
}
