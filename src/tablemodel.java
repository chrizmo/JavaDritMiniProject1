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
import javax.swing.*;

 public class tablemodel extends AbstractTableModel {
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
                }	
 


// Insert a row
public void insertRow() {
data.addElement(1+this.data.size());

fireTableRowsInserted(this.data.size() - 1, this.data.size() - 1);
}

// Delete a row
public void deleteRow (int row) {
	this.data.removeElementAt(row);
	fireTableRowsDeleted(0,row);
}

// Create a new table, delete everything in the current one
public void ny() {
	this.data.removeAllElements();
	fireTableRowsDeleted(0,this.data.size());
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
//
public Object getValueAt(int row, int col) {
	switch(col) {
	case 0: return data.elementAt(row);
	case 1: return data.elementAt(row);
	case 2: return data.elementAt(row);
	case 3: return data.elementAt(row);
	case 4: return data.elementAt(row);
	case 5: return data.elementAt(row);
	case 6: return data.elementAt(row);
	case 7: return data.elementAt(row);
	case 8: return data.elementAt(row);
	}
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

// Move row up
public void moverowup(int row)
{
  if ((row >= 0) && (row < this.data.size() - 1)) {
    Object localObject = this.data.elementAt(row);
    deleteRow(row);
    this.data.insertElementAt(localObject, row - 1);
    fireTableRowsInserted(row - 1, row - 1);

  }
}

// Move row down
public void moverowdown(int row)
{
  if (row <= this.data.size() - 1) {
    Object localObject = this.data.elementAt(row);
    deleteRow(row);
    this.data.insertElementAt(localObject, row + 1);
    fireTableRowsInserted(row + 1, row + 1);
  }
}


 }   // End of class tablemodel