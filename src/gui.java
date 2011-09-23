import java.awt.*;
import javax.swing.*;


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
		
			// Filemenu items
			JMenuItem newItem = new JMenuItem("New", new ImageIcon("NEW.GIF"));
			newItem.setMnemonic('N');
			
			fileMenu.add(newItem);
		
			JMenuItem loadItem = new JMenuItem("Load", new ImageIcon("OPENDOC.GIF"));
			loadItem.setMnemonic('L');
			fileMenu.add(loadItem);
			
			JMenuItem saveItem = new JMenuItem("Save", new ImageIcon("SAVE.GIF"));
			saveItem.setMnemonic('S');
			fileMenu.add(saveItem);
			
			JMenuItem saveasItem = new JMenuItem("Save as", new ImageIcon(""));
			saveasItem.setMnemonic('a');
			fileMenu.add(saveasItem);
			
			fileMenu.addSeparator();
			
			JMenuItem previewItem = new JMenuItem("Preview");
			saveasItem.setMnemonic('P');
			fileMenu.add(previewItem);
			
			JMenuItem generateItem = new JMenuItem("Generate Java code", new ImageIcon("SAVEJAVA.GIF"));
			generateItem.setMnemonic('J');
			fileMenu.add(generateItem);
			
			fileMenu.addSeparator();
			
			JMenuItem exitItem = new JMenuItem("Exit");
			exitItem.setMnemonic('E');
			fileMenu.add(exitItem);
			
			bar.add(fileMenu);

		// Editmenu
		JMenu editMenu = new JMenu ("Edit");
		editMenu.setMnemonic('E');
		
			// Editmenu items
			JMenuItem newrowItem = new JMenuItem("New row", new ImageIcon("NEWROW.GIF"));
			editMenu.add(newrowItem);
			
			editMenu.addSeparator();
		
			JMenuItem preferencesItem = new JMenuItem("Preferences");
			preferencesItem.setMnemonic('P');
			editMenu.add(preferencesItem);
		
		bar.add(editMenu);

		// Helpmenu
		JMenu helpMenu = new JMenu ("Help");
		helpMenu.setMnemonic('H');
		
			// Helpmenu items
			JMenuItem helpItem = new JMenuItem("Help", new ImageIcon("HELP.GIF"));
			helpItem.setMnemonic('H');
			helpMenu.add(helpItem);
		
			helpMenu.addSeparator();
			
			JMenuItem aboutItem = new JMenuItem("About");
			aboutItem.setMnemonic('A');
			helpMenu.add(aboutItem);
		
		bar.add(helpMenu);
				
		pack();
		setVisible (true);
	}
}