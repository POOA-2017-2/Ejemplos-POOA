package hilos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FiguraInterfaz extends JFrame {

	private JPanel contentPane;
	private Color c;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FiguraInterfaz frame = new FiguraInterfaz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FiguraInterfaz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlDatos = new JPanel();
		contentPane.add(pnlDatos, BorderLayout.NORTH);
		
		JLabel lblFigura = new JLabel("Figura:");
		pnlDatos.add(lblFigura);
		
		final JComboBox<String>comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Cuadrado", "Circulo", "Triangulo"}));
		pnlDatos.add(comboBox);
		
		
		JLabel lblTamao = new JLabel("Tamaño:");
		pnlDatos.add(lblTamao);
		
		final JSpinner spinner = new JSpinner();
		pnlDatos.add(spinner);
		SpinnerNumberModel modelo= new SpinnerNumberModel(5, 5, 30, 1);
		spinner.setModel(modelo);
		
		JLabel lblColor = new JLabel("Color:");
		pnlDatos.add(lblColor);
		
		final JLabel lblTestColor = new JLabel("   ");
		pnlDatos.add(lblTestColor);
		c=Color.red;
		lblTestColor.setBackground(c);
		lblTestColor.setOpaque(true);
		
		JButton btnColor = new JButton("Color");
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JColorChooser seleccion= new JColorChooser();
				c=seleccion.showDialog(contentPane, "Seleccione Color", Color.red);
				if(c!=null){
					lblTestColor.setBackground(c);
					lblTestColor.setOpaque(true);
				}

			}
			
		});
		pnlDatos.add(btnColor);
		
		JButton btnAgregar = new JButton("Agregar");
	
		pnlDatos.add(btnAgregar);
		
		final PanelFiguras pnlFiguras=new PanelFiguras();
		contentPane.add(pnlFiguras, BorderLayout.CENTER);
		
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random rnd=new Random();
				int size=(Integer) spinner.getValue();
				int x=(int) (rnd.nextDouble() * (pnlFiguras.getWidth()-size) + 0);
				int y=(int) (rnd.nextDouble() * (pnlFiguras.getHeight()-size) + 0);

				int dx=(int) (rnd.nextDouble() * (15-size) + 1);
				int dy=(int) (rnd.nextDouble() * (15-size) + 1);
				String forma=(String)comboBox.getSelectedItem();
				
				Figura f=new Figura(x, y, dx, dy, c, size, forma);
				pnlFiguras.addFigura(f);
			}
		});
	}
	
}
