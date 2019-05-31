package LN;

import static COMUN.clsConstantes.CapuchaBD;
import static COMUN.clsConstantes.ColorBD;
import static COMUN.clsConstantes.LargoBD;

import static COMUN.clsConstantes.MarcaBD;
import static COMUN.clsConstantes.MaterialBD;
import static COMUN.clsConstantes.ModeloBD;
import static COMUN.clsConstantes.PrecioBD;
import static COMUN.clsConstantes.SuelaBD;
import static COMUN.clsConstantes.TallaBD;
import static COMUN.clsConstantes.TallaBotaBD;
import static COMUN.clsConstantes.TejidoBD;
import static COMUN.clsConstantes.IdCamisetaBD;
import static COMUN.clsConstantes.IdPantalonBD;
import static COMUN.clsConstantes.IdSudaderaBD;
import static COMUN.clsConstantes.IdBotaBD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import COMUN.itfProperty;
import LD.clsDatos;

/**
 * 
 * @author Aitor Contrasta y Asier Sojo
 *
 */

public class clsGestor {

	/**
	 * Declaramos los ArrayList y el objDatos.
	 */

	private ArrayList<clsCamisetas> miListaCamisetas;
	private ArrayList<clsPantalones> miListaPantalones;
	private ArrayList<clsSudaderas> miListaSudaderas;
	private ArrayList<clsBotas> miListaBotas;

	private clsDatos objDatos;

	public clsGestor() {

		/**
		 * Inicializamos los ArrayList establecemos la conexión a Base de Datos.
		 */

		miListaCamisetas = new ArrayList<clsCamisetas>();
		miListaPantalones = new ArrayList<clsPantalones>();
		miListaSudaderas = new ArrayList<clsSudaderas>();
		miListaBotas = new ArrayList<clsBotas>();
		objDatos = new clsDatos();

		this.CargarCamisetas();
		this.CargarPantalones();
		this.CargarSudaderas();
		this.CargarBotas();
	}

	public ArrayList<itfProperty> DameCamisetas() {

		/**
		 * Este método es para sacar por pantalla las camisetas de las que disponemos.
		 */

		ArrayList<itfProperty> retorno;
		retorno = new ArrayList<itfProperty>();
		for (clsCamisetas a : miListaCamisetas) {
			retorno.add(a);
		}
		return retorno;
	}

	public void CrearCamiseta(int id, String marca, String talla, String color, double precio) {

		/**
		 * Con este método lo que hacemos es crear las camisetas y guardarlas en nuestro
		 * ArrayList, además hacemos la conexión, la inserción de los datos y la
		 * desconexión de la Base de Datos.
		 */

		clsCamisetas objCamiseta;

		objCamiseta = new clsCamisetas(id, marca, talla, color, precio);
		miListaCamisetas.add(objCamiseta);
		// Lo guardo en base de datos.
		objDatos.Conexion();
		objDatos.InsertarCamiseta(id, marca, talla, color, precio);
		objDatos.Desconexion();

	}

