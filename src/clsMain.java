import LN.clsGestor;
import LP.clsMenuPrincipal;

/**
 * 
 * @author Aitor Contrasta y Asier Sojo
 * 
 *         Esta clase se va a encargar de crear un menu principal que sera el
 *         encargado de interactuar con el usuario y de iniciar el objGestor.
 *
 */
public class clsMain {

	public static void main(String[] args) {

		clsGestor objGestor;
		objGestor = new clsGestor();
		clsMenuPrincipal MenuPrincipal = new clsMenuPrincipal(objGestor);

		
		MenuPrincipal.setVisible(true);
		MenuPrincipal.setLocationRelativeTo(null);

	}
}