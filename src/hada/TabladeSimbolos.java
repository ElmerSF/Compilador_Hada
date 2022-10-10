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
        Reservada("(SUMA|RESTA|MULTIPLICA|DIVIDE|PROGRAMA)"),
        Numeros("[0-9]*"),
        Palabra("[A-Za-z]*"),
        Operadores("(=|>=|<=|!=)");
        
        public final String patron;
        Tipos(String s){
            this.patron =s;
        }
    }
    
}
