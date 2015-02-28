/*
 * notepad.java
 *
 * Created on 4 December, 2011, 10:00 PM
 */



/**
 *
 * @author  Anshul Jain
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import java.io.*;
import java.util.Random;
import java.awt.event.*;
import java.lang.Integer.*;

public class notepad extends javax.swing.JFrame 
{
	int wrap=0;
	int p,q;
	int i=0;
	
	File file;
	
	boolean exist=true;
	
	JPanel jPanel1;
	
	JFrame jFrame1;
	JFileChooser jFileChooser1;
    
    JLabel jLabel1;
    JLabel jLabel2;
    JLabel jLabel3;
    JLabel jLabel4;
    JLabel jLabel5;
    JLabel jLabel6;
    
    JTextArea jTextArea2;
    JTextArea jTextArea1;
    
    JScrollPane jScrollPane1;
    JScrollPane jScrollPane2;
	
	FileOutputStream fos;
	
	Random aRandom;
	
	JPopupMenu Pmenu;
  	
  	JMenuBar menubar;
  		
  	JMenuItem menuItem;
  	
  	ImageIcon icon1;
	ImageIcon icon2;
	ImageIcon icon3;
	ImageIcon icon4;
	ImageIcon icon5;
	ImageIcon icon6;
	ImageIcon icon7;
	ImageIcon icon8;
	ImageIcon icon9;
	ImageIcon icon10;
	ImageIcon icon11;
	
	JMenu file1;
    JMenu file2;
    JMenu file3;
    JMenu file4;
	JMenu file5;
	JMenu file6;
	
	JMenuItem eMenuItem1;
    JMenuItem eMenuItem2;
    JMenuItem eMenuItem3;
    JMenuItem eMenuItem4;
   	JMenuItem eMenuItem5;
    JMenuItem eMenuItem6;
    JMenuItem eMenuItem7;
    JMenuItem eMenuItem8;
    JMenuItem eMenuItem9;
    JMenuItem eMenuItem10;
    JMenuItem eMenuItem11;
    JMenuItem eMenuItem12;
    JMenuItem eMenuItem13;
	
	public static void main(String[] args) 
	{
        SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                notepad ex = new notepad();
                ex.setVisible(true);
            }
        });
        
    }
    
    public notepad() 
    {
        initComponents();
    }

    public final void initComponents() 
    {
    	icon1 = new ImageIcon(getClass().getResource("images\\new.jpg"));
		icon2 = new ImageIcon(getClass().getResource("images\\open.jpg"));
		icon3 = new ImageIcon(getClass().getResource("images\\save.jpg"));
		icon4 = new ImageIcon(getClass().getResource("images\\exit.jpg"));
		icon5 = new ImageIcon(getClass().getResource("images\\undo.jpg"));
		icon6 = new ImageIcon(getClass().getResource("images\\cut.jpg"));
		icon7 = new ImageIcon(getClass().getResource("images\\copy.jpg"));
		icon8 = new ImageIcon(getClass().getResource("images\\paste.jpg"));
		icon9 = new ImageIcon(getClass().getResource("images\\delete.jpg"));
		icon10 = new ImageIcon(getClass().getResource("images\\encrypt.jpg"));
		icon11 = new ImageIcon(getClass().getResource("images\\decrypt.jpg"));
		
    	menubar = new JMenuBar();
        
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        
        jTextArea1 = new javax.swing.JTextArea();
        jTextArea2 = new javax.swing.JTextArea();
  		
  		Pmenu = new JPopupMenu();
  		Pmenu.setBackground(new java.awt.Color(255, 255, 255));
  		Pmenu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
  		
  		menuItem = new JMenuItem("        Undo",icon5);
  		menuItem.setBackground(new java.awt.Color(255, 255, 255));
  		Pmenu.add(menuItem);
  		menuItem.addActionListener(new ActionListener()
  		{
  			public void actionPerformed(ActionEvent e)
  			{
  			}
  		});
  		
  		menuItem = new JMenuItem("        Cut",icon6);
  		menuItem.setBackground(new java.awt.Color(255, 255, 255));
  		Pmenu.add(menuItem);
  		menuItem.addActionListener(new ActionListener()
  		{
  			public void actionPerformed(ActionEvent e)
  			{
  				jTextArea1.cut();
  			}
  		});
  		
  		menuItem = new JMenuItem("        Copy",icon7);
  		menuItem.setBackground(new java.awt.Color(255, 255, 255));
  		Pmenu.add(menuItem);
  		menuItem.addActionListener(new ActionListener()
  		{
  			public void actionPerformed(ActionEvent e)
  			{
  				jTextArea1.copy();
  			}
  		});
  		
  		menuItem = new JMenuItem("        Paste",icon8);
  		menuItem.setBackground(new java.awt.Color(255, 255, 255));
  		Pmenu.add(menuItem);
  		menuItem.addActionListener(new ActionListener()
  		{
  			public void actionPerformed(ActionEvent e)
  			{
  				jTextArea1.paste();
  			}
  		});
  		
  		menuItem = new JMenuItem("        Delete",icon9);
  		menuItem.setBackground(new java.awt.Color(255, 255, 255));
  		Pmenu.add(menuItem);
  		
  		menuItem.addActionListener(new ActionListener()
  		{
  			public void actionPerformed(ActionEvent e)
  			{
  				
  			}
  		});
  		
  		jTextArea1.addMouseListener(new MouseAdapter()
  		{
  			public void mouseReleased(MouseEvent Me)
  			{
  				if(Me.isPopupTrigger())
  				{
  					Pmenu.show(Me.getComponent(), Me.getX(), Me.getY());
 				 }
 			 }
  		});
        
        jPanel1 = new javax.swing.JPanel();
        
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        
        jLabel1.setText("ln : ");
        //jLabel2.setText("0222");
        jLabel3.setText("Col : ");
        jLabel4.setText("3989");
        jLabel5.setText("Char : ");
        jLabel6.setText("7874597");
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setBackground(new java.awt.Color(204, 204, 204));
        jTextArea2.setColumns(1);
        jTextArea2.setRows(5);
        jTextArea2.setEditable(false);
        jTextArea2.setLineWrap(false);
        jTextArea2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 280, javax.swing.GroupLayout.DEFAULT_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)))
        );

        pack();
		
        file1 = new JMenu("File");
        file2 = new JMenu("Edit");
        file3 = new JMenu("Format");
        file4 = new JMenu("View");
        file6 = new JMenu("Security");
        file5 = new JMenu("Help");
        
        file1.setMnemonic(KeyEvent.VK_F);
		file2.setMnemonic(KeyEvent.VK_E);
		file3.setMnemonic(KeyEvent.VK_O);
        file4.setMnemonic(KeyEvent.VK_V);
        file5.setMnemonic(KeyEvent.VK_H);
        file6.setMnemonic(KeyEvent.VK_U);
         	
        eMenuItem1 = new JMenuItem("New        Ctrl+N",icon1);
        eMenuItem2 = new JMenuItem("Open       Ctrl+O",icon2);
        eMenuItem3 = new JMenuItem("Save       Ctrl+S",icon3);
        eMenuItem4 = new JMenuItem("Exit          Ctrl+Q",icon4);
        eMenuItem5 = new JMenuItem("Undo            Ctrl+Z",icon5);
        eMenuItem6 = new JMenuItem("Cut              Ctrl+X",icon6);
        eMenuItem7 = new JMenuItem("Copy           Ctrl+C",icon7);
        eMenuItem8 = new JMenuItem("Paste          Ctrl+V",icon8);
        eMenuItem9 = new JMenuItem("Delete          ",icon9);
        eMenuItem10 = new JMenuItem("Encrypt          ",icon10);
        eMenuItem11 = new JMenuItem("Decrypt          ",icon11);
        eMenuItem12 = new JMenuItem("Word Wrap          ",icon11);
        eMenuItem13 = new JMenuItem("Font...        ",icon11);
        
        eMenuItem1.setToolTipText("New File");
        eMenuItem2.setToolTipText("Open File");
        eMenuItem3.setToolTipText("Save File");
        eMenuItem4.setToolTipText("Exit application");
        eMenuItem5.setToolTipText("Undo");
        eMenuItem6.setToolTipText("Cut");
        eMenuItem7.setToolTipText("Copy");
        eMenuItem8.setToolTipText("Paste");
        eMenuItem9.setToolTipText("Delete");
        eMenuItem10.setToolTipText("Encrypt");
        eMenuItem11.setToolTipText("Decrypt");
        eMenuItem12.setToolTipText("Word Wrap");
        eMenuItem13.setToolTipText("Font...");
                
    	file1.add(eMenuItem1);
    	file1.add(eMenuItem2);
    	file1.add(eMenuItem3);
    	file1.add(eMenuItem4);
    	file2.add(eMenuItem5);
		file2.add(eMenuItem6);
		file2.add(eMenuItem7);
		file2.add(eMenuItem8);
		file2.add(eMenuItem9);
		file3.add(eMenuItem12);
		file3.add(eMenuItem13);
		file6.add(eMenuItem10);
		file6.add(eMenuItem11);
		
	    menubar.add(file1);
   	 	menubar.add(file2);
    	menubar.add(file3);
    	menubar.add(file4);
    	menubar.add(file6);
    	menubar.add(file5);

    	setJMenuBar(menubar);
    	
    	while(exist)
   	 	{
    		i++;
      		file=new File("Untitled"+i+".txt");
  			exist = file.exists();	
    	}
  		setTitle("Untitled"+i+" - Notepad");
  		
		String strLine;
    	setSize(700, 700);
    	setLocationRelativeTo(null);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    //	System.out.println(jTextArea1.getCaretPosition());
    //	System.out.println(jTextArea1.getCaretColor());
    
     /*       
        
        eMenuItem3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }

        });
        
*/
		eMenuItem2.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent event)
            {
            	try
            	{
               		FileInputStream fstream = new FileInputStream("test files\\README.txt");
					DataInputStream in = new DataInputStream(fstream);
	  				BufferedReader br = new BufferedReader(new InputStreamReader(in));	
 	 				String strLine;
 	 				String strLine1="";
 	 				int j=0;
 	 				while ((strLine = br.readLine()) != null)   
  					{
  						j++;
  						jTextArea1.append(strLine+"\n");
  						jTextArea2.append(j+"\n");
  						int i=0;
  						//fos.write(strLine.getBytes());
  						
  					}
  					//jTextArea1.setText(strLine1);
  					jLabel2.setText(""+j+"");
            	}
            	catch(Exception e)
            	{
            		e.printStackTrace();
            	}
            	
           	 }

        });
		
        eMenuItem3.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent event) 
            {
            
            	setTitle("Untitled"+i+" - Notepad");
                try
  				{
  					fos = new FileOutputStream("Untitled"+i+".txt");
  					String save=jTextArea1.getText();
  					fos.write(save.getBytes());
  					
  				}
  				catch(Exception e)
  				{
  					e.printStackTrace();	
  				}
  			
  			
            }

        });
        
		eMenuItem4.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent event) 
            {
                System.exit(0);
            }

        });
        
		eMenuItem10.addActionListener(new ActionListener()
		{
            public void actionPerformed(ActionEvent event) 
            {
            	p=-1;
    			q=-1;
    			int k;
    			while(p==-1)
    			{
    				aRandom = new Random();
    				int rand=aRandom.nextInt(1000);	
   			 		for (k=2; k < rand ;k++ )
    				{
  						int num = rand%k;
  						if (num==0)
  						{
  							break;
  						}
  					}
  					if(k == rand)
  					{
  						p=rand;
  					}
    			} 
   			 	while(q==-1)
    			{
    				aRandom = new Random();
    				int rand=aRandom.nextInt(1000);	
    				for (k=2; k < rand ;k++ )
    				{
  						int num = rand%k;
  						if (num==0)
  						{
  							break;
  						}
  					}
  					if(k == rand)
  					{
  						q=rand;
  					}
  		  		} 
    			int n=p*q;  		
   		 		System.out.print("p="+p+"q="+q+"n="+n);
   		 		System.out.println(jTextArea1.countComponents());    		 		
    		}
  		});
  	
  		eMenuItem12.addActionListener(new ActionListener() 
  		{
   	     	public void actionPerformed(ActionEvent event) 
    	    {
       		 	wrap++;
        		if(wrap%2!=0)
        		{	
           		 	jTextArea1.setLineWrap(true);
        			jTextArea1.setWrapStyleWord(true);
        		}
        		else
   		     	{
       		 		jTextArea1.setLineWrap(false);
        			jTextArea1.setWrapStyleWord(false);
        		}
       	 	}
    	});
    	
    	eMenuItem13.addActionListener(new ActionListener() 
    	{
            public void actionPerformed(ActionEvent event) 
            {
                
            }

        });
        
		jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() 
		{
   	     	public void keyTyped(java.awt.event.KeyEvent evt) 
   	     	{
           	 	jTextArea1KeyTyped(evt);
           	 //	System.out.println(jTextArea1.getCaretPosition());
        	}
        	
        	public void keyReleased(java.awt.event.KeyEvent evt) 
   	     	{
           	 	jTextArea1KeyReleased(evt);
        	}
    	});
	}
	
    private void jTextArea1KeyTyped(java.awt.event.KeyEvent evt) 
    {
        char a = evt.getKeyChar();
    	setTitle("Untitled"+i+"* - Notepad");
    	jLabel2.setText(""+jTextArea1.getLineCount()+"");
    //	System.out.println(jTextArea1.getSelectedText());
    	
    //	System.out.println(jTextArea1.getX());
    /*    try
  		{
        	fos.write(a);
        }
  		catch(Exception e)
  		{
  			e.printStackTrace();	
  		}
  		System.out.print(a);
  	*/
       // System.out.print("");
    }  
    	
    private void jTextArea1KeyReleased(java.awt.event.KeyEvent evt)
    {
    	jLabel4.setText(""+jTextArea1.getCaretPosition()+"");
    } 
}