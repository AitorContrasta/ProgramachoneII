package LN;

import static COMUN.clsConstantes.Color;
import static COMUN.clsConstantes.Id;
import static COMUN.clsConstantes.Marca;
import static COMUN.clsConstantes.TallaBota;

import COMUN.itfProperty;

import static COMUN.clsConstantes.Modelo;
import static COMUN.clsConstantes.Suela;
import static COMUN.clsConstantes.Material;
import static COMUN.clsConstantes.Precio;

/**
 * 
 * @author Aitor Contrasta y Asier Sojo
 * 
 *         Esta clase se encargará de dar de alta, modificar o eliminar los
 *         atributos de las botas.
 *
 */

public class clsBotas extends clsTextil implements itfProperty, Comparable<clsBotas> {

	/*
	 * Declaramos los atributos propios de las botas
	 */

	private double tallaBota;
	private String modelo;
	private String suela;
	private String material;
	private double precio;

	public clsBotas(int id, String marca, String modelo, String color, String suela, double tallaBota, String material,
			double precio) {

		super(id, color, marca);
		this.tallaBota = tallaBota;
		this.modelo = modelo;
		this.suela = suela;
		this.material = material;
		this.precio = precio;
	}

	/*
	 * Ponemos los Getters y los Setters de las botas.
	 */

	public double getTallaBota() {
		return tallaBota;
	}

	public void setTallaBota(double tallaBota) {
		this.tallaBota = tallaBota;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getSuela() {
		return suela;
	}

	public void setSuela(String suela) {
		this.suela = suela;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/*
	 * Aplicamos el itfProperty
	 */

	@Override
	public Object getProperty(String propiedad) {

		switch (propiedad) {

		case Id:
			return this.getId();
		case Color:
			return this.getColor();
		case Marca:
			return this.getMarca();
		case TallaBota:
			return this.getTallaBota();
		case Modelo:
			return this.getModelo();
		case Suela:
			return this.getSuela();
		case Material:
			return this.getMaterial();
		case Precio:
			return this.getPrecio();

		}

		return null;
	}

	/**
	 * Al implementar el Comparable se nos autogenera este metodo para poder ordenar
	 * las botas por el parametro que queramos, en este caso por el precio.
	 */

	@Override
	public int compareTo(clsBotas b) {
		if (b.getPrecio() > precio) {
			return -1;
		} else {
			if (b.getPrecio() > precio) {
				return 0;
			} else {
				return 1;
			}
		}
	}

}
