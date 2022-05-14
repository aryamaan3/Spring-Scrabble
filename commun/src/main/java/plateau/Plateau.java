package plateau;

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
}
