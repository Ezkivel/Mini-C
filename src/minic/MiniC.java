package minic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;

public class MiniC 
{
    public static void main(String[] args) throws FileNotFoundException, IOException, Exception 
    {
        //Esta funcion se encarga de crear la clase <AnalizadorLexico> en base al archivo .jflex
        //Ejecutar luego de hacer algun cambio en el archivo .jflex
        generarClases();
        
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
    
    public static void Analizador(FileReader file) throws IOException, Exception
    {
        AnalizadorLexico al = new AnalizadorLexico(file);
        Token token = null;
        
        //Recorre todos los tokens
        do
        {
            token = (Token)al.next_token().value;
            System.out.println(token);
        } while (token != null);
        
        AnalizadorSintactico as = new AnalizadorSintactico(al);
        as.parse();
    }
    
    public static void generarClases() throws IOException, Exception
    {
        String path = System.getProperty("user.dir") + "\\src\\minic\\AnalizadorSintactico.cup";
        String[] analizadorSintactico = {"-parser", "AnalizadorSintactico", path};
        java_cup.Main.main(analizadorSintactico);
        
        
        //Esta funcion se encarga de crear la clase <AnalizadorLexico> en base al archivo .jflex  
        path = System.getProperty("user.dir") + "\\src\\minic\\AnalizadorLexico.jflex";
        File file = new File(path);        
        jflex.Main.generate(file);
    }
}
