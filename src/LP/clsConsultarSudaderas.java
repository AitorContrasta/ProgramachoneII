package LP;

import static COMUN.clsConstantes.Capucha;
import static COMUN.clsConstantes.Color;
import static COMUN.clsConstantes.Id;
import static COMUN.clsConstantes.Marca;
import static COMUN.clsConstantes.Precio;
import static COMUN.clsConstantes.Talla;

import static LP.clsConstantesLP.BTN_ATRAS;
import static LP.clsConstantesLP.BTN_CONSULTAR_POR_PRECIO;
import static LP.clsConstantesLP.BTN_CONSULTAR_POR_MARCA;
import static LP.clsConstantesLP.BTN_CONSULTAR_SIN_ORDENAR;


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

import javax.swing.JScrollPane;

import javax.swing.JTable;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

/**
 * 
 * @author Aitor Contrasta y Asier Sojo
 *
 */

public class clsConsultarSudaderas extends JFrame implements WindowListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<itfProperty> miListaSudaderas;
	private JTable table;
	private JPanel contentPane;
	private clsGestor objGestor;

	/**
	 * Este JFrame nos muestra 3 botones que podemos pulsar. Uno para ver las
	 * sudaderas que tebemos almacenadas en la base de datos sin ningun tipo de
	 * orden, es decir, al ritmo que las hemos ido insertando, otro para que nos las
	 * muestre ordenadas por precio y el ultimo boton est para volver atras.
	 * 
	 * @param _objGestor
	 */

	public clsConsultarSudaderas(clsGestor _objGestor) {
		setTitle("CONSULTAR SUDADERA");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"Imagenes\\Caja.png"));

		this.addWindowListener(this);
		objGestor = _objGestor;

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
		btnAtras.setActionCommand(BTN_ATRAS);
		btnAtras.setOpaque(false);
		btnAtras.setContentAreaFilled(false);
		btnAtras.setBorderPainted(false);
		btnAtras.addActionListener(this);
		btnAtras.setBounds(0, 264, 55, 47);
		btnAtras.addActionListener(this);

		// Crear el boton ordenadas.

		JButton btnOrdenadasPrecio = new JButton("<html> ORDENADAS </br> POR PRECIO </html>");
		btnOrdenadasPrecio.addKeyListener(new KeyAdapter() {

			/**
			 * Metodo para utilizar un boton pulsando ENTER
			 */

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					MostrarSudaderasPorPrecio(objGestor);

				}

			}
		});
		btnOrdenadasPrecio.addActionListener(this);
		btnOrdenadasPrecio.setActionCommand(BTN_CONSULTAR_POR_PRECIO);
		btnOrdenadasPrecio.setBounds(31, 44, 120, 48);
		btnOrdenadasPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));

		// Crear el boton sinOrdenar.

		JButton btnSinOrdenar = new JButton("SIN ORDENAR");
		btnSinOrdenar.addKeyListener(new KeyAdapter() {

			/**
			 * Metodo para utilizar un boton pulsando ENTER
			 */

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					MostrarSudaderas(objGestor);

				}

			}
		});
		btnSinOrdenar.addActionListener(this);
		btnSinOrdenar.setActionCommand(BTN_CONSULTAR_SIN_ORDENAR);
		btnSinOrdenar.setBounds(187, 55, 120, 23);
		btnSinOrdenar.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.setLayout(null);

		contentPane.add(lblTitulo);
		contentPane.add(btnOrdenadasPrecio);
		contentPane.add(btnSinOrdenar);
		contentPane.add(btnAtras);
		
		JButton btnOrdenadasMarca = new JButton("<html> ORDENADAS </br> POR MARCA </html>");
		btnOrdenadasMarca.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnOrdenadasMarca.setActionCommand(BTN_CONSULTAR_POR_MARCA);
		btnOrdenadasMarca.addActionListener(this);
		btnOrdenadasMarca.setBounds(334, 44, 120, 47);
		contentPane.add(btnOrdenadasMarca);

		JLabel fondoConsultarTodos = new JLabel("");
		fondoConsultarTodos.setIcon(new ImageIcon("Imagenes\\FondoConsultarTodos.jpg"));
		fondoConsultarTodos.setBounds(0, 0, 494, 311);
		contentPane.add(fondoConsultarTodos);
	
	}

	public void CrearTabla() {

		table = null;

		miListaSudaderas = MostrarSudaderas(objGestor);

		clsTablaSudaderas tcm = new clsTablaSudaderas(miListaSudaderas);

		table = new JTable(tcm);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);
		table.setEnabled(true);
		table.setRowSelectionAllowed(true);
		tcm.fireTableDataChanged();

		JScrollPane jspSudaderas = new JScrollPane(table);
		jspSudaderas.setBounds(18, 100, 457, 164);
		getContentPane().add(jspSudaderas);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("Imagenes\\FondoConsultarTodos.jpg"));
		label.setBounds(-61, 0, 600, 311);
		contentPane.add(label);
		tcm.setData(miListaSudaderas);
	}
	
	public void CrearTablaOrdenadaPrecio() {

		table = null;

		miListaSudaderas = MostrarSudaderasPorPrecio(objGestor);

		clsTablaSudaderas tcm = new clsTablaSudaderas(miListaSudaderas);

		table = new JTable(tcm);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);
		table.setEnabled(true);
		table.setRowSelectionAllowed(true);
		tcm.fireTableDataChanged();

		JScrollPane jspSudaderas = new JScrollPane(table);
		jspSudaderas.setBounds(18, 100, 457, 164);
		getContentPane().add(jspSudaderas);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("Imagenes\\FondoConsultarTodos.jpg"));
		label.setBounds(-61, 0, 600, 311);
		contentPane.add(label);
		tcm.setData(miListaSudaderas);
	}
	
	public void CrearTablaOrdenadaMarca() {

		table = null;

		miListaSudaderas = MostrarSudaderasPorMarca(objGestor);

		clsTablaSudaderas tcm = new clsTablaSudaderas(miListaSudaderas);

		table = new JTable(tcm);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);
		table.setEnabled(true);
		table.setRowSelectionAllowed(true);
		tcm.fireTableDataChanged();

		JScrollPane jspSudaderas = new JScrollPane(table);
		jspSudaderas.setBounds(18, 100, 457, 164);
		getContentPane().add(jspSudaderas);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("Imagenes\\FondoConsultarTodos.jpg"));
		label.setBounds(-61, 0, 600, 311);
		contentPane.add(label);
		tcm.setData(miListaSudaderas);
	}

	/**
	 * Este es el metodo actionPerformed el cual se autogenera cuando implementamos
	 * ActionListener en la clase. En este caso hace de escuchador para los 3
	 * botones que tenemos, el de mostrar las sudaderas que tenemos en la base de
	 * datos ordenadas por precio, donde llama al objGestor y a su vez al metodo
	 * MostrarSudaderasOrdenadas que nos muestra las sudaderas que hemos intruducido
	 * de manera ordenada, el de mostrar las sudaderas pero sin ordenar, como han
	 * ido entrando donde llama al objGestor y a su vez al metodo MostrarSudaderas
	 * que nos muestra las sudaderas sin estar ordenadas y el de atras.
	 */

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {

		case BTN_CONSULTAR_POR_PRECIO:

			CrearTablaOrdenadaPrecio();
			MostrarSudaderasPorPrecio(objGestor);

			break;

		case BTN_CONSULTAR_SIN_ORDENAR:

			CrearTabla();
			MostrarSudaderas(objGestor);

			break;
			
		case BTN_CONSULTAR_POR_MARCA:
		
			CrearTablaOrdenadaMarca();
			MostrarSudaderasPorMarca(objGestor);
			
			break;
			
		case "borra":
			break;

		case BTN_ATRAS:

			clsMenuConsultar MenuConsultar = new clsMenuConsultar(objGestor);
			MenuConsultar.setVisible(true);
			MenuConsultar.setLocationRelativeTo(null);
			dispose();

			break;
		}

	}

	private static ArrayList<itfProperty> MostrarSudaderas(clsGestor objGestor) {

		/**
		 * Este método es el que permite mostrar las sudaderas que tenemos diponibes al
		 * usuario. Mediante el ArrayList de itfProperty conseguimos sacar todos los
		 * atributos de cada prenta y mostrarselos al usuario por pantalla.
		 */

		ArrayList<itfProperty> misSudaderas;
		misSudaderas = objGestor.DameSudaderas();
		@SuppressWarnings("unused")
		String lista = null;

		for (itfProperty s : misSudaderas)
			lista += ("\n·SUDADERA: " + s.getProperty(Id) + s.getProperty(Marca) + " -- " + s.getProperty(Talla)
					+ " -- " + s.getProperty(Color) + " -- " + s.getProperty(Capucha) + " -- " + s.getProperty(Precio));
		return misSudaderas;

	}

	private static ArrayList<itfProperty> MostrarSudaderasPorPrecio(clsGestor objGestor) {

		/**
		 * Este método es el que permite mostras las sudaderas que tenemos diponibes al
		 * usuario, pero esta vez a diferencia de la anterior, las sacaremos ordenadas
		 * por talla. Mediante el ArrayList de itfProperty conseguimos sacar todos los
		 * atributos de cada prenta y mostrarselos al usuario por pantalla.
		 */

		ArrayList<itfProperty> sudaderas;
		sudaderas = objGestor.DameSudaderasOrdenadas();
		@SuppressWarnings("unused")
		String lista = null;

		for (itfProperty s : sudaderas)
			lista += ("\n·SUDADERA: " + s.getProperty(Id) + " - " + s.getProperty(Marca) + " - " + s.getProperty(Talla)
					+ " - " + s.getProperty(Color) + " - " + s.getProperty(Capucha) + " - " + s.getProperty(Precio));
		return sudaderas;

	}
	
	private static ArrayList<itfProperty> MostrarSudaderasPorMarca(clsGestor objGestor){
		
		ArrayList<itfProperty> sudaderas;
		sudaderas = objGestor.DameSudaderasOrdenadosCompareTo();
		@SuppressWarnings("unused")
		String lista = null;
		
		for (itfProperty s : sudaderas)
			lista += ("\n·SUDADERA: " + s.getProperty(Id) + " - " + s.getProperty(Marca) + " - " + s.getProperty(Talla)
					+ " - " + s.getProperty(Color) + " - " + s.getProperty(Capucha) + " - " + s.getProperty(Precio));
		return sudaderas;
		
		
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
