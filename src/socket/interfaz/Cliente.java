package socket.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import socket.controlador.ClienteControlador;
import socket.modelo.Persona;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class Cliente extends JFrame implements Runnable {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtMensaje;
	private JTextArea txtMensajes;
	private Socket cliente;
	private ObjectInputStream input;
	

	public JTextArea getTxtMensajes() {
		return txtMensajes;
	}

	public void setTxtMensajes(JTextArea txtMensajes) {
		this.txtMensajes = txtMensajes;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtMensaje() {
		return txtMensaje;
	}

	public void setTxtMensaje(JTextField txtMensaje) {
		this.txtMensaje = txtMensaje;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente frame = new Cliente();
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
	public Cliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlDatos = new JPanel();
		contentPane.add(pnlDatos, BorderLayout.NORTH);
		
		JLabel lblNombre = new JLabel("Nombre:");
		pnlDatos.add(lblNombre);
		
		txtNombre = new JTextField();
		pnlDatos.add(txtNombre);
		txtNombre.setColumns(10);
		
		JPanel pnlEscribir = new JPanel();
		contentPane.add(pnlEscribir, BorderLayout.SOUTH);
		pnlEscribir.setLayout(new BoxLayout(pnlEscribir, BoxLayout.X_AXIS));
		
		txtMensaje = new JTextField();
		pnlEscribir.add(txtMensaje);
		txtMensaje.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar");
		try {
			cliente=new  Socket("127.0.0.1", 8000);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ClienteControlador cc=new ClienteControlador(this,cliente);
		btnEnviar.addActionListener(cc);
		pnlEscribir.add(btnEnviar);
		
		txtMensajes = new JTextArea();
		contentPane.add(txtMensajes, BorderLayout.CENTER);
	
		Thread t=new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		 while(true){
			 try {
				input=new ObjectInputStream(cliente.getInputStream());
				Persona p=(Persona) input.readObject();
				txtMensajes.append("\n"+p.getNombre()+": "+p.getMensaje());
			 } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		
	}

}
