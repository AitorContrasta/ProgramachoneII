package LP;



import static LP.clsConstantesLP.BTN_ATRAS;
import static LP.clsConstantesLP.BTN_INICIAR_SESION;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LN.clsGestor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

/**
 * 
 * @author Aitor Contrasta y Asier Sojo
 *
 */
public class clsMenuContrasena extends JFrame implements WindowListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	public static JTextField txtUser;
	public static JPasswordField pssPass;
	private clsGestor objGestor;

	/**
	 * Con este metodo creamos el formulario al que vamos si clicamos sobre la
	 * opcion insertar. Este formulario sirve para introducir el usuario y la
	 * contraseï¿½a para poder inciar sesion y que gente que no queramos que entre a
	 * insertar cualquier cosa pueda hacerlo.
	 * 
	 * @param _objGestor
	 */
	public clsMenuContrasena(clsGestor _objGestor) {
		setTitle("INICIAR SESI\u00D3N");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"Imagenes\\Caja.png"));

		objGestor = _objGestor;
		this.addWindowListener(this);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 510, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("INTRODUZCA EL USUARIO Y LA CONTRASE\u00D1A");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(40, 11, 414, 27);
		contentPane.add(lblTitulo);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsuario.setBounds(20, 89, 79, 14);
		contentPane.add(lblUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContrasea.setBounds(232, 89, 79, 14);
		contentPane.add(lblContrasea);

		txtUser = new JTextField();
		txtUser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

					if (e.getKeyCode() == KeyEvent.VK_ENTER) {

						final clsDatosUsuario datosUsuario = new clsDatosUsuario();
						final clsMenuInsertar MenuInsertar = new clsMenuInsertar(objGestor);

						if (datosUsuario.probarPass() == 1) {

							JOptionPane.showMessageDialog(null, "Bienvenid@ al sistema!!");
							MenuInsertar.setVisible(true);
							MenuInsertar.setLocationRelativeTo(null);
							dispose();

						} else {
							JOptionPane.showMessageDialog(null, "Error, usuario o contraseña incorrectos");
							txtUser.setText(null);
							pssPass.setText(null);
						}

					}
				

			}
		});
		txtUser.setBounds(71, 87, 117, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);

		pssPass = new JPasswordField();
		pssPass.addKeyListener(new KeyAdapter() {

			/**
			 * Metodo para utilizar un boton pulsando ENTER
			 */
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					final clsDatosUsuario datosUsuario = new clsDatosUsuario();
					final clsMenuInsertar MenuInsertar = new clsMenuInsertar(objGestor);

					if (datosUsuario.probarPass() == 1) {

						JOptionPane.showMessageDialog(null, "ï¿½ï¿½Bienvenid@ al sistema!!");
						MenuInsertar.setVisible(true);
						MenuInsertar.setLocationRelativeTo(null);
						dispose();

					} else {
						JOptionPane.showMessageDialog(null, "Error, usuario o contraseï¿½a incorrectos");
						txtUser.setText(null);
						pssPass.setText(null);
					}

				}

			}
		});
		pssPass.setBounds(304, 88, 130, 18);
		contentPane.add(pssPass);

		@SuppressWarnings("unused")
		final clsDatosUsuario datosUsuario = new clsDatosUsuario();
		@SuppressWarnings("unused")
		final clsMenuInsertar MenuInsertar = new clsMenuInsertar(objGestor);

		// Crear el boto de iniciar sesion.

		JButton btnIniciarSesion = new JButton("INICIAR SESI\u00D3N");
		btnIniciarSesion.setActionCommand(BTN_INICIAR_SESION);
		btnIniciarSesion.addActionListener(this);
		btnIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnIniciarSesion.setBounds(178, 224, 137, 23);
		contentPane.add(btnIniciarSesion);

		// Crear el boton de atras

		JButton btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon("Imagenes\\Atras.png"));
		btnAtras.addKeyListener(new KeyAdapter() {

			/**
			 * Metodo para utilizar un boton pulsando ENTER
			 */

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					clsMenuPrincipal MenuPrincipal = new clsMenuPrincipal(objGestor);
					MenuPrincipal.setVisible(true);
					dispose();

				}

			}
		});
		btnAtras.setActionCommand(BTN_ATRAS);
		btnAtras.setOpaque(false);
		btnAtras.setContentAreaFilled(false);
		btnAtras.setBorderPainted(false);
		btnAtras.addActionListener(this);
		btnAtras.setBounds(0, 269, 50, 42);
		contentPane.add(btnAtras);

		// Aï¿½adir imagenes.

		JLabel iconoCandado = new JLabel("");
		iconoCandado.setIcon(new ImageIcon(
				"Imagenes\\Candado.png"));
		iconoCandado.setBounds(304, 53, 161, 151);
		contentPane.add(iconoCandado);

		JLabel iconoUsuario = new JLabel("");
		iconoUsuario.setIcon(new ImageIcon(
				"Imagenes\\Usuario.png"));
		iconoUsuario.setBounds(62, 49, 145, 155);
		contentPane.add(iconoUsuario);

		JLabel fondoInicioSesion = new JLabel("");
		fondoInicioSesion.setIcon(new ImageIcon(
				"Imagenes\\FondoInicioSesion.jpg"));
		fondoInicioSesion.setBounds(0, 0, 494, 311);
		contentPane.add(fondoInicioSesion);
	}

	/**
	 * Este es el metodo actionPerformed el cual se autogenera cuando implementamos
	 * ActionListener en la clase. En este caso hace de escuchador para los 2
	 * botones que tenemos, el de iniciar sesiï¿½n y el de atras.
	 */

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {

		case BTN_INICIAR_SESION:

			final clsDatosUsuario datosUsuario = new clsDatosUsuario();
			final clsMenuInsertar MenuInsertar = new clsMenuInsertar(objGestor);

			if (datosUsuario.probarPass() == 1) {

				MenuInsertar.setVisible(true);
				MenuInsertar.setLocationRelativeTo(null);
				dispose();

			} else {
				JOptionPane.showMessageDialog(null, "Error, usuario o contraseï¿½a incorrectos");
				txtUser.setText("");
				pssPass.setText("");
			}

			break;

		case BTN_ATRAS:

			clsMenuPrincipal MenuPrincipal = new clsMenuPrincipal(objGestor);
			MenuPrincipal.setVisible(true);
			MenuPrincipal.setLocationRelativeTo(null);
			dispose();

			break;
		}

	}

	@Override
	public void windowOpened(WindowEvent e) {

	}

	/**
	 * Este metodo sirve para que cuando le damos a la X estando en el formulario no
	 * se termine la aplicacion directamente, sino que vaya a la anterior
	 * pesataï¿½a. Para que esta funcion ocurra en la closeOperation del JFrame hay
	 * que ponerle el DISPOSE_ON_CLOSE. Esto funciona gracias a implementar el
	 * WindowListener y los metodos se autogeneran.
	 */

	@Override
	public void windowClosing(WindowEvent e) {
		clsMenuPrincipal MenuPrincipal = new clsMenuPrincipal(objGestor);
		MenuPrincipal.setVisible(true);
		MenuPrincipal.setLocationRelativeTo(null);
	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}
}
