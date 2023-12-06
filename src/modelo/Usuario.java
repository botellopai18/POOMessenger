package modelo;

import java.io.File;
import java.io.Serializable;

public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private String usuario;
    private String contraseña;
    private String ip;
    private int puerto;
    private String apellido;
    private File directorio;

    public Usuario() {
    }

    public Usuario(String username, String password) {
        this.usuario = username;
        this.contraseña = password;
    }

    public Usuario(String nombre, String apellido, String usuario, String contraseña, String ip, int puerto,
            File directorio) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.ip = ip;
        this.puerto = puerto;
        this.apellido = apellido;
        this.directorio = directorio;
    }

    public Usuario(String nombre, String apellido, String usuario, String contraseña, String ip) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.ip = ip;
        this.apellido = apellido;
    }

    public Usuario(String nombre, String apellido, String usuario, String contraseña) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}