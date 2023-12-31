package controlador.conexion;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import controlador.conexion.Servidor;
class Hilo extends Thread {
    private ServerSocket servidor;
    private Socket cliente;
    private DataInputStream entrada;
    private DataOutputStream salida;
    private String nombre;
    
    Hilo(String nombre){
        super(nombre);
    }
    Hilo(String nombre, ServerSocket serv, Socket cli){
        super(nombre);
        servidor = serv;
        cliente = cli;
    }
    public void run(){
        try{
            System.out.println("Cliente " + Servidor.getNumClientes() + " conectado.");
            preparar();
            comunicar();
            terminar();
        }catch(Exception e){
            System.out.println("No se pudo iniciar el hilo.");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
    }
    private void preparar(){
        try{
            Servidor.setNumClientes(1);
            OutputStream escribir = cliente.getOutputStream();
            salida = new DataOutputStream(escribir);
            entrada = new DataInputStream(cliente.getInputStream());
            nombre = entrada.readUTF();
            salida.writeUTF("Bienvenido " + nombre);
            Servidor.usernames.add(nombre);
            Servidor.actualizarUsuarios();
        }catch(Exception e){
            System.out.println("error en preparar en hilo.");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    private void comunicar(){
        try{
            while(true){
                String mensaje = entrada.readUTF();
                String[] datos = mensaje.split("--");
                Servidor.alertarMensaje(datos[0], datos[1]);
            }
        }catch(Exception e){
            System.out.println("error en comunicar en hilo.");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    private void terminar(){
        try{
            System.out.println("Cliente " + nombre + " salio.");
            Servidor.setNumClientes(-1);

            // Desconectar usuario
            Servidor.usernames.remove(nombre);
            Servidor.actualizarUsuarios();
            // Servidor.usuarioDesconectado(nombre);
            salida.close();
            entrada.close();
            cliente.close();  
        }catch(Exception e){
            System.out.println("error en terminar en hilo.");
        }
    }
    public DataOutputStream getSalida(){
        return salida;
    }
    public DataInputStream getEntrada(){
        return entrada;
    }
    public String getNombre(){
        return nombre;
    }

}