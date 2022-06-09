package plateau;

public class Case {
    private TypeDeCase type;
    private Character valeur;
    private int x;
    private int y;


    public Case(int type)
    {
        this.type = attibuerType(type);
        this.valeur = ' ';
    }

    private TypeDeCase attibuerType(int type) {
        switch(type)
        {
            case 0:
                return TypeDeCase.NORMAL;
            case 1:
                return TypeDeCase.LETTRE_DOUBLE;
            case 2:
                return TypeDeCase.LETTRE_TRIPLE;
            case 3:
                return TypeDeCase.MOT_DOUBLE;
            case 4:
                return TypeDeCase.MOT_TRIPLE;
            case 5:
                return TypeDeCase.CENTER;
        }
        return null;
    }

    private TypeDeCase getType(int type) {
        switch(type)
        {
            case 0:
                return TypeDeCase.NORMAL;
            case 1:
                return TypeDeCase.LETTRE_DOUBLE;
            case 2:
                return TypeDeCase.LETTRE_TRIPLE;
            case 3:
                return TypeDeCase.MOT_DOUBLE;
            case 4:
                return TypeDeCase.MOT_TRIPLE;
            case 5:
                return TypeDeCase.CENTER;
        }

        return null;
    }

    public boolean isEmpty() {
        return this.valeur == ' ';
    }

    public Character getValeur() {
        return this.valeur;
    }

    public TypeDeCase getType() {
        return this.type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setValeur(Character c){
        this.valeur = c;
    }

}
