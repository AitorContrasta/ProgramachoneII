package LP;

import static COMUN.clsConstantes.Color;
import static COMUN.clsConstantes.Id;
import static COMUN.clsConstantes.Marca;
import static COMUN.clsConstantes.Precio;
import static COMUN.clsConstantes.Talla;
import static COMUN.clsConstantes.Capucha;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import COMUN.itfProperty;

/**
 * 
 * @author Aitor Contrasta y Asier Sojo
 *
 */

public class clsTablaSudaderas extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	
	private String[] columnNames = {"ID","Marca","Talla","Color", "Capucha", "Precio"};
    Object[][] data;
    
    public clsTablaSudaderas(ArrayList<itfProperty>miListaSudaderas)
    {
    	
    	
    	
		int filas = miListaSudaderas.size();
		int cont;
		data=new Object[filas][];
		cont=0;
		
		for (itfProperty b: miListaSudaderas)
		{
			Object[]a={b.getProperty(Id),
					   b.getProperty(Marca),
					   b.getProperty(Talla),
					   b.getProperty(Color),
					   b.getProperty(Capucha),
					   b.getProperty(Precio),};
			data[cont]=a;
			cont++;
		}
		
    	
    }
    
    public void setData(ArrayList<itfProperty> miListaSudaderas) 
    {
    	int filas = miListaSudaderas.size();
		int cont;
		data=new Object[filas][];
		cont=0;
		
		
		for (itfProperty b: miListaSudaderas)
		{
			Object[]a={b.getProperty(Id),
					   b.getProperty(Marca),
					   b.getProperty(Talla),
					   b.getProperty(Color),
					   b.getProperty(Capucha),
					   b.getProperty(Precio),};
			data[cont]=a;
			cont++;
		}
    }
    
    
    
    
    
    public int getColumnCount() 
    {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    /*
     * JTable uses this method to determine the default renderer/
     * editor for each cell.  If we didn't implement this method,
     * then the last column would contain text ("true"/"false"),
     * rather than a check box.
     */
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {
       
            return false;
       
    }

    /*
     * Don't need to implement this method unless your table's
     * data can change.
     */
    public void setValueAt(Object value, int row, int col) 
    {
        
        data[row][col] = value;
        fireTableCellUpdated(row, col);

    }

}
