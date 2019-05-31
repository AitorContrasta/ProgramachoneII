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
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
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

public class clsInsertarSudadera extends JFrame implements WindowListener, ActionListener {

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
	private JComboBox comboBoxTalla;
	private JRadioButton rdbtnSi, rdbtnNo;
	private JTextField txtID;

	/**
	 * Este JFrame nos muestra los campos que debemos rellenar para poder hacer una
	 * insert correctamente en la base de datos, a demas de un boton para hacer la
	 * insert y otro para volver al formulario naterior. En este caso nos muestra
	 * unos textFields para rellenar la marca, color y precio, un ComboBox para
	 * seleccionar la talla y un RadioButton para decir si tiene capucha o no.
	 * 
	 * @param _objGestor
	 */

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public clsInsertarSudadera(clsGestor _objGestor) {
		setTitle("INSERTAR SUDADERA");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"Imagenes\\Caja.png"));

		objGestor = _objGestor;
		this.addWindowListener(this);

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
		lblTitulo.setBounds(10, 11, 414, 26);
		contentPane.add(lblTitulo);

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setForeground(Color.WHITE);
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMarca.setBounds(222, 59, 46, 14);
		contentPane.add(lblMarca);

		JLabel lblTalla = new JLabel("Talla:");
		lblTalla.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTalla.setForeground(Color.WHITE);
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTalla.setBounds(10, 102, 36, 14);
		contentPane.add(lblTalla);

		JLabel lblColor = new JLabel("Color:");
		lblColor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblColor.setForeground(Color.WHITE);
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblColor.setBounds(222, 102, 46, 14);
		contentPane.add(lblColor);

		JLabel lbltieneCapucha = new JLabel("\u00BFTiene capucha?");
		lbltieneCapucha.setForeground(Color.WHITE);
		lbltieneCapucha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbltieneCapucha.setBounds(10, 147, 102, 14);
		contentPane.add(lbltieneCapucha);

		// Creacion de los RadioButton.

		rdbtnSi = new JRadioButton("S\u00CD");
		rdbtnSi.setToolTipText("Con capucha");
		rdbtnSi.setForeground(Color.WHITE);
		rdbtnSi.setBounds(118, 143, 46, 23);
		contentPane.add(rdbtnSi);
		// Quitarle el fondo al RadioButton
		rdbtnSi.setOpaque(false);
		rdbtnSi.setContentAreaFilled(false);
		rdbtnSi.setBorderPainted(false);

		rdbtnNo = new JRadioButton("NO");
		rdbtnNo.setToolTipText("Sin capucha");
		rdbtnNo.setForeground(Color.WHITE);
		rdbtnNo.setBounds(163, 143, 49, 23);
		contentPane.add(rdbtnNo);
		// Quitarle el fondo al RadioButton
		rdbtnNo.setOpaque(false);
		rdbtnNo.setContentAreaFilled(false);
		rdbtnNo.setBorderPainted(false);

		// Hacer que solo se pueda seleccionar UN RadioButton.

		botones.add(rdbtnSi);
		botones.add(rdbtnNo);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrecio.setBounds(222, 149, 46, 14);
		contentPane.add(lblPrecio);

		// Crear el ComboBox para seleccionar la talla.

		comboBoxTalla = new JComboBox();
		comboBoxTalla.setToolTipText("Talla");
		comboBoxTalla.setModel(new DefaultComboBoxModel(
				new String[] { "Seleccione una talla:", "XS", "S", "M", "L", "XL", "XXL", "XXXL" }));
		comboBoxTalla.setBounds(45, 100, 154, 22);
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
		 * Hacer que aparezca un mensaje antes de escribir y que cuando escribas
		 * desaparezca
		 */

		TextPrompt placeholderMarca = new TextPrompt(" Ej: Lyle & Scott", txtMarca);
		placeholderMarca.changeAlpha(0.75f);
		placeholderMarca.changeStyle(Font.ITALIC);
		placeholderMarca.setForeground(Color.LIGHT_GRAY);
		txtMarca.setToolTipText("Marca");
		txtMarca.setBounds(262, 57, 162, 20);
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

				if (!Character.isLetter(c) && c!=KeyEvent.VK_SPACE) {
					
					e.consume();
				}
			}
		});
		/**
		 * Hacer que aparezca un mensaje antes de escribir y que cuando escribas
		 * desaparezca
		 */

		TextPrompt placeholderColor = new TextPrompt(" Ej: Granate", txtColor);
		placeholderColor.changeAlpha(0.75f);
		placeholderColor.changeStyle(Font.ITALIC);
		placeholderColor.setForeground(Color.LIGHT_GRAY);
		txtColor.setToolTipText("Color");
		txtColor.setBounds(257, 100, 167, 20);
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

		TextPrompt placeholderPrecio = new TextPrompt(" Ej: 59.99", txtPrecio);
		placeholderPrecio.changeAlpha(0.75f);
		placeholderPrecio.changeStyle(Font.ITALIC);
		placeholderPrecio.setForeground(Color.LIGHT_GRAY);
		txtPrecio.setToolTipText("Precio");
		txtPrecio.setBounds(267, 147, 157, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);

		// Crear el boton para ir atras.

		JButton btnAtras = new JButton("");
		btnAtras.setToolTipText("Atr\u00E1s");
		btnAtras.setIcon(new ImageIcon("Imagenes\\Atras.png"));
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

		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblId.setForeground(Color.WHITE);
		lblId.setBounds(10, 48, 46, 37);
		contentPane.add(lblId);

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
		txtID.setBounds(33, 57, 166, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		btnAtras.setBounds(0, 274, 46, 37);
		contentPane.add(btnAtras);

		// Crear el boton para insertar en bbdd.

		JButton btnInsertar = new JButton("");
		btnInsertar.setToolTipText("Insertar");
		btnInsertar.setIcon(new ImageIcon("Imagenes\\Insertar.png"));
		btnInsertar.setActionCommand(BTN_INSERTAR);
		btnInsertar.setOpaque(false);
		btnInsertar.setContentAreaFilled(false);
		btnInsertar.setBorderPainted(false);
		btnInsertar.addActionListener(this);
		btnInsertar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnInsertar.setBounds(279, 226, 81, 61);
		contentPane.add(btnInsertar);

		JLabel fondoInsertarTodos = new JLabel("");
		fondoInsertarTodos.setIcon(new ImageIcon(
				"Imagenes\\FondoInsertarTodos.jpg"));
		fondoInsertarTodos.setBounds(0, 0, 494, 311);
		contentPane.add(fondoInsertarTodos);
	}

	/**
	 * Este es el metodo actionPerformed el cual se autogenera cuando implementamos
	 * ActionListener en la clase. En este caso hace de escuchador para los 2
	 * botones que tenemos, el de insertar la sudadera en la base de datos, donde
	 * llama objGestor y a su vez al metodo crearSudadera que recoge los parametros
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

				String capucha = null;

				if (rdbtnSi.isSelected()) {

					capucha = "Si";

				} else {

					if (rdbtnNo.isSelected()) {

						capucha = "No";

					} else

						capucha = "";

				}

				objGestor.CrearSudadera(Integer.parseInt(txtID.getText()), txtMarca.getText(),
						comboBoxTalla.getSelectedItem().toString(), txtColor.getText(), capucha,
						Double.parseDouble(txtPrecio.getText()));

				// Poner los textFields vacios tras hacer la insert.

				txtID.setText("");
				comboBoxTalla.setSelectedIndex(0);
				txtColor.setText("");
				txtMarca.setText("");
				botones.clearSelection();
				txtPrecio.setText("");
				txtID.setText("");
				JOptionPane.showMessageDialog(null, "Has insertado una sudadera");
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
