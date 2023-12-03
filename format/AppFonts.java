package format;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

import java.awt.Font;

public interface AppFonts {
  Font titulo = new Font("Dialog", Font.BOLD, 15);
  Font subtitulo = new Font("Dialog", Font.PLAIN, 14);
  Font regular = new Font("Dialog", Font.PLAIN, 12);
  Font usuarios = new Font("Dialog", Font.PLAIN, 14);
  Border borderUsuarios = new MatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY);
  Color mainColor = Color.GRAY;
  Color secondaryColor = Color.WHITE;
  Color mensajeUsuario = new Color(150, 239, 255);
  Color mensajeAmigo = new Color(224, 239, 255);
}
