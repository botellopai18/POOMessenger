package ejemplos.interfaces;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
public class DisposicionConBordes {
    public static void main(String [] args) {
        JFrame marco = new JFrame("Disposición con bordes");
        Container contenedor = marco.getContentPane();
        contenedor.setLayout(new BorderLayout());
        JButton b1 = new JButton("Norte");
        JButton b2 = new JButton("Sur");
        JButton b3 = new JButton("Este");
        JButton b4 = new JButton("Oeste");
        JButton b5 = new JButton("Centro");
        contenedor.add(b1,BorderLayout.NORTH);
        contenedor.add(b2,BorderLayout.SOUTH);
        contenedor.add(b3,BorderLayout.EAST);
        contenedor.add(b4,BorderLayout.WEST);
        contenedor.add(b5,BorderLayout.CENTER);
        marco.pack();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}