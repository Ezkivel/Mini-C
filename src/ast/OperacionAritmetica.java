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
public class OperacionAritmetica {

    public OperacionAritmetica _operacionAritmetica;
    public operadorSuma _operadorSuma;
    public operadorResta _operadorResta;
    public OperacionAritmetica2 _operacionAritmetica2;

    public OperacionAritmetica(OperacionAritmetica _operacionAritmetica, operadorSuma _operadorSuma, OperacionAritmetica2 _operacionAritmetica2) {
        this._operacionAritmetica = _operacionAritmetica;
        this._operadorSuma = _operadorSuma;
        this._operacionAritmetica2 = _operacionAritmetica2;
    }

    public OperacionAritmetica(OperacionAritmetica _operacionAritmetica, operadorResta _operadorResta, OperacionAritmetica2 _operacionAritmetica2) {
        this._operacionAritmetica = _operacionAritmetica;
        this._operadorResta = _operadorResta;
        this._operacionAritmetica2 = _operacionAritmetica2;
    }

    public OperacionAritmetica(OperacionAritmetica2 _operacionAritmetica2) {
        this._operacionAritmetica2 = _operacionAritmetica2;
    }

}
