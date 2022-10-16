/*
 UNED Informática Compiladores 3307
Estudiante Elmer Eduardo Salazar Flores 3-0426-0158
III Cuatrimestre 2022
En esta clase se realiza la segunda fase de compilación
 */
package hada;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



/**
 *
 * @author elmer
 */
public class Fase2 {
    public void Mostrar_Proceso(String nombArchivo) throws IOException, InterruptedException
    {
        String ruta=("cmd /c C:\\GNAT\\2021\\bin\\gnatmake "+nombArchivo);
        
        try 
        {
            
           // String directoryName = System.getProperty("user.dir");
            System.out.println("Ejecutando" +ruta);
            
            Process process = Runtime.getRuntime().exec(ruta);
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            
            
            String resultOfExecution = null;
            while((resultOfExecution = br.readLine()) != null)
            {
                System.out.println(resultOfExecution);
                    
            }     
            Mostrar_dir("cmd /c dir");
                    
            }
             catch (IOException e) 
                     {
            e.printStackTrace();
        }
        }    
     public void Mostrar_dir(String nombArchivo) throws IOException, InterruptedException
     {
         try 
        {
            
           // String directoryName = System.getProperty("user.dir");
            System.out.println("Ejecutando" +nombArchivo);
            
            Process process = Runtime.getRuntime().exec(nombArchivo);
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            
            
            String resultOfExecution = null;
            while((resultOfExecution = br.readLine()) != null)
            {
                System.out.println(resultOfExecution);
                    
            }     
                    
            }
             catch (IOException e) 
                     {
            e.printStackTrace();
        }
     }
    }
    


