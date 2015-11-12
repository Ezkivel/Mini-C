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
public class Ambito {

    public int ambito;

    public Ambito() {
        this.ambito = 0;
    }

    public void generarAmbito() {
        this.ambito = ambito + 1;
    }

    public int getAmbito() {
        return ambito;
    }
    
}
