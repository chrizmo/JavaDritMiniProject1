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
 
 public class componentJTextArea extends component
 {
   double width;
   double height;
   double columns;
   double rows;
   boolean brukScrollPane = true;
   boolean brukWordWrap = true;
   // TextAreaEditorGBL editor; //TODO: FIXXIES
   JDialog dialog;
 
   public componentJTextArea()
   {
     this.type = 3;
     this.width = 0.0D; this.height = 0.0D; this.columns = 0.0D; this.rows = 0.0D;
   }
 
   public componentJTextArea(component paramcomponent)
   {
     super(paramcomponent);
     this.type = 3;
     this.width = 0.0D; this.height = 0.0D; this.columns = 0.0D; this.rows = 0.0D;
   }
 
   public componentJTextArea(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
   {
     super(paramInt1, paramInt2, paramInt4, paramInt3);
     this.type = 3;
     this.variablename = paramString1;
     this.text = paramString2;
     this.width = 0.0D; this.height = 0.0D; paramInt4 = 0; paramInt3 = 0;
   }
 
   public void showExtrasEditor(JFrame paramJFrame)
   {// TODO: NEEDS TO BE FIXED
	   /*
     this.editor = new TextAreaEditorGBL();
     this.editor.columns.setValue(new Double(this.columns));
     this.editor.rows.setValue(new Double(this.rows));
     this.editor.width.setValue(new Double(this.width));
     this.editor.height.setValue(new Double(this.height));
     this.editor.brukScrollPane.setSelected(this.brukScrollPane);
     this.editor.brukWordWrap.setSelected(this.brukWordWrap);
     this.dialog = new JDialog(paramJFrame, prosjekt1.getMessages().getString("textAreaEditorGBL.windowtitle"), true);
     this.dialog.getContentPane().add(this.editor);
     this.dialog.pack();
     this.dialog.setSize((int)this.dialog.getSize().getWidth() + 20, (int)this.dialog.getSize().getHeight() + 10);
     this.dialog.setLocation(100, 100);
     this.editor.ok.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent paramActionEvent) {
         componentJTextArea.this.columns = ((Double)componentJTextArea.this.editor.columns.getValue()).doubleValue();
         componentJTextArea.this.rows = ((Double)componentJTextArea.this.editor.rows.getValue()).doubleValue();
         componentJTextArea.this.width = ((Double)componentJTextArea.this.editor.width.getValue()).doubleValue();
         componentJTextArea.this.height = ((Double)componentJTextArea.this.editor.height.getValue()).doubleValue();
         componentJTextArea.this.brukScrollPane = componentJTextArea.this.editor.brukScrollPane.isSelected();
         componentJTextArea.this.brukWordWrap = componentJTextArea.this.editor.brukWordWrap.isSelected();
         componentJTextArea.this.dialog.setVisible(false);
         componentJTextArea.this.dialog.dispose();
       }
     });
     this.editor.avbryt.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent paramActionEvent) {
         componentJTextArea.this.dialog.setVisible(false);
         componentJTextArea.this.dialog.dispose();
       }
     });
     this.dialog.setVisible(true);
     this.dialog.dispose();*/
   }
 
   public String getDefinisjon()
   {
     return "  JTextArea " + this.variablename + " = new JTextArea (\"" + this.text + "\"" + (this.rows > 0.0D ? ", " + (int)this.rows + ", " + (int)this.columns : "") + ");";
   }
 
   public String getGUIKode()
   {
     StringBuffer localStringBuffer = new StringBuffer();
     localStringBuffer.append(super.getGUIKode());
     if (!this.brukScrollPane) {
       localStringBuffer.append("    layout.setConstraints (" + this.variablename + ", gbc);\n");
       if (this.height > 0.0D)
         localStringBuffer.append("    " + this.variablename + ".setPreferredSize (new java.awt.Dimension (" + (int)this.width + ", " + (int)this.height + "));\n");
       localStringBuffer.append("    add (" + this.variablename + ");\n");
     } else {
       localStringBuffer.append("    JScrollPane " + this.variablename + "ScrollPane = new JScrollPane (" + this.variablename + ");\n");
       if (this.height > 0.0D)
         localStringBuffer.append("    " + this.variablename + "ScrollPane.setPreferredSize (new java.awt.Dimension (" + (int)this.width + ", " + (int)this.height + "));\n");
       localStringBuffer.append("    layout.setConstraints (" + this.variablename + "ScrollPane, gbc);\n");
       localStringBuffer.append("    add (" + this.variablename + "ScrollPane);\n");
     }
     if (this.brukWordWrap) {
       localStringBuffer.append("    " + this.variablename + ".setLineWrap (true);\n");
       localStringBuffer.append("    " + this.variablename + ".setWrapStyleWord (true);\n");
     }
     return localStringBuffer.toString();
   }
 
   public void tilFil(RandomAccessFile paramRandomAccessFile)
     throws IOException
   {
     super.tilFil(paramRandomAccessFile);
     paramRandomAccessFile.writeDouble(this.rows);
     paramRandomAccessFile.writeDouble(this.columns);
     paramRandomAccessFile.writeDouble(this.width);
     paramRandomAccessFile.writeDouble(this.height);
     paramRandomAccessFile.writeBoolean(this.brukScrollPane);
     paramRandomAccessFile.writeBoolean(this.brukWordWrap);
   }
 
   public void fraFil(RandomAccessFile paramRandomAccessFile)
     throws IOException
   {
     this.rows = paramRandomAccessFile.readDouble();
     this.columns = paramRandomAccessFile.readDouble();
     this.width = paramRandomAccessFile.readDouble();
     this.height = paramRandomAccessFile.readDouble();
     this.brukScrollPane = paramRandomAccessFile.readBoolean();
     this.brukWordWrap = paramRandomAccessFile.readBoolean();
   }
 }
