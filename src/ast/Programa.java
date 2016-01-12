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
public class Programa {

    public DeclaracionFuncion _declaracionFuncion;
    public DeclaracionVariable _declaracionVariable;
    public MainClass _mainClass;
    public Programa _programa;

    public Programa() {

    }

    public Programa(MainClass m) {
        this._mainClass = m;
    }

    public Programa(DeclaracionFuncion df, Programa p) {
        this._declaracionFuncion = df;
        this._programa = p;
    }
    
    public Programa(DeclaracionVariable dv, Programa p) {
        this._declaracionVariable = dv;
        this._programa = p;
    }

}
