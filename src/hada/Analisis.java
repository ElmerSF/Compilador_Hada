/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hada;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author cchac
 */
public class Analisis {
    
    Read_Archivo txt = new Read_Archivo();
    
    public void leerArchivo(String NombArch)
    {
        String linea;
        int contador=1;
        BufferedReader br;
        
        try {
            br = new BufferedReader(new FileReader(NombArch));
            
            while ((linea= br.readLine())!=null) //Lectura del archivo por l�nea
            {
                AnalizaTexto(linea);
                        }
            
        } catch (FileNotFoundException ex)
        {
            System.out.println("Archivo no encontrado");
        } catch (IOException ex){
          System.out.println("Archivo no encontrado o no se pudo abrir");
        }
        
    }
    
    
    public void AnalizaTexto(String TxtLinea)
    {
        StringTokenizer segmentos = new StringTokenizer(TxtLinea);
        int cuenta=0;
        String Expresion= new String();
        boolean TokenClasificado= false;
        String Respuesta ="";
        String Respuesta2 ="";
        
        if (TxtLinea.length()>80)
        {
            txt.escribir(" La línea supera los 80 caracteres");
        }else{
            
                while (segmentos.hasMoreTokens())
        {
            String token = segmentos.nextToken();
                        
            //=======================Verificar los tokens=================================
            
            for (TabladeSimbolos.Tipos comparaTOKENS : TabladeSimbolos.Tipos.values())
            {
                
                if (TokenClasificado)
                {
                    TokenClasificado = false; 
                    break; 
                }
                if (token.matches(comparaTOKENS.patron))
                {
                    switch (comparaTOKENS)
                    {
                        case Reservada:
                            
                            txt.escribir(" Es una palabra reservada");
                            Respuesta = (token +" Es una palabra reservada");
                            TokenClasificado =true;
                            break;
                        case Numeros:
                           txt.escribir(" Es un número");
                            
                            TokenClasificado =true;
                            break;
                        case Palabra:
                            System.out.println(token + " Es un identificador de usuario");
                            txt.escribir(" Es un identificador de usuario");
                            TokenClasificado =true;
                            break;
                        case Operadores:
                            System.out.println(token + " Es un operador relacional");
                            txt.escribir(" Es un operador relacional");
                            TokenClasificado =true;
                            break;
                         case nombre:
                            System.out.println(token + " Es un nombre");
                            txt.escribir( " Es un operador relacional");
                            TokenClasificado =true;
                            break;   
                    }
                }
            
            }
            if (cuenta==0)
                Expresion=Expresion+token;
            else
                Expresion=Expresion+" "+token;
            cuenta++;
           
           
        }
        
        //=======================Verificar las expresiones =================================
        //System.out.println("Expresion --->> "+Expresion);
    
        Boolean encontrado=false;
        for (TabladeExpresiones.Tipos comparaExpresiones : TabladeExpresiones.Tipos.values())
        {
            if (Expresion.matches(comparaExpresiones.patron))
            {
                switch (comparaExpresiones)
                {
                    case Inicio:
                        System.out.println(Expresion+" --> Es una instrucci�n de inicio");
                        txt.escribir(" --> Es una instrucción de inicio");
                        encontrado=true;
                        break;
                    case Final:
                        System.out.println(Expresion+" --> Es una instrucci�n de final");
                        txt.escribir(" --> Es una instrucción de final");
                        encontrado=true;
                        break;
                    case Suma:
                       System.out.println(Expresion+" --> Es una suma correcta!");
                       txt.escribir(" --> Es una suma correcta!");
                        encontrado=true;
                        break;
                    case Resta:
                        System.out.println(Expresion+" --> Es una resta correcta!");
                        txt.escribir(" --> Es una resta correcta!");
                        encontrado=true;
                        break;                    
                    case Multiplica:
                        System.out.println(Expresion+" --> Es una multiplicaci�n correcta!");
                        txt.escribir(" --> Es una resta correcta!");
                        encontrado=true;
                        break;
                    default:
                        System.out.println(Expresion+"---> Expresi�n no encontrada!!");
                        txt.escribir("---> Expresi�n no encontrada!!");
                }           
            }
        }
        if (encontrado==false)
        {
            System.out.println(Expresion+" >>>> Expresi�n no encontrada!!");
         
        } 
        }
       
    }
    
}
