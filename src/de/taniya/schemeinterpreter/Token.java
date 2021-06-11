package de.taniya.schemeinterpreter;

public class Token {
    enum Tokentyp{
        number,
        character,
        bracketopen,
        bracketclose,
        keyWord,
        gruppe,
        variable,
    }

    Tokentyp tokentyp;
    public datenTypen var;

    public Token(Tokentyp tokentyp){
        this.tokentyp = tokentyp;
    }

    public Token(Tokentyp tokentyp, datenTypen var){
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
