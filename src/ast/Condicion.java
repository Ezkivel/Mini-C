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

    public OperacionAritmetica oa;
    public constChar cc;
    public constStr cs;
    public Condicion cn;
    public CondicionOperadorLogico co;

    public Condicion(OperacionAritmetica oa) {
        this.oa = oa;
    }

}
