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
    private Tipo _tipo;

    public Variable(nombreVariable i) {
        this._nombreVariable = i;
    }

    public Variable(ElementoDeUnArreglo ea) {
        this._elementoDeUnArreglo = ea;
    }

    public Tipo getTipo() {
        return _tipo;
    }

    public void setTipo(Tipo _tipo) {
        this._tipo = _tipo;
    }

    public nombreVariable getNombreVariable() {
        return _nombreVariable;
    }

    public void setNombreVariable(nombreVariable _nombreVariable) {
        this._nombreVariable = _nombreVariable;
    }

}
