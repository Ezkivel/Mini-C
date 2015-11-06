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
public class TablaTipos {

    protected String _nombre;
    protected String _ambito;

    public TablaTipos(String _nombre, String _ambito) {
        this._nombre = _nombre;
        this._ambito = _ambito;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String getAmbito() {
        return _ambito;
    }

    public void setAmbito(String _ambito) {
        this._ambito = _ambito;
    }

}
