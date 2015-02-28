
import javax.swing.JTextField;
import java.io.*;
import javax.swing.event.*;
import javax.swing.JPanel.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.table.*;

import java.util.*;
import java.text.*;

    

public class test extends javax.swing.JFrame  {
    
    int start;
    String[] strings;
    int num;
    int first;
    int last;
    public test() {
    	num=0;
    	first=0;
        last=0;
        initComponents();
    }
    private void initComponents() {
	
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        dequeue = new javax.swing.JTextField();
        debtn = new javax.swing.JButton();
        enbtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        day = new javax.swing.JTextField();
        jProgressBar1 = new javax.swing.JProgressBar();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
		compileall = new javax.swing.JButton();
		
		jTextArea1.setEditable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setText("Day : ");

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		
        jList1.setToolTipText("");
        jScrollPane1.setViewportView(jList1);
        jList1.getAccessibleContext().setAccessibleName("enlist");

  		jList2.setModel(new myTry(strings,start,0){});
        jList2.setToolTipText("");
        jScrollPane2.setViewportView(jList2);
        jList2.getAccessibleContext().setAccessibleName("enlist");


        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel4.setText("EN-QUEUE");
        
        enbtn.setBackground(new java.awt.Color(0, 0, 204));
        enbtn.setForeground(new java.awt.Color(204, 204, 204));
        enbtn.setText("En-Queue");

		enbtn.addActionListener(new java.awt.event.ActionListener()
        {
        public void actionPerformed(java.awt.event.ActionEvent evt)
        {
        	enbtnActionPerformed(evt);
        }
       
        });
		
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(enbtn)
                            .addComponent(jLabel4))
                        .addGap(46, 46, 46)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(31, 31, 31)
                .addComponent(enbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

		enbtn.getAccessibleContext().setAccessibleName("enbtn");
        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("Number of URL's :");

        debtn.setBackground(new java.awt.Color(0, 0, 204));
        debtn.setForeground(new java.awt.Color(204, 204, 204));
        debtn.setText("De-Queue");
        
      
        debtn.addActionListener(new java.awt.event.ActionListener()
        {
        public void actionPerformed(java.awt.event.ActionEvent evt)
        {
        	debtnActionPerformed(evt);
        }
       
        });
        
        jList2.addListSelectionListener(new SharedListSelectionHandler());

        jScrollPane2.setViewportView(jList2);
        jList2.getAccessibleContext().setAccessibleName("delist");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel5.setText("DE-QUEUE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dequeue, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(debtn)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dequeue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(debtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        dequeue.getAccessibleContext().setAccessibleName("dequeue");
        debtn.getAccessibleContext().setAccessibleName("debtn");

        jProgressBar1.setBackground(new java.awt.Color(102, 102, 255));
		jProgressBar1.setForeground(new java.awt.Color(20, 204, 20));
        jTextArea1.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(204, 204, 204));
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);
        jTextArea1.getAccessibleContext().setAccessibleName("commandline");
		
		jProgressBar1.setValue(0);
		jProgressBar1.setStringPainted(true);
		
		compileall.setBackground(new java.awt.Color(0, 0, 204));
        compileall.setForeground(new java.awt.Color(204, 204, 204));
        compileall.setText("Find Importance Matrix");
		
		compileall.getAccessibleContext().setAccessibleName("compileall");
		compileall.addActionListener(new java.awt.event.ActionListener()
        {
        public void actionPerformed(java.awt.event.ActionEvent evt)
        {
        	compileallActionPerformed(evt);
        }
       
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(compileall))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(compileall))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        day.getAccessibleContext().setAccessibleName("day");

