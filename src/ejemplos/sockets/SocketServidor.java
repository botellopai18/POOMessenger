package ejemplos.sockets;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.net.ServerSocket; 
import java.net.Socket;

public class SocketServidor {
    static final int PUERTO = 5432;
    
    public SocketServidor() {
        try {
            ServerSocket servidor = new ServerSocket(PUERTO);
            System.out.println("Esperando peticiones por el puerto " + PUERTO);
            for (int clientes = 0; clientes < 5; clientes++) {
                Socket servicio = servidor.accept();
                System.out.println("Se aceptO la conexion del cliente " + clientes);
                OutputStream escribir = servicio.getOutputStream();
                DataOutputStream flujoDatosSalida = new DataOutputStream(escribir);
                flujoDatosSalida.writeUTF("Bienvenido cliente " + clientes);
                DataInputStream flujoDatosEntrada = new DataInputStream(servicio.getInputStream());
                System.out.println("El cliente " + clientes + " dice: " + flujoDatosEntrada.readUTF());
                flujoDatosSalida.close();
                flujoDatosEntrada.close();
                servicio.close();
            }
            System.out.println("Demasiados clientes por hoy.");
        } catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    /*Método Principal MAIN */
    public static void main(String [] arg) {
        //Se crea una instancia de la clase Servidor
        new SocketServidor();
    }

}