/**
 * 
 * @author Christer Vaskinn
 *
 */

import javax.swing.*;		// For the fileChooser
//import java.awt.*;			// Awt stuff
import java.io.File;
public class guiLoad extends JComponent {
	
	public void guiLoad(){
		System.out.println("Function ran!");
		this.openFileDialog();
	}
	
	private File openFileDialog(){
		JFileChooser fileChooser = new JFileChooser();
		
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		
		int result = fileChooser.showOpenDialog(this);
		
		if(result == JFileChooser.CANCEL_OPTION)
			System.exit(1);
		File fileName = fileChooser.getSelectedFile();
		
		if( (fileName == null) || fileName.getName().equals("")){
			JOptionPane.showMessageDialog(this, "Invalid Name", "Invalid Name",JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		
		return(fileName);		// Return filename to function
		
	}
}
