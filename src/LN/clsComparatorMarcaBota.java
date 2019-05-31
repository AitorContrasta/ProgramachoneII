package LN;

import java.util.Comparator;

/**
 * En esta clase ordenamos el arraylist de botas por marca
 * 
 * @author Aitor Contrasta y Asier Sojo
 *
 */

public class clsComparatorMarcaBota implements Comparator<clsBotas>{

	@Override
	public int compare(clsBotas o1, clsBotas o2) {

		return (o1.getMarca().compareTo(o2.getMarca()));
	}

}
