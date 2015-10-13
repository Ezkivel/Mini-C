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
public class Codigos {

    private Vector list;

    public Codigos() {
        list = new Vector();
    }

    public void add(Codigo n) {
        list.add(0, n);
    }

    public Codigo elementAt(int i) {
        return (Codigo) list.elementAt(i);
    }

    public int size() {
        return list.size();
    }

}
