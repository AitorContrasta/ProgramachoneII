package LN;

import COMUN.itfProperty;

/**
 * 
 * @author Aitor Contrasta y Asier Sojo
 * 
 *         Esta clase existe para que las clases clsCamisetas, clsPantalones y
 *         clsSudaderas puedan heredar los atributos comunes entre ellas.
 *
 */

public abstract class clsTextil implements itfProperty {

	/**
	 * Aquí declaramos las variables que van a ser comunes con las clases hijo.
	 */

	private int id;
	protected String color;
	protected String marca;

	/**
	 * Aquí ponemos los Getters y los Setters.
	 */

	public clsTextil() {

		this.id = 0;
		this.color = "";
		this.marca = "";

	}

	public clsTextil(int id, String color, String marca) {

		this.id = id;
		this.color = color;
		this.marca = marca;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Estos métodos se generan automaticamente al utilizar el compareTo.
	 */

	public int compareTo(clsCamisetas o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int compareTo(clsPantalones p) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int compareTo(clsSudaderas s) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int compareTo(clsBotas b) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Estos métodos (hashcode e equals) se generan automaticamente, y son necesarios para que los
	 * objetos se distingan de forma unívoca en base a los atributos definidos
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		clsTextil other = (clsTextil) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
