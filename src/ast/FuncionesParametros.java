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
public class FuncionesParametros {

    public Tipo _tipo;
    public nombreVariable _nombreVariable;
    public FuncionesParametrosComa _funcionesParametrosComa;
    public corcheteIzquierdo _corIz;
    public corcheteDerecho _corDer;

    public FuncionesParametros(Tipo _tipo, nombreVariable _nombreVariable, FuncionesParametrosComa _funcionesParametrosComa) {
        this._tipo = _tipo;
        this._nombreVariable = _nombreVariable;
        this._funcionesParametrosComa = _funcionesParametrosComa;
    }

    public FuncionesParametros(Tipo _tipo, nombreVariable _nombreVariable, corcheteIzquierdo _corIz, corcheteDerecho _corDer, FuncionesParametrosComa _funcionesParametrosComa) {
        this._tipo = _tipo;
        this._nombreVariable = _nombreVariable;
        this._funcionesParametrosComa = _funcionesParametrosComa;
        this._corIz = _corIz;
        this._corDer = _corDer;
    }

}
