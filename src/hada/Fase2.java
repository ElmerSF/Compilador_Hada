/*
 UNED Informática Compiladores 3307
Estudiante Elmer Eduardo Salazar Flores 3-0426-0158
III Cuatrimestre 2022
En esta clase se realiza la segunda fase de compilación
 */
package hada;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author elmer
 */
public class Fase2 {
    public String Mostrar_Proceso(String ruta) 
    {
        
        String mensaje ="";
        try 
        {
            
           // String directoryName = System.getProperty("user.dir");
            System.out.println(" Ejecutando " +ruta);
            
            Process process = Runtime.getRuntime().exec(ruta);
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            
            
            String resultOfExecution = null;
            while((resultOfExecution = br.readLine()) != null)
            {
                System.out.println(resultOfExecution);
                    
            }     
            mensaje = ">OK se ejecuto correctamente";
            
            try {
                process.waitFor();
            } catch (InterruptedException ex) {
                Logger.getLogger(Fase2.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
            }
             catch (IOException e) 
                     {
            e.printStackTrace();
            mensaje = "Error en la ejecución";
        }
        return mensaje;
        }    
     public void tmp_lectura(String Archivo, File tmp) throws FileNotFoundException{
        
         FileWriter escribir;
        PrintWriter reglon;
        String linea;
        BufferedReader br;
         try {
        escribir = new FileWriter(tmp, true);
        reglon= new PrintWriter(escribir);
        br = new BufferedReader(new FileReader(Archivo));
        while ((linea= br.readLine())!=null)
        {
            if (linea.isEmpty()){
                
            }else{
                reglon.println(linea);
            }
            
            
        }
        reglon.close();
        escribir.close();
         } catch (Exception e) {
         }
        
     }
    }
    


