package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import modelo.Usuario;
import java.util.ArrayList;

public class Modelo {
    private File chat;
    private File usuarios;
    private File conectados;
    ArrayList<Usuario> Usuarios = new ArrayList<>();
    BaseDatos bd;

    public Modelo() {
        chat = new File("datos/chat.txt");
        usuarios = new File("datos/usuarios.ser");
        conectados = new File("datos/conectados.txt");
    }

    /*
     * public Boolean registrarUsuario(Usuario usuario) {
     * // registrar usuario en el archivo serializable usuarios
     * // return true si se registró, false si ya estaba registrado
     * 
     * }
     */

    public Usuario buscarUsuario(String u) {
        System.out.println("Buscando usuario: " + u);
        for (Usuario usuario : bd.datos) {
            if (u.equals(usuario.getUsuario())) {
                return usuario;
            }
        }
        return null;
    }

    public boolean agregarUsuario(Usuario usuario) {

        if (bd.datos == null) {
            bd.datos = new ArrayList<>();
        }

        if (buscarUsuario(usuario.getUsuario()) == null) {
            bd.datos.add(usuario);
            guardarDatos();
            bd.cargarDatos();
            return true;
        } else {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    public void cargarDatos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("datos.txt"))) {
            bd.datos = (ArrayList<Usuario>) ois.readObject();
        } catch (Exception e) {
            // Si ocurre un error al cargar, simplemente inicializa la lista
            bd.datos = new ArrayList<>();
        }
    }

    public void guardarDatos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("datos.txt"))) {
            oos.writeObject(bd.datos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * public Usuario obtenerUsuario(String usuario) {
     * // obtener usuario del archivo serializable usuarios
     * // return user si existe, null si no
     * }
     * 
     * public Boolean autenticarUsuario(String usuario, String contraseña) {
     * // autenticar usuario en el archivo serializable usuarios
     * // return true si se autenticó, false si no
     * Usuario user = obtenerUsuario(usuario);
     * if (user != null) {
     * if (user.getContraseña().equals(contraseña)) {
     * return true;
     * }
     * }
     * return false;
     * }
     */

    /*
     * public void guardarMensaje(String mensaje) {
     * // guardar mensaje en el archivo chat
     * // recuerda que cada mensaje tiene el formato: username--mensaje
     * }
     * 
     * public ArrayList<String> obtenerMensajes() {
     * // obtener mensajes del archivo chat
     * // recuerda que cada mensaje tiene el formato: username--mensaje
     * // return mensajes
     * }
     * 
     * public void conectarUsuario(String usuario) {
     * // registrar usuario en el archivo conectados
     * // escribir en el archivo conectados el usuario
     * }
     * 
     * public void desconectarUsuario(String usuario) {
     * // eliminar usuario del archivo conectados
     * // eliminar la linea del archivo conectados que contenga el usuario
     * }
     * 
     * public ArrayList<String> obtenerUsuariosConectados() {
     * // obtener usuarios del archivo conectados
     * // return ArrayList<String> con los usuarios conectados
     * }
     * 
     * public ArrayList<Usuario> obtenerUsuariosConectados() {
     * // obtener usuarios del archivo conectados
     * // return ArrayList<String> con los usuarios conectados
     * ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
     * // leer del serializable
     * usuarios.add(new Usuario("isaac", "botello", "botellopai", "1234",
     * "127.0.0.1"));
     * return usuarios;
     * }
     * 
     * public void guardarArchivo(String usuario, File archivo) {
     * // guardar archivo en el directorio del usuario
     * }
     */

    public File getChat() {
        return chat;
    }

    public String getChatPath() {
        return chat.getPath();
    }

    public void setChat(File chat) {
        this.chat = chat;
    }

    public void setChatPath(String path) {
        this.chat = new File(path);
    }

    public File getUsuarios() {
        return usuarios;
    }

    public String getUsuariosPath() {
        return usuarios.getPath();
    }

    public void setUsuarios(File usuarios) {
        this.usuarios = usuarios;
    }

    public void setUsuariosPath(String path) {
        this.usuarios = new File(path);
    }

    public File getConectados() {
        return conectados;
    }

    public String getConectadosPath() {
        return conectados.getPath();
    }

    public void setConectadosPath(String path) {
        this.conectados = new File(path);
    }

    public void setConectados(File conectados) {
        this.conectados = conectados;
    }

}