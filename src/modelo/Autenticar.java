package modelo;
import java.io.*;
import java.util.HashMap;

class UsuarioNoExisteException extends Exception {
    public UsuarioNoExisteException(String message) {
        super(message);
    }
}

class Usuario {
    private String username;
    private String password;

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}

public class Autenticar {

    private static final String ARCHIVO = "usuarios.txt";
    private HashMap<String, Usuario> usuarios;

    public Autenticar() {
        usuarios = new HashMap<String, Usuario>();
        crearArchivo();
        cargarUsuarios();
    }

    public void crearArchivo() { // Nos permite crear el archivo de usuarios si este no existe
        File archivo = new File(ARCHIVO);
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                System.out.println("Error al crear el archivo de usuarios");
            }
        }
    }

    public void cargarUsuarios() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(ARCHIVO));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                Usuario usuario = new Usuario(datos[0], datos[1]);
                usuarios.put(usuario.getUsername(), usuario);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }
    }

    public void agregarUsuario(String usuario, String password) {
        Usuario user = new Usuario(usuario, password);
        usuarios.put(user.getUsername(), user);
    }

    public void guardarUsuarios() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO));
            for (Usuario user : usuarios.values()) {
                bw.write(user.getUsername() + "," + user.getPassword() + "\n");
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo");
        }
    }

    public boolean autenticar(String username, String password) {
        Usuario usuario = usuarios.get(username);
        if (usuario != null) {
            return usuario.getPassword().equals(password);
        } else {
            return false;
        }
    }

    public void registrarUsuario(String username, String password)
    {
        
    }


    public static void main(String[] args) {
        Autenticar sa = new Autenticar();
        sa.agregarUsuario("cristian", "123");
        sa.guardarUsuarios();

        boolean autenticado = false;

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while (!autenticado) {
                System.out.print("Ingrese su nombre de usuario: ");
                String username = reader.readLine();
                System.out.print("Ingrese su contraseña: ");
                String password = reader.readLine();

                if (sa.autenticar(username, password)) {
                    System.out.println("Autenticación exitosa");
                    autenticado = true;
                } else {
                    System.out.println("Autenticación fallida");
                }
            }
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
