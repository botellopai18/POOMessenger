//package controlador;

import java.io.InputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;
public class Cliente {
    String SERVIDOR = "localhost";
    int PUERTO = 5432;
    String nombre;
    String mensaje;
    File archivo;
    DataOutputStream flujoDatosSalida;
    public Cliente(){};
    public Cliente(String server, int port) {
        SERVIDOR = server;
        PUERTO = port;
    }
    public void iniciar(){
        System.out.println("Iniciando...");
        // System.out.println("IP Address: ");
        // SERVIDOR = System.console().readLine();
        // System.out.println("Puerto: ");
        // PORT = Integer.parseInt(System.console().readLine());
        System.out.println("Nombre: ");
        nombre = System.console().readLine();
        conectarServidor(SERVIDOR, PUERTO);
    }
    public void conectarServidor(String IP, int puerto){
        try{
            Socket con = new Socket(IP, puerto);
            InputStream leer = con.getInputStream();
            DataInputStream flujoDatosEntrada = new DataInputStream(leer);
            flujoDatosSalida = new DataOutputStream(con.getOutputStream());
            flujoDatosSalida.writeUTF(nombre);
            System.out.println(flujoDatosEntrada.readUTF());
            while(true){
                if(menu() == false){
                    break;
                }
            }
            

            flujoDatosEntrada.close();
            flujoDatosSalida.close();
            leer.close();
            con.close();
        } catch (Exception e) {
            System.out.println("No se pudo enviar mensaje.");
            System.out.println(e.getMessage());

        }
    }
    public Boolean menu(){
        System.out.println("1. Enviar mensaje");
        System.out.println("2. Enviar archivo");
        System.out.println("3. Salir");
        System.out.print("Opcion: ");
        int opcion = Integer.parseInt(System.console().readLine());
        switch(opcion){
            case 1:
                enviarMensaje("mensaje");
                enviarMensaje();
                return true;
            case 2:
                enviarMensaje("archivo");
                enviarArchivo();
                return true;
            case 3:
                enviarMensaje("salir");
                return false;
            default:
                
                System.out.println("Opcion invalida.");
                return true;
        }

    }
    public void enviarArchivo(){
        try{
            String path = "a1.txt";
            FileInputStream fis = new FileInputStream(path);

            // Enviar el archivo al servidor
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                flujoDatosSalida.write(buffer, 0, bytesRead);
            }
            fis.close();
            System.out.println("Archivo enviado.");
        }catch(Exception e){
            System.out.println("No se pudo enviar el archivo.");
            //System.out.println(e.getMessage());
        }
    }
    public void enviarMensaje(){
        try{
            System.out.print("Mensaje: ");
            mensaje = System.console().readLine();
            flujoDatosSalida.writeUTF(mensaje);
        }catch(Exception e){
            System.out.println("No se pudo enviar mensaje.");
            //System.out.println(e.getMessage());
        }
    }
    public void enviarMensaje(String m){
        try{
            flujoDatosSalida.writeUTF(m);
        }catch(Exception e){
            System.out.println("No se pudo enviar mensaje.");
            //System.out.println(e.getMessage());
        }
    }
    
    public static void main(String [] arg) {
        //Se crea una instancia de la clase Servidor
        Cliente c = new Cliente();
        c.iniciar();
    }
}
