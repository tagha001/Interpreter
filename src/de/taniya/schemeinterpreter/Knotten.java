package de.taniya.schemeinterpreter;

import java.util.ArrayList;
import java.util.List;

public class Knotten {
    private Token token;
    private Knotten eltern;
    private List<Knotten> kind;

    public Knotten(Token token){
        this.token = token;
        kind = new ArrayList<>();
    }
    public Token getToken(){
        return token;
    }

    public Knotten getEltern(){
        return eltern;
    }

    public List<Knotten> getKind(){
        return kind;
    }

    public void setEltern(Knotten eltern) {
        this.eltern = eltern;
    }

    public void addKind(Knotten kind){
        this.kind.add(kind);
    }

    public String toString() {
        String result = "";
        result = this.token.toString();
        if (!this.kind.isEmpty()) {
            result += "(";
            for (int i = 0; i < this.kind.size(); i++) {
                result += this.kind.get(i).toString();
                result += ", ";
            }
            result += ")";
        }
        return result;
    }
}
