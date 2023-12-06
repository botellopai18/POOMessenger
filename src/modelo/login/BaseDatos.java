package modelo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

class BaseDatos {
    ArrayList<Usuario> datos;

    BaseDatos() {
        datos = new ArrayList<Usuario>();
        cargarDatos();
    }

    @SuppressWarnings("unchecked")
    public void cargarDatos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("usuarios.txt"))) {
            datos = (ArrayList<Usuario>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Si ocurre un error al cargar, simplemente inicializa la lista
            datos = new ArrayList<>();
        }
    }
}