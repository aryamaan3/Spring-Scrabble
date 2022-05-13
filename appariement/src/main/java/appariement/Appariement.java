package appariement;

import joueur.Joueur;
import partie.Partie;

import java.util.ArrayList;

public class Appariement {
    Partie partie;
    ArrayList<Joueur> joueurs;
    public Appariement (Partie p, ArrayList<Joueur> j)
    {
        this.partie = p;
        this.joueurs = j;
    }

    public ArrayList<Character> getMain (int id)
    {
        return partie.getMain(id);
    }

    public String demanderJouer (int id)
    {
        return this.joueurs.get(id-1).jouer(getMain(id-1));
    }

    public void lancerPartie ()
    {
        System.out.println("Le jeu commence");
        System.out.println("Il y a " + joueurs.size() + " joueurs");
        System.out.println("------------------------------------");
        System.out.println("Le joueur " + 1 + " va commencer par choisir un mot");
        System.out.println("Le joueur " + 1 + " a choisi le mot : " + demanderJouer(1));
        System.out.println("-----------------Fin----------------");
    }

    public static void main(String[] args) {
        ArrayList<Joueur> joueurs = new ArrayList<>();
        joueurs.add(new Joueur(1));
        ArrayList<Integer> idJoueurs = new ArrayList<>();
        idJoueurs.add(1);
        Partie partie = new Partie(idJoueurs);
        Appariement linker = new Appariement(partie, joueurs);
        linker.lancerPartie();
    }
}
