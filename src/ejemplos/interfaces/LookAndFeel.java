package ejemplos.interfaces;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import java.awt.Container;
import java.awt.FlowLayout;
public class LookAndFeel {

    public static void main(String [] args) {

        JFrame marco = new JFrame("Look and feel y disposición fluida");
        marco.setDefaultLookAndFeelDecorated(true);
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception e) { }
        Container contenedor = marco.getContentPane();
        contenedor.setLayout(new FlowLayout());
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        contenedor.add(b1);
        contenedor.add(b2);
        marco.pack();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}