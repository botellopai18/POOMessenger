package ejemplos.sockets;
import java.io.InputStream;
import java.io.DataInputStream; 
import java.io.DataOutputStream;
import java.net.Socket;
public class SocketCliente {
    String SERVIDOR = "localhost";
    int PUERTO = 5432;
    public SocketCliente(){};
    public SocketCliente(String server, int port) {
        SERVIDOR = server;
        PUERTO = port;
        try{
            Socket con = new Socket(SERVIDOR, PUERTO);
            InputStream leer = con.getInputStream();
            DataInputStream flujoDatosEntrada = new DataInputStream(leer);
            System.out.println(flujoDatosEntrada.readUTF());
            DataOutputStream flujoDatosSalida = new DataOutputStream(con.getOutputStream());
            flujoDatosSalida.writeUTF("Gracias por aceptarme.");
            flujoDatosEntrada.close();
            flujoDatosSalida.close();
            con.close();
        } catch (Exception e) {
            System.out.println("No se pudo conectar con el servidor.");
            System.out.println(e.getMessage());

        }

    }
    public static void main(String [] arg) {
        System.out.println("Iniciando...");
        System.out.println("IP Address: ");
        String ip = System.console().readLine();
        System.out.println("Puerto: ");
        int port = Integer.parseInt(System.console().readLine());
        new SocketCliente(ip, port);
    }
}