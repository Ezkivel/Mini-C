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
public class _ListaTipos {

    private Tipo _tipo;
    private String nombre;
    private String ambito;
    private Vector<Tipo> _parametros;
    private boolean funcion;

    public _ListaTipos(Tipo _tipo, String nombre, String ambito) {
        this._tipo = _tipo;
        this.nombre = nombre;
        this.ambito = ambito;
    }

    public _ListaTipos(Tipo _tipo_retorno, String nombre, String ambito, Vector<Tipo> _parametros, boolean funcion) {
        this._tipo = _tipo_retorno;
        this.nombre = nombre;
        this.ambito = ambito;
        //this._parametros = _parametros;
        this.funcion = funcion;
        
        setParametros(_parametros);
    }

    public Tipo getTipo() {
        return _tipo;
    }

    public void setTipo(Tipo _tipo) {
        this._tipo = _tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public Vector<Tipo> getParametros() {
        return _parametros;
    }

    public void setParametros(Vector<Tipo> _parametros) {
        Vector<Tipo> parametrosTemp = _parametros;        
        this._parametros = new Vector();
        
        for (int i = parametrosTemp.size() - 1; i >= 0; i--) {
            this._parametros.add(parametrosTemp.elementAt(i));
        }
    }
    
    public boolean isFuncion() {
        return funcion;
    }

    public void setFuncion(boolean esFuncion) {
        this.funcion = esFuncion;
    }

    @Override
    public String toString() {
        return "_ListaTipos{" + "_tipo=" + getTipo() + ", nombre=" + getNombre() + ", ambito=" + getAmbito() + ", _parametros=" + _parametros + ", _funcion=" + isFuncion() + '}';
    }

}
