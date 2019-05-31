package LD;

/**
 * En esta clase creamos los public static final String de las cosas que vamos a
 * usar en relacion a la base de datos, es decir, los insert, selec y las
 * constantes como la contraseña o el URL.
 * 
 * @author Aitor Contrasta y Asier Sojo
 *
 */

public class clsConstantesBD {

	// CONSTANTES PARA LA CREACIÓN DEL ACCESO A BASE DE DATOS.

	public static final String URL = "jdbc:mysql://localhost:3306/";
	public static final String SCHEMA = "TIENDA";
	public static final String TIME = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String USER = "root";
	public static final String PASS = "0000";

	public static final String SQL_INSERTAR_CAMISETA = "INSERT INTO `TIENDA`.`CamisetasCasual`\r\n"
			+ "(`idCamiseta`,\r\n" + "`Marca`,\r\n" + "`Talla`,\r\n" + "`Color`,\r\n" + "`Precio`)\r\n" + "VALUES\r\n"
			+ "(?,\r\n" + "?,\r\n" + "?,\r\n" + "?,\r\n" + "?\r\n);\r\n";

	public static final String SQL_SELECT_CAMISETA = "SELECT * FROM TIENDA.CamisetasCasual";

	public static final String SQL_INSERTAR_PANTALON = "INSERT INTO `TIENDA`.`PantalonesCasual`\r\n"
			+ "(`idPantalon`,\r\n" + "`Marca`,\r\n" + "`Talla`,\r\n" + "`Largo`,\r\n" + "`Color`,\r\n"
			+ "`Material`,\r\n" + "`Precio`)\r\n" + "VALUES\r\n" + "(?,\r\n" + "?,\r\n" + "?,\r\n" + "?,\r\n" + "?,\r\n" + "?,\r\n"
			+ "?\r\n);\r\n";

	public static final String SQL_SELECT_PANTALON = "SELECT * FROM TIENDA.PantalonesCasual";

	public static final String SQL_INSERTAR_SUDADERA = "INSERT INTO `TIENDA`.`SudaderasCasual`\r\n"
			+ "(`idSudadera`,\r\n" + "`Marca`,\r\n" + "`Talla`,\r\n" + "`Color`,\r\n" + "`Capucha`,\r\n"
			+ "`Precio`)\r\n" + "VALUES\r\n" + "(?,\r\n" + "?,\r\n" + "?,\r\n" + "?,\r\n" + "?,\r\n" + "?\r\n);\r\n";

	public static final String SQL_SELECT_SUDADERA = "SELECT * FROM TIENDA.SudaderasCasual";

	public static final String SQL_INSERTAR_BOTA = "INSERT INTO `TIENDA`.`Botas`\r\n" + "(`idBota`,\r\n"
			+ "`Marca`,\r\n" + "`Modelo`,\r\n" + "`Color`,\r\n" + "`TipoSuela`,\r\n" + "`Talla`,\r\n"
			+ "`Material`,\r\n" + "`Precio`)\r\n" + "VALUES\r\n" + "(?,\r\n" + "?,\r\n" + "?,\r\n" + "?,\r\n" + "?,\r\n" + "?,\r\n"
			+ "?,\r\n" + "?\r\n);\r\n";

	public static final String SQL_SELECT_BOTA = "SELECT * FROM TIENDA.Botas";
}
