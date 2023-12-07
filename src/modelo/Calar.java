package modelo;

import modelo.*;
import vista.login.login;
import vista.registro.registro;
import vista.conexion.conexion;
import java.io.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

// clase para calar el modelo
class Calar {
    public static void main(String[] args) {
        Modelo m = new Modelo();

        Usuario u1 = new Usuario("isaac", "botello", "botellopai", "1234");
        Usuario u2 = new Usuario("cristian", "hernandez", "cristian", "1234");

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Modelo modelo1 = new Modelo();
                ArrayList<Usuario> listaUsuarios = modelo1.obtenerListaUsuarios();
                /*
                 * Implementar primero la logica de la conexion para despues pasar al login, se
                 * usan los frames de ejemplo
                 */
                JFrame frameC = new conexion();
                JFrame frameL = new login();
                JFrame frameR = new registro();
                frameL.setVisible(true);

            }
        });

        // System.out.println(m.obtenerUsuario("botellopai").getNombre());
        // System.out.println(m.autenticarUsuario("botellopa", "124"));
        // System.out.println(m.obtenerUsuario("cristian").getNombre());
        // System.out.println(m.autenticarUsuario("cristian", "1234"));
        // m.guardarMensaje("botello--Hola");
        // m.guardarMensaje("cristian--Hola");
        // m.guardarMensaje("botello--¿Cómo estás?");
        // m.guardarMensaje("cristian--Bien, ¿y tú?");
        // ArrayList<String> mensajes = m.obtenerMensajes();
        // for (String mensaje : mensajes) {
        // System.out.println(mensaje);
        // }
        // System.out.println("Conectados:");
        // m.conectarUsuario("botellopai");
        // m.conectarUsuario("cristian");
        // ArrayList<String> conectados = m.obtenerUsuariosConectados();
        // for (String conectado : conectados) {
        // System.out.println(conectado);
        // }
        // m.desconectarUsuario("botellopai");
        // conectados = m.obtenerUsuariosConectados();
        // for (String conectado : conectados) {
        // System.out.println(conectado);
        // }

    }
}