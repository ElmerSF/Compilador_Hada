/*
UNED Informática Compiladores 3307
Estudiante Elmer Eduardo Salazar Flores 3-0426-0158
III Cuatrimestre 2022
Clase principal donde se inicia
 */
package hada;

public class HADA {
static Logs log_Aplicacion = new Logs();
static boolean continuar=false;
    public static void main(String[] args) throws InterruptedException {

        //Creamos un archivo llamado Hada_log para revisión de la herramienta
        
    //formato para el Log
        
        String Archivo = "";

        if (args.length > 0) {
            Archivo = (args[0] + "");
            
                for (TabladeSimbolos.Tipos comparaTOKENS : TabladeSimbolos.Tipos.values()){
                    if ((comparaTOKENS==TabladeSimbolos.Tipos.Nombre_Archivo)&&(Archivo.length()<20)){
                                 continuar = true;        
                        }else{
                                 continuar = false;
                        }
                    
                }
            
                        if (continuar){
                                    String directoryName = System.getProperty("user.dir");
                                    System.out.println("Estamos en la ubicación " + directoryName);
                                    log_Aplicacion.escribe_log(1, directoryName);
                                    log_Aplicacion.escribe_log(3, Archivo);

                                    System.out.println("\nEl archivo a analizar es " + Archivo);
                                    System.out.println("Se genera automáticamente un arhivo de log llamado Hada_log.txt en la ruta " + directoryName);
                                    System.out.println("Tambien se genera un archivo de errores basado en el archivo recibido\n\n" + Archivo);

                                    Read_Archivo lectura = new Read_Archivo();
                                    lectura.leerArchivo(Archivo);

                        }else{
                                    System.out.println("\n !!!!! ATENCIÓN !!!!!! \n\nEl nombre de Archivo indicado no cumple con los requisitos\n 1.No puede llevar caracter especiales #%&\n 2. No puede empezar con un número\n 3. No puede empezar o terminar con _ \n 4. No puede tener más de 20 caracteres \n\nPuede consultar el arhivo de Log Hada_log.txt");
                                    log_Aplicacion.escribe_log(2, "");
                                    log_Aplicacion.escribe_log(14, Archivo);
                                    log_Aplicacion.escribe_log(15, "");
                        }
            
        } else {
            log_Aplicacion.escribe_log(2, "");
            log_Aplicacion.escribe_log(16, "");
            log_Aplicacion.escribe_log(15, "");
            System.out.println("No se indicó nombre de archivo a analizar!");
            System.out.println("Puede consultar el arhivo de Log Hada_log.txt");
            
        }

    }

}
