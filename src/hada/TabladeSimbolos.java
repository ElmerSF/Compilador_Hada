/*
 UNED Informática Compiladores 3307
Estudiante Elmer Eduardo Salazar Flores 3-0426-0158
III Cuatrimestre 2022
Tabla de los Simbolos según los lineamientos del lenguaje HADA
 */
package hada;


public class TabladeSimbolos {
    
    static Palabras_Reservadas_Ada Res_ada = new Palabras_Reservadas_Ada();
    static final String Reservadas = Res_ada.lista();
    static Palabras_Reservadas_Hada Res_hada = new Palabras_Reservadas_Hada();
    static final String Reservadas_ha = Res_hada.lista();
    
    public enum Tipos {
       Procedure("PROCEDURE|procedure|Procedure"),
       Is("IS|is"),
       Begin("BEGIN|Begin|begin"),
       End("END|end|End"),
      
       Reservada_Hada(""+Reservadas_ha),
       Reservada_Ada(""+Reservadas),
        comentario("[--]."),
       
        num("[0-9]"),
        Nombre_Archivo("([A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,})"),
        lista_variables("([A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,})([[,][[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]]]{1,})([[,][[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]]]{0,})*(:)"),
        Operadores("[\\*|/|+|-]{1,}"),
        Cadena("(([\"])([' '|\n|\t]|[^\"].{0,})([\"]))"),
        Numero_Entero("[0-9]*|[' '][0-9]*|[0-9]*[' ']|[+|-][0-9]*"),
        Numero_Real("[0-9]*[.][0-9]*"),
        finlinea("(;)"),
        Etiqueta("([<<]{1,})([A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,})([>>]{1,}[;])"),
        Agrupacion("[(|)]{1,}");
        

        public final String patron;

        Tipos(String s) {
            this.patron = s;
            
        }
    }
  
  
    

}
