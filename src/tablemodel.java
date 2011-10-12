import javax.swing.JFrame;
import javax.swing.table.TableColumn;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Vector;

 class tablemodel extends AbstractTableModel {
	  private String[] columnNames= {"nisse", "variablename", "text", "row", "columns", "rows", "columns", "fill", "anchor" } ;
	  private Vector data = new Vector();
    

    tablemodel() {

    	this.columnNames[0] =  prosjekt1.getMessages().getString("type");
    	this.columnNames[1] =  prosjekt1.getMessages().getString("variablename");
    	this.columnNames[2] =  prosjekt1.getMessages().getString("text");
    	this.columnNames[3] =  prosjekt1.getMessages().getString("row");
    	this.columnNames[4] =  prosjekt1.getMessages().getString("column");
    	this.columnNames[5] =  prosjekt1.getMessages().getString("rows");
    	this.columnNames[6] =  prosjekt1.getMessages().getString("columns");
    	this.columnNames[7] =  prosjekt1.getMessages().getString("fill");
    	this.columnNames[8] =  prosjekt1.getMessages().getString("anchor");
    	insertRow();
                }	
 


// Insert a row
public void insertRow() {
this.data.addElement(1+this.data.size());	// Just to confirm that we can add rows
this.data.addElement(1+this.data.size());
this.data.addElement(1+this.data.size());

fireTableRowsInserted(this.data.size() - 1, this.data.size() - 1);
}


// Delete a row
public void deleteRow (int row) {
	this.data.removeElementAt(row);
	fireTableRowsDeleted(0,row);
}

// Create a new table, delete everything in the current one
public void ny() {
	int size = this.data.size();
	this.data.removeAllElements();
	fireTableRowsDeleted(0,size);
}

// Return number of rows
public int getRowCount() {
return this.data.size();
}

// Get number of columns
public int getColumnCount() {
return this.columnNames.length;
}

// Sets the name for each column
public String getColumnName(int col) {
return this.columnNames[col].toString();
}

// ***NEED TO BE FIXED***
// Obtain value in particular row and column
public Object getValueAt(int row, int col) {
	
return this.data.elementAt(row);
}

// Set cell to editable
public boolean isCellEditable(int row, int col) {
	return true; 
}
        

// Set value at
public void setValueAt(Object value, int row, int col) {
    //this.data.elementAt(row) = value;
    fireTableCellUpdated(row, col);
}
 
// Have no idea what this is for...
public Class getColumnClass(int i)
{
  return getValueAt(0, i).getClass();
}





 }   // End of class tablemodel