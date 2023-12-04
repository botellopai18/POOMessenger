package vista.menu;

import javax.swing.*;
import java.awt.*;
import vista.menu.UsuariosConectados;
import vista.chat.Chat;
import vista.format.AppFonts;

public class Principal extends JPanel {
  private GridBagConstraints constraints;
  private UsuariosConectados usuarios;

  public Principal() {
    super(new GridBagLayout());

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
    usuarios = new UsuariosConectados();
    constraints.weighty = 1.0;
    constraints.weightx = 0.15;
    constraints.gridy = 1;
    add(usuarios.scrollPanel, constraints);

    constraints.weightx = 1.0;
    Chat chat = new Chat();
    add(chat.parent, constraints);
  }
}
