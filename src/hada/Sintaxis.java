/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hada;

import java.util.ArrayList;

/**
 *
 * @author elmer
 */
public class Sintaxis {
    public String Sintaxis_definir_variable [] = {"Identificador",":","tiposVariables",";"};

    public String procesa_definir_varible(ArrayList<String> datosxProcesar){
    String resultado= "";
        for (int i = 0; i < Sintaxis_definir_variable.length; i++) {
            //String string = Sintaxis_definir_variable[i];
             if (datosxProcesar.size()<i+1){
              //  resultado =("Se omite --> "+Sintaxis_definir_variable[i]+" <--");
               //  System.out.println(resultado);
            }else{
                if (datosxProcesar.get(i).trim().equals(Sintaxis_definir_variable[i].trim()))
                {}
                else
                {
                    resultado =("La línea presenta un error en posición "+(i+1)+" en el dato >>> "
                            +datosxProcesar.get(i)
                            +" <<< Se esperaba  --> "+ Sintaxis_definir_variable[i] +" <--");
                 //   System.out.println(resultado);
                    
                }
            }
        }
    
    return resultado;
    
}
}
