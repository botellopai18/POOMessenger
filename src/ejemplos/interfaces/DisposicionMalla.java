package ejemplos.interfaces;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
public class DisposicionMalla {
    public static void main(String [] args) {
        JFrame marco = new JFrame("Disposición con malla");
        Container contenedor = marco.getContentPane();
        contenedor.setLayout(new GridLayout(2,3));
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        contenedor.add(b1);
        contenedor.add(b2);
        contenedor.add(b3);
        contenedor.add(b4);
        contenedor.add(b5);
        contenedor.add(b6);
        marco.pack();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}