package login;

import javax.swing.JOptionPane;

/**����Ա�޸��û���Ϣ���*/
public class Xguserinfo extends javax.swing.JFrame {
	public static Object[][] Usercx=null;

	public Xguserinfo() {
		initComponents();
	}
	//�޸���Ϣ
	public void xginfo(Object[][] Userxg) throws Exception{
		GetConn gc=new GetConn();//������ݿ�����
		int result = 0;
		for(int i=0;i<Userxg.length;i++){
		int User_Identity=Integer.parseInt((String)(Userxg[i][0]));//��ȡ���е�Ԫ������ֵ 
		String username=(String)Userxg[i][1];
		String password=(String)Userxg[i][2];
		String Name=(String)Userxg[i][3];
		String id=(String)Userxg[i][4];
		String sex=(String)Userxg[i][5];
		String college=(String)Userxg[i][6];
		String Class=(String)Userxg[i][7];
	    String cKey = "1234567890abcdef";
		
		String enString = aes.Encrypt(password.trim(), cKey);
		String str="update user set User_Identity='"+User_Identity+"',username='"+username+"',password='"+enString+"',Name='"+Name+"',sex='"+sex+"',college='"+college+"',Class='"+Class+"'where id='"+id+"'";
	    result=gc.executeUpdate(str);//�������ݿ��Ӧ��¼
		}
		if (result == 1) {

			JOptionPane.showMessageDialog(Xguserinfo.this, "ȫ���޸ĳɹ�!", "��ӭ", 1);
			}
		 else 
				JOptionPane.showMessageDialog(Xguserinfo.this, "�޸�ʧ��",
						"Error!", 1);
	 
	}

