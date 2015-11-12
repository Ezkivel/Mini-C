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
public class entero {

    public int _entero;
    public final int linea;
    public final int columna;
    private Tipo _tipo;

    public entero(int _entero, int linea, int columna) {
        this._entero = _entero;
        this.linea = linea;
        this.columna = columna;
    }

    public Tipo getTipo() {
        return _tipo;
    }

    public void setTipo(Tipo _tipo) {
        this._tipo = _tipo;
    }

}
