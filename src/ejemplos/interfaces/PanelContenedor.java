package ejemplos.interfaces;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class PanelContenedor {
    public static void main(String [] args) {
        JFrame marco = new JFrame("Ejemplo con JPanel");
        Container c = marco.getContentPane();
        c.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        JButton b1 = new JButton("Panel 1");
        JButton b2 = new JButton("Panel 2");
        JButton b3 = new JButton("Norte");
        JButton b4 = new JButton("Centro");
        JButton b5 = new JButton("Este");
        JButton b6 = new JButton("Sur");
        panel.setLayout(new GridLayout(2,1));
        panel.add(b1);
        panel.add(b2);
        c.add(panel,BorderLayout.WEST);
        c.add(b3,BorderLayout.NORTH);
        c.add(b4,BorderLayout.CENTER);
        c.add(b5,BorderLayout.EAST);
        c.add(b6,BorderLayout.SOUTH);
        marco.pack();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}