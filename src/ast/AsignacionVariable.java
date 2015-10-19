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
public class AsignacionVariable {

    public Variable v;
    public OperacionAritmetica oa;
    public AsignacionVariableComa avc;
    public operadorAritmeticoIgual oi;
    public constChar cstC;
    public constStr cstS;

    public AsignacionVariable(Variable v, OperacionAritmetica oa, AsignacionVariableComa avc) {
        this.v = v;
        this.oa = oa;
        this.avc = avc;
    }

    public AsignacionVariable(Variable v, OperacionAritmetica oa, AsignacionVariableComa avc, operadorAritmeticoIgual oi) {
        this.v = v;
        this.oa = oa;
        this.avc = avc;
        this.oi = oi;
    }

    public AsignacionVariable(Variable v, AsignacionVariableComa avc, constChar cstC) {
        this.v = v;
        this.avc = avc;
        this.cstC = cstC;
    }

    public AsignacionVariable(Variable v, AsignacionVariableComa avc, constStr cstS) {
        this.v = v;
        this.avc = avc;
        this.cstS = cstS;
    }

    public AsignacionVariable() {
    }

}
