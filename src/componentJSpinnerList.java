import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ResourceBundle;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
 
 public class componentJSpinnerList extends component
 {
   String data = "";
 
   public componentJSpinnerList()
   {
     this.type = 7;
   }
 
   public componentJSpinnerList(component paramcomponent)
   {
     super(paramcomponent);
     this.type = 7;
   }
 
   public componentJSpinnerList(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
   {
     super(paramInt1, paramInt2, paramInt4, paramInt3);
     this.type = 7;
     this.variablename = paramString1;
     this.text = paramString2;
   }
 
   public void showExtrasEditor(JFrame paramJFrame)
   {
     this.data = JOptionPane.showInputDialog(paramJFrame, prosjekt1.getMessages().getString("spinnerListModelEditor.windowtitle"), this.data);
   }
 
   public String getDefinisjon()
   {
     return "  String " + this.variablename + "Data = \"" + this.data + "\";\n" + "  SpinnerListModel " + this.variablename + "Model = new SpinnerListModel (" + this.variablename + "Data.split (\"[\\\\p{Punct}\\\\s]+\"));\n" + "  JSpinner " + this.variablename + " = new JSpinner (" + this.variablename + "Model);";
   }
 
   public String getGUIKode()
   {
     return super.getGUIKode() + "    layout.setConstraints (" + this.variablename + ", gbc);\n" + "    add (" + this.variablename + ");\n";
   }
 
   public void tilFil(RandomAccessFile paramRandomAccessFile)
     throws IOException
   {
     super.tilFil(paramRandomAccessFile);
     paramRandomAccessFile.writeUTF(this.data);
   }
 
   public void fraFil(RandomAccessFile paramRandomAccessFile)
     throws IOException
   {
     this.data = paramRandomAccessFile.readUTF();
   }
 }
