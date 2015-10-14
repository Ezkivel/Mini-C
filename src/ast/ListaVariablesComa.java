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
public class ListaVariablesComa {

    private Vector list;

    public ListaVariablesComa() {
        list = new Vector();
    }

    public void add(ListaVariables n) {
        list.add(0, n);
    }

    public ListaVariables elementAt(int i) {
        return (ListaVariables) list.elementAt(i);
    }

    public int size() {
        return list.size();
    }

}
