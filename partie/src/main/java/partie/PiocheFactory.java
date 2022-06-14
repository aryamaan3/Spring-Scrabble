package partie;

import java.util.ArrayList;
import java.util.List;

public class PiocheFactory {
    static List<Character> pioche = new ArrayList<>();
    
    static List<Character> creerPioche(){
        for (int i = 0; i < 9; i++) {
            pioche.add('a');
        }
        for (int i = 0; i < 2; i++) {
            pioche.add('b');
            pioche.add('c');
            pioche.add('f');
            pioche.add('g');
            pioche.add('h');
            pioche.add('p');
            pioche.add('v');
        }
        for (int i = 0; i < 3; i++) {
            pioche.add('d');
            pioche.add('m');
        }
        for (int i = 0; i < 15; i++) {
            pioche.add('b');
        }
        for (int i = 0; i < 8; i++) {
            pioche.add('i');
        }
        
        for (int i = 0; i < 5; i++) {
            pioche.add('l');
        }
        for (int i = 0; i < 6; i++) {
            pioche.add('n');
            pioche.add('o');
            pioche.add('r');
            pioche.add('s');
            pioche.add('t');
            pioche.add('u');
        }
        pioche.add('j');
        pioche.add('k');
        pioche.add('q');
        pioche.add('w');
        pioche.add('x');
        pioche.add('y');
        pioche.add('z');
        return pioche;
    }
}
