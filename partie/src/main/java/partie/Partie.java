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
    static final String kRepiocheMot = "sososos";

    @Autowired
    PartieConsumer linker;

    public Partie()
    {}

    boolean setJoueurs(List<String> urls)
    {
        this.joueursUrls.clear();
        for (int i = 1; i < urls.size() + 1; i++)
        {
            this.joueurs.add(i);
            this.joueursUrls.put(joueurs.get(i-1), urls.get(i-1));
        }
        return lancerPartie();
    }

    void setJoueurs(PlayerDetails playerData)
    {
        setJoueurs(playerData.getUrls());
    }

    ArrayList<Placement> appelJoueur(String url, String main)
    {
        return linker.jouer(url, new PartieToJoueur(board, main)).getPayloadJoueur();
    }

    /**
     * Transfome la queue de char en String pour l'envoi au
     * Joueur
     * @param main du joueurApplication.joueur
     * @return La main du joueurApplication.joueur
     */
    String getMain(Queue<Character> main)
    {
        return main.stream()
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
        var motChoisie = appelJoueur(joueursUrls.get(id), getMain(main.get(id)));
        var mot = caseToString(motChoisie);
        if (Objects.equals(mot, kRepiocheMot))
        {
            emptyMain(id);
            return demandeJouer(id);
        }
        if (verifierMot(mot))
        {
            updateMain(id, mot);
            placerMot(motChoisie);
            joueurPoints.put(id, joueurPoints.get(id) + attribuerPoints(motChoisie));
            return mot;
        }
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
            this.main.put(id, removeFromMain(this.main.get(id), c));
        }
    }

    Queue<Character> removeFromMain(Queue<Character> q, Character c)
    {
        Queue<Character> ref = new LinkedList<>();
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

        return q;
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
     * @param mot placé par le joueurApplication.joueur
     */
    int attribuerPoints(ArrayList<Placement> mot)
    {
        int points = 0;
        for (Placement lettre : mot)
        {
            points += PointLettre.valueOf(lettre.getLettre().toString().toUpperCase()).value;
        }

        return points;
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

    void emptyMain(int id)
    {
        var toPutBack = this.main.get(id);
        for (int i = 0; i < kTailleMain; i++)
        {
            this.pioche.putBackInPioche(toPutBack.poll());
        }
        this.main.get(id).clear();
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

    boolean isBoardFull(ArrayList<Integer> joueurs)
    {
        int nbLineFree = 0;
        for (int i = 0; i < 15; i++)
        {
            if (board.getNumberOfLettresPlacedOnLine(i) == 0)
            {
                nbLineFree++;
            }
            if (board.getNumberOfLettersPlacedOnColumn(i) == 0)
            {
                nbLineFree++;
            }
        }
        return nbLineFree < joueurs.size();
    }

    boolean isGameOn(ArrayList<Integer> joueurs, Map<Integer, Integer> joueurPoints)
    {
        for (int id : joueurs)
        {
            if (joueurPoints.get(id) >= 50)
            {
                return false;
            }
        }

        return !isBoardFull(joueurs);

    }

    Map<Integer, Integer> sortByValue(Map<Integer, Integer> map)
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

    int getWinners(Map<Integer, Integer> joueurPoints)
    {
        List<Integer> keys = new ArrayList<>(joueurPoints.keySet());
        return keys.get(keys.size() - 1);
    }

    /**
     * Lance la PartieApplication.partie
     */
    public boolean lancerPartie()
    {
        setupPartie();
        System.out.println("Le jeu commence");
        System.out.println("Il y a " + joueurs.size() + " joueurs");
        System.out.println("------------------------------------");
        int round = 1;
        this.joueurPoints = sortByValue(this.joueurPoints);
        while (isGameOn(this.joueurs, this.joueurPoints))
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
            System.out.println("Voici le plateau apres ce round");
            System.out.println("------------------------------------");
            System.out.println("");
            System.out.println(this.board);
            System.out.println("------------------------------------");
            round ++;
            System.out.println("------------------------------------");
            System.out.println(classement());
        }
        System.out.println("-----------------Fin----------------");
        //System.out.println("Le[s] gagnant[s] : " + getWinners(this.joueurPoints));
        return true;
    }
}
