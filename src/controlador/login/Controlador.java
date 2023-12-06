package controlador.login;

import modelo.*;

public class Controlador {

    Modelo modelo;

    public Controlador() {

        modelo = new Modelo();
    }

    /*
     * public boolean autenticar(String username, String password)
     * {
     * Usuario user = modelo.buscarUsuario(username);
     * if (user == null)
     * {
     * return false;
     * }
     * if (user.getPassword().equals(password))
     * {
     * return true;
     * } else
     * {
     * return false;
     * }
     * }
     */

    public boolean autenticar(String username, String password) {
        Usuario user = modelo.buscarUsuario(username);
        if (user == null) {
            System.out.println("Hola");
            return false;
        }
        System.out.println("Contraseña ingresada: " + password);
        System.out.println("Contraseña almacenada: " + user.getContraseña());

        return user.getContraseña().equals(password);
    }

    public void guardarDatos() {
        modelo.guardarDatos();
    }
}
