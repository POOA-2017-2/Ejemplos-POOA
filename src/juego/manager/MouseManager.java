package juego.manager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class MouseManager extends MouseAdapter{

	private boolean left;
	private boolean right;
	private boolean fire;
	
	public MouseManager() {
		left=false;
		right=false;
		fire=false;
	}
	
	
	public void mousePressed(MouseEvent e){
		mover(e);
	}
	
	private void mover(MouseEvent e){
		
		String action=((JButton)e.getSource()).getActionCommand();
		
		left=false;
		right=false;
		fire=false;
		
		switch(action){
			case "left":
				left=true;
				break;
			case "right":
				right=true;
				break;
			case "fire":
				fire=true;
				break;
		}
	}

	public void mouseReleased(MouseEvent e){
		left=false;
		right=false;
		
	}
	
	public void mouseEntered(MouseEvent e){
		//mover(e);
	}
	
	public void mouseExited(MouseEvent e){
		left=false;
		right=false;
	}


	public boolean isLeft() {
		return left;
	}


	public void setLeft(boolean left) {
		this.left = left;
	}


	public boolean isRight() {
		return right;
	}


	public void setRight(boolean right) {
		this.right = right;
	}


	public boolean isFire() {
		return fire;
	}


	public void setFire(boolean fire) {
		this.fire = fire;
	}
	
	
	
	
	
	
	
	

}
