//package controlador;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.FileOutputStream;
import java.io.FileWriter;
public class Servidor {
    static final int PUERTO = 5432;
    private boolean esperando = true;
    int clientes = 0;
    
    public Servidor() {
    }
    public void iniciarServidor(){
        try{
            ServerSocket servidor = new ServerSocket(PUERTO);
            System.out.println("Iniciando servidor con puerto " + PUERTO);
            while(true){
                Socket cliente = servidor.accept();
                clientes++;
                OutputStream escribir = cliente.getOutputStream();
                DataOutputStream flujoDatosSalida = new DataOutputStream(escribir);
                DataInputStream flujoDatosEntrada = new DataInputStream(cliente.getInputStream());
                String nombre = flujoDatosEntrada.readUTF();
                flujoDatosSalida.writeUTF("Bienvenido " + nombre);
                while(true){
                    String opcion = flujoDatosEntrada.readUTF();
                    if(opcion.equals("salir")){
                        break;
                    } else if(opcion.equals("mensaje")){
                        String mensaje = flujoDatosEntrada.readUTF();
                        System.out.println("El cliente " + nombre + " dice: " + mensaje);
                    } else if(opcion.equals("archivo")){
                        recibirArchivo(flujoDatosEntrada);
                        System.out.println("Archivo recibido.");
                    } else{
                        System.out.println("Opcion no valida.");
                    }
                    
                }
                clientes--;
                flujoDatosSalida.close();
                flujoDatosEntrada.close();
                escribir.close();
                cliente.close();
            }
            System.out.println("Demasiados clientes por hoy.");
            servidor.close();
        }catch(Exception e){
            System.out.println("No se pudo iniciar el servidor");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public void recibirArchivo(DataInputStream fis){
        try{
            FileWriter writer = new FileWriter("a2.ser");
            writer.close();
            FileOutputStream fos = new FileOutputStream("a2.ser");

            // Leer el archivo del cliente y escribirlo en el servidor
            byte[] buffer = new byte[4096];
            int bytesRead = fis.read(buffer, 0, buffer.length);

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
                System.out.println("Recibiendo archivo...");
            }
            System.out.println("Archivo recibido.");
            fos.close();
        }catch(Exception e){
            System.out.println("No se pudo recibir el archivo.");
        }
        
    }
    public void detenerServidor(){
        esperando = false;
    }
    public Boolean getEsperando(){
        return esperando;
    }
    /*Método Principal MAIN */
    public static void main(String [] arg) {
        //Se crea una instancia de la clase Servidor
        Servidor s = new Servidor();
        s.iniciarServidor();
    }

}