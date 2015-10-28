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
public class LlamadoAFuncion {

    public nombreVariable _nombreVariable;
    public parentesisIzquierdo _parIz;
    public LlamadoAFuncionParametros _llamadoAFuncionParametros;
    public parentesisDerecho _parDer;

    public LlamadoAFuncion(nombreVariable _nombreVariable, parentesisIzquierdo _parIz, LlamadoAFuncionParametros _llamadoAFuncionParametros, parentesisDerecho _parDer) {
        this._nombreVariable = _nombreVariable;
        this._parIz = _parIz;
        this._llamadoAFuncionParametros = _llamadoAFuncionParametros;
        this._parDer = _parDer;
    }

    public LlamadoAFuncion(nombreVariable _nombreVariable, parentesisDerecho _parDer) {
        this._nombreVariable = _nombreVariable;
        this._parDer = _parDer;
    }

}
