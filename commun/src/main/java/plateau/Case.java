package plateau;

public class Case
{
    private TypeDeCase type;
    private Character valeur;

    public Case(int type)
    {
        this.type = getType(type);
    }

    private TypeDeCase getType(int type)
    {
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

    public boolean isEmpty()
    {
        return this.valeur == ' ';
    }

    public Character getValeur()
    {
        return this.valeur;
    }

    public TypeDeCase getType()
    {
        return this.type;
    }
}
