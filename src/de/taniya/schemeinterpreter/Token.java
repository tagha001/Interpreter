package de.taniya.schemeinterpreter;

public class Token {
    public enum Tokentyp{
        number,
        bracketopen,
        bracketclose,
        keyWord,
        gruppe,
        variable,
        string,
        bool,
        root,
    }

    public Tokentyp tokentyp;
    public DatenTypen var;

    public Token(Tokentyp tokentyp){
        this.tokentyp = tokentyp;
    }

    public Token(Tokentyp tokentyp, DatenTypen var){
        this.tokentyp = tokentyp;
        this.var = var;
    }

    public String toString(){

        if (tokentyp==Tokentyp.number)
            return tokentyp.name() + var;
        else
            return tokentyp.name();
    }

}
