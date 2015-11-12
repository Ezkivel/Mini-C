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
public class OperacionAritmetica2 {

    public OperacionAritmetica2 _operacionAritmetica2;
    public operadorMultiplicacion _operadorMultiplicacion;
    public operadorDivision _operadorDivision;
    public OperacionAritmetica3 _operacionAritmetica3;
    public Tipo _tipo;

    public OperacionAritmetica2(OperacionAritmetica2 _operacionAritmetica2, operadorMultiplicacion _operadorMultiplicacion, OperacionAritmetica3 _operacionAritmetica3) {

        this._operacionAritmetica2 = _operacionAritmetica2;
        this._operadorMultiplicacion = _operadorMultiplicacion;
        this._operacionAritmetica3 = _operacionAritmetica3;
    }

    public OperacionAritmetica2(OperacionAritmetica2 _operacionAritmetica2, operadorDivision _operadorDivision, OperacionAritmetica3 _operacionAritmetica3) {
        this._operacionAritmetica2 = _operacionAritmetica2;
        this._operadorDivision = _operadorDivision;
        this._operacionAritmetica3 = _operacionAritmetica3;
    }

    public OperacionAritmetica2(OperacionAritmetica3 _operacionAritmetica3) {
        this._operacionAritmetica3 = _operacionAritmetica3;
    }

    public Tipo getTipo() {
        return _tipo;
    }

    public void setTipo(Tipo _tipo) {
        this._tipo = _tipo;
    }

}
