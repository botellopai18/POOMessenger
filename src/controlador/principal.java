package controlador;

import vista.login.login;
import vista.registro.registro;
import modelo.Modelo;

import javax.swing.*;

public class principal {
    principal() {
    }

    ;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Modelo modelo1 = new Modelo();
                modelo1.cargarDatos();

                JFrame frame = new login();
                JFrame frame3 = new registro();

                frame.setSize(400, 300);
                frame.setVisible(true);

            }
        });
        // new Controlador().iniciar(); //Inicia el controlador desde la consola
    }

}
