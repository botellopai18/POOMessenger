package vista.chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.chat.Chat;

// ESTA CLASE YA NO SE VA A UTILIZAR
public class EnviarMensaje implements ActionListener {
  private Component source;
  private JTextField textField;

  private Chat chat;

  public EnviarMensaje(Chat chat, JTextField source) {
    this.chat = chat;
    this.source = source;
    source.addActionListener(this);
  }

  public EnviarMensaje(Chat chat, JButton source, JTextField textField) {
    this.chat = chat;
    this.source = source;
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
    chat.mensajeEnviado();

    SwingUtilities.invokeLater(scroll);
  }
}
