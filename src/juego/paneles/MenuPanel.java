package juego.paneles;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import juego.Game;
import juego.botones.MiBoton;
import juego.estados.EstadoJuego;
import juego.manager.StateManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPanel extends JPanel {

	private MiBoton btnNew;
	private MiBoton btnAbout;
	private MiBoton btnQuit;
	private MiBoton btnOptions;
	
	public MenuPanel(Game juego) {
		setBackground(new Color(0, 0, 0));
		setLayout(null);
		
	
		btnOptions=new MiBoton(juego,"Options");
		btnOptions.setBounds(6, 92, 117, 29);
		add(btnOptions);
		
		
		btnNew = new MiBoton(juego,"New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StateManager.getInstance().setCurrentEstado(EstadoJuego.JUEGO);
			}
		});
		btnNew.setBounds(6, 64, 117, 29);
		add(btnNew);

		
		btnAbout = new MiBoton(juego,"About");
		btnAbout.setBounds(6, 120, 117, 29);
		add(btnAbout);
		
		
		btnQuit = new MiBoton(juego,"Quit");
		btnQuit.setBounds(6, 152, 117, 29);
		
		add(btnQuit);
		

		JLabel lblNombreDeMi = new JLabel("NOMBRE DE MI JUEGO");
		lblNombreDeMi.setForeground(new Color(165, 42, 42));
		lblNombreDeMi.setBounds(173, 40, 146, 16);
		add(lblNombreDeMi);
		
		JLabel lblMaximoScore = new JLabel("MAXIMO SCORE: 10000 - JUAN");
		lblMaximoScore.setForeground(new Color(30, 144, 255));
		lblMaximoScore.setBounds(145, 177, 230, 16);
		add(lblMaximoScore);
		
	}

}
