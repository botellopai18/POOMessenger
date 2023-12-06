import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static Boolean esperando = true;
    public static void main(String[] args) {
        int puerto = 12345;
        esperando = true;
        try {
            ServerSocket serverSocket = new ServerSocket(puerto);
            System.out.println("Servidor esperando conexiones en el puerto " + puerto);
            
            while(esperando){
                Socket clienteSocket = serverSocket.accept();
                //esperando = false;
                System.out.println("Cliente conectado desde " + clienteSocket.getInetAddress());

                // Configurar canales de entrada y salida
                BufferedReader entradaCliente = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
                PrintWriter salidaCliente = new PrintWriter(clienteSocket.getOutputStream(), true);

                // Loop para recibir y enviar mensajes
                BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
                    
                // Recibir mensaje del cliente
                String mensajeCliente = entradaCliente.readLine();
                System.out.println("Cliente " + mensajeCliente);

                // Enviar respuesta al cliente
                System.out.print("Servidor: ");
                String respuesta = teclado.readLine();
                salidaCliente.println(respuesta);
    
                salidaCliente.close();
                entradaCliente.close();
                teclado.close();
                clienteSocket.close();
                //esperando = true;
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
