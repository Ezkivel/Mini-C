package minic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;

public class MiniC 
{
    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
        //Esta funcion se encarga de crear la clase <AnalizadorLexico> en base al archivo .jflex
        //Ejecutar luego de hacer algun cambio en el archivo .jflex
        //generarClaseAnalizadorLexico();
        
        //Archivo fuente
        JFileChooser fc = new JFileChooser();
        
        int returnVal = fc.showOpenDialog(fc);

        if (returnVal == JFileChooser.APPROVE_OPTION) 
        {
            File file = fc.getSelectedFile();
            FileReader fr = new FileReader(file);
            
            //Analizar e imprimir los tokens
            Analizador(fr);
        }
    }
    
    public static void Analizador(FileReader file) throws IOException
    {
        AnalizadorLexico al = new AnalizadorLexico(file);
        Token token = null;
        
        //Recorre todos los tokens
        do
        {
            token = al.yylex();
            System.out.println(token);
        } while (token != null);
    }
    
    public static void generarClaseAnalizadorLexico()
    {
        //Esta funcion se encarga de crear la clase <AnalizadorLexico> en base al archivo .jflex
        
        JFileChooser fc = new JFileChooser();
        
        int returnVal = fc.showOpenDialog(fc);

        if (returnVal == JFileChooser.APPROVE_OPTION) 
        {
            File file = fc.getSelectedFile();
            jflex.Main.generate(file);
        }
    }
}
