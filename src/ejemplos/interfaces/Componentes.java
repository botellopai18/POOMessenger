package ejemplos.interfaces;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.ButtonGroup;
import java.awt.Container;
import java.awt.FlowLayout;

public class Componentes {
    public static void main(String [] args) {
        JFrame marco = new JFrame("Componenetes");
        Container contenedor = marco.getContentPane();
        contenedor.setLayout(new FlowLayout());
        // botOn
        JButton b1 = new JButton("Boton");
        // etiqueta
        JLabel etiqueta = new JLabel("Nombre");
        // campo texto
        JTextField campoTexto = new JTextField("Campo de texto");
        // Area de texto
        JTextArea areaTexto = new JTextArea("Area de texto");
        // Botones tipo radio
        JRadioButton[] botonesRadio = new JRadioButton[3];
        ButtonGroup grupo = new ButtonGroup();
        botonesRadio[0] = new JRadioButton("Opcion 1");
        botonesRadio[1] = new JRadioButton("Opcion 2");
        botonesRadio[2] = new JRadioButton("Opcion 3");
        for (int i = 0; i < 3; i++) {
            grupo.add(botonesRadio[i]);
        }
        // Caja de selecciOn
        JCheckBox caja = new JCheckBox("Caja de selección");
        // Combo box
        String [] a = {"uno", "dos", "tres"};
        JComboBox<String> jcb = new JComboBox<>(a);
        // Lista
        String [] d = {"one", "two", "three", "four"};
        JList<String> jl = new JList<>(d);
        // Slider
        JSlider js = new JSlider(-5,5);
        // Spinner
        JSpinner jsp = new JSpinner();
        // Paleta de colores
        JColorChooser jcc = new JColorChooser();
        // Arbol
        JTree jt = new JTree();
        // Barra de progreso
        JProgressBar jpb = new JProgressBar();
        jpb.setValue(25);
        jpb.setStringPainted(true);
        // Se agregan los componentes al contenedor
        contenedor.add(etiqueta);
        contenedor.add(b1);
        contenedor.add(campoTexto);
        contenedor.add(areaTexto);
        contenedor.add(caja);
        for (int i = 0; i < 3; i++) {
            contenedor.add(botonesRadio[i]);
        }
        contenedor.add(jcb);
        contenedor.add(jl);
        contenedor.add(js);
        contenedor.add(jsp);
        contenedor.add(jcc);
        contenedor.add(jt);
        contenedor.add(jpb);
        marco.setSize(500,500);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}