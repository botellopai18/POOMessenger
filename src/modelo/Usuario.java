package modelo;
 
import java.io.File;
import java.io.Serializable;
public class Usuario implements Serializable{
    private static final long serialVersionUID = 1L;
    private String nombre;
    private String usuario;
    private String contraseña;
    private String ip;
    private int puerto;
    private String apellido;
    private File directorio;

    public Usuario(){
    }
    
    public Usuario(String nombre, String apellido, String usuario, String contraseña, String ip, int puerto, File directorio){
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.ip = ip;
        this.puerto = puerto;
        this.apellido = apellido;
        this.directorio = directorio;
    }
     public Usuario(String nombre, String apellido, String usuario, String contraseña, String ip){
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.ip = ip;
        this.apellido = apellido;
    }
    public Usuario(String nombre, String apellido, String usuario, String contraseña){
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.apellido = apellido;
    }
    public getNombre(){
        return nombre;
    }
    public setNombre(String nombre){
        this.nombre = nombre;
    }
    public getUsuario(){
        return usuario;
    }
    public setUsuario(String usuario){
        this.usuario = usuario;
    }
    public getContraseña(){
        return contraseña;
    }
    public setContraseña(String contraseña){
        this.contraseña = contraseña;
    }
    public getIp(){
        return ip;
    }
    public setIp(String ip){
        this.ip = ip;
    }
    public getPuerto(){
        return puerto;
    }
    public setPuerto(int puerto){
        this.puerto = puerto;
    }
    public getApellido(){
        return apellido;
    }
    public setApellido(String apellido){
        this.apellido = apellido;
    }
    public getDirectorio(){
        return directorio;
    }
    public getDirectorioPath(){
        return directorio.getPath();
    }
    public setDirectorio(File directorio){
        this.directorio = directorio;
    }
    public setDirectorioPath(String path){
        this.directorio = new File(directorio);
    }
}