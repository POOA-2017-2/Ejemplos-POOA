package juego.manager;

import java.util.HashMap;
import java.util.Map;

import juego.vista.EstadoJuego;

public class StateManager {

	private static final StateManager sm=new StateManager();
	private Map<EstadoJuego, Estado> estados=new HashMap<EstadoJuego, Estado>();
	private Estado currentEstado;
	
	private StateManager() {
		// TODO Auto-generated constructor stub
	}

	public void addEstado(Estado estado){
		estados.put(estado.getState(), estado);
		if(currentEstado==null){
			currentEstado=estado;
			currentEstado.show(); // <--- cambie esto
			//currentEstado.init();
		}
	}
	
	public void setCurrentEstado(EstadoJuego key){
		Estado aux=estados.get(key);
		if(aux==null){
			System.err.println("ERROR");
			return;
		}
		currentEstado.exit();
		aux.show();
		currentEstado=aux;
	}
	
	public static StateManager getInstance(){
		return sm;
	}

	
	public Map<EstadoJuego, Estado> getEstados() {
		return estados;
	}

	public Estado getCurrentEstado() {
		return currentEstado;
	}
	
	
}
