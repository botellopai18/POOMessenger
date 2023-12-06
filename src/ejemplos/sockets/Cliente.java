import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
    String nombre;
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 12345;
        nombre = System.console().readLine("Ingrese su nombre: ");
        // while(Servidor.esperando == false){
        //     System.out.println("Esperando a que el servidor se desocupe...");
        // }
        try {
            // Conectar al servidor
            Socket socket = new Socket(host, puerto);
            System.out.println("Conectado al servidor en " + host + ":" + puerto);

            // // Configurar canales de entrada y salida
            // BufferedReader entradaServidor = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // PrintWriter salidaServidor = new PrintWriter(socket.getOutputStream(), true);


            Socket servidor = new Socket(SERVIDOR, PUERTO);
            InputStream leer = servidor.getInputStream();
            DataInputStream flujoDatosEntrada = new DataInputStream(leer);
            System.out.println(flujoDatosEntrada.readUTF());
            DataOutputStream flujoDatosSalida = new DataOutputStream(servidor.getOutputStream());
            flujoDatosSalida.writeUTF("Gracias por aceptarme.");
            flujoDatosEntrada.close();
            flujoDatosSalida.close();
            con.close();

            // // Leer mensajes del usuario y enviar al servidor
            // BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
                
            // System.out.print(nombre + ": ");
            // String mensajeCliente = nombre + ": " + teclado.readLine();

            // // Enviar mensaje al servidor
            // salidaServidor.println(mensajeCliente);

            // // Recibir respuesta del servidor
            // String respuestaServidor = entradaServidor.readLine();
            // System.out.println("Servidor: " + respuestaServidor);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
