package de.taniya.schemeinterpreter;

import de.taniya.schemeinterpreter.prozedur.*;

import java.util.List;
import java.util.Scanner;

public class Interpreter {
    public static void repl(VarStore varStore){

        Scanner myInput = new Scanner(System.in);
        while (true) {
            String input = myInput.nextLine();
            if (input.equals("Exit")) {
                return;
            } else {
                tokendef test = new tokendef();
                List list = test.load(input);
                Knotten knotten = tokendef.gruppierung(list, 0, list.size());
                System.out.println(Auswertung.auswertung(knotten, varStore));
            }
        }
    }


    public static void main(String args[]){
        tokendef test = new tokendef();
        //List list = test.load("(+ 5 6)");
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
        //List list = test.load("(quote (+ 5 (* 2 3)))");
        //abstraction
        //List list = test.load("(define (quadrat x) (* x x)) (define summe (lambda (a b) (+ a b))) (define comperator (lambda (x y) (cond ((= x y) 0) ((> x y) 1) ((< x y) 1)))) (comperator (quadrat 10) (summe 50 50))");
        //closure
        List list = test.load("(define (erzeuge-konto-abheben saldo) (lambda (betrag) (set! saldo (- saldo betrag)) saldo)) (define konto (erzeuge-konto-abheben 1100)) (konto 0)");
        // let
        //List list = test.load("(define (test n) (let ((a 10) (b 100)) (* a b n))) (test 5)");
        //liste
        //List list = test.load("(define myappend (lambda (a b) (if (null? a) b (cons (car a) (myappend (cdr a) b))))) (myappend (list 1 2) (list 3 4))");
        //curry
        /*List list = test.load("(define T (lambda (x) (lambda (y) x)))\n" +
                "(define F (lambda (x) (lambda (y) y)))\n" +
                "(define IF (lambda (p) (lambda (c) (lambda (a) ((p c) a)))))\n" +
                "(define I (lambda (x) x))\n" +
                "(define NICHT (lambda (x) ((x F) T)))\n" +
                "(define SUCC (lambda(n) (lambda(f) ((B f) (n f)))))\n" +
                "\n" +
                "(define ZERO (lambda (f) (lambda (x) x)))\n" +
                "(define ONE (lambda (f) (lambda  (x) (f x))))\n" +
                "(define TWO (lambda (f) (lambda (x) (f (f x)))))\n" +
                "\n" +
                "(define COUNTER (lambda (x) (+ x 1)))\n" +
                "\n" +
                "(define TONUMBER (lambda (x) ((x COUNTER) 0)))\n" +
                "\n" +
                "(define B (lambda(x) (lambda(y) (lambda(z) (x(y z))))))\n" +
                "\n" +
                "(define PLUS (lambda (a) (lambda (b) (lambda (f) (lambda (x) ((a f) ((b f) x)))))))\n" +
                "(define PLUSSUCC (lambda (a) (lambda (b) ((a SUCC) b))))\n" +
                "\n" +
                "(define MULT (lambda (a) (lambda (b) (lambda (f) (a (b f))))))\n" +
                "\n" +
                "(define POW (lambda (a) (lambda (b) (b a))))\n" +
                "\n" +
                "(define THREE (SUCC TWO))\n" +
                "(define SIX ((MULT TWO) THREE))\n" +
                "(define FOUR ((PLUS TWO) TWO))\n" +
                "(define EIGHT ((PLUSSUCC FOUR) FOUR))\n" +
                "(define SIXTEEN ((POW TWO) FOUR))\n" +
                "\n" +
                "(define V (lambda (a) (lambda (b) (lambda (f) ((f a) b)))))\n" +
                "\n" +
                "(define RCONS V)\n" +
                "(define RCAR (lambda (f) (f T)))\n" +
                "(define RCDR (lambda (f) (f F)))\n" +
                "\n" +
                "((ONE COUNTER) 0)\n" +
                "((TWO COUNTER) 0)\n" +
                "((SIX COUNTER) 0)\n" +
                "((EIGHT COUNTER) 0)\n" +
                "((SIXTEEN COUNTER) 0)\n" +
                "\n" +
                "(RCAR ((RCONS 10) 100))\n" +
                "\n" +
                "(((((IF T) ONE) ZERO) COUNTER) 0)\n" +
                "(((((IF F) ZERO) ONE) COUNTER) 0) ");*/

        //recursion
        //List list = test.load("(define (summe x) (if (= x 0) 0 (+ x (summe (- x 1))))) (define (fac n) (if (= n 0) 1 (* n (fac (- n 1))))) (summe 100) (fac 5)");
        //simple
        //List list = test.load("(+ (* 10 10) (- 100 100)) (define a (* 10 10)) (+ a a)");
        Knotten knotten = tokendef.gruppierung(list,0, list.size());


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
        // repl(varStore);
        System.out.println(Auswertung.auswertung(knotten, varStore));

    }
}
