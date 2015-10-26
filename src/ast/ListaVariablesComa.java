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

    public ListaVariables _listaVariables;
    public nombreVariable _nombreVariable;
    public coma _coma;

    public ListaVariablesComa(ListaVariables lv, coma coma) {
        this._listaVariables = lv;
        this._coma = coma;
    }

}
