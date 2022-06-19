package plateau;

import java.util.ArrayList;
import java.util.List;

public class Plateau
{
    private List<List<Case>> plateau;
    private final int longeur;
    private final int largeur;
    private static final int kCenter = 7;

    public Plateau()
    {
        this.largeur = 15;
        this.longeur = 15;
    }

    public Plateau(List<List<Case>> board)
    {
        this.largeur = 15;
        this.longeur = 15;
        this.plateau = board;
    }

    public List<List<Case>> getPlateau()
    {
        return plateau;
    }

    public void setPlateau(List<List<Case>> plateau)
    {
        this.plateau = plateau;
    }

    public int getLargeur()
    {
        return largeur;
    }

    public int getLongeur()
    {
        return longeur;
    }

    public Case getCentre()
    {
        return getCase(kCenter, kCenter);
    }

    public Case getCase(int x, int y)
    {
        return this.plateau.get(y).get(x);
    }

    //TODO : @geoffreylalic à verifier si ça marche
    public ArrayList<Case> getPosedCase()
    {
        ArrayList<Case> cases = new ArrayList<>();
        for (var aCol : this.plateau)
        {
            for (var aCase : aCol)
            {
                if(!aCase.isEmpty()){
                    cases.add(aCase);
                }
            }
        }
        return cases;
    }

    public ArrayList<Case> getLigne(int y)
    {
        ArrayList<Case> ligne = new ArrayList<>();
        for(int i = 0 ; i<getLongeur() ; i++){
            ligne.add(plateau.get(y).get(i));
        }
        return ligne;
    }

    public ArrayList<Case> getColonne(int x)
    {
        ArrayList<Case> colonne = new ArrayList<>();
        for(int i = 0 ; i<getLongeur() ; i++){
            colonne.add(plateau.get(i).get(x));
        }
        return colonne;
    }

    public int getNumberOfLettersPlacedOnColumn(int numCol)
    {
        ArrayList<Case> colonne = getColonne(numCol);
        int nbLetters = 0;
        for(Case lettre: colonne){
            if(!lettre.isEmpty()) nbLetters++;
        }
        return nbLetters;
    }

    public void setCase(int x, int y, Character val)
    {
        this.plateau.get(y).get(x).setValeur(val);
    }

    @Override
    public String toString()
    {
        StringBuilder output = new StringBuilder();
        for (List<Case> aLine : this.plateau)
        {
            output.append("|");
            for (Case aCase : aLine)
            {
                output.append(aCase.getValeur());
                output.append("|");
            }
            output.append("\n");
        }
        return output.toString();
    }
}
