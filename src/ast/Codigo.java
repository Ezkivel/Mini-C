/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast;

/**
 *
 * @author Gabriel
 */
public class Codigo {

    public DeclaracionVariables dv;

    public AsignacionVariable av;
    public IncrementarDecrementarVariable idv;
    public Printf p;
    public Scanf s;
    public While w;
    public If i;
    public For f;
    public LlamadoAFuncion lf;
    public RETURN r;
    public OperacionAritmetica o;
    public constChar cstC;
    public constStr cstS;
    public Codigo c;

    public Codigo(DeclaracionVariables dv, Codigo c) {
        this.dv = dv;
        this.c = c;
    }

    public Codigo(AsignacionVariable av, Codigo c) {
        this.c = c;
        this.av = av;
    }

    public Codigo(IncrementarDecrementarVariable idv, Codigo c) {
        this.idv = idv;
        this.c = c;
    }

    public Codigo(Printf p, Codigo c) {
        this.p = p;
        this.c = c;
    }

    public Codigo(Scanf s, Codigo c) {
        this.s = s;
        this.c = c;
    }

    public Codigo(While w, Codigo c) {
        this.w = w;
        this.c = c;
    }

    public Codigo(If i, Codigo c) {
        this.i = i;
        this.c = c;
    }

    public Codigo(For f, Codigo c) {
        this.f = f;
        this.c = c;
    }

    public Codigo(LlamadoAFuncion lf, Codigo c) {
        this.lf = lf;
        this.c = c;
    }

    public Codigo(RETURN r, OperacionAritmetica o, Codigo c) {
        this.r = r;
        this.o = o;
        this.c = c;
    }

    public Codigo(RETURN r, constChar cstC, Codigo c) {
        this.r = r;
        this.cstC = cstC;
        this.c = c;
    }

    public Codigo(RETURN r, constStr cstS, Codigo c) {
        this.r = r;
        this.cstS = cstS;
        this.c = c;
    }

    public Codigo(Codigo c) {
        this.c = c;
    }

    public Codigo() {
    }
    

}
