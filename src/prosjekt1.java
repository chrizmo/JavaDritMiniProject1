import java.awt.*;

import javax.swing.*;

public class prosjekt1 extends JFrame {
	
	public prosjekt1 () {
		super ("prosjekt1");
		GridBagLayout layout = new GridBagLayout();
		setLayout( layout);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets (2,2,2,2);
	        JLabel label1;
		label1 = new JLabel("Her trenger vi litt mer innhold...");
		add(label1);
		
		pack();
		setVisible (true);
		
	}
	
	public static void main (String args[]) {
	prosjekt1 p1 = new prosjekt1();
	p1.setSize(770, 300);
	p1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
	}
	
}
