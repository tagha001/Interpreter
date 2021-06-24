package de.taniya.schemeinterpreter;

import de.taniya.schemeinterpreter.prozedur.*;

import java.util.List;
import java.util.Scanner;

public class Interpreter {
    public static void repl(){

        Scanner myInput = new Scanner(System.in);
        while (true) {
            String input = myInput.nextLine();
            if (input.equals("Exit")) {
                return;
            } else {
                tokendef test = new tokendef();
                List list = test.load(input);
                Knotten knotten = tokendef.gruppierung(list, 0, list.size());
                VarStore varStore = new VarStore();
                varStore.addVar("+", new DatenTypen(new prozedurPlus(varStore)));
                varStore.addVar("-", new DatenTypen(new prozedurMinus(varStore)));
                varStore.addVar("*", new DatenTypen(new prozedurMal(varStore)));
                varStore.addVar("/", new DatenTypen(new prozedurGeteilt(varStore)));
                System.out.println(Auswertung.auswertung(knotten, varStore));
            }
        }
    }


    public static void main(String args[]){
        tokendef test = new tokendef();
        //List list = test.load("(let ((a (+ 5 6))) (* a a))");
        List list = test.load("(round 3.6)");
        //List list = test.load("(define (func x y) (* x y))");
        //List list = test.load("((lambda (x) (* x x)) 5)");
        Knotten knotten = tokendef.gruppierung(list,0, list.size());
        //repl();

        System.out.println(list);
        System.out.println(knotten);
        VarStore varStore = new VarStore();
        varStore.addVar("+", new DatenTypen(new prozedurPlus(varStore)));
        varStore.addVar("-", new DatenTypen(new prozedurMinus(varStore)));
        varStore.addVar("*", new DatenTypen(new prozedurMal(varStore)));
        varStore.addVar("/", new DatenTypen(new prozedurGeteilt(varStore)));
        varStore.addVar("define", new DatenTypen(new prozedurDefine(varStore)));
        varStore.addVar("let", new DatenTypen(new prozedurLet(varStore)));
        varStore.addVar("lambda", new DatenTypen(new prozedurLambda(varStore)));
        varStore.addVar("round", new DatenTypen(new prozedurRound(varStore)));
        System.out.println(Auswertung.auswertung(knotten, varStore));

    }
}
