package LP;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LN.clsGestor;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

import static LP.clsConstantesLP.BTN_ATRAS;
import static LP.clsConstantesLP.BTN_BOTAS;
import static LP.clsConstantesLP.BTN_CAMISETAS;
import static LP.clsConstantesLP.BTN_PANTALONES;
import static LP.clsConstantesLP.BTN_SUDADERAS;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Toolkit;;

/**
 * 
 * @author Aitor Contrasta y Asier Sojo
 *
 */

public class clsMenuInsertar extends JFrame implements WindowListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private clsGestor objGestor;

	/**
	 * Este metodo crea un formulario al que llegamos tras haber iniciado sesion.
	 * Este formulario nos brinda 4 opciones a las cuales podemos acceder y
	 * posteriormente insertar alguna prenda en la base de datos. Estas opciones son
	 * la de las camisetas, pantalones, sudaderas y botas. Por ultimo tenemos un
	 * quinto boton que sirve para volver atras.
	 * 
	 * @param _objGestor
	 */

	public clsMenuInsertar(clsGestor _objGestor) {
		setTitle("INSERTAR");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Imagenes\\Caja.png"));

		objGestor = _objGestor;
		this.addWindowListener(this);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 510, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("\u00BFQUE PRODUCTO DESEA INSERTAR?");
		lblTitulo.setForeground(Color.BLACK);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(40, 11, 414, 24);
		contentPane.add(lblTitulo);

		// Creacion del boton de insertar camisetas.

		JButton btnCamisetas = new JButton("CAMISETAS");
		btnCamisetas.addKeyListener(new KeyAdapter() {

			/**
			 * Metodo para utilizar un boton pulsando ENTER
			 */

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					clsInsertarCamiseta InsertarCamiseta = new clsInsertarCamiseta(objGestor);
					InsertarCamiseta.setVisible(true);
					InsertarCamiseta.setLocationRelativeTo(null);
					dispose();

				}

			}
		});
		btnCamisetas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCamisetas.addActionListener(this);
		btnCamisetas.setActionCommand(BTN_CAMISETAS);
		btnCamisetas.setBounds(186, 90, 123, 23);
		contentPane.add(btnCamisetas);

		// Creacion del boton para insertar pantalones.

		JButton btnPantalones = new JButton("PANTALONES");
		btnPantalones.addKeyListener(new KeyAdapter() {

			/**
			 * Metodo para utilizar un boton pulsando ENTER
			 */

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					clsInsertarPantalones InsertarPantalones = new clsInsertarPantalones(objGestor);
					InsertarPantalones.setVisible(true);
					InsertarPantalones.setLocationRelativeTo(null);
					dispose();

				}

			}
		});
		btnPantalones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPantalones.addActionListener(this);
		btnPantalones.setActionCommand(BTN_PANTALONES);
		btnPantalones.setBounds(186, 138, 123, 23);
		contentPane.add(btnPantalones);

		// Creacion del boton para insertar sudaderas.

		JButton btnSudaderas = new JButton("SUDADERAS");
		btnSudaderas.addKeyListener(new KeyAdapter() {

			/**
			 * Metodo para utilizar un boton pulsando ENTER
			 */

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					clsInsertarSudadera InsertarSudadera = new clsInsertarSudadera(objGestor);
					InsertarSudadera.setVisible(true);
					InsertarSudadera.setLocationRelativeTo(null);
					dispose();

				}

			}
		});
		btnSudaderas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSudaderas.addActionListener(this);
		btnSudaderas.setActionCommand(BTN_SUDADERAS);
		btnSudaderas.setBounds(186, 187, 123, 23);
		contentPane.add(btnSudaderas);

		// Creacion del boton para insertar botas.

		JButton btnBotas = new JButton("BOTAS");
		btnBotas.addKeyListener(new KeyAdapter() {

			/**
			 * Metodo para utilizar un boton pulsando ENTER
			 */

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					clsInsertarBotas InsertarBotas = new clsInsertarBotas(objGestor);
					InsertarBotas.setVisible(true);
					InsertarBotas.setLocationRelativeTo(null);
					dispose();

				}

			}
		});
		btnBotas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBotas.addActionListener(this);
		btnBotas.setActionCommand(BTN_BOTAS);
		btnBotas.setBounds(186, 233, 123, 23);
		contentPane.add(btnBotas);

		// Creacion del boton atras.

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
					MenuPrincipal.setLocationRelativeTo(null);
					dispose();

				}

			}
		});
		btnAtras.addActionListener(this);
		btnAtras.setOpaque(false);
		btnAtras.setContentAreaFilled(false);
		btnAtras.setBorderPainted(false);
		btnAtras.setActionCommand(BTN_ATRAS);
		btnAtras.setBounds(0, 270, 48, 41);
		contentPane.add(btnAtras);

		// Añadir imagenes.

		JLabel iconoCamiseta = new JLabel("");
		iconoCamiseta.setIcon(new ImageIcon("Imagenes\\Camiseta.png"));
		iconoCamiseta.setBounds(78, 38, 153, 130);
		contentPane.add(iconoCamiseta);

		JLabel iconoPantalon = new JLabel("");
		iconoPantalon.setIcon(new ImageIcon("Imagenes\\Pantalón.png"));
		iconoPantalon.setBounds(356, 55, 108, 113);
		contentPane.add(iconoPantalon);

		JLabel iconoBota = new JLabel("");
		iconoBota.setIcon(new ImageIcon("Imagenes\\Bota.png"));
		iconoBota.setBounds(356, 173, 70, 83);
		contentPane.add(iconoBota);

		JLabel iconoSudadera = new JLabel("");
		iconoSudadera.setIcon(new ImageIcon("Imagenes\\Sudadera.png"));
		iconoSudadera.setForeground(Color.BLACK);
		iconoSudadera.setBounds(40, 160, 128, 84);
		contentPane.add(iconoSudadera);

		JLabel fondoInsertar = new JLabel("");
		fondoInsertar.setIcon(new ImageIcon("Imagenes\\FondoInsertar.jpg"));
		fondoInsertar.setBounds(0, 0, 494, 311);
		contentPane.add(fondoInsertar);
	}

	/**
	 * Este es el metodo actionPerformed el cual se autogenera cuando implementamos
	 * ActionListener en la clase. En este caso hace de escuchador para los 5
	 * botones que tenemos, el de insertar camisetas, pantalones, sudaderas, botas y
	 * el de atras.
	 */

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {

		case BTN_CAMISETAS:

			clsInsertarCamiseta InsertarCamiseta = new clsInsertarCamiseta(objGestor);
			InsertarCamiseta.setVisible(true);
			InsertarCamiseta.setLocationRelativeTo(null);
			dispose();

			break;

		case BTN_PANTALONES:

			clsInsertarPantalones InsertarPantalones = new clsInsertarPantalones(objGestor);
			InsertarPantalones.setVisible(true);
			InsertarPantalones.setLocationRelativeTo(null);
			dispose();

			break;

		case BTN_SUDADERAS:

			clsInsertarSudadera InsertarSudadera = new clsInsertarSudadera(objGestor);
			InsertarSudadera.setVisible(true);
			InsertarSudadera.setLocationRelativeTo(null);
			dispose();

			break;
		case BTN_BOTAS:

			clsInsertarBotas InsertarBotas = new clsInsertarBotas(objGestor);
			InsertarBotas.setVisible(true);
			InsertarBotas.setLocationRelativeTo(null);
			dispose();

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
	 * se termine la aplicacion directamente, sino que vaya a la anterior pesataña.
	 * Para que esta funcion ocurra en la closeOperation del JFrame hay que ponerle
	 * el DISPOSE_ON_CLOSE. Esto funciona gracias a implementar el WindowListener y
	 * los metodos se autogeneran.
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
