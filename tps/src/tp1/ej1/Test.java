package tp1.ej1;

public class Test {

	public static void main(String[] args) {
		Grupo grupo = new Grupo("Grupo 3");
		grupo.agregarIntegrante("Seba");
		grupo.agregarIntegrante("Jorge");
		grupo.agregarIntegrante("Ricardo");
		System.out.println(grupo.obtenerIntegrante(0));
		System.out.println(grupo.obtenerIntegrante(1));
		
		grupo.removerIntegrante("Jorge");
		grupo.mostrarIntegrantes();
	}

}
