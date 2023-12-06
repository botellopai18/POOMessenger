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
        directorio = null;
    }

    public Usuario(String nombre, String usuario, String contraseña, String ip, int puerto, String apellido, File directorio) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.ip = ip;
        this.puerto = puerto;
        this.apellido = apellido;
        this.directorio = directorio;
    }

    public Usuario(String nombre, String apellido, String usuario, String contraseña) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.apellido = apellido;
    }

    // Agregar "void" a los métodos getter y setter
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

    public File getDirectorio() {
        return directorio;
    }

    public String getDirectorioPath() {
        if (directorio == null) {
            return null;
        }
        return directorio.getPath();
    }

    public void setDirectorio(File directorio) {
        if(!directorio.exists() || !directorio.isDirectory()) {
            directorio.mkdir();
        }
        this.directorio = directorio;
    }

    public void setDirectorioPath(String path) {
        File directorio = new File(path);
        if(!directorio.exists() || !directorio.isDirectory()) {
            System.out.println("El directorio no existe o no es un directorio");
            directorio.mkdir();
        }
        this.directorio = directorio;
    }
}