package Tarea;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.border.TitledBorder;

import serializacion.Genero;
import serializacion.Persona;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;
import javax.swing.event.ListSelectionEvent;

public class Agenda extends JFrame {

	private JPanel contentPane;
	private FileManager<DefaultListModel<Persona>> file=new FileManager<DefaultListModel<Persona>>("test.txt");
	private JTextField txtNombre;
	private JFormattedTextField txtEdad;
	private DefaultListModel<Persona> modelo;
	JRadioButton rdbtnHombre = new JRadioButton("Hombre");
	JRadioButton rdbtnMujer = new JRadioButton("Mujer");
	JFormattedTextField txtCorreo;
	JFormattedTextField txtTelefono;

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
		pnlDatos.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pnlDatos.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3), "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(pnlDatos);
		pnlDatos.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlCentro = new JPanel();
		pnlDatos.add(pnlCentro);
		pnlCentro.setLayout(new GridLayout(5, 0, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre:");
		pnlCentro.add(lblNombre);
		
		txtNombre = new JTextField();
		pnlCentro.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad:");
		pnlCentro.add(lblEdad);
		
		
		try {
			MaskFormatter formatoEdad = new MaskFormatter("##");
			txtEdad = new JFormattedTextField(formatoEdad);
		} catch (ParseException e2) {
			// m
			e2.printStackTrace();
		}
	
		pnlCentro.add(txtEdad);
		txtEdad.setColumns(10);
		
		JLabel lblGenero = new JLabel("Genero:");
		pnlCentro.add(lblGenero);
		
		JPanel pnlGenero = new JPanel();
		pnlCentro.add(pnlGenero);
		pnlGenero.setLayout(new BoxLayout(pnlGenero, BoxLayout.X_AXIS));
		

		rdbtnHombre.setSelected(true);
		pnlGenero.add(rdbtnHombre);
		

		pnlGenero.add(rdbtnMujer);
		
		ButtonGroup grupo=new ButtonGroup();
		grupo.add(rdbtnHombre);
		grupo.add(rdbtnMujer);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		pnlCentro.add(lblTelefono);
		
		
		try {
			MaskFormatter formatTel=new MaskFormatter("(###)###-####");
			txtTelefono = new JFormattedTextField(formatTel);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		pnlCentro.add(txtTelefono);
		
		JLabel lblCorreo = new JLabel("Correo:");
		pnlCentro.add(lblCorreo);
		
		txtCorreo = new JFormattedTextField();
		pnlCentro.add(txtCorreo);
		
		JPanel pnlBotones = new JPanel();
		pnlDatos.add(pnlBotones, BorderLayout.SOUTH);
		
		JButton btnNuevo = new JButton("Nuevo");

		pnlBotones.add(btnNuevo);
		
		final JButton btnAgregar = new JButton("Agregar");

		pnlBotones.add(btnAgregar);
		
		final JButton btnEditar = new JButton("Editar");
		btnEditar.setEnabled(false);
		pnlBotones.add(btnEditar);
		
		final JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		pnlBotones.add(btnEliminar);
		
		JPanel pnlContactos = new JPanel();
		pnlContactos.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3, true), "Contactos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pnlContactos);
		pnlContactos.setLayout(new BorderLayout(0, 0));
		
		JScrollPane pnlLista = new JScrollPane();
		pnlLista.setPreferredSize(new Dimension(250, 300));
		pnlContactos.add(pnlLista);
		pnlLista.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		final JList<Persona> list = new JList<Persona>();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int index=list.getSelectedIndex();
				if(index!=-1)
					datos(modelo.get(index));
				btnAgregar.setEnabled(false);
				btnEditar.setEnabled(true);
				btnEliminar.setEnabled(true);
			}
		});
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		modelo=file.readObject();
		if(modelo==null){
			modelo=new DefaultListModel<Persona>();
		}
		list.setModel(modelo);
		pnlLista.setViewportView(list);
		
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Persona p = crear();
					modelo.addElement(p);
					limpiar();
					file.writeObject(modelo);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					mensaje(e1.getMessage());
					e1.printStackTrace();
				}

			}
		});
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index=list.getSelectedIndex();
				try{
					Persona p=crear();
					modelo.set(index, p);
					file.writeObject(modelo);
				}
				catch(Exception e1){
					mensaje(e1.getMessage());
				}
				
			}
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index=list.getSelectedIndex();
				modelo.remove(index);
				file.writeObject(modelo);
				limpiar();
				btnAgregar.setEnabled(true);
				btnEditar.setEnabled(false);
				btnEliminar.setEnabled(false);
			}
		});
		
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				btnAgregar.setEnabled(true);
				btnEditar.setEnabled(false);
				btnEliminar.setEnabled(false);
			}
		});
	}
	
	
	public Persona crear() throws Exception{
		String nombre=txtNombre.getText();
		if(validarVacio(nombre)) throw new Exception("Nombre debe de tener un valor.");
		if(validarVacio(txtEdad.getText())) throw new Exception("Edad debe de tener un valor.");
		int edad=Integer.parseInt(txtEdad.getText());
		Genero g=rdbtnMujer.isSelected()?Genero.MUJER:Genero.HOMBRE;
		String tel=(String) txtTelefono.getText();
		if(validarVacio(tel)) throw new Exception("Telefono debe de tener un valor.");
		String correo=txtCorreo.getText();
		if(validarVacio(correo)) throw new Exception("Correo debe de tener un valor.");
		Persona p=new Persona(nombre,edad, g, tel, correo);
		return p;
	}
	
	public void limpiar(){
		txtNombre.setText("");
		txtEdad.setText("");
		rdbtnHombre.setSelected(true);
		rdbtnMujer.setSelected(false);
		txtTelefono.setText("");
		txtCorreo.setText("");
		
	}
	
	public void datos(Persona p){
		txtNombre.setText(p.getNombre());
		txtEdad.setText(String.valueOf(p.getEdad()));
		boolean h=p.getGenero()==Genero.HOMBRE?true:false;
		boolean m=p.getGenero()==Genero.MUJER?true:false;
		rdbtnHombre.setSelected(h);
		rdbtnMujer.setSelected(m);
		txtTelefono.setText(p.getTelefono());
		txtCorreo.setText(p.getCorreo());
	}
	
	public boolean validarVacio(String value){
		return value.trim().isEmpty();
	}
	
	public void mensaje(String mensaje){
		JOptionPane.showMessageDialog(contentPane, mensaje,"Error", JOptionPane.ERROR_MESSAGE);
	}

}
