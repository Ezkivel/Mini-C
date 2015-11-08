/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minic;

/**
 *
 * @author Gabriel
 */
public class ListaTipos {

    protected String _nombre;
    protected int _ambito;

    public ListaTipos(String _nombre, int _ambito) {
        this._nombre = _nombre;
        this._ambito = _ambito;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public int getAmbito() {
        return _ambito;

    }

    public void setAmbito(int _ambito) {
        this._ambito = _ambito;
    }

}
