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

    public AsignacionVariable _asignacionVariable;
    public IncrementarDecrementarVariable _incrementarDecrementarVariable;
    public Printf _prinft;
    public Scanf _scanf;
    public While _while;
    public If _if;
    public For _for;
    public LlamadoAFuncion _llamadoFuncion;
    public puntoYComa _puntoYComa;
    public RETURN _return;
    public OperacionAritmetica _operacionAritmetica;
    public constChar _constChar;
    public constStr _constStr;
    public Codigo _codigo;

    public Codigo(DeclaracionVariables dv, Codigo c) {
        this.dv = dv;
        this._codigo = c;
    }

    public Codigo(AsignacionVariable av, Codigo c) {
        this._codigo = c;
        this._asignacionVariable = av;
    }

    public Codigo(IncrementarDecrementarVariable idv, Codigo c) {
        this._incrementarDecrementarVariable = idv;
        this._codigo = c;
    }

    public Codigo(Printf p, Codigo c) {
        this._prinft = p;
        this._codigo = c;
    }

    public Codigo(Scanf s, Codigo c) {
        this._scanf = s;
        this._codigo = c;
    }

    public Codigo(While w, Codigo c) {
        this._while = w;
        this._codigo = c;
    }

    public Codigo(If i, Codigo c) {
        this._if = i;
        this._codigo = c;
    }

    public Codigo(For f, Codigo c) {
        this._for = f;
        this._codigo = c;
    }

    public Codigo(LlamadoAFuncion lf, puntoYComa pyc, Codigo c) {
        this._llamadoFuncion = lf;
        this._puntoYComa = pyc;
        this._codigo = c;
    }

    public Codigo(RETURN r, OperacionAritmetica o, puntoYComa pyc, Codigo c) {
        this._return = r;
        this._operacionAritmetica = o;
        this._codigo = c;
    }

    public Codigo(RETURN r, constChar cstC, puntoYComa pyc, Codigo c) {
        this._return = r;
        this._constChar = cstC;
        this._puntoYComa = pyc;
        this._codigo = c;
    }

    public Codigo(RETURN r, constStr cstS, puntoYComa pyc, Codigo c) {
        this._return = r;
        this._constStr = cstS;
        this._puntoYComa = pyc;
        this._codigo = c;
    }

    public Codigo(Codigo c) {
        this._codigo = c;
    }

    public Codigo() {
    }

}
