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
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 9));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 2, 0, 0));
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setToolTipText("CLICK");
		btnNewButton.setBackground(SystemColor.windowText);
		btnNewButton.setForeground(UIManager.getColor("Button.select"));
		
		/////////////////////////////////
		btnNewButton.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							txtHola.setText("CLICK");
					}
				}
		);
		
		////////////////////////
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		contentPane.add(btnNewButton_2);
		
		txtHola = new JTextField();
		txtHola.setText("Hola");
		contentPane.add(txtHola);
		txtHola.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("New button");
		contentPane.add(btnNewButton_3);
	}
}
