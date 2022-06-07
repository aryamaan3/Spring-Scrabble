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

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i<this.plateau.size(); i++){
            for (int j= 0; j<this.plateau.get(i).size(); j++){
                if(!this.plateau.get(i).get(j).isEmpty()){
                    res += '|'+this.plateau.get(i).get(j).getValeur();
                }else {
                    res += "|_" ;
                }
                if (j == getLongeur()-1){
                    res += "|\n";
                }
            }
        }
        return res;
    }


}
