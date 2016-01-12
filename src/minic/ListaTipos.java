/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minic;

import ast.*;
import ast.Tipo;
import java.util.Vector;

/**
 *
 * @author Gabriel
 */
public class ListaTipos {

    protected Vector list;

    public ListaTipos() {
        this.list = new Vector();
    }

    public void add(_ListaTipos n) {
        list.add(0, n);
    }

    public _ListaTipos elementAt(int i) {
        return (_ListaTipos) list.elementAt(i);
    }

    public int size() {
        return list.size();
    }

    public Tipo buscarId(String id) {
        Tipo resultado = null;
        if (size() >= 0) {
            for (int i = 0; i < size(); i++) {
                _ListaTipos temp = elementAt(i);
                if (temp.getNombre().equals(id)) {
                    resultado = temp.getTipo();
                    break;
                } 
            }
        }
        return resultado;
    }
    
    public void clear() {
        this.list.clear();
    }

}
