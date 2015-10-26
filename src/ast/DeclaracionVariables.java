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
public class DeclaracionVariables extends Codigo {

    public Tipo _tipo;
    public ListaVariables _listaVariables;
    public puntoYComa _puntoYComa;

    public DeclaracionVariables(Tipo t, ListaVariables lv, puntoYComa pyc) {
        this._tipo = t;
        this._listaVariables = lv;
        this._puntoYComa = pyc;
    }

}
