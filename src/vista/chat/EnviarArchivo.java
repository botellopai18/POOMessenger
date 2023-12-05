package vista.chat;

import java.util.ArrayList;
import java.io.File;
import javax.swing.*;
import java.awt.*;
import vista.chat.Chat;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnviarArchivo implements ActionListener {
  private JButton source;
  private Chat chat;

  public EnviarArchivo (JButton source, Chat chat) {
    this.source = source;
    this.chat = chat;
    source.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    new SeleccionarArchivo(chat);
  }
}

class SeleccionarArchivo extends JFrame implements ActionListener {
  private JTextField txt;
  private File file;
  private ArrayList<JCheckBox> checkboxes;
  private Chat chat;

  public SeleccionarArchivo(Chat chat) {
    super("Selecciona usuarios");
    this.chat = chat;
    setLayout(new FlowLayout());

    txt = new JTextField(30);
    JButton button = new JButton("Buscar");
    button.addActionListener(this);
    JButton enviar = new JButton("Enviar");
    enviar.addActionListener(this);

    listarUsuarios();
    add(txt);
    add(button);
    add(enviar);

    setSize(400, 200);
    setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    JButton source = (JButton) e.getSource();

    if (source.getText().equals("Buscar")) mostrarArchivos();
    else enviarArchivo();
  }

  private void mostrarArchivos() {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

    int result = fileChooser.showOpenDialog(this);

    if (result != JFileChooser.CANCEL_OPTION) {

      File fileName = fileChooser.getSelectedFile();

      if ((fileName == null) || (fileName.getName().equals(""))) {
          txt.setText("...");
      } else {
          txt.setText(fileName.getAbsolutePath());
          file = fileName;
      }
    }
  }

  private void enviarArchivo() {
    if (file == null) return;
    
    ArrayList<String> users = new ArrayList<String>();
    for (int i = 0; i < checkboxes.size(); i++) {
      JCheckBox curr = checkboxes.get(i);

      if (!curr.isSelected()) continue;

      String user = curr.getText();
      users.add(user);
    }
    
    setVisible(false);
    dispose();
    chat.enviarArchivoControlador(file, users);
  }

  private void listarUsuarios() {
    checkboxes = new ArrayList<JCheckBox>();
    for (int i = 0; i < chat.usuariosConectados.size(); i++) {
      String username = chat.usuariosConectados.get(i);
      if (username.equals(chat.usuarioAutenticado)) continue;

      JCheckBox checkbox = new JCheckBox(username);
      add(checkbox);
      checkboxes.add(checkbox);
    }
  }
}
