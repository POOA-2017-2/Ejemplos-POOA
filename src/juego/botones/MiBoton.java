package juego.botones;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import javax.swing.ButtonModel;
import javax.swing.JButton;

import juego.Game;

public class MiBoton extends JButton{

	String text;
	
	public MiBoton(Game juego, String text) {
		super(text);
		setContentAreaFilled(false);
		setOpaque(false);
		setBorderPainted(false);
		setRolloverEnabled(true);
		this.text=text;
		
		//addActionListener(new AccionBoton(juego));
	}

	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		ButtonModel modelo=getModel();
		FontMetrics fm=g.getFontMetrics();
		Rectangle2D r2d=fm.getStringBounds(text,g);
		int x=(int) (getWidth()/2-r2d.getWidth()/2);
		int y=(int) (getHeight()/2+r2d.getHeight()/2);
		g.setColor(Color.white);
	
		if(modelo.isArmed() && modelo.isPressed()){
			g.setColor(Color.white.darker());
			g.fillRoundRect(20,5,(int)((x+r2d.getWidth())), (int)(5+r2d.getHeight()), 20,20);
			g.setColor(Color.yellow.brighter());
			g.drawString(text, x, y);
			
		}
		else if(modelo.isRollover()){
			g.setColor(Color.red);
			g.drawString(">", x-15, y);
			g.drawString("<",(int) (x+r2d.getWidth()+5), y);
			g.drawString(text, x, y);
		}
		
		g.drawString(text, x, y);
		
		
	}
	
}
