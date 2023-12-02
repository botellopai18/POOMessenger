import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
class Marco {
    public static void main(String[] args) {
        JFrame marco = new JFrame("Mi primer marco");
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}
class Marco2 {
    public static void main(String[] args) {
        JFrame marco = new JFrame("Mi segundo marco");
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
        marco.setSize(300, 200);
    }
}

class PanelConScroll {
    public static void main(String [] args) {
        JFrame marco = new JFrame("Ej JScrollPanel");
        ImageIcon ii = new ImageIcon("dragon.jpeg");
        JLabel etiqueta = new JLabel(ii);
        JScrollPane scrollPane = new JScrollPane(etiqueta);
        marco.getContentPane().add(scrollPane);
        marco.pack();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
        //marco.setSize(300, 200);
    }
}

class PanelDivisor{
    public static void main(String [] args) {
        JFrame marco = new JFrame("Ej JSplitPanel");
        ImageIcon ii = new ImageIcon("dragon.jpg");
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


class Icono extends JFrame {
    public Icono () {
        ImageIcon icono = new ImageIcon("dragon.jpeg");
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


class MarcoInterno {
    public static void main(String[] args) {
        JFrame marco = new JFrame("Marco externo");
        JDesktopPane dp = new JDesktopPane();
        marco.getContentPane().add(dp);
        // JInternalFrame (Nombre, dimensionar, cerrar, maximimar, minimizar)
        JInternalFrame interno = new JInternalFrame("Marco interno", true, true, true, true);
        interno.setSize(200,200);
        interno.setVisible(true);
        dp.add(interno);
        marco.setSize(500,500);
        marco.setVisible(true);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}