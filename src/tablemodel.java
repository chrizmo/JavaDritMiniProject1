import javax.swing.JFrame;
import javax.swing.table.TableColumn;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Vector;

public class tablemodel extends JPanel {
 
    public tablemodel() {
        super(new GridLayout(1,0));
    	
 
        JTable table = new JTable(new Mytablemodel());
        
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
 
        //Add the scroll pane to this panel.
        add(scrollPane);
    }   // End of public tablemodel
 
    class Mytablemodel extends AbstractTableModel {
        private String[] columnNames = {prosjekt1.getMessages().getString("type"),
        								prosjekt1.getMessages().getString("variablename"),
        								prosjekt1.getMessages().getString("text"),
        								prosjekt1.getMessages().getString("row"),
        								prosjekt1.getMessages().getString("column"),
        								prosjekt1.getMessages().getString("rows"),
        								prosjekt1.getMessages().getString("columns"),
        								prosjekt1.getMessages().getString("fill"),
        								prosjekt1.getMessages().getString("anchor"), 
                                        };
        
        // Let's give Vector a try instead... 
        //private Object[][] data = {{"a","a","a","a","a","a","a","a","a"} };
        private Vector data = new Vector();
        
        // Insert a row
        public void insertrow() {
        this.data.add("hei");
        }
 
        // Get size
        public int getRowCount() {
            return this.data.size();
        }
        
        // Get length
        public int getColumnCount() {
            return this.columnNames.length;
        }
        
        // Sets the name for each column
        public String getColumnName(int col) {
            return this.columnNames[col];
        }
 
        // **** This needs to be fixed, should take 2 parameters ****
        public Object getValueAt(int row, int col) {
            return this.data.elementAt(row);
        }
        
        
 

    	} // End of class mytablemodel
    
  } // End of class tablemodel
 
   