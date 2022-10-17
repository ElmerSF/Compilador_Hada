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


public class Read_Archivo {
    
        int cuenta_error=0;
       String nomArchivo =""; 
       File compilar;
        Fase2 fase2 = new Fase2();
    public void leerArchivo(String Archivo) 
    {
        Analisis revi = new Analisis();
        String Bitacora ="Hada_log.txt";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); //formato para el Log
        File log, errores;
        FileWriter escribirlog, escribirerror;
        PrintWriter reglonlog, reglonerror;
        String linea;
        String pendiente ="";
        int contador=1;
     
        
        BufferedReader br;
        
        try {
        
        String Respuesta ="";
        log=new File(Bitacora);
        escribirlog = new FileWriter(log, true);
        reglonlog =new PrintWriter(escribirlog);
        
       
        nomArchivo = Archivo.substring(0, Archivo.indexOf('.')); //tomamos el arhivo y le eliminamos la extensión
        errores = new File(nomArchivo+"-errores.txt");
       // String prueba1 =nomArchivo;
        //System.out.println(prueba1);
       // String prueba2 = Archivo.substring(0, Archivo.indexOf('/'));
      // System.out.println("hola amigos "+prueba2);
        escribirerror = new FileWriter(errores, true);
        reglonerror= new PrintWriter(escribirerror);
        
            
            br = new BufferedReader(new FileReader(Archivo));
            reglonlog.println("> "+dtf.format(LocalDateTime.now())+" ***** 02 INFORMACIÓN se comienza lectura de archivo "+Archivo);
            
           // Analisis revi = new Analisis();
            
            
            while ((linea= br.readLine())!=null) //Lectura del archivo por línea
            {
            reglonlog.println("\t & {linea de lectura ["+contador+"] }");   
                      
                if (contador<8)
                {
                    
                    pendiente =(pendiente + " "+ revi.AnalizaTexto(linea));
                reglonerror.println("0000"+contador + " " + linea + " ");
                
                contador++;
                }
                else{
                 if(contador==8)   
                 {
                    Respuesta =(Respuesta +revi.AnalizaTexto(linea)); 
                    reglonerror.println("0000"+contador + " " + linea + " "+ pendiente+ Respuesta); 
                    contador++;
                 }else{
                     
                 
                if (contador<10)
                {
                    Respuesta =(Respuesta +revi.AnalizaTexto(linea)); 
                reglonerror.println("0000"+contador + " " + linea + " "+ Respuesta );
                       // System.out.println(contador + " " + linea + " "+Respuesta );
                
                        contador++;
                }
                else{
                if(contador<100){
                   Respuesta =revi.AnalizaTexto(linea);
                reglonerror.println("000"+contador + " " + linea + " "+Respuesta);
                        //System.out.println(contador + " " + linea + " "+Respuesta);
                        contador++;
                }
                else{
                if(contador<1000){
                  Respuesta =revi.AnalizaTexto(linea);
                reglonerror.println("00"+contador + " " + linea + " "+Respuesta );
                        //System.out.println(contador + " " + linea + " "+Respuesta);
                        contador++;
                }
                else{
                if(contador<10000){
                  Respuesta =revi.AnalizaTexto(linea);
                reglonerror.println("0"+contador + " " + linea + " "+Respuesta );
                        //System.out.println(contador + " " + linea + " "+Respuesta );
                        contador++;
                }
                else{
                Respuesta =revi.AnalizaTexto(linea);
               reglonerror.println(contador + " " + linea + " "+Respuesta );
                        //System.out.println(contador + " " + linea + " "+Respuesta );
                        contador++;
                
                }
                }
                }
                }
                }
                }
                        
                
            }
            
           cuenta_error = revi.valida_errores(nomArchivo);
            reglonlog.println("> "+dtf.format(LocalDateTime.now())+" >!!!AVISO Se encontraron "+cuenta_error+ " Errores para detalle consulte "+nomArchivo+"-errores.txt");    
            reglonlog.println("\n> "+dtf.format(LocalDateTime.now())+" ***** 03 INFORMACIÓN SE termina lectura de archivo "+Archivo);
            reglonerror.close();
            escribirerror.close();
            
            if (cuenta_error>0)
            {
            reglonlog.println("> "+dtf.format(LocalDateTime.now())+" ***** 04 AVISO Por los errores no se pasa a segunda fase de Compilación");
            reglonlog.println("\n\n *************************FIN DE LOG ********************************** ");
            reglonlog.close();
            escribirlog.close();
            }else
            {
                String Temporal =(nomArchivo+".adb");
                compilar = new File(Temporal);
                fase2.tmp_lectura(Archivo, compilar);
                
                
            reglonlog.println("> "+dtf.format(LocalDateTime.now())+" ***** 04 INFORMACIÓN se comienza generación de archivo para segunda fase de compilar Archivo nombre: "+nomArchivo);    
            System.out.println("Se comienza proceso de generación archivo "+ compilar.getName()); 
                      
            
            String ruta=("cmd /c C:\\GNAT\\2021\\bin\\gnatmake "+compilar.getName());
            String compilacion =(fase2.Mostrar_Proceso(ruta));
            reglonlog.println("> "+dtf.format(LocalDateTime.now())+compilacion + " Compilación de archivo");
            ruta = "cmd /c dir";
            compilacion=(fase2.Mostrar_Proceso(ruta));
            reglonlog.println("> "+dtf.format(LocalDateTime.now())+compilacion+ " Ejecución comando dir");
           
            String Temp2 =compilar.getName();
            Temp2 = (Temp2.substring(0, Temp2.indexOf('.')))+".exe";
            reglonlog.println("> "+dtf.format(LocalDateTime.now())+ " Ejecución programa"+ Temp2);
            compilacion=(fase2.Mostrar_Proceso(Temp2));
            reglonlog.println("> "+dtf.format(LocalDateTime.now())+compilacion+ " Se ejecuto el programa");
            
             reglonlog.println("\n\n *************************FIN DE LOG ********************************** ");
            
            reglonlog.close();
            escribirlog.close();
            }
                 
            
                
               
            
        } catch (FileNotFoundException ex)
        {
            System.out.println("Archivo no encontrado");
        } catch (IOException ex){
          System.out.println("Archivo no encontrado o no se pudo abrir");
        }
        
    }

}
