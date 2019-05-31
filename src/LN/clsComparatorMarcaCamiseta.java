package LN;

import java.util.Comparator;

/**
 * En esta clase ordenamos el arraylist de camisetas por marca
 * 
 * @author Aitor Contrasta y Asier Sojo
 *
 */

public class clsComparatorMarcaCamiseta implements Comparator<clsCamisetas>{

	@Override
	public int compare(clsCamisetas o1, clsCamisetas o2) {
		
		return (o1.getMarca().compareTo(o2.getMarca()));
	}

	

}
