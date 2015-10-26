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
public class DeclaracionFuncionParametros {

    public Tipo _tipo;
    public nombreVariable _nombreVariable;

    //falta el arreglo
    public DeclaracionFuncionParametros(Tipo t, nombreVariable i) {
        this._tipo = t;
        this._nombreVariable = i;
    }

    public DeclaracionFuncionParametros(Tipo t) {
        this._tipo = t;
    }

    public DeclaracionFuncionParametros() {
    }

}
