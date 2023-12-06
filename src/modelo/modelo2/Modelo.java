package modelo.modelo2;
import java.io.*;
import java.util.ArrayList;
import modelo.modelo2.Usuario;
public class Modelo {
    private File chat;
    private File usuarios;
    private File conectados;

    public Modelo() {
        chat = new File("modelo/modelo2/datos/chat.txt");
        usuarios = new File("modelo/modelo2/datos/usuarios.ser");
        conectados = new File("modelo/modelo2/datos/conectados.txt");
    }
    // ya
    public Boolean registrarUsuario(Usuario usuario) {
        ArrayList<Usuario> listaUsuarios = obtenerListaUsuarios();
        for (Usuario u : listaUsuarios) {
            if (u.getUsuario().equals(usuario.getUsuario())) {
                return false; // El usuario ya está registrado
            }
        }
        listaUsuarios.add(usuario);
        guardarListaUsuarios(listaUsuarios);
        return true; // Registro exitoso
    }
    // ya
    public Usuario obtenerUsuario(String usuario) {
        ArrayList<Usuario> listaUsuarios = obtenerListaUsuarios();
        for (Usuario u : listaUsuarios) {
            if (u.getUsuario().equals(usuario)) {
                return u; // Usuario encontrado
            }
        }
        return null; // Usuario no encontrado
    }
    // ya
    public Boolean autenticarUsuario(String usuario, String contraseña) {
        Usuario user = obtenerUsuario(usuario);
        return user != null && user.getContraseña().equals(contraseña);
    }
    // ya
    public void guardarMensaje(String mensaje) {
        try (FileWriter writer = new FileWriter(chat, true);
             BufferedWriter bw = new BufferedWriter(writer)) {
            bw.write(mensaje + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // ya
    public ArrayList<String> obtenerMensajes() {
        ArrayList<String> mensajes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(chat))) {
            String line;
            while ((line = br.readLine()) != null) {
                mensajes.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mensajes;
    }
    // ya
    public void conectarUsuario(String usuario) {
        try (FileWriter writer = new FileWriter(conectados, true);
             BufferedWriter bw = new BufferedWriter(writer)) {
            bw.write(usuario + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   // ya
    public void desconectarUsuario(String usuario) {
        ArrayList<String> usuariosConectados = obtenerUsuariosConectados();
        usuariosConectados.remove(usuario);
        guardarListaUsuariosConectados(usuariosConectados);
    }
// ya
    public ArrayList<String> obtenerUsuariosConectados() {
        return obtenerListaUsuariosConectados();
    }

    public void guardarArchivo(String usuario, File archivo) {
        File directorioUsuario = new File(usuario);
        if (!directorioUsuario.exists()) {
            directorioUsuario.mkdir();
        }

        File destino = new File(directorioUsuario, archivo.getName());

        try (FileInputStream fis = new FileInputStream(archivo);
             FileOutputStream fos = new FileOutputStream(destino)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // ya
    @SuppressWarnings("unchecked")
    private ArrayList<Usuario> obtenerListaUsuarios() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(usuarios))) {
            return (ArrayList<Usuario>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
    // ya
    private void guardarListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(usuarios))) {
            oos.writeObject(listaUsuarios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // ya
    private ArrayList<String> obtenerListaUsuariosConectados() {
        ArrayList<String> usuariosConectados = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(conectados))) {
            String line;
            while ((line = br.readLine()) != null) {
                usuariosConectados.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuariosConectados;
    }
    // ya
    private void guardarListaUsuariosConectados(ArrayList<String> usuariosConectados) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(conectados))) {
            for (String usuario : usuariosConectados) {
                writer.println(usuario);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
