package controlador.conexion;
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
    private static int clientes;
    
    public Servidor() {
        esperando = true;
        PUERTO = 5432;
        clientes = 0;
    }
    public void iniciarServidor(){
        try{
            ServerSocket servidor = new ServerSocket(PUERTO);
            System.out.println("Iniciando servidor con puerto " + PUERTO);
            while(esperando){
                Socket cliente = servidor.accept();
                Hilo hilo = new Hilo("Cliente" + clientes, servidor, cliente);
                hilo.start();
            }
            System.out.println("Demasiados clientes por hoy.");
            servidor.close();
        }catch(Exception e){}
        
    }
    public static synchronized void setClientes(int u){
        clientes+=u;
    }
    public static synchronized int getClientes(){
        return clientes;
    }
    public static void main(String[] args) {
        Servidor servidor = new Servidor();
        servidor.iniciarServidor();
    }
}