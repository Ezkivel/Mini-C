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
public class constStr {

    public String _constStr;
    public final int linea;
    public final int columna;

    public constStr(String _constStr, int linea, int columna) {
        this._constStr = _constStr;
        this.linea = linea;
        this.columna = columna;
    }


}
