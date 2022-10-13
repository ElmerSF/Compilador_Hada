/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hada;

/**
 *
 * @author cchac
 */
public class TabladeSimbolos {
    
    enum Tipos 
    {
        Reservada("(SUMA|RESTA|MULTIPLICA|DIVIDE|PROGRAMA|ADA.TEXT_IO|begin)"),
        
        Operadores("[*|/|+|-]"),
        Numero_Entero("[0-9]*|[' '][0-9]*|[0-9]*[' ']|[+|-][0-9]*"),
        Numero_Real("[0-9]*[.][0-9]*"),
        finlinea("(;)"),
        Palabra("[A-Za-z]*"),
        Agrupacion("[(|)]+");
        
        
        public final String patron;
        Tipos(String s){
            this.patron =s;
        }
    }
    
}
