package LN;

import static COMUN.clsConstantes.Precio;
import static COMUN.clsConstantes.Talla;
import static COMUN.clsConstantes.Tejido;

import COMUN.itfProperty;

import static COMUN.clsConstantes.Color;
import static COMUN.clsConstantes.Id;
import static COMUN.clsConstantes.Largo;
import static COMUN.clsConstantes.Marca;

/**
 * 
 * @author Aitor Contrasta y Asier Sojo
 * 
 *         Esta clase se encargará de dar de alta, modificar o eliminar los
 *         atributos de las pantalones. Esta clase va a heredar de la clase
 *         clsTextil los atributos: talla, color y marca; que son comunes a
 *         todos los textiles.
 *
 */

public class clsPantalones extends clsTextil implements itfProperty, Comparable<clsPantalones> {

	public clsPantalones(int id, String marca, String talla, String largo, String color, String tejido, double precio) {
		super(id, color, marca);
		this.largo = largo;
		this.tejido = tejido;
		this.precio = precio;
		this.talla = talla;
	}

	/**
	 * Ponemos los atributos propios de los pantalones.
	 */
	
	private String largo;
	private String tejido;
	private double precio;
	private String talla;

	
	/**
	 * Ponemos los Getters y los Setters.
	 */
	
	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public String getLargo() {
		return largo;
	}

	public void setLargo(String largo) {
		this.largo = largo;
	}

	public String getTejido() {
		return tejido;
	}

	public void setTejido(String tejido) {
		this.tejido = tejido;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Utilizamos el itfProperty.
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
		case Largo:
			return this.getLargo();
		case Color:
			return this.getColor();
		case Tejido:
			return this.getTejido();
		case Precio:
			return this.getPrecio();

		}

		return null;
	}
	
	/**
	 * Al implementar el Comparable se nos autogenera este metodo para poder ordenar
	 * los pantalones por el parametro que queramos, en este caso por el precio.
	 */
	
	@Override
	public int compareTo(clsPantalones p) {
		if (p.getPrecio() > precio) {
			return -1;
		} else {
			if (p.getPrecio() > precio) {
				return 0;
			} else {
				return 1;
			}
		}
	}

}
