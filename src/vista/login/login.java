package vista.login;

import controlador.login.Controlador;
import modelo.Modelo;
import vista.registro.registro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login extends JFrame {
    /*
     * public JPanel parent;
     * public JTextField usuario;
     * public JPasswordField password;
     * public JButton loginButton;
     * public JPanel panel;
     */

    private Controlador controlador;
    private Modelo modelo;

    public login() {
        setSize(300, 300);
        setTitle("Interfaz Login");
        modelo = new modelo.Modelo();
        setLocationRelativeTo(null); // Establecemos la ventana en el centro de la pantalla
        mostrarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private void mostrarComponentes() {

        JPanel panel = new JPanel();
        panel.setLayout(null); // Desactivamos el diseño por defecto
        this.getContentPane().add(panel);// Agregamos el panel a la ventana
        panel.setBackground(Color.WHITE);// Establecemos el color del panel
        JLabel labelPOOMessenger = new JLabel("POOMessenger", SwingConstants.CENTER);
        labelPOOMessenger.setBounds(100, 0, 100, 25); // Establecemos la posicion y el tamaño
        JLabel labelUsuario = new JLabel("Usuario:", SwingConstants.CENTER);
        labelUsuario.setBounds(10, 60, 80, 25); // Establecemos la posicion y el tamaño
        JLabel labelContrasenia = new JLabel("Contraseña:", SwingConstants.CENTER);
        labelContrasenia.setBounds(10, 90, 80, 25); // Establecemos la posicion y el tamaño
        JTextField txtUsuario = new JTextField();
        txtUsuario.setBounds(100, 60, 100, 25);
        JTextField txtContrasenia = new JTextField(); // Oculta la contraseña
        txtContrasenia.setBounds(100, 90, 100, 25);
        panel.add(txtUsuario);
        panel.add(labelPOOMessenger);
        panel.add(labelUsuario);
        panel.add(labelContrasenia);
        panel.add(txtContrasenia);
        // Boton para ingresar
        JButton btnIngresar = new JButton("Ingresar");
        btnIngresar.setBounds(100, 120, 100, 25);
        panel.add(btnIngresar);
        // Boton para registrarse
        JButton btnRegistrarse = new JButton("Registrarse");
        btnRegistrarse.setBounds(100, 150, 100, 25);
        panel.add(btnRegistrarse);
        // Boton para cancelar
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(100, 180, 100, 25);
        panel.add(btnCancelar);

        // Añadir funcion al boton ingresar
        ActionListener ingresarBoton = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txtUsuario.getText().isEmpty() && !txtContrasenia.getText().isEmpty()) {
                    String name = txtUsuario.getText();
                    String password = txtContrasenia.getText();
                    if (modelo.autenticarUsuario(name, password)) {
                        JOptionPane.showMessageDialog(null, "Ingreso exitoso");
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No pueden estar vacios los campos");
                }

            }

        };
        btnIngresar.addActionListener(ingresarBoton);

        // Añadir funcion al boton cancelar
        ActionListener cancelarBoton = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }

        };
        btnCancelar.addActionListener(cancelarBoton);

        // Añadir funcion al boton registrarse

        ActionListener registrarseBoton = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                registro frameRegistro = new registro();
                dispose();
                frameRegistro.setVisible(true);
            }

        };

        btnRegistrarse.addActionListener(registrarseBoton);
    }

    public static void main(String[] args) {
        login login = new login();
        login.setVisible(true);
    }
}
