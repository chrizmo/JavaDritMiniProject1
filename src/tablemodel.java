import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import java.awt.Dimension;
import java.awt.GridLayout;

public class tablemodel extends JPanel {
 
    public tablemodel() {
        super(new GridLayout(1,0));
    	
 
        JTable table = new JTable(new Mytablemodel());
        

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
 
        //Add the scroll pane to this panel.
        add(scrollPane);
    }
 
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
        
        private Object[][] data = {
        };
        
        public void insertrows() {
        	Mytablemodel.this.insertrows();
        	
        }
 
        public int getRowCount() {
            return data.length;
        }
        
        public int getColumnCount() {
            return columnNames.length;
        }
        
        // Sets the name for each column
        public String getColumnName(int col) {
            return columnNames[col];
        }
 
        public Object getValueAt(int row, int col) {
            return data[row][col];
        }
 }
 

 
    
    }
 
   