package partie;

import joueur.Joueur;

import java.util.ArrayList;

public class Partie {
    ArrayList<Joueur> joueurs;
    public Partie (ArrayList<Joueur> joueurs)
    {
        this.joueurs = joueurs;
    }

    public ArrayList<Character> getMain (int id) {
        //TODO à changer !
        ArrayList<Character> random = new ArrayList<>();
        random.add('S');
        random.add('L');
        random.add('O');
        random.add('Z');
        random.add('S');
        random.add('F');
        random.add('J');
        return random;
    }

    public String demandeJouer(int id)
    {
        return this.joueurs.get(id).jouer(getMain(id));
    }

    public void lancerPartie ()
    {
        System.out.println("Le jeu commence");
        System.out.println("Il y a " + joueurs.size() + " joueurs");
        System.out.println("------------------------------------");
        System.out.println("Le joueur " + 1 + " va commencer par choisir un mot");
        System.out.println("Le joueur " + 1 + " a choisi le mot : " + demandeJouer(0));
        System.out.println("-----------------Fin----------------");
    }

    public static void main(String[] args) {
        ArrayList<Joueur> joueurs = new ArrayList<>();
        joueurs.add(new Joueur(1));
        Partie partie = new Partie(joueurs);
        partie.lancerPartie();
    }
}
