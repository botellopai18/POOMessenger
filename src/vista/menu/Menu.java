package vista.menu;

import java.util.ArrayList;
import java.io.File;
import javax.swing.*;
import java.awt.*;
import vista.chat.*;
import vista.menu.Principal;
import vista.menu.Archivos;
import controlador.conexion.Cliente;

public class Menu {
    static public Principal principal;
    static public Archivos archivos;
    static public String usuarioAutenticado;
    public static void main(String[] args) {
        // TODO: pasarle al menu como argumento el usuario que se autentico
        usuarioAutenticado = args[0];
        JFrame frame = new JFrame("Messenger POO");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JTabbedPane tabbedPane = new JTabbedPane();
        
        // Arreglos de prueba
        ArrayList<String> usuariosConectados = new ArrayList<String>();
        usuariosConectados.add("Botello");
        usuariosConectados.add("Cris");
        usuariosConectados.add("Moncho");
        usuariosConectados.add("Esteban");
        ArrayList<String> mensajes = new ArrayList<String>();
        // El formato de cada string va a ser: username--mensaje
        mensajes.add("Moncho--Hola");
        mensajes.add("Cris--No");
        mensajes.add("Esteban--Si");

        // Pestaña chat
        // En este caso, el usuario Moncho es el usuario que se autenticó
        principal = new Principal(usuarioAutenticado, usuariosConectados, mensajes);

        tabbedPane.addTab("Mensajes", principal);

        // Pestaña archivos
        // El segundo argumento de Archivos es la eleccion actual de la carpeta del usuario autenticado, debería obtenerse de un archivo de texto en donde se guarden las elecciones de cada usuario, por defecto sería "..."
        archivos = new Archivos(usuarioAutenticado, "...", principal.cliente);
        tabbedPane.addTab("Archivos", archivos);

        frame.add(tabbedPane);
        frame.setVisible(true);
    }
}
