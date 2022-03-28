package tp1.ej1;

import java.util.ArrayList;

public class Grupo {
	private String nombre;
	private ArrayList<String> integrantes;
	public Grupo(String nombre) {
		super();
		this.setNombre(nombre);
		this.integrantes = new ArrayList<String>();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public ArrayList<String> getIntegrantes() {
		return integrantes;
	}
	
	public int getCantidadIntegrantes() {
		return integrantes.size();
	}
	
	public String buscarIntegrante(String nombreIntegrante) {
		String integranteEncontrado = null;
		if(obtenerPosicionIntegrante(nombreIntegrante)!=-1) {
			integranteEncontrado=nombreIntegrante;
		}
		return integranteEncontrado;
	}
	
	public void agregarIntegrante(String nombreIntegrante) {
		if(buscarIntegrante(nombreIntegrante)==null) {
			integrantes.add(nombreIntegrante);
		}
	}
	
	public int obtenerPosicionIntegrante(String nombreIntegrante) {
		int pos = -1;
		int i = 0;
		while(i<integrantes.size() && pos == -1) {
			if(integrantes.get(i).equals(nombreIntegrante)) {
				pos =i;
			}
			i++;
		}
		return pos;
	}
	
	public String obtenerIntegrante(int pos) {
		String integranteObtenido = null;
		if(pos < getCantidadIntegrantes()) {
			integranteObtenido=integrantes.get(pos);
		}
		return integranteObtenido;
	}
}
