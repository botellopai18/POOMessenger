package vista.registro;

import controlador.login.Controlador;
import modelo.*;
import javax.swing.*;
import vista.login.login;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class registro extends JFrame {
    public registro() {
        setSize(370, 380);
        setTitle("Interfaz Registro");
        setLocationRelativeTo(null); // Establecemos la ventana en el centro de la pantalla
        mostrarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private void mostrarComponentes() {
        Controlador controlador1 = new Controlador();
        Modelo modelo1 = new Modelo();
        JPanel panel = new JPanel();
        panel.setLayout(null); // Desactivamos el diseño por defecto
        this.getContentPane().add(panel);// Agregamos el panel a la ventana
        panel.setBackground(Color.WHITE);// Establecemos el color del panel
        JLabel labelRegistro = new JLabel("Registro", SwingConstants.CENTER);
        labelRegistro.setBounds(120, 0, 100, 25); // Establecemos la posicion y el tamaño
        JLabel labelNombre = new JLabel("Nombre:", SwingConstants.CENTER);
        labelNombre.setBounds(10, 60, 80, 25); // Establecemos la posicion y el tamaño
        JLabel labelApellido = new JLabel("Apellido:", SwingConstants.CENTER);
        labelApellido.setBounds(10, 90, 80, 25); // Establecemos la posicion y el tamaño
        JLabel labelUsuario = new JLabel("Usuario:", SwingConstants.CENTER);
        labelUsuario.setBounds(10, 120, 80, 25); // Establecemos la posicion y el tamaño
        JLabel labelContrasenia = new JLabel("Contraseña:", SwingConstants.CENTER);
        labelContrasenia.setBounds(10, 150, 80, 25); // Establecemos la posicion y el tamaño
        JLabel labelConfirmarContrasenia = new JLabel("Confirmar Contraseña:", SwingConstants.CENTER);
        labelConfirmarContrasenia.setBounds(10, 180, 80, 25); // Establecemos la posicion y el tamaño
        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(100, 60, 150, 25);
        JTextField txtApellido = new JTextField();
        txtApellido.setBounds(100, 90, 150, 25);
        JTextField txtUsuario = new JTextField();
        txtUsuario.setBounds(100, 120, 150, 25);
        JTextField txtContrasenia = new JTextField();
        txtContrasenia.setBounds(100, 150, 150, 25);
        JTextField txtConfirmarContrasenia = new JTextField();
        txtConfirmarContrasenia.setBounds(100, 180, 150, 25);
        panel.add(txtNombre);
        panel.add(txtApellido);
        panel.add(txtUsuario);
        panel.add(labelRegistro);
        panel.add(labelNombre);
        panel.add(labelApellido);
        panel.add(labelUsuario);
        panel.add(labelContrasenia);
        panel.add(labelConfirmarContrasenia);
        panel.add(txtUsuario);
        panel.add(txtContrasenia);
        panel.add(txtConfirmarContrasenia);
        // Boton para registrarse
        JButton btnRegistrarse = new JButton("Registrarse");
        btnRegistrarse.setBounds(50, 240, 110, 25);
        panel.add(btnRegistrarse);
        // Boton para mmstrar contraseña
        JButton btnMostrarContrasenia = new JButton("Mostrar contraseña");
        btnMostrarContrasenia.setBounds(180, 240, 150, 25);
        panel.add(btnMostrarContrasenia);
        // Boton para cancelar
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(100, 300, 150, 25);
        panel.add(btnCancelar);

        // Añadir funciones al boton registrarse
        ActionListener registrarseBoton = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String name = txtNombre.getText();
                String surname = txtApellido.getText();
                String username = txtUsuario.getText();
                String password = txtContrasenia.getText();
                String confirmPassword = txtConfirmarContrasenia.getText();
                // Verificar que las contraseñas coincidan
                if ((!txtUsuario.getText().isEmpty() && !txtContrasenia.getText().isEmpty()
                        && !txtNombre.getText().isEmpty() && !txtApellido.getText().isEmpty()
                        && !txtContrasenia.getText().isEmpty() && !txtConfirmarContrasenia.getText().isEmpty()))

                {
                    if (password.equals(confirmPassword)) {
                        // Contraseñas coinciden, procede con el registro
                        Usuario nuevoUsuario = new Usuario(name, surname, username, password);
                        boolean registroExitoso = modelo1.registrarUsuario(nuevoUsuario);

                        if (registroExitoso) {
                            JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente");
                            login frameLogin = new login();
                            dispose();
                            frameLogin.setSize(300, 300);
                            frameLogin.setVisible(true);

                        } else {
                            JOptionPane.showMessageDialog(null, "El usuario ya se encuentra registrado");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No pueden estar vacios los campos");
                }
            }

        };
        btnRegistrarse.addActionListener(registrarseBoton);
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
        registro r = new registro();
        r.setVisible(true);
    }
}
