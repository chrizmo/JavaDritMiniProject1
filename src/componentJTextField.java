import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JSpinner;
 
 public class componentJTextField extends component
 {
   double width;
   double height;
   double columns;
   //TextFieldEditorGBL editor;
   JDialog dialog;
 
   public componentJTextField()
   {
     this.type = 2;
     this.width = 0.0D; this.height = 0.0D; this.columns = 0.0D;
   }
 
   public componentJTextField(component paramcomponent)
   {
     super(paramcomponent);
     this.type = 2;
     this.width = 0.0D; this.height = 0.0D; this.columns = 0.0D;
   }
 
   public componentJTextField(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
   {
     super(paramInt1, paramInt2, paramInt4, paramInt3);
     this.type = 2;
     this.variablename = paramString1;
     this.text = paramString2;
     this.width = 0.0D; this.height = 0.0D; this.columns = 0.0D;
   }
 
   public void showExtrasEditor(JFrame paramJFrame)
   {// TODO: FIX, KRAV
	   /*
     this.editor = new TextFieldEditorGBL();
     this.editor.columns.setValue(new Double(this.columns));
     this.editor.width.setValue(new Double(this.width));
     this.editor.height.setValue(new Double(this.height));
     this.dialog = new JDialog(paramJFrame, prosjekt1.getMessages().getString("textFieldEditorGBL.windowtitle"), true);
     this.dialog.getContentPane().add(this.editor);
     this.dialog.pack();
     this.dialog.setSize((int)this.dialog.getSize().getWidth() + 20, (int)this.dialog.getSize().getHeight() + 10);
     this.dialog.setLocation(100, 100);
     this.editor.ok.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent paramActionEvent) {
         componentJTextField.this.columns = ((Double)componentJTextField.this.editor.columns.getValue()).doubleValue();
         componentJTextField.this.width = ((Double)componentJTextField.this.editor.width.getValue()).doubleValue();
         componentJTextField.this.height = ((Double)componentJTextField.this.editor.height.getValue()).doubleValue();
         componentJTextField.this.dialog.setVisible(false);
         componentJTextField.this.dialog.dispose();
       }
     });
     this.editor.avbryt.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent paramActionEvent) {
         componentJTextField.this.dialog.setVisible(false);
         componentJTextField.this.dialog.dispose();
       }
     });
     this.dialog.setVisible(true);
     this.dialog.dispose();*/
   }
 
   public String getDefinisjon()
   {
     return "  JTextField " + this.variablename + " = new JTextField (\"" + this.text + "\"" + (this.columns > 0.0D ? ", " + (int)this.columns : "") + ");";
   }
 
   public String getGUIKode()
   {
     StringBuffer localStringBuffer = new StringBuffer();
     localStringBuffer.append(super.getGUIKode());
     if (this.height > 0.0D)
       localStringBuffer.append("    " + this.variablename + ".setPreferredSize (new java.awt.Dimension (" + (int)this.width + ", " + (int)this.height + "));\n");
     localStringBuffer.append("    layout.setConstraints (" + this.variablename + ", gbc);\n");
     localStringBuffer.append("    add (" + this.variablename + ");\n");
     return localStringBuffer.toString();
   }
 
   public void tilFil(RandomAccessFile paramRandomAccessFile)
     throws IOException
   {
     super.tilFil(paramRandomAccessFile);
     paramRandomAccessFile.writeDouble(this.columns);
     paramRandomAccessFile.writeDouble(this.width);
     paramRandomAccessFile.writeDouble(this.height);
   }
 
   public void fraFil(RandomAccessFile paramRandomAccessFile)
     throws IOException
   {
     this.columns = paramRandomAccessFile.readDouble();
     this.width = paramRandomAccessFile.readDouble();
     this.height = paramRandomAccessFile.readDouble();
   }
 }
