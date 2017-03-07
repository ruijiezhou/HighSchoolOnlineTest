package login;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author 教师查看试卷面板
 */
public class cksj extends javax.swing.JFrame {
	
	/**创建教师查看试卷面板 */
	public cksj() {
		initComponents();
	}
	//面板初始化
	private void initComponents() {
		jButton1 = new javax.swing.JButton();//新建控件
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jEditorPane1 = new javax.swing.JTextPane();
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		this.setBounds(250, 150, 500, 300);//面板位置
		jButton1.setText("试题");//按钮文字
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}//按钮事件监听器
		});

		jScrollPane1.setViewportView(jEditorPane1);//试题显示面板
		
		jButton2.setText("答案");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton3.setText("返回");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});
		//面板布局代码
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup().addContainerGap()
								.addComponent(jButton1).addGap(18, 18, 18)
								.addComponent(jButton2).addGap(18, 18, 18)
								.addComponent(jButton3)
								.addContainerGap(435, Short.MAX_VALUE))
				.addComponent(jScrollPane1));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jButton1)
												.addComponent(jButton2)
												.addComponent(jButton3))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										380, Short.MAX_VALUE)));

		pack();
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		shitiguanli.shijuanchakan="试卷\n";
			shitiguanli.shijuandaan="参考答案\n";
		dispose();//返回关闭面板并恢复变量
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		jEditorPane1.setText(shitiguanli.shijuandaan);//查看试卷的参考答案
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		int ti=4;
		Object[][] shijuan;
		
		try {
			shijuan= OperateQuestion.selectAllshijuan();
		} catch (Exception e) {
			shijuan = null;
			e.printStackTrace();
		}
		
		String[] cxshiti1=new String[6];
		int i,j;
		for (i = 0,j=0; i < shijuan.length; i++) {//找到对应试卷
		if (shijuan[i][0].equals(shitiguanli.idck)) {
			    cxshiti1[0]=(String) shijuan[i][4];//读出各个题型的所有试题的编号
			    cxshiti1[1]= (String)shijuan[i][5];
			    cxshiti1[2]= (String)shijuan[i][6];
			    cxshiti1[3]= (String)shijuan[i][7];
			    cxshiti1[4]= (String)shijuan[i][8];
			    cxshiti1[5]=(String) shijuan[i][9];
			}
		}	
		
		System.out.println("查看试卷题目：读取试卷信息");
	String[] ty0 =cxshiti1[0].split(" ");//将字符串还原成试题编号数组,字符串中每一项以空格隔开
	String[] ty1 =cxshiti1[1].split(" ");
	String[] ty2 =cxshiti1[2].split(" ");
	String[] ty3 =cxshiti1[3].split(" ");
	String[] ty4 =cxshiti1[4].split(" ");
	String[] ty5 =cxshiti1[5].split(" ");
	
	
	//在各个题型的试题库中读出对应试题
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
		}
		*/
		//实现图片文字在同一面板中混合依次显示
	long start=System.currentTimeMillis();
	System.out.println("试卷查看：开始计时");
		ImageIcon img1;
		javax.swing.text.Document doc=new javax.swing.text.DefaultStyledDocument(); 
		jEditorPane1.setDocument(doc);             
		javax.swing.text.SimpleAttributeSet attributeSet=new javax.swing.text.SimpleAttributeSet();      
		try{       
			GetConn gc=new GetConn();
			ResultSet rs=null;
			doc.insertString(doc.getLength(),"\n一、判断题",attributeSet); 	//按照各个题型依次显示每道小题的编号/内容/图片
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
				buffer=ii.readBolb(ty0[j],0); //读取试题表中存储的图片二进制流 
				System.out.println("buffer:correct0");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("buffer:error0");
			}
			if(buffer!=null){//有图片则显示
				Binary b=new Binary();
				ImageIcon img=b.BytetoImage(buffer);//将二进制流转换成图片显示
				img1=b.zoom(img,250,250);//图片大小设定
				jEditorPane1.insertIcon(img1);
			}
			long end1=System.currentTimeMillis()-start1;
			System.out.println(end1);
			*/
		}
				//}
				//}
			//}	
		doc.insertString(doc.getLength(),"\n二、选择题",attributeSet); 	//显示选择题各题编号文字图片
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
				buffer=ii.readBolb(ty1[j],1); //读取试题表中存储的图片二进制流 
				System.out.println("buffer:correct1");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("buffer:error1");
			}
			if(buffer!=null){//有图片则显示
				Binary b=new Binary();
				ImageIcon img=b.BytetoImage(buffer);//将二进制流转换成图片显示
				img1=b.zoom(img,250,250);//图片大小设定
				jEditorPane1.insertIcon(img1);
			}*/
		}
		doc.insertString(doc.getLength(),"\n三、填空题",attributeSet); 	//显示填空题各题编号文字图片
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
		doc.insertString(doc.getLength(),"\n四、简答题",attributeSet); //显示简答题各题编号文字图片	
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
		doc.insertString(doc.getLength(),"\n五、计算题",attributeSet); //显示该题型各题编号文字图片	
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
		doc.insertString(doc.getLength(),"\n六、操作题",attributeSet); //显示该题型各题编号文字图片		
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
		long end=System.currentTimeMillis()-start;
		System.out.println("试卷查看时间："+end);
		}
		catch(Exception e){e.printStackTrace(System.out);//试卷显示完毕
		}  
	}
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JTextPane jEditorPane1;
	private javax.swing.JScrollPane jScrollPane1;

}