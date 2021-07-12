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
        //List list = test.load("(round 3.6)");
        //List list = test.load("(define (func x y) (* x y))");
        //List list = test.load("((lambda (x) (* x x)) 5)");
        //List list = test.load("(if #f 11 8)");
        //List list = test.load("(cond (#f 11)(#f 8))");
        //List list = test.load("(cdr (cons 1 2))");
        //List list = test.load("(list 1 2 3 4)");
        //List list = test.load("(cons 1 2)");
        //List list = test.load("(< 1 2 4 4)");
        //List list = test.load("(>= 3 2 3 1)");
        //List list = test.load("(length (list 1 2 3 4))");
        //List list = test.load("(null? (list 1 2 3 4))");
        //List list = test.load("(define x 10) (set! x 20) x ");
        List list = test.load("(quote (+ 5 (* 2 3)))");
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
        varStore.addVar("if", new DatenTypen(new prozedurIf(varStore)));
        varStore.addVar("cond", new DatenTypen(new prozedurCond(varStore)));
        varStore.addVar("cons", new DatenTypen(new prozedurCons(varStore)));
        varStore.addVar("car", new DatenTypen(new prozedurCar(varStore)));
        varStore.addVar("cdr", new DatenTypen(new prozedurCdr(varStore)));
        varStore.addVar("list", new DatenTypen(new prozedurList(varStore)));
        varStore.addVar("length", new DatenTypen(new prozedurLength(varStore)));
        varStore.addVar("null?", new DatenTypen(new prozedurNull(varStore)));
        varStore.addVar("'()", new DatenTypen());
        varStore.addVar("<", new DatenTypen(new prozedurKleiner(varStore)));
        varStore.addVar(">", new DatenTypen(new prozedurGroßer(varStore)));
        varStore.addVar("=", new DatenTypen(new prozedurGleich(varStore)));
        varStore.addVar("<=", new DatenTypen(new prozedurKleinGleich(varStore)));
        varStore.addVar(">=", new DatenTypen(new prozedurGroßGleich(varStore)));
        varStore.addVar("set!", new DatenTypen(new prozedurSet(varStore)));
        varStore.addVar("quote", new DatenTypen(new prozedurQuote(varStore)));
        System.out.println(Auswertung.auswertung(knotten, varStore));

    }
}
