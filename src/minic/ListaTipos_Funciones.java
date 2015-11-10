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
public class ListaTipos_Funciones extends ListaTipos {

    private Tipo _tipo_retorno;
    private String nombre;
    private Vector<Tipo> _parametros;
    private RETURN _return;

    public ListaTipos_Funciones(Tipo _tipo_retorno, String nombre, Vector<Tipo> _parametros) {
        this._tipo_retorno = _tipo_retorno;
        this.nombre = nombre;
        this._parametros = _parametros;
    }

    public void setTipo_retorno(Tipo _tipo_retorno) {
        this._tipo_retorno = _tipo_retorno;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setParametros(Vector<Tipo> _parametros) {
        this._parametros = _parametros;
    }

}
