package vista.menu;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import vista.format.AppFonts;

public class UsuariosConectados extends JPanel {
  private GridBagConstraints constraints;
  public JScrollPane scrollPanel;

  public UsuariosConectados(String usuarioAutenticado, ArrayList<String> usuariosConectados) {
    super(new GridBagLayout());
    constraints = new GridBagConstraints();
    constraints.gridx = 0;
    constraints.weightx = 1.0;
    constraints.fill = GridBagConstraints.HORIZONTAL;
    constraints.anchor = GridBagConstraints.PAGE_START;
    constraints.ipady = 5;

    scrollPanel = new JScrollPane(this);
    agregarUsuarios(usuarioAutenticado, usuariosConectados);
  }

  public void agregarUsuarios(String usuarioAutenticado, ArrayList<String> usuarios) {
    removeAll();
    for (int i = 0; i < usuarios.size(); i++) {
      String username = usuarios.get(i);
      if (username.equals(usuarioAutenticado)) continue;
      JLabel user = new JLabel(usuarios.get(i));
      user.setBorder(AppFonts.borderUsuarios);
      user.setFont(AppFonts.usuarios);
      user.setHorizontalAlignment(SwingConstants.CENTER);
      user.setOpaque(true);
      user.setBackground(AppFonts.secondaryColor);
      add(user, constraints);
    }
    revalidate();
    repaint();
  }
}
