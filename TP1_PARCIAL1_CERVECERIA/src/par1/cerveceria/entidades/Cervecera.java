package par1.cerveceria.entidades;

import java.util.ArrayList;

public class Cervecera {

	private static final double PRECIO_BOTELLITA = 80.0;
	private static final double PRECIO_LITRO = 160.0;
	private ArrayList<Contenedor> deposito;
	private ArrayList<EnvaseCerveza> ventas;

	// DESCOMENTAR Y COMPLETAR
	private Refrigerador<Contenedor> refrigeradorEnvasados;
	private Refrigerador<Contenedor> refrigeradorSueltos;
	
	
	// FALTAN ATRIBUTOS, COMPLETAR

	public Cervecera() {
		this.deposito=new ArrayList<>();
		this.refrigeradorEnvasados = new Refrigerador<>();
		this.refrigeradorEnvasados = new Refrigerador<>();
		this.ventas = new ArrayList<>();
	}
	
	/**
	 * Guarda el barril en el refrigerador que corresponda.
	 * @param sabor
	 */
	public void agregarBarril(Sabor sabor) {
		this.refrigeradorSueltos.add(new Barril(sabor));
	}

	/**
	 * Guarda el cajon en el refrigerador que corresponda
	 * @param sabor
	 */
	public void agregarCajon(Sabor sabor) {
		this.refrigeradorEnvasados.add(new Cajon(sabor));
	}

	/**
	 * Se usa para vender botellitas. No olvides chequear el stock al terminar la venta.
	 * @param sabor
	 * @return
	 */
	public EnvaseCerveza vender(Sabor sabor) {
		
		EnvaseCerveza botellita = null;
		
		Contenedor contenedor = this.refrigeradorEnvasados.buscar(sabor);
		
		if(contenedor != null) {
			botellita = contenedor.extraer();
			botellita.setPrecioVenta(PRECIO_BOTELLITA);
			if(contenedor.estaVacio()) {
				this.deposito.add(contenedor);
				this.refrigeradorEnvasados.remove(contenedor);
				this.ventas.add(botellita);
			}
		}
		
		return botellita;
	}

	/**
	 * Se usa para vender cerveza suelta en garrafas. No olvides chequear el stock al terminar la venta.
	 * @param capacidad
	 * @param sabor
	 * @return
	 */
	public EnvaseCerveza vender(Medida medida, Sabor sabor) {
		EnvaseCerveza garrafa = null;
		
		Contenedor contenedor = this.refrigeradorSueltos.buscar(sabor);
		
		if(contenedor!=null) {
			Barril barril = (Barril) contenedor;
			if(barril.sePuedeServir(medida)) {
				garrafa = barril.extraer(medida);
				garrafa.setPrecioVenta(PRECIO_LITRO);
				ventas.add(garrafa);
			}
			if(contenedor.estaVacio()) {
				this.deposito.add(contenedor);
				this.refrigeradorSueltos.remove(contenedor);;
			}
		}
		return garrafa;
	}

	/**
	 * Lista los sabores disponibles de cerveza suelta o preenvasada
	 */
	public void listarDisponibles() {
		listarEnvasados("envasados", this.refrigeradorEnvasados.getLista());
		listarEnvasados("suelta", this.refrigeradorSueltos.getLista());
		
	}
	
	private void listarEnvasados(String tipo, ArrayList<Contenedor> lista) {
		System.out.printf("Sabores disponibles de cerveza %s \n", tipo);
		for(Contenedor contenedor : lista) {
			System.out.println(contenedor.getSabor());
		}
	}

	public double getPrecioLitro() {
		return PRECIO_LITRO;
	}

	public double getPrecioUnidad() {
		return PRECIO_BOTELLITA;
	}

	/**
	 * Lista la reposicion a partir de lo que haya vacio en deposito.
	 */
	private void listarReposicion() {
		System.out.println("-- Reposiciones --");
		if (deposito.isEmpty()) {
			System.out.println("No hay nada que reponer.");
		} else {
			System.out.println("-- Se debe reponer lo siguiente --");
			for(Contenedor contenedor:deposito) {
				System.out.println(contenedor.getSabor().toString() + "Presentación: " + contenedor.getClass().getSimpleName());
				
			}
		}
	}

	/**
	 * Lista la cantidad de unidades vendidas de cada sabor.
	 * saber cuantos sabores se vendieron de cada sabor
	 */
	private void listarUnidadesVendidasPorSabor() {
		System.out.println("-- Unidades vendidas por sabor --");
		// completar
	}

	public void cerrarDia() {
		System.out.println("** Cierre del dia **");
		listarReposicion();
		listarUnidadesVendidasPorSabor();
	}

}