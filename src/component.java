import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.JFrame;

/**
 * 
 * @author Jon Arne Westgaard
 *
 */

public class component
{
  int row, column, columns, rows, anchoring, scale, type;
  String anchor, fill, variablename, text;
  public static String[] TYPE = {"JLabel", "JButton", "JTextField", "JTextArea", "JCheckBox", "JList", "JComboBox", "JSpinnerList", "JSpinnerNumber" };
  public static String[] ANCHORING = {"CENTER", "NORTH", "NORTHEAST", "EAST", "SOUTHEAST", "SOUTH", "SOUTHWEST", "WEST", "NORTHWEST"};
  public static String[] SCALE = {"NONE", "HORIZONTAL", "VERTICAL", "BOTH" };
/**
 * Constructor
 */
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
/**
 * Constructor
 * 
 * @param row Row number
 * @param column Column number
 * @param cols Columns number
 * @param rows Rows number
 */
  public component(int row, int column, int cols, int rows) {
    this();
    this.row = row;
    this.column = column;
    this.columns = cols;
    this.rows = rows;
  }
/**
 * Constructor with component
 * 
 * @param paramcomponent table component
 */
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
/**
 * Show the editor
 * 
 * @param paramJFrame
 */
  public void showExtrasEditor(JFrame paramJFrame)
  {
  }
/**
 * Return type of cell
 * 
 * @return class variable type
 */
  public int getType()
  {
    return this.type;
  }
/**
 * Get type string
 * 
 * @return string of type
 */
  public String getTypeString()
  {
    return TYPE[this.type];
  }
/**
 * Returns the variable
 * 
 * @return class variable variablename
 */
  public String getvariablename()
  {
    return this.variablename;
  }
/**
 * Get the component text
 * 
 * @return class variable text
 */
  public String getcomponenttext()
  {
    return this.text;
  }
/**
 * Returns row number
 * 
 * @return class variable row
 */
  public int getrow()
  {
    return this.row;
  }
/**
 * Return column
 * 
 * @return class variable column
 */
  public int getcolumn()
  {
    return this.column;
  }
/**
 * Returns anchoring
 * 
 * @return class variable anchoring
 */
  public int getanchoring()
  {
    return this.anchoring;
  }
/**
 * Return anchor as string
 * 
 * @return string of anchoring type
 */
  public String getanchoringString()
  {
    return ANCHORING[this.anchoring];
  }
/**
 * Get the scale
 * 
 * @return class variable scale
 */
  public int getscale()
  {
    return this.scale;
  }
/**
 * Return string of scale variable
 * 
 * @return string
 */
  public String getscaleString()
  {
    return SCALE[this.scale];
  }
/**
 * Returns the number of rows
 * 
 * @return int of rows
 */
  public int getrows()
  {
    return this.rows;
  }
/**
 * Returns number of columns
 * 
 * @return class variable coloumns
 */
  public int getcolumns()
  {
    return this.columns;
  }
/**
 * Set type of component
 * 
 * @param paramInt the type to set
 */
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
/**
 * Set the variable name varable
 * 
 * @param paramString string with variablename
 */
  public void setvariablename(String paramString)
  {
    this.variablename = paramString;
  }
/**
 * Set string text of component
 * 
 * @param paramString the string to set
 */
  public void setcomponenttext(String paramString)
  {
    this.text = paramString;
  }
/**
 * Set the row variable
 * 
 * @param paramInt the value of the variable
 */
  public void setrow(int paramInt)
  {
    this.row = paramInt;
  }
/**
 * set column variable
 * 
 * @param paramInt value to set
 */
  public void setcolumn(int paramInt)
  {
    this.column = paramInt;
  }
/**
 * Sets the anchoring of component
 * 
 * @param paramInt value to set.
 */
  public void setanchoring(int paramInt)
  {
    this.anchoring = paramInt;
    setanchor(ANCHORING[paramInt]);
  }
/**
 * set the scale variable
 * 
 * @param paramInt value of scale variable
 */
  public void setscale(int paramInt)
  {
    this.scale = paramInt;
    setUtfilling(SCALE[paramInt]);
  }
/**
 * Set rows variable
 * 
 * @param paramInt 
 */
  public void setrows(int paramInt)
  {
    this.rows = paramInt;
  }
/**
 * Set column
 * 
 * @param paramInt value to set
 */
  public void setcolumns(int paramInt)
  {
    this.columns = paramInt;
  }
/**
 * Get coloumn from component
 * 
 * @param paramInt the parameter to return
 * @return object of a variable
 */
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
/**
 * Set coloumns
 * 
 * @param paramInt int 
 * @param paramObject Object
 */
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
/**
 * Convert to XML
 * 
 * @return String object
 */
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
/**
 * Returns the string of a component
 */
  public String toString()
  {
    return "component of type " + getTypeString() + " with variablename " + this.variablename + " on row " + this.row + " in column " + this.column;
  }
/**
 * 
 * @param paramRandomAccessFile Files to write to
 * @throws IOException
 */
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
/**
 * Set values from file
 * 
 * @param paramRandomAccessFile File to load from
 * @throws IOException
 */
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
/**
 * 
 * @return nothing?
 */
  public String getDefinisjon()
  {
    return "";
  }
/**
 * Gets the GUI kode
 * 
 * @return string
 */
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
/**
 * @deprecated since allways
 * 
 * @param paramString string
 */
  private void setanchor(String paramString)
  {
 //   this.anchor = Anchoring.getanchoring(paramString);
  }
/**
 * set utfilling
 * @deprecated since allways
 * @param paramString value
 */
  private void setUtfilling(String paramString)
  {
    //this.fill = componentfilling.getcomponentfilling(paramString);
  }
}