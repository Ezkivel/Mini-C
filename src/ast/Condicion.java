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
class Condicion {

    public OperacionAritmetica _operacionAritmetica;
    public constChar _constChar;
    public constStr _constStr;
    public Condicion _condicion;
    public CondicionOperadorLogico _condicionOperadorLogico;

    public Condicion(OperacionAritmetica oa) {
        this._operacionAritmetica = oa;
    }

}
