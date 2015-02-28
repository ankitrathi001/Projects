import javax.swing.*;


class myTry extends javax.swing.AbstractListModel
{
	static String[] strings;
	String str[];
	int size;
	int i,start;
	myTry(String[] strings,int start,int size)	
	{
		this.start=start;
		this.size=size;
		str=new String[size];
		this.strings=strings;
		for(i=start;i<start+size;i++)
		{
			str[i-start]=strings[i];	
		}
	}
	
	public int getSize() { return str.length; }
    public Object getElementAt(int i) { return str[i]; }
}