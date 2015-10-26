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
public abstract class OperacionAritmetica {

    public OperacionAritmetica _operacionAritmetica;
    public OperacionAritmetica2 _operacionAritmetica2;

    public OperacionAritmetica(OperacionAritmetica o1, OperacionAritmetica2 o2) {
        this._operacionAritmetica = o1;
        this._operacionAritmetica2 = o2;
    }

    public OperacionAritmetica(OperacionAritmetica2 o2) {
        this._operacionAritmetica2 = o2;
    }

}
