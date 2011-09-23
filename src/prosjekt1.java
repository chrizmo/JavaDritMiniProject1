import java.awt.*;

import javax.swing.*;

public class prosjekt1 extends JFrame {
	
	public prosjekt1 () {
		super ("prosjekt1");
		GridBagLayout layout = new GridBagLayout();
		setLayout( layout);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets (2,2,2,2);
	    
		
		// Filemenu
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		JMenu fileMenu = new JMenu ("File");
		fileMenu.setMnemonic('F');
		JMenuItem newItem = new JMenuItem("New");
		newItem.setMnemonic('N');
		fileMenu.add(newItem);
		JMenuItem loadItem = new JMenuItem("Load");
		loadItem.setMnemonic('L');
		fileMenu.add(loadItem);
		JMenuItem saveItem = new JMenuItem("Save");
		saveItem.setMnemonic('S');
		fileMenu.add(saveItem);
		JMenuItem saveasItem = new JMenuItem("Save as");
		saveasItem.setMnemonic('a');
		fileMenu.add(saveasItem);
		JMenuItem previewItem = new JMenuItem("Preview");
		saveasItem.setMnemonic('P');
		fileMenu.add(previewItem);
		JMenuItem generateItem = new JMenuItem("Generate Java code");
		generateItem.setMnemonic('G');
		fileMenu.add(generateItem);
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.setMnemonic('E');
		fileMenu.add(exitItem);
		JMenu editMenu = new JMenu ("Edit");
		editMenu.setMnemonic('E');
		JMenu helpMenu = new JMenu ("Help");
		helpMenu.setMnemonic('H');
		bar.add(fileMenu);
		bar.add(editMenu);
		bar.add(helpMenu);
		
		
		pack();
		setVisible (true);
		
	}
	
	public static void main (String args[]) {
	prosjekt1 p1 = new prosjekt1();
	p1.setSize(770, 300);
	p1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
	}
	
}
