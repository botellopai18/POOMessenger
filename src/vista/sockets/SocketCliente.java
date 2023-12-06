package vista.sockets;

import java.io.*;
import java.net.Socket;

public class SocketCliente {
  static final String SERVIDOR = "localhost";
  static final int PUERTO = 5432;
  Socket con;
  DataInputStream flujoDatosEntrada;
  DataOutputStream flujoDatosSalida;

  public SocketCliente() {
    try {
      con = new Socket(SERVIDOR, PUERTO);

      InputStream leer = con.getInputStream();
      flujoDatosEntrada = new DataInputStream(leer);

      // System.out.println(flujoDatosEntrada.readUTF());

      flujoDatosSalida = new DataOutputStream(con.getOutputStream());
      flujoDatosSalida.writeUTF("Gracias por aceptarme.");
      
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
  }

  public void escuchar() {
    while (true) {
      System.out.println(flujoDatosEntrada.readUTF());
    }
  }

  public void cerrar() {
      flujoDatosEntrada.close();
      flujoDatosSalida.close();
      con.close();
  }
}