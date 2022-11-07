/*
 * UNED Informática Compiladores 3307
Estudiante Elmer Eduardo Salazar Flores 3-0426-0158
III Cuatrimestre 2022
Clase para el análisis Sintáctico
 */
package hada;

import java.util.ArrayList;

/**
 *
 * @author elmer
 */
public class Sintaxis {
    Errores error = new Errores();
    public String Sintaxis_definir_variable [] = {"Identificador","Asignacion","Asignacion","expresion"};
     public String Sintaxis_get [] = {"GET","(","tiposVariables",")"};
     public String Sintaxis_skip_line [] = {"SKIP_LINE"};
     public String Sintaxis_put_integer [] = {"PUT","(","Var_integer",")"};
     public String Sintaxis_put_float [] = {"PUT","(","Var_float",")"};
     public String Sintaxis_put_character [] = {"PUT","(","Var_character",")"};
     public String Sintaxis_put_texto [] = {"PUT","(","Var_texto",")"};
    
     public String procesa_definir_varible(ArrayList<String> datosxProcesar){
    String resultado= "";
        for (int i = 0; i < Sintaxis_definir_variable.length; i++) {
            //String string = Sintaxis_definir_variable[i];
             if (datosxProcesar.size()<i+1){
                resultado =("Se omite --> "+Sintaxis_definir_variable[i]+" <--");
                 System.out.println(resultado);
            }else{
                if (datosxProcesar.get(i).trim().equals(Sintaxis_definir_variable[i].trim()))
                {}
                else
                {
                    resultado =("\nLa definición de variable presenta un error en posición "+(i+1)+" en el dato ["
                            +datosxProcesar.get(i)
                            +"] el dato que se esperaba  es --> "+ Sintaxis_definir_variable[i] +" <--");
                    System.out.println(resultado);
                    
                }
            }
        }
    
    return resultado;
    
}
     public String procesa_get(ArrayList<String> datosxProcesar){
          String resultado="";
          for (int i = 0; i < Sintaxis_get.length; i++) {
          
             if (datosxProcesar.size()<i+1){
               resultado =("Se omite --> "+Sintaxis_get[i]+" <--");
                 System.out.println(resultado);
            }else{
                if (datosxProcesar.get(i).trim().equals(Sintaxis_get[i].trim()))
                {}
                else
                {
                    resultado =("\nEl comando GET  presenta un error en posición "+(i+1)+" en el dato >>> "
                            +datosxProcesar.get(i)
                            +" <<< Se esperaba  --> "+ Sintaxis_get[i] +" <--");
                    System.out.println(resultado);
                    
                }
            }
        }
          return resultado;
      }
     public String procesa_skip_line(ArrayList<String> datosxProcesar){
          String resultado="";
          for (int i = 0; i < Sintaxis_skip_line.length; i++) {
          
             if (datosxProcesar.size()<i+1){
               resultado =("Se omite --> "+Sintaxis_skip_line[i]+" <--");
                 System.out.println(resultado);
            }else{
                if (datosxProcesar.get(i).trim().equals(Sintaxis_skip_line[i].trim()))
                {}
                else
                {
                    resultado =("\nEl comando SKIP_LINE presenta un error en posición "+(i+1)+" en el dato >>> "
                            +datosxProcesar.get(i)
                            +" <<< Se esperaba  --> "+ Sintaxis_skip_line[i] +" <--");
                    System.out.println(resultado);
                    
                }
            }
        }
          return resultado;
      }
     public String procesa_put_integer(ArrayList<String> datosxProcesar){
          String resultado="";
          for (int i = 0; i < Sintaxis_put_integer.length; i++) {
          
             if (datosxProcesar.size()<i+1){
               resultado =("Se omite --> "+Sintaxis_put_integer[i]+" <--");
                 System.out.println(resultado);
            }else{
                if (datosxProcesar.get(i).trim().equals(Sintaxis_put_integer[i].trim()))
                {}
                else
                {
                    resultado =("\n El comando PUT con datos INTEGER presenta un error en posición "+(i+1)+" en el dato >>> "
                            +datosxProcesar.get(i)
                            +" <<< Se esperaba  --> "+ Sintaxis_put_integer[i] +" <--");
                    System.out.println(resultado);
                    
                }
            }
        }
          return resultado;
      }
     public String procesa_put_float(ArrayList<String> datosxProcesar){
          String resultado="";
          for (int i = 0; i < Sintaxis_put_float.length; i++) {
          
             if (datosxProcesar.size()<i+1){
               resultado =("Se omite --> "+Sintaxis_put_float[i]+" <--");
                 System.out.println(resultado);
            }else{
                if (datosxProcesar.get(i).trim().equals(Sintaxis_put_float[i].trim()))
                {}
                else
                {
                    resultado =("\nEl comando PUT con datos FLOAT presenta un error en posición "+(i+1)+" en el dato >>> "
                            +datosxProcesar.get(i)
                            +" <<< Se esperaba  --> "+ Sintaxis_put_float[i] +" <--");
                    System.out.println(resultado);
                    
                }
            }
        }
          return resultado;
      }
     public String procesa_put_character(ArrayList<String> datosxProcesar){
          String resultado="";
          for (int i = 0; i < Sintaxis_put_character.length; i++) {
          
             if (datosxProcesar.size()<i+1){
               resultado =("Se omite --> "+Sintaxis_put_character[i]+" <--");
                 System.out.println(resultado);
            }else{
                if (datosxProcesar.get(i).trim().equals(Sintaxis_put_character[i].trim()))
                {}
                else
                {
                    resultado =("\nEl comando PUT con datos CHARACTER presenta un error en posición "+(i+1)+" en el dato >>> "
                            +datosxProcesar.get(i)
                            +" <<< Se esperaba  --> "+ Sintaxis_put_character[i] +" <--");
                    System.out.println(resultado);
                    
                }
            }
        }
          return resultado;
      }
     public String procesa_put_texto(ArrayList<String> datosxProcesar){
          String resultado="";
          for (int i = 0; i < Sintaxis_put_texto.length; i++) {
          
             if (datosxProcesar.size()<i+1){
               resultado =("Se omite --> "+Sintaxis_put_texto[i]+" <--");
                // System.out.println(resultado);
            }else{
                if (datosxProcesar.get(i).trim().equals(Sintaxis_put_texto[i].trim()))
                {}
                else
                {
                    resultado =("\nEl comando PUT con datos TEXTO presenta un error en posición "+(i+1)+" en el dato >>> "
                            +datosxProcesar.get(i)
                            +" <<< Se esperaba  --> "+ Sintaxis_put_texto[i] +" <--");
                   // System.out.println(resultado);
                    
                }
            }
        }
          return resultado;
      }
}
