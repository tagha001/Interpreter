package de.taniya.schemeinterpreter;

import java.util.ArrayList;
import java.util.List;


public class tokendef {

    public static List<Token> load(String input) {
        List<Token> Tokens = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            Token typ = null;
            switch (input.charAt(i)) {
                case '(':
                    typ = new Token(Token.Tokentyp.bracketopen);
                    break;
                case ')':
                    typ = new Token(Token.Tokentyp.bracketclose);
                    break;
                case '+':
                    typ = new Token(Token.Tokentyp.keyWord, new DatenTypen("+"));
                    break;
                case '-':
                    typ = new Token(Token.Tokentyp.keyWord, new DatenTypen("-"));
                    break;
                case '*':
                    typ = new Token(Token.Tokentyp.keyWord, new DatenTypen("*"));
                    break;
                case '/':
                    typ = new Token(Token.Tokentyp.keyWord, new DatenTypen("/"));
                    break;
                case '<':
                    if (input.charAt(i+1) == '='){
                        typ = new Token(Token.Tokentyp.keyWord, new DatenTypen("<="));
                        i++;
                    }
                    else {
                        typ = new Token(Token.Tokentyp.keyWord, new DatenTypen("<"));
                    }
                    break;
                case '>':
                    if (input.charAt(i+1) == '='){
                        typ = new Token(Token.Tokentyp.keyWord, new DatenTypen(">="));
                        i++;
                    }
                    else {
                        typ = new Token(Token.Tokentyp.keyWord, new DatenTypen(">"));
                    }
                    break;
                case '=':
                    typ = new Token(Token.Tokentyp.keyWord, new DatenTypen("="));
                    break;



                case '"':
                    int stringEnd = input.indexOf('"', i+1);
                    String string = input.substring(i+1, stringEnd);
                    typ = new Token(Token.Tokentyp.string, new DatenTypen(string));
                    i = stringEnd;
                    break;

                case '#':
                    if (input.charAt(i+1) == 't'){
                        typ = new Token(Token.Tokentyp.bool, new DatenTypen(true));
                    }else {
                        typ = new Token(Token.Tokentyp.bool, new DatenTypen(false));
                    }
                    i++;
                    break;


                default:
                    if ('a' <= input.charAt(i) && input.charAt(i) <= 'z') {
                        if (input.substring(i).startsWith("let")) {
                            typ = new Token(Token.Tokentyp.keyWord, new DatenTypen("let"));
                            i += 2;
                        }
                        else if (input.substring(i).startsWith("define")){
                            typ = new Token(Token.Tokentyp.keyWord, new DatenTypen("define"));
                            i += 5;
                        }

                        else if (input.substring(i).startsWith("lambda")){
                            typ = new Token(Token.Tokentyp.keyWord, new DatenTypen("lambda"));
                            i += 5;
                        }
                        else if (input.substring(i).startsWith("round")){
                            typ = new Token(Token.Tokentyp.keyWord, new DatenTypen("round"));
                            i += 4;
                        }
                        else if (input.substring(i).startsWith("if")){
                            typ = new Token(Token.Tokentyp.keyWord, new DatenTypen("if"));
                            i++;
                        }

                        else if (input.substring(i).startsWith("cond")){
                            typ = new Token(Token.Tokentyp.keyWord, new DatenTypen("cond"));
                            i += 3;
                        }
                        else if (input.substring(i).startsWith("cons")){
                            typ = new Token(Token.Tokentyp.keyWord, new DatenTypen("cons"));
                            i += 3;
                        }

                        else if (input.substring(i).startsWith("car")){
                            typ = new Token(Token.Tokentyp.keyWord, new DatenTypen("car"));
                            i += 2;
                        }

                        else if (input.substring(i).startsWith("cdr")){
                            typ = new Token(Token.Tokentyp.keyWord, new DatenTypen("cdr"));
                            i += 2;
                        }

                        else if (input.substring(i).startsWith("'()")){
                            typ = new Token(Token.Tokentyp.keyWord, new DatenTypen("'()"));
                            i += 2;
                        }

                        else if (input.substring(i).startsWith("list")){
                            typ = new Token(Token.Tokentyp.keyWord, new DatenTypen("list"));
                            i += 3;
                        }

                        else if (input.substring(i).startsWith("length")){
                            typ = new Token(Token.Tokentyp.keyWord, new DatenTypen("length"));
                            i += 5;
                        }


                        else {
                            String var = "";
                            while ('a' <= input.charAt(i) && input.charAt(i) <= 'z') {
                                var = var + input.charAt(i);
                                i++;
                            }
                            i--;
                            typ = new Token(Token.Tokentyp.variable, new DatenTypen(var));
                        }
                    } else if ('0' <= input.charAt(i) && input.charAt(i) <= '9') {
                        double num = 0;
                        while ('0' <= input.charAt(i) && input.charAt(i) <= '9') {
                            num *= 10;
                            num += input.charAt(i) - '0';
                            i++;
                        }
                        if (input.charAt(i) == '.'){
                            i++;
                            int j = 0;
                            while ('0' <= input.charAt(i) && input.charAt(i) <= '9') {
                                num *= 10;
                                num += input.charAt(i) - '0';
                                i++;
                                j++;
                            }
                            num = num/(Math.pow(10, j));

                        }
                        ;
                        //Ende der String und an Bracketclose
                        i--;

                        typ = new Token(Token.Tokentyp.number, new DatenTypen(num));

                    }
            }
            if (typ != null) {
                Tokens.add(typ);
            }
        }
        return Tokens;
    }

    public static int findeKlammer(List<Token> Tokens, int index) {
        int j = 0;
        for (int i = index; i < Tokens.size(); i++) {
            if (Tokens.get(i).tokentyp == Token.Tokentyp.bracketopen) {
                j++;
            } else if (Tokens.get(i).tokentyp == Token.Tokentyp.bracketclose) {
                j--;
            }
            if (j == 0) {
                return i;
            }

        }
        throw new RuntimeException("Kein Klammer gefunden!");
    }


    public static Knotten gruppierung(List<Token> Tokens, int anfang, int ende) {
        Knotten eltern;

        if (anfang == 0){
            eltern = new Knotten(new Token(Token.Tokentyp.root));
        }
        else {
            eltern = new Knotten(new Token(Token.Tokentyp.gruppe));
        }
        for (int i = anfang; i < ende; i++) {
            if (Tokens.get(i).tokentyp == Token.Tokentyp.bracketopen) {
                int j = findeKlammer(Tokens, i);
                eltern.addKind(gruppierung(Tokens, i + 1, j));
                i = j;
            } else {
                Knotten kind = new Knotten(Tokens.get(i));
                eltern.addKind(kind);
            }
        }
        return eltern;

    }


}
