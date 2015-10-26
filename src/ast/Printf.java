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
public class Printf {

    public constStr _constStr;
    public OperacionAritmetica _operacionAritmetica;

    public Printf(constStr cs, OperacionAritmetica oa) {
        this._constStr = cs;
        this._operacionAritmetica = oa;
    }

    public Printf(constStr cs) {
        this._constStr = cs;
    }

}
