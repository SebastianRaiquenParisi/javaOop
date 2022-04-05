/**
 * 
 */
package ort.tp1.parcial1.entidades;

/**
 * Un producto
 */
public abstract class Producto implements Mostrable{

	private static final float DESCUENTO_POR_MAYOR=0.8f;
	private FamiliaProducto familiaProducto;
	private String nombre;
	private float precio;

	/**
	 * Constructor del pedido, recibe sus atributos como parámetro
	 * 
	 * @param familiaProducto {@link FamiliaProducto}
	 * @param nombre          {@link String} con el nombre
	 * @param precio          {@link Float} con su precio
	 */
	public Producto(FamiliaProducto familiaProducto, String nombre, float precio) {
		this.setFamiliaProducto(familiaProducto);
		this.setNombre(nombre);
		this.setPrecio(precio);
	}
	
	public float getPrecio() {
		return precio;
	}
	
	public FamiliaProducto getFamiliaProducto() {
		return familiaProducto;
	}

	private void setFamiliaProducto(FamiliaProducto familiaProducto) {
		this.familiaProducto = familiaProducto;
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	public boolean equals(Producto producto) {
		return producto.getNombre().equals(this.getNombre());
	}

	private void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getPrecio(TipoPedido tipoPedido) {
		float precioFinal = getPrecio();
		if(tipoPedido.equals(TipoPedido.POR_MAYOR)) {
			precioFinal *= DESCUENTO_POR_MAYOR;
		}
		return precioFinal;
	}
	

}
