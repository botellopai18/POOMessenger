package menu;

import java.io.File;
import java.io.IOException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import format.AppFonts;

public class Archivos extends JPanel implements ActionListener {
  private GridBagConstraints constraints;
  private JLabel path;

  public Archivos() {
    super(new GridBagLayout());
    constraints = new GridBagConstraints();
    constraints.weightx = 1.0;
    constraints.gridx = 0;
    constraints.gridwidth = 2;
    constraints.fill = GridBagConstraints.HORIZONTAL;
    constraints.anchor = GridBagConstraints.CENTER;
    constraints.insets = new Insets(5, 3, 5, 3);

    JLabel label = new JLabel("Carpeta designada para almacenar archivos: ");
    label.setFont(AppFonts.titulo);
    label.setHorizontalAlignment(SwingConstants.CENTER);
    add(label, constraints);

    path = new JLabel("...");
    path.setFont(AppFonts.subtitulo);
    path.setHorizontalAlignment(SwingConstants.CENTER);
    add(path, constraints);

    JButton cambiarCarpeta = new JButton("Cambiar carpeta");
    cambiarCarpeta.addActionListener(this);
    constraints.weightx = 0.5;
    constraints.gridy = 2;
    constraints.gridx = GridBagConstraints.RELATIVE;
    constraints.gridwidth = 1;
    constraints.fill = GridBagConstraints.NONE;
    constraints.anchor = GridBagConstraints.LINE_END;
    add(cambiarCarpeta, constraints);

    JButton abrirArchivos = new JButton("Abrir archivos");
    abrirArchivos.addActionListener(this);
    constraints.anchor = GridBagConstraints.LINE_START;
    add(abrirArchivos, constraints);
  }

  public void actionPerformed(ActionEvent e) {
    JButton source = (JButton) e.getSource();

    if (source.getText().equals("Cambiar carpeta")) cambiarCarpeta();
    else abrirCarpeta();
  }

  private void cambiarCarpeta() {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

    int result = fileChooser.showOpenDialog(this);

    if (result != JFileChooser.CANCEL_OPTION) {

      File fileName = fileChooser.getSelectedFile();

      if ((fileName == null) || (fileName.getName().equals(""))) {
          path.setText("...");
      } else {
          path.setText(fileName.getAbsolutePath());
          // Guardar la nueva carpeta en server
      }
    }
  }

  private void abrirCarpeta() {
    try {
      String route = path.getText();

      if (route.equals("...")) throw new IOException();

      File directory = new File(path.getText());
      Desktop.getDesktop().open(directory);

    } catch (IOException e) {}
  }
}
