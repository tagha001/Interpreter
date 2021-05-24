public class Token {
    enum Tokentyp{
        number,
        character,
        bracketopen,
        bracketclose,
        operator,
        gruppe,
    }

    Tokentyp tokentyp;
    int num;
    public Token(Tokentyp tokentyp){
        this.tokentyp = tokentyp;
    }

    public Token(Tokentyp tokentyp, int num){
        this.tokentyp = tokentyp;
        this.num = num;
    }

    public String toString(){

        if (tokentyp==Tokentyp.number)
            return tokentyp.name() + num;
        else
            return tokentyp.name();
    }

}
