package vista.chat;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.chat.Chat;

public class EnviarMensaje implements ActionListener {
  private Component source;
  private JPanel parent;
  private JTextField textField;
  private JScrollPane panel;

  private Chat chat;

  public EnviarMensaje(JScrollPane panel, JTextField source, JPanel parent) {
    this.panel = panel;
    this.source = source;
    this.parent = parent;
    source.addActionListener(this);
  }

  public EnviarMensaje(JScrollPane panel, JButton source, JPanel parent, JTextField textField) {
    this.panel = panel;
    this.source = source;
    this.parent = parent;
    this.textField = textField;
    source.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    String message;
    if (source instanceof JButton) {
      JButton newSource = (JButton) source;
      message = textField.getText();
      textField.setText("");
    } else {
      JTextField newSource = (JTextField) source;
      message = newSource.getText();
      newSource.setText("");
    }

    message = message.strip();
    if (message.equals("")) return;

    // Aqui iria la funcion para mandar el mensaje a traves del server

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.weightx = 0.8;
    gbc.insets = new Insets(3, 5, 3, 5);
    gbc.anchor = GridBagConstraints.FIRST_LINE_END;
    
    JLabel label = Chat.crearLabelMensaje(message, SwingConstants.RIGHT);
    parent.add(label, gbc);
    panel.revalidate();
    panel.repaint();

    JScrollBar vertical = panel.getVerticalScrollBar();
    vertical.setValue(vertical.getMaximum());
  }
}
