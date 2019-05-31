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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static LP.clsConstantesLP.BTN_CAMISETAS;
import static LP.clsConstantesLP.BTN_PANTALONES;
import static LP.clsConstantesLP.BTN_SUDADERAS;
import static LP.clsConstantesLP.BTN_BOTAS;
import static LP.clsConstantesLP.BTN_ATRAS;
import java.awt.Color;
import java.awt.Toolkit;

/**
 * 
 * @author Aitor Contrasta y Asier Sojo
 *
 */

public class clsMenuConsultar extends JFrame implements WindowListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private clsGestor objGestor;

	/**
	 * Este formulario nos ofrece 5 opciones. Las cuatro primeras nos llevan a otros
	 * formularios en los que podremos consultar las prendas de ropa que tenemos
	 * introducidas en la base de datos. El primero nos llevara a las camisetas, el
	 * segundo a los pantalones, el tercero a las sudaderas y el cuarto a las botas.
	 * Por ultimo esta el de atras para volver al formulario anterior.
	 * 
	 * @param _objGestor
	 */

	public clsMenuConsultar(clsGestor _objGestor) {
		setTitle("CONSULTAR");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Imagenes\\Caja.png"));

		objGestor = _objGestor;
		this.addWindowListener(this);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 510, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("\u00BFQUE PRODUCTO DESEA CONSULTAR?");
		lblTitulo.setForeground(Color.BLACK);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(48, 33, 414, 22);
		contentPane.add(lblTitulo);

		// Crear el boton de atras.

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
		btnAtras.setBounds(0, 268, 52, 43);
		contentPane.add(btnAtras);

		// Crear el boton para consultar camisetas.

		JButton btnCamisetas = new JButton("CAMISETAS");
		btnCamisetas.setActionCommand(BTN_CAMISETAS);
		btnCamisetas.addKeyListener(new KeyAdapter() {

			/**
			 * Metodo para utilizar un boton pulsando ENTER
			 */

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					clsConsultarCamisetas ConsultarCamisetas = new clsConsultarCamisetas(objGestor);
					ConsultarCamisetas.setVisible(true);
					ConsultarCamisetas.setLocationRelativeTo(null);
					dispose();

				}

			}
		});
		btnCamisetas.addActionListener(this);
		btnCamisetas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCamisetas.setBounds(192, 84, 110, 23);
		contentPane.add(btnCamisetas);

		// Crear el boton para consultar pantalones.

		JButton btnPantalones = new JButton("PANTALONES");
		btnPantalones.addKeyListener(new KeyAdapter() {

			/**
			 * Metodo para utilizar un boton pulsando ENTER
			 */

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					clsConsultarPantalones ConsultarPantalones = new clsConsultarPantalones(objGestor);
					ConsultarPantalones.setVisible(true);
					ConsultarPantalones.setLocationRelativeTo(null);
					dispose();

				}

			}
		});
		btnPantalones.addActionListener(this);
		btnPantalones.setActionCommand(BTN_PANTALONES);
		btnPantalones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPantalones.setBounds(192, 132, 110, 23);
		contentPane.add(btnPantalones);

		// Crear el boton para consultar sudaderas.

		JButton btnSudaderas = new JButton("SUDADERAS");
		btnSudaderas.addKeyListener(new KeyAdapter() {

			/**
			 * Metodo para utilizar un boton pulsando ENTER
			 */

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					clsConsultarSudaderas ConsultarSudaderas = new clsConsultarSudaderas(objGestor);
					ConsultarSudaderas.setVisible(true);
					ConsultarSudaderas.setLocationRelativeTo(null);
					dispose();

				}

			}

		});
		btnSudaderas.addActionListener(this);
		btnSudaderas.setActionCommand(BTN_SUDADERAS);
		btnSudaderas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSudaderas.setBounds(192, 179, 110, 23);
		contentPane.add(btnSudaderas);

		// Crear el boton para consultar botas.

		JButton btnBotas = new JButton("BOTAS");
		btnBotas.addKeyListener(new KeyAdapter() {

			/**
			 * Metodo para utilizar un boton pulsando ENTER
			 */

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					clsConsultarBotas ConsultarBotas = new clsConsultarBotas(objGestor);
					ConsultarBotas.setVisible(true);
					ConsultarBotas.setLocationRelativeTo(null);
					dispose();

				}

			}
		});
		btnBotas.addActionListener(this);
		btnBotas.setActionCommand(BTN_BOTAS);
		btnBotas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBotas.setBounds(192, 225, 110, 23);
		contentPane.add(btnBotas);

		// Añadir imagenes

		JLabel iconoCamiseta = new JLabel("");
		iconoCamiseta.setIcon(new ImageIcon(
				"Imagenes\\Camiseta.png"));
		iconoCamiseta.setBounds(48, 47, 153, 130);
		contentPane.add(iconoCamiseta);

		JLabel iconoPantalon = new JLabel("");
		iconoPantalon.setIcon(new ImageIcon(
				"Imagenes\\Pantal\u00F3n.png"));
		iconoPantalon.setBounds(319, 83, 86, 67);
		contentPane.add(iconoPantalon);

		JLabel iconoSudadera = new JLabel("");
		iconoSudadera.setIcon(new ImageIcon(
				"Imagenes\\Sudadera.png"));
		iconoSudadera.setBounds(10, 171, 150, 86);
		contentPane.add(iconoSudadera);

		JLabel iconoBota = new JLabel("");
		iconoBota.setIcon(new ImageIcon(
				"Imagenes\\Bota.png"));
		iconoBota.setBounds(319, 179, 81, 72);
		contentPane.add(iconoBota);

		JLabel fondoConsultar = new JLabel("");
		fondoConsultar.setIcon(new ImageIcon("Imagenes\\FondoConsutar.jpg"));
		fondoConsultar.setBounds(0, 0, 494, 311);
		contentPane.add(fondoConsultar);
	}

	/**
	 * Este es el metodo actionPerformed el cual se autogenera cuando implementamos
	 * ActionListener en la clase. En este caso hace de escuchador para los 5
	 * botones que tenemos, el de consultar camisetas, pantalones, sudaderas, botas
	 * y el de atras.
	 */

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {

		case BTN_CAMISETAS:

			clsConsultarCamisetas ConsultarCamisetas = new clsConsultarCamisetas(objGestor);
			ConsultarCamisetas.setVisible(true);
			ConsultarCamisetas.setLocationRelativeTo(null);
			dispose();

			break;

		case BTN_PANTALONES:

			clsConsultarPantalones ConsultarPantalones = new clsConsultarPantalones(objGestor);
			ConsultarPantalones.setVisible(true);
			ConsultarPantalones.setLocationRelativeTo(null);
			dispose();

			break;

		case BTN_SUDADERAS:

			clsConsultarSudaderas ConsultarSudaderas = new clsConsultarSudaderas(objGestor);
			ConsultarSudaderas.setVisible(true);
			ConsultarSudaderas.setLocationRelativeTo(null);
			dispose();

			break;
		case BTN_BOTAS:

			clsConsultarBotas ConsultarBotas = new clsConsultarBotas(objGestor);
			ConsultarBotas.setVisible(true);
			ConsultarBotas.setLocationRelativeTo(null);
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
