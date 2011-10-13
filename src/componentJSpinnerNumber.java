 import java.awt.Container;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.io.IOException;
 import java.io.RandomAccessFile;
 import java.util.ResourceBundle;
 import javax.swing.JButton;
 import javax.swing.JDialog;
 import javax.swing.JFrame;
 import javax.swing.JTextField;
 
 public class componentJSpinnerNumber extends component
 {
   double value;
   double min;
   double max;
   double step;
   //JSpinnerNumberModelEditor editor;
   JDialog dialog;
 
   public componentJSpinnerNumber()
   {
     this.type = 8;
     this.value = 1.0D; this.min = 1.0D; this.max = 5.0D; this.step = 1.0D;
   }
 
   public componentJSpinnerNumber(component paramcomponent)
   {
     super(paramcomponent);
     this.type = 8;
     this.value = 1.0D; this.min = 1.0D; this.max = 5.0D; this.step = 1.0D;
   }
 
   public componentJSpinnerNumber(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
   {
     super(paramInt1, paramInt2, paramInt4, paramInt3);
     this.type = 8;
     this.variablename = paramString1;
     this.text = paramString2;
     this.value = 1.0D; this.min = 1.0D; this.max = 5.0D; this.step = 1.0D;
   }
 
   public void showExtrasEditor(JFrame paramJFrame)
   {// TODO: FIX THIS!
	   
	   /*
     this.editor = new JSpinnerNumberModelEditor();
     this.editor.value.setText(Double.toString(this.value));
     this.editor.max.setText(Double.toString(this.max));
     this.editor.min.setText(Double.toString(this.min));
     this.editor.step.setText(Double.toString(this.step));
     this.dialog = new JDialog(paramJFrame, prosjekt1.getMessages().getString("spinnerNumerModelEditor.windowtitle"), true);
     this.dialog.getContentPane().add(this.editor);
     this.dialog.setSize(250, 150);
     this.dialog.setLocation(100, 100);
     this.editor.ok.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent paramActionEvent) {
         componentJSpinnerNumber.this.value = Double.parseDouble(componentJSpinnerNumber.this.editor.value.getText());
         componentJSpinnerNumber.this.min = Double.parseDouble(componentJSpinnerNumber.this.editor.min.getText());
         componentJSpinnerNumber.this.max = Double.parseDouble(componentJSpinnerNumber.this.editor.max.getText());
         componentJSpinnerNumber.this.step = Double.parseDouble(componentJSpinnerNumber.this.editor.step.getText());
         componentJSpinnerNumber.this.dialog.setVisible(false);
         componentJSpinnerNumber.this.dialog.dispose();
       }
     });
     this.editor.avbryt.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent paramActionEvent) {
         componentJSpinnerNumber.this.dialog.setVisible(false);
         componentJSpinnerNumber.this.dialog.dispose();
       }
     });
     this.dialog.setVisible(true);
     this.dialog.dispose();*/
     
   }
 
   public String getDefinisjon()
   {
     return "  JSpinner " + this.variablename + " = new JSpinner (new SpinnerNumberModel (" + this.value + ", " + this.min + ", " + this.max + ", " + this.step + "));";
   }
 
   public String getGUIKode()
   {
     return super.getGUIKode() + "    layout.setConstraints (" + this.variablename + ", gbc);\n" + "    add (" + this.variablename + ");\n";
   }
 
   public void tilFil(RandomAccessFile paramRandomAccessFile)
     throws IOException
   {
     super.tilFil(paramRandomAccessFile);
     paramRandomAccessFile.writeDouble(this.value);
     paramRandomAccessFile.writeDouble(this.min);
     paramRandomAccessFile.writeDouble(this.max);
     paramRandomAccessFile.writeDouble(this.step);
   }
 
   public void fraFil(RandomAccessFile paramRandomAccessFile)
     throws IOException
   {
     this.value = paramRandomAccessFile.readDouble();
     this.min = paramRandomAccessFile.readDouble();
     this.max = paramRandomAccessFile.readDouble();
     this.step = paramRandomAccessFile.readDouble();
   }
 }