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
    public static synchronized void setClientes(int u){
        clientes+=u;
    }
    public static int getClientes(){
        return clientes;
    }

}
