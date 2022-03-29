package par1.cerveceria.entidades;

public class Garrafa extends EnvaseCerveza{

	private Medida medida;
	
	public Garrafa(Sabor sabor) {
		super(sabor);
		this.medida=Medida.MEDIANA;
	}
	
	public Garrafa(Sabor sabor, Medida medida) {
		super(sabor);
		this.medida=medida;
	}

	@Override
	protected void setPrecioVenta(double precio) {
		super.precioVenta=this.calcularPrecioPorMedida(precio, this.getMedida());
		
	}
	private double calcularPrecioPorMedida(double precioLitro, Medida medida) {
		double precio = 160;
		
		//reemplaza al switch, por utilizar el enum como clase
		precio = (medida.getCantidad()/1000) * precioLitro * medida.getRecargo();
		
		return precio;
	}
	
	private Medida getMedida() {
		return medida;
	}

	@Override
	public String getTipo() {
		return "Garrafa";
	}

}
