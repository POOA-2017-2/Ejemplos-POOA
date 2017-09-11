package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Formulario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JPasswordField txtPassword;
	private JRadioButton rdbtnHombre;
	private JRadioButton rdbtnMujer;
	private JCheckBox checkBox;
	private JPanel panelDatos;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario frame = new Formulario();
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
	public Formulario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelBotones = new JPanel();
		contentPane.add(panelBotones, BorderLayout.SOUTH);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cadena="El usuario "+txtNombre.getText()+" esta de acuerdo";
				if(txtNombre.getText().isEmpty() || txtPassword.getText().isEmpty()){
					JOptionPane.showMessageDialog(panelDatos, "Debe llenar los datos nombre y password.", "Mensaje", JOptionPane.ERROR_MESSAGE);
				}
				else if(checkBox.isSelected()){
					JOptionPane.showMessageDialog(panelDatos, cadena, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
			
			
		});
		panelBotones.add(btnEnviar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNombre.setText("");
				txtPassword.setText("");
				rdbtnHombre.setSelected(true);
				rdbtnMujer.setSelected(false);
				checkBox.setSelected(false);
				
			}
		});
		panelBotones.add(btnLimpiar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					int opcion=JOptionPane.showConfirmDialog(panelDatos, "Seguro que te deseas salir","Titulo",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
					if(opcion==JOptionPane.YES_OPTION){
						System.exit(0);
					}
			}
		});
		panelBotones.add(btnSalir);
		
		panelDatos = new JPanel();
		contentPane.add(panelDatos, BorderLayout.CENTER);
		panelDatos.setLayout(new GridLayout(4, 0, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre:");
		panelDatos.add(lblNombre);
		
		txtNombre = new JTextField();
		panelDatos.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		panelDatos.add(lblPassword);
		
		txtPassword = new JPasswordField();
		panelDatos.add(txtPassword);
		
		JLabel lblGnero = new JLabel("Género:");
		panelDatos.add(lblGnero);
		
		JPanel panelGenero = new JPanel();
		panelDatos.add(panelGenero);
		
		rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setSelected(true);
		panelGenero.add(rdbtnHombre);
		
		rdbtnMujer = new JRadioButton("Mujer");
		panelGenero.add(rdbtnMujer);
		
		ButtonGroup grupo= new ButtonGroup();
		grupo.add(rdbtnHombre);
		grupo.add(rdbtnMujer);
		
		JLabel lblEstasDeAcuerdo = new JLabel("Estas de acuerdo con los terminos?");
		panelDatos.add(lblEstasDeAcuerdo);
		
		checkBox = new JCheckBox("");
		panelDatos.add(checkBox);
	}

}
