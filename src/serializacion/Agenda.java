package serializacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class Agenda extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	DefaultListModel<Persona> modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agenda frame = new Agenda();
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
	public Agenda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JPanel pnlDatos = new JPanel();
		pnlDatos.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3), "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pnlDatos);
		pnlDatos.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlCentro = new JPanel();
		pnlDatos.add(pnlCentro, BorderLayout.CENTER);
		pnlCentro.setLayout(new GridLayout(5, 2, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre:");
		pnlCentro.add(lblNombre);
		
		txtNombre = new JTextField();
		pnlCentro.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad:");
		pnlCentro.add(lblEdad);
		
		txtEdad = new JTextField();
		pnlCentro.add(txtEdad);
		txtEdad.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		pnlCentro.add(lblTelefono);
		
		txtTelefono = new JTextField();
		pnlCentro.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblCorreo = new JLabel("Correo:");
		pnlCentro.add(lblCorreo);
		
		txtCorreo = new JTextField();
		pnlCentro.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		JLabel lblGenero = new JLabel("Genero:");
		pnlCentro.add(lblGenero);
		
		JPanel pnlGenero = new JPanel();
		pnlCentro.add(pnlGenero);
		
		
		ButtonGroup grupo = new ButtonGroup();
		
		final JRadioButton rdbtnHombre = new JRadioButton("Hombre");
		pnlGenero.add(rdbtnHombre);
		
		JRadioButton rdbtnMujer = new JRadioButton("Mujer");
		pnlGenero.add(rdbtnMujer);
		
		grupo.add(rdbtnHombre);
		grupo.add(rdbtnMujer);
		
		
		JPanel pnlBotones = new JPanel();
		pnlDatos.add(pnlBotones, BorderLayout.SOUTH);
		
		JButton btnNuevo = new JButton("Nuevo");
		pnlBotones.add(btnNuevo);
		
		JButton btnAgregar = new JButton("Agregar");

		pnlBotones.add(btnAgregar);
		
		JButton btnEditar = new JButton("Editar");
		pnlBotones.add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");
		pnlBotones.add(btnEliminar);
		
		JPanel pnlContactos = new JPanel();
		pnlContactos.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3), "Contactos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pnlContactos);
		pnlContactos.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		pnlContactos.add(scrollPane);
		
		final JList list = new JList();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int index=list.getSelectedIndex();
				Persona p=modelo.get(index);
				txtNombre.setText(p.getNombre());
				//JOptionPane.showMessageDialog(contentPane, modelo.get(index).toString());
			}
		});
		scrollPane.setViewportView(list);
		
		
		 modelo= new DefaultListModel<Persona>();
		 try {
			FileInputStream file= new FileInputStream("contactos.txt");
			ObjectInputStream ois=new ObjectInputStream(file);
			modelo=(DefaultListModel<Persona>) ois.readObject();
			file.close();
			ois.close();
			
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} 
		/*
		Persona juan =new Persona("Juan", 20, Genero.HOMBRE, "123123123", "asdasdasd");
		Persona juan2 =new Persona("Juan", 20, Genero.HOMBRE, "123123123", "asdasdasd");
		modelo.addElement(juan);
		modelo.addElement(juan2);
		Persona maria =new Persona("Maria", 20, Genero.HOMBRE, "123123123", "asdasdasd");
		modelo.set(1, maria);
		*/
		list.setModel(modelo);
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre=txtNombre.getText();
				int edad=Integer.parseInt(txtEdad.getText());
				Genero genero=rdbtnHombre.isSelected()?Genero.HOMBRE:Genero.MUJER;
				String telefono=txtTelefono.getText();
				String correo=txtCorreo.getText();
				Persona p= new Persona(nombre, edad, genero, telefono, correo);
				modelo.addElement(p);
				
				try {
					FileOutputStream file= new FileOutputStream("contactos.txt");
					ObjectOutputStream oos= new ObjectOutputStream(file);
					oos.writeObject(modelo);
					file.close();
					oos.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

	}

}
