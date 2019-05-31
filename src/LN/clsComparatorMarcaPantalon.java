package LN;

import java.util.Comparator;

/**
 * En esta clase ordenamos el arraylist de pantalones por marca
 * 
 * @author Aitor Contrasta y Asier Sojo
 *
 */

public class clsComparatorMarcaPantalon implements Comparator<clsPantalones>{

	@Override
	public int compare(clsPantalones o1, clsPantalones o2) {
		return (o1.getMarca().compareTo(o2.getMarca()));
	}

}
