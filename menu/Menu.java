package menu;

import java.io.File;
import javax.swing.*;
import java.awt.*;
import chat.*;
import menu.Principal;
import menu.Archivos;

public class Menu {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Messenger POO");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Pestaña chat
        tabbedPane.addTab("Mensajes", new Principal());

        // Pestaña archivos
        tabbedPane.addTab("Archivos", new Archivos());

        frame.add(tabbedPane);
        frame.setVisible(true);
    }
}
