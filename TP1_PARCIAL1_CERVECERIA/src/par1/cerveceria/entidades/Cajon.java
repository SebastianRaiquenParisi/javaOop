package par1.cerveceria.entidades;

public class Cajon extends Contenedor{

	private static final int CANTIDAD_BOTELLAS = 12;
	private int cantBotellas;
	
	public Cajon(Sabor sabor) {
		super(sabor);
		this.cantBotellas=CANTIDAD_BOTELLAS;
	}

	@Override
	protected EnvaseCerveza extraer() {
		EnvaseCerveza cerveza = null;
		if(!this.estaVacio()) {

			this.cantBotellas--;
			
			cerveza= new Botella(getSabor());
		}
		return cerveza;
	}

	@Override
	public boolean estaVacio() {
		// TODO Auto-generated method stub
		return this.cantBotellas==0;
	}

}
