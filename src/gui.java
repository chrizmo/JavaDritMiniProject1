import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.logging.*;
import javax.swing.JButton;
import javax.swing.JPopupMenu;
/** Class gui. Creates the window with file-menus and buttons
 * @author Jon Arne Westgaard
 */
public class gui extends JFrame {

	
	private File fileLoadTable = null;

	private Logger logger = Logger.getLogger("MyLog");		// Logging mechanism
	final tablemodel t2;							// Our table model used in the system
	final JTable table1;							// The JTable for use in system
	
	public gui() {		
		super (prosjekt1.getMessages().getString("title"));

		//TODO: Decide if this should last
		t2 = new tablemodel();
		table1 = new JTable(t2);

		// Menubar
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		
		
		// Filemenu
		JMenu fileMenu = new JMenu (prosjekt1.getMessages().getString("file"));
		fileMenu.setMnemonic('F');
		fileMenu.setToolTipText(prosjekt1.getMessages().getString("filettt"));
		
			// Filemenu items
			JMenuItem newItem = new JMenuItem(prosjekt1.getMessages().getString("new"), new ImageIcon("icons/NEW.GIF"));
			newItem.setMnemonic('N');
			newItem.setToolTipText(prosjekt1.getMessages().getString("newttt"));
			newItem.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
						t2.ny();
						gui.this.fileLoadTable = null;
			}}); // Creates new file, add listener
			fileMenu.add(newItem);
		
			JMenuItem loadItem = new JMenuItem(prosjekt1.getMessages().getString("load"), new ImageIcon("icons/OPENDOC.GIF"));
			loadItem.setMnemonic('L');
			loadItem.setToolTipText(prosjekt1.getMessages().getString("loadttt"));
			loadItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt){
					gui.this.openFileDialog();
		}}); // Loads new file, add listener
			fileMenu.add(loadItem);
			
			JMenuItem saveItem = new JMenuItem(prosjekt1.getMessages().getString("save"), new ImageIcon("icons/SAVE.GIF"));
			saveItem.setMnemonic('S');
			saveItem.setToolTipText(prosjekt1.getMessages().getString("savettt"));
			saveItem.addActionListener(new ActionListener() {
				public void actionPerformed (ActionEvent evt){
					gui.this.saveFileDialog();
				}
			});
			fileMenu.add(saveItem);
			
			JMenuItem saveasItem = new JMenuItem(prosjekt1.getMessages().getString("saveas"), new ImageIcon("icons/SAVEJAVA.GIF"));
			saveasItem.setMnemonic(KeyEvent.VK_A);
			saveasItem.setToolTipText(prosjekt1.getMessages().getString("saveasttt"));
			fileMenu.add(saveasItem);
			
			fileMenu.addSeparator();
			
			JMenuItem previewItem = new JMenuItem(prosjekt1.getMessages().getString("preview"));
			previewItem.setMnemonic('P');
			previewItem.setToolTipText(prosjekt1.getMessages().getString("previewttt"));
			//previewItem.addActionListener(evtHandle.guiPreview())
			fileMenu.add(previewItem);
			
			JMenuItem generateItem = new JMenuItem(prosjekt1.getMessages().getString("genjava"), new ImageIcon("icons/SAVEJAVA.GIF"));
			generateItem.setMnemonic(KeyEvent.VK_J);
			generateItem.setToolTipText(prosjekt1.getMessages().getString("genjavattt"));
			fileMenu.add(generateItem);
			
			fileMenu.addSeparator();
			
			JMenuItem exitItem = new JMenuItem(prosjekt1.getMessages().getString("exit"));
			exitItem.setMnemonic('E');
			exitItem.setToolTipText(prosjekt1.getMessages().getString("exitttt"));
			exitItem.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					int answer = JOptionPane.showConfirmDialog(gui.this, prosjekt1.getMessages().getString("msgQuitConfirmation"),prosjekt1.getMessages().getString("title"), JOptionPane.YES_NO_CANCEL_OPTION);
					if(answer == 1) // If user wants to save changes
						// TODO: Insert Save code
					
					if(answer != 2) // If user doesn't press cancel
						System.exit(NORMAL); 	// Normal exit event
				}
			});
			fileMenu.add(exitItem);
			
			bar.add(fileMenu);

		// Editmenu
		JMenu editMenu = new JMenu (prosjekt1.getMessages().getString("edit"));
		editMenu.setMnemonic('E');
		editMenu.setToolTipText(prosjekt1.getMessages().getString("editttt"));
		
			// Editmenu items
			JMenuItem newrowItem = new JMenuItem(prosjekt1.getMessages().getString("newrow"), new ImageIcon("icons/NEWROW.GIF"));
			newrowItem.setToolTipText(prosjekt1.getMessages().getString("newrowttt"));
			editMenu.add(newrowItem);
			newrowItem.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e)
	            {
	            	t2.insertRow();
	            }
	        }); 
			
			
			editMenu.addSeparator();
		
			JMenuItem preferencesItem = new JMenuItem(prosjekt1.getMessages().getString("preferences"));
			preferencesItem.setMnemonic('P');
			preferencesItem.setToolTipText(prosjekt1.getMessages().getString("preferencesttt"));
			preferencesItem.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					new guiPrefs();
				}
			});
			editMenu.add(preferencesItem);
		
		bar.add(editMenu);

		// Helpmenu
		JMenu helpMenu = new JMenu (prosjekt1.getMessages().getString("help"));
		helpMenu.setMnemonic('H');
		helpMenu.setToolTipText(prosjekt1.getMessages().getString("helpttt"));
		
			// Helpmenu items
			JMenuItem helpItem = new JMenuItem(prosjekt1.getMessages().getString("help"), new ImageIcon("icons/HELP.GIF"));
			helpItem.setMnemonic('H');
			helpItem.setToolTipText(prosjekt1.getMessages().getString("helpttt"));
			helpMenu.add(helpItem);
			helpItem.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					JOptionPane.showMessageDialog(gui.this,"Fukcing google it!","Please...",JOptionPane.INFORMATION_MESSAGE);
				}
			});
			helpMenu.addSeparator();
			
			JMenuItem aboutItem = new JMenuItem(prosjekt1.getMessages().getString("about"));
			aboutItem.setMnemonic('A');
			aboutItem.setToolTipText(prosjekt1.getMessages().getString("aboutttt"));
			aboutItem.addActionListener(new guiAbout());
			helpMenu.add(aboutItem);
			
		bar.add(helpMenu);

		// Menubar
		JToolBar ikoner = new JToolBar ();
		JButton newButton = new JButton(new ImageIcon("icons/NEW.GIF"));
		newButton.setToolTipText(prosjekt1.getMessages().getString("new"));
		JButton loadButton = new JButton(new ImageIcon("icons/OPENDOC.GIF"));
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				gui.this.openFileDialog();
	}}); // Loads new file, add listener
		loadButton.setToolTipText(prosjekt1.getMessages().getString("loadttt"));
		// Actionlistener:
		newButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	t2.ny();
            	gui.this.fileLoadTable = null;
            }
        }); 
		
		JButton saveButton = new JButton(new ImageIcon("icons/SAVE.GIF"));
		saveButton.setToolTipText(prosjekt1.getMessages().getString("savettt"));
		
		
		JButton previewButton = new JButton(new ImageIcon("icons/ExecuteProject.gif"));
		previewButton.setToolTipText(prosjekt1.getMessages().getString("previewttt"));
		
		
		JButton generateButton = new JButton(new ImageIcon("icons/SAVEJAVA.GIF"));
		generateButton.setToolTipText(prosjekt1.getMessages().getString("previewttt"));
		
		JButton newrowButton = new JButton(new ImageIcon("icons/NEWROW.GIF"));
		newrowButton.setToolTipText(prosjekt1.getMessages().getString("newrowttt"));
		// Actionlistener:
		newrowButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	t2.insertRow();
            }
        });      
		
		
				
		JButton moveupButton = new JButton(new ImageIcon("icons/MoveRowUp.gif"));
		moveupButton.setToolTipText(prosjekt1.getMessages().getString("moveupttt"));
		// Actionlistener:
		moveupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	// Need to check if row is already at the top
            	t2.moverowup(table1.getSelectedRow());
            	}
            
        }); 
		
		
		JButton movedownButton = new JButton(new ImageIcon("icons/MoveRowDown.gif"));
		movedownButton.setToolTipText(prosjekt1.getMessages().getString("movedownttt"));
		// Actionlistener:
		movedownButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	// Need to chek if row is already at the bottom
            	t2.moverowdown(table1.getSelectedRow());
            	
            }
        }); 
		JButton aboutButton = new JButton(new ImageIcon("icons/HELP.GIF"));
		aboutButton.setToolTipText(prosjekt1.getMessages().getString("helpttt"));
	
		
		ikoner.add(newButton);
		ikoner.add(loadButton);
		ikoner.add(saveButton);
		ikoner.add(previewButton);
		ikoner.add(generateButton);
		ikoner.add(newrowButton);
		ikoner.add(moveupButton);
		ikoner.add(movedownButton);
		ikoner.add(aboutButton);
		
		add(ikoner, BorderLayout.NORTH);
		

	
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table1);
        
        //Add the scroll pane to this panel.
        add(scrollPane);
		
    		
        
		pack();
		setVisible (true);
	}

	
	private void openFileDialog() {
		
	try {
		JFileChooser fileChooser = new JFileChooser(".");
		
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);	// Sets mode of the filechooser
		
		int result = fileChooser.showOpenDialog(this);   // Opens file dialog
		
		this.fileLoadTable = fileChooser.getSelectedFile();
		
		if(fileLoadTable == null || result == JFileChooser.CANCEL_OPTION){
			return;
		}
		
		RandomAccessFile randFile = new RandomAccessFile(this.fileLoadTable, "r");
		this.t2.openTableFile(randFile);
		
		setTitle(prosjekt1.getMessages().getString("title") + this.fileLoadTable.getName()); // Sets title of main window 
	}
		catch( Exception e){
			logger.log(Level.WARNING,"Error e: " + e.getMessage());
		}
	}
	
	private void saveFileDialog(){
		    try
		    {
		      if ((this.fileLoadTable == null)) {
		  		
		        JFileChooser fileChooser = new JFileChooser(".");

				fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				
			 fileChooser.showSaveDialog(this);
		      this.fileLoadTable = fileChooser.getSelectedFile();
		      setTitle(prosjekt1.getMessages().getString("title") + this.fileLoadTable.getName());
		      }
		      Object objLocalFile = new RandomAccessFile(this.fileLoadTable, "rw");	// Generate file
		      this.t2.saveToFile((RandomAccessFile)objLocalFile); // Write data to file
		      ((RandomAccessFile)objLocalFile).close();
		    } catch (Exception e) {
		      logger.log(Level.WARNING,"Feil under lagring til fil : " + e.toString());
		    }
		  }

}

