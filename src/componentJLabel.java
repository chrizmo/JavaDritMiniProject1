

public class componentJLabel extends component
{
  public componentJLabel()
  {
    this.type = 0;
  }

  public componentJLabel(component paramKomponent)
  {
    super(paramKomponent);
    this.type = 0;
  }

  public componentJLabel(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt4, paramInt3);
    this.type = 0;
    this.variablename = paramString1;
    this.text = paramString2;
  }

  public String getDefinisjon()
  {
    return "  JLabel " + this.variablename + " = new JLabel (\"" + this.text + "\");";
  }

  public String getGUIKode()
  {
    return super.getGUIKode() + "    layout.setConstraints (" + this.variablename + ", gbc);\n" + "    add (" + this.variablename + ");\n";
  }
}