package LN;



import COMUN.itfProperty;

import static COMUN.clsConstantes.Color;
import static COMUN.clsConstantes.Id;
import static COMUN.clsConstantes.Marca;
import static COMUN.clsConstantes.Precio;
import static COMUN.clsConstantes.Talla;

/**
 * 
 * @author Aitor Contrasta y Asier Sojo
 *
 *         Esta clase se encargará de dar de alta, modificar o eliminar los
 *         atributos de las camisetas. Esta clase va a heredar de la clase
 *         clsTextil los atributos: talla, color y marca; que son comunes a
 *         todos los textiles.
 *
 */

public class clsCamisetas extends clsTextil implements itfProperty, Comparable<clsCamisetas> {

	/**
	 * Ponemos los atributos propios de las camisetas.
	 */

	private String talla;
	private double precio;

	public clsCamisetas(int id, String marca, String talla, String color, double precio) {
		super(id, color, marca);
		this.talla = talla;
		this.precio = precio;
	}

	/**
	 * Ponemos los Getters y los Setteres.
	 */

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Utilizamos el itfPoperty.
	 */

	@Override
	public Object getProperty(String propiedad){

		switch (propiedad) {

		case Id:
			return this.getId();
		case Talla:
			return this.getTalla();
		case Color:
			return this.getColor();
		case Marca:
			return this.getMarca();
		case Precio:
			return this.getPrecio();
				
		}
		return null;
	}

	/**
	 * Al implementar el Comparable se nos autogenera este metodo para poder ordenar
	 * las camisetas por el parametro que queramos, en este caso por el precio.
	 */

	@Override
	public int compareTo(clsCamisetas c) {
		if (c.getPrecio() > precio) {
			return -1;
		} else {
			if (c.getPrecio() > precio) {
				return 0;
			} else {
				return 1;
			}
		}
	}
	

}
