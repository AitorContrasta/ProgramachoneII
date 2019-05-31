package Excepciones;

public class clsNoExisteElCampo extends RuntimeException{
	

/**
 * Clase para crear una excepcion que muestre el mensaje al
 * usuario cuando no existe el campo que pretende rellenar
 * 
 * @author Aitor Contrasta y Asier Sojo
 */
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		
		return "No existe ese campo";
		
	}

}
