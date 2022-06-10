package plateau;

import java.util.ArrayList;
import java.util.List;

public class Plateau
{
    private List<List<Case>> plateau;
    private int longeur;
    private int largeur;

    public Plateau()
    {
        this.plateau = PlateauFactory.creerPlateau();
        this.largeur = this.plateau.size();
        this.longeur = this.plateau.get(0).size();
    }

    public List<List<Case>> getPlateau()
    {
        return plateau;
    }

    public void setPlateau(List<List<Case>> plateau)
    {
        this.plateau = plateau;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getLongeur() {
        return longeur;
    }

    public Case getCentre(){
        for (int i = 0; this.plateau.size()<i; i++){
            for (int j= 0; this.plateau.get(i).size()<j; j++){
                if(this.plateau.get(i).get(j).getType() == TypeDeCase.CENTER){
                    return this.plateau.get(i).get(j);
                }
            }
        }
        return null;
    }

    public Case getCase(int x, int y){
        return this.plateau.get(y).get(x);
    }

    public ArrayList<Case> getPosedCase(){
        ArrayList<Case> cases = new ArrayList<>();
        for (int i = 0; this.plateau.size()<i; i++){
            for (int j= 0; this.plateau.get(i).size()<j; j++){
                if(!this.plateau.get(i).get(j).isEmpty()){
                    cases.add(this.plateau.get(i).get(j));
                }
            }
        }
        return cases;
    }

    public ArrayList<Case> getLigne(int y){
        ArrayList<Case> ligne = new ArrayList<>();
        for(int i = 0 ; i<getLongeur() ; i++){
            ligne.add(plateau.get(y).get(i));
        }
        return ligne;
    }

    public ArrayList<Case> getColonne(int x){
        ArrayList<Case> colonne = new ArrayList<>();
        for(int i = 0 ; i<getLongeur() ; i++){
            colonne.add(plateau.get(i).get(x));
        }
        return colonne;
    }

    public int getNumberOfLettersPlacedOnColumn(int numCol){
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
    public String toString() {
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
