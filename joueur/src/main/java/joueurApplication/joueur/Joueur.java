package joueurApplication.joueur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import plateau.Case;
import plateau.Placement;
import plateau.Plateau;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@Component
public class Joueur {
    boolean didIRetry = false;
    private static final int[] traverseRoute = {7, 8, 6, 5, 9, 4, 10, 3, 11, 2, 12, 1, 13, 0, 14};

    @Autowired
    JoueurConsumer linker;

    //TODO : get player id from dockerfile?

    public Joueur(){}


    public String choisirMotPlusLong(ArrayList<String> listeDeMot){
        return Collections.max(listeDeMot, Comparator.comparing(s -> s.length()));
    }

    public ArrayList<Placement> placeOnAxeX(String mot, Integer x, Integer firstY){
        ArrayList<Placement> reponse = new ArrayList<>();
        for(int iterator = 0; iterator < mot.length(); iterator++){
            Placement placement = new Placement(mot.charAt(iterator),x,firstY+iterator);
            reponse.add(placement);
        }
        return reponse;
    }

    public ArrayList<Placement> placeOnAxeY(String mot, Integer firstX, Integer y){
        ArrayList<Placement> reponse = new ArrayList<>();
        for(int iterator = 0; iterator < mot.length(); iterator++){
            Placement placement = new Placement(mot.charAt(iterator), iterator+firstX, y);
            reponse.add(placement);
        }
        return reponse;
    }

    public ArrayList<Placement> firstPlacement(ArrayList<String> listeMotsPossibles){
        int posY = 7;// la ligne du milieu
        String motChoisi = choisirMotPlusLong(listeMotsPossibles);
        int milieu = Math.round(((float) motChoisi.length())/2);
        int firstPosX = 3;
        return placeOnAxeY(motChoisi, firstPosX, posY);
    }

    public int getLetterPositionInWord(String word, Character letter){
        return word.indexOf(letter);
    }

    public ArrayList<Placement> findVerticalWord(ArrayList<String> listeMotsPossibles, Plateau plateau){
        for(int x = 0; x < 15; x++){
            if(plateau.getNumberOfLettersPlacedOnColumn(x) == 1){
                ArrayList<Case> colonne = plateau.getColonne(x);
                for(int i = 0; i < colonne.size(); i++){
                    if(!colonne.get(i).isEmpty()){
                        Case instanceCase = plateau.getCase(x,i);
                        Character lettre = instanceCase.getValeur();
                        for(String mot: listeMotsPossibles){
                            try{
                                int positionLettre = mot.indexOf(lettre);
                                int firstY = i - positionLettre;
                                return placeOnAxeX(mot,x,firstY);
                            }
                            catch (Throwable throwable){
                                throwable.printStackTrace();
                            }

                        }
                    }
                }
            }
        }
        return null;
    }

    private ArrayList<Placement> findHorizontalWord(ArrayList<String> listeMotsPossibles, Plateau plateau)
    {
        for (var i : traverseRoute)
        {
            if (plateau.getNumberOfLettersPlacedOnColumn(i) == 0)
            {
                String motChoisi = choisirMotPlusLong(listeMotsPossibles);
                return placeOnAxeX(motChoisi, i, 3);
            }
        }
        return null;
    }

    private ArrayList<Placement> placeOnFreeVerticals(ArrayList<String> listeMotsPossibles, Plateau plateau)
    {
        for (var i : traverseRoute)
        {
            if (plateau.getNumberOfLettresPlacedOnLine(i) == 0)
            {
                String motChoisi = choisirMotPlusLong(listeMotsPossibles);
                return placeOnAxeY(motChoisi, 3, i);
            }
        }
        return null;
    }

    private ArrayList<Placement> getRepiocheMot()
    {
        ArrayList<Placement> output = new ArrayList<>();
        output.add(new Placement('s', 0, 0));
        output.add(new Placement('o', 0, 0));
        output.add(new Placement('s', 0, 0));
        output.add(new Placement('o', 0, 0));
        output.add(new Placement('s', 0, 0));
        output.add(new Placement('o', 0, 0));
        output.add(new Placement('s', 0, 0));

        return output;
    }

    public ArrayList<Placement> jouer (Plateau plateau, String main) {
        var urlAnagrammeur = linker.getFreeAnagrammeur();
        var listeMotsPossibles = linker.getMotPossible(main, urlAnagrammeur).getPayloadJoueur();
        if (listeMotsPossibles.size() < 1)
        {
            if (didIRetry)
            {
                listeMotsPossibles.add("yakuzas");
            }
            else
            {
                didIRetry = true;
                return getRepiocheMot();
            }
        }
        ArrayList<Placement> choix;
        if(plateau.isEmpty()){
            choix = firstPlacement(listeMotsPossibles);
        }
        else choix = findVerticalWord(listeMotsPossibles,plateau);

        if (choix == null)
        {
            choix = findHorizontalWord(listeMotsPossibles,plateau);
        }

        if (choix == null)
        {
            choix = placeOnFreeVerticals(listeMotsPossibles,plateau);
        }

        if (choix == null)
        {
            return getRepiocheMot();
        }
        didIRetry = false;
        return choix;
    }
}
