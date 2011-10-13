/**
 * 
 * @author Christer Vaskinn
 *
 */

public class componentJButton extends component
 {
   public componentJButton()
   {
     this.type = 1;
   }
 
   public componentJButton(component paramcomponent)
   {
     super(paramcomponent);
     this.type = 1;
   }
 
   public componentJButton(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
   {
     super(paramInt1, paramInt2, paramInt4, paramInt3);
     this.type = 1;
     this.variablename = paramString1;
     this.text = paramString2;
   }
 
   public String getDefinisjon()
   {
     return "  JButton " + this.variablename + " = new JButton (\"" + this.text + "\");";
   }
 
   public String getGUIKode()
   {
     return super.getGUIKode() + "    layout.setConstraints (" + this.variablename + ", gbc);\n" + "    add (" + this.variablename + ");\n";
   }
 }