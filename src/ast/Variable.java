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
public class Variable {

    public nombreVariable _nombreVariable;
    public ElementoDeUnArreglo _elementoDeUnArreglo;

    public Variable(nombreVariable i) {
        this._nombreVariable = i;
    }

    public Variable(ElementoDeUnArreglo ea) {
        this._elementoDeUnArreglo = ea;
    }

}
