import java.awt.*;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.event.KeyEvent;


public class gui extends JFrame {
	public gui() {
		super ("gui");
		
		// Set layout
		GridBagLayout layout = new GridBagLayout();
		setLayout( layout);
		GridBagConstraints constraints = new GridBagConstraints();
		
		
		// Menubar
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		
		// Filemenu
		JMenu fileMenu = new JMenu ("File");
		fileMenu.setMnemonic('F');
		fileMenu.setToolTipText("File related operations");
		
			// Filemenu items
			JMenuItem newItem = new JMenuItem("New", new ImageIcon("NEW.GIF"));
			newItem.setMnemonic('N');
			newItem.setToolTipText("Create new file, remove existing data");
			
			fileMenu.add(newItem);
		
			JMenuItem loadItem = new JMenuItem("Load", new ImageIcon("OPENDOC.GIF"));
			loadItem.setMnemonic('L');
			loadItem.setToolTipText("Load a previously saved file");
			fileMenu.add(loadItem);
			
			JMenuItem saveItem = new JMenuItem("Save", new ImageIcon("SAVE.GIF"));
			saveItem.setMnemonic('S');
			saveItem.setToolTipText("Save this layout to a file");
			fileMenu.add(saveItem);
			
			JMenuItem saveasItem = new JMenuItem("Save as", new ImageIcon("SAVEJAVA.GIF"));
			saveasItem.setMnemonic(KeyEvent.VK_A);
			saveasItem.setToolTipText("Save this layout to a file other than the active one");
			fileMenu.add(saveasItem);
			
			fileMenu.addSeparator();
			
			JMenuItem previewItem = new JMenuItem("Preview");
			previewItem.setMnemonic('P');
			previewItem.setToolTipText("Show this layout in a preview window");
			fileMenu.add(previewItem);
			
			JMenuItem generateItem = new JMenuItem("Generate Java code", new ImageIcon("SAVEJAVA.GIF"));
			generateItem.setMnemonic(KeyEvent.VK_J);
			generateItem.setToolTipText("Write the Java code for this layout to file");
			fileMenu.add(generateItem);
			
			fileMenu.addSeparator();
			
			JMenuItem exitItem = new JMenuItem("Exit");
			exitItem.setMnemonic('E');
			exitItem.setToolTipText("Terminate the program");
			fileMenu.add(exitItem);
			
			bar.add(fileMenu);

		// Editmenu
		JMenu editMenu = new JMenu ("Edit");
		editMenu.setMnemonic('E');
		editMenu.setToolTipText("Editing operations");
		
			// Editmenu items
			JMenuItem newrowItem = new JMenuItem("New row", new ImageIcon("NEWROW.GIF"));
			newrowItem.setToolTipText("Add a new row/component to the layout");
			editMenu.add(newrowItem);
			
			
			editMenu.addSeparator();
		
			JMenuItem preferencesItem = new JMenuItem("Preferences");
			preferencesItem.setMnemonic('P');
			preferencesItem.setToolTipText("Edit personal preferences");
			editMenu.add(preferencesItem);
		
		bar.add(editMenu);

		// Helpmenu
		JMenu helpMenu = new JMenu ("Help");
		helpMenu.setMnemonic('H');
		helpMenu.setToolTipText("Help related operations");
		
			// Helpmenu items
			JMenuItem helpItem = new JMenuItem("Help", new ImageIcon("HELP.GIF"));
			helpItem.setMnemonic('H');
			helpItem.setToolTipText("Overview of how the program works");
			helpMenu.add(helpItem);
		
			helpMenu.addSeparator();
			
			JMenuItem aboutItem = new JMenuItem("About");
			aboutItem.setMnemonic('A');
			aboutItem.setToolTipText("Information about the application");
			helpMenu.add(aboutItem);
		
		bar.add(helpMenu);

		
		pack();
		setVisible (true);
	}
}
