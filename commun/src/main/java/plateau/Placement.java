package plateau;

public class Placement {
    private char lettre;
    private int x, y;

    public Placement(char lettre, int x, int y){
        this.lettre = lettre;
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public Character getLettre()
    {
        return this.lettre;
    }
}
