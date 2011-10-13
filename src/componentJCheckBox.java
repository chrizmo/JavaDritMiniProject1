public class componentJCheckBox extends component
 {
   public componentJCheckBox()
   {
     this.type = 4;
   }
 
   public componentJCheckBox(component paramcomponent)
   {
     super(paramcomponent);
     this.type = 4;
   }
 
   public componentJCheckBox(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
   {
     super(paramInt1, paramInt2, paramInt4, paramInt3);
     this.type = 4;
     this.variablename = paramString1;
     this.text = paramString2;
   }
 
   public String getDefinisjon()
   {
     return "  JCheckBox " + this.variablename + " = new JCheckBox (\"" + this.text + "\");";
   }
 
   public String getGUIKode()
   {
     return super.getGUIKode() + "    layout.setConstraints (" + this.variablename + ", gbc);\n" + "    add (" + this.variablename + ");\n";
   }
 }
