/*
 UNED Informática Compiladores 3307
Estudiante Elmer Eduardo Salazar Flores 3-0426-0158
III Cuatrimestre 2022
Tabla de los Simbolos según los lineamientos del lenguaje HADA
 */
package hada;

/**
 *
 * @author cchac
 */
public class TabladeSimbolos {
    
    enum Tipos 
    {
        Procedure("PROCEDURE|procedure|Procedure"),
        Reservada("(SUMA|RESTA|MULTIPLICA|DIVIDE|PROGRAMA|ADA.TEXT_IO|begin)"),
        Is ("IS|is"),
        Nombre_Archivo ("[a-z|A-Z]{1,20}[a-z|A-Z|0-9|_]*{0,20}[a-z|A-Z|0-9]*]{0,20}[^_]"),
        Operadores("[*|/|+|-]{1,}"),
        Cadena("(([\"])([' '|\n|\t]|[^\"].{0,})([\"]))"),
        Numero_Entero("[0-9]*|[' '][0-9]*|[0-9]*[' ']|[+|-][0-9]*"),
        Numero_Real("[0-9]*[.][0-9]*"),
        finlinea("(;)"),
        Palabra("[A-Za-z]{1,}"),
        Agrupacion("[(|)]{1,}");
        
        
        public final String patron;
        Tipos(String s){
            this.patron =s;
        }
    }
    
}
