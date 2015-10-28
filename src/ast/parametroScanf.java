/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast;

/**
 *
 * @author Gabriel
 */
public class parametroScanf {

    public String _parametroScanf;
    public final int linea;
    public final int columna;

    public parametroScanf(String _parametroScanf, int linea, int columna) {
        this._parametroScanf = _parametroScanf;
        this.linea = linea;
        this.columna = columna;
    }

}
