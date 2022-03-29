package par1.cerveceria.entidades;

public enum Medida {
	GRANDE(3000,1), MEDIANA(1500,1.1), CHICA(750,1.2);
	
	private int cantidad;
	private double recargo;
	
	Medida(int cantidad, double recargo){
		this.cantidad = cantidad;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	public double getRecargo() {
		return recargo;
	}
}
