/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hada;
//("[*|/|+|-]"
/**
 *("[*|/|+|-]"
 * @author cchac
 */
public class TabladeExpresiones {
    
    enum Tipos {
        Inicio("(begin)"),
        Final("(-- fin del programa)"),
        Suma("[0-9]*\\+[0-9]*|[0-9]*[' ']\\SUMA[' '][0-9]*|[0-9]*[' ']\\+[' '][0-9]*|[0-9]*\\+[' '][0-9]*|[0-9]*[' ']\\+[0-9]*"),
        Resta("[0-9]*\\-[0-9]*"),
        final_linea(";"),
        Multiplica("[0-9]*\\s+(MULTIPLICA|MULTI|X)+\\s[0-9]*");
        
        public final String patron;
        Tipos(String s){
            this.patron =s;
        }        
    }
    
}
