package LN;

import static COMUN.clsConstantes.Talla;

import COMUN.itfProperty;

import static COMUN.clsConstantes.Id;
import static COMUN.clsConstantes.Color;
import static COMUN.clsConstantes.Marca;
import static COMUN.clsConstantes.Capucha;
import static COMUN.clsConstantes.Precio;

/**
 * 
 * @author Aitor Contrasta y Asier Sojo
 * 
 *         Esta clase se encargará de dar de alta, modificar o eliminar los
 *         atributos de las sudaderas. Esta clase va a heredar de la clase
 *         clsTextil los atributos: talla, color y marca; que son comunes a
 *         todos los textiles.
 *
 */

public class clsSudaderas extends clsTextil implements itfProperty, Comparable<clsSudaderas> {

	public clsSudaderas(int id, String marca, String talla, String color, String capucha, double precio) {
		super(id, color, marca);
		this.capucha = capucha;
		this.precio = precio;
		this.talla = talla;
	}
	
	/**
	 * Ponemos los atributos propios de las sudaderas.
	 */
	
	private String capucha;
	private double precio;
	private String talla;
	
	/**
	 * Ponemos los getters y los setters.
	 */

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public String getCapucha() {
		return capucha;
	}

	public void setCapucha(String capucha) {
		this.capucha = capucha;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Utilizamos el itfProperty
	 */

	@Override
	public Object getProperty(String propiedad) {

		switch (propiedad) {

		case Id:
			return this.getId();
		case Marca:
			return this.getMarca();
		case Talla:
			return this.getTalla();
		case Color:
			return this.getColor();
		case Capucha:
			return this.getCapucha();
		case Precio:
			return this.getPrecio();

		}

		return null;
	}

	/**
	 * Al implementar el Comparable se nos autogenera este metodo para poder ordenar
	 * las sudaderas por el parametro que queramos, en este caso por el precio.
	 */

	@Override
	public int compareTo(clsSudaderas s) {
		if (s.getPrecio() > precio) {
			return -1;
		} else {
			if (s.getPrecio() > precio) {
				return 0;
			} else {
				return 1;
			}
		}
	}

}
