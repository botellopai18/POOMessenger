package vista.menu;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import vista.menu.UsuariosConectados;
import vista.chat.Chat;
import vista.format.AppFonts;

public class Principal extends JPanel {
  private GridBagConstraints constraints;
  private UsuariosConectados usuarios;
  public Chat chat;
  private String usuarioAutenticado;
  private ArrayList<String> usuariosConectados, mensajes;

  public Principal(String user, ArrayList<String> usuariosConectados, ArrayList<String> mensajes) {
    super(new GridBagLayout());
    this.usuarioAutenticado = user;
    this.usuariosConectados = usuariosConectados;
    this.mensajes = mensajes;

    constraints = new GridBagConstraints();
    constraints.fill = GridBagConstraints.BOTH;
    constraints.insets = new Insets(4, 5, 0, 5);

    agregarLabels();
    agregarPaneles();
  }

  private void agregarLabels() {
    constraints.weighty = 0.1;
    constraints.gridy = 0;

    JLabel enLinea = new JLabel("En linea");
    enLinea.setFont(AppFonts.titulo);
    enLinea.setHorizontalAlignment(SwingConstants.CENTER);
    add(enLinea, constraints);

    JLabel chat = new JLabel("Chat");
    chat.setFont(AppFonts.titulo);
    chat.setHorizontalAlignment(SwingConstants.CENTER);
    add(chat, constraints);
  }

  private void agregarPaneles() {
    usuarios = new UsuariosConectados(usuarioAutenticado, usuariosConectados);
    constraints.weighty = 1.0;
    constraints.weightx = 0.15;
    constraints.gridy = 1;
    add(usuarios.scrollPanel, constraints);

    constraints.weightx = 1.0;
    chat = new Chat(usuarioAutenticado, usuariosConectados, mensajes);
    add(chat.parent, constraints);
  }

  public void setUsuariosConectados(ArrayList<String> nuevosUsuariosConectados) {
    usuarios.agregarUsuarios(usuarioAutenticado, nuevosUsuariosConectados);
    chat.usuariosConectados = nuevosUsuariosConectados;
  }
}
