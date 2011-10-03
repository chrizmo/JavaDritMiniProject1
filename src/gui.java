import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;

/** Class gui. Creates the window with file-menus and buttons
 * @author Jon Arne Westgaard
 */
public class gui extends JFrame {
	
	private guiEventHandlers evtHandle;
	
	
	public gui() {
		super ("GridBagLayout editor");
		
		evtHandle = new guiEventHandlers();
		
	
				
		// Menubar
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		
		
		// Filemenu
		JMenu fileMenu = new JMenu (prosjekt1.getMessages().getString("file"));
		fileMenu.setMnemonic('F');
		fileMenu.setToolTipText(prosjekt1.getMessages().getString("filettt"));
		
			// Filemenu items
			JMenuItem newItem = new JMenuItem(prosjekt1.getMessages().getString("new"), new ImageIcon("NEW.GIF"));
			newItem.setMnemonic('N');
			newItem.setToolTipText(prosjekt1.getMessages().getString("newttt"));
			newItem.addActionListener(evtHandle.guiNewFile()); // Opens new file, add listener
			fileMenu.add(newItem);
		
			JMenuItem loadItem = new JMenuItem(prosjekt1.getMessages().getString("load"), new ImageIcon("OPENDOC.GIF"));
			loadItem.setMnemonic('L');
			loadItem.setToolTipText(prosjekt1.getMessages().getString("loadttt"));
			loadItem.addActionListener(evtHandle.guiLoadFile());
			fileMenu.add(loadItem);
			
			JMenuItem saveItem = new JMenuItem(prosjekt1.getMessages().getString("save"), new ImageIcon("SAVE.GIF"));
			saveItem.setMnemonic('S');
			saveItem.setToolTipText(prosjekt1.getMessages().getString("savettt"));
			saveItem.addActionListener(evtHandle.guiSaveFile());
			fileMenu.add(saveItem);
			
			JMenuItem saveasItem = new JMenuItem(prosjekt1.getMessages().getString("saveas"), new ImageIcon("SAVEJAVA.GIF"));
			saveasItem.setMnemonic(KeyEvent.VK_A);
			saveasItem.setToolTipText(prosjekt1.getMessages().getString("saveasttt"));
			fileMenu.add(saveasItem);
			
			fileMenu.addSeparator();
			
			JMenuItem previewItem = new JMenuItem(prosjekt1.getMessages().getString("preview"));
			previewItem.setMnemonic('P');
			previewItem.setToolTipText(prosjekt1.getMessages().getString("previewttt"));
			previewItem.addActionListener(evtHandle.guiPreview())
			fileMenu.add(previewItem);
			
			JMenuItem generateItem = new JMenuItem(prosjekt1.getMessages().getString("genjava"), new ImageIcon("SAVEJAVA.GIF"));
			generateItem.setMnemonic(KeyEvent.VK_J);
			generateItem.setToolTipText(prosjekt1.getMessages().getString("genjavattt"));
			fileMenu.add(generateItem);
			
			fileMenu.addSeparator();
			
			JMenuItem exitItem = new JMenuItem(prosjekt1.getMessages().getString("exit"));
			exitItem.setMnemonic('E');
			exitItem.setToolTipText(prosjekt1.getMessages().getString("exitttt"));
			fileMenu.add(exitItem);
			
			bar.add(fileMenu);

		// Editmenu
		JMenu editMenu = new JMenu (prosjekt1.getMessages().getString("edit"));
		editMenu.setMnemonic('E');
		editMenu.setToolTipText(prosjekt1.getMessages().getString("editttt"));
		
			// Editmenu items
			JMenuItem newrowItem = new JMenuItem(prosjekt1.getMessages().getString("newrow"), new ImageIcon("NEWROW.GIF"));
			newrowItem.setToolTipText(prosjekt1.getMessages().getString("newrowttt"));
			editMenu.add(newrowItem);
			
			
			editMenu.addSeparator();
		
			JMenuItem preferencesItem = new JMenuItem(prosjekt1.getMessages().getString("preferences"));
			preferencesItem.setMnemonic('P');
			preferencesItem.setToolTipText(prosjekt1.getMessages().getString("preferencesttt"));
			editMenu.add(preferencesItem);
		
		bar.add(editMenu);

		// Helpmenu
		JMenu helpMenu = new JMenu (prosjekt1.getMessages().getString("help"));
		helpMenu.setMnemonic('H');
		helpMenu.setToolTipText(prosjekt1.getMessages().getString("helpttt"));
		
			// Helpmenu items
			JMenuItem helpItem = new JMenuItem(prosjekt1.getMessages().getString("help"), new ImageIcon("HELP.GIF"));
			helpItem.setMnemonic('H');
			helpItem.setToolTipText(prosjekt1.getMessages().getString("helpttt"));
			helpMenu.add(helpItem);
		
			helpMenu.addSeparator();
			
			JMenuItem aboutItem = new JMenuItem(prosjekt1.getMessages().getString("about"));
			aboutItem.setMnemonic('A');
			aboutItem.setToolTipText(prosjekt1.getMessages().getString("aboutttt"));
			helpMenu.add(aboutItem);
			
		bar.add(helpMenu);

		// Menubar
		JToolBar ikoner = new JToolBar ();
		JButton newButton = new JButton(new ImageIcon("NEW.GIF"));
		newButton.setToolTipText(prosjekt1.getMessages().getString("new"));
		JButton loadButton = new JButton(new ImageIcon("OPENDOC.GIF"));
		loadButton.setToolTipText(prosjekt1.getMessages().getString("loadttt"));
		JButton saveButton = new JButton(new ImageIcon("SAVE.GIF"));
		saveButton.setToolTipText(prosjekt1.getMessages().getString("savettt"));
		JButton previewButton = new JButton(new ImageIcon("ExecuteProject.gif"));
		previewButton.setToolTipText(prosjekt1.getMessages().getString("previewttt"));
		JButton generateButton = new JButton(new ImageIcon("SAVEJAVA.GIF"));
		generateButton.setToolTipText(prosjekt1.getMessages().getString("previewttt"));
		JButton newrowButton = new JButton(new ImageIcon("NEWROW.GIF"));
		newrowButton.setToolTipText(prosjekt1.getMessages().getString("newrowttt"));
		JButton moveupButton = new JButton(new ImageIcon("MoveRowUp.gif"));
		moveupButton.setToolTipText(prosjekt1.getMessages().getString("moveupttt"));
		JButton movedownButton = new JButton(new ImageIcon("MoveRowDown.gif"));
		movedownButton.setToolTipText(prosjekt1.getMessages().getString("movedownttt"));
		JButton aboutButton = new JButton(new ImageIcon("HELP.GIF"));
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
		
		// JTable
		String[] columnNames = {"Type", "Variable Name", "Text", "Row", "Column", "Rows", "Columns", "Fill", "Anchor"};
		Object[] [] data = { { "", "", "", "",""}};
				
			
		JTable table = new JTable(data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(500,700));
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);
	
		
		pack();
		setVisible (true);
	}
}
