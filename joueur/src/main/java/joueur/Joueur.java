package joueur;

import java.util.ArrayList;

public class Joueur {
    int id;
    public Joueur (int id)
    {
        this.id = id;
    }

    public String jouer (ArrayList<Character> main)
    {
        String mot = new StringBuilder().append(main.get(2)).append(main.get(3)).append(main.get(5)).append(main.get(0)).toString();
        return mot;
    }
}
