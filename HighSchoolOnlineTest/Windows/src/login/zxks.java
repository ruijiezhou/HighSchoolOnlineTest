/*
 * zxks.java
 *
 * Created on __DATE__, __TIME__
 */
package login;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JFrame;
import java.util.Calendar;

import javax.swing.JTextField;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author  ѧ�����߿������
 */
public class zxks extends javax.swing.JFrame {
	public 	static	int counttimes=0;
	public 	static	int tishu=0;
	public 	static	int sx=0;
	public 	static	String kgtanswer;
	public 	static	String sjid;
	public 	static	int score0;
	public 	static	int score1;
	public 	static int time;
	
	Thread t; //����һ���߳�
	Calendar now; 
	int hour; 
	int hourEnd; 
	int minute; 
	int minuteend; 
	int second; 
	int secondend; 
	int hourend; 
	int minutePlus; 
	int secondPlus; 
	boolean right = true;
	int s1=0;		//s1��s2����Ϊ�ź���,�ڸ���ʱ�Ӻͷ���ʱʹ��
	int s2=0;
	
	public 	static	String [] zgtdaan=new String[50];
	/** Creates new form zxks */
	public zxks() {
		initComponents();
	}
	//ʱ�䵹��ʱ
	public void MyTiming() {
		now = Calendar.getInstance();  
		hourEnd = now.get(Calendar.HOUR_OF_DAY) + 1;  
		minutePlus = now.get(Calendar.MINUTE);  
		secondPlus = now.get(Calendar.SECOND);  
		hourend=time/60;	//�����趨�Ŀ���ʱ��ȷ������Сʱ��
		minuteend=time%60;	//�����趨�Ŀ���ʱ��ȷ�����Է�����(������Сʱ��)
		t = new Thread(new Runnable() 
		{  
			public void run() 
			{   
				
					while (right)
					{     
						try {       
							Thread.sleep(100);       
							jTextField1.setText(CalTime());    //����CalTime���������ϸ���textField ����ʾ����ʱʱ��      
							} 
						catch (InterruptedException e) {      
							e.printStackTrace();     
							}    
						if(hourend==0&&minuteend==0&&secondend==0){
							int row1 = jTable1.getSelectedRow(); 
							int col1 = jTable1.getSelectedColumn(); 
							if(row1!=-1)
							jTable1.getCellEditor(row1,col1).stopCellEditing();
							int [] daant0=new int[jTable1.getRowCount()];
							for(int i=0;i<jTable1.getRowCount();i++){
								daant0[i]=Integer.parseInt(String.valueOf(jTable1.getValueAt(i,1)));
							}
							int row2 = jTable2.getSelectedRow(); 
							int col2 = jTable2.getSelectedColumn(); 
							if(row2!=-1)
							jTable2.getCellEditor(row2,col2).stopCellEditing();
							int [] daant1=new int[jTable2.getRowCount()];
							for(int i=0;i<jTable2.getRowCount();i++){
								daant1[i]=Integer.parseInt(String.valueOf(jTable2.getValueAt(i,1)));
							}
							String[] kgtdaan1 =kgtanswer.split(" ");
							int count0=0;
							int count1=0;
							String []daant01=new String[daant0.length+daant1.length];
							for(int i=0;i<daant0.length;i++){
								daant01[i]=Integer.toString(daant0[i]);
								if(daant0[i]==Integer.parseInt(String.valueOf((kgtdaan1[i])))){
									count0++;
								}
							}
							for(int i=0;i<daant1.length;i++){
								daant01[i+daant0.length]=Integer.toString(daant1[i]);
								if((daant01[i+daant0.length]).equals(kgtdaan1[i+daant0.length])){
									count1++;
								}
							}
							String kgtda1=OperateQuestion.toString(daant01);
							int kgtfs=0;
							kgtfs=count0*score0+count1*score1;
							
							String xsid=stumain.stuid;
							String xsxm=stumain.stuname;
							String shijuandaan="��\nһ���ж���";
							  for (int i = 0; i<daant0.length; i++) {
								  shijuandaan=shijuandaan+"\n"+(i+1)+"��"+daant0[i];
							  }
							 shijuandaan+="\n����ѡ����";
							  for (int i = 0; i<daant1.length; i++) {
								  shijuandaan=shijuandaan+"\n"+(i+1)+"��"+daant1[i];
							  } 
							  for (int i = 0; i<tishu; i++) {
								  shijuandaan=shijuandaan+"\n"+zgtdaan[i];
							  }
							int score=0;
							GetConn gc=new GetConn();
						    String str1="insert into "+sjid+" (id,name,answer,score,kgtanswer,kgtscore)" +"values('"+xsid+"','"+xsxm+"','"+shijuandaan+"','"+score+"','"+kgtda1+"','"+kgtfs+"')";
						    int result1=gc.executeUpdate(str1);
						    System.out.println("�߳�����");
						    if (result1 ==1) {

								JOptionPane.showMessageDialog(zxks.this, "����ɹ�!", "��ӭ", 1);
								dispose();
								}
							 else {
								JOptionPane.showMessageDialog(zxks.this, "����ʧ�ܣ������½���","Error!", 1);
							 }
						    break;
						}
					}   
	
			} 
		}); 
		t.start();  
		
	}
	public String CalTime() {  
		now = Calendar.getInstance();  
		hour = now.get(Calendar.HOUR_OF_DAY); 	//�ֱ�õ�ϵͳ��ǰ��Сʱ��,������,Сʱ��
		minute = now.get(Calendar.MINUTE);  
		second = now.get(Calendar.SECOND); 
	
		do
		{  
			//����ϵͳ��ǰʱ�������µ���ʱ����
			if(second>=secondPlus) 	secondend = 59 - second+secondPlus; 
			else 	secondend=secondPlus-second-1;
			
			if(secondend==59 )//���ݵ���ʱ���������·��ӣ���ע���ź������Ƶ�ʹ��
			{
				if(s1==0)
				{
					minuteend--;
					if(minuteend==-1) minuteend=59;
					s1=1;
				}
			}
			else s1=0;
			if(secondend==59&&minuteend==59)//���ݵ���ʱ���Ӻ�����������ʱ�ӣ�ͬ��ע���ź�������
			{
				if(s2==0)
				{
					hourend--;
					s2=1;
				}
			}
	
			return "" + hourend + ":" + minuteend + ":" + secondend+" "; //����??:??:??��ʽ�ĵ���ʱ
			
		}  while(hourend!=0||minuteend!=0||secondend!=0);
		
	} 

