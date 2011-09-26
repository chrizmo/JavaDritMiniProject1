import java.awt.*;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.event.KeyEvent;

/** Class gui. Creates the window with file-menus and buttons
 * @author Jon Arne Westgaard
 */
public class gui extends JFrame {
	public gui() {
		super ("GridBagLayout editor");
	
		// Set layout
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		setLayout( layout);
		
		
		
		// Menubar
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		layout.setConstraints (bar, constraints);
		
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

		// Menubar
		JToolBar ikoner = new JToolBar ();
		ikoner.add (Box.createHorizontalGlue());
		ikoner.addSeparator();
		JButton newButton = new JButton(new ImageIcon("NEW.GIF"));
		newButton.setToolTipText("Create new file, remove existing data");
		JButton loadButton = new JButton(new ImageIcon("OPENDOC.GIF"));
		loadButton.setToolTipText("Load a previously saved file");
		JButton saveButton = new JButton(new ImageIcon("SAVE.GIF"));
		saveButton.setToolTipText("Save this layout to a file");
		JButton previewButton = new JButton(new ImageIcon("ExecuteProject.gif"));
		previewButton.setToolTipText("Show this layout in a preview window");
		JButton generateButton = new JButton(new ImageIcon("SAVEJAVA.GIF"));
		generateButton.setToolTipText("Show this layout in a preview window");
		JButton newrowButton = new JButton(new ImageIcon("NEWROW.GIF"));
		newrowButton.setToolTipText("Add a new row/layout to this layout");
		JButton moveupButton = new JButton(new ImageIcon("MoveRowUp.gif"));
		moveupButton.setToolTipText("Move row up");
		JButton movedownButton = new JButton(new ImageIcon("MoveRowDown.gif"));
		movedownButton.setToolTipText("Move row down");
		JButton aboutButton = new JButton(new ImageIcon("HELP.GIF"));
		aboutButton.setToolTipText("Help on using this software");
		ikoner.add(newButton);
		ikoner.add(loadButton);
		ikoner.add(saveButton);
		ikoner.add(previewButton);
		ikoner.add(generateButton);
		ikoner.add(newrowButton);
		ikoner.add(moveupButton);
		ikoner.add(movedownButton);
		ikoner.add(aboutButton);
		ikoner.setLayout(layout);
		add (ikoner);
		
		pack();
		setVisible (true);
	}
}
