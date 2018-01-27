package unidad2_interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Temperatura extends JFrame {

	private JPanel contentPane;
	private JTextField txtFahrenheit;
	private JTextField txtCentigrados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Temperatura frame = new Temperatura();
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
	public Temperatura() {
		setTitle("Conversor Temperatura");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel pnlFahrenheit = new JPanel();
		pnlFahrenheit.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3), "Fahrenheit", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(pnlFahrenheit);
		pnlFahrenheit.setLayout(new BoxLayout(pnlFahrenheit, BoxLayout.Y_AXIS));
		
		final JSlider Fahrenheit = new JSlider();
		Fahrenheit.setForeground(Color.BLACK);
		Fahrenheit.setBackground(Color.RED);
		final JSlider Centigrados = new JSlider();
		Centigrados.setValue(10);
		txtFahrenheit = new JTextField();
		txtFahrenheit.setHorizontalAlignment(SwingConstants.CENTER);
		txtFahrenheit.setText("50");
		txtCentigrados = new JTextField();
		txtCentigrados.setHorizontalAlignment(SwingConstants.CENTER);
		txtCentigrados.setText("10");
		

		
		Fahrenheit.setPaintTicks(true);
		Fahrenheit.setPaintLabels(true);
		Fahrenheit.setMajorTickSpacing(10);
		Fahrenheit.setMaximum(120);
		Fahrenheit.setOrientation(SwingConstants.VERTICAL);
		pnlFahrenheit.add(Fahrenheit);
		
		
		txtFahrenheit.setEnabled(false);
		pnlFahrenheit.add(txtFahrenheit);
		txtFahrenheit.setColumns(10);
		
		JPanel pnlCentigrados = new JPanel();
		pnlCentigrados.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3), "Centigrados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pnlCentigrados);
		pnlCentigrados.setLayout(new BoxLayout(pnlCentigrados, BoxLayout.Y_AXIS));
		
	
		Centigrados.setEnabled(false);
		Centigrados.setPaintTicks(true);
		Centigrados.setPaintLabels(true);
		Centigrados.setMajorTickSpacing(10);
		Centigrados.setMaximum(60);
		Centigrados.setMinimum(-20);
		Centigrados.setOrientation(SwingConstants.VERTICAL);
		pnlCentigrados.add(Centigrados);
		
		
		txtCentigrados.setEnabled(false);
		pnlCentigrados.add(txtCentigrados);
		txtCentigrados.setColumns(10);
		
		Fahrenheit.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				double resultado=(Fahrenheit.getValue()-32)/1.8;
				Centigrados.setValue((int)resultado);
				txtFahrenheit.setText(String.valueOf(Fahrenheit.getValue()));
				txtCentigrados.setText(String.valueOf(resultado).format("%.2f", resultado));
			}
		});
	}

}
