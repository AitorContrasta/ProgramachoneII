package LP;

import static LP.clsConstantesLP.BTN_ATRAS;
import static LP.clsConstantesLP.BTN_INSERTAR;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LN.clsGestor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
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

public class clsInsertarPantalones extends JFrame implements WindowListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtMarca;
	private JTextField txtColor;
	private JTextField txtPrecio;
	private ButtonGroup botones = new ButtonGroup();
	private clsGestor objGestor;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxTalla, comboBoxMaterial;
	private JRadioButton rdbtnSi, rdbtnNo;
	private JTextField txtID;

	/**
	 * Este JFrame nos muestra los campos que debemos rellenar para poder hacer una
	 * insert correctamente en la base de datos, a demas de un boton para hacer la
	 * insert y otro para volver al formulario naterior. En este caso nos muestra
	 * unos TextFields para poner la marca, color y precio, unos RadioButtons para
	 * decir si es un pantalon corto o no y unos ComboBox para seleccionar la talla
	 * y decir de que material esta hecho el pantalon.
	 * 
	 * @param _objGestor
	 */

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public clsInsertarPantalones(clsGestor _objGestor) {
		setTitle("INSERTAR PANTAL\u00D3N");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\Industria 4.0\\Desktop\\Programaci\u00F3n II\\PROYECTO PROGRAMACI\u00D3N II\\Aplicacion\\Imagenes\\Caja.png"));

		objGestor = _objGestor;
		this.addWindowListener(this);

		comboBoxTalla = new JComboBox();
		comboBoxMaterial = new JComboBox();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 510, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("RELLENE LOS SIGUIENTES CAMPOS");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 11, 414, 24);
		contentPane.add(lblTitulo);

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setForeground(Color.WHITE);
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMarca.setBounds(220, 68, 46, 14);
		contentPane.add(lblMarca);

		JLabel lblTalla = new JLabel("Talla:");
		lblTalla.setForeground(Color.WHITE);
		lblTalla.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTalla.setBounds(10, 109, 46, 14);
		contentPane.add(lblTalla);

		JLabel lblColor = new JLabel("Color:");
		lblColor.setForeground(Color.WHITE);
		lblColor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblColor.setBounds(10, 152, 46, 14);
		contentPane.add(lblColor);

		JLabel lblsonCortos = new JLabel("\u00BFSon cortos?");
		lblsonCortos.setForeground(Color.WHITE);
		lblsonCortos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblsonCortos.setBounds(220, 108, 81, 14);
		contentPane.add(lblsonCortos);

		JLabel lblMaterial = new JLabel("Material:");
		lblMaterial.setForeground(Color.WHITE);
		lblMaterial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaterial.setBounds(220, 155, 60, 14);
		contentPane.add(lblMaterial);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrecio.setBounds(10, 200, 46, 14);
		contentPane.add(lblPrecio);

		txtMarca = new JTextField();
		/**
		 * Metodo para solo meter letras
		 */
		txtMarca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				char c = e.getKeyChar();

				if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {

					e.consume();
				}
			}
		});

		/**
		 * Hacer que aparezca un mensaje antes de escribit y que cuando escribas
		 * desaparezca
		 */

		TextPrompt placeholderMarca = new TextPrompt(" Ej: Nike", txtMarca);
		placeholderMarca.changeAlpha(0.75f);
		placeholderMarca.changeStyle(Font.ITALIC);
		placeholderMarca.setForeground(Color.LIGHT_GRAY);
		txtMarca.setToolTipText("Marca");
		txtMarca.setBounds(267, 66, 157, 20);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);

		txtColor = new JTextField();
		/**
		 * Metodo para solo meter letras
		 */
		txtColor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				char c = e.getKeyChar();

				if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {

					e.consume();
				}

			}
		});
		/**
		 * Hacer que aparezca un mensaje antes de escribit y que cuando escribas
		 * desaparezca
		 */

		TextPrompt placeholderColor = new TextPrompt(" Ej: Gris", txtColor);
		placeholderColor.changeAlpha(0.75f);
		placeholderColor.changeStyle(Font.ITALIC);
		placeholderColor.setForeground(Color.LIGHT_GRAY);
		txtColor.setToolTipText("Color");
		txtColor.setBounds(52, 150, 144, 20);
		contentPane.add(txtColor);
		txtColor.setColumns(10);

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

		TextPrompt placeholderPrecio = new TextPrompt(" Ej: 44.99", txtPrecio);
		placeholderPrecio.changeAlpha(0.75f);
		placeholderPrecio.changeStyle(Font.ITALIC);
		placeholderPrecio.setForeground(Color.LIGHT_GRAY);
		txtPrecio.setToolTipText("Precio");
		txtPrecio.setBounds(57, 197, 139, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);

		// Crear el ComboBox para seleccionar la talla.

		comboBoxTalla = new JComboBox();
		comboBoxTalla.setToolTipText("Talla");
		comboBoxTalla.setModel(new DefaultComboBoxModel(
				new String[] { "Seleccione una talla:", "XS", "S", "M", "L", "XL", "XXL", "XXXL" }));
		comboBoxTalla.setBounds(49, 105, 147, 22);
		contentPane.add(comboBoxTalla);

		// Crear los RadioButtons.

		rdbtnSi = new JRadioButton("S\u00CD");
		rdbtnSi.setToolTipText("Corto");
		rdbtnSi.setForeground(Color.WHITE);
		rdbtnSi.setBounds(306, 104, 46, 23);
		contentPane.add(rdbtnSi);
		// Quitarle el fondo al RadioButton
		rdbtnSi.setOpaque(false);
		rdbtnSi.setContentAreaFilled(false);
		rdbtnSi.setBorderPainted(false);

		rdbtnNo = new JRadioButton("NO");
		rdbtnNo.setToolTipText("Largo");
		rdbtnNo.setForeground(Color.WHITE);
		rdbtnNo.setBounds(354, 104, 46, 23);
		contentPane.add(rdbtnNo);
		// Quitarle el fondo al RadioButton
		rdbtnNo.setOpaque(false);
		rdbtnNo.setContentAreaFilled(false);
		rdbtnNo.setBorderPainted(false);

		// Hacer que solo se pueda seleccionar UN RadioButton.

		botones.add(rdbtnSi);
		botones.add(rdbtnNo);

		// Creacion del boton para ir atras.

		JButton btnAtras = new JButton("");
		btnAtras.setToolTipText("Atras");
		btnAtras.setIcon(new ImageIcon(
				"C:\\Users\\Industria 4.0\\Desktop\\Programaci\u00F3n II\\PROYECTO PROGRAMACI\u00D3N II\\Aplicacion\\Imagenes\\Atras.png"));
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
		btnAtras.setBounds(0, 270, 46, 41);
		contentPane.add(btnAtras);

		JLabel lblID = new JLabel("ID:");
		lblID.setForeground(Color.WHITE);
		lblID.setBounds(10, 69, 46, 14);
		contentPane.add(lblID);

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
		txtID.setBounds(35, 66, 161, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);

		// Crear el ComboBox para seleccionar el material.

		comboBoxMaterial = new JComboBox();
		comboBoxMaterial.setToolTipText("Material");
		comboBoxMaterial.setModel(new DefaultComboBoxModel(
				new String[] { "Seleccione un material:", "Chandal", "Pana", "Vaqueros", "Cuero" }));
		comboBoxMaterial.setBounds(276, 152, 130, 22);
		contentPane.add(comboBoxMaterial);

		// Crear el boton para insertar en la bbdd.

		JButton btnInsertar = new JButton("");
		btnInsertar.setToolTipText("Insertar");
		btnInsertar.setIcon(new ImageIcon(
				"C:\\Users\\Industria 4.0\\Desktop\\Programaci\u00F3n II\\PROYECTO PROGRAMACI\u00D3N II\\Aplicacion\\Imagenes\\Insertar.png"));
		btnInsertar.setActionCommand(BTN_INSERTAR);
		btnInsertar.setOpaque(false);
		btnInsertar.setContentAreaFilled(false);
		btnInsertar.setBorderPainted(false);
		btnInsertar.addActionListener(this);
		btnInsertar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnInsertar.setBounds(276, 214, 99, 65);
		contentPane.add(btnInsertar);

		JLabel fondoInsertarTodos = new JLabel("");
		fondoInsertarTodos.setIcon(new ImageIcon(
				"C:\\Users\\Industria 4.0\\Desktop\\Programaci\u00F3n II\\PROYECTO PROGRAMACI\u00D3N II\\Aplicacion\\Imagenes\\FondoInsertarTodos.jpg"));
		fondoInsertarTodos.setBounds(0, 0, 494, 311);
		contentPane.add(fondoInsertarTodos);

	}

	/**
	 * Este es el metodo actionPerformed el cual se autogenera cuando implementamos
	 * ActionListener en la clase. En este caso hace de escuchador para los 2
	 * botones que tenemos, el de insertar el pantalon en la base de datos, donde
	 * llama objGestor y a su vez al metodo crearPantalon que recoge los parametros
	 * que le introducimos para hacer la insert en la base de datos y el de atras.
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {

		case BTN_INSERTAR:

			if (txtMarca.getText().isEmpty() || txtID.getText().isEmpty() || txtColor.getText().isEmpty()
					|| txtPrecio.getText().isEmpty() || botones.isSelected(null)) {

				JOptionPane.showMessageDialog(null, "Rellene todos los acmpos");

			} else {

				String largo = null;

				if (rdbtnSi.isSelected()) {

					largo = "Si";

				} else {

					if (rdbtnNo.isSelected()) {

						largo = "No";

					} else
						largo = "";

				}

				objGestor.CrearPantalon(Integer.parseInt(txtID.getText()), txtMarca.getText(),
						comboBoxTalla.getSelectedItem().toString(), largo, txtColor.getText(),
						comboBoxMaterial.getSelectedItem().toString(), Double.parseDouble(txtPrecio.getText()));

				// Poner los textFields vacios tras hacer la insert.

				comboBoxTalla.setSelectedIndex(0);
				txtColor.setText("");
				txtMarca.setText("");
				botones.clearSelection();
				comboBoxMaterial.setSelectedIndex(0);
				txtPrecio.setText("");
				txtID.setText("");
				JOptionPane.showMessageDialog(null, "Has insertado un pantalón");
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
