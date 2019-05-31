package LP;

import static LP.clsConstantesLP.BTN_ATRAS;
import static LP.clsConstantesLP.BTN_INSERTAR;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LN.clsGestor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

/**
 * 
 * @author Aitor Contrasta y Asier Sojo
 *
 */

public class clsInsertarBotas extends JFrame implements WindowListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtColor;
	private JTextField txtPrecio;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private ButtonGroup botones = new ButtonGroup();
	private clsGestor objGestor;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxSuela, comboBoxTalla;
	JRadioButton rdbtnPiel, rdbtnSintetico;
	private JTextField txtID;

	/**
	 * Este JFrame nos muestra los campos que debemos rellenar para poder hacer una
	 * insert correctamente en la base de datos, a demas de un boton para hacer la
	 * insert y otro para volver al formulario naterior. En este caso nos muestra
	 * unos TextFields para poner la marca, modelo, color y precio, unos
	 * RadioButtons para decir si es una bota de piel o sintetica y unos ComboBox
	 * para seleccionar la talla y decir que tipo de suela tiene la bota.
	 * 
	 * @param _objGestor
	 */

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public clsInsertarBotas(clsGestor _objGestor) {
		setTitle("INSERTAR BOTA");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"Imagenes\\Caja.png"));

		this.addWindowListener(this);
		objGestor = _objGestor;

		comboBoxSuela = new JComboBox();
		comboBoxTalla = new JComboBox();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 510, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("RELLENE LOS SIGUIENTES CAMPOS");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(10, 11, 414, 25);
		contentPane.add(lblTitulo);

		// Crear el boton para ir atras.

		JButton btnAtras = new JButton("");
		btnAtras.setToolTipText("Atras");
		btnAtras.setIcon(new ImageIcon(
				"Imagenes\\Atras.png"));
		btnAtras.addKeyListener(new KeyAdapter() {

			/**
			 * Metodo para utilizar un boton pulsando ENTER
			 */

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					clsMenuInsertar MenuInsertar = new clsMenuInsertar(objGestor);
					MenuInsertar.setVisible(true);
					MenuInsertar.setLocationRelativeTo(null);
					dispose();

				}
			}
		});
		btnAtras.setActionCommand(BTN_ATRAS);
		btnAtras.setOpaque(false);
		btnAtras.setContentAreaFilled(false);
		btnAtras.setBorderPainted(false);
		btnAtras.addActionListener(this);
		btnAtras.setBounds(0, 277, 46, 34);
		contentPane.add(btnAtras);

		JLabel lblMarca = new JLabel("Talla:");
		lblMarca.setForeground(Color.WHITE);
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMarca.setBounds(219, 137, 46, 14);
		contentPane.add(lblMarca);

		JLabel lblTalla = new JLabel("Marca:");
		lblTalla.setForeground(Color.WHITE);
		lblTalla.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTalla.setBounds(216, 59, 46, 14);
		contentPane.add(lblTalla);

		JLabel lblColor = new JLabel("Color:");
		lblColor.setForeground(Color.WHITE);
		lblColor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblColor.setBounds(216, 97, 46, 14);
		contentPane.add(lblColor);

		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setForeground(Color.WHITE);
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblModelo.setBounds(10, 95, 51, 14);
		contentPane.add(lblModelo);

		JLabel lblSuela = new JLabel("Suela:");
		lblSuela.setForeground(Color.WHITE);
		lblSuela.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSuela.setBounds(10, 137, 46, 14);
		contentPane.add(lblSuela);

		JLabel lblMaterial = new JLabel("Material:");
		lblMaterial.setForeground(Color.WHITE);
		lblMaterial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaterial.setBounds(10, 180, 51, 14);
		contentPane.add(lblMaterial);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrecio.setBounds(218, 176, 46, 14);
		contentPane.add(lblPrecio);

		txtColor = new JTextField();
		/**
		 * Metodo para solo meter letras
		 */
		txtColor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				char c = e.getKeyChar();

				if (!Character.isLetter(c) && c!=KeyEvent.VK_SPACE) {
					
					e.consume();
				}
			}
		});
		/**
		 * Hacer que aparezca un mensaje antes de escribit y que cuando escribas
		 * desaparezca
		 */

		TextPrompt placeholderColor = new TextPrompt(" Ej: Blanco", txtColor);
		placeholderColor.changeAlpha(0.75f);
		placeholderColor.changeStyle(Font.ITALIC);
		placeholderColor.setForeground(Color.LIGHT_GRAY);
		txtColor.setToolTipText("Color");
		txtColor.setBounds(254, 95, 170, 20);
		contentPane.add(txtColor);
		txtColor.setColumns(10);

		// Crear el ComboBox para elegir el tipo de suela.

		comboBoxSuela = new JComboBox();
		comboBoxSuela.setToolTipText("Suela");
		comboBoxSuela.setModel(new DefaultComboBoxModel(new String[] { "Seleccione el tipo de suela:", "TF (Turf)",
				"AG (Artificial Ground)", "FG (Firm Ground)", "SG (Soft Ground)" }));
		comboBoxSuela.setBounds(53, 134, 138, 22);
		contentPane.add(comboBoxSuela);

		txtPrecio = new JTextField();
		txtPrecio.addKeyListener(new KeyAdapter() {
			/**
			 * Metodo para meter numeros y un punto decimal
			 */
			@Override
			public void keyTyped(KeyEvent e) {

				if (!Character.isDigit(e.getKeyChar()) && e.getKeyChar() != '.') {
					e.consume();
				}

				if (e.getKeyChar() == '.' && txtPrecio.getText().contains(".")) {
					e.consume();
				}
			}
		});
		/**
		 * Hacer que aparezca un mensaje antes de escribit y que cuando escribas
		 * desaparezca
		 */

		TextPrompt placeholderPrecio = new TextPrompt(" Ej: 119.99", txtPrecio);
		placeholderPrecio.changeAlpha(0.75f);
		placeholderPrecio.changeStyle(Font.ITALIC);
		placeholderPrecio.setForeground(Color.LIGHT_GRAY);
		txtPrecio.setToolTipText("Precio");
		txtPrecio.setBounds(265, 174, 159, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);

		// Crear los RadioButtons.

		rdbtnPiel = new JRadioButton("Piel");
		rdbtnPiel.setToolTipText("Piel");
		rdbtnPiel.setForeground(new Color(255, 255, 255));
		rdbtnPiel.setBounds(62, 176, 59, 23);
		contentPane.add(rdbtnPiel);
		// Quitarle el fondo al RadioButton
		rdbtnPiel.setOpaque(false);
		rdbtnPiel.setContentAreaFilled(false);
		rdbtnPiel.setBorderPainted(false);

		rdbtnSintetico = new JRadioButton("Sint\u00E9tico");
		rdbtnSintetico.setToolTipText("Sint\u00E9tico");
		rdbtnSintetico.setForeground(Color.WHITE);
		rdbtnSintetico.setBounds(109, 176, 82, 23);
		contentPane.add(rdbtnSintetico);
		// Quitarle el fondo al RadioButton
		rdbtnSintetico.setOpaque(false);
		rdbtnSintetico.setContentAreaFilled(false);
		rdbtnSintetico.setBorderPainted(false);

		// Hacer que solo se pueda seleccionar UN RadioButton.

		botones.add(rdbtnPiel);
		botones.add(rdbtnSintetico);

		// Crear el ComboBox para seleccionar la talla.

		comboBoxTalla = new JComboBox();
		comboBoxTalla.setToolTipText("Talla");
		comboBoxTalla.setModel(new DefaultComboBoxModel(new String[] { "Seleccione la talla:", "40", "40.5", "41",
				"41.5", "42", "42.5", "43", "43.5", "44", "44.5", "45", "45.5" }));
		comboBoxTalla.setBounds(257, 134, 167, 22);
		contentPane.add(comboBoxTalla);

		txtMarca = new JTextField();
		/**
		 * Metodo para solo meter letras
		 */
		txtMarca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				char c = e.getKeyChar();

				if (!Character.isLetter(c) && c!=KeyEvent.VK_SPACE) {
					
					e.consume();
				}
			}
		});
		/**
		 * Hacer que aparezca un mensaje antes de escribit y que cuando escribas
		 * desaparezca
		 */

		TextPrompt placeholderMarca = new TextPrompt(" Ej: Puma", txtMarca);
		placeholderMarca.changeAlpha(0.75f);
		placeholderMarca.changeStyle(Font.ITALIC);
		placeholderMarca.setForeground(Color.LIGHT_GRAY);
		txtMarca.setToolTipText("Marca");
		txtMarca.setBounds(259, 57, 165, 20);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);

		txtModelo = new JTextField();
		/**
		 * Metodo para solo meter letras
		 */
		txtModelo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				char c = e.getKeyChar();

				if (!Character.isLetter(c) && c!=KeyEvent.VK_SPACE) {
					
					e.consume();
				}
			}
		});
		/**
		 * Hacer que aparezca un mensaje antes de escribit y que cuando escribas
		 * desaparezca
		 */

		TextPrompt placeholderModelo = new TextPrompt(" Ej: Future", txtModelo);
		placeholderModelo.changeAlpha(0.75f);
		placeholderModelo.changeStyle(Font.ITALIC);
		placeholderModelo.setForeground(Color.LIGHT_GRAY);
		txtModelo.setToolTipText("Modelo");
		txtModelo.setBounds(67, 93, 124, 20);
		contentPane.add(txtModelo);
		txtModelo.setColumns(10);

		// Crear el boton para insertar en la bbdd.

		JButton btnInsertar = new JButton("");
		btnInsertar.setToolTipText("Insertar");
		btnInsertar.setIcon(new ImageIcon(
				"Imagenes\\Insertar.png"));
		btnInsertar.setActionCommand(BTN_INSERTAR);
		btnInsertar.setOpaque(false);
		btnInsertar.setContentAreaFilled(false);
		btnInsertar.setBorderPainted(false);
		btnInsertar.addActionListener(this);
		btnInsertar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnInsertar.setBounds(303, 227, 81, 60);
		contentPane.add(btnInsertar);

		txtID = new JTextField();
		/**
		 * Metodo para solo meter numeros
		 */
		txtID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				char c = e.getKeyChar();

				if (c < '0' || c > '9' || c == '.')
					e.consume();

			}
		});
		/**
		 * Hacer que aparezca un mensaje antes de escribit y que cuando escribas
		 * desaparezca
		 */

		TextPrompt placeholderID = new TextPrompt(" Ej: 1234", txtID);
		placeholderID.changeAlpha(0.75f);
		placeholderID.changeStyle(Font.ITALIC);
		placeholderID.setForeground(Color.LIGHT_GRAY);
		txtID.setToolTipText("ID");
		txtID.setBounds(35, 57, 156, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);

		JLabel lblID = new JLabel("ID:");
		lblID.setForeground(Color.WHITE);
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblID.setBounds(10, 59, 46, 14);
		contentPane.add(lblID);

		JLabel fondoInsertarTodos = new JLabel("");
		fondoInsertarTodos.setIcon(new ImageIcon(
				"Imagenes\\FondoInsertarTodos.jpg"));
		fondoInsertarTodos.setBounds(0, 0, 494, 311);
		contentPane.add(fondoInsertarTodos);
	}

	/**
	 * Este es el metodo actionPerformed el cual se autogenera cuando implementamos
	 * ActionListener en la clase. En este caso hace de escuchador para los 2
	 * botones que tenemos, el de insertar una botas en la base de datos, donde
	 * llama objGestor y a su vez al metodo crearBota que recoge los parametros que
	 * le introducimos para hacer la insert en la base de datos y el de atras.
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {

		case BTN_INSERTAR:

			if (txtMarca.getText().isEmpty() || txtID.getText().isEmpty() || txtColor.getText().isEmpty()
					|| txtPrecio.getText().isEmpty() || txtModelo.getText().isEmpty() || botones.isSelected(null)) {

				JOptionPane.showMessageDialog(null, "Rellene todos los acmpos");

			} else {

				String material = null;

				if (rdbtnPiel.isSelected()) {

					material = "Piel";

				} else {

					if (rdbtnSintetico.isSelected()) {

						material = "Sintético";

					} else

						material = "";

				}

				objGestor.CrearBota(Integer.parseInt(txtID.getText()), txtMarca.getText(), txtModelo.getText(),
						txtColor.getText(), comboBoxSuela.getSelectedItem().toString(),
						Double.parseDouble((String) comboBoxTalla.getSelectedItem()), material,
						Double.parseDouble(txtPrecio.getText()));

				// Poner los textFields vacios tras hacer la insert.

				comboBoxTalla.setSelectedIndex(0);
				txtColor.setText("");
				txtMarca.setText("");
				txtModelo.setText("");
				comboBoxSuela.setSelectedIndex(0);
				botones.clearSelection();
				txtPrecio.setText("");
				txtID.setText("");
				JOptionPane.showMessageDialog(null, "Has insertado una bota");
			}
			break;

		case BTN_ATRAS:

			clsMenuInsertar MenuInsertar = new clsMenuInsertar(objGestor);
			MenuInsertar.setVisible(true);
			MenuInsertar.setLocationRelativeTo(null);
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
		clsMenuInsertar MenuInsertar = new clsMenuInsertar(objGestor);
		MenuInsertar.setVisible(true);
		MenuInsertar.setLocationRelativeTo(null);
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
