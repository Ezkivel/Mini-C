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
public class constChar {

    public String _constChar;
    public final int linea;
    public final int columna;

    public constChar(String c, int linea, int columna) {
        this._constChar = c;
        this.linea = linea;
        this.columna = columna;
    }

}
