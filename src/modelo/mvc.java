package modelo;
import java.util.*;
import java.io.*;

class Modelo {
	BaseDatos bd;

	Modelo() {
		bd = new BaseDatos();
		bd.cargarDatos();
	}

	public Usuario buscarUsuario(String u) {
		for (int i = 0; i < bd.datos.size(); i++) {
			if (u.equals(bd.datos.get(i).getUsername())) {
				return bd.datos.get(i);
			}
		}
		return null;
	}

	public void agregarUsuario(Usuario usuario) {
		if (buscarUsuario(usuario.getUsername()) == null) {
			bd.datos.add(usuario);
			guardarDatos();
			bd.cargarDatos();
		} else {
			System.out.println("¡Error! El nombre de usuario ya está registrado.");
		}
	}

	private void guardarDatos() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("datos.ser"))) {
			oos.writeObject(bd.datos);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

class BaseDatos {
	ArrayList<Usuario> datos;

	BaseDatos() {
		datos = new ArrayList<Usuario>();
		cargarDatos();
	}

	@SuppressWarnings("unchecked")
	public void cargarDatos() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("datos.ser"))) {
			datos = (ArrayList<Usuario>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			// Si ocurre un error al cargar, simplemente inicializa la lista
			datos = new ArrayList<>();
		}
	}
}

class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

	Usuario() {
	}

	Usuario(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public void setUsername(String l) {
		username = l;
	}

	public void setPassword(String p) {
		password = p;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}

class Vista {
	String username;
	String password;
	String respuesta;

	public void pedirDatosRegistro() {
		Console con = System.console();
		System.out.println("Nuevo username: ");
		username = con.readLine();
		System.out.println("Nueva password: ");
		char pass[] = con.readPassword();
		password = new String(pass);
	}

	public void pedirDatos() {
		Console con = System.console();
		System.out.println("username: ");
		username = con.readLine();
		System.out.println("password: ");
		char pass[] = con.readPassword();
		password = new String(pass);
	}

	public void mostrarRespuesta() {
		System.out.println(respuesta);
	}

}

class Controlador {
	Vista vista;
	Modelo modelo;

	Controlador() {
		vista = new Vista();
		modelo = new Modelo();
	}

	public void iniciar() {
		int opcion = menu();
		switch (opcion) {
			case 1:
				registrarUsuario();
				break;
			case 2:
				autenticarUsuario();
				break;
			default:
				System.out.println("Opción no válida");
		}
	}

	private int menu() {
		Console con = System.console();
		System.out.println("Seleccione una opción:");
		System.out.println("1. Registrar");
		System.out.println("2. Autenticar");
		return Integer.parseInt(con.readLine());
	}

	private void registrarUsuario() {

		boolean registroExitoso = false;
		do {
			vista.pedirDatosRegistro();
			Usuario nuevoUsuario = new Usuario(vista.username, vista.password);
			modelo.agregarUsuario(nuevoUsuario);
			System.out.println("Usuario registrado exitosamente");
			registroExitoso = true;
		} while (!registroExitoso);
	}

	private void autenticarUsuario() {
		vista.pedirDatos();
		Usuario user = modelo.buscarUsuario(vista.username);
		if (user != null) {
			boolean res = autenticar(user);
			if (res) {
				vista.respuesta = "Autenticacion exitosa!! \n Bienvenido " + user.getUsername();
			}
		} else {
			vista.respuesta = "Usuario no existente ";
		}
		vista.mostrarRespuesta();
	}

	public boolean autenticar(Usuario user) {
		boolean result;
		if (user.getUsername().equals(vista.username) &&
				user.getPassword().equals(vista.password)) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

}

class TestMVC {
	TestMVC() {
	};

	public static void main(String[] args) {
		new Controlador().iniciar();
	}
}
