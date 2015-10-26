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
public class ElementoDeUnArreglo {

    public nombreVariable _nombreVariable;
    public OperacionAritmetica _operacionAritmetica;

    public ElementoDeUnArreglo(nombreVariable nv, OperacionAritmetica o) {
        this._nombreVariable = nv;
        this._operacionAritmetica = o;
    }
}
