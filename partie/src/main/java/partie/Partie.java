package partie;

import java.util.ArrayList;

public class Partie {
    ArrayList<Integer> joueurs;
    public Partie (ArrayList<Integer> joueurs)
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
}
