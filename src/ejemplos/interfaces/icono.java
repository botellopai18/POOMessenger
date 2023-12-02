package ejemplos.interfaces;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
class Icono extends JFrame {
    public Icono () {
        ImageIcon icono = new ImageIcon("resources/dragon.jpeg");
        this.setIconImage(icono.getImage());
        this.setSize(200,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("Y el Icono??");
    }
    public static void main(String [] args) {
        new Icono();
    }

}
