package vista.conexion;

import vista.login.login;
import vista.registro.registro;
import controlador.login.Controlador;
import modelo.Modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class conexion extends JFrame {
    public conexion() {
        setSize(350, 240);
        setTitle("Interfaz Conexion");
        setLocationRelativeTo(null); // Establecemos la ventana en el centro de la pantalla
        mostrarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void mostrarComponentes() {
        JPanel panel = new JPanel();
        panel.setLayout(null); // Desactivamos el diseño por defecto
        this.getContentPane().add(panel);// Agregamos el panel a la ventana
        panel.setBackground(Color.WHITE);// Establecemos el color del panel
        JLabel labelConexion = new JLabel("Conexion", SwingConstants.CENTER);
        labelConexion.setBounds(100, 0, 130, 25); // Establecemos la posicion y el tamaño
        JLabel labelIp = new JLabel("IP:", SwingConstants.CENTER);
        labelIp.setBounds(10, 60, 80, 25); // Establecemos la posicion y el tamaño
        JTextField txtIp = new JTextField();
        txtIp.setBounds(100, 60, 150, 25);
        JLabel labelPuerto = new JLabel("Puerto:", SwingConstants.CENTER);
        labelPuerto.setBounds(10, 90, 80, 25); // Establecemos la posicion y el tamaño
        JTextField txtPuerto = new JTextField();
        txtPuerto.setBounds(100, 90, 150, 25);
        panel.add(labelIp);
        panel.add(labelPuerto);
        panel.add(txtIp);
        panel.add(txtPuerto);
        panel.add(labelConexion);
        // Boton para conectar
        JButton btnConectar = new JButton("Conectar");
        btnConectar.setBounds(50, 130, 100, 25);
        panel.add(btnConectar);
        // Boton para cancelar
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(200, 130, 100, 25);
        panel.add(btnCancelar);

        // Añadir funcion al boton conectar
        ActionListener conectarBoton = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar el codigo para que ingrese a la ventana de login
                
                // if(conectarServidor()){

                // } else {

                // }
            }

        };
        // Añadir funcion al boton cancelar
        ActionListener cancelarBoton = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }

        };
        btnCancelar.addActionListener(cancelarBoton);
    }

    public static void main(String[] args) {
        conexion r = new conexion();
        r.setVisible(true);
    }
}
