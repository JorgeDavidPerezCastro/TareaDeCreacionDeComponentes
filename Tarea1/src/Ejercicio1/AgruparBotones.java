package Ejercicio1;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

public class AgruparBotones extends JFrame implements ActionListener {

	private final static String ACEPTAR = "Aceptar";
	private final static String CANCELAR = "Cancelar";
	
    public AgruparBotones(String titulo) {
        //CreacioÌn de los RadioButtons
        JRadioButton birdButton = new JRadioButton("Pajarito");
        birdButton.setMnemonic(KeyEvent.VK_B);
        birdButton.setActionCommand("bird");
        birdButton.setSelected(true);

        JRadioButton catButton = new JRadioButton("Gatito");
        catButton.setMnemonic(KeyEvent.VK_C);
        catButton.setActionCommand("cat");

        JRadioButton dogButton = new JRadioButton("Perrito");
        dogButton.setMnemonic(KeyEvent.VK_D);
        dogButton.setActionCommand("dog");

        JRadioButton rabbitButton = new JRadioButton("Conejito");
        rabbitButton.setMnemonic(KeyEvent.VK_R);
        rabbitButton.setActionCommand("rabbit");

        JRadioButton pigButton = new JRadioButton("Cerdito");
        pigButton.setMnemonic(KeyEvent.VK_P);
        pigButton.setActionCommand("pig");

        ButtonGroup btgAnimalitos = new ButtonGroup();

        btgAnimalitos.add(birdButton);
        btgAnimalitos.add(catButton);
        btgAnimalitos.add(dogButton);
        btgAnimalitos.add(rabbitButton);
        btgAnimalitos.add(pigButton);

        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(0,1));
        radioPanel.add(birdButton);
        radioPanel.add(catButton);
        radioPanel.add(dogButton);
        radioPanel.add(rabbitButton);
        radioPanel.add(pigButton);
        radioPanel.setBackground(Color.RED);

        JLabel picture = new JLabel(new ImageIcon("src\\Ejercicio1/loro.png"));

        JPanel SubPanel1 = new JPanel();
        SubPanel1.setLayout(new GridLayout(1,2));
        SubPanel1.add(radioPanel);
        SubPanel1.add(picture);
        SubPanel1.setBackground(Color.BLUE);
       
        JButton Aceptar = new JButton("Aceptar");
        JButton Cancelar = new JButton("Cancelar");
        Aceptar.setActionCommand(ACEPTAR);
        Cancelar.setActionCommand(CANCELAR);
        Aceptar.addActionListener(this);
        Cancelar.addActionListener(this);
        
        JPanel SubPanel2 = new JPanel();
        SubPanel2.setLayout(null);
        
        Aceptar.setBounds(15, 30, 100, 30);
        Cancelar.setBounds(215, 30, 100, 30);
        
        SubPanel2.add(Aceptar);
        SubPanel2.add(Cancelar);
        
        GridLayout distGrid = new GridLayout(2,1);
        getContentPane().setLayout(distGrid);
        getContentPane().add(SubPanel1);
        getContentPane().add(SubPanel2);      

        pack();

        setTitle(titulo);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Evento producido por " + e.getActionCommand());
        String comando = e.getActionCommand();
        if(comando.equals(ACEPTAR)) {
        	JOptionPane.showMessageDialog(this, "Se presiono el boton Aceptar", "Calculo de Impuestos", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(comando.equals(CANCELAR)) {
        	JOptionPane.showMessageDialog(this, "Se presiono el boton Cancelar", "Calculo de Impuestos", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main (String[] args) {
        WindowListener l = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };

        JFrame frame = new AgruparBotones("Curso de Java: Agrupar Botones");
        frame.addWindowListener(l);

        frame.pack();
        frame.setVisible(true);
    }
}