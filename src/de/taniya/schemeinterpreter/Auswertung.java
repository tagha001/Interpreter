package de.taniya.schemeinterpreter;

public class Auswertung {

    public static DatenTypen auswertung(Knotten knotten, VarStore varStore){
        if (knotten.getToken().tokentyp== Token.Tokentyp.number){
            return knotten.getToken().var;
        }
        else if(knotten.getToken().tokentyp== Token.Tokentyp.variable ||
                knotten.getToken().tokentyp == Token.Tokentyp.keyWord){
            return varStore.findVar(knotten.getToken().var.getString());
        }
        else if (knotten.getToken().tokentyp == Token.Tokentyp.bool){
            return knotten.getToken().var;
        }

        /*switch (knotten.getKind().get(0).getToken().tokentyp){
            case variable:
            case keyWord:
                DatenTypen temp = varStore.findVar(knotten.getKind().get(0).getToken().var.getString());
                if (temp != null){
                    return temp.getProzedur().execute(knotten, varStore);
                }
                break;

            case gruppe:
                temp = auswertung(knotten.getKind().get(0), varStore);
                if (temp != null){
                    return temp.getProzedur().execute(knotten, varStore);
                }
            break;

            case root:
                DatenTypen datenTypen = new DatenTypen();
                for (int i = 0; i < knotten.getKind().size(); i++) {
                    datenTypen = auswertung(knotten.getKind().get(i), varStore);
                }
                return datenTypen;
        }*/


        switch (knotten.getToken().tokentyp){
            case gruppe:
                DatenTypen temp = auswertung(knotten.getKind().get(0), varStore);
                if (temp != null){
                    return temp.getProzedur().execute(knotten, varStore);
                }
                break;

            case root:
                DatenTypen datenTypen = new DatenTypen();
                for (int i = 0; i < knotten.getKind().size(); i++) {
                    datenTypen = auswertung(knotten.getKind().get(i), varStore);
                }
                return datenTypen;
        }
        return null;
    }
}
