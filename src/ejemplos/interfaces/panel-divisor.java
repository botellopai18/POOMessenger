package ejemplos.interfaces;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

class PanelDivisor{
    public static void main(String [] args) {
        JFrame marco = new JFrame("Ej JSplitPanel");
        ImageIcon ii = new ImageIcon("resources/dragon.jpeg");
        JScrollPane panelDeslizable = new JScrollPane(new JLabel(ii));
        JPanel panellDeEtiqueta = new JPanel();
        JLabel etiqueta = new JLabel("Papel Tapiz");
        panellDeEtiqueta.add(etiqueta);
        JSplitPane panelDivisor = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,panelDeslizable, panellDeEtiqueta);
        panelDivisor.setOneTouchExpandable(true);
        marco.getContentPane().add(panelDivisor);
        marco.pack();
        panelDivisor.setDividerLocation(0.5d);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}
