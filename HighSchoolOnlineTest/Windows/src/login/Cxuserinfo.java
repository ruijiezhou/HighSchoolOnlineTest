package login;

public class Cxuserinfo extends javax.swing.JFrame {
	public static Object[][] Usercx=null;

	/** 创建管理员查看用户信息的面板 */
	public Cxuserinfo() {
		initComponents();
	}
	//面板初始化
	private void initComponents() {
		jButton1 = new javax.swing.JButton();//创建控件
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
		this.setBounds(250, 150, 500, 300);//面板位置
		setTitle("\u9AD8\u4E2D\u5316\u5B66\u5728\u7EBF\u8003\u8BD5\u7CFB\u7EDF\u7528\u6237\u4FE1\u606F");//面板标题
		jButton1 = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable(){//设置表格部分可编辑
			public boolean isCellEditable(int row,int col){
				return false;
			}
		};
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		jButton1.setText("\u8fd4\u56de");//按钮及其事件监听器
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		
		jButton2.setText("\u6240\u6709");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
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

		jButton5.setText("\u5b66\u751f");
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});
		//面板各个控件的布局代码
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
	/**各个按钮对应的事件*/
	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
		Object[][] User1=new Object[Usercx.length][Usercx[0].length];
			int i,j;
			for (i = 0,j=0; i < Usercx.length; i++) {
			
			if (Usercx[i][0].equals("2")) {//查询所有学生
			
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
			
			if (Usercx[i][0].equals("1")) {//查询所有教师
			
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
		try {//读取所有用户信息
			Usercx = GetData.selectAll();
			System.out.println("got");
		} catch (Exception e) {
			Usercx = null;
			e.printStackTrace();
		}
		Object[][] User1=new Object[Usercx.length][Usercx[0].length];
		int i,j;
		System.out.println(Usercx[0][0]);
		System.out.println(Usercx.length);
		
		for (i = 0,j=0; i < Usercx.length; i++) {	
			if (Usercx[i][0].equals("0")) {//查询所有管理员
			
				User1[j]=Usercx[i];
				j++;
				
			}
		}
		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				User1, new String[] { "身份类型",
						"用户名", "密码", "姓名", "学号/教工号" , "性别" , "年级" ,  "班级/授课班级"  }));
		jScrollPane1.setViewportView(jTable1);
		
		
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		try {//读取所有用户信息
			Usercx = GetData.selectAll();
		} catch (Exception e) {
			Usercx = null;
			e.printStackTrace();
		}
		jTable1.setModel(new javax.swing.table.DefaultTableModel(//所有用户
				Usercx, new String[] { "身份类型",
						"用户名", "密码", "姓名", "学号/教工号" , "性别" , "年级" ,  "班级/授课班级"  }));
		jScrollPane1.setViewportView(jTable1);
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//返回
		dispose();
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	// End of variables declaration//GEN-END:variables

}