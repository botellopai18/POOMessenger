package ejemplos.interfaces;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
class PanelConScroll {
    public static void main(String [] args) {
        JFrame marco = new JFrame("Ej JScrollPanel");
        ImageIcon ii = new ImageIcon("resources/dragon.jpeg");
        JLabel etiqueta = new JLabel(ii);
        JScrollPane scrollPane = new JScrollPane(etiqueta);
        marco.getContentPane().add(scrollPane);
        marco.pack();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
        //marco.setSize(300, 200);
    }
}
