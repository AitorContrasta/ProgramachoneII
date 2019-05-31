package LP;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import LN.clsGestor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import static LP.clsConstantesLP.BTN_INSERTAR;
import static LP.clsConstantesLP.BTN_ATRAS;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.border.LineBorder;


/**
 * 
 * @author Aitor Contrasta y Asier Sojo
 *
 */

public class clsInsertarCamiseta extends JFrame implements ActionListener, WindowListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtMarca;
	private JTextField txtColor;
	private JTextField txtPrecio;
	private clsGestor objGestor;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxTalla;
	private JTextField txtID;

	/**
	 * Este JFrame nos muestra los campos que debemos rellenar para poder hacer una
	 * insert correctamente en la base de datos, a demas de un boton para hacer la
	 * insert y otro para volver al formulario naterior. En este caso nos muestra
	 * unos TextFields para poner la marca, color y precio y un ComboBox para
	 * seleccionar la talla de la camiseta.
	 * 
	 * @param _objGestor
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public clsInsertarCamiseta(clsGestor _objGestor) {
		setTitle("INSERTAR CAMISETA");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"Aplicacion\\Imagenes\\Caja.png"));

		this.addWindowListener(this);
		objGestor = _objGestor;

		comboBoxTalla = new JComboBox();
		comboBoxTalla.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBoxTalla.setToolTipText("Talla");
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
		lblMarca.setBounds(233, 72, 46, 14);
		contentPane.add(lblMarca);

		JLabel lblTalla = new JLabel("Talla:");
		lblTalla.setForeground(Color.WHITE);
		lblTalla.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTalla.setBounds(10, 115, 46, 14);
		contentPane.add(lblTalla);

		JLabel lblColor = new JLabel("Color:");
		lblColor.setForeground(Color.WHITE);
		lblColor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblColor.setBounds(233, 117, 46, 14);
		contentPane.add(lblColor);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrecio.setBounds(10, 163, 46, 14);
		contentPane.add(lblPrecio);

		// Crear el boton para ir atras.

		JButton btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon("Imagenes\\Atras.png"));
		btnAtras.setToolTipText("Atras");
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
		btnAtras.setBounds(0, 278, 46, 33);
		contentPane.add(btnAtras);

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
		 * Hacer que aparezca un mensaje antes de escribit y que cuando escribas desaparezca
		 */
		
		TextPrompt placeholder = new TextPrompt(" Ej: Adidas", txtMarca);
	    placeholder.changeAlpha(0.75f);
	    placeholder.changeStyle(Font.ITALIC);
	    placeholder.setForeground(Color.LIGHT_GRAY);
		txtMarca.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtMarca.setToolTipText("Marca");
		txtMarca.setForeground(Color.BLACK);
		txtMarca.setBounds(273, 70, 134, 20);
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
		 * Hacer que aparezca un mensaje antes de escribit y que cuando escribas desaparezca
		 */
		
		TextPrompt placeholderColor = new TextPrompt(" Ej: Negro", txtColor);
		placeholderColor.changeAlpha(0.75f);
		placeholderColor.changeStyle(Font.ITALIC);
		placeholderColor.setForeground(Color.LIGHT_GRAY);
		txtColor.setBorder(new LineBorder(Color.BLACK));
		txtColor.setToolTipText("Color");
		txtColor.setForeground(Color.BLACK);
		txtColor.setBounds(279, 115, 128, 20);
		contentPane.add(txtColor);
		txtColor.setColumns(10);

		txtPrecio = new JTextField();
		txtPrecio.setToolTipText("Precio");
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
		 * Hacer que aparezca un mensaje antes de escribit y que cuando escribas desaparezca
		 */
		
		TextPrompt placeholderPrecio = new TextPrompt(" Ej: 14.99", txtPrecio);
		placeholderPrecio.changeAlpha(0.75f);
		placeholderPrecio.changeStyle(Font.ITALIC);
		placeholderPrecio.setForeground(Color.LIGHT_GRAY);
		txtPrecio.setBorder(new LineBorder(Color.BLACK));
		txtPrecio.setForeground(Color.BLACK);
		txtPrecio.setBounds(54, 161, 134, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);

		txtID = new JTextField();
		/**
		 * Metodo para solo meter numeros
		 */
		txtID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				char c = e.getKeyChar();

				if (c < '0' || c > '9')
					e.consume();

			}
		});

		/**
		 * Hacer que aparezca un mensaje antes de escribit y que cuando escribas desaparezca
		 */
		
		TextPrompt placeholderID = new TextPrompt(" Ej: 1234", txtID);
		placeholderID.changeAlpha(0.75f);
		placeholderID.changeStyle(Font.ITALIC);
		placeholderID.setForeground(Color.LIGHT_GRAY);
	    txtID.setBorder(new LineBorder(Color.BLACK));
		txtID.setToolTipText("ID");
		txtID.setForeground(Color.BLACK);
		txtID.setBounds(31, 70, 157, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);

		JLabel lblID = new JLabel("ID:");
		lblID.setForeground(Color.WHITE);
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblID.setBounds(10, 72, 46, 14);
		contentPane.add(lblID);

		// Crear el ComboBox para seleccionar la talla.

		comboBoxTalla.setModel(new DefaultComboBoxModel(
				new String[] { "Seleccione una talla:", "XS", "S", "M", "L", "XL", "XXL", "XXXL" }));
		comboBoxTalla.setBounds(48, 112, 140, 22);
		contentPane.add(comboBoxTalla);

		// Crear el boton para insertar en la bbdd.

		JButton btnInsertar = new JButton("");
		btnInsertar.setToolTipText("Insertar");
		btnInsertar.setIcon(new ImageIcon("Imagenes\\Insertar.png"));
		btnInsertar.setActionCommand(BTN_INSERTAR);
		btnInsertar.setOpaque(false);
		btnInsertar.setContentAreaFilled(false);
		btnInsertar.setBorderPainted(false);
		btnInsertar.addActionListener(this);
		btnInsertar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnInsertar.setBounds(294, 206, 79, 55);
		contentPane.add(btnInsertar);

		JLabel fondoInsertarTodos = new JLabel("");
		fondoInsertarTodos.setBorder(null);
		fondoInsertarTodos.setIcon(new ImageIcon("Imagenes\\FondoInsertarTodos.jpg"));
		fondoInsertarTodos.setBounds(0, 0, 494, 311);
		contentPane.add(fondoInsertarTodos);
	}

	/**
	 * Este es el metodo actionPerformed el cual se autogenera cuando implementamos
	 * ActionListener en la clase. En este caso hace de escuchador para los 2
	 * botones que tenemos, el de insertar la camiseta en la base de datos, donde
	 * llama objGestor y a su vez al metodo crearCamiseta que recoge los parametros
	 * que le introducimos para hacer la insert en la base de datos y el de atras.
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {

		case BTN_INSERTAR:

			if(txtMarca.getText().isEmpty() || txtID.getText().isEmpty() || txtColor.getText().isEmpty() || txtPrecio.getText().isEmpty()) {
				
				JOptionPane.showMessageDialog(null, "Rellene todos los acmpos");
				
			}else {
				
			
			objGestor.CrearCamiseta(Integer.parseInt(txtID.getText()), txtMarca.getText(),
					comboBoxTalla.getSelectedItem().toString(), txtColor.getText(),
					Double.parseDouble(txtPrecio.getText()));

			// Poner los textFields vacios tras hacer la insert.

			txtMarca.setText("");
			comboBoxTalla.setSelectedIndex(0);
			txtID.setText("");
			txtColor.setText("");
			txtPrecio.setText("");
			JOptionPane.showMessageDialog(null, "Has insertado algo");
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

	@Override
	public void windowOpened(WindowEvent e) {

	}
}
