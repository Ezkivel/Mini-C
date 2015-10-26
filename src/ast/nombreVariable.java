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
public class nombreVariable {

    public String _nombreVariable;
    public final int linea;
    public final int columna;

    public nombreVariable(String _nombreVariable, int linea, int columna) {
        this._nombreVariable = _nombreVariable;
        this.linea = linea;
        this.columna = columna;
    }

  
}
