package plateau;

import java.util.Arrays;
import java.util.List;

public class PlateauFactory {
    static final List<List<Case>> plateau = Arrays.asList(
            Arrays.asList(new Case(4), new Case(0), new Case(0), new Case(1), new Case(0), new Case(0), new Case(0), new Case(4), new Case(0), new Case(0), new Case(0), new Case(1), new Case(0), new Case(0), new Case(4)),
            Arrays.asList(new Case(0), new Case(3), new Case(0), new Case(0), new Case(0), new Case(2), new Case(0), new Case(0), new Case(0), new Case(2), new Case(0), new Case(0), new Case(0), new Case(3), new Case(0)),
            Arrays.asList(new Case(0), new Case(0), new Case(3), new Case(0), new Case(0), new Case(0), new Case(1), new Case(0), new Case(1), new Case(0), new Case(0), new Case(0), new Case(3), new Case(0), new Case(0)),
            Arrays.asList(new Case(1), new Case(0), new Case(0), new Case(3), new Case(0), new Case(0), new Case(0), new Case(1), new Case(0), new Case(0), new Case(0), new Case(3), new Case(0), new Case(0), new Case(1)),
            Arrays.asList(new Case(0), new Case(0), new Case(0), new Case(0), new Case(3), new Case(0), new Case(0), new Case(0), new Case(0), new Case(0), new Case(3), new Case(0), new Case(0), new Case(0), new Case(0)),
            Arrays.asList(new Case(0), new Case(2), new Case(0), new Case(0), new Case(0), new Case(2), new Case(0), new Case(0), new Case(0), new Case(2), new Case(0), new Case(0), new Case(0), new Case(2), new Case(0)),
            Arrays.asList(new Case(0), new Case(0), new Case(1), new Case(0), new Case(0), new Case(0), new Case(1), new Case(0), new Case(1), new Case(0), new Case(0), new Case(0), new Case(1), new Case(0), new Case(0)),
            Arrays.asList(new Case(4), new Case(0), new Case(0), new Case(1), new Case(0), new Case(0), new Case(0), new Case(5), new Case(0), new Case(0), new Case(0), new Case(1), new Case(0), new Case(0), new Case(4)),
            Arrays.asList(new Case(0), new Case(0), new Case(1), new Case(0), new Case(0), new Case(0), new Case(1), new Case(0), new Case(1), new Case(0), new Case(0), new Case(0), new Case(1), new Case(0), new Case(0)),
            Arrays.asList(new Case(0), new Case(2), new Case(0), new Case(0), new Case(0), new Case(2), new Case(0), new Case(0), new Case(0), new Case(2), new Case(0), new Case(0), new Case(0), new Case(2), new Case(0)),
            Arrays.asList(new Case(0), new Case(0), new Case(0), new Case(0), new Case(3), new Case(0), new Case(0), new Case(0), new Case(0), new Case(0), new Case(3), new Case(0), new Case(0), new Case(0), new Case(0)),
            Arrays.asList(new Case(1), new Case(0), new Case(0), new Case(3), new Case(0), new Case(0), new Case(0), new Case(1), new Case(0), new Case(0), new Case(0), new Case(3), new Case(0), new Case(0), new Case(1)),
            Arrays.asList(new Case(0), new Case(0), new Case(3), new Case(0), new Case(0), new Case(0), new Case(1), new Case(0), new Case(1), new Case(0), new Case(0), new Case(0), new Case(3), new Case(0), new Case(0)),
            Arrays.asList(new Case(0), new Case(3), new Case(0), new Case(0), new Case(0), new Case(2), new Case(0), new Case(0), new Case(0), new Case(2), new Case(0), new Case(0), new Case(0), new Case(3), new Case(0)),
            Arrays.asList(new Case(4), new Case(0), new Case(0), new Case(1), new Case(0), new Case(0), new Case(0), new Case(4), new Case(0), new Case(0), new Case(0), new Case(1), new Case(0), new Case(0), new Case(4))
    );

    static List<List<Case>> creerPlateau()
    {
        for (int i = 0; plateau.size()<i; i++){
            for (int j= 0; plateau.get(i).size()<j; j++){
                plateau.get(i).get(j).setY(i);
                plateau.get(i).get(j).setX(j);
            }
        }
        return plateau;
    }

}
