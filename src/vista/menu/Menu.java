package vista.menu;

import java.util.ArrayList;
import java.io.File;
import javax.swing.*;
import java.awt.*;
import vista.chat.*;
import vista.menu.Principal;
import vista.menu.Archivos;

public class Menu {
    static public Principal principal;
    static public Archivos archivos;
    // Provisional
    static public String usuarioAutenticado = "Moncho";
    public static void main(String[] args) {
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
        /*
            Para cambiar los usuarios conectados, llamar el metodo:
            principal.setUsuariosConectados(ArrayList<String> nuevo);
        */ 

        tabbedPane.addTab("Mensajes", principal);

        // Pestaña archivos
        // El segundo argumento de Archivos es la eleccion actual de la carpeta del usuario autenticado, debería obtenerse de un archivo de texto en donde se guarden las elecciones de cada usuario, por defecto sería "..."
        archivos = new Archivos(usuarioAutenticado, "...");
        tabbedPane.addTab("Archivos", archivos);

        frame.add(tabbedPane);
        frame.setVisible(true);
    }
}
