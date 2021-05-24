import java.util.List;

public class Interpreter {

    public static void main(String args[]){
        tokendef test = new tokendef();
        List list = test.load("(+ 5 68)");
        Knotten knotten = tokendef.gruppierung(list,0, list.size());
        System.out.println(list);
        System.out.println(knotten);

    }
}
