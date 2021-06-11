package de.taniya.schemeinterpreter;

public class Auswertung {

    public static datenTypen auswertung(Knotten knotten, varStore varStore){
        if (knotten.getToken().tokentyp== Token.Tokentyp.number){
            return knotten.getToken().var;
        }
        else if(knotten.getToken().tokentyp== Token.Tokentyp.variable){
            return varStore.findVar(knotten.getToken().var.getString());
        }

        switch (knotten.getKind().get(0).getToken().tokentyp){
            case keyWordLet:
                varStore store = new varStore(varStore);
                for (Knotten temp : knotten.getKind().get(1).getKind()) {
                    store.addVar(temp.getKind().get(0).getToken().var.getString(), auswertung(temp.getKind().get(1), varStore));
                }
                return auswertung(knotten.getKind().get(2), store);

            case keyWord:
                datenTypen temp = varStore.findVar(knotten.getKind().get(0).getToken().var.getString());
                if (temp != null){
                    return temp.getProzedur().execute(knotten, varStore);
                }
                break;

            case gruppe:
               return auswertung(knotten.getKind().get(0), varStore);
        }
        return null;
    }
}
