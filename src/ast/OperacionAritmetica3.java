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
public abstract class OperacionAritmetica3 extends OperacionAritmetica2 {

    public entero _entero;
    public Variable _variable;
    public LlamadoAFuncion _llamadoAFuncion;

    public OperacionAritmetica3(entero e, Variable v, LlamadoAFuncion llf, OperacionAritmetica o1, OperacionAritmetica2 o2, OperacionAritmetica3 o3) {
        super(o1, o2, o3);
        super._operacionAritmetica2 = o3;
        this._entero = e;
        this._variable = v;
        this._llamadoAFuncion = llf;
    }

    public OperacionAritmetica3(entero e, Variable v, LlamadoAFuncion llf, OperacionAritmetica2 o2, OperacionAritmetica3 o3) {
        super(o2, o3);
        this._entero = e;
        this._variable = v;
        this._llamadoAFuncion = llf;
    }

}
