/*
 UNED Informática Compiladores 3307
Estudiante Elmer Eduardo Salazar Flores 3-0426-0158
III Cuatrimestre 2022
En esta clase se realiza la lectura del arhivo y creación del arhivo de errores
 */
package hada;


public class Errores {
   String Error=""; 
    
    public String Asigna_Error(int codigo)
    {
     
        switch (codigo) {
            case 1:  Error = ("\n>!!!Error [" +codigo+"] La Linea supera los 80 caracteres" ); break;
            case 2:  Error = ("\n>!!!Error [" +codigo+"] hay caracteres antes de la instrucción de inicio, si es un comentario falta --" ); break;
            case 3:  Error = ("\n>!!!Error [" +codigo+"] hay caracteres antes de la instrucción de inicio, si es un comentario falta --" ); break;
            case 4:  Error = ("\n>!!!Error [" +codigo+"] falta palabra Reservada IS en la declaración inicial" ); break;
            case 5:  Error = ("\n>!!!Error [" +codigo+"] Nombre de Identificador Empieza con _" ); break;
            case 6:  Error = ("\n>!!!Error [" +codigo+"] Nombre de Identificador Termina con _" ); break;
            case 7:  Error = ("\n>!!!Error [" +codigo+"] Nombre de Identificador Contiene caracteres no permitidos" ); break;
            case 8:  Error = ("\n>!!!Error [" +codigo+"] Nombre de Identifcador Empieza con un número" ); break;
            case 9:  Error = ("\n>!!!Error [" +codigo+"] falta >> de cierre de Etiqueta" ); break;
            case 10: Error = ("\n>!!!Error [" +codigo+"] falta << de apertura de Etiqueta" ); break;
            case 11: Error = ("\n>!!!Error [" +codigo+"] Falta ; en la expresión de suma " ); break;
            case 12: Error = ("\n>!!!Error [" +codigo+"] Es mayor al rango" ); break;
            case 13: Error = ("\n>!!!Error [" +codigo+"] Es menor al rango" ); break;
            case 14: Error = ("\n>!!!Error [" +codigo+"] Despues de PROCEDURE, BEGIN, IF, ELSE o FOR no debe llevar ;" ); break;
            case 15: Error = ("\n>!!!Error [" +codigo+"] Un token NO debe exender los 20 caracteres" ); break;
            case 16: Error = ("\n>!!!Error [" +codigo+"] Una Etiqueta no debe llevar ; al final" ); break;
            case 17: Error = ("\n>!!!Error [" +codigo+"] La palabra Reservada \"Procedure\" aparece [" ); break;
            case 18: Error = ("\n>!!!Error [" +codigo+"] La palabra Reservada \"Begin\" aparece [" ); break;
            case 19: Error = ("\n>!!!Error [" +codigo+"] La palabra Reservada \"end\" aparece [" ); break;
            case 20: Error = ("\n>!!!Error [" +codigo+"] La palabra Reservada \"Procedure\" no aparece" ); break;
            case 21: Error = ("\n>!!!Error [" +codigo+"] La palabra Reservada \"Begin\" no aparece" ); break;
            case 22: Error = ("\n>!!!Error [" +codigo+"] La palabra Reservada \"end\" no aparece" ); break;
            case 23: Error = ("\n>!!!Error [" +codigo+"] Para más de un identificador debe llevar coma y espacio " ); break;
            case 24: Error = ("\n>!!!Error [" +codigo+"] En la definición de variable falta indicar el tipo de variable \"INTERGER, FLOAT, CHARACTER\" y el caracter ; " ); break;
            case 25: Error = ("\n>!!!Error [" +codigo+"] En la definición de variable falta el caracter ; " ); break;
            case 26: Error = ("\n>!!!Error [" +codigo+"] En la definición de variable falta el primer indicador por lo que sobra una coma al inicio " ); break;
            case 27: Error = ("\n>!!!Error [" +codigo+"] En la definición de variable falta el último indicador por lo que sobra una coma al final " ); break;
            case 28: Error = ("\n>!!!Error [" +codigo+"] El tipo de variable no corresponde a: \"INTERGER, FLOAT, CHARACTER\" " ); break;
            case 29: Error = ("\n>!!!Error [" +codigo+"] Identificador repetido " ); break;
            default:
                Error = (">!!!Error [" +codigo+"] No ha sido clasificado" );
                throw new AssertionError();
        }
        
     
        
     return Error;  
    }
    
}