	public void CargarCamisetas() {

		/**
		 * En este método pretendemos conectar con la Base de Datos y recuperar los
		 * datos de las camisetas que ya hemos creado. Dentro del try hay que poner los
		 * atributos en el orden que queremos sacarlos.
		 */

		// Conecto a la base de datos.
		objDatos.Conexion();
		// Leo la información y la uso.
		ResultSet camisetas = objDatos.DameCamisetas();
		try {
			while (camisetas.next()) {

				int id = camisetas.getInt(IdCamisetaBD);
				String marca = camisetas.getString(MarcaBD);
				String talla = camisetas.getString(TallaBD);
				String color = camisetas.getString(ColorBD);
				double precio = camisetas.getDouble(PrecioBD);

				miListaCamisetas.add(new clsCamisetas(id, marca, talla, color, precio));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		// Libero los recursos.
		objDatos.Desconexion();
	}

	public ArrayList<itfProperty> DameCamisetasOrdenadas() {

		/**
		 * En este método pretendemos conectar con la Base de Datos y recuperar los
		 * datos de las camisetas que ya hemos creado, pero esta vez de una forma
		 * ordenada.
		 */

		ArrayList<itfProperty> retorno;

		retorno = new ArrayList<itfProperty>();

		Collections.sort(miListaCamisetas);

		for (clsCamisetas c : miListaCamisetas) {
			retorno.add(c);
		}

		return retorno;
	}

	public ArrayList<itfProperty> DameCamisetasOrdenadasCompareTo() {

		ArrayList<itfProperty> retorno;

		retorno = new ArrayList<itfProperty>();

		Collections.sort(miListaCamisetas, new clsComparatorMarcaCamiseta());

		for (clsCamisetas c : miListaCamisetas) {
			retorno.add(c);
		}

		return retorno;
	}

	public ArrayList<itfProperty> DamePantalones() {

		/**
		 * Este método es para sacar por pantalla los pantalones de las que disponemos.
		 */

		ArrayList<itfProperty> retorno;
		retorno = new ArrayList<itfProperty>();
		for (clsPantalones p : miListaPantalones) {
			retorno.add(p);
		}

		return retorno;

	}

	public void CrearPantalon(int id, String marca, String talla, String largo, String color, String tejido,
			double precio) {

		/**
		 * Con este método lo que hacemos es crear los pantalones y guardarlos en
		 * nuestro ArrayList, además hacemos la conexión, la inserción de los datos y la
		 * desconexión de la Base de Datos.
		 */

		clsPantalones objPantalon;

		objPantalon = new clsPantalones(id, marca, talla, largo, color, tejido, precio);
		miListaPantalones.add(objPantalon);

		// Lo guardo en base de datos.
		objDatos.Conexion();
		objDatos.InsertarPantalon(id, marca, talla, largo, color, tejido, precio);
		objDatos.Desconexion();

	}

	public void CargarPantalones() {

		/**
		 * En este método pretendemos conectar con la Base de Datos y recuperar los
		 * datos de los pantalones que ya hemos creado. Dentro del try hay que poner los
		 * atributos en el orden que queremos sacarlos.
		 */

		// Conecto a la base de datos.
		objDatos.Conexion();
		// Leo la información y la uso.
		ResultSet pantalones = objDatos.DamePantalones();
		try {
			while (pantalones.next()) {

				int id = pantalones.getInt(IdPantalonBD);
				String marca = pantalones.getString(MarcaBD);
				String talla = pantalones.getString(TallaBD);
				String largo = pantalones.getString(LargoBD);
				String color = pantalones.getString(ColorBD);
				String tejido = pantalones.getString(TejidoBD);
				double precio = pantalones.getDouble(PrecioBD);

				miListaPantalones.add(new clsPantalones(id, marca, talla, largo, color, tejido, precio));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		// Libero los recursos.
		objDatos.Desconexion();
	}

	public ArrayList<itfProperty> DamePantalonesOrdenados() {

		/**
		 * En este método pretendemos conectar con la Base de Datos y recuperar los
		 * datos de los pantalones que ya hemos creado, pero esta vez de una forma
		 * ordenada.
		 */

		ArrayList<itfProperty> retorno;

		retorno = new ArrayList<itfProperty>();

		Collections.sort(miListaPantalones);

		for (clsPantalones p : miListaPantalones) {
			retorno.add(p);
		}

		return retorno;
	}

	public ArrayList<itfProperty> DamePantalonesOrdenadosCompareTo() {

		ArrayList<itfProperty> retorno;

		retorno = new ArrayList<itfProperty>();

		Collections.sort(miListaPantalones, new clsComparatorMarcaPantalon());

		for (clsPantalones c : miListaPantalones) {
			retorno.add(c);
		}

		return retorno;
	}

	public ArrayList<itfProperty> DameSudaderas() {

		/**
		 * Este método es para sacar por pantalla las sudaderas de las que disponemos.
		 */

		ArrayList<itfProperty> retorno;
		retorno = new ArrayList<itfProperty>();
		for (clsSudaderas s : miListaSudaderas) {
			retorno.add(s);
		}

		return retorno;

	}

	public void CrearSudadera(int id, String marca, String talla, String color, String capucha, double precio) {

		/**
		 * Con este método lo que hacemos es crear las sudaderas y guardarlas en nuestro
		 * ArrayList, además hacemos la conexión, la inserción de los datos y la
		 * desconexión de la Base de Datos.
		 */

		clsSudaderas objSudadera;

		objSudadera = new clsSudaderas(id, marca, talla, color, capucha, precio);

		miListaSudaderas.add(objSudadera);

		objDatos.Conexion();
		objDatos.InsertarSudadera(id, marca, talla, color, capucha, precio);
		objDatos.Desconexion();

	}

	public void CargarSudaderas() {

		/**
		 * En este método pretendemos conectar con la Base de Datos y recuperar los
		 * datos de las sudaderas que ya hemos creado. Dentro del try hay que poner los
		 * atributos en el orden que queremos sacarlos.
		 */

		// Conecto a la base de datos.
		objDatos.Conexion();
		// Leo la información y la uso.
		ResultSet sudaderas = objDatos.DameSudaderas();
		try {
			while (sudaderas.next()) {

				int id = sudaderas.getInt(IdSudaderaBD);
				String marca = sudaderas.getString(MarcaBD);
				String talla = sudaderas.getString(TallaBD);
				String color = sudaderas.getString(ColorBD);
				String capucha = sudaderas.getString(CapuchaBD);
				double precio = sudaderas.getDouble(PrecioBD);

				miListaSudaderas.add(new clsSudaderas(id, marca, talla, color, capucha, precio));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		// Libero los recursos.
		objDatos.Desconexion();
	}

	public ArrayList<itfProperty> DameSudaderasOrdenadas() {

		/**
		 * En este método pretendemos conectar con la Base de Datos y recuperar los
		 * datos de las sudaderas que ya hemos creado, pero esta vez de una forma
		 * ordenada.
		 */

		ArrayList<itfProperty> retorno;

		retorno = new ArrayList<itfProperty>();

		Collections.sort(miListaSudaderas);

		for (clsTextil s : miListaSudaderas) {
			retorno.add(s);
		}

		return retorno;
	}

	public ArrayList<itfProperty> DameSudaderasOrdenadosCompareTo() {

		ArrayList<itfProperty> retorno;

		retorno = new ArrayList<itfProperty>();

		Collections.sort(miListaSudaderas, new clsComparatorMarcaSudadera());

		for (clsSudaderas c : miListaSudaderas) {
			retorno.add(c);
		}

		return retorno;
	}

	public ArrayList<itfProperty> DameBotas() {

		/**
		 * Este método es para sacar por pantalla las botas de las que disponemos.
		 */

		ArrayList<itfProperty> retorno;
		retorno = new ArrayList<itfProperty>();
		for (clsBotas b : miListaBotas) {
			retorno.add(b);
		}

		return retorno;

	}

	public void CrearBota(int id, String marca, String modelo, String color, String suela, double tallaBota,
			String material, double precio) {

		/**
		 * Con este método lo que hacemos es crear las botas y guardarlas en nuestro
		 * ArrayList, además hacemos la conexión, la inserción de los datos y la
		 * desconexión de la Base de Datos.
		 */

		clsBotas objBota;

		objBota = new clsBotas(id, marca, modelo, color, suela, tallaBota, material, precio);

		miListaBotas.add(objBota);

		objDatos.Conexion();
		objDatos.InsertarBota(id, marca, modelo, color, suela, tallaBota, material, precio);
		objDatos.Desconexion();

	}

	public void CargarBotas() {

		/**
		 * En este método pretendemos conectar con la Base de Datos y recuperar los
		 * datos de las botas que ya hemos creado. Dentro del try hay que poner los
		 * atributos en el orden que queremos sacarlos.
		 */

		// Conecto a la base de datos.
		objDatos.Conexion();
		// Leo la información y la uso.
		ResultSet botas = objDatos.DameBotas();
		try {
			while (botas.next()) {

				int id = botas.getInt(IdBotaBD);
				String marca = botas.getString(MarcaBD);
				String modelo = botas.getString(ModeloBD);
				String color = botas.getString(ColorBD);
				String suela = botas.getString(SuelaBD);
				double tallaBota = botas.getDouble(TallaBotaBD);
				String material = botas.getString(MaterialBD);
				double precio = botas.getDouble(PrecioBD);

				miListaBotas.add(new clsBotas(id, marca, modelo, color, suela, tallaBota, material, precio));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		// Libero los recursos.
		objDatos.Desconexion();
	}

	public ArrayList<itfProperty> DameBotasOrdenadas() {

		/**
		 * En este método pretendemos conectar con la Base de Datos y recuperar los
		 * datos de las botas que ya hemos creado, pero esta vez de una forma ordenada.
		 * 
		 * Como hemos comentado antes, este método no funciona, no sabemos porque.
		 */

		ArrayList<itfProperty> retorno;

		retorno = new ArrayList<itfProperty>();

		Collections.sort(miListaBotas);

		for (clsTextil b : miListaBotas) {
			retorno.add(b);
		}

		return retorno;
	}

	public ArrayList<itfProperty> DameBotasOrdenadosCompareTo() {

		ArrayList<itfProperty> retorno;

		retorno = new ArrayList<itfProperty>();

		Collections.sort(miListaBotas, new clsComparatorMarcaBota());

		for (clsBotas c : miListaBotas) {
			retorno.add(c);
		}

		return retorno;
	}

}
