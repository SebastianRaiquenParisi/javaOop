package par1.cerveceria.entidades;

public class Barril extends Contenedor{
	
	private static final int CONTENIDO_INICIAL = 30000;
	private static final int CANTIDAD_MINIMA = 750;
	
	private int contenido;
	
	public Barril(Sabor sabor) {
		super(sabor);
		this.contenido = CONTENIDO_INICIAL;
	}

	@Override
	protected EnvaseCerveza extraer() {
		return null;
	}
	
	protected EnvaseCerveza extraer(Medida medida) {
		EnvaseCerveza garrafa=null;
		
		if(sePuedeServir(medida)) {
			contenido-=medida.getCantidad();
			garrafa = new Garrafa(getSabor(), medida);
		}
		
		return garrafa;
		
	}

	protected boolean sePuedeServir(Medida medida) {
		return medida.getCantidad() <= this.contenido;
	}
	
	@Override
	public boolean estaVacio() {
		return this.contenido < CANTIDAD_MINIMA;
	}
	
}
