/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minic;

import ast.Codigo;
import ast.DeclaracionVariable;
import java.util.Vector;

/**
 *
 * @author Gabriel
 */
public class ListaTipos {

    protected DeclaracionVariable _declaracionVariable;
    protected Vector<DeclaracionVariable> list;

    public ListaTipos() {
        this.list = new Vector();
    }

    public void add(DeclaracionVariable n) {
        list.add(0, n);
    }

    public DeclaracionVariable elementAt(int i) {
        return (DeclaracionVariable) list.elementAt(i);
    }

    public int size() {
        return list.size();
    }

}
