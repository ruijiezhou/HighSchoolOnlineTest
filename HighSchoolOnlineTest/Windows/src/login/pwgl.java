package login;

import javax.swing.JOptionPane;
/**密码管理面板*/
public class pwgl extends javax.swing.JFrame {
	public static Object[][] Usercx=null;

	public pwgl() {
		initComponents();
	}

	private void initComponents() {

		jButton1 = new javax.swing.JButton();//定义控件
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
		this.setBounds(250, 150, 500, 300);
		setTitle("\u9AD8\u4E2D\u5316\u5B66\u5728\u7EBF\u8003\u8BD5\u7CFB\u7EDF\u7528\u6237\u5BC6\u7801\u7BA1\u7406");
		try {
			Usercx = GetData.selectAll();
		} catch (Exception e) {
			Usercx = null;
			e.printStackTrace();
		}
		jButton1 = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable(){
			public boolean isCellEditable(int row,int col){
				return false;
			}
		};
		
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		jButton1.setText("\u8fd4\u56de");//按钮及监听器
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		jButton2.setText("学生");
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton5ActionPerformed(evt);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		jButton3.setText("\u7ba1\u7406\u5458");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});
		jButton4.setText("\u6559\u5e08");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});
		jButton5.setText("密码查询");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		//自动生成的面板布局代码
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
																		100,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
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
												.addComponent(jButton2))
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
	//查询用户信息
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		Object[][] User1=new Object[Usercx.length][Usercx[0].length];
			int i,j;
			for (i = 0,j=0; i < Usercx.length; i++) {
			
			if (Usercx[i][0].equals("2")) {//查看学生
			
				User1[j]=Usercx[i];
				j++;
				
			}
			}
			jTable1.setModel(new javax.swing.table.DefaultTableModel(
					User1, new String[] { "身份类型",
							"用户名", "密码", "姓名", "学号/教工号" , "性别" , "年级" ,  "班级/授课班级"  }));
			jScrollPane1.setViewportView(jTable1);
	}

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		Object[][] User1=new Object[Usercx.length][Usercx[0].length];
	
			int i,j;
			for (i = 0,j=0; i < Usercx.length; i++) {
			
			if (Usercx[i][0].equals("1")) {//查教师
			
				User1[j]=Usercx[i];
				j++;
				
			}
			}
			jTable1.setModel(new javax.swing.table.DefaultTableModel(
					User1, new String[] { "身份类型",
							"用户名", "密码", "姓名", "学号/教工号" , "性别" , "年级" ,  "班级/授课班级"  }));
			jScrollPane1.setViewportView(jTable1);
			
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		Object[][] User1=new Object[Usercx.length][Usercx[0].length];
		int i,j;
		for (i = 0,j=0; i < Usercx.length; i++) {	
		if (Usercx[i][0].equals("0")) {	//查看管理员
			User1[j]=Usercx[i];
			j++;		
		}
		}
		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				User1, new String[] { "身份类型",
						"用户名", "密码", "姓名", "学号/教工号" , "性别" , "年级" ,  "班级/授课班级"  }));
		jScrollPane1.setViewportView(jTable1);
		
		
	}
	//查询密码
	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
		int row=jTable1.getSelectedRow();
		String cKey = "1234567890abcdef";
		String password=(String)jTable1.getValueAt(row,2);
		String user=(String)jTable1.getValueAt(row,1);
		aes a=new aes();
		String DeString = a.Decrypt(password.trim(), cKey);//将密文解密之后显示密码明文
		JOptionPane.showMessageDialog(pwgl.this, "用户"+user+"的密码为："+DeString, "密码查询", 1);
		
		
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		dispose();//返回关闭面板
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;

}