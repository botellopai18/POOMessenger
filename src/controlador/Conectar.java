package controlador;

import controlador.Cliente;
import controlador.Servidor;

public class Conectar {
    private Servidor servidor;
    private Cliente cliente;

    public Conectar() {
        servidor = new Servidor();
        cliente = new Cliente();
    }

    public static void main(String[] arg) {
        // Se crea una instancia de la clase Servidor
        Conectar conectar = new Conectar();
        conectar.servidor.iniciarServidor();
        while (true) {
            System.out.println("Desea iniciar un cliente? (1/0)");
            int opcion = Integer.parseInt(System.console().readLine());
            if (opcion == 1 && conectar.servidor.getEsperando()) {
                conectar.cliente.iniciar();
            } else if (conectar.servidor.getEsperando() == false) {
                System.out.println("Servidor ocupado.");
                continue;
            } else {
                break;
            }
        }

    }
}