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
public class Condicion {

    public OperacionAritmetica _operacionAritmetica;
    public constChar _constChar;
    public constStr _constStr;
    public Condicion _condicion;
    public CondicionOperadorLogico _condicionOperadorLogico;

    public Condicion(OperacionAritmetica oa) {
        this._operacionAritmetica = oa;
    }

}
/*
cion ::= operacion_aritmetica operadorRelacional operacion_aritmetica CondicionOperadorLogico
            | operacion_aritmetica operadorRelacional constChar CondicionOperadorLogico
            | operacion_aritmetica operadorRelacional constStr CondicionOperadorLogico
            | constChar operadorRelacional operacion_aritmetica CondicionOperadorLogico
            | constStr operadorRelacional operacion_aritmetica CondicionOperadorLogico
            | parentesisIzquierdo condicion parentesisDerecho CondicionOperadorLogico;
*/