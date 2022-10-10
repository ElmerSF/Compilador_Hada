/*
UNED Informática Compiladores 3307
Estudiante Elmer Eduardo Salazar Flores 3-0426-0158
III Cuatrimestre 2022
En esta clase se realiza la lectura del arhivo y creación del arhivo de errores
 */
package hada;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author elmer
 */
public class Read_Archivo {
    File log, errores;
    FileWriter escribirlog, escribirerror;//para poder llenar los datos
    PrintWriter reglonlog, reglonerror;//para agregar un nuevo reglon con información
    
    public void leerArchivo(String Archivo, String bitacora, DateTimeFormatter dtf)
    {
        
        
        String nomArchivo ="";
        String linea;
        int contador=0001;
     
        
        BufferedReader br;
        
        try {
        //log = new FileREader(bitacora);
        
        escribirlog = new FileWriter(bitacora, true);
        reglonlog = new PrintWriter(escribirlog);
        nomArchivo = Archivo.substring(0, Archivo.indexOf('.'));
        errores = new File (nomArchivo+"-errores.txt");
        escribirerror = new FileWriter(errores, true);
        reglonerror = new PrintWriter(escribirerror);
            
            br = new BufferedReader(new FileReader(Archivo));
            reglonlog.println("> "+dtf.format(LocalDateTime.now())+" ***** 02 INFORMACIÓN se comienza lectura de archivo "+Archivo);
            Analisis revi = new Analisis();
            
            
            while ((linea= br.readLine())!=null) //Lectura del archivo por línea
            {
                
                if (contador<10)
                {
                reglonerror.println("0000"+contador + " " + linea + " OK");
                        System.out.println(contador + " " + linea );
                        revi.AnalizaTexto(linea);
                        
                        contador++;
                }
                else{
                if(contador<100){
                reglonerror.println("000"+contador + " " + linea + " OK");
                        System.out.println(contador + " " + linea );
                        contador++;
                }
                else{
                if(contador<1000){
                reglonerror.println("00"+contador + " " + linea + " OK");
                        System.out.println(contador + " " + linea );
                        contador++;
                }
                else{
                if(contador<10000){
                reglonerror.println("0"+contador + " " + linea + " OK");
                        System.out.println(contador + " " + linea );
                        contador++;
                }
                else{
                
                reglonerror.println(contador + " " + linea + " OK");
                        System.out.println(contador + " " + linea );
                        contador++;
                
                }
                }
                }
                }
                
                
                        
                
                
                
                //AnalizaTexto(linea);
            
            }
                reglonlog.println("> "+dtf.format(LocalDateTime.now())+" ***** 03 SE termina lectura de archivo "+Archivo);
                
                reglonlog.close();
                reglonerror.close();
                escribirerror.close();
                escribirlog.close();
               
            
        } catch (FileNotFoundException ex)
        {
            System.out.println("Archivo no encontrado");
        } catch (IOException ex){
          System.out.println("Archivo no encontrado o no se pudo abrir");
        }
        
    }
    
    
}
