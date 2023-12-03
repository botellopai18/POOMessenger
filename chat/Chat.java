package chat;

import javax.swing.*;
import chat.*;
import java.awt.*;
import menu.Menu;
import format.AppFonts;

public class Chat {
  public JPanel parent, contenedorMensajes;
  public JScrollPane scrollPanel;

  public Chat() {
    this.parent = new JPanel(new GridBagLayout());
    this.contenedorMensajes = new JPanel(new GridBagLayout());
    contenedorMensajes.setBackground(AppFonts.secondaryColor);

    restaurarMensajes();
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
    JTextField textField = new JTextField();
    new EnviarMensaje(scrollPanel, textField, contenedorMensajes);
    barra.add(textField, gbc);

    gbc.weightx = 0.0;
    gbc.gridx = GridBagConstraints.RELATIVE;
    gbc.fill = GridBagConstraints.NONE;
    gbc.insets = new Insets(3, 2, 3, 2); 

    JButton enviarButton = new JButton("Enviar");
    new EnviarMensaje(scrollPanel, enviarButton, contenedorMensajes, textField);
    barra.add(enviarButton, gbc);

    gbc.insets = new Insets(3, 0, 3, 2); 

    JButton archivoButton = new JButton("Archivo");
    new EnviarArchivo(archivoButton);
    barra.add(archivoButton, gbc);

    GridBagConstraints gbcBarra = new GridBagConstraints();
    gbcBarra.gridx = 0;
    gbcBarra.gridy = 1;
    gbcBarra.fill = GridBagConstraints.HORIZONTAL;
    gbcBarra.weighty = 0.05;
    parent.add(barra, gbcBarra);
  }

  private void restaurarMensajes() {
    // La funcion testAgregarMensajes solo es para ver que la interfaz este bien, debe reemplazarse por una funcion que tome los mensajes guardados en el servidor
    testAgregarMensajes();

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.fill = GridBagConstraints.BOTH;
    gbc.weightx = 1.0;
    gbc.weighty = 0.95;
    gbc.insets = new Insets(0, 0, 0, 0);

    scrollPanel = new JScrollPane(contenedorMensajes);
    parent.add(scrollPanel, gbc);
  }

  private void testAgregarMensajes() {
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = GridBagConstraints.RELATIVE;
    gbc.weightx = 0.8;
    gbc.weighty = 1.0;
    gbc.fill = GridBagConstraints.VERTICAL;
    gbc.insets = new Insets(3, 5, 3, 5);

    for (int i = 0; i < 15; i++) {
      int alignment = i % 2 == 0 ? SwingConstants.LEFT : SwingConstants.RIGHT;
      JLabel label = crearLabelMensaje("mensaje " + i, alignment);

      if (i % 2 != 0) gbc.anchor = GridBagConstraints.LINE_END;
      else gbc.anchor = GridBagConstraints.LINE_START;

      contenedorMensajes.add(label, gbc);
    }
  }

  public void mensajeRecibido(String mensaje) {
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.weightx = 0.8;
    gbc.insets = new Insets(3, 5, 3, 5);
    gbc.anchor = GridBagConstraints.LINE_START;
    
    JLabel label = crearLabelMensaje(mensaje, SwingConstants.LEFT);
    contenedorMensajes.add(label, gbc);
    scrollPanel.revalidate();
    scrollPanel.repaint();

    JScrollBar vertical = scrollPanel.getVerticalScrollBar();
    vertical.setValue(vertical.getMaximum());
  }

  static public JLabel crearLabelMensaje(String mensaje, int alignment) {
    JLabel label = new JLabel(mensaje, alignment);
    label.setFont(AppFonts.regular);
    label.setBorder(BorderFactory.createEmptyBorder(4, 6, 4, 6));
    label.setOpaque(true);
    Color color = alignment == SwingConstants.LEFT ? AppFonts.mensajeAmigo : AppFonts.mensajeUsuario;
    label.setBackground(color);

    return label;
  } 
}
