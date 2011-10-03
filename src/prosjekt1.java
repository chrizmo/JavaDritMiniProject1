import java.util.Locale;
import java.util.*;

import javax.swing.JFrame;

/** Main-class, creates a new gui-object, sets size and DefaultCloseOperation.
 *  @author Jon Arne Westgaard */

public class prosjekt1 {
	private static ResourceBundle messages = ResourceBundle.getBundle("MessageBundle", Locale.getDefault());
	
	public static ResourceBundle getMessages() {
	return messages;	
	}
	
	public static void main (String args[]) {
		
		
		
		gui g1 = new gui();
		g1.setSize(770, 300);
		g1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}	
}