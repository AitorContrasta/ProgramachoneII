package LD;

import java.sql.*;

import javax.swing.JOptionPane;

import static LD.clsConstantesBD.DRIVER;
import static LD.clsConstantesBD.PASS;
import static LD.clsConstantesBD.SCHEMA;
import static LD.clsConstantesBD.URL;
import static LD.clsConstantesBD.USER;
import static LD.clsConstantesBD.TIME;

import static LD.clsConstantesBD.SQL_SELECT_CAMISETA;
import static LD.clsConstantesBD.SQL_INSERTAR_CAMISETA;
import static LD.clsConstantesBD.SQL_SELECT_PANTALON;
import static LD.clsConstantesBD.SQL_INSERTAR_PANTALON;
import static LD.clsConstantesBD.SQL_SELECT_SUDADERA;
import static LD.clsConstantesBD.SQL_INSERTAR_SUDADERA;
import static LD.clsConstantesBD.SQL_SELECT_BOTA;
import static LD.clsConstantesBD.SQL_INSERTAR_BOTA;

/**
 * Clase para el acceso a datos
 * 
 * @author Aitor Contrasta y Asier Sojo
 *
 */

public class clsDatos {

	// Objeto para crear la conexión a base de datos.

	Connection conn = null;

	// Objeto para crear la consulta a base de datos.

	PreparedStatement ps = null;

	// Objeto para devolver el resultado de la consulta.

	ResultSet rs = null;

	@SuppressWarnings("deprecation")
	public void Conexion() {

		/**
		 * Este método sirve para la conexión a la base de datos, y si no hay conexión
		 * lanza una excepción.
		 */

		try {
			Class.forName(DRIVER).newInstance();
			conn = DriverManager.getConnection(URL + SCHEMA + TIME, USER, PASS);
			System.out.println("Conexión establecida");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "CONEXIÓN FALLIDA, REVISA QUE EL SERVICIO HAYA SIDO INICIADO");
		}
	}

	public void Desconexion() {

		/**
		 * Este método sirve para hacer la desconexión de la base de datos.
		 */

		try {
			conn.close();
			ps.close(); // cerrar el statement tb cierra el resultset.
		} catch (SQLException e) {

		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				/* no hago nada */}
			try {
				ps.close();
			} catch (Exception e) {
				/* no hago nada */}
		}

	}

	// CAMISETAS
	public int InsertarCamiseta(int id, String marca, String talla, String color, double precio) {

		/**
		 * Este método sirve para insertar camisetas en la base de datos.
		 */

		int regActualizados = 0;
		int retorno = 0;

		try {
			ps = conn.prepareStatement(SQL_INSERTAR_CAMISETA, PreparedStatement.RETURN_GENERATED_KEYS);

			ps.setInt(1, id);
			ps.setString(2, marca);
			ps.setString(3, talla);
			ps.setString(4, color);
			ps.setDouble(5, precio);

			regActualizados = ps.executeUpdate();

			if (regActualizados == 1) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					retorno = rs.getInt(1);
				}
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return retorno;

	}

	public ResultSet DameCamisetas() {

		/**
		 * Este método sirve para recojer las casmisetas de la base de datos.
		 */

		rs = sendSelectCamisetas(SQL_SELECT_CAMISETA);

		return rs;

	}

	private ResultSet sendSelectCamisetas(String sqlSelectCamiseta) {

		try {
			ps = conn.prepareStatement(sqlSelectCamiseta);
			rs = ps.executeQuery(sqlSelectCamiseta);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return rs;

	}

	// PANTALONES
	public int InsertarPantalon(int id, String marca, String talla, String largo, String color, String tejido, double precio) {

		/**
		 * Este método sirve para insertar pantalones en la base de datos.
		 */

		int regActualizados = 0;
		int retorno = 0;

		try {
			ps = conn.prepareStatement(SQL_INSERTAR_PANTALON, PreparedStatement.RETURN_GENERATED_KEYS);

			ps.setInt(1, id);
			ps.setString(2, marca);
			ps.setString(3, talla);
			ps.setString(4, largo);
			ps.setString(5, color);
			ps.setString(6, tejido);
			ps.setDouble(7, precio);

			regActualizados = ps.executeUpdate();

			if (regActualizados == 1) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					retorno = rs.getInt(1);
				}
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return retorno;

	}

	public ResultSet DamePantalones() {

		/**
		 * Este método sirve para recojer los pantalones de la base de datos.
		 */

		rs = sendSelectPantalones(SQL_SELECT_PANTALON);

		return rs;

	}

	private ResultSet sendSelectPantalones(String sqlSelectPantalon) {

		try {
			ps = conn.prepareStatement(sqlSelectPantalon);
			rs = ps.executeQuery(sqlSelectPantalon);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return rs;

	}

	// SUDADERAS
	public int InsertarSudadera(int id, String marca, String talla, String color, String capucha, double precio) {

		/**
		 * Este método sirve para insertar sudaderas en la base de datos.
		 */

		int regActualizados = 0;
		int retorno = 0;

		try {
			ps = conn.prepareStatement(SQL_INSERTAR_SUDADERA, PreparedStatement.RETURN_GENERATED_KEYS);

			ps.setInt(1, id);
			ps.setString(2, marca);
			ps.setString(3, talla);
			ps.setString(4, color);
			ps.setString(5, capucha);
			ps.setDouble(6, precio);

			regActualizados = ps.executeUpdate();

			if (regActualizados == 1) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					retorno = rs.getInt(1);
				}
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return retorno;

	}

	public ResultSet DameSudaderas() {

		/**
		 * Este método sirve para recojer las casmisetas de la base de datos.
		 */

		rs = sendSelectSudaderas(SQL_SELECT_SUDADERA);

		return rs;

	}

	private ResultSet sendSelectSudaderas(String sqlSelectSudadera) {
		

		try {
			ps = conn.prepareStatement(sqlSelectSudadera);
			rs = ps.executeQuery(sqlSelectSudadera);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return rs;

	}

	// BOTAS
	public int InsertarBota(int id, String marca, String modelo, String color, String suela, double tallaBota, String material,
			double precio) {

		/**
		 * Este método sirve para insertar botas en la base de datos.
		 */

		int regActualizados = 0;
		int retorno = 0;

		try {
			ps = conn.prepareStatement(SQL_INSERTAR_BOTA, PreparedStatement.RETURN_GENERATED_KEYS);

			ps.setInt(1, id);
			ps.setString(2, marca);
			ps.setString(3, modelo);
			ps.setString(4, color);
			ps.setString(5, suela);
			ps.setDouble(6, tallaBota);
			ps.setString(7, material);
			ps.setDouble(8, precio);

			regActualizados = ps.executeUpdate();

			if (regActualizados == 1) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					retorno = rs.getInt(1);
				}
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return retorno;

	}

	public ResultSet DameBotas() {

		/**
		 * Este método sirve para recojer las casmisetas de la base de datos.
		 */

		rs = sendSelectBotas(SQL_SELECT_BOTA);

		return rs;

	}

	private ResultSet sendSelectBotas(String sqlSelectBota) {
		

		try {
			ps = conn.prepareStatement(sqlSelectBota);
			rs = ps.executeQuery(sqlSelectBota);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return rs;

	}

}
