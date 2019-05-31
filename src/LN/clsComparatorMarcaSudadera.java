package LN;

import java.util.Comparator;

/**
 * En esta clase ordenamos el arraylist de sudaderas por marca
 * 
 * @author Aitor Contrasta y Asier Sojo
 *
 */

public class clsComparatorMarcaSudadera implements Comparator<clsSudaderas>{

	@Override
	public int compare(clsSudaderas o1, clsSudaderas o2) {

		return (o1.getMarca().compareTo(o2.getMarca()));
	}

}
