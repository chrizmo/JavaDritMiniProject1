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
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

 public class tablemodel extends AbstractTableModel {
	  private String[] columnNames= {"type", "variablename", "text", "row", "columns", "rows", "columns", "fill", "anchor" } ;
	  private Vector data = new Vector();
	  private Logger logger = Logger.getLogger("MyLog");
	  private final String fileHeader = "GridBagLayout2010";
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
	data.addElement(new componentJLabel("ny" + this.data.size(), "", 1, 1, 1, 1));
	fireTableRowsInserted(this.data.size() - 1, this.data.size() - 1);
	logger.log(Level.FINE,"Ny rad pŒ posisjon " + (this.data.size() - 1));
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
public void setValueAt(Object paramObject, int row, int col)
{
  if (col == 0) {
    int i = ((Integer)paramObject).intValue();
    Object localObject = null;
    switch (i) { case 0:
      localObject = new componentJLabel((component)this.data.elementAt(row));
      this.data.setElementAt(localObject, row);
      break;
    case 1:
      //localObject = new componentJButton((component)this.data.elementAt(row));
      this.data.setElementAt(localObject, row);
      break;
    case 2:
      //localObject = new componentJTextField((component)this.data.elementAt(row));
      this.data.setElementAt(localObject, row);
      break;
    case 3:
      //localObject = new componentJTextArea((component)this.data.elementAt(row));
      this.data.setElementAt(localObject, row);
      break;
    case 4:
      //localObject = new componentJCheckBox((component)this.data.elementAt(row));
      this.data.setElementAt(localObject, row);
      break;
    case 5:
      //localObject = new componentJList((component)this.data.elementAt(row));
      this.data.setElementAt(localObject, row);
      break;
    case 6:
      //localObject = new componentJComboBox((component)this.data.elementAt(row));
      this.data.setElementAt(localObject, row);
      break;
    case 7:
      //localObject = new componentJSpinnerList((component)this.data.elementAt(row));
      this.data.setElementAt(localObject, row);
      break;
    case 8:
      //localObject = new componentJSpinnerNumber((component)this.data.elementAt(row));
      this.data.setElementAt(localObject, row); }
  }
  else
  {
    //((component)this.data.elementAt(row)).setKolonne(col, paramObject);
  }
  fireTableCellUpdated(row, col);
}

 
// Have no idea what this is for...
public Class getColumnClass(int row, int col)
{
  //return getValueAt(0, i).getClass();
  return this.getValueAt(row, col).getClass();
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

public void saveToFile(RandomAccessFile randTblFle) throws IOException{
	
	randTblFle.writeUTF(fileHeader);
	randTblFle.writeInt(this.data.size());
    for (int i = 0; i < this.data.size(); i++) {
      component localKomponent = (component)this.data.elementAt(i);
      localKomponent.tilFil(randTblFle);
    }
    logger.log(Level.FINE, "Written" + this.data.size() + " to file"); //TODO: Internasionalise
}

public void openTableFile(RandomAccessFile randAccFile) throws IOException{
	try {
		String str = randAccFile.readUTF();
		if (!str.equals(fileHeader)) {
			logger.warning("Feil pŒ kontrollstring i filformat, kunne ikke laste inn fil");
			JOptionPane.showMessageDialog(null, prosjekt1.getMessages().getString("fileLoad.baddate"), prosjekt1.getMessages().getString("fileLoad.table"), 0);
			return;
		}
	} catch (Exception e) {
		logger.log(Level.INFO,"Error with file: " + e.getMessage());
		JOptionPane.showMessageDialog(null, prosjekt1.getMessages().getString("fileLoad.baddate"), prosjekt1.getMessages().getString("fileLoad.table"), 0);
		return;
	}
	this.data.removeAllElements();				// Remove all the elements
    int i = randAccFile.readInt();
	
    try {
        for (int j = 0; j < i; j++) {
          component localcomponent = new component();
          Object localObject = null;
          logger.log(Level.FINE, "Leser inn component " + j);
          localcomponent.fraFil(randAccFile);
          switch (localcomponent.getType()) { case 0:
            localObject = new componentJLabel(localcomponent);
            break;
          case 1:
            localObject = new componentJButton(localcomponent);
            break;
          case 2:
            localObject = new componentJTextField(localcomponent);
            ((component)localObject).fraFil(randAccFile);
            break;
          case 3:
            localObject = new componentJTextArea(localcomponent);
            ((component)localObject).fraFil(randAccFile);
            break;
          case 4:
            localObject = new componentJCheckBox(localcomponent);
            break;
          case 5:
            localObject = new componentJList(localcomponent);
            ((component)localObject).fraFil(randAccFile);
            break;
          case 6:
            localObject = new componentJComboBox(localcomponent);
            ((component)localObject).fraFil(randAccFile);
            break;
          case 7:
            localObject = new componentJSpinnerList(localcomponent);
            ((component)localObject).fraFil(randAccFile);
            break;
          case 8:
            localObject = new componentJSpinnerNumber(localcomponent);
            ((component)localObject).fraFil(randAccFile);
          }

          this.data.add(localObject);
        }
      } catch (Exception localException2) {
        logger.log(Level.FINE, "Feil under lesing fra fil : " + localException2.toString());
      }
      fireTableRowsInserted(0, this.data.size() - 1);
      logger.log(Level.FINE, "Lest inn fil med " + this.data.size() + " rader");
}    

}   // End of class tablemodel