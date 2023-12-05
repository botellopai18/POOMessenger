package menu;

import javax.swing.*;
import java.awt.*;
import format.AppFonts;

public class UsuariosConectados extends JPanel {
  private GridBagConstraints constraints;
  public JScrollPane scrollPanel;

  public UsuariosConectados() {
    super(new GridBagLayout());
    constraints = new GridBagConstraints();
    constraints.gridx = 0;
    constraints.weightx = 1.0;
    constraints.fill = GridBagConstraints.HORIZONTAL;
    constraints.anchor = GridBagConstraints.PAGE_START;
    constraints.ipady = 5;

    agregarUsuarios();
  }

  private void agregarUsuarios() {
    // Los usuarios aqui deberian sacarse del servidor
    for (int i = 1; i <= 15; i++) {
      JLabel user = new JLabel("user" + i);
      user.setBorder(AppFonts.borderUsuarios);
      user.setFont(AppFonts.usuarios);
      user.setHorizontalAlignment(SwingConstants.CENTER);
      user.setOpaque(true);
      user.setBackground(AppFonts.secondaryColor);
      add(user, constraints);
    }

    scrollPanel = new JScrollPane(this);
  }
}