	private void initComponents() {

		jButton1 = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
		setTitle("\u9AD8\u4E2D\u5316\u5B66\u5728\u7EBF\u8003\u8BD5\u7CFB\u7EDF\u7528\u6237\u4FE1\u606F\u4FEE\u6539");
		this.setBounds(250, 150, 500, 300);
		jButton1 = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable(){
			public boolean isCellEditable(int row,int col){
				if(col==4)
					return false;
				else return true;
			}
		};

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jButton1.setText("\u8fd4\u56de");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		jButton2.setText("����");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton2ActionPerformed(evt);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		jButton3.setText("����Ա");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton3ActionPerformed(evt);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		jButton4.setText("\u6559\u5e08");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton4ActionPerformed(evt);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		jButton5.setText("\u5b66\u751f");
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton5ActionPerformed(evt);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		jButton6.setText("\u786e\u8ba4\u4fee\u6539");
		jButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton6ActionPerformed(evt);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		jButton7.setText("\u5220\u9664\u7528\u6237");
		jButton7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton7ActionPerformed(evt);
			}
		});

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
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(
														jScrollPane1,
														javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														489, Short.MAX_VALUE)
												.addGroup(
														layout.createSequentialGroup()
																.addContainerGap(
																		432,
																		Short.MAX_VALUE)
																.addComponent(
																		jButton1))
												.addGroup(
														javax.swing.GroupLayout.Alignment.LEADING,
														layout.createSequentialGroup()
																.addComponent(
																		jButton2,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		68,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jButton3)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jButton4,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		68,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jButton5,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		71,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		23,
																		Short.MAX_VALUE)
																.addComponent(
																		jButton7)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jButton6)))
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jButton3)
												.addComponent(jButton5)
												.addComponent(jButton4)
												.addComponent(jButton2)
												.addComponent(jButton6)
												.addComponent(jButton7))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										325, Short.MAX_VALUE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jButton1).addContainerGap()));

		pack();
	}
	//ɾ���û�
	private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
		GetConn gc=new GetConn();//�������ݿ�
		int row=jTable1.getSelectedRow();//����к�
		String id1=(String) jTable1.getValueAt(row,4);//����û�id��
	int r;
			r=gc.executeUpdate("delete from user where id='"+id1+"'");//ɾ�����ݿ��¼
			if (r ==1) {

				JOptionPane.showMessageDialog(Xguserinfo.this, "ɾ���ɹ�!", "��ӭ", 1);
				}
			 else 
					JOptionPane.showMessageDialog(Xguserinfo.this, "ɾ��ʧ��",
							"Error!", 1);
	
	}
	//�鿴�û���Ϣ
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
		Object[][] Userxg;
		try {
			Userxg = GetData.selectAll();
		} catch (Exception e) {
			Userxg = null;
			e.printStackTrace();
		}
		for (int i = 0; i < Userxg.length; i++) {
				String cKey = "1234567890abcdef";;
				aes a=new aes();
				String pw=(String)Userxg[i][2];
				String DeString = a.Decrypt(pw.trim(), cKey);
				Userxg[i][2]=DeString;
				
			}
	
		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				Userxg, new String[] { "�������",
						"�û���", "����", "����", "ѧ��/�̹���" , "�Ա�" , "�꼶" ,  "�༶/�ڿΰ༶"  }));
		jScrollPane1.setViewportView(jTable1);
		
	}
	//ɸѡѧ��
	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
		Object[][] Userxg;
		try {
			Userxg = GetData.selectAll();
		} catch (Exception e) {
			Userxg = null;
			e.printStackTrace();
		}
		
		Object[][] User1=new Object[Userxg.length][Userxg[0].length];
			int i,j;
			for (i = 0,j=0; i < Userxg.length; i++) {
			
			if (Userxg[i][0].equals("2")) {
			
				User1[j]=Userxg[i];
				String cKey = "1234567890abcdef";;
				aes a=new aes();
				String pw=(String)Userxg[i][2];
				String DeString = a.Decrypt(pw.trim(), cKey);
				User1[j][2]=DeString;
				j++;
				
			}
			}
			jTable1.setModel(new javax.swing.table.DefaultTableModel(
					User1, new String[] { "�������",
							"�û���", "����", "����", "ѧ��/�̹���" , "�Ա�" , "�꼶" ,  "�༶/�ڿΰ༶"  }));
			jScrollPane1.setViewportView(jTable1);

	}
	//ɸѡ��ʦ
	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
		Object[][] Userxg;
		try {
			Userxg = GetData.selectAll();
		} catch (Exception e) {
			Userxg = null;
			e.printStackTrace();
		}	
		Object[][] User1=new Object[Userxg.length][Userxg[0].length];
	
			int i,j;
			for (i = 0,j=0; i < Userxg.length; i++) {
			
			if (Userxg[i][0].equals("1")) {
			
				User1[j]=Userxg[i];
				String cKey = "1234567890abcdef";;
				aes a=new aes();
				String pw=(String)Userxg[i][2];
				String DeString = a.Decrypt(pw.trim(), cKey);
				User1[j][2]=DeString;
				j++;			
			}
			}
			jTable1.setModel(new javax.swing.table.DefaultTableModel(
					User1, new String[] { "�������",
							"�û���", "����", "����", "ѧ��/�̹���" , "�Ա�" , "�꼶" ,  "�༶/�ڿΰ༶"  }));
			jScrollPane1.setViewportView(jTable1);
			
	}
	//ɸѡ����Ա
	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
		
		Object[][] Userxg;
		try {
			Userxg = GetData.selectAll();
		} catch (Exception e) {
			Userxg = null;
			e.printStackTrace();
		}
		
		System.out.println(Userxg.length);
		System.out.println(Userxg[0].length);
		Object[][] User1=new Object[Userxg.length][Userxg[0].length];

			int i,j;
			for (i = 0,j=0; i < Userxg.length; i++) {
			
			if (Userxg[i][0].equals("0")) {
			
				User1[j]=Userxg[i];
				String cKey = "1234567890abcdef";;
				aes a=new aes();
				String pw=(String)Userxg[i][2];
				String DeString = a.Decrypt(pw.trim(), cKey);
				User1[j][2]=DeString;
				j++;
				
			}
			}
			jTable1.setModel(new javax.swing.table.DefaultTableModel(
					User1, new String[] { "�������",
							"�û���", "����", "����", "ѧ��/�̹���" , "�Ա�" , "�꼶" ,  "�༶/�ڿΰ༶"  }));
			jScrollPane1.setViewportView(jTable1);
		
	}
	//ֱ������������޸��û���Ϣȷ�ϼ��ɸ���
	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
		Object[][] Userxg;
		try {
			Userxg = GetData.selectAll();
		} catch (Exception e) {
			Userxg = null;
			e.printStackTrace();
		}
		
		Object[][] Userall=new Object[Userxg.length][Userxg[0].length];
		int row,column;
	    for(row=0;row<Userxg.length;row++){
	    	for(column=0;column<Userxg[0].length;column++){
	    		Userall[row][column]= jTable1.getValueAt(row,column);
	    	}
	    }    
	    xginfo(Userall);		
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		dispose();//����
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton6;
	private javax.swing.JButton jButton7;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	// End of variables declaration//GEN-END:variables

}