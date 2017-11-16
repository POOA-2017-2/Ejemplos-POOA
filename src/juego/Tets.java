package juego;

import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.newdawn.easyogg.OggClip;

import juego.manager.AudioManager;
import juego.vista.Game;

public class Tets {

	public static void main(String args[]){
		Game ventana=new Game(384, 225,"Hola");
		ventana.start();
		
		AudioManager manager=new AudioManager("/sonidos/sonido3.wav");
		manager.loop();
		
		/*
		try {
			Clip sonido=AudioSystem.getClip();
			sonido.open(AudioSystem.getAudioInputStream(Tets.class.getResourceAsStream("/sonidos/sonido3.wav")));
			sonido.loop(Clip.LOOP_CONTINUOUSLY);
			
	
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			OggClip sonido2=new OggClip(Tets.class.getResourceAsStream("/sonidos/sonido.ogg"));
			sonido2.loop();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
	}

}
