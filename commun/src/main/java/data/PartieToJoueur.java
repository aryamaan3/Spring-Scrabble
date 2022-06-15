package data;

import plateau.Placement;
import plateau.Plateau;

import java.util.ArrayList;
import java.util.List;

public class PartieToJoueur
{
    private Plateau board;
    private String main;

    public PartieToJoueur() {
    }

    public PartieToJoueur(Plateau board, String main)
    {
        this.board = board;
        this.main = main;
    }

    public void setBoard(Plateau board)
    {
        this.board = board;
    }

    public void setMain(String main)
    {
        this.main = main;
    }

    public Plateau getBoard()
    {
        return board;
    }

    public String getMain()
    {
        return main;
    }

    @Override
    public String toString()
    {
        return "PartieToJoueur{" +
                "board=" + board +
                "main=" + main +
                '}';
    }
}
