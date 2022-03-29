package par1.cerveceria.entidades;

public class Botella extends EnvaseCerveza{

	public Botella(Sabor sabor) {
		super(sabor);
	}

	@Override
	protected void setPrecioVenta(double precio) {
		super.precioVenta = precio;
		
	}

	@Override
	public String getTipo() {
		return this.getClass().getSimpleName();
	}

}
