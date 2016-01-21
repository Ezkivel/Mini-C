package minic;

import ast.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MiniC {
    public static ListaTipos tablaSimbolos = new ListaTipos();
    public static Vector<String> codigoIntermedio = new Vector();
    public static Vector<String> listaMensajes = new Vector();
    public static Vector<String> codigoFinal = new Vector();
    public static int codigoFinal_temporal = -1;
    public static int codigoFinal_parametro = -1;
    public static Vector<String> listaContenidoTemporales = new Vector();
    
    public static String nombreArchivoFuente = "";
    public static String directorioArchivoFuente = "";

    public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
        //Esta funcion se encarga de crear la clase <AnalizadorLexico> en base al archivo .jflex
        //Ejecutar luego de hacer algun cambio en el archivo .jflex
        try {
            generarClases();

            MoverArchivosCAP();
            //Archivo fuente
            JFileChooser fc = new JFileChooser();

            int returnVal = fc.showOpenDialog(fc);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                FileReader fr = new FileReader(file);
                
                directorioArchivoFuente = file.getParent();
                nombreArchivoFuente = file.getName();
                System.out.println(nombreArchivoFuente);

                //Analizar e imprimir los tokens
                Analizador(fr);
            }
        } catch (Exception e) {
            System.err.println("ERROR main: " + e.getMessage());
        }

    }

    public static void Analizador(FileReader file) throws IOException, Exception {
        AnalizadorLexico al = new AnalizadorLexico(file);

        //Imprime los tokens 
        try {
            /*Token token = null;
             do {
             token = (Token) al.next_token().value;
             if (token != null) {
             System.out.println(token);
             }
             } while (token != null);*/

            AnalizadorSintactico as = new AnalizadorSintactico(al);
            as.parse();
            Programa generarPrograma = as.getGenerarPrograma();
            
            for( int i = as.lista.size() - 1; i >= 0; i--)
            {
                System.out.println(as.lista.elementAt(i).toString());
            }
            
            as.codigoIntermedio_generar();
            
            tablaSimbolos = as.lista;
            codigoIntermedio = as.codigoIntermedio;
            
            if (as.codigoFuenteValido()) {
                generarCodigoFinal();
            }

        } catch (Exception e) {
            System.err.println("ERROR Analizador: " + e.toString());
        }
    }
    
    
    
    
    
    public static void generarCodigoFinal() {
        codigoFinal_initListaContenidoTemporales();
        codigoFinal_llenarListaMensajes();
        codigoFinal_data();
        codigoFinal_main();
        
        System.out.println("\n\nCodigo Final:\n");
        
        for (int a = 0; a < codigoFinal.size(); a++) {
            System.out.println(codigoFinal.elementAt(a));
        }
        
        generarArchivosResultantes();
    }
    
    public static void generarArchivosResultantes() {
        Charset utf8 = StandardCharsets.UTF_8;
        
        Path archivoCodigoIntermedio = Paths.get(directorioArchivoFuente + File.separator + nombreArchivoFuente + "_intermedio.txt");
        Path archivoCodigoFinal = Paths.get(directorioArchivoFuente + File.separator + nombreArchivoFuente + "_final.asm");
        
        try {
            List<String> lines = codigoIntermedio;
            
            Files.write(archivoCodigoIntermedio, lines, utf8);
        } catch (IOException ex) {
            Logger.getLogger(MiniC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            List<String> lines = codigoFinal;
            
            Files.write(archivoCodigoFinal, lines, utf8);
        } catch (IOException ex) {
            Logger.getLogger(MiniC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void codigoFinal_initListaContenidoTemporales() {
        listaContenidoTemporales.add("");
        listaContenidoTemporales.add("");
        listaContenidoTemporales.add("");
        listaContenidoTemporales.add("");
        listaContenidoTemporales.add("");
        listaContenidoTemporales.add("");
        listaContenidoTemporales.add("");
        listaContenidoTemporales.add("");
        listaContenidoTemporales.add("");
        listaContenidoTemporales.add("");
    }
    
    public static void codigoFinal_llenarListaMensajes() {
        for (int a = 0; a < codigoIntermedio.size(); a++) {
            if (codigoIntermedio.elementAt(a).startsWith("print \"")) {
                String mensaje = codigoIntermedio.elementAt(a).substring(6);
                boolean yaEsta = false;
                
                for (int b = 0; b < listaMensajes.size(); b++) {
                    if (listaMensajes.elementAt(b).equals(mensaje)) {
                        yaEsta = true;
                    }
                }
                
                if (!yaEsta) {
                    listaMensajes.add(mensaje);
                }
            }
        }
    }
    
    public static void codigoFinal_data() {
        codigoFinal.add(".data");
        codigoFinal.add("espacio: .asciiz \"\\n\"");
        
        if (listaMensajes.size() > 0) {
            for (int a = 0; a < listaMensajes.size(); a++) {
                String texto = "_msg" + a + ": .asciiz " + listaMensajes.elementAt(a);
                codigoFinal.add(texto);
            }
        }
        
        for (int a = 0; a < codigoIntermedio.size(); a++) {
            if (codigoIntermedio.elementAt(a).equals("funcion_main:")) {
                break;
            } else {
                String codigoActual = codigoIntermedio.elementAt(a);
                String variable = codigoActual.split("=")[0];
                
                for (int b = 0; b < tablaSimbolos.size(); b++) {
                    if (variable.equals(tablaSimbolos.elementAt(b).getNombre()) && tablaSimbolos.elementAt(b).getAmbito().equals("") && !tablaSimbolos.elementAt(b).isFuncion()) {
                        String codigoAnterior = codigoIntermedio.elementAt(a - 1);
                        String valor = codigoAnterior.split("=")[1];
                        
                        if (valor.matches("^-?\\d+$")) {
                            String texto = "_" + variable + ": .word " + valor;
                            codigoFinal.add(texto);
                        } else {
                            String texto = "_" + variable + ": .asciiz " + codigoActual.split("=")[1];
                            codigoFinal.add(texto);
                        }
                    }
                }
            }
        }
    }
    
    public static void codigoFinal_main() {
        codigoFinal.add(".text");
        codigoFinal.add(".globl main");
        codigoFinal.add("main:");
        
        for (int a = codigoIntermedio.indexOf("funcion_main:")+1; a < codigoIntermedio.size(); a++) {
            String lineaCodigo = codigoIntermedio.elementAt(a);
            
            //Print
            if (lineaCodigo.startsWith("print \"")) {
                String texto = lineaCodigo.substring(6);
                int indice = obtenerIndiceMensaje(texto);
                String variable = "_msg" + indice;
                
                codigoFinal.add("li $v0,4");
                codigoFinal.add("la $a0," + variable);
                codigoFinal.add("syscall");
                
                if (codigoIntermedio.elementAt(a + 1).startsWith("print \"")) {
                    //Nueva linea
                    codigoFinal.add("addi $v0,$zero,4");
                    codigoFinal.add("la $a0,espacio");
                    codigoFinal.add("syscall");
                }
            } else if(lineaCodigo.startsWith("print ")) {
                String variable = lineaCodigo.substring(6);
                
                //Se va a imprimir un numero
                if (variable.matches("\\d+")) {
                    String temporal = "$t" + nuevoTemporal();
                    
                    codigoFinal.add("li " + temporal + "," + variable);
                    
                    codigoFinal.add("li $v0,1");
                    codigoFinal.add("move $a0," + temporal);
                    codigoFinal.add("syscall");
                } else {
                    String temporal = obtenerTemporalDeVariable(variable);
                
                    codigoFinal.add("li $v0,1");
                    codigoFinal.add("move $a0," + temporal);
                    codigoFinal.add("syscall");
                }
                
                //Nueva linea
                codigoFinal.add("addi $v0,$zero,4");
                codigoFinal.add("la $a0,espacio");
                codigoFinal.add("syscall");
            }
            
            
            
            //Read
            if (lineaCodigo.startsWith("read ")) {
                String variable = lineaCodigo.substring(5);
                
                //La variable no ha sido utilizada
                if (obtenerTemporalDeVariable(variable).equals("-1")) {
                    String temporal = "$t" + nuevoTemporal();
                    enlazarContenidoATemporal(variable);
                
                    codigoFinal.add("li $v0,5");
                    codigoFinal.add("syscall");
                    codigoFinal.add("move " + temporal + ",$v0");
                } else {
                    String temporal = obtenerTemporalDeVariable(variable);
                    
                    codigoFinal.add("li $v0,5");
                    codigoFinal.add("syscall");
                    codigoFinal.add("move " + temporal + ",$v0");
                }
            }
            
            
            
            //Asignacion
            if (!lineaCodigo.contains("==") && lineaCodigo.contains("=")) {
                String variable = lineaCodigo.split("=")[0];
                String operacion = lineaCodigo.split("=")[1];
                
                if (operacion.contains("+")) {
                    String variable1 = operacion.split("\\+")[0];
                    String variable2 = operacion.split("\\+")[1];
                    
                    //Ya hay temporales almacenando las variables de la derecha (Ejemplo: se hizo un read antes)
                    if (!obtenerTemporalDeVariable(variable1).equals("-1") && !obtenerTemporalDeVariable(variable2).equals("-1")) {
                        String temporalVariable1 = obtenerTemporalDeVariable(variable1);
                        String temporalVariable2 = obtenerTemporalDeVariable(variable2);
                        
                        //La variable de la izquierda NO ha sido usada (ningun temporal guarda la variable)
                        if (obtenerTemporalDeVariable(variable).equals("-1")) {
                            String temporalVariable = "$t" + nuevoTemporal();
                            enlazarContenidoATemporal(variable);
                            
                            codigoFinal.add("add " + temporalVariable + "," + temporalVariable1 + "," + temporalVariable2);
                        } else {//La variable de la izquierda HA sido usada (un temporal guarda la variable)
                            String temporalVariable = obtenerTemporalDeVariable(variable);
                            
                            codigoFinal.add("add " + temporalVariable + "," + temporalVariable1 + "," + temporalVariable2);
                        }//Ninguna de las variables de la derecha han sido usadas
                    } else if (obtenerTemporalDeVariable(variable1).equals("-1") && obtenerTemporalDeVariable(variable2).equals("-1")) {
                        //La variable de la izquierda NO ha sido usada (ningun temporal guarda la variable)
                        if (obtenerTemporalDeVariable(variable).equals("-1")) {
                            //Si ambas variables son numero
                            if (variable1.matches("\\d+") && variable2.matches("\\d+")) {
                                String temporalVariable1 = "$t" + nuevoTemporal();
                                enlazarContenidoATemporal(variable1);

                                codigoFinal.add("li " + temporalVariable1 + "," + variable1);

                                String temporalVariable2 = "$t" + nuevoTemporal();
                                enlazarContenidoATemporal(variable2);

                                codigoFinal.add("li " + temporalVariable2 + "," + variable2);

                                String temporalVariable = "$t" + nuevoTemporal();
                                enlazarContenidoATemporal(variable);

                                codigoFinal.add("add " + temporalVariable + "," + temporalVariable1 + "," + temporalVariable2);
                            }
                        } else {//La variable de la izquierda HA sido usada (un temporal guarda la variable)
                            //Si ambas variables son numero
                            if (variable1.matches("\\d+") && variable2.matches("\\d+")) {
                                String temporalVariable1 = "$t" + nuevoTemporal();
                                enlazarContenidoATemporal(variable1);

                                codigoFinal.add("li " + temporalVariable1 + "," + variable1);

                                String temporalVariable2 = "$t" + nuevoTemporal();
                                enlazarContenidoATemporal(variable2);

                                codigoFinal.add("li " + temporalVariable2 + "," + variable2);

                                String temporalVariable = obtenerTemporalDeVariable(variable);

                                codigoFinal.add("add " + temporalVariable + "," + temporalVariable1 + "," + temporalVariable2);
                            }
                        } //La variable1 HA sido usada pero la variable2 NO
                    } else if (!obtenerTemporalDeVariable(variable1).equals("-1") && obtenerTemporalDeVariable(variable2).equals("-1")){
                        //La variable de la izquierda NO ha sido usada (ningun temporal guarda la variable)
                        if (obtenerTemporalDeVariable(variable).equals("-1")) {
                            if (variable2.matches("\\d+")) {
                                String temporalVariable1 =  obtenerTemporalDeVariable(variable1);
                                
                                String temporalVariable = "$t" + nuevoTemporal();
                                enlazarContenidoATemporal(variable);
                                
                                codigoFinal.add("addi " + temporalVariable + "," + temporalVariable1 + "," + variable2);
                            }
                        } else {//La variable de la izquierda HA sido usada (un temporal guarda la variable)
                            if (variable2.matches("\\d+")) {
                                String temporalVariable1 =  obtenerTemporalDeVariable(variable1);
                                
                                String temporalVariable = obtenerTemporalDeVariable(variable);
                                
                                codigoFinal.add("addi " + temporalVariable + "," + temporalVariable1 + "," + variable2);
                            }
                        } //La variable1 NO ha sido usada pero la variable2 SI
                    } else if (obtenerTemporalDeVariable(variable1).equals("-1") && !obtenerTemporalDeVariable(variable2).equals("-1")){
                        //La variable de la izquierda NO ha sido usada (ningun temporal guarda la variable)
                        if (obtenerTemporalDeVariable(variable).equals("-1")) {
                            if (variable1.matches("\\d+")) {
                                String temporalVariable2 =  obtenerTemporalDeVariable(variable2);
                                
                                String temporalVariable = "$t" + nuevoTemporal();
                                enlazarContenidoATemporal(variable);
                                
                                codigoFinal.add("addi " + temporalVariable + "," + temporalVariable2 + "," + variable1);
                            }
                        } else {//La variable de la izquierda HA sido usada (un temporal guarda la variable)
                            if (variable1.matches("\\d+")) {
                                String temporalVariable2 =  obtenerTemporalDeVariable(variable2);
                                
                                String temporalVariable = obtenerTemporalDeVariable(variable);
                                
                                codigoFinal.add("addi " + temporalVariable + "," + temporalVariable2 + "," + variable1);
                            }
                        }
                    }
                } else if (lineaCodigo.contains("-")) {
                    String variable1 = operacion.split("\\-")[0];
                    String variable2 = operacion.split("\\-")[1];
                    
                    //Ya hay temporales almacenando las variables de la derecha (Ejemplo: se hizo un read antes)
                    if (!obtenerTemporalDeVariable(variable1).equals("-1") && !obtenerTemporalDeVariable(variable2).equals("-1")) {
                        String temporalVariable1 = obtenerTemporalDeVariable(variable1);
                        String temporalVariable2 = obtenerTemporalDeVariable(variable2);
                        
                        //La variable de la izquierda NO ha sido usada (ningun temporal guarda la variable)
                        if (obtenerTemporalDeVariable(variable).equals("-1")) {
                            String temporalVariable = "$t" + nuevoTemporal();
                            enlazarContenidoATemporal(variable);
                            
                            codigoFinal.add("sub " + temporalVariable + "," + temporalVariable1 + "," + temporalVariable2);
                        } else {//La variable de la izquierda HA sido usada (un temporal guarda la variable)
                            String temporalVariable = obtenerTemporalDeVariable(variable);
                            
                            codigoFinal.add("sub " + temporalVariable + "," + temporalVariable1 + "," + temporalVariable2);
                        }//Ninguna de las variables de la derecha han sido usadas
                    } else if (obtenerTemporalDeVariable(variable1).equals("-1") && obtenerTemporalDeVariable(variable2).equals("-1")) {
                        //La variable de la izquierda NO ha sido usada (ningun temporal guarda la variable)
                        if (obtenerTemporalDeVariable(variable).equals("-1")) {
                            //Si ambas variables son numero
                            if (variable1.matches("\\d+") && variable2.matches("\\d+")) {
                                String temporalVariable1 = "$t" + nuevoTemporal();
                                enlazarContenidoATemporal(variable1);

                                codigoFinal.add("li " + temporalVariable1 + "," + variable1);

                                String temporalVariable2 = "$t" + nuevoTemporal();
                                enlazarContenidoATemporal(variable2);

                                codigoFinal.add("li " + temporalVariable2 + "," + variable2);

                                String temporalVariable = "$t" + nuevoTemporal();
                                enlazarContenidoATemporal(variable);

                                codigoFinal.add("sub " + temporalVariable + "," + temporalVariable1 + "," + temporalVariable2);
                            }
                        } else {//La variable de la izquierda HA sido usada (un temporal guarda la variable)
                            //Si ambas variables son numero
                            if (variable1.matches("\\d+") && variable2.matches("\\d+")) {
                                String temporalVariable1 = "$t" + nuevoTemporal();
                                enlazarContenidoATemporal(variable1);

                                codigoFinal.add("li " + temporalVariable1 + "," + variable1);

                                String temporalVariable2 = "$t" + nuevoTemporal();
                                enlazarContenidoATemporal(variable2);

                                codigoFinal.add("li " + temporalVariable2 + "," + variable2);

                                String temporalVariable = obtenerTemporalDeVariable(variable);

                                codigoFinal.add("sub " + temporalVariable + "," + temporalVariable1 + "," + temporalVariable2);
                            }
                        } //La variable1 HA sido usada pero la variable2 NO
                    } else if (!obtenerTemporalDeVariable(variable1).equals("-1") && obtenerTemporalDeVariable(variable2).equals("-1")){
                        //La variable de la izquierda NO ha sido usada (ningun temporal guarda la variable)
                        if (obtenerTemporalDeVariable(variable).equals("-1")) {
                            if (variable2.matches("\\d+")) {
                                String temporalVariable1 =  obtenerTemporalDeVariable(variable1);
                                
                                String temporalVariable = "$t" + nuevoTemporal();
                                enlazarContenidoATemporal(variable);
                                
                                codigoFinal.add("sub " + temporalVariable + "," + temporalVariable1 + "," + variable2);
                            }
                        } else {//La variable de la izquierda HA sido usada (un temporal guarda la variable)
                            if (variable2.matches("\\d+")) {
                                String temporalVariable1 =  obtenerTemporalDeVariable(variable1);
                                
                                String temporalVariable = obtenerTemporalDeVariable(variable);
                                
                                codigoFinal.add("sub " + temporalVariable + "," + temporalVariable1 + "," + variable2);
                            }
                        } //La variable1 NO ha sido usada pero la variable2 SI
                    } else if (obtenerTemporalDeVariable(variable1).equals("-1") && !obtenerTemporalDeVariable(variable2).equals("-1")){
                        //La variable de la izquierda NO ha sido usada (ningun temporal guarda la variable)
                        if (obtenerTemporalDeVariable(variable).equals("-1")) {
                            if (variable1.matches("\\d+")) {
                                String temporalVariable1 = "$t" + nuevoTemporal();
                                enlazarContenidoATemporal(variable1);

                                codigoFinal.add("li " + temporalVariable1 + "," + variable1);
                                
                                String temporalVariable2 =  obtenerTemporalDeVariable(variable2);
                                
                                String temporalVariable = "$t" + nuevoTemporal();
                                enlazarContenidoATemporal(variable);
                                
                                codigoFinal.add("sub " + temporalVariable + "," + temporalVariable1 + "," + temporalVariable2);
                            }
                        } else {//La variable de la izquierda HA sido usada (un temporal guarda la variable)
                            if (variable1.matches("\\d+")) {
                                String temporalVariable1 = "$t" + nuevoTemporal();
                                enlazarContenidoATemporal(variable1);

                                codigoFinal.add("li " + temporalVariable1 + "," + variable1);
                                
                                String temporalVariable2 =  obtenerTemporalDeVariable(variable2);
                                
                                String temporalVariable = obtenerTemporalDeVariable(variable);
                                
                                codigoFinal.add("sub " + temporalVariable + "," + temporalVariable1 + "," + temporalVariable2);
                            }
                        }
                    }
                } else if (lineaCodigo.contains("*")) {
                    String variable1 = operacion.split("\\*")[0];
                    String variable2 = operacion.split("\\*")[1];
                    
                    //Ya hay temporales almacenando las variables de la derecha (Ejemplo: se hizo un read antes)
                    if (!obtenerTemporalDeVariable(variable1).equals("-1") && !obtenerTemporalDeVariable(variable2).equals("-1")) {
                        String temporalVariable1 = obtenerTemporalDeVariable(variable1);
                        String temporalVariable2 = obtenerTemporalDeVariable(variable2);
                        
                        //La variable de la izquierda NO ha sido usada (ningun temporal guarda la variable)
                        if (obtenerTemporalDeVariable(variable).equals("-1")) {
                            String temporalVariable = "$t" + nuevoTemporal();
                            enlazarContenidoATemporal(variable);
                            
                            codigoFinal.add("mult " + temporalVariable1 + "," + temporalVariable2);
                            codigoFinal.add("mflo " + temporalVariable);
                        } else {//La variable de la izquierda HA sido usada (un temporal guarda la variable)
                            String temporalVariable = obtenerTemporalDeVariable(variable);
                            
                            codigoFinal.add("mult " + temporalVariable1 + "," + temporalVariable2);
                            codigoFinal.add("mflo " + temporalVariable);
                        }//Ninguna de las variables de la derecha han sido usadas
                    } else if (obtenerTemporalDeVariable(variable1).equals("-1") && obtenerTemporalDeVariable(variable2).equals("-1")) {
                        //La variable de la izquierda NO ha sido usada (ningun temporal guarda la variable)
                        if (obtenerTemporalDeVariable(variable).equals("-1")) {
                            //Si ambas variables son numero
                            if (variable1.matches("\\d+") && variable2.matches("\\d+")) {
                                String temporalVariable1 = "$t" + nuevoTemporal();
                                enlazarContenidoATemporal(variable1);

                                codigoFinal.add("li " + temporalVariable1 + "," + variable1);

                                String temporalVariable2 = "$t" + nuevoTemporal();
                                enlazarContenidoATemporal(variable2);

                                codigoFinal.add("li " + temporalVariable2 + "," + variable2);

                                String temporalVariable = "$t" + nuevoTemporal();
                                enlazarContenidoATemporal(variable);

                                codigoFinal.add("mult " + temporalVariable1 + "," + temporalVariable2);
                                codigoFinal.add("mflo " + temporalVariable);
                            }
                        } else {//La variable de la izquierda HA sido usada (un temporal guarda la variable)
                            //Si ambas variables son numero
                            if (variable1.matches("\\d+") && variable2.matches("\\d+")) {
                                String temporalVariable1 = "$t" + nuevoTemporal();
                                enlazarContenidoATemporal(variable1);

                                codigoFinal.add("li " + temporalVariable1 + "," + variable1);

                                String temporalVariable2 = "$t" + nuevoTemporal();
                                enlazarContenidoATemporal(variable2);

                                codigoFinal.add("li " + temporalVariable2 + "," + variable2);

                                String temporalVariable = obtenerTemporalDeVariable(variable);

                                codigoFinal.add("mult " + temporalVariable1 + "," + temporalVariable2);
                                codigoFinal.add("mflo " + temporalVariable);
                            }
                        } //La variable1 HA sido usada pero la variable2 NO
                    } else if (!obtenerTemporalDeVariable(variable1).equals("-1") && obtenerTemporalDeVariable(variable2).equals("-1")){
                        //La variable de la izquierda NO ha sido usada (ningun temporal guarda la variable)
                        if (obtenerTemporalDeVariable(variable).equals("-1")) {
                            if (variable2.matches("\\d+")) {
                                String temporalVariable1 =  obtenerTemporalDeVariable(variable1);
                                
                                String temporalVariable2 = "$t" + nuevoTemporal();
                                enlazarContenidoATemporal(variable2);

                                codigoFinal.add("li " + temporalVariable2 + "," + variable2);
                                
                                String temporalVariable = "$t" + nuevoTemporal();
                                enlazarContenidoATemporal(variable);
                                
                                codigoFinal.add("mult " + temporalVariable1 + "," + temporalVariable2);
                                codigoFinal.add("mflo " + temporalVariable);
                            }
                        } else {//La variable de la izquierda HA sido usada (un temporal guarda la variable)
                            if (variable2.matches("\\d+")) {
                                String temporalVariable1 =  obtenerTemporalDeVariable(variable1);
                                
                                String temporalVariable2 = "$t" + nuevoTemporal();
                                enlazarContenidoATemporal(variable2);

                                codigoFinal.add("li " + temporalVariable2 + "," + variable2);
                                
                                String temporalVariable = obtenerTemporalDeVariable(variable);
                                
                                codigoFinal.add("mult " + temporalVariable1 + "," + temporalVariable2);
                                codigoFinal.add("mflo " + temporalVariable);
                            }
                        } //La variable1 NO ha sido usada pero la variable2 SI
                    } else if (obtenerTemporalDeVariable(variable1).equals("-1") && !obtenerTemporalDeVariable(variable2).equals("-1")){
                        //La variable de la izquierda NO ha sido usada (ningun temporal guarda la variable)
                        if (obtenerTemporalDeVariable(variable).equals("-1")) {
                            if (variable1.matches("\\d+")) {
                                String temporalVariable1 = "$t" + nuevoTemporal();
                                enlazarContenidoATemporal(variable1);

                                codigoFinal.add("li " + temporalVariable1 + "," + variable1);
                                
                                String temporalVariable2 =  obtenerTemporalDeVariable(variable2);
                                
                                String temporalVariable = "$t" + nuevoTemporal();
                                enlazarContenidoATemporal(variable);
                                
                                codigoFinal.add("mult " + temporalVariable2 + "," + temporalVariable1);
                                codigoFinal.add("mflo " + temporalVariable);
                            }
                        } else {//La variable de la izquierda HA sido usada (un temporal guarda la variable)
                            if (variable1.matches("\\d+")) {
                                String temporalVariable1 = "$t" + nuevoTemporal();
                                enlazarContenidoATemporal(variable1);

                                codigoFinal.add("li " + temporalVariable1 + "," + variable1);
                                
                                String temporalVariable2 =  obtenerTemporalDeVariable(variable2);
                                
                                String temporalVariable = obtenerTemporalDeVariable(variable);
                                
                                codigoFinal.add("mult " + temporalVariable2 + "," + temporalVariable1);
                                codigoFinal.add("mflo " + temporalVariable);
                            }
                        }
                    }
                } else if (lineaCodigo.contains("/")) {
                    String variable1 = operacion.split("\\/")[0];
                    String variable2 = operacion.split("\\/")[1];
                    
                    //Ya hay temporales almacenando las variables de la derecha (Ejemplo: se hizo un read antes)
                    if (!obtenerTemporalDeVariable(variable1).equals("-1") && !obtenerTemporalDeVariable(variable2).equals("-1")) {
                        String temporalVariable1 = obtenerTemporalDeVariable(variable1);
                        String temporalVariable2 = obtenerTemporalDeVariable(variable2);
                        
                        //La variable de la izquierda NO ha sido usada (ningun temporal guarda la variable)
                        if (obtenerTemporalDeVariable(variable).equals("-1")) {
                            String temporalVariable = "$t" + nuevoTemporal();
                            enlazarContenidoATemporal(variable);
                            
                            codigoFinal.add("div " + temporalVariable1 + "," + temporalVariable2);
                            codigoFinal.add("mflo " + temporalVariable);
                        } else {//La variable de la izquierda HA sido usada (un temporal guarda la variable)
                            String temporalVariable = obtenerTemporalDeVariable(variable);
                            
                            codigoFinal.add("div " + temporalVariable1 + "," + temporalVariable2);
                            codigoFinal.add("mflo " + temporalVariable);
                        }//Ninguna de las variables de la derecha han sido usadas
                    } else if (obtenerTemporalDeVariable(variable1).equals("-1") && obtenerTemporalDeVariable(variable2).equals("-1")) {
                        //La variable de la izquierda NO ha sido usada (ningun temporal guarda la variable)
                        if (obtenerTemporalDeVariable(variable).equals("-1")) {
                            //Si ambas variables son numero
                            if (variable1.matches("\\d+") && variable2.matches("\\d+")) {
                                String temporalVariable1 = "$t" + nuevoTemporal();
                                enlazarContenidoATemporal(variable1);

                                codigoFinal.add("li " + temporalVariable1 + "," + variable1);

                                String temporalVariable2 = "$t" + nuevoTemporal();
                                enlazarContenidoATemporal(variable2);

                                codigoFinal.add("li " + temporalVariable2 + "," + variable2);

                                String temporalVariable = "$t" + nuevoTemporal();
                                enlazarContenidoATemporal(variable);

                                codigoFinal.add("div " + temporalVariable1 + "," + temporalVariable2);
                                codigoFinal.add("mflo " + temporalVariable);
                            }
                        } else {//La variable de la izquierda HA sido usada (un temporal guarda la variable)
                            //Si ambas variables son numero
                            if (variable1.matches("\\d+") && variable2.matches("\\d+")) {
                                String temporalVariable1 = "$t" + nuevoTemporal();
                                enlazarContenidoATemporal(variable1);

                                codigoFinal.add("li " + temporalVariable1 + "," + variable1);

                                String temporalVariable2 = "$t" + nuevoTemporal();
                                enlazarContenidoATemporal(variable2);

                                codigoFinal.add("li " + temporalVariable2 + "," + variable2);

                                String temporalVariable = obtenerTemporalDeVariable(variable);

                                codigoFinal.add("div " + temporalVariable1 + "," + temporalVariable2);
                                codigoFinal.add("mflo " + temporalVariable);
                            }
                        } //La variable1 HA sido usada pero la variable2 NO
                    } else if (!obtenerTemporalDeVariable(variable1).equals("-1") && obtenerTemporalDeVariable(variable2).equals("-1")){
                        //La variable de la izquierda NO ha sido usada (ningun temporal guarda la variable)
                        if (obtenerTemporalDeVariable(variable).equals("-1")) {
                            if (variable2.matches("\\d+")) {
                                String temporalVariable1 =  obtenerTemporalDeVariable(variable1);
                                
                                String temporalVariable2 = "$t" + nuevoTemporal();
                                enlazarContenidoATemporal(variable2);

                                codigoFinal.add("li " + temporalVariable2 + "," + variable2);
                                
                                String temporalVariable = "$t" + nuevoTemporal();
                                enlazarContenidoATemporal(variable);
                                
                                codigoFinal.add("div " + temporalVariable1 + "," + temporalVariable2);
                                codigoFinal.add("mflo " + temporalVariable);
                            }
                        } else {//La variable de la izquierda HA sido usada (un temporal guarda la variable)
                            if (variable2.matches("\\d+")) {
                                String temporalVariable1 =  obtenerTemporalDeVariable(variable1);
                                
                                String temporalVariable2 = "$t" + nuevoTemporal();
                                enlazarContenidoATemporal(variable2);

                                codigoFinal.add("li " + temporalVariable2 + "," + variable2);
                                
                                String temporalVariable = obtenerTemporalDeVariable(variable);
                                
                                codigoFinal.add("div " + temporalVariable1 + "," + temporalVariable2);
                                codigoFinal.add("mflo " + temporalVariable);
                            }
                        } //La variable1 NO ha sido usada pero la variable2 SI
                    } else if (obtenerTemporalDeVariable(variable1).equals("-1") && !obtenerTemporalDeVariable(variable2).equals("-1")){
                        //La variable de la izquierda NO ha sido usada (ningun temporal guarda la variable)
                        if (obtenerTemporalDeVariable(variable).equals("-1")) {
                            if (variable1.matches("\\d+")) {
                                String temporalVariable1 = "$t" + nuevoTemporal();
                                enlazarContenidoATemporal(variable1);

                                codigoFinal.add("li " + temporalVariable1 + "," + variable1);
                                
                                String temporalVariable2 =  obtenerTemporalDeVariable(variable2);
                                
                                String temporalVariable = "$t" + nuevoTemporal();
                                enlazarContenidoATemporal(variable);
                                
                                codigoFinal.add("div " + temporalVariable1 + "," + temporalVariable2);
                                codigoFinal.add("mflo " + temporalVariable);
                            }
                        } else {//La variable de la izquierda HA sido usada (un temporal guarda la variable)
                            if (variable1.matches("\\d+")) {
                                String temporalVariable1 = "$t" + nuevoTemporal();
                                enlazarContenidoATemporal(variable1);

                                codigoFinal.add("li " + temporalVariable1 + "," + variable1);
                                
                                String temporalVariable2 =  obtenerTemporalDeVariable(variable2);
                                
                                String temporalVariable = obtenerTemporalDeVariable(variable);
                                
                                codigoFinal.add("div " + temporalVariable1 + "," + temporalVariable2);
                                codigoFinal.add("mflo " + temporalVariable);
                            }
                        }
                    }
                } else { //Solo una variable a la derecha
                    String contenido = operacion;

                    //La variable de la izquierda NO ha sido usada (ningun temporal guarda la variable)
                    if (obtenerTemporalDeVariable(variable).equals("-1")) {
                        //La variable de la derecha HA sido usada (un temporal guarda la variable)  
                        if (!obtenerTemporalDeVariable(contenido).equals("-1")) {
                            String temporalContenido = obtenerTemporalDeVariable(contenido);
                            
                            String temporalVariable = "$t" + nuevoTemporal();
                            enlazarContenidoATemporal(variable);

                            codigoFinal.add("addi " + temporalVariable + "," + temporalContenido + ",0");
                        } else {//La variable de la derecha NO sido usada (ningun temporal guarda la variable)
                            //Si lo que esta a la derecha es un numero
                            if (contenido.matches("\\d+")) {
                                String temporalVariable = "$t" + nuevoTemporal();
                                enlazarContenidoATemporal(variable);

                                codigoFinal.add("li " + temporalVariable + "," + contenido);
                            }
                        }
                    } else {//La variable de la izquierda HA sido usada (un temporal guarda la variable)
                        //La variable de la derecha HA sido usada (un temporal guarda la variable)  
                        if (!obtenerTemporalDeVariable(contenido).equals("-1")) {
                            String temporalVariable = obtenerTemporalDeVariable(variable); //Reutiliza el temporal
                            String temporalContenido = obtenerTemporalDeVariable(contenido);
                            
                            codigoFinal.add("addi " + temporalVariable + "," + temporalContenido + ",0");
                        } else {//La variable de la derecha NO ha sido usada (ningun temporal guarda la variable)
                            //Si lo que esta a la derecha es un numero
                            if (contenido.matches("\\d+")) {
                                String temporalVariable = obtenerTemporalDeVariable(variable); //Reutiliza el temporal
                                
                                codigoFinal.add("li " + temporalVariable + "," + contenido);
                            }
                        }
                    }
                }
            }
            
            
            
            //IF
            if (lineaCodigo.startsWith("if ")) {
                String condicion = lineaCodigo.split(" ")[1];
                String etiqueta = lineaCodigo.split(" ")[3];
                
                if (condicion.contains("==")) {
                    String variable1 = condicion.split("==")[0];
                    String variable2 = condicion.split("==")[1];
                    
                    //Si la variable de la derecha es un numero
                    if (variable2.matches("\\d+")) {
                        String temporalVariable1 = obtenerTemporalDeVariable(variable1);
                        
                        codigoFinal.add("beq " + temporalVariable1 + "," + variable2 + "," + etiqueta);
                    } else { //La variable de la derecha NO es un numero
                        String temporalVariable1 = obtenerTemporalDeVariable(variable1);
                        String temporalVariable2 = obtenerTemporalDeVariable(variable2);
                        
                        codigoFinal.add("beq " + temporalVariable1 + "," + temporalVariable2 + "," + etiqueta);
                    }
                } else if (condicion.contains("!=")) {
                    String variable1 = condicion.split("!=")[0];
                    String variable2 = condicion.split("!=")[1];
                    
                    //Si la variable de la derecha es un numero
                    if (variable2.matches("\\d+")) {
                        String temporalVariable1 = obtenerTemporalDeVariable(variable1);
                        
                        codigoFinal.add("bne " + temporalVariable1 + "," + variable2 + "," + etiqueta);
                    } else { //La variable de la derecha NO es un numero
                        String temporalVariable1 = obtenerTemporalDeVariable(variable1);
                        String temporalVariable2 = obtenerTemporalDeVariable(variable2);
                        
                        codigoFinal.add("bne " + temporalVariable1 + "," + temporalVariable2 + "," + etiqueta);
                    }
                } else if (condicion.contains(">=")) {
                    String variable1 = condicion.split(">=")[0];
                    String variable2 = condicion.split(">=")[1];
                    
                    //Si la variable de la derecha es un numero
                    if (variable2.matches("\\d+")) {
                        String temporalVariable1 = obtenerTemporalDeVariable(variable1);
                        
                        codigoFinal.add("bge " + temporalVariable1 + "," + variable2 + "," + etiqueta);
                    } else { //La variable de la derecha NO es un numero
                        String temporalVariable1 = obtenerTemporalDeVariable(variable1);
                        String temporalVariable2 = obtenerTemporalDeVariable(variable2);
                        
                        codigoFinal.add("bge " + temporalVariable1 + "," + temporalVariable2 + "," + etiqueta);
                    }
                } else if (condicion.contains("<=")) {
                    String variable1 = condicion.split("<=")[0];
                    String variable2 = condicion.split("<=")[1];
                    
                    //Si la variable de la derecha es un numero
                    if (variable2.matches("\\d+")) {
                        String temporalVariable1 = obtenerTemporalDeVariable(variable1);
                        
                        codigoFinal.add("ble " + temporalVariable1 + "," + variable2 + "," + etiqueta);
                    } else { //La variable de la derecha NO es un numero
                        String temporalVariable1 = obtenerTemporalDeVariable(variable1);
                        String temporalVariable2 = obtenerTemporalDeVariable(variable2);
                        
                        codigoFinal.add("ble " + temporalVariable1 + "," + temporalVariable2 + "," + etiqueta);
                    }
                } else if (condicion.contains(">")) {
                    String variable1 = condicion.split(">")[0];
                    String variable2 = condicion.split(">")[1];
                    
                    //Si la variable de la derecha es un numero
                    if (variable2.matches("\\d+")) {
                        String temporalVariable1 = obtenerTemporalDeVariable(variable1);
                        
                        codigoFinal.add("bgt " + temporalVariable1 + "," + variable2 + "," + etiqueta);
                    } else { //La variable de la derecha NO es un numero
                        String temporalVariable1 = obtenerTemporalDeVariable(variable1);
                        String temporalVariable2 = obtenerTemporalDeVariable(variable2);
                        
                        codigoFinal.add("bgt " + temporalVariable1 + "," + temporalVariable2 + "," + etiqueta);
                    }
                } else if (condicion.contains("<")) {
                    String variable1 = condicion.split("<")[0];
                    String variable2 = condicion.split("<")[1];
                    
                    //Si la variable de la derecha es un numero
                    if (variable2.matches("\\d+")) {
                        String temporalVariable1 = obtenerTemporalDeVariable(variable1);
                        
                        codigoFinal.add("blt " + temporalVariable1 + "," + variable2 + "," + etiqueta);
                    } else { //La variable de la derecha NO es un numero
                        String temporalVariable1 = obtenerTemporalDeVariable(variable1);
                        String temporalVariable2 = obtenerTemporalDeVariable(variable2);
                        
                        codigoFinal.add("blt " + temporalVariable1 + "," + temporalVariable2 + "," + etiqueta);
                    }
                }
            }

            //GOTO
            if (lineaCodigo.startsWith("goto")) {
                String etiqueta = lineaCodigo.split(" ")[1];
                
                codigoFinal.add("b " + etiqueta);
            }
            
            //Etiqueta
            if (lineaCodigo.startsWith("etiqueta_")) {
                codigoFinal.add(lineaCodigo);
            }
            
            //llamado a funcion (parametro)
            if (lineaCodigo.startsWith("param ")) {
                String parametro = lineaCodigo.split(" ")[1];
                
                //El parametro es un numero
                if (parametro.matches("\\d+")) {
                    codigoFinal.add("li $a" + nuevoParametro() + "," + parametro);
                } else {
                    String temporalParametro = obtenerTemporalDeVariable(parametro);
                    
                    codigoFinal.add("addi $a" + nuevoParametro() + "," + temporalParametro + ",0");
                }
            }
            
            if (lineaCodigo.startsWith("call ")) {
                String funcion = lineaCodigo.split(" ")[1];
                
                codigoFinal.add("jal funcion_" + funcion);
                
                //Resetea los parametros
                codigoFinal_parametro = -1;
            }
            
            if (lineaCodigo.contains("=RET")) {
                String variable = lineaCodigo.split("=")[0];
                
                //La variable no ha sido usada (no esta en la lista)
                if (obtenerTemporalDeVariable(variable).equals("-1")) {
                    String temporalVariable = "$t" + nuevoTemporal();
                    enlazarContenidoATemporal(variable);
                    
                    codigoFinal.add("move " + temporalVariable + ",$v0");
                } else {
                    String temporalVariable = obtenerTemporalDeVariable(variable);
                    
                    codigoFinal.add("move " + temporalVariable + ",$v0");
                }
            }
            
            //Funcion
            if (lineaCodigo.startsWith("funcion_")) {
                String funcion = lineaCodigo.split("_")[1];
                
                codigoFinal.add(lineaCodigo);
                
                codigoFinal.add("sw $fp,-4($sp)");
                codigoFinal.add("sw $ra,-8($sp)");
                codigoFinal.add("move $fp,$sp");
                codigoFinal.add("sub $sp,$sp,12");
                
                
                Vector<String> parametros = obtenerParametrosFuncion(funcion);
                
                //Recorre los parametros (variable) en caso de que hayan
                for (int i = 0; i < parametros.size(); i++) {
                    String variable = parametros.elementAt(i);
                    
                    //La variable no ha sido usada
                    if (obtenerTemporalDeVariable(variable).equals("-1")) {
                        String temporalVariable = "$t" + nuevoTemporal();
                        enlazarContenidoATemporal(variable);
                        
                        codigoFinal.add("move " + temporalVariable + "," + "$a" + i);
                    } else {
                        String temporalVariable = obtenerTemporalDeVariable(variable);
                        
                        codigoFinal.add("move " + temporalVariable + "," + "$a" + i);
                    }
                }
            }
            
            if (lineaCodigo.startsWith("return ")) {
                String variable = lineaCodigo.split(" ")[1];
                
                //Es un numero
                if (variable.matches("\\d+")) {
                    codigoFinal.add("li $v0," + variable);
                } else {
                    String temporalVariable = obtenerTemporalDeVariable(variable);
                
                    codigoFinal.add("move $v0," + temporalVariable);
                }
            }
            
            //Fin de una funcion
            if (lineaCodigo.startsWith("FIN_") && !lineaCodigo.contains("main")) {
                codigoFinal.add("move $sp,$fp");
                codigoFinal.add("lw $ra,-8($fp)");
                codigoFinal.add("lw $fp,-4($fp)");
                codigoFinal.add("jr $ra");
            }
            
            
            //FIN
            if (lineaCodigo.equals("FIN_main")) {
                codigoFinal.add("li $v0,10");
                codigoFinal.add("syscall");
            }
        }
    }
    
    public static int obtenerIndiceMensaje(String texto) {
        for (int a = 0; a < listaMensajes.size(); a++) {
            if (texto.equals(listaMensajes.elementAt(a))) {
                return a;
            }
        }
        
        return -1;
    }
    
    public static int nuevoTemporal() {
        /*int contadorLibres = 0;
        int temporal = 0;
        
        //Limpia la lista (borra los t)
        for (int i = 0; i < listaContenidoTemporales.size(); i++) {
            if (listaContenidoTemporales.elementAt(i).equals("")) {
                contadorLibres++;
            } else if (listaContenidoTemporales.elementAt(i).matches("t\\d")) {
                listaContenidoTemporales.set(i, "");
                contadorLibres++;
            }
        }
        
        //Hay espacio libre
        if (contadorLibres > 0) {
            for (int i = 0; i < listaContenidoTemporales.size(); i++) {
                if (listaContenidoTemporales.elementAt(i).equals("")) {
                    return i;
                }
            }
        } else {
            temporal = codigoFinal_temporal == 9 ? 0 : ++codigoFinal_temporal;
        }
        
        return temporal;*/
        
        return codigoFinal_temporal == 9 ? 0 : ++codigoFinal_temporal;
    }
    
    public static int nuevoParametro() {
        return ++codigoFinal_parametro;
    }
    
    public static int temporalActual() {
        return codigoFinal_temporal;
    }
    
    public static void enlazarContenidoATemporal(String variable) {
        int temporalActual = temporalActual();
        
        listaContenidoTemporales.set(temporalActual, variable);
    }
    
    public static String obtenerTemporalDeVariable(String variable) {
        String temporal = "-1";
        
        for (int i = 0; i < listaContenidoTemporales.size(); i++) {
            if (listaContenidoTemporales.elementAt(i).equals(variable)) {
                temporal = "$t" + i;
                
                break;
            }
        }
        
        return temporal;
    }
    
    public static Vector<String> obtenerParametrosFuncion(String funcion) {
        Vector<String> parametros = new Vector();
        int cantidadParametros = 0;
        int contador = 1;
        
        for (int a = 0; a < tablaSimbolos.size(); a++) {
            if (tablaSimbolos.elementAt(a).getNombre().equals(funcion) && tablaSimbolos.elementAt(a).isFuncion()) {
                cantidadParametros = tablaSimbolos.elementAt(a).getParametros().size();
            }
            
            if (contador <= cantidadParametros) {
                if (tablaSimbolos.elementAt(a).getAmbito().equals(funcion)) {
                    parametros.add(tablaSimbolos.elementAt(a).getNombre());
                    contador++;
                }
            }
        }
        
        return parametros;
    }
    
    
    
    
    
    public static void generarClases() {
        try {
            String path = System.getProperty("user.dir") + "\\src\\minic\\AnalizadorSintactico.cup";
            String[] analizadorSintactico = {"-parser", "AnalizadorSintactico", path};
            java_cup.Main.main(analizadorSintactico);

            //Esta funcion se encarga de crear la clase <AnalizadorLexico> en base al archivo .jflex  
            path = System.getProperty("user.dir") + "\\src\\minic\\AnalizadorLexico.jflex";
            File file = new File(path);
            jflex.Main.generate(file);
        } catch (Exception e) {
            System.err.println("ERROR generarClases: " + e.getMessage());
        }
    }

    public static void MoverArchivosCAP() {
        InputStream inStreamA = null;
        InputStream inStreamB = null;
        OutputStream outStreamA = null;
        OutputStream outStreamB = null;
        try {

            File afile = new File("./AnalizadorSintactico.java");
            File bfile = new File("./sym.java");
            File pathA = new File("./src/minic/AnalizadorSintactico.java");
            File pathB = new File("./src/minic/sym.java");

            if (pathA.exists() && pathB.exists()) {
                pathA.delete();
                pathB.delete();
            }

            inStreamA = new FileInputStream(afile);
            inStreamB = new FileInputStream(bfile);
            outStreamA = new FileOutputStream(pathA);
            outStreamB = new FileOutputStream(pathB);

            byte[] buffer = new byte[1024];

            int length;
            //copy the file content in bytes 
            while ((length = inStreamA.read(buffer)) > 0) {

                outStreamA.write(buffer, 0, length);

            }
            while ((length = inStreamB.read(buffer)) > 0) {

                outStreamB.write(buffer, 0, length);

            }
            inStreamA.close();
            outStreamA.close();
            inStreamB.close();
            outStreamB.close();

            //delete the original file
            afile.delete();
            bfile.delete();

            System.out.println("Files were copied successfully!");
            System.out.println(pathA.getName());
            System.out.println(pathB.getName());

        } catch (IOException e) {
            System.err.println("ERROR MoverArchivosCAP: " + e.getMessage());
        }
    }

}
