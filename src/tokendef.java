import java.util.ArrayList;
import java.util.List;

public class tokendef {

    public static List<Token> load(String input){
        List<Token> Tokens = new ArrayList<>();

        for (int i=0; i<input.length(); i++) {
            Token typ = null;
            switch (input.charAt(i)) {
                case '(':
                    typ = new Token(Token.Tokentyp.bracketopen);
                    break;
                case ')':
                    typ = new Token(Token.Tokentyp.bracketclose);
                    break;
                case '+':
                    typ = new Token(Token.Tokentyp.operator);
                    break;
                case '-':
                    typ = new Token(Token.Tokentyp.operator);
                    break;
                case '*':
                    typ = new Token(Token.Tokentyp.operator);
                    break;
                case '/':
                    typ = new Token(Token.Tokentyp.operator);
                    break;
                default:
                    if ('0' <= input.charAt(i) && input.charAt(i) <= '9') {
                        int num = 0;
                        while('0' <= input.charAt(i) && input.charAt(i) <= '9'){
                            num *= 10;
                            num += input.charAt(i)- '0';
                            i++;
                        };
                        //Ende der String und an Bracketclose
                        i--;

                        typ = new Token(Token.Tokentyp.number, num);

                    }
            }
            if (typ != null) {
                Tokens.add(typ);
            }
        }
        return Tokens;
    }
    public static int findeKlammer(List<Token> Tokens, int index){
        int j= 0;
        for(int i= index; i<Tokens.size(); i++) {
            if (Tokens.get(i).tokentyp == Token.Tokentyp.bracketopen) {
                j++;
            } else if (Tokens.get(i).tokentyp == Token.Tokentyp.bracketclose) {
                j--;
            }
            if (j==0){
                return i;
            }

        }
        throw new RuntimeException("Kein Klammer gefunden!");
    }


    public static Knotten gruppierung(List<Token> Tokens, int anfang, int ende){
        Knotten eltern = new Knotten(new Token(Token.Tokentyp.gruppe));
        for(int i=anfang; i<ende; i++){
            if(Tokens.get(i).tokentyp== Token.Tokentyp.bracketopen){
                int j = findeKlammer(Tokens, i);
                eltern.addKind(gruppierung(Tokens, i+1, j));
                i = j;
            }
            else {
                Knotten kind = new Knotten(Tokens.get(i));
                eltern.addKind(kind);
            }
        }
        return eltern;

    }


}