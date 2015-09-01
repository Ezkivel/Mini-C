package minic;

public class Token 
{
    private final String tipo;
    private final String contenido;
    private final int linea;
    private final int columna;
    
    public Token(String tipo, String texto, int linea, int columna)
    {
        this.tipo = tipo;
        this.contenido = texto;
        this.linea = linea;
        this.columna = columna;
    }

    public String getTipo() {
        return tipo;
    }

    public String getContenido() {
        return contenido;
    }

    public int getLinea() {
        return linea;
    }

    public int getColumna() {
        return columna;
    }
    
    @Override
    public String toString() {
        return "Token{" + "tipo = " + tipo + ", contenido = " + contenido + ", linea = " + linea + ", columna = " + columna + '}';
    }
}
