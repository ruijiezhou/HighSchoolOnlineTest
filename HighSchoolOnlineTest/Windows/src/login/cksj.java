package login;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ��ʦ�鿴�Ծ����
 */
public class cksj extends javax.swing.JFrame {
	
	/**������ʦ�鿴�Ծ���� */
	public cksj() {
		initComponents();
	}
	//����ʼ��
	private void initComponents() {
		jButton1 = new javax.swing.JButton();//�½��ؼ�
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jEditorPane1 = new javax.swing.JTextPane();
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		this.setBounds(250, 150, 500, 300);//���λ��
		jButton1.setText("����");//��ť����
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}//��ť�¼�������
		});

		jScrollPane1.setViewportView(jEditorPane1);//������ʾ���
		
		jButton2.setText("��");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton3.setText("����");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});
		//��岼�ִ���
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
		shitiguanli.shijuanchakan="�Ծ�\n";
			shitiguanli.shijuandaan="�ο���\n";
		dispose();//���عر���岢�ָ�����
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		jEditorPane1.setText(shitiguanli.shijuandaan);//�鿴�Ծ�Ĳο���
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
		for (i = 0,j=0; i < shijuan.length; i++) {//�ҵ���Ӧ�Ծ�
		if (shijuan[i][0].equals(shitiguanli.idck)) {
			    cxshiti1[0]=(String) shijuan[i][4];//�����������͵���������ı��
			    cxshiti1[1]= (String)shijuan[i][5];
			    cxshiti1[2]= (String)shijuan[i][6];
			    cxshiti1[3]= (String)shijuan[i][7];
			    cxshiti1[4]= (String)shijuan[i][8];
			    cxshiti1[5]=(String) shijuan[i][9];
			}
		}	
		
		System.out.println("�鿴�Ծ���Ŀ����ȡ�Ծ���Ϣ");
	String[] ty0 =cxshiti1[0].split(" ");//���ַ�����ԭ������������,�ַ�����ÿһ���Կո����
	String[] ty1 =cxshiti1[1].split(" ");
	String[] ty2 =cxshiti1[2].split(" ");
	String[] ty3 =cxshiti1[3].split(" ");
	String[] ty4 =cxshiti1[4].split(" ");
	String[] ty5 =cxshiti1[5].split(" ");
	
	
	//�ڸ������͵�������ж�����Ӧ����
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
		//ʵ��ͼƬ������ͬһ����л��������ʾ
	long start=System.currentTimeMillis();
	System.out.println("�Ծ�鿴����ʼ��ʱ");
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
		long end=System.currentTimeMillis()-start;
		System.out.println("�Ծ�鿴ʱ�䣺"+end);
		}
		catch(Exception e){e.printStackTrace(System.out);//�Ծ���ʾ���
		}  
	}
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JTextPane jEditorPane1;
	private javax.swing.JScrollPane jScrollPane1;

}