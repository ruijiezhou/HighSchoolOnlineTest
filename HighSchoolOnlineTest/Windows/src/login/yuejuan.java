/*
 * yuejuan.java
 *
 * Created on __DATE__, __TIME__
 */

package login;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author  教师阅卷面板,实现查看试卷及参考答案,批阅试卷_
 */
public class yuejuan extends javax.swing.JFrame {
	public String idthis;
	public String xh;
	public int t2;
	public int t3;
	public int t4;
	public int t5;
	public int count;
    public Object[][] dajuan;
	/** Creates new form yuejuan */
	public yuejuan() {
		initComponents();
	}

	private void initComponents() {

		Popup pop=new Popup(2);
		pop.setVisible(true);
		JOptionPane.showMessageDialog(null, "请稍等","欢迎！", 1);
		
		
		jTabbedPane1 = new javax.swing.JTabbedPane();
		jPanel1 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jEditorPane1 = new javax.swing.JTextPane();
		jEditorPane1.setEditable(false);
		jScrollPane2 = new javax.swing.JScrollPane();
		jEditorPane2 = new javax.swing.JEditorPane();
		jEditorPane2.setEditable(false);
		//jScrollPane2.setSize(300, 300);
		jPanel2 = new javax.swing.JPanel();
		jScrollPane4 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable()
		{
			public boolean isCellEditable(int row,int col){
				if(col==0||(col==1&&row==0))
					return false;
				else return true;
			}
		};
		jScrollPane3 = new javax.swing.JScrollPane();
		jEditorPane3 = new javax.swing.JEditorPane();
		jEditorPane3.setEditable(false);
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		setTitle("阅卷");
		this.setBounds(250, 150, 855, 495);
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1,
				javax.swing.BoxLayout.LINE_AXIS));

		jScrollPane1.setViewportView(jEditorPane1);

		jPanel1.add(jScrollPane1);

		jScrollPane2.setViewportView(jEditorPane2);

		jPanel1.add(jScrollPane2);

		jTabbedPane1.addTab("\u8bd5\u9898\u4e0e\u53c2\u8003\u7b54\u6848",
				jPanel1);
		
		String[] shijuan;
		try {
			shijuan = OperateQuestion.selectflag();
		} catch (Exception e) {
			shijuan = null;
			e.printStackTrace();
		}
		String shijuantm="试卷";
		String shijuandaan="参考答案";
		idthis=shijuan[0];
		String []get=new String [8];
		get=OperateQuestion.zujuan(idthis,4);
		shijuantm+=get[6];
		t2=Integer.parseInt(String.valueOf(get[2]));
		t3=Integer.parseInt(String.valueOf(get[3]));
		t4=Integer.parseInt(String.valueOf(get[4]));
		t5=Integer.parseInt(String.valueOf(get[5]));
		String []getda=new String [8];
		String idd="sj"+idthis;
		getda=OperateQuestion.zujuan(idthis,5);
		shijuandaan+=getda[6];
		//显示试卷和参考答案,包括图文
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
					if (shijuan1[i][0].equals(idthis)) {
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
			
			/*ImageIcon img1;
			javax.swing.text.Document doc=new javax.swing.text.DefaultStyledDocument(); 
			jEditorPane1.setDocument(doc);             
			javax.swing.text.SimpleAttributeSet attributeSet=new javax.swing.text.SimpleAttributeSet();      
			try{              
			doc.insertString(doc.getLength(),"\n一、判断题",attributeSet); 	
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
			doc.insertString(doc.getLength(),"\n二、选择题",attributeSet); 	
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
			doc.insertString(doc.getLength(),"\n三、填空题",attributeSet); 	
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
			doc.insertString(doc.getLength(),"\n四、简答题",attributeSet); 	
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
			doc.insertString(doc.getLength(),"\n五、计算题",attributeSet); 	
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
			doc.insertString(doc.getLength(),"\n六、操作题",attributeSet); 	
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
			
			
			}
			catch(Exception e){e.printStackTrace(System.out);
			}  */
		
	    	jEditorPane1.setText(shijuantm);
		jEditorPane2.setText(shijuandaan);

	
		try {
			dajuan = OperateQuestion.selectAlldajuan(idd);
		} catch (Exception e) {
			dajuan = null;
			e.printStackTrace();
		}
		
		
		jScrollPane3.setViewportView(jEditorPane3);

		jButton1.setText("返回");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setText("\u4e0b\u4e00份");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton3.setText("确定");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jButton4.setText("上一份");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout
				.setHorizontalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel2Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jScrollPane3,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												443, Short.MAX_VALUE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																jScrollPane4,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																167,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(
																jPanel2Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				false)
																		.addComponent(
																				jButton4,
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				0,
																				0,
																				Short.MAX_VALUE)
																		.addComponent(
																				jButton3,
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				jButton1,
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				jButton2,
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)))));
		jPanel2Layout
				.setVerticalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addComponent(
												jScrollPane4,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												294,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jButton3)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jButton4)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jButton2)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(jButton1))
						.addComponent(jScrollPane3,
								javax.swing.GroupLayout.DEFAULT_SIZE, 426,
								Short.MAX_VALUE));

		jTabbedPane1.addTab("\u8003\u751f\u7b54\u5377", jPanel2);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 634,
				Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 457,
				Short.MAX_VALUE));

		pack();
		pop.dispose();
	}
	//确认打分
	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		int score=0;
		for(int i=0;i<t2+t3+t4+t5+1;i++){
			if(jTable1.getValueAt(i, 1).equals(null)){//每道题都需要打分
				JOptionPane.showMessageDialog(yuejuan.this, "请为所有的题目打分!", "提醒", 1);
				break;
			}
			else{
		score+=Integer.parseInt(String.valueOf(jTable1.getValueAt(i, 1)));//计算总分
			}
		}
		GetConn gc=new GetConn();
	    String idst="sj"+idthis;
		String str="update "+idst+" set score='"+score+"'where id='"+xh+"'";//往对应考试信息表中写入分数
	    int  result=gc.executeUpdate(str);

		if (result == 1) {
			//阅卷登分成功，显示考生分数
			JOptionPane.showMessageDialog(yuejuan.this, "登记分数成功!卷面成绩为"+score+"分", "提醒", 1);
			}
		 else 
				JOptionPane.showMessageDialog(yuejuan.this, "登记分数失败",
						"Error!", 1);
		
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		dispose();//返回
	}
	//阅卷下一份
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		if(count<(dajuan.length-1)&&count>=0){
		count++;
		String answer=(String)dajuan[count][2];
		xh=(String)dajuan[count][0];
		jEditorPane3.setText(answer);
		 Object[][] jifenka=new Object[t2+t3+t4+t5+1][2];
		 jifenka[0][0]="客观题";
		 jifenka[0][1]=dajuan[count][5];
		for(int i=1;i<t2+1;i++){
			 jifenka[i][0]="填空题"+i;
		}
		for(int i=1;i<t3+1;i++){
			 jifenka[i+t2][0]="简答题"+i;
		}
		for(int i=1;i<=t4;i++){
			 jifenka[i+t2+t3][0]="计算题"+i;
		}
		for(int i=1;i<=t5;i++){
			 jifenka[i+t2+t3+t4][0]="操作题"+i;
		}
		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				jifenka, new String[] { "题号",
						"得分" }));
		jScrollPane4.setViewportView(jTable1);
		}
		else
			JOptionPane.showMessageDialog(yuejuan.this, "已是最后一份考卷!", "提醒", 1);
	}
	//阅卷上一份
	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		if(count<(dajuan.length+1)&&count>1){
			count--;
			String answer=(String)dajuan[count][2];
			xh=(String)dajuan[count][0];
			jEditorPane3.setText(answer);
			 Object[][] jifenka=new Object[t2+t3+t4+t5+1][2];
			 jifenka[0][0]="客观题";
			 jifenka[0][1]=dajuan[count][5];
			for(int i=1;i<t2+1;i++){
				 jifenka[i][0]="填空题"+i;
			}
			for(int i=1;i<t3+1;i++){
				 jifenka[i+t2][0]="简答题"+i;
			}
			for(int i=1;i<=t4;i++){
				 jifenka[i+t2+t3][0]="计算题"+i;
			}
			for(int i=1;i<=t5;i++){
				 jifenka[i+t2+t3+t4][0]="操作题"+i;
			}
			jTable1.setModel(new javax.swing.table.DefaultTableModel(
					jifenka, new String[] { "题号",
							"得分" }));
			jScrollPane4.setViewportView(jTable1);
			}
		else
			JOptionPane.showMessageDialog(yuejuan.this, "已是第一份考卷!", "提醒", 1);
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;

	private javax.swing.JTextPane jEditorPane1;
	private javax.swing.JEditorPane jEditorPane2;
	private javax.swing.JEditorPane jEditorPane3;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JScrollPane jScrollPane4;
	private javax.swing.JTabbedPane jTabbedPane1;
	private javax.swing.JTable jTable1;

}