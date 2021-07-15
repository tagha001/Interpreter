package de.taniya.schemeinterpreter.prozedur;

import de.taniya.schemeinterpreter.*;

import java.util.List;

public class schemeProzedur extends Prozedur {

    private Knotten prozedurRumpf;

    public schemeProzedur(List<String> parameter, Knotten prozedurRumpf, VarStore varStore) {
        super(parameter, varStore);
        this.prozedurRumpf = prozedurRumpf;
    }

    @Override
    public DatenTypen executeRumpf(List<DatenTypen> parameter) {
        if (parameterNamen.size() == parameter.size()){
            Knotten root = new Knotten(new Token(Token.Tokentyp.gruppe));
            root.addKind(new Knotten(new Token(Token.Tokentyp.keyWord, new DatenTypen("let"))));
            Knotten letVariablen = new Knotten(new Token(Token.Tokentyp.gruppe));
            for (int i=0; i<parameterNamen.size(); i++){
                Knotten letVar = new Knotten(new Token(Token.Tokentyp.gruppe));
                letVar.addKind(new Knotten(new Token(Token.Tokentyp.variable, new DatenTypen(parameterNamen.get(i)))));
                if (parameter.get(i).isBoolean()){
                    letVar.addKind(new Knotten(new Token(Token.Tokentyp.bool, parameter.get(i))));
                }else if (parameter.get(i).isNumber()){
                    letVar.addKind(new Knotten(new Token(Token.Tokentyp.number, parameter.get(i))));
                }else if (parameter.get(i).isString()){
                    letVar.addKind(new Knotten(new Token(Token.Tokentyp.string, parameter.get(i))));
                }else if (parameter.get(i).isTuple()){
                    letVar.addKind(new Knotten(new Token(Token.Tokentyp.tuple, parameter.get(i))));
                }else if (parameter.get(i).isProzedur()){
                    letVar.addKind(new Knotten(new Token(Token.Tokentyp.prozedur, parameter.get(i))));
                }else {
                    letVar.addKind(new Knotten(new Token(Token.Tokentyp.tuple, parameter.get(i))));
                }

                letVariablen.addKind(letVar);
            }
            root.addKind(letVariablen);
            root.addKind(prozedurRumpf);
            return Auswertung.auswertung(root, varStore);
        }
        return null;
    }
}
