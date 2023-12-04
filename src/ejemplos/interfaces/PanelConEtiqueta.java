package ejemplos.interfaces;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class PanelConEtiqueta {

    public static void main(String [] args) {

        JFrame marco = new JFrame("Ej JScrollPanel");
        ImageIcon ii = new ImageIcon("resources/dragon.jpeg");
        JLabel etiqueta = new JLabel(ii);
        etiqueta.setToolTipText("Imagen de dragOn");
        JScrollPane scrollPane = new JScrollPane(etiqueta);
        marco.getContentPane().add(scrollPane);
        marco.pack();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }

}