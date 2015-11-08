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
public class DeclaracionVariable extends Codigo {

    public Tipo _tipo;
    public DeclaracionVariables _declaracionVariables;
    public puntoYComa _puntoYComa;

    public DeclaracionVariable(Tipo t, DeclaracionVariables lv, puntoYComa pyc) {
        this._tipo = t;
        this._declaracionVariables = lv;
        this._puntoYComa = pyc;
    }
    

}
