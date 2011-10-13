

import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.JFrame;

public class component
{
  int row;
  int column;
  int columns;
  int rows;
  int anchoring;
  int scale;
  int type;
  String anchor;
  String fill;
  String variablename;
  String text;
  public static String[] TYPE = { "JLabel", "JButton", "JTextField", "JTextArea", "JCheckBox", "JList", "JComboBox", "JSpinnerList", "JSpinnerNumber" };

  public static String[] ANCHORING = { "CENTER", "NORTH", "NORTHEAST", "EAST", "SOUTHEAST", "SOUTH", "SOUTHWEST", "WEST", "NORTHWEST" };

  public static String[] SCALE = { "NONE", "HORIZONTAL", "VERTICAL", "BOTH" };

  public component()
  {
    this.row = 0;
    this.column = 0;
    this.columns = 1;
    this.rows = 1;
    this.anchor = "java.awt.GridBagConstraints.CENTER";
    this.fill = "java.awt.GridBagConstraints.NONE";
    this.anchoring = 0;
    this.scale = 0;
    this.variablename = "";
    this.text = "";
    this.type = -1;
  }

  public component(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this();
    this.row = paramInt1;
    this.column = paramInt2;
    this.columns = paramInt3;
    this.rows = paramInt4;
  }

  public component(component paramcomponent)
  {
    this.row = paramcomponent.getrow();
    this.column = paramcomponent.getcolumn();
    this.rows = paramcomponent.getrows();
    this.columns = paramcomponent.getcolumns();
    this.variablename = paramcomponent.getvariablename();
    this.anchoring = paramcomponent.getanchoring();
    this.scale = paramcomponent.getscale();
    this.text = paramcomponent.getcomponenttext();
    setUtfilling(SCALE[this.scale]);
    setanchor(ANCHORING[this.anchoring]);
  }

  public void showExtrasEditor(JFrame paramJFrame)
  {
  }

  public int getType()
  {
    return this.type;
  }

  public String getTypeString()
  {
    return TYPE[this.type];
  }

  public String getvariablename()
  {
    return this.variablename;
  }

  public String getcomponenttext()
  {
    return this.text;
  }

  public int getrow()
  {
    return this.row;
  }

  public int getcolumn()
  {
    return this.column;
  }

  public int getanchoring()
  {
    return this.anchoring;
  }

  public String getanchoringString()
  {
    return ANCHORING[this.anchoring];
  }

  public int getscale()
  {
    return this.scale;
  }

  public String getscaleString()
  {
    return SCALE[this.scale];
  }

  public int getrows()
  {
    return this.rows;
  }

  public int getcolumns()
  {
    return this.columns;
  }

  public void setType(int paramInt)
  {
    this.type = paramInt;
  }

  public void setvariablename(String paramString)
  {
    this.variablename = paramString;
  }

  public void setcomponenttext(String paramString)
  {
    this.text = paramString;
  }

  public void setrow(int paramInt)
  {
    this.row = paramInt;
  }

  public void setcolumn(int paramInt)
  {
    this.column = paramInt;
  }

  public void setanchoring(int paramInt)
  {
    this.anchoring = paramInt;
    setanchor(ANCHORING[paramInt]);
  }

  public void setscale(int paramInt)
  {
    this.scale = paramInt;
    setUtfilling(SCALE[paramInt]);
  }

  public void setrows(int paramInt)
  {
    this.rows = paramInt;
  }

  public void setcolumns(int paramInt)
  {
    this.columns = paramInt;
  }

  public Object getcolumn(int paramInt)
  {
    switch (paramInt) { case 0:
      return new Integer(this.type);
    case 1:
      return this.variablename;
    case 2:
      return this.text;
    case 3:
      return new Integer(this.row);
    case 4:
      return new Integer(this.column);
    case 5:
      return new Integer(this.rows);
    case 6:
      return new Integer(this.columns);
    case 7:
      return new Integer(this.scale);
    case 8:
      return new Integer(this.anchoring);
    }
    return null;
  }

