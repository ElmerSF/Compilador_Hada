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
        while (segmentos.hasMoreTokens())
        {
            String token = segmentos.nextToken();
            System.out.println("Token ---------------->> "+token + " <<----------------");
            
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
                            System.out.println(token +" Es una palabra reservada");
                            TokenClasificado =true;
                            break;
                        case Numeros:
                            System.out.println(token +" Es un n�mero");
                            TokenClasificado =true;
                            break;
                        case Palabra:
                            System.out.println(token + " Es un identificador de usuario");
                            TokenClasificado =true;
                            break;
                        case Operadores:
                            System.out.println(token + " Es un operador relacional");
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
        System.out.println("Expresion --->> "+Expresion);
    
        Boolean encontrado=false;
        for (TabladeExpresiones.Tipos comparaExpresiones : TabladeExpresiones.Tipos.values())
        {
            if (Expresion.matches(comparaExpresiones.patron))
            {
                switch (comparaExpresiones)
                {
                    case Inicio:
                        System.out.println(Expresion+" --> Es una instrucci�n de inicio");
                        encontrado=true;
                        break;
                    case Final:
                        System.out.println(Expresion+" --> Es una instrucci�n de final");
                        encontrado=true;
                        break;
                    case Suma:
                        System.out.println(Expresion+" --> Es una suma correcta!");
                        encontrado=true;
                        break;
                    case Resta:
                        System.out.println(Expresion+" --> Es una resta correcta!");
                        encontrado=true;
                        break;                    
                    case Multiplica:
                        System.out.println(Expresion+" --> Es una multiplicaci�n correcta!");
                        encontrado=true;
                        break;
                    default:
                        System.out.println(Expresion+"---> Expresi�n no encontrada!!");
                }           
            }
        }
        if (encontrado==false)
        {
            System.out.println(Expresion+" >>>> Expresi�n no encontrada!!");
        }    
    }
}
