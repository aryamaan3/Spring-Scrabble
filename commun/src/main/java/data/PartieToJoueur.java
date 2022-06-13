package data;

import plateau.Placement;
import plateau.Plateau;

import java.util.ArrayList;
import java.util.List;

public class PartieToJoueur
{
    private Plateau board;
    private List<Character> main;

    public PartieToJoueur() {
    }

    public PartieToJoueur(Plateau board, List<Character> main)
    {
        this.board = board;
        this.main = main;
    }

    public PartieToJoueur(Plateau board, String main)
    {
        this.board = board;
        this.main = new ArrayList<>();
        for (char c : main.toCharArray())
        {
            this.main.add(c);
        }
    }

    public void setBoard(Plateau board)
    {
        this.board = board;
    }

    public void setMain(List<Character> main)
    {
        this.main = main;
    }

    public Plateau getBoard()
    {
        return board;
    }

    public List<Character> getMain()
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
