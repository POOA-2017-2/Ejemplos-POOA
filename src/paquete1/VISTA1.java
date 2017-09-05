package paquete1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JSlider;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class VISTA1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtHola;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VISTA1 frame = new VISTA1();
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
	public VISTA1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("primera interfaz");
		contentPane = new Mipanel();
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 2, 0, 0));
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setToolTipText("CLICK");
		btnNewButton.setBackground(SystemColor.windowText);
		btnNewButton.setForeground(UIManager.getColor("Button.select"));
		
		/////////////////////////////////
		txtHola = new JTextField();
		btnNewButton.addActionListener( new Accion(txtHola));
		
		////////////////////////
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		contentPane.add(btnNewButton_2);
		
		
		txtHola.setText("Hola");
		txtHola.setEnabled(false);
		contentPane.add(txtHola);
		txtHola.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setEnabled(false);
		contentPane.add(btnNewButton_3);
		
		JSlider slider = new JSlider();
		contentPane.add(slider);
		
	}
}

class Accion implements ActionListener{
	
	JTextField test;

	public Accion( JTextField test ){
		this.test=test;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		test.setText("CLICK");
	}
	
	
}