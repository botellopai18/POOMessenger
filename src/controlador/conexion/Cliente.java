package controlador.conexion;
 
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;
import java.io.IOException;

public class Cliente {
    private String IP;
    private int PUERTO;
    private String nombre;
    private DataInputStream entrada;
    private DataOutputStream salida;
    private Socket servidor;
    
    public Cliente(){
        nombre = "";
        IP = "localhost";
        PUERTO = 5432;
    };
    public Cliente(String ip, int port) {
        IP = ip;
        PUERTO = port;
    }
    public void iniciar(){
        System.out.println("Iniciando...");
        nombre = System.console().readLine("Nombre: ");
        //pedirDatos();
        conectar(IP, PUERTO);
        comunicar();
        terminar();
    }
    private void pedirDatos(){
        System.out.println("IP Address: ");
        IP = System.console().readLine();
        System.out.println("Puerto: ");
        PUERTO = Integer.parseInt(System.console().readLine());
    }
    public Boolean conectar(String IP, int puerto){
        try{
            servidor = new Socket(IP, puerto);
            InputStream leer = servidor.getInputStream();
            entrada = new DataInputStream(leer);
            salida = new DataOutputStream(servidor.getOutputStream());
            salida.writeUTF(nombre);
            System.out.println(entrada.readUTF());
            return true;
        } catch (Exception e) {
            System.out.println("No se pudo conectar al servidor.");
            System.out.println(e.getMessage());
            return false;
        }
    }
    public void terminar(){
        try{
            entrada.close();
            salida.close();
            servidor.close();
        } catch (Exception e) {
            System.out.println("No se pudo terminar la conexion.");
            System.out.println(e.getMessage());
        }
    }
    public void comunicar(){
        try{
            Boolean activo = true;
            while(activo){
                escuchar(); 
                
                // while (entrada.available() == 0){
                //     System.out.println("Escribir mensaje: ");
                //     if(System.console() != null){
                //     String mensaje = System.console().readLine();
                //     salida.writeUTF(mensaje);
                //     System.out.println("Mensaje enviado.");
                //     if(mensaje.equals("salir")){
                //         activo = false;
                //         break;
                //     }
                //     }

                //     try{
                //         Thread.sleep(1000);
                //     } catch(Exception e){
                //         System.out.println("Error en sleep.");
                //         System.out.println(e.getMessage());
                //     }
                // }
                // if(entrada.available() > 0){
                //     String mensaje = entrada.readUTF();
                //     System.out.println("El servidor dice: " + mensaje);
                // }
            }
        } catch (Exception e) {
            System.out.println("No se pudo conectar al servidor.");
            System.out.println(e.getMessage());
        }
    }

    private void escuchar(){
        try{
            while(!hablar()){
                if(entrada.available() != 0){
                    String mensaje = entrada.readUTF();
                    System.out.println("El servidor dice: " + mensaje);
                }
            }
        } catch (Exception e) {
            System.out.println("No jalo escuchar hilo");
            //System.out.println(e.getMessage());
        }
    }
    private Boolean hablar(){
        try{
            return false;
        } catch (Exception e) {
            System.out.println("No jalo hablar hilo");
            //System.out.println(e.getMessage());
            return false;
        }
    }
    public void enviarArchivo(DataOutputStream flujoDatosSalida){
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
    
    public void setNombre(String n){
        nombre = n;
    }
    public String getNombre(){
        return nombre;
    }
    public void setIP(String ip){
        IP = ip;
    }
    public String getIP(){
        return IP;
    }
    public void setPuerto(int puerto){
        PUERTO = puerto;
    }
    public int getPuerto(){
        return PUERTO;
    }
    
    public static void main(String [] arg) {
        //Se crea una instancia de la clase Servidor
        Cliente c = new Cliente();
        c.iniciar();
    }
}