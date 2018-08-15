package unidad5_socket.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import unidad5_socket.controlador.ClienteHilo;
import unidad5_socket.modelo.Persona;

import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Servidor extends JFrame implements Runnable{

	private JPanel contentPane;
	private JTextArea txtMensajes;
	private JTextField txtMensaje;
	private Socket cliente;
	private ArrayList<Socket> listaClientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Servidor frame = new Servidor();
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
	public Servidor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		txtMensajes = new JTextArea();
		contentPane.add(txtMensajes, BorderLayout.CENTER);
		
		JPanel pnlMensajes = new JPanel();
		contentPane.add(pnlMensajes, BorderLayout.SOUTH);
		pnlMensajes.setLayout(new BoxLayout(pnlMensajes, BoxLayout.X_AXIS));
		
		txtMensaje = new JTextField();
		pnlMensajes.add(txtMensaje);
		txtMensaje.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name="Servidor";
					String mensaje=txtMensaje.getText();
					Persona p= new Persona(name, mensaje);
					
					for(Socket item:listaClientes){
						ObjectOutputStream output=new ObjectOutputStream(item.getOutputStream());
						output.writeObject(p);
					}
				
					txtMensajes.append("\n Servidor: "+mensaje);
					txtMensaje.setText("");
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		pnlMensajes.add(btnEnviar);

		listaClientes=new ArrayList<Socket>();
		Thread t=new Thread(this);
		t.start();
	}
	
	

	public JTextArea getTxtMensajes() {
		return txtMensajes;
	}

	public void setTxtMensajes(JTextArea txtMensajes) {
		this.txtMensajes = txtMensajes;
	}

	public void run() {
		try {
			
			ServerSocket servidor=new ServerSocket(8000);
			while(true){
				
				cliente=servidor.accept();
				listaClientes.add(cliente);
				ClienteHilo ch=new ClienteHilo(cliente, this,listaClientes);
				Thread t=new Thread(ch);
				t.start();
			}

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	
}
