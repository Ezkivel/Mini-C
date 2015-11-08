/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minic;

import ast.Codigos;
import ast.DeclaracionVariable;
import ast.DeclaracionVariables;
import ast.For;
import ast.If;
import ast.ListaVariables;
import ast.Programa;
import ast.While;
import java.util.Vector;

/**
 *
 * @author Gabriel
 */
public class TablaTipos {

    private Vector<ListaTipos> listaTipos;

    private Programa programa;

    public TablaTipos(Programa p) {
        this.programa = p;
        this.listaTipos = new Vector();
        llenar_tabla_variables();
    }

    public Vector<ListaTipos> getLista() {
        return listaTipos;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void llenar_tabla_variables() {

        Codigos c = getPrograma()._mainClass._codigos;
        for (int i = 0; i < c.size(); i++) {
           try {
                DeclaracionVariables in = ((DeclaracionVariable) c.elementAt(i))._declaracionVariables;
                for (int l = 0; l < in.size(); l++) {

                    System.out.println(" " + ((ListaVariables)in.elementAt(l))._nombreVariable._nombreVariable );
                }
           }catch(Exception e)
           {
               
           }
            
        }
    }

    public void llenar_tabla_funciones() {

    }

    public void print() {
        System.out.println(listaTipos.size());
        for (int i = 0; i < listaTipos.size(); i++) {
            ListaTipos_Variable s = ((ListaTipos_Variable) listaTipos.elementAt(i));
            System.out.println(s._nombre + " " + s.getTipo().getClass().getName() + " " + s._ambito);
        }
    }

}
