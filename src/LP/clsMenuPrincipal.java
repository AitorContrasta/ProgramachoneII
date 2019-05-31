package LP;

import static LP.clsConstantesLP.BTN_SALIR;
import static LP.clsConstantesLP.BTN_INSERTAR;
import static LP.clsConstantesLP.BTN_CONSULTAR;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LN.clsGestor;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;


/**
 * 
 * @author Aitor Contrasta y Asier Sojo
 *
 */
public class clsMenuPrincipal extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private clsGestor objGestor;

	/**
	 * En este metodo creamos el JFrame principal de la aplicacion el cual tiene 3
	 * opciones. La de consultar, la de insertar y la de salir de la aplicacion.
	 * 
	 * @param _objGestor
	 */
	public clsMenuPrincipal(clsGestor _objGestor) {
		setTitle("ALMAC\u00C9N");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"Imagenes\\Caja.png"));
		objGestor = _objGestor;
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("\u00A1BIENVENID@! \u00BFQU\u00C9 DESEA HACER?");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(40, 24, 414, 25);
		contentPane.add(lblTitulo);

		/**
		 * Creaci�n del boton para consultar.
		 */

		JButton btnConsultar = new JButton("CONSULTAR");
		btnConsultar.addKeyListener(new KeyAdapter() {

			/**
			 * Metodo para utilizar un boton pulsando ENTER
			 */

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					clsMenuConsultar MenuConsultar = new clsMenuConsultar(objGestor);
					MenuConsultar.setVisible(true);
					MenuConsultar.setLocationRelativeTo(null);
					dispose();

				}

			}
		});
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnConsultar.setBackground(Color.WHITE);
		btnConsultar.setActionCommand(BTN_CONSULTAR);
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(192, 85, 109, 32);
		contentPane.add(btnConsultar);

		/**
		 * Creacion del boton para insertar.
		 */

		JButton btnInsertar = new JButton("INSERTAR");
		btnInsertar.addKeyListener(new KeyAdapter() {

			/**
			 * Metodo para utilizar un boton pulsando ENTER
			 */

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					clsMenuContrasena MenuContrasena = new clsMenuContrasena(objGestor);
					MenuContrasena.setVisible(true);
					MenuContrasena.setLocationRelativeTo(null);
					dispose();

				}

			}
		});
		btnInsertar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnInsertar.setBackground(Color.WHITE);
		btnInsertar.setActionCommand(BTN_INSERTAR);
		btnInsertar.addActionListener(this);
		btnInsertar.setBounds(192, 141, 109, 32);
		contentPane.add(btnInsertar);

		/**
		 * Creacion del boton para salir.
		 */

		JButton btnSalir = new JButton("SALIR");
		btnSalir.addKeyListener(new KeyAdapter() {

			/**
			 * Metodo para utilizar un boton pulsando ENTER
			 */

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					System.exit(0);

				}

			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setActionCommand(BTN_SALIR);
		btnSalir.addActionListener(this);
		btnSalir.setBounds(192, 199, 109, 32);
		contentPane.add(btnSalir);

		/**
		 * Aplicar la imagen de fondo.
		 */

		JLabel fondoMenuPrincipal = new JLabel("");
		fondoMenuPrincipal.setIcon(new ImageIcon("Imagenes\\Almacen.jpg"));
		fondoMenuPrincipal.setBounds(-172, 0, 692, 311);
		contentPane.add(fondoMenuPrincipal);
	}

	/**
	 * Este es el metodo actionPerformed el cual se autogenera cuando implementamos
	 * ActionListener en la clase. En este caso hace de escuchador para los 3
	 * botones que tenemos, el de consultar, el de insertar y el de salir de la
	 * aplicacion.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {

		case BTN_CONSULTAR:

			clsMenuConsultar MenuConsultar = new clsMenuConsultar(objGestor);
			MenuConsultar.setVisible(true);
			MenuConsultar.setLocationRelativeTo(null);
			dispose();

			break;

		case BTN_INSERTAR:

			clsMenuContrasena MenuContrasena = new clsMenuContrasena(objGestor);
			MenuContrasena.setVisible(true);
			MenuContrasena.setLocationRelativeTo(null);
			dispose();

			break;

		case BTN_SALIR:

			System.exit(0);

			break;

		}
	}
}
