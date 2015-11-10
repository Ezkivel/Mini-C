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

public class MiniC {

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
            TablaTipos tabla = new TablaTipos(as.getListaVariables());
            tabla.print();
          // Testing
           /* System.out.println(generarPrograma._mainClass._codigo._prinft._constStr._constStr);
              System.out.println(generarPrograma._mainClass._codigo._codigo._prinft._constStr._constStr);
           */
        } catch (Exception e) {
            System.err.println("ERROR Analizador: " + e.getMessage());
        }
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
