import java.awt.event.ActionEvent;
import java.util.*;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * 
 * @author Christer Vaskinn
 *
 * Implements the 
 */
public class guiEventHandlers extends JFrame {

	public guiEventHandlers() {
		
	}
	
/**
 * Opens the about window
 */
	//@Override // Compiler time check for overridden methods 
	public void guiAbout(){
		
	}
	
	public void guiNewFile(){
		
	}
	
	public void guiLoadFile(){
		 try
		    {
		      JFileChooser localJFileChooser = new JFileChooser(".");
		      int i = localJFileChooser.showSaveDialog(null);
		      if (i != 0) {
		        return;
		      }
		      //this.aktivFil = localJFileChooser.getSelectedFile();
		      //setTitle(spraak.getString("main.window.title") + this.aktivFil.getName());
		      //RandomAccessFile localRandomAccessFile = new RandomAccessFile(this.aktivFil, "r");
		      //this.data.lastModell(localRandomAccessFile);
		      //localRandomAccessFile.close();
		    } catch (Exception localException) {
		      JOptionPane.showMessageDialog(this, "Feil under lesing fra fil : " + localException.toString());
		    }
		  //}
	}
	
	public void guiSaveFile(){
		
	}
	
	public void guiPreview() {
	
	}
}
