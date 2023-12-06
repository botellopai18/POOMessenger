package controlador.conexion;
import java.util.ArrayList;
import java.io.OutputStream; 
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
//importar getInputStream
//importar getOutputStream
import controlador.conexion.Hilo;
public class Servidor  {
    private int PUERTO;
    private boolean esperando;
        private static int numClientes;
    private static ArrayList<Hilo> clientes = new ArrayList<Hilo>();

    
    public Servidor() {
        esperando = true;
        PUERTO = 5432;
        numClientes = 0;
    }
    public void iniciarServidor(){
        try{
            ServerSocket servidor = new ServerSocket(PUERTO);
            System.out.println("Iniciando servidor con puerto " + PUERTO);
            while(esperando){
                Socket cliente = servidor.accept();
                Hilo hilo = new Hilo("Cliente" + clientes, servidor, cliente);
                clientes.add(hilo);
                hilo.start();
            }
            System.out.println("Demasiados clientes por hoy.");
            servidor.close();
        }catch(Exception e){}
        
    }

    public static void alertarMensaje(String user, String mensaje) {
        System.out.println("Tam de clientes: " + clientes.size());
        for (int i = 0; i < clientes.size(); i++) {
            Hilo curr = clientes.get(i);
            System.out.println("Curr es: " + curr.getNombre());
            String msg = String.format("[mensaje] %s--%s", user, mensaje);
            try{
                curr.getSalida().writeUTF(msg);
            }catch(Exception e){
                System.out.println("Error al enviar mensaje a cliente.");
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            
            // curr.salida.writeUTF("[disconected]-");
            // curr.mensajeRecibido(user, mensaje)
        }
    }

    public static synchronized void setNumClientes(int u){
        numClientes+=u;
    }
    public static synchronized int getNumClientes(){
        return numClientes;
    }
    public static void main(String[] args) {
        Servidor servidor = new Servidor();
        servidor.iniciarServidor();
    }
}