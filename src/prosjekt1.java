import java.util.*;
import java.util.logging.*;

import javax.swing.JFrame;

/** Main-class, creates a new gui-object, sets size and DefaultCloseOperation.
 *  @author Jon Arne Westgaard */
public class prosjekt1 {
	
	
	
	private static ResourceBundle messages = ResourceBundle.getBundle("MessageBundle", Locale.getDefault());
	
	public static ResourceBundle getMessages() {
		try{
			return messages;
		}
		catch (Exception e){	
			System.out.printf("Error: %s from %s \n", e.getMessage(),e.getClass().getSimpleName());
			return null;
		}
	}
	
	public static void main (String args[]) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	gui g1 = new gui();
        		g1.setSize(770, 300);
        		g1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
		
		
		
		
	}	
}