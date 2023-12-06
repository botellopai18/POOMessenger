package vista.chat;

import java.net.Socket;
import java.util.Arrays;
import java.util.ArrayList;
import javax.swing.*;
import vista.chat.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import vista.menu.Menu;
import vista.format.AppFonts;

public class Chat implements ActionListener {
  public JPanel parent, contenedorMensajes;
  public JScrollPane scrollPanel;
  public String usuarioAutenticado;
  private JTextField textField;
  public ArrayList<String> usuariosConectados;

  public Chat(String user, ArrayList<String> usuariosConectados, ArrayList<String> mensajes) {
    this.parent = new JPanel(new GridBagLayout());
    this.contenedorMensajes = new JPanel(new GridBagLayout());
    this.usuarioAutenticado = user;
    this.usuariosConectados = usuariosConectados;
    contenedorMensajes.setBackground(AppFonts.secondaryColor);

    restaurarMensajes(mensajes);
    crearBarraMensajes();
  }

  private void crearBarraMensajes() {
    JPanel barra = new JPanel(new GridBagLayout());

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.insets = new Insets(3, 3, 3, 0); 

    gbc.weightx = 1.0;
    textField = new JTextField();
    textField.addActionListener(this);
    barra.add(textField, gbc);

    gbc.weightx = 0.0;
    gbc.gridx = GridBagConstraints.RELATIVE;
    gbc.fill = GridBagConstraints.NONE;
    gbc.insets = new Insets(3, 2, 3, 2); 

    JButton enviarButton = new JButton("Enviar");
    enviarButton.addActionListener(this);
    barra.add(enviarButton, gbc);

    gbc.insets = new Insets(3, 0, 3, 2); 

    JButton archivoButton = new JButton("Archivo");
    new EnviarArchivo(archivoButton, this);
    barra.add(archivoButton, gbc);

    GridBagConstraints gbcBarra = new GridBagConstraints();
    gbcBarra.gridx = 0;
    gbcBarra.gridy = 1;
    gbcBarra.fill = GridBagConstraints.HORIZONTAL;
    gbcBarra.weighty = 0.05;
    parent.add(barra, gbcBarra);
  }

  private void restaurarMensajes(ArrayList<String> mensajes) {
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.fill = GridBagConstraints.BOTH;
    gbc.weightx = 1.0;
    gbc.weighty = 0.95;
    gbc.insets = new Insets(0, 0, 0, 0);

    scrollPanel = new JScrollPane(contenedorMensajes);
    parent.add(scrollPanel, gbc);

    for (int i = 0; i < mensajes.size(); i++) {
      String[] parsed = mensajes.get(i).split("--");
      mensajeRecibido(parsed[1], parsed[0]);
    }
  }

  public void mensajeRecibido(String mensaje, String user) {
    int alignment, anchor;
    String from;
    if (user.equals(usuarioAutenticado)) {
      alignment = SwingConstants.RIGHT;
      from = "Yo";
      anchor = GridBagConstraints.LINE_END;
    } else {
      alignment = SwingConstants.LEFT;
      from = user;
      anchor = GridBagConstraints.LINE_START;
    }

    JLabel label = crearLabelMensaje(mensaje, alignment, from);

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.weightx = 0.8;
    gbc.insets = new Insets(3, 5, 3, 5);
    gbc.anchor = anchor;
    
    contenedorMensajes.add(label, gbc);
    scrollPanel.revalidate();
    scrollPanel.repaint();

    Runnable scroll = new Runnable() {
      public void run() {
        JScrollBar vertical = scrollPanel.getVerticalScrollBar();
        vertical.setValue(vertical.getMaximum());
      }
    };

    SwingUtilities.invokeLater(scroll);
  }

  static public JLabel crearLabelMensaje(String mensaje, int alignment, String user) {
    String formateado = separarLineas(mensaje);
    String styleAlign = alignment == SwingConstants.LEFT ? "left" : "right";
    String texto = String.format("<html><body style='text-align: %s'><b>%s</b><br>%s</body></html>", styleAlign, user, formateado);
    JLabel label = new JLabel("", alignment);
    label.setText(texto);
    label.setFont(AppFonts.regular);
    label.setBorder(BorderFactory.createEmptyBorder(4, 6, 4, 6));
    label.setOpaque(true);
    Color color = alignment == SwingConstants.LEFT ? AppFonts.mensajeAmigo : AppFonts.mensajeUsuario;
    label.setBackground(color);

    return label;
  } 

  static private String separarLineas(String mensaje) {
    String[] temp = mensaje.split(" ");
    String formateado = "";

    while (true) {
      if (temp.length <= 5) {
        formateado += String.join(" ", temp);
        break;

      } else {
        formateado += String.format("%s %s %s %s %s<br>", temp[0], temp[1], temp[2], temp[3], temp[4]);
        temp = Arrays.copyOfRange(temp, 5, temp.length - 1);
      }
    }

    return formateado;
  }

  public void actionPerformed(ActionEvent e) {
    String message = textField.getText();
    textField.setText("");
    
    message = message.strip();
    if (message.equals("")) return;

    // mensaje recibido no debe de ser llamado directamente, solo es para ver que funcione 
    mensajeRecibido(message, usuarioAutenticado);

    // Lo que se debe de hacer es esto:
    // controlador.mensajeEnviado(mensaje, usuario)
    /*
     * 
     * Controlador recibe mensaje
     * Modelo: Escribir mensaje en el archivo de texto
     * Controlador: a cada chat de los usuarios activos va a invocar la function chat.mensajeRecibido(mensaje,    usuario)
     */
  }

  public void enviarArchivoControlador(File archivo, ArrayList<String> userList) {
    // TODO implementar funcion para mandar archivos por el servidor
    // TENER EN CUENTA que pasa cuando se intenta mandar un archivo a un usuario que todavia no ha elegido carpeta en la pestaña Archivos
    System.out.println("Enviando " + archivo.getAbsolutePath() + " a: ");
    for (int i = 0; i < userList.size(); i++) {
      System.out.println(userList.get(i));
    }
  }
}