        pack();
    }// </editor-fold>

    private void debtnActionPerformed(java.awt.event.ActionEvent evt) 
    {
    	Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss.S");
		String strDate=sdf.format(date);
		System.out.println("De-Queue Started at : "+strDate);
        if(Integer.parseInt(dequeue.getText())>20)
        {
        	jTextArea1.setText("Please Enter a value less than 20 !!!");
        }
        else
        {
        	
        	jList2.setModel(new myTry(strings,start,Integer.parseInt(dequeue.getText())){});
        	jTextArea1.setText("");
        	jTextArea1.setText("De-Queue Done...");
        	Date date1=new Date();
			SimpleDateFormat sdf1=new SimpleDateFormat("hh:mm:ss.S");
			String strDate1=sdf1.format(date1);
			System.out.println("\tFinished at :"+strDate1);
       		start+=Integer.parseInt(dequeue.getText());
        	jList1.setModel(new myTry(strings,start,20) {});
        	
        }
    }
    
     private void enbtnActionPerformed(java.awt.event.ActionEvent evt) 
     {
     	Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss.S");
		String strDate=sdf.format(date);
		System.out.println("En-Queue Started at : "+strDate);
        if(day.getText()==null)
        {
        	jTextArea1.setText("Enter The Day...");
        }	
        else if(Integer.parseInt(day.getText())>120)
        {
        	jTextArea1.setText("Please Enter the correct day !!!");
        }
        else
        {
        	strings = new String[20000];
			start=0;
			try
            {
            	//System.out.println(Integer.parseInt(day.getText()));
            	FileInputStream fstream = new FileInputStream("important url\\Day"+Integer.parseInt(day.getText())+"_important_URLs.svm");
				DataInputStream in = new DataInputStream(fstream);
  				BufferedReader br = new BufferedReader(new InputStreamReader(in));
  	 			String strLine;
  	 			
				int lines=0;
		  	
		  		while((strLine = br.readLine())!=null)   
		  		{
		  				strings[lines]=strLine;
		  				lines++;
		  		}
            }
            catch(Exception exp)
            {
            	exp.printStackTrace();
            }
        	jList1.setModel(new myTry(strings,start,20) {});
        	jTextArea1.setText("En-Queue Done...");
        	Date date1=new Date();
			SimpleDateFormat sdf1=new SimpleDateFormat("hh:mm:ss.S");
			String strDate1=sdf1.format(date1);
			System.out.println("\tFinished at :"+strDate1);
        }
    }
    
    private void compileallActionPerformed(java.awt.event.ActionEvent evt) {
        if(day.getText()==null)
        {
        	jTextArea1.setText("Enter The Day...");
        }	
        else if(Integer.parseInt(day.getText())>120)
        {
        	jTextArea1.setText("Please Enter the correct day !!!");
        }
        else
        {
        	
        	String qw = "Day"+Integer.parseInt(day.getText())+"";
        	try
        	{
        		jProgressBar1.setValue(1);
        		FinalCrawler fc = new FinalCrawler(qw);
        		jProgressBar1.setValue(100);
        		jTextArea1.setText("Importance Matrix Found...Now you can use En-Queue for "+qw);
        	}
        	catch(Exception exp)
        	{
        		exp.printStackTrace();
        	}
        }
    }
    
    private void jList2ActionPerformed(java.awt.event.ActionEvent evt) {
    	System.out.println((String)jList2.getSelectedValue());
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new test().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify
    private javax.swing.JButton compileall;
    private javax.swing.JTextField day;
    private javax.swing.JButton debtn;
    private javax.swing.JButton enbtn;
    private javax.swing.JTextField dequeue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration
    
    
     class SharedListSelectionHandler implements ListSelectionListener 
     	{
     		int firstIndex;
     		int lastIndex;
     		
     		SharedListSelectionHandler()
     		{
     			firstIndex=0;
     			lastIndex=0;
     		}
        public void valueChanged(ListSelectionEvent e) 
        { 
           try
           {
           	FileInputStream fstream = new FileInputStream("data\\Day"+Integer.parseInt(day.getText())+".svm");
			DataInputStream in = new DataInputStream(fstream);
  			BufferedReader br = new BufferedReader(new InputStreamReader(in));
  			
  			
		
           
           int tempf=firstIndex;
           int templ=lastIndex;
           	
             firstIndex = e.getFirstIndex();
             lastIndex = e.getLastIndex();
            
            int fin;
			if(firstIndex==lastIndex)
				fin=firstIndex;
			else
			{
				if(tempf==firstIndex && templ==lastIndex)
				{
					if(firstIndex>lastIndex)
						fin=firstIndex;
						else
							fin=lastIndex;
				}
				if(tempf!=firstIndex && templ!=lastIndex)
				{
					if(firstIndex>lastIndex)
						fin=firstIndex;
						else
							fin=lastIndex;
				}
				if(tempf!=firstIndex && templ==lastIndex)
				{
							fin=firstIndex;
				}
				else
				{
					fin=lastIndex;
				}
			}
            
            
            
            
            
            String newline = "\n";
            
            if(num%2==0)
            {
     	      	jTextArea1.setText("");
            	jTextArea1.append(strings[start-Integer.parseInt(dequeue.getText())+lastIndex]);
            	jTextArea1.append(newline);
            	String tempstr=strings[start-Integer.parseInt(dequeue.getText())+lastIndex];
            	int t=9;
            	String newtempstr="";
            	while(tempstr.charAt(t)!=32)
            	{
            		newtempstr+=tempstr.charAt(t);
            		t++;
            	}
            	int id;
            		id=Integer.parseInt(newtempstr);
            	for(t=0;t<id;t++)
            		newtempstr=br.readLine();
            	jTextArea1.append(newtempstr);
            	jTextArea1.append(newline);	
            }
    
            num++;
           }
           catch(Exception exp)
           {
           	exp.printStackTrace();
           }
        }
    }
}
