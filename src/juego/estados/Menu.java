package juego.estados;

import java.awt.CardLayout;
import java.awt.Graphics;

import juego.Game;
import juego.paneles.MenuPanel;

public class Menu extends Estado{

	private MenuPanel pnlMenu;
	private Game juego;
	public Menu(Game juego) {
		// TODO Auto-generated constructor stub
		super(EstadoJuego.MENU);
		this.juego=juego;
		init();
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		pnlMenu=new MenuPanel(juego);
		juego.getVentana().getPnlVista().add(pnlMenu, "Menu");
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		CardLayout c=(CardLayout) juego.getVentana().getPnlVista().getLayout();
		c.show(juego.getVentana().getPnlVista(), "Menu");
		juego.getVentana().setVisible(true);
	}

}
