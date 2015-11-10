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

    private Vector<ListaTipos_Variable> listaTipos;
    private Programa programa;
    private ListaTipos lista;

    public TablaTipos(ListaTipos lista) {
        this.listaTipos = new Vector();
        this.lista = lista;
        llenar_tabla_variables();
    }

    public void llenar_tabla_variables() {
        try {

            int n = lista.list.size();
            for (int i = 0; i < n; i++) {
                DeclaracionVariable d = lista.list.elementAt(i);
                int in = d._declaracionVariables.size();

                for (int j = 0; j < in; j++) {
                    if(d._declaracionVariables.elementAt(j)._inicializacionArreglo != null )
                    {
                        //el arreglo no se que pedos
                        System.out.println("fack");
                    }
                    listaTipos.add(new ListaTipos_Variable(d._tipo, d._declaracionVariables.elementAt(j)._nombreVariable._nombreVariable, 0));
                }

            }
        } catch (Exception e) {

        }
    }

    public void llenar_tabla_funciones() {

    }

    public void print() {
        int n = listaTipos.size();
        System.out.println(n);
        for (int i = 0; i < n; i++) {
            System.out.println(listaTipos.elementAt(i).getTipo().getClass().getName() + " " + listaTipos.elementAt(i).getNombre() + " " + listaTipos.elementAt(i).getAmbito());
        }
    }

}