  public void setcolumn(int paramInt, Object paramObject)
  {
    switch (paramInt) { case 0:
      this.type = ((Integer)paramObject).intValue();
      break;
    case 1:
      this.variablename = ((String)paramObject);
      break;
    case 2:
      this.text = ((String)paramObject);
      break;
    case 3:
      this.row = ((Integer)paramObject).intValue();
      break;
    case 4:
      this.column = ((Integer)paramObject).intValue();
      break;
    case 5:
      this.rows = ((Integer)paramObject).intValue();
      break;
    case 6:
      this.columns = ((Integer)paramObject).intValue();
      break;
    case 7:
      this.scale = ((Integer)paramObject).intValue();
      setUtfilling(SCALE[this.scale]);
      break;
    case 8:
      this.anchoring = ((Integer)paramObject).intValue();
      setanchor(ANCHORING[this.anchoring]);
    }
  }

  public String toXML()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("<component type='" + getTypeString() + "' ");
    localStringBuffer.append("variablename='" + this.variablename + "' ");
    localStringBuffer.append("row='" + this.row + "' ");
    localStringBuffer.append("column='" + this.column + "' ");
    localStringBuffer.append("scale='" + getscaleString() + "' ");
    localStringBuffer.append("anchoring='" + getanchoringString() + "' ");
    localStringBuffer.append("rows='" + this.rows + "' ");
    localStringBuffer.append("columns='" + this.columns + "'>");
    localStringBuffer.append(this.text);
    localStringBuffer.append("</component>");
    return localStringBuffer.toString();
  }

  public String toString()
  {
    return "component av type " + getTypeString() + " med variablename " + this.variablename + " på row " + this.row + " i column " + this.column;
  }

  public void tilFil(RandomAccessFile paramRandomAccessFile)
    throws IOException
  {
    paramRandomAccessFile.writeInt(this.type);
    paramRandomAccessFile.writeUTF(this.variablename);
    paramRandomAccessFile.writeUTF(this.text);
    paramRandomAccessFile.writeInt(this.row);
    paramRandomAccessFile.writeInt(this.column);
    paramRandomAccessFile.writeInt(this.scale);
    paramRandomAccessFile.writeInt(this.anchoring);
    paramRandomAccessFile.writeInt(this.rows);
    paramRandomAccessFile.writeInt(this.columns);
  }

  public void fraFil(RandomAccessFile paramRandomAccessFile)
    throws IOException
  {
    this.type = paramRandomAccessFile.readInt();
    this.variablename = paramRandomAccessFile.readUTF();
    this.text = paramRandomAccessFile.readUTF();
    this.row = paramRandomAccessFile.readInt();
    this.column = paramRandomAccessFile.readInt();
    this.scale = paramRandomAccessFile.readInt();
    this.anchoring = paramRandomAccessFile.readInt();
    this.rows = paramRandomAccessFile.readInt();
    this.columns = paramRandomAccessFile.readInt();
    setUtfilling(SCALE[this.scale]);
    setanchor(ANCHORING[this.anchoring]);
  }

  public String getDefinisjon()
  {
    return "";
  }

  public String getGUIKode()
  {
    String str = "    gbc.gridx = " + this.column + ";\n";
    str = str + "    gbc.gridy = " + this.row + ";\n";
    str = str + "    gbc.gridwidth = " + this.columns + ";\n";
    str = str + "    gbc.gridheight = " + this.rows + ";\n";
    str = str + "    gbc.anchor = " + this.anchor + ";\n";
    str = str + "    gbc.fill = " + this.fill + ";\n";
    return str;
  }

  private void setanchor(String paramString)
  {
 //   this.anchor = Anchoring.getanchoring(paramString);
  }

  private void setUtfilling(String paramString)
  {
    //this.fill = componentfilling.getcomponentfilling(paramString);
  }
}