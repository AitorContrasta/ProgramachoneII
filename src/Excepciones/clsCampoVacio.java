package Excepciones;

/**
 * Clase para crear una excepcion que se propagara, y que muestre el mensaje al
 * usuario cuando no rellena todos los campos
 * 
 * @author Aitor Contrasta y Asier Sojo
 */

public class clsCampoVacio extends Exception {

	
	private static final long serialVersionUID = 1L;

	private final String MENSAJE = "Tienes que rellenar todos los campos";

	public String getMENSAJE() {
		return MENSAJE;
	}

	public String toString() {

		return MENSAJE;
	}

}
