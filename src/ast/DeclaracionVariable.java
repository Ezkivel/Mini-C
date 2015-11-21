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
public class DeclaracionVariable extends Codigo {

    public Tipo _tipo;
    public DeclaracionVariables _declaracionVariables;
    public puntoYComa _puntoYComa;
    private Tipo tipo;
    private nombreVariable _nombreVariable;
    /*  public DeclaracionVariable(Tipo t, ListaVariables _listaVariables, puntoYComa pyc) {
     this._tipo = t;
     this._listaVariables = _listaVariables;
     this._puntoYComa = pyc;
     }*/

    public DeclaracionVariable(Tipo t, DeclaracionVariables _declaracionVariables, puntoYComa pyc) {
        this._tipo = t;
        this._declaracionVariables = _declaracionVariables;
        this._puntoYComa = pyc;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public nombreVariable getNombreVariable() {
        return _nombreVariable;
    }

    public void setNombreVariable(nombreVariable _nombreVariable) {
        this._nombreVariable = _nombreVariable;
    }

}
