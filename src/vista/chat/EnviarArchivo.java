package vista.chat;

import java.util.ArrayList;
import java.io.File;
import javax.swing.*;
import java.awt.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnviarArchivo implements ActionListener {
  private JButton source;

  public EnviarArchivo (JButton source) {
    this.source = source;
    source.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    new SeleccionarArchivo();
  }
}

class SeleccionarArchivo extends JFrame implements ActionListener {
  private JTextField txt;
  private File file;
  private ArrayList<JCheckBox> checkboxes;

  public SeleccionarArchivo() {
    super("Selecciona usuarios");
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
    
    for (int i = 0; i < checkboxes.size(); i++) {
      JCheckBox curr = checkboxes.get(i);

      if (!curr.isSelected()) continue;

      String user = curr.getText();
      // Aqui deberia ir la funcion para enviar el archivo al usuario

      setVisible(false);
      dispose();
    }

  }

  private void listarUsuarios() {
    // Aqui los usuarios deberian sacarse del server
    checkboxes = new ArrayList<JCheckBox>();
    for (int i = 1; i <= 10; i++) {
      JCheckBox checkbox = new JCheckBox("usuario" + i);
      add(checkbox);
      checkboxes.add(checkbox);
    }
  }
}