	private void initComponents() {

		this.setBounds(250, 50, 200, 300);
		jScrollPane1 = new javax.swing.JScrollPane();
		jEditorPane1 = new javax.swing.JTextPane();
		jEditorPane1.setEditable(false);
		jScrollPane2 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable()
		{
			public boolean isCellEditable(int row,int col){
				if(col==0)
					return false;
				else return true;
			}
		};
		jTable2 = new javax.swing.JTable()
		{
			public boolean isCellEditable(int row,int col){
				if(col==0)
					return false;
				else return true;
			}
		};
		jScrollPane3 = new javax.swing.JScrollPane();
		jScrollPane4 = new javax.swing.JScrollPane();
		jEditorPane2 = new javax.swing.JEditorPane();
		jLabel1 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jButtonxyt = new javax.swing.JButton();
		jButtonsyt = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();
		jButtonks = new javax.swing.JButton();
		jButtontj = new javax.swing.JButton();
		jTextField1 =new javax.swing.JTextField();
		setTitle("���߿���");
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		jScrollPane1.setViewportView(jEditorPane1);
		jScrollPane3.setViewportView(jEditorPane2);
		jLabel1.setText("\u4e3b\u89c2\u9898\u7b54\u9898\u533a\uff1a");
		jButtonxyt.setText("\u4e0b\u4e00\u9898");
		jButtonxyt.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonxytActionPerformed(evt);
			}
		});

		jButtonsyt.setText("\u4e0a\u4e00\u9898");
		jButtonsyt.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonsytActionPerformed(evt);
			}
		});

		jLabel2.setText("�ж����������");

		jButtonks.setText("\u5f00\u59cb\u8003\u8bd5");
		jButtonks.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonksActionPerformed(evt);
			}
		});

		jButtontj.setText("\u63d0\u4ea4\u7b54\u5377");
		jButtontj.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtontjActionPerformed(evt);
			}
		});

		jLabel3.setText("\u9009\u62e9\u9898\u7b54\u9898\u533a\uff1a");

		

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(6, 6, 6)
																.addComponent(
																		jButtonks)
																.addGap(18, 18,
																		18)
																.addComponent(
																		jButtontj)
																		.addGap(28, 28,
																		28)
																.addComponent(
																		jTextField1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		77,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addComponent(
														jScrollPane1,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														420, Short.MAX_VALUE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(
														jScrollPane2,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														291, Short.MAX_VALUE)
												.addComponent(
														jScrollPane4,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														291, Short.MAX_VALUE)
												.addComponent(jScrollPane3, 0,
														0, Short.MAX_VALUE)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jLabel1)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(
																		jButtonxyt)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		57,
																		Short.MAX_VALUE)
																.addComponent(
																		jButtonsyt))
												.addComponent(jLabel2)
												.addComponent(jLabel3))
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jLabel2)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jScrollPane2,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		104,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jLabel3)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jScrollPane4,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		105,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(18, 18,
																		18)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel1)
																				.addGroup(
																						layout.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																								.addComponent(
																										jButtonxyt)
																								.addComponent(
																										jButtonsyt)))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(
																		jScrollPane3,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		282,
																		Short.MAX_VALUE))
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						jButtonks)
																				.addComponent(
																						jButtontj)
																							.addComponent(
																						jTextField1,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jScrollPane1,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		573,
																		Short.MAX_VALUE)))));

		pack();
	}
	//��һ��,��д��
	private void jButtonsytActionPerformed(java.awt.event.ActionEvent evt) {
		if(sx>0&&sx<=tishu){
		zgtdaan[sx]=jEditorPane2.getText();
		sx--;
		jEditorPane2.setText((String)zgtdaan[sx]);
		}
		else if(sx==0){
			zgtdaan[sx]=jEditorPane2.getText();
		}
	}
	//��һ��,��д��
	private void jButtonxytActionPerformed(java.awt.event.ActionEvent evt) {
		if(sx<(tishu-1)&&sx>=0){
		zgtdaan[sx]=jEditorPane2.getText();
		sx++;
		jEditorPane2.setText((String)zgtdaan[sx]);
		}
		else if(sx==(tishu-1)){
			zgtdaan[sx]=jEditorPane2.getText();
		}	
	}
	//�ύ�Ծ�
	private void jButtontjActionPerformed(java.awt.event.ActionEvent evt) {
		
		int res=JOptionPane.showConfirmDialog(null, "ÿ��IDֻ�ܽ���һ�����߿��ԣ���ȷ��Ҫ�ύ�Ծ���", "ȷ���ύ�Ծ�", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(res==JOptionPane.YES_OPTION)
		{
			int row1 = jTable1.getSelectedRow(); 
			int col1 = jTable1.getSelectedColumn(); 
			if(row1!=-1)
			jTable1.getCellEditor(row1,col1).stopCellEditing();
			int [] daant0=new int[jTable1.getRowCount()];//����ж����
			for(int i=0;i<jTable1.getRowCount();i++){
				daant0[i]=Integer.parseInt(String.valueOf(jTable1.getValueAt(i,1)));
			}
			int row2 = jTable2.getSelectedRow(); 
			int col2 = jTable2.getSelectedColumn(); 
			if(row2!=-1)
			jTable2.getCellEditor(row2,col2).stopCellEditing();
			int [] daant1=new int[jTable2.getRowCount()];//���ѡ�����
			for(int i=0;i<jTable2.getRowCount();i++){
				daant1[i]=Integer.parseInt(String.valueOf(jTable2.getValueAt(i,1)));
			}
			String[] kgtdaan1 =kgtanswer.split(" ");//����͹����ʵ���Զ��ľ�
			int count0=0;
			int count1=0;
			String []daant01=new String[daant0.length+daant1.length];
			for(int i=0;i<daant0.length;i++){//�Զ��ľ�����͹����ܷ�
				daant01[i]=Integer.toString(daant0[i]);
				if(daant0[i]==Integer.parseInt(String.valueOf((kgtdaan1[i])))){
					count0++;
				}
			}
			for(int i=0;i<daant1.length;i++){
				daant01[i+daant0.length]=Integer.toString(daant1[i]);
				if((daant01[i+daant0.length]).equals(kgtdaan1[i+daant0.length])){
					count1++;
				}
			}
			String kgtda1=OperateQuestion.toString(daant01);
			int kgtfs=0;
			kgtfs=count0*score0+count1*score1;	//�õ��͹����ܷ�
			String xsid=stumain.stuid;
			String xsxm=stumain.stuname;
			String shijuandaan="��\nһ���ж���";//��ȡ���ݾ��Ӵ�
			  for (int i = 0; i<daant0.length; i++) {
				  shijuandaan=shijuandaan+"\n"+(i+1)+"��"+daant0[i];
			  }
			 shijuandaan+="\n����ѡ����";
			  for (int i = 0; i<daant1.length; i++) {
				  shijuandaan=shijuandaan+"\n"+(i+1)+"��"+daant1[i];
			  } 
			  for (int i = 0; i<tishu; i++) {
				  shijuandaan=shijuandaan+"\n"+zgtdaan[i];
			  }
			int score=0;
			GetConn gc=new GetConn();
		    String str1="insert into "+sjid+" (id,name,answer,score,kgtanswer,kgtscore)"
			+"values('"+xsid+"','"+xsxm+"','"+shijuandaan+"','"+score+"','"+kgtda1+"','"+kgtfs+"')";
		    String str2="insert into "+sjid+" (id,name,answer,score,kgtanswer,kgtscore)"
		    		+"values('"+xsid+"','"+xsxm+"','"+shijuandaan+"','"+score+"','"+kgtda1+"','"+kgtfs+"')";
		    //System.out.println(result1);
		    String str4="insert into sj2014471024 (id,name,answer,score,kgtanswer,kgtscore)"+
		    		"values('0','0','0','0','0','0')";
		    String str5="insert into sj (id,name,difficult,chapter,content,answer,note)" +
		    		"values('201448105634','0','0','0','����AFD','AFAGA','')";
		    //�����������д�뿼����Ϣ��
		    //int result2=gc.executeUpdate(str2);
		    int result1=gc.executeUpdate(str1);
		   // System.out.println(result2);
		    System.out.println(result1);
		    System.out.println("�ύ�Ծ���");
//		    System.out.println(sjid);
//		    System.out.println(xsid);
//		    System.out.println(xsxm);
//		    System.out.println(shijuandaan);
//		    System.out.println(score);
//		    System.out.println(kgtda1);
//		    System.out.println(kgtfs);
		    if (result1 ==1) {

				JOptionPane.showMessageDialog(zxks.this, "����ɹ�!", "��ӭ", 1);
				dispose();
				}
			 else {
				JOptionPane.showMessageDialog(zxks.this, "����ʧ�ܣ������½���","Error!", 1);
			 }

		}
		else if(res==JOptionPane.NO_OPTION)
		{
			
		}
		
		
	}
	//��ʼ����
	private void jButtonksActionPerformed(java.awt.event.ActionEvent evt) {
		Popup pop=new Popup(3);
		JOptionPane.showMessageDialog(null, "���Ե�","��ӭ��", 1);
		long start=System.currentTimeMillis();
		if(counttimes==0){
		String[] shijuan;
		try {
			shijuan = OperateQuestion.selectflag();//�ҵ����ο��Ե�ָ���Ծ�
		} catch (Exception e) {
			shijuan = null;
			e.printStackTrace();
		}
		String shijuanks="\n";
		 time=Integer.parseInt(String.valueOf(shijuan[10]));
		 MyTiming();
		int score=Integer.parseInt(String.valueOf(shijuan[2]));
		int difficult=Integer.parseInt(String.valueOf(shijuan[1]));
		score0=Integer.parseInt(String.valueOf(shijuan[11]));
		score1=Integer.parseInt(String.valueOf(shijuan[12]));
		String id1=shijuan[0];
		sjid="sj"+id1;
		stumain stu=new stumain();
		 Object[][] cj;
	    	try {
				cj = OperateQuestion.selectAlldajuan(sjid);//�����Ծ�����ѡ����Ӧ�Ծ�
			} catch (Exception e) {
				cj = null;
				e.printStackTrace();
			}
			//�����Ծ��Ų��Ҷ�Ӧ�Ŀ�����Ϣ
				for (int i = 0; i < cj.length; i++) {
					String iii=(String)cj[i][0];
					System.out.println(iii);
					System.out.println(stu.stuid);
					if(iii.equals(stu.stuid)){
						JOptionPane.showMessageDialog(zxks.this, "���Ѿ��μӴ˴ο���","Error!", 1);
					}
					}		
		String []get=new String [8];	
		//get=OperateQuestion.zujuan(id1,4);
		shijuanks=get[6];
		String []getda=new String [8];
		getda=OperateQuestion.zujuan(id1,5);
		long end=System.currentTimeMillis()-start;
		System.out.println("��ʼ���Ե�һ����ʱ�䣺"+end);
		get=getda;
		kgtanswer=getda[7];
		System.out.println(kgtanswer);
		int ti=4;
		 Object[][] shijuan1;
	    	try {
				shijuan1= OperateQuestion.selectAllshijuan();
			} catch (Exception e) {
				shijuan1 = null;
				e.printStackTrace();
			}		
			String[] cxshiti1=new String[6];
				int i,j;
				for (i = 0,j=0; i < shijuan1.length; i++) {
					if (shijuan1[i][0].equals(id1)) {
						    cxshiti1[0]=(String) shijuan1[i][4];
						    cxshiti1[1]= (String)shijuan1[i][5];
						    cxshiti1[2]= (String)shijuan1[i][6];
						    cxshiti1[3]= (String)shijuan1[i][7];
						    cxshiti1[4]= (String)shijuan1[i][8];
						    cxshiti1[5]=(String) shijuan1[i][9];
					}
				}	
		String[] ty0 =cxshiti1[0].split(" ");
		String[] ty1 =cxshiti1[1].split(" ");
		String[] ty2 =cxshiti1[2].split(" ");
		String[] ty3 =cxshiti1[3].split(" ");
		String[] ty4 =cxshiti1[4].split(" ");
		String[] ty5 =cxshiti1[5].split(" ");
		end=System.currentTimeMillis()-start;
		System.out.println("��ʼ����ǰ���ʱ�䣺"+end);
		/* Object[][] shiti0;
	    	try {
				shiti0 = OperateQuestion.selectAllQuestion(0);
			} catch (Exception e) {
				shiti0 = null;
				e.printStackTrace();
			}
			Object[][] shiti1;
	    	try {
				shiti1 = OperateQuestion.selectAllQuestion(1);
			} catch (Exception e) {
				shiti1 = null;
				e.printStackTrace();
			}
			Object[][] shiti2;
	    	try {
				shiti2 = OperateQuestion.selectAllQuestion(2);
			} catch (Exception e) {
				shiti2 = null;
				e.printStackTrace();
			}
			Object[][] shiti3;
	    	try {
				shiti3 = OperateQuestion.selectAllQuestion(3);
			} catch (Exception e) {
				shiti3 = null;
				e.printStackTrace();
			}
			Object[][] shiti4;
	    	try {
				shiti4 = OperateQuestion.selectAllQuestion(4);
			} catch (Exception e) {
				shiti4 = null;
				e.printStackTrace();
			}
			Object[][] shiti5;
	    	try {
				shiti5 = OperateQuestion.selectAllQuestion(5);
			} catch (Exception e) {
				shiti5 = null;
				e.printStackTrace();
			}*/
			//��ʾ�Ծ�

		
			ImageIcon img1;
			javax.swing.text.Document doc=new javax.swing.text.DefaultStyledDocument(); 
			jEditorPane1.setDocument(doc);             
			javax.swing.text.SimpleAttributeSet attributeSet=new javax.swing.text.SimpleAttributeSet();      
			try{     
				GetConn gc=new GetConn();
				ResultSet rs=null;
				doc.insertString(doc.getLength(),"\nһ���ж���",attributeSet); 	//���ո�������������ʾÿ��С��ı��/����/ͼƬ
				//for(j=0;j<ty0.length;j++){
				//	for (i = 0; i < shiti0.length; i++) {
				//		if (shiti0[i][0].equals(ty0[j])) {

				String []strTemp=new String[10];
				String str1="select content from questionbank0 where id in(";
				for(j=0;j<ty0.length-1;j++)
				{
					str1+=""+ty0[j]+",";
				}
				str1+=""+ty0[j]+")";
				rs=gc.executeQuery(str1);
				j=0;
				while(rs.next())
				{
					strTemp[j]=(String)rs.getString("content");
					System.out.println(strTemp[j]);
					j++;
				}
				
				
				for(j=0;j<ty0.length;j++)
				{
				    doc.insertString(doc.getLength(),"\n"+(j+1)+"."+strTemp[j]+"\n",attributeSet);  
				  /*  long start1=System.currentTimeMillis();
					byte [] buffer=null;
					IOImage ii=new IOImage();		
					try {
						buffer=ii.readBolb(ty0[j],0); //��ȡ������д洢��ͼƬ�������� 
						System.out.println("buffer:correct0");
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("buffer:error0");
					}
					if(buffer!=null){//��ͼƬ����ʾ
						Binary b=new Binary();
						ImageIcon img=b.BytetoImage(buffer);//����������ת����ͼƬ��ʾ
						img1=b.zoom(img,250,250);//ͼƬ��С�趨
						jEditorPane1.insertIcon(img1);
					}
					long end1=System.currentTimeMillis()-start1;
					System.out.println(end1);
					*/
				}
						//}
						//}
					//}	
				doc.insertString(doc.getLength(),"\n����ѡ����",attributeSet); 	//��ʾѡ�������������ͼƬ
				/*for(j=0;j<ty1.length;j++){
					for (i = 0; i < shiti1.length; i++) {
						if (shiti1[i][0].equals(ty1[j])) {  
							    doc.insertString(doc.getLength(),"\n"+(j+1)+"."+(String) shiti1[i][ti]+"\n",attributeSet);  
								byte [] buffer=null;
								IOImage ii=new IOImage();		
								try {
									buffer=ii.readBolb(ty1[j],1);  
									
								} catch (Exception e) {
									e.printStackTrace();
									
								}
								if(buffer!=null){
								Binary b=new Binary();
								ImageIcon img=b.BytetoImage(buffer);
								img1=b.zoom(img,250,250);
							jEditorPane1.insertIcon(img1);}
						}
						}
					}*/
				str1="select content from questionbank1 where id in(";
				for(j=0;j<ty1.length-1;j++)
				{
					str1+=""+ty1[j]+",";
				}
				str1+=""+ty1[j]+")";
				rs=gc.executeQuery(str1);
				j=0;
				while(rs.next())
				{
					strTemp[j]=(String)rs.getString("content");
					System.out.println(strTemp[j]);
					j++;
				}
				for(j=0;j<ty1.length;j++)
				{

				    doc.insertString(doc.getLength(),"\n"+(j+1)+"."+strTemp[j]+"\n",attributeSet);  
				    
					/*byte [] buffer=null;
					IOImage ii=new IOImage();		
					try {
						buffer=ii.readBolb(ty1[j],1); //��ȡ������д洢��ͼƬ�������� 
						System.out.println("buffer:correct1");
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("buffer:error1");
					}
					if(buffer!=null){//��ͼƬ����ʾ
						Binary b=new Binary();
						ImageIcon img=b.BytetoImage(buffer);//����������ת����ͼƬ��ʾ
						img1=b.zoom(img,250,250);//ͼƬ��С�趨
						jEditorPane1.insertIcon(img1);
					}*/
				}
				doc.insertString(doc.getLength(),"\n���������",attributeSet); 	//��ʾ��������������ͼƬ
				/*for(j=0;j<ty2.length;j++){
					for (i = 0; i < shiti2.length; i++) {
						if (shiti2[i][0].equals(ty2[j])) {  
							    doc.insertString(doc.getLength(),"\n"+(j+1)+"."+(String) shiti2[i][ti]+"\n",attributeSet);  
								byte [] buffer=null;
								IOImage ii=new IOImage();		
								try {
									buffer=ii.readBolb(ty2[j],2);  
								} catch (Exception e) {
									e.printStackTrace();
								}
								if(buffer!=null){
								Binary b=new Binary();
								ImageIcon img=b.BytetoImage(buffer);
								 img1=b.zoom(img,250,250);
							jEditorPane1.insertIcon(img1);}
						}
						}
					}	*/
				str1="select content from questionbank2 where id in(";
				for(j=0;j<ty2.length-1;j++)
				{
					str1+=""+ty2[j]+",";
				}
				str1+=""+ty2[j]+")";
				rs=gc.executeQuery(str1);
				j=0;
				while(rs.next())
				{
					strTemp[j]=(String)rs.getString("content");
					System.out.println(strTemp[j]);
					j++;
				}
				for(j=0;j<ty2.length;j++)
				{

				    doc.insertString(doc.getLength(),"\n"+(j+1)+"."+strTemp[j]+"\n",attributeSet);  
				    
				   /* byte [] buffer=null;
					IOImage ii=new IOImage();		
					try {
						buffer=ii.readBolb(ty2[j],2);  
					} catch (Exception e) {
						e.printStackTrace();
					}
					if(buffer!=null)
					{
						Binary b=new Binary();
						ImageIcon img=b.BytetoImage(buffer);
						img1=b.zoom(img,250,250);
						jEditorPane1.insertIcon(img1);
					}*/
				}
				doc.insertString(doc.getLength(),"\n�ġ������",attributeSet); //��ʾ��������������ͼƬ	
				/*for(j=0;j<ty3.length;j++){
					for (i = 0; i < shiti3.length; i++) {
						if (shiti3[i][0].equals(ty3[j])) {  
							    doc.insertString(doc.getLength(),"\n"+(j+1)+"."+(String) shiti3[i][ti]+"\n",attributeSet);  
								byte [] buffer=null;
								IOImage ii=new IOImage();		
								try {
									buffer=ii.readBolb(ty3[j],3);  
								} catch (Exception e) {
									e.printStackTrace();
								}
								if(buffer!=null){
								Binary b=new Binary();
								ImageIcon img=b.BytetoImage(buffer);
								 img1=b.zoom(img,250,250);
							jEditorPane1.insertIcon(img1);}
						}
						}
					}*/
				str1="select content from questionbank3 where id in(";
				for(j=0;j<ty3.length-1;j++)
				{
					str1+=""+ty3[j]+",";
				}
				str1+=""+ty3[j]+")";
				rs=gc.executeQuery(str1);
				j=0;
				while(rs.next())
				{
					strTemp[j]=(String)rs.getString("content");
					System.out.println(strTemp[j]);
					j++;
				}
				for(j=0;j<ty3.length;j++)
				{

				   doc.insertString(doc.getLength(),"\n"+(j+1)+"."+strTemp[j]+"\n",attributeSet);  
				    
				   /*byte [] buffer=null;
					IOImage ii=new IOImage();		
					try {
						buffer=ii.readBolb(ty3[j],3);  
					} catch (Exception e) {
						e.printStackTrace();
					}
					if(buffer!=null)
					{
						Binary b=new Binary();
						ImageIcon img=b.BytetoImage(buffer);
						img1=b.zoom(img,250,250);
						jEditorPane1.insertIcon(img1);
					}*/
				}
				doc.insertString(doc.getLength(),"\n�塢������",attributeSet); //��ʾ�����͸���������ͼƬ	
				/*for(j=0;j<ty4.length;j++){
					for (i = 0; i < shiti4.length; i++) {
						if (shiti4[i][0].equals(ty4[j])) {  
							    doc.insertString(doc.getLength(),"\n"+(j+1)+"."+(String) shiti4[i][ti]+"\n",attributeSet);  
								byte [] buffer=null;
								IOImage ii=new IOImage();		
								try {
									buffer=ii.readBolb(ty4[j],4);  
								} catch (Exception e) {
									e.printStackTrace();
								}
								if(buffer!=null){
								Binary b=new Binary();
								ImageIcon img=b.BytetoImage(buffer);
								 img1=b.zoom(img,250,250);
							jEditorPane1.insertIcon(img1);}
						}
						}
					}*/
				str1="select content from questionbank4 where id in(";
				for(j=0;j<ty4.length-1;j++)
				{
					str1+=""+ty4[j]+",";
				}
				str1+=""+ty4[j]+")";
				rs=gc.executeQuery(str1);
				j=0;
				while(rs.next())
				{
					strTemp[j]=(String)rs.getString("content");
					System.out.println(strTemp[j]);
					j++;
				}
				for(j=0;j<ty4.length;j++)
				{

				    doc.insertString(doc.getLength(),"\n"+(j+1)+"."+strTemp[j]+"\n",attributeSet);  
				    
				  /*  byte [] buffer=null;
					IOImage ii=new IOImage();		
					try {
						buffer=ii.readBolb(ty4[j],4);  
					} catch (Exception e) {
						e.printStackTrace();
					}
					if(buffer!=null)
					{
						Binary b=new Binary();
						ImageIcon img=b.BytetoImage(buffer);
						img1=b.zoom(img,250,250);
						jEditorPane1.insertIcon(img1);
					}*/
				}
				doc.insertString(doc.getLength(),"\n����������",attributeSet); //��ʾ�����͸���������ͼƬ		
				/*for(j=0;j<ty5.length;j++){
					for (i = 0; i < shiti5.length; i++) {
						if (shiti5[i][0].equals(ty5[j])) {  
							    doc.insertString(doc.getLength(),"\n"+(j+1)+"."+(String) shiti5[i][ti]+"\n",attributeSet);  
								byte [] buffer=null;
								IOImage ii=new IOImage();		
								try {
									buffer=ii.readBolb(ty5[j],5);  
								} catch (Exception e) {
									e.printStackTrace();
								}
								if(buffer!=null){
								Binary b=new Binary();
								ImageIcon img=b.BytetoImage(buffer);
								 img1=b.zoom(img,250,250);
							jEditorPane1.insertIcon(img1);}  
						}
						}
					}*/
				str1="select content from questionbank5 where id in(";
				for(j=0;j<ty5.length-1;j++)
				{
					str1+=""+ty5[j]+",";
				}
				str1+=""+ty5[j]+")";
				rs=gc.executeQuery(str1);
				j=0;
				while(rs.next())
				{
					strTemp[j]=(String)rs.getString("content");
					System.out.println(strTemp[j]);
					j++;
				}
				for(j=0;j<ty5.length;j++)
				{

				    doc.insertString(doc.getLength(),"\n"+(j+1)+"."+strTemp[j]+"\n",attributeSet);  
				    
				  /*  byte [] buffer=null;
					IOImage ii=new IOImage();		
					try {
						buffer=ii.readBolb(ty5[j],5);  
					} catch (Exception e) {
						e.printStackTrace();
					}
					if(buffer!=null)
					{
						Binary b=new Binary();
						ImageIcon img=b.BytetoImage(buffer);
						img1=b.zoom(img,250,250);
						jEditorPane1.insertIcon(img1);
					}
					*/
				}
			/*doc.insertString(doc.getLength(),"\nһ���ж���",attributeSet); 	
			for(j=0;j<ty0.length;j++){
				for (i = 0; i < shiti0.length; i++) {
					if (shiti0[i][0].equals(ty0[j])) {
						    
						    doc.insertString(doc.getLength(),"\n"+(j+1)+"."+(String) shiti0[i][ti]+"\n",attributeSet);  
							byte [] buffer=null;
							IOImage ii=new IOImage();		
							try {
								buffer=ii.readBolb(ty0[j],0);  
							} catch (Exception e) {
								e.printStackTrace();
							}
							if(buffer!=null){
							Binary b=new Binary();
							ImageIcon img=b.BytetoImage(buffer);
							 img1=b.zoom(img,250,250);
						jEditorPane1.insertIcon(img1);}
						  
					}
					}
				}	
			doc.insertString(doc.getLength(),"\n����ѡ����",attributeSet); 	
			for(j=0;j<ty1.length;j++){
				for (i = 0; i < shiti1.length; i++) {
					if (shiti1[i][0].equals(ty1[j])) {  
						    doc.insertString(doc.getLength(),"\n"+(j+1)+"."+(String) shiti1[i][ti]+"\n",attributeSet);  
							byte [] buffer=null;
							IOImage ii=new IOImage();		
							try {
								buffer=ii.readBolb(ty1[j],1);  
							} catch (Exception e) {
								e.printStackTrace();
							}
							if(buffer!=null){
							Binary b=new Binary();
							ImageIcon img=b.BytetoImage(buffer);
							 img1=b.zoom(img,250,250);
						jEditorPane1.insertIcon(img1);}
					}
					}
				}	
			doc.insertString(doc.getLength(),"\n���������",attributeSet); 	
			for(j=0;j<ty2.length;j++){
				for (i = 0; i < shiti2.length; i++) {
					if (shiti2[i][0].equals(ty2[j])) {  
						    doc.insertString(doc.getLength(),"\n"+(j+1)+"."+(String) shiti2[i][ti]+"\n",attributeSet);  
							byte [] buffer=null;
							IOImage ii=new IOImage();		
							try {
								buffer=ii.readBolb(ty2[j],2);  
							} catch (Exception e) {
								e.printStackTrace();
							}
							if(buffer!=null){
							Binary b=new Binary();
							ImageIcon img=b.BytetoImage(buffer);
							 img1=b.zoom(img,250,250);
						jEditorPane1.insertIcon(img1);}
					}
					}
				}	
			doc.insertString(doc.getLength(),"\n�ġ������",attributeSet); 	
			for(j=0;j<ty3.length;j++){
				for (i = 0; i < shiti3.length; i++) {
					if (shiti3[i][0].equals(ty3[j])) {  
						    doc.insertString(doc.getLength(),"\n"+(j+1)+"."+(String) shiti3[i][ti]+"\n",attributeSet);  
							byte [] buffer=null;
							IOImage ii=new IOImage();		
							try {
								buffer=ii.readBolb(ty3[j],3);  
							} catch (Exception e) {
								e.printStackTrace();
							}
							if(buffer!=null){
							Binary b=new Binary();
							ImageIcon img=b.BytetoImage(buffer);
							 img1=b.zoom(img,250,250);
						jEditorPane1.insertIcon(img1);}
					}
					}
				}
			doc.insertString(doc.getLength(),"\n�塢������",attributeSet); 	
			for(j=0;j<ty4.length;j++){
				for (i = 0; i < shiti4.length; i++) {
					if (shiti4[i][0].equals(ty4[j])) {  
						    doc.insertString(doc.getLength(),"\n"+(j+1)+"."+(String) shiti4[i][ti]+"\n",attributeSet);  
							byte [] buffer=null;
							IOImage ii=new IOImage();		
							try {
								buffer=ii.readBolb(ty4[j],4);  
							} catch (Exception e) {
								e.printStackTrace();
							}
							if(buffer!=null){
							Binary b=new Binary();
							ImageIcon img=b.BytetoImage(buffer);
							 img1=b.zoom(img,250,250);
						jEditorPane1.insertIcon(img1);}
					}
					}
				}
			doc.insertString(doc.getLength(),"\n����������",attributeSet); 	
			for(j=0;j<ty5.length;j++){
				for (i = 0; i < shiti5.length; i++) {
					if (shiti5[i][0].equals(ty5[j])) {  
						    doc.insertString(doc.getLength(),"\n"+(j+1)+"."+(String) shiti5[i][ti]+"\n",attributeSet);  
							byte [] buffer=null;
							IOImage ii=new IOImage();		
							try {
								buffer=ii.readBolb(ty5[j],5);  
							} catch (Exception e) {
								e.printStackTrace();
							}
							if(buffer!=null){
							Binary b=new Binary();
							ImageIcon img=b.BytetoImage(buffer);
							 img1=b.zoom(img,250,250);
						jEditorPane1.insertIcon(img1);}  
					}
					}
				}
			*/
			
			
			}
			catch(Exception e){e.printStackTrace(System.out);
			}  
		
		//�������������ɿ͹�����⿨����������⿨
		int t0n=Integer.parseInt(String.valueOf(get[0]));
		int t1n=Integer.parseInt(String.valueOf(get[1]));
		int t2n=Integer.parseInt(String.valueOf(get[2]));
		int t3n=Integer.parseInt(String.valueOf(get[3]));
		int t4n=Integer.parseInt(String.valueOf(get[4]));
		int t5n=Integer.parseInt(String.valueOf(get[5]));
		tishu=t5n+t4n+t3n+t2n;
		for(int i1=0;i1<t2n;i1++){
			zgtdaan[i1]="�����\n"+(i1+1)+".\n";
		}
		for(int i1=0;i1<t3n;i1++){
			zgtdaan[i1+t2n]="�����\n"+(i1+1)+".\n";
		}
		for(int i1=0;i1<t4n;i1++){
			zgtdaan[i1+t3n+t2n]="������\n"+(i1+1)+".\n";
		}
		for(int i1=0;i1<t5n;i1++){
			zgtdaan[i1+t4n+t3n+t2n]="������\n"+(i1+1)+".\n";
		}
		jEditorPane2.setText((String)zgtdaan[0]);
		
		Object[][] datika1 =new Object[t0n][2];
		Object[][] datika2 =new Object[t1n][2];
		for(int i1=0;i1<t0n;i1++){
			datika1[i1][0]=i1+1;
			datika1[i1][1]=-1;
		}
			
			
				jTable1.setModel(new javax.swing.table.DefaultTableModel(
				datika1,new Object[]{"Question","Answer"}));	
		
		String[] answer = {"��","��"};
		jTable1.getColumn("Answer").setCellRenderer(
	    	      new RadioButtonRenderer(answer)
	    	    );
		jTable1.getColumn("Answer").setCellEditor(
	    	      new RadioButtonEditor(new JCheckBox(), 
	    	                            new RadioButtonPanel(answer))
	    	    );


		jScrollPane2.setViewportView(jTable1);
		
		//�͹�����⿨�ڱ�������ѡ�񰴼�
		for(int i1=0;i1<t1n;i1++){
			datika2[i1][0]=i1+1;
			datika2[i1][1]=-1;
		}
		jTable2.setModel(new javax.swing.table.DefaultTableModel(
				datika2,new Object[]{"Question","Answer"}));	
		
		String[] answer1 = {"A","B","C","D"};
		jTable2.getColumn("Answer").setCellRenderer(
	    	      new RadioButtonRenderer(answer1)
	    	    );
		jTable2.getColumn("Answer").setCellEditor(
	    	      new RadioButtonEditor(new JCheckBox(), 
	    	                            new RadioButtonPanel(answer1))
	    	    );
		jScrollPane4.setViewportView(jTable2);
		counttimes++;
		}
		long end=System.currentTimeMillis()-start;
		System.out.println(end);
		pop.dispose();
	}
	//�ڱ������ӵ�ѡ��ť��ϵ�з���
	 public class RadioButtonPanel extends JPanel {
		    JRadioButton[] buttons;
		    
		    RadioButtonPanel(String[] str) {
		      setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		      buttons = new JRadioButton[str.length];
		      for (int i=0; i<buttons.length; i++) {
		        buttons[i] = new JRadioButton(str[i]);
		        buttons[i].setFocusPainted(false);
		        add(buttons[i]);
		      }      
		    }
		    
		    public void setSelectedIndex(int index) {
		      for (int i=0;i<buttons.length;i++) {
		        buttons[i].setSelected(i == index);
		      }
		    }
		    
		    public int getSelectedIndex() {
		      for (int i=0; i<buttons.length; i++) {
		        if (buttons[i].isSelected()) {
		          return i;
		        }
		      }      
		      return -1;      
		    }
		    
		    public JRadioButton[] getButtons() {
		      return buttons;
		    }
		  }


		  
		  public class RadioButtonRenderer extends    RadioButtonPanel
		                            implements TableCellRenderer {    
		    RadioButtonRenderer(String[] strs) {
		      super(strs);
		    }
		    
		    public Component getTableCellRendererComponent(JTable table, Object value,
		                   boolean isSelected, boolean hasFocus, int row, int column) {
		      if (value instanceof Integer) {
		        setSelectedIndex(((Integer)value).intValue());
		      }      
		      return this;
		    }
		  }



		  public class RadioButtonEditor extends    DefaultCellEditor
		                          implements ItemListener {
		    RadioButtonPanel panel;

		    public RadioButtonEditor(JCheckBox checkBox,RadioButtonPanel panel) {
		      super(checkBox);
		      this.panel = panel;
		      ButtonGroup buttonGroup = new ButtonGroup();
		      JRadioButton[] buttons  = panel.getButtons();
		      for (int i=0; i<buttons.length; i++) {
		        buttonGroup.add(buttons[i]);
		        buttons[i].addItemListener(this);
		      }                  
		    }

		    public Component getTableCellEditorComponent(JTable table, Object value,
		                   boolean isSelected, int row, int column) {
		      if (value instanceof Integer) {
		        panel.setSelectedIndex(((Integer)value).intValue());
		      }      
		      return panel;
		    }

		    public Object getCellEditorValue() {
		      return new Integer(panel.getSelectedIndex());
		    }

		    public void itemStateChanged(ItemEvent e) {
		      super.fireEditingStopped();
		    }
		  }
	

	private javax.swing.JButton jButtonks;
	private javax.swing.JButton jButtonsyt;
	private javax.swing.JButton jButtontj;
	private javax.swing.JButton jButtonxyt;
	private javax.swing.JTextPane jEditorPane1;
	private javax.swing.JEditorPane jEditorPane2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;	
	private javax.swing.JLabel jLabel3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JScrollPane jScrollPane4;
	private javax.swing.JTable jTable1;
	private javax.swing.JTable jTable2;
	private javax.swing.JTextField jTextField1;

}