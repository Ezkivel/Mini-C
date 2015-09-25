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
class Printf {

    public constStr cs;
    public OperacionAritmetica oa;

    public Printf(constStr cs, OperacionAritmetica oa) {
        this.cs = cs;
        this.oa = oa;
    }

    public Printf(constStr cs) {
        this.cs = cs;
    }

}
