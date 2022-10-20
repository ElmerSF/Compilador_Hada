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

public class Read_Archivo {

    int cuenta_error = 0;
    String nomArchivo = "";
    File compilar;
    Fase2 fase2 = new Fase2();
    Logs log_Aplicacion = new Logs();

    public void leerArchivo(String Archivo) {
        Analisis revi = new Analisis();
        //String Bitacora = "Hada_log.txt";
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); //formato para el Log
        File errores;
        FileWriter escribirerror;
        PrintWriter reglonerror;
        String linea;
        String pendiente = "";
        int contador = 1;

        BufferedReader br;

        try {

            String Respuesta = "";

            nomArchivo = Archivo.substring(0, Archivo.indexOf('.')); //tomamos el arhivo y le eliminamos la extensión
            errores = new File(nomArchivo + "-errores.txt");
            escribirerror = new FileWriter(errores, true);
            reglonerror = new PrintWriter(escribirerror);

            br = new BufferedReader(new FileReader(Archivo));
            log_Aplicacion.escribe_log(4, Archivo);
            
            while ((linea = br.readLine()) != null) //Lectura del archivo por línea
            {
                log_Aplicacion.escribe_log(5, "\t & {linea de lectura [" + contador + "] }" );
                

                if (contador < 8) {

                    pendiente = (pendiente + " " + revi.AnalizaTexto(linea));
                    reglonerror.println("0000" + contador + " " + linea + " ");

                    contador++;
                } else {
                    if (contador == 8) {
                        Respuesta = (Respuesta + revi.AnalizaTexto(linea));
                        reglonerror.println("0000" + contador + " " + linea + " " + pendiente + Respuesta);
                        contador++;
                    } else {

                        if (contador <10) {
                            Respuesta = (Respuesta + revi.AnalizaTexto(linea));
                            reglonerror.println("0000" + contador + " " + linea + " " + Respuesta);
                            contador++;
                        } else {
                            if (contador < 100) {
                                Respuesta = revi.AnalizaTexto(linea);
                                reglonerror.println("000" + contador + " " + linea + " " + Respuesta);
                                contador++;
                            } else {
                                if (contador < 1000) {
                                    Respuesta = revi.AnalizaTexto(linea);
                                    reglonerror.println("00" + contador + " " + linea + " " + Respuesta);
                                    contador++;
                                } else {
                                    if (contador < 10000) {
                                        Respuesta = revi.AnalizaTexto(linea);
                                        reglonerror.println("0" + contador + " " + linea + " " + Respuesta);
                                        contador++;
                                    } else {
                                        Respuesta = revi.AnalizaTexto(linea);
                                        reglonerror.println(contador + " " + linea + " " + Respuesta);
                                        contador++;

                                    }
                                }
                            }
                        }
                    }
                }

            }

            cuenta_error = revi.valida_errores(nomArchivo);
            log_Aplicacion.escribe_log(6,  + cuenta_error + " Errores para detalle consulte " + nomArchivo + "-errores.txt" );
            log_Aplicacion.escribe_log(7,  Archivo);
        
            if (cuenta_error > 0) {
                
                log_Aplicacion.escribe_log(8, "");
                             
            } else {
                String Temporal = (nomArchivo + ".adb");
                compilar = new File(Temporal);
                fase2.tmp_lectura(Archivo, compilar);

                log_Aplicacion.escribe_log(9, Archivo);
                
                System.out.println("Se comienza proceso de generación archivo " + compilar.getName());

                String ruta = ("cmd /c C:\\GNAT\\2021\\bin\\gnatmake " + compilar.getName());
                
                String compilacion = (fase2.Mostrar_Proceso(ruta));
                log_Aplicacion.escribe_log(10, ""+compilacion);
               
                ruta = "cmd /c dir";
                compilacion = (fase2.Mostrar_Proceso(ruta));
                log_Aplicacion.escribe_log(11, ""+compilacion);
                
                String Temp2 = compilar.getName();
                
                Temp2 = (Temp2.substring(0, Temp2.indexOf('.'))) + ".exe";
                
                log_Aplicacion.escribe_log(12, Temp2);
               
                compilacion = (fase2.Mostrar_Proceso(Temp2));
                log_Aplicacion.escribe_log(13, compilacion);
                 }

        } catch (FileNotFoundException ex) {
            log_Aplicacion.escribe_log(0,"Error "+ex );
            System.out.println("Archivo no encontrado");
        } catch (IOException ex) {
            log_Aplicacion.escribe_log(0,"Error "+ex );
            System.out.println("Archivo no encontrado o no se pudo abrir");
        }

    }

}
