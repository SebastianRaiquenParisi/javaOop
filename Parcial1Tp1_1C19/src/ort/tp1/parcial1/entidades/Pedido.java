/**
 * 
 */
package ort.tp1.parcial1.entidades;

import java.util.ArrayList;

/**
 * Clase que contiene un pedido generado.
 */
public class Pedido implements Certificable, Mostrable{

	private ArrayList<Producto> productosList;
	private ArrayList<Integer> cantidadList;
	private TipoPedido tipoPedido;

	public Pedido(TipoPedido tipo) {
		productosList = new ArrayList<Producto>();
		cantidadList = new ArrayList<Integer>();
		this.setTipoPedido(tipo);
	}

	
	public TipoPedido getTipoPedido() {
		return tipoPedido;
	}


	private void setTipoPedido(TipoPedido tipoPedido) {
		this.tipoPedido = tipoPedido;
	}


	/**
	 * Permite agregar un producto al pedido
	 * 
	 * @param producto El {@link Producto} a agregar.
	 * @param cantidad La cantidadd del {@link Producto} a agregar
	 */
	public void agregarProducto(Producto producto, Integer cantidad) {
		int idProducto = buscarProducto(producto);
		if(idProducto!=-1) {
			agregarCantidad(idProducto, cantidad);
		}else {
		this.productosList.add(producto);
		this.cantidadList.add(cantidad);
		}
		// buscar si el producto esta sumar cantidades
		//		si no esta agregarlo
	}


	private void agregarCantidad(int idProducto, int cantidad) {
		Producto producto = this.productosList.get(idProducto);
		int cantidadAgregada = cantidadProducto(producto);
		cantidadAgregada += cantidad;
		this.cantidadList.set(idProducto, cantidadAgregada);
	}

	/**
	 * Saca un producto del pedido.
	 * 
	 * @param producto El {@link Producto} a sacar del pedido
	 * @param cantidad Cantidad del {@link Producto} a sacar del pedido
	 */
	public void sacarProducto(Producto producto, int cantidadASacar) {
        
		int idBuscado = buscarProducto(producto);
        int cantidadActual;
        
        if (idBuscado != -1) {
        	
            cantidadActual = this.cantidadProducto(producto);
            
            if (cantidadASacar < cantidadActual) {
            	
                cantidadActual -= cantidadASacar;
                cantidadList.set(idBuscado, cantidadActual);
                
            } else {
            	
                cantidadList.remove(idBuscado);
                productosList.remove(producto);
                
            }
        }
    }

	/**
	 * Devuelve el indice del producto buscado en la lista.
	 * 
	 * @param p {@link Producto}
	 * @return El indice >= 0 si encuentra el producto y -1 si no lo encuentra
	 */
	private int buscarProducto(Producto p) {
		
		int idx = -1;
		int pos = 0;
		Producto productoEncontrado;
		while(idx==-1 && pos<this.productosList.size()) {
			
			productoEncontrado=this.productosList.get(pos);
			
			if(p.equals(productoEncontrado)) {
				idx = pos;
			}
			pos++;
		}
		return idx;
	}

	/**
	 * Indica la cantidad del producto dado.
	 * 
	 * @param producto {@link Producto} cuya cantidad se desea averiguar
	 * @return {@link Integer} conteniendo la cantidad del producto en el pedido -1
	 *         si no está el producto
	 */
	private int cantidadProducto(Producto producto) {
		int idProducto = this.buscarProducto(producto);
		int cantidad;
		if(idProducto!=-1) {
			cantidad = this.cantidadList.get(idProducto);
		}else {
			cantidad = -1;
		}
		return cantidad;
	}

	/**
	 * Devuelve una estructura conteniendo las lineas del pedido
	 * 
	 * @return un la estructura conteniendo {@link LineaPedido}s
	 */
	private Object getTablaProductosPedidos() {
		// Completar

		return null;
	}

	/**
	 * // * Calcula el importe del pedido
	 * 
	 * @return {@link Float} conteniendo el importe del pedido
	 */
	private float calcularImportePedido() {

		// Completar
		float importe = 0;
		return importe;
	}

	@Override
	public boolean isCertificadoSinTACC() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		
	}

}
