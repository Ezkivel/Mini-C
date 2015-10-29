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
public class OperacionAritmetica3 {

    public entero _entero;
    public Variable _variable;
    public LlamadoAFuncion _llamadoAFuncion;
    public parentesisIzquierdo _parentesisIzquierdo;
    public OperacionAritmetica _OperacionAritmetica;
    public parentesisDerecho _parentesisDerecho;

    public OperacionAritmetica3(entero _entero) {
        this._entero = _entero;
    }

    public OperacionAritmetica3(Variable _variable) {
        this._variable = _variable;
    }

    public OperacionAritmetica3(LlamadoAFuncion _llamadoAFuncion) {
        this._llamadoAFuncion = _llamadoAFuncion;
    }

    public OperacionAritmetica3(parentesisIzquierdo _parentesisIzquierdo, OperacionAritmetica _OperacionAritmetica, parentesisDerecho _parentesisDerecho) {
        this._parentesisIzquierdo = _parentesisIzquierdo;
        this._OperacionAritmetica = _OperacionAritmetica;
        this._parentesisDerecho = _parentesisDerecho;
    }

}
