public enum SymbolClass{
    E(0),
    G(1),
    I(2),
    L(3),
    N(4),
    O(5),
    P(6),
    OTHER(7);

    SymbolClass(int i){
        this.i = i;
    }

    private int i;

    public int getI(){
        return i;
    }

    public static SymbolClass getSymbolClass(char symbol){
        switch (symbol){
            case 'e' :{
                return E;
            }
            case 'g' :{
                return G;
            }
            case 'i' :{
                return I;
            }
            case 'l' :{
                return L;
            }
            case 'n' :{
                return N;
            }
            case 'o' :{
                return O;
            }
            case 'p' :{
                return P;
            }
            default:{
                return OTHER;
            }
        }
    }
}
