package partie;

import factory.PiocheFactory;

import java.util.List;
import java.util.Random;

public class Pioche {
    private List<Character> pioche;
  
    public Pioche(){
        this.pioche = PiocheFactory.creerPioche();
    }

    Character piocher(){
        Random r = new Random();
        return pioche.remove(r.nextInt((this.pioche.size()-1) + 1));
    }

    void putBackInPioche(Character c)
    {
        pioche.add(c);
    }

}
