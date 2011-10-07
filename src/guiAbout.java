/**
 * 
 * @author Christer Vaskinn
 *
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class guiAbout extends JFrame implements ActionListener{

	public guiAbout (){
		super("About the software");
		JPanel winAbout = new JPanel();
		winAbout.add(new JLabel("Created by Christer Vaskinn and Jon Arne Westgaard"));
		add(winAbout);
	}
	public void actionPerformed(ActionEvent evt){
		this.setVisible(true);
	}
}
