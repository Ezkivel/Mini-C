/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast;

import java.util.Vector;

/**
 *
 * @author Gabriel
 */
public class DeclaracionVariables {

    private Vector list;
    public DeclaracionVariables _declaracionVariables;
    public ListaVariables _listaVariables;
    private Tipo tipo;
    private nombreVariable _nombreVariable;

    public DeclaracionVariables(DeclaracionVariables _declaracionVariables, ListaVariables _listaVariables) {
        this._declaracionVariables = _declaracionVariables;
        this._listaVariables = _listaVariables;
    }

    public DeclaracionVariables() {
        list = new Vector();
    }

    public void add(ListaVariables n) {
        list.add(n);
    }

    public ListaVariables elementAt(int i) {
        return (ListaVariables) list.elementAt(i);
    }

    public int size() {
        return list.size();
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public nombreVariable getNombreVariable() {
        return _nombreVariable;
    }

    public void setNombreVariable(nombreVariable _nombreVariable) {
        this._nombreVariable = _nombreVariable;
    }

}
