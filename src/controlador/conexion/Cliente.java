package controlador.conexion;
 
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.io.IOException;
import vista.chat.Chat;
import vista.menu.Principal;

public class Cliente extends Thread {
    private String IP;
    private int PUERTO;
    private String nombre;
    private DataInputStream entrada;
    private DataOutputStream salida;
    private Socket servidor;
    private String msg = null;
    private Principal parentPrincipal;
    
    public Cliente(Principal parent){
        super(parent.chat.usuarioAutenticado);
        nombre = parent.chat.usuarioAutenticado;
        IP = "localhost";
        PUERTO = 5430;
        this.parentPrincipal = parent;
        start();
    };
    public Cliente(String ip, int port) {
        IP = ip;
        PUERTO = port;
    }
    public void run (){
        System.out.println("Iniciando...");
        conectar(IP, PUERTO);

        try {
            Boolean activo = true;
            while(activo){
                if (entrada.available() > 0) {
                    String incoming = entrada.readUTF();
                    System.out.println("El servidor dice: " + incoming);
                    String tipo = incoming.split("sep")[0];
                    if (tipo.equals("[mensaje]")) {
                        String datosUsuario = incoming.split("sep")[1];
                        String[] mensajeSeparado = datosUsuario.split("--");
                        parentPrincipal.chat.mensajeRecibido(mensajeSeparado[1], mensajeSeparado[0]);

                    } else {
                        String usuariosConectados = incoming.split("sep")[1];
                        ArrayList<String> nuevosEnLinea = new ArrayList<String>();
                        String[] arrUsuarios = usuariosConectados.split("DEL");

                        for (int i = 0; i < arrUsuarios.length; i++) {
                            if (arrUsuarios[i].strip().equals("")) continue;
                            System.out.println(arrUsuarios[i]);
                            nuevosEnLinea.add(arrUsuarios[i]);
                        }
                        parentPrincipal.setUsuariosConectados(nuevosEnLinea);
                    }
                }

                if (msg != null) {
                    salida.writeUTF(msg);
                    System.out.println("Mensaje enviado");
                    msg = null;
                }

            }
        } catch (Exception e) {
            System.out.println("No se pudo conectar al servidor.");
            System.out.println(e.getMessage());
        }
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

    public void guardarEleccionCarpeta(File carpeta) {
        // TODO: Esta funcion se llama cuando el usuario cambia de carpeta, acuerdense que cada instancia de Cliente ya tiene acceso al username en la variable nombre
        System.out.printf("El usuario %s quiere cambiar a la carpeta %s%n", nombre, carpeta.getAbsolutePath());
        // Aqui deberian mandar a llamar un metodo tipo Servidor.guardarCarpeta(nombre, carpeta)
    }

    public void enviarArchivoUsuarios(File archivo, ArrayList<String> usernames) {
        // TODO: Podrian llamar a un metodo de la clase Servidor, el ArrayList usernames tiene el nombre de todos los usuarios a los que les tiene que llegar
        System.out.println("Enviando " + archivo.getAbsolutePath() + " a: ");
        for (int i = 0; i < usernames.size(); i++) {
          System.out.println(usernames.get(i));
        }
    }

    public void setMsg(String nuevoMsg) {
        msg = nuevoMsg;
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
        // Cliente c = new Cliente("usuario");
        // c.start();
    }
}