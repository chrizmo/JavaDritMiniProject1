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
 
 public class componentJList extends component
 {
   double width;
   double height;
   boolean brukScrollPane = true;
   boolean brukDefaultComboBoxModel = true;
   //JListEditorGBL editor;
   JDialog dialog;
 
   public componentJList()
   {
     this.type = 5;
     this.width = 0.0D; this.height = 0.0D;
   }
 
   public componentJList(component paramcomponent)
   {
     super(paramcomponent);
     this.type = 5;
     this.width = 0.0D; this.height = 0.0D;
   }
 
   public componentJList(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
   {
     super(paramInt1, paramInt2, paramInt4, paramInt3);
     this.type = 5;
     this.variablename = paramString1;
     this.text = paramString2;
     this.width = 0.0D; this.height = 0.0D;
   }
 
   public void showExtrasEditor(JFrame paramJFrame)
   {/*// TODO: WHAT THE HELL?
     this.editor = new JListEditorGBL();
     this.editor.width.setValue(new Double(this.width));
     this.editor.height.setValue(new Double(this.height));
     this.editor.brukScrollPane.setSelected(this.brukScrollPane);
     this.editor.brukDefaultComboBoxModel.setSelected(this.brukDefaultComboBoxModel);
     this.dialog = new JDialog(paramJFrame, prosjekt1.getMessages().getString("listEditorGBL.windowtitle"), true);
     this.dialog.getContentPane().add(this.editor);
     this.dialog.pack();
     this.dialog.setSize((int)this.dialog.getSize().getWidth() + 20, (int)this.dialog.getSize().getHeight() + 10);
     this.dialog.setLocation(100, 100);
     this.editor.ok.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent paramActionEvent) {
         componentJList.this.width = ((Double)componentJList.this.editor.width.getValue()).doubleValue();
         componentJList.this.height = ((Double)componentJList.this.editor.height.getValue()).doubleValue();
         componentJList.this.brukScrollPane = componentJList.this.editor.brukScrollPane.isSelected();
         componentJList.this.brukDefaultComboBoxModel = componentJList.this.editor.brukDefaultComboBoxModel.isSelected();
         componentJList.this.dialog.setVisible(false);
         componentJList.this.dialog.dispose();
       }
     });
     this.editor.avbryt.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent paramActionEvent) {
         componentJList.this.dialog.setVisible(false);
         componentJList.this.dialog.dispose();
       }
     });
     this.dialog.setVisible(true);
     this.dialog.dispose();*/
   }
 
   public String getDefinisjon()
   {
     if (!this.brukDefaultComboBoxModel) {
       return "  String " + this.variablename + "Data = \"" + this.text + "\";\n" + "  JList " + this.variablename + " = new JList (" + this.variablename + "Data.split (\"[\\\\p{Punct}]+\"));";
     }
 
     return "  String " + this.variablename + "Data = \"" + this.text + "\";\n" + "  DefaultComboBoxModel " + this.variablename + "Model = new DefaultComboBoxModel (" + this.variablename + "Data.split (\"[\\\\p{Punct}\\\\s]+\"));\n" + "  JList " + this.variablename + " = new JList (" + this.variablename + "Model);";
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
     return localStringBuffer.toString();
   }
 
   public void tilFil(RandomAccessFile paramRandomAccessFile)
     throws IOException
   {
     super.tilFil(paramRandomAccessFile);
     paramRandomAccessFile.writeDouble(this.width);
     paramRandomAccessFile.writeDouble(this.height);
     paramRandomAccessFile.writeBoolean(this.brukScrollPane);
     paramRandomAccessFile.writeBoolean(this.brukDefaultComboBoxModel);
   }
 
   public void fraFil(RandomAccessFile paramRandomAccessFile)
     throws IOException
   {
     this.width = paramRandomAccessFile.readDouble();
     this.height = paramRandomAccessFile.readDouble();
     this.brukScrollPane = paramRandomAccessFile.readBoolean();
     this.brukDefaultComboBoxModel = paramRandomAccessFile.readBoolean();
   }
 }
