/*
UNED Informática Compiladores 3307
Estudiante Elmer Eduardo Salazar Flores 3-0426-0158
III Cuatrimestre 2022
Clase principal donde se inicia
 */
package hada;

public class HADA {
static Logs log_Aplicacion = new Logs();
    public static void main(String[] args) throws InterruptedException {

        //Creamos un archivo llamado Hada_log para revisión de la herramienta
        
    //formato para el Log
        
        String Archivo = "";

        if (args.length > 0) {
            Archivo = (args[0] + "");
            
            String directoryName = System.getProperty("user.dir");
            System.out.println("Estamos en la ubicación " + directoryName);
            log_Aplicacion.escribe_log(1, directoryName);
            log_Aplicacion.escribe_log(3, Archivo);
            
            System.out.println("\nEl archivo a analizar es " + Archivo);
            System.out.println("Se genera automáticamente un arhivo de log llamado Hada_log.txt en la ruta " + directoryName);
            System.out.println("Tambien se genera un archivo de errores basado en el archivo recibido\n\n" + Archivo);
            
            Read_Archivo lectura = new Read_Archivo();
            lectura.leerArchivo(Archivo);
            
        } else {
            log_Aplicacion.escribe_log(2, "");
            System.out.println("No se indicó nombre de archivo a analizar!");
            System.out.println("Puede consultar el arhivo de Log Hada_log.txt");
            
        }

    }

}
