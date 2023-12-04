package ejemplos.interfaces;
import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
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