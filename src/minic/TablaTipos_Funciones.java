/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minic;

import ast.*;
import java.util.Vector;

/**
 *
 * @author Gabriel
 */
public class TablaTipos_Funciones extends TablaTipos {

    private Tipo _tipo_retorno;
    private Vector<Tipo> _parametros;

    public TablaTipos_Funciones(Tipo _tipo_retorno, Vector<Tipo> _parametros, String _nombre, String _ambito) {
        super(_nombre, _ambito);
        this._tipo_retorno = _tipo_retorno;
        this._parametros = _parametros;
    }

    public Tipo getTipo_retorno() {
        return _tipo_retorno;
    }

    public Vector<Tipo> getParametros() {
        return _parametros;
    }

}
