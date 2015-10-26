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
    public corcheteIzquierdo _corIz;
    public corcheteDerecho _corDer;
    public DeclaracionFuncionParametrosComa _declaracionFuncionParametrosComa;

    public DeclaracionFuncionParametros(Tipo _tipo, DeclaracionFuncionParametrosComa _declaracionFuncionParametrosComa) {
        this._tipo = _tipo;
        this._declaracionFuncionParametrosComa = _declaracionFuncionParametrosComa;
    }

    public DeclaracionFuncionParametros(Tipo _tipo, corcheteIzquierdo _corIz, corcheteDerecho _corDer, DeclaracionFuncionParametrosComa _declaracionFuncionParametrosComa) {
        this._tipo = _tipo;
        this._corIz = _corIz;
        this._corDer = _corDer;
        this._declaracionFuncionParametrosComa = _declaracionFuncionParametrosComa;
    }

    public DeclaracionFuncionParametros(Tipo _tipo, nombreVariable _nombreVariable, DeclaracionFuncionParametrosComa _declaracionFuncionParametrosComa) {
        this._tipo = _tipo;
        this._nombreVariable = _nombreVariable;
        this._declaracionFuncionParametrosComa = _declaracionFuncionParametrosComa;
    }

    public DeclaracionFuncionParametros(Tipo _tipo, nombreVariable _nombreVariable, corcheteIzquierdo _corIz, corcheteDerecho _corDer, DeclaracionFuncionParametrosComa _declaracionFuncionParametrosComa) {
        this._tipo = _tipo;
        this._nombreVariable = _nombreVariable;
        this._corIz = _corIz;
        this._corDer = _corDer;
        this._declaracionFuncionParametrosComa = _declaracionFuncionParametrosComa;
    }

}
