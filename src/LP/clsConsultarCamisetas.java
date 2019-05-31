package LP;

import static COMUN.clsConstantes.Color;
import static COMUN.clsConstantes.Marca;
import static COMUN.clsConstantes.Precio;
import static COMUN.clsConstantes.Talla;
import static COMUN.clsConstantes.Id;
import static LP.clsConstantesLP.BTN_ATRAS;
import static LP.clsConstantesLP.BTN_CONSULTAR_SIN_ORDENAR;
import static LP.clsConstantesLP.BTN_CONSULTAR_POR_PRECIO;
import static LP.clsConstantesLP.BTN_CONSULTAR_POR_MARCA;


import java.awt.Dimension;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import COMUN.itfProperty;


import LN.clsGestor;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;


import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import java.util.ArrayList;

import java.awt.event.ActionEvent;
import javax.swing.JTable;




import javax.swing.JScrollPane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

/**
 * 
 * @author Aitor Contrasta y Asier Sojo
 *
 */

public class clsConsultarCamisetas extends JFrame implements WindowListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<itfProperty> miListaCamisetas;
	private JPanel contentPane;
	clsGestor objGestor;
	private JTable table;

	/**
	 * Este JFrame nos muestra 3 botones que podemos pulsar. Uno para ver las
	 * camisetas que tebemos almacenadas en la base de datos sin ningun tipo de
	 * orden, es decir, al ritmo que las hemos ido insertando, otro para que nos las
	 * muestre ordenadas por precio y el ultimo boton es para volver atras.
	 * 
	 * @param _objGestor
	 */

	public clsConsultarCamisetas(clsGestor _objGestor) {
		setTitle("CONSULTAR CAMISETA");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"Imagenes\\Caja.png"));

		objGestor = _objGestor;
		this.addWindowListener(this);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 510, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblTitulo = new JLabel("\u00BFDE QU\u00C9 MANERA DESEA CONSULTARLAS?");
		lblTitulo.setForeground(java.awt.Color.BLACK);
		lblTitulo.setBounds(40, 11, 414, 28);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

		// Crear el boton ordenadas po marca.

		JButton btnOrdenadarMarca = new JButton("<html> ORDENADAS </br> POR MARCA </html>");
		btnOrdenadarMarca.addKeyListener(new KeyAdapter() {

			/**
			 * Metodo para utilizar un boton pulsando ENTER
			 */

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					MostrarCamisetasPorMarca(objGestor);

				}

			}
		});
		btnOrdenadarMarca.setBounds(334, 44, 120, 47);
		btnOrdenadarMarca.setActionCommand(BTN_CONSULTAR_POR_MARCA);
		btnOrdenadarMarca.addActionListener(this);
		btnOrdenadarMarca.setFont(new Font("Tahoma", Font.BOLD, 12));

		// Crear el boton sinOrdenar.

		JButton btnSinOrdenar = new JButton("SIN ORDENAR");
		btnSinOrdenar.addKeyListener(new KeyAdapter() {

			/**
			 * Metodo para utilizar un boton pulsando ENTER
			 */

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					MostrarCamisetas(objGestor);

				}

			}
		});
		btnSinOrdenar.setBounds(187, 55, 120, 23);
		btnSinOrdenar.setActionCommand(BTN_CONSULTAR_SIN_ORDENAR);
		btnSinOrdenar.addActionListener(this);
		btnSinOrdenar.setFont(new Font("Tahoma", Font.BOLD, 12));

		// Crear el boton para ir atras.

		JButton btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon("Imagenes\\Atras.png"));
		btnAtras.addKeyListener(new KeyAdapter() {

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
		btnAtras.setBounds(0, 270, 45, 41);
		btnAtras.setActionCommand(BTN_ATRAS);
		btnAtras.setOpaque(false);
		btnAtras.setContentAreaFilled(false);
		btnAtras.setBorderPainted(false);
		btnAtras.addActionListener(this);
		contentPane.setLayout(null);
		contentPane.add(lblTitulo);
		contentPane.add(btnAtras);
		contentPane.add(btnOrdenadarMarca);
		contentPane.add(btnSinOrdenar);
		
		JButton btnOrdenadasPrecio = new JButton("<html> ORDENADAS </br> POR PRECIO </html>");
		btnOrdenadasPrecio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					
					CrearTablaOrdenadaPrecio();
					MostrarCamisetasPorPrecio(objGestor);
					
				}
			}
		});
		btnOrdenadasPrecio.addActionListener(this);
		btnOrdenadasPrecio.setActionCommand(BTN_CONSULTAR_POR_PRECIO);
		btnOrdenadasPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnOrdenadasPrecio.setBounds(31, 44, 120, 48);
		contentPane.add(btnOrdenadasPrecio);
		
		JLabel fondoConsultarTodos = new JLabel("");
		fondoConsultarTodos.setIcon(new ImageIcon("Imagenes\\FondoConsultarTodos.jpg"));
		fondoConsultarTodos.setBounds(0, 0, 494, 311);
		contentPane.add(fondoConsultarTodos);

		

	}

	public void CrearTabla() {

		table = null;

		miListaCamisetas = MostrarCamisetas(objGestor);

		clsTablaCamisetas tcm = new clsTablaCamisetas(miListaCamisetas);

		table = new JTable(tcm);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);
		table.setEnabled(true);
		table.setRowSelectionAllowed(true);
		tcm.fireTableDataChanged();

		JScrollPane jspCamisetas = new JScrollPane(table);
		jspCamisetas.setBounds(18, 100, 457, 164);
		getContentPane().add(jspCamisetas);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("Imagenes\\FondoConsultarTodos.jpg"));
		label.setBounds(-61, 0, 600, 311);
		contentPane.add(label);
		tcm.setData(miListaCamisetas);
	}
	
	public void CrearTablaOrdenadaPrecio() {

		table = null;

		miListaCamisetas = MostrarCamisetasPorPrecio(objGestor);

		clsTablaCamisetas tcm = new clsTablaCamisetas(miListaCamisetas);

		table = new JTable(tcm);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);
		table.setEnabled(true);
		table.setRowSelectionAllowed(true);
		tcm.fireTableDataChanged();

		JScrollPane jspCamisetas = new JScrollPane(table);
		jspCamisetas.setBounds(18, 100, 457, 164);
		getContentPane().add(jspCamisetas);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("Imagenes\\FondoConsultarTodos.jpg"));
		label.setBounds(-61, 0, 600, 311);
		contentPane.add(label);
		tcm.setData(miListaCamisetas);
	}
	
	public void CrearTablaOrdenadaMarca() {

		table = null;

		miListaCamisetas = MostrarCamisetasPorMarca(objGestor);

		clsTablaCamisetas tcm = new clsTablaCamisetas(miListaCamisetas);

		table = new JTable(tcm);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);
		table.setEnabled(true);
		table.setRowSelectionAllowed(true);
		tcm.fireTableDataChanged();

		JScrollPane jspCamisetas = new JScrollPane(table);
		jspCamisetas.setBounds(18, 100, 457, 164);
		getContentPane().add(jspCamisetas);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("Imagenes\\FondoConsultarTodos.jpg"));
		label.setBounds(-61, 0, 600, 311);
		contentPane.add(label);
		tcm.setData(miListaCamisetas);
	}

	/**
	 * Este es el metodo actionPerformed el cual se autogenera cuando implementamos
	 * ActionListener en la clase. En este caso hace de escuchador para los 3
	 * botones que tenemos, el de mostrar las camisetas que tenemos en la base de
	 * datos ordenadas por precio, donde llama al objGestor y a su vez al metodo
	 * MostrarCamisetasOrdenadas que nos muestra las camisetas que hemos intruducido
	 * de manera ordenada, el de mostrar las camisetas pero sin ordenar, como han
	 * ido entrando donde llama al objGestor y a su vez al metodo MostrarCamisetas
	 * que nos muestra las camisetas sin estar ordenadas y el de atras.
	 */

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {

		case BTN_CONSULTAR_POR_MARCA:

			CrearTablaOrdenadaMarca();
			MostrarCamisetasPorMarca(objGestor);

			break;
			
		case BTN_CONSULTAR_POR_PRECIO:
			
			CrearTablaOrdenadaPrecio();
			MostrarCamisetasPorPrecio(objGestor);
			
			break;

		case BTN_CONSULTAR_SIN_ORDENAR:

			CrearTabla();
			MostrarCamisetas(objGestor);

			break;

		case BTN_ATRAS:

			clsMenuConsultar MenuConsultar = new clsMenuConsultar(objGestor);
			MenuConsultar.setVisible(true);
			MenuConsultar.setLocationRelativeTo(null);
			dispose();

			break;
		}
	}

	private static ArrayList<itfProperty> MostrarCamisetas(clsGestor objGestor) {

		/**
		 * Este método es el que permite mostrar las camisetas que tenemos diponibes al
		 * usuario. Mediante el ArrayList de itfProperty conseguimos sacar todos los
		 * atributos de cada prenta y mostrarselos al usuario por pantalla.
		 */

		ArrayList<itfProperty> camisetas;
		camisetas = objGestor.DameCamisetas();
		@SuppressWarnings("unused")
		String lista = null;

		for (itfProperty c : camisetas)
			lista += ("\n·CAMISETA: " + c.getProperty(Id) + " -- " + c.getProperty(Marca) + " -- "
					+ c.getProperty(Talla) + " -- " + c.getProperty(Color) + " -- " + c.getProperty(Precio));
		return camisetas;

	}

	private static ArrayList<itfProperty> MostrarCamisetasPorPrecio(clsGestor objGestor) {

		/**
		 * Este método es el que permite mostras las camisetas que tenemos diponibes al
		 * usuario, pero esta vez a diferencia de la anterior, las sacaremos ordenadas
		 * por talla. Mediante el ArrayList de itfProperty conseguimos sacar todos los
		 * atributos de cada prenta y mostrarselos al usuario por pantalla.
		 */

		ArrayList<itfProperty> camisetas;
		camisetas = objGestor.DameCamisetasOrdenadas();
		@SuppressWarnings("unused")
		String lista = null;

		for (itfProperty c : camisetas)
			lista += ("\n·CAMISETA: " + c.getProperty(Id) + " -- " + c.getProperty(Marca) + " -- "
					+ c.getProperty(Talla) + " -- " + c.getProperty(Color) + " -- " + c.getProperty(Precio));
		return camisetas;
	}
	
	public static ArrayList<itfProperty> MostrarCamisetasPorMarca(clsGestor objGestor){
		
		ArrayList<itfProperty> camisetas;
		camisetas = objGestor.DameCamisetasOrdenadasCompareTo();
		@SuppressWarnings("unused")
		String lista = null;
		
		for (itfProperty c : camisetas)
			lista += ("\n·CAMISETA: " + c.getProperty(Id) + " -- " + c.getProperty(Marca) + " -- "
					+ c.getProperty(Talla) + " -- " + c.getProperty(Color) + " -- " + c.getProperty(Precio));
		return camisetas;
		
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
		clsMenuConsultar MenuConsultar = new clsMenuConsultar(objGestor);
		MenuConsultar.setVisible(true);
		MenuConsultar.setLocationRelativeTo(null);
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
