import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JSpinner;

/**
 * 
 * @author Christer Vaskinn
 *
 */

 public class componentJComboBox extends component
 {
   double width;
   double height;
   boolean brukDefaultComboBoxModel = true;
   //JComboBoxEditorGBL editor;
   JDialog dialog;
 
   public componentJComboBox()
   {
     this.type = 6;
     this.width = 0.0D; this.height = 0.0D;
   }
 
   public componentJComboBox(component paramcomponent)
   {
     super(paramcomponent);
     this.type = 6;
     this.width = 0.0D; this.height = 0.0D;
   }
 
   public componentJComboBox(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
   {
     super(paramInt1, paramInt2, paramInt4, paramInt3);
     this.type = 6;
     this.variablename = paramString1;
     this.text = paramString2;
     this.width = 0.0D; this.height = 0.0D;
   }
 
   public void showExtrasEditor(JFrame paramJFrame)
   { // TODO: FIX THIS!
	   /*
   }
     this.editor = new JComboBoxEditorGBL();
     this.editor.width.setValue(new Double(this.width));
     this.editor.height.setValue(new Double(this.height));
     this.editor.brukDefaultComboBoxModel.setSelected(this.brukDefaultComboBoxModel);
     this.dialog = new JDialog(paramJFrame, prosjekt1.getMessages().getString("comboBoxEditorGBL.windowtitle"), true);
     this.dialog.getContentPane().add(this.editor);
     this.dialog.pack();
     this.dialog.setSize((int)this.dialog.getSize().getWidth() + 20, (int)this.dialog.getSize().getHeight() + 10);
     this.dialog.setLocation(100, 100);
     this.editor.ok.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent paramActionEvent) {
         componentJComboBox.this.width = ((Double)componentJComboBox.this.editor.width.getValue()).doubleValue();
         componentJComboBox.this.height = ((Double)componentJComboBox.this.editor.height.getValue()).doubleValue();
         componentJComboBox.this.brukDefaultComboBoxModel = componentJComboBox.this.editor.brukDefaultComboBoxModel.isSelected();
         componentJComboBox.this.dialog.setVisible(false);
         componentJComboBox.this.dialog.dispose();
       }
     });
     this.editor.avbryt.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent paramActionEvent) {
         componentJComboBox.this.dialog.setVisible(false);
         componentJComboBox.this.dialog.dispose();
       }
     });
     this.dialog.setVisible(true);
     this.dialog.dispose();*/
   }
 
   public String getDefinisjon()
   {
     if (!this.brukDefaultComboBoxModel) {
       return "  String " + this.variablename + "Data = \"" + this.text + "\";\n" + "  JComboBox " + this.variablename + " = new JComboBox (" + this.variablename + "Data.split (\"[\\\\p{Punct}]+\"));";
     }
 
     return "  String " + this.variablename + "Data = \"" + this.text + "\";\n" + "  DefaultComboBoxModel " + this.variablename + "Model = new DefaultComboBoxModel (" + this.variablename + "Data.split (\"[\\\\p{Punct}\\\\s]+\"));\n" + "  JComboBox " + this.variablename + " = new JComboBox (" + this.variablename + "Model);";
   }
 
   public String getGUIKode()
   {
     StringBuffer localStringBuffer = new StringBuffer();
     localStringBuffer.append(super.getGUIKode());
     localStringBuffer.append("    layout.setConstraints (" + this.variablename + ", gbc);\n");
     if (this.height > 0.0D)
       localStringBuffer.append("    " + this.variablename + ".setPreferredSize (new java.awt.Dimension (" + (int)this.width + ", " + (int)this.height + "));\n");
     localStringBuffer.append("    add (" + this.variablename + ");\n");
     return localStringBuffer.toString();
   }
 
   public void tilFil(RandomAccessFile paramRandomAccessFile)
     throws IOException
   {
     super.tilFil(paramRandomAccessFile);
     paramRandomAccessFile.writeDouble(this.width);
     paramRandomAccessFile.writeDouble(this.height);
     paramRandomAccessFile.writeBoolean(this.brukDefaultComboBoxModel);
   }
 
   public void fraFil(RandomAccessFile paramRandomAccessFile)
     throws IOException
   {
     this.width = paramRandomAccessFile.readDouble();
     this.height = paramRandomAccessFile.readDouble();
     this.brukDefaultComboBoxModel = paramRandomAccessFile.readBoolean();
   }
 }
