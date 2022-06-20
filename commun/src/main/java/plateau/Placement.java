package plateau;

public class Placement
{
    private final char lettre;
    private final int x;
    private final int y;

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

    @Override
    public String toString() {
        return "Placement{" +
                "lettre=" + lettre +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
