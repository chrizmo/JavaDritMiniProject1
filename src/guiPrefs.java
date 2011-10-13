import javax.swing.*;		// Swing objects
//import java.awt.event.*;	// Action listener stuff	
import java.awt.*;
import java.util.*;			// For
import java.awt.event.*;	// For the listeners
import java.util.prefs.Preferences; // Preferences
import java.util.logging.*;

/**
 * Implements the functions necessary for the user preference windows
 * 
 * @author Christer Vaskinn
 *
 */

public class guiPrefs extends JFrame{
/**
 * Constructor for preference window
 */
	Logger logger = Logger.getLogger("MyLog");
	
	public guiPrefs(){
		super(prosjekt1.getMessages().getString("winPreferencesTitle"));
		try{
			GridBagLayout thisLayout = new GridBagLayout(); // Sets the window to gridbag
			GridBagConstraints wplCons = new GridBagConstraints();  // Constraints for new file
			this.setLayout(thisLayout);
			wplCons.insets = new Insets(5,5,5,5);		// Sets internal padding
			wplCons.fill = GridBagConstraints.HORIZONTAL;
			wplCons.gridx = 0;
			wplCons.gridy = 0;
			wplCons.gridwidth = 1;
			wplCons.weightx = 3;
			wplCons.anchor = GridBagConstraints.EAST;
			this.add(new JLabel(prosjekt1.getMessages().getString("winPreferenceIceCreamQuestion")),wplCons);
			
			wplCons.gridx = 2;
			wplCons.gridy = 0;
			wplCons.gridwidth = GridBagConstraints.REMAINDER;
			this.add(genJCombo(),wplCons);
			
			wplCons.gridx = 0;
			wplCons.gridy = 5;
			wplCons.weightx = 1;
			wplCons.gridwidth = 2;
			JButton btnCancel = new JButton(prosjekt1.getMessages().getString("stdDialogCancel"));
			this.add(btnCancel,wplCons);
			wplCons.gridx = 2;
			wplCons.gridwidth = 2;
			wplCons.gridy = 5;
			wplCons.weightx = 1;
			JButton btnOK = new JButton(prosjekt1.getMessages().getString("stdDialogOK"));
			this.add(btnOK,wplCons);
			pack();
		
			btnCancel.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					guiPrefs.this.setVisible(false);
				}
			});
			
			this.setSize((int)this.getSize().getWidth() + 20, (int)this.getSize().getHeight() + 10);
			this.setVisible(true);
			
		
		}
		catch(Exception pEx){
			logger.log(Level.WARNING, pEx.getMessage());
		}
	}
	
	private JComboBox genJCombo(){
		try{
			String[] test = {"Vanilla", "Strawberry","Chocolate"};
		//String[] test = prosjekt1.getMessages().getStringArray("winPreferenceIceCreamFlavors.String[]");
			System.out.println(test);
			JComboBox loveIceCream = new JComboBox(test);
			loveIceCream.setEditable(true);
			loveIceCream.setMaximumRowCount(3);
			return (loveIceCream);
			}
			catch(Exception e){
				logger.log(Level.WARNING,e.getMessage());
				return(new JComboBox(new String[] {"Error!"}));
			}

	}

}
