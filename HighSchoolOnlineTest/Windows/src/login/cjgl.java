package login;

import javax.swing.JOptionPane;

/**
 *
 * @author  教师成绩管理
 */
public class cjgl extends javax.swing.JFrame {

	/**创建教师成绩管理面板 */
	public cjgl() {
		initComponents();
	}
	//面板初始化方法
	private void initComponents() {
		jScrollPane1 = new javax.swing.JScrollPane();//定义控件
		jTable1 = new javax.swing.JTable()
		{
			public boolean isCellEditable(int row,int col){//设置table部分单元格可编辑
					return false;
			}
		};
		jScrollPane2 = new javax.swing.JScrollPane();
		jTable2 = new javax.swing.JTable();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jComboBox1 = new javax.swing.JComboBox();
		jLabel2 = new javax.swing.JLabel();
		jComboBox2 = new javax.swing.JComboBox();
		jButton3 = new javax.swing.JButton();
		this.setBounds(250, 150, 500, 300);//面板位置
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("\u9AD8\u4E2D\u5316\u5B66\u5728\u7EBF\u8003\u8BD5\u7CFB\u7EDF\u6210\u7EE9\u7BA1\u7406");//面板标题
		jButton1.setText("\u8fd4\u56de");//按钮文字和监听器
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		jButton2.setText("\u67e5\u770b\u6210\u7ee9");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		jLabel1.setText("\u67e5\u627e\u8bd5\u5377");
		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {//下拉框选项
				 "所有", "很简单", "简单", "一般", "较难", "很难" }));
		jLabel2.setText("\u67e5\u627e\u5b66\u751f");
		jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"所有"}));
		jButton3.setText("\u5237\u65b0");
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
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										377,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING,
												false)
												.addComponent(jLabel1)
												.addComponent(jLabel2)
												.addComponent(
														jComboBox2,
														0,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														jButton3,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														jComboBox1,
														0,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														jButton1,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(jButton2))
								.addGap(18, 18, 18)
								.addComponent(jScrollPane2,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										228, Short.MAX_VALUE).addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(
														jScrollPane1,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														374, Short.MAX_VALUE)
												.addComponent(
														jScrollPane2,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														374, Short.MAX_VALUE)
												.addGroup(
														javax.swing.GroupLayout.Alignment.LEADING,
														layout.createSequentialGroup()
																.addComponent(
																		jLabel1)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jComboBox1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(
																		jButton3)
																.addGap(12, 12,
																		12)
																.addComponent(
																		jLabel2)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jComboBox2,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(18, 18,
																		18)
																.addComponent(
																		jButton2)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		159,
																		Short.MAX_VALUE)
																.addComponent(
																		jButton1)))
								.addContainerGap()));

		pack();
	}
	/**按钮事件监听器对应功能*/
	//查看试卷表,通过试卷表选定任意试卷查看对应试卷的成绩情况
	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		int difficult=jComboBox1.getSelectedIndex();//根据难度选择试卷
        String d1 = Integer.toString(difficult-1);
        Object[][] shiti1;//读取试卷
    	try {
			shiti1 = OperateQuestion.selectAllshijuan();
		} catch (Exception e) {
			shiti1 = null;
			e.printStackTrace();
		}
		if (shiti1[0][0]==null) {
			JOptionPane.showMessageDialog(cjgl.this, "没有找到对应属性的试卷",
						"Error!", 1);
		}
		else{
         Object[][] cxshiti1=new Object[shiti1.length][shiti1[0].length];
			int i,j;
			if(difficult==0){
				cxshiti1=shiti1;			
				}		
				else{
						for (i = 0,j=0; i < shiti1.length; i++) {
							if (shiti1[i][1].equals(d1)) {
								cxshiti1[j]=shiti1[i];
								j++;	
							}
						}
				}//找到对应属性的试卷在表格中显示
			jTable1.setModel(new javax.swing.table.DefaultTableModel(
					cxshiti1, new String[] { "考试日期",
							"试卷难度", "总分", "是否选定" }));
			jScrollPane1.setViewportView(jTable1);
		}
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		dispose();//返回按键,关闭窗口
	}
	//根据选择的试卷查看对应考试信息表中学生的成绩
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		int stu=jComboBox2.getSelectedIndex();//根据条件筛选需要查看的学生
		int row=jTable1.getSelectedRow();//读取选择的试卷编号
		String id1=(String) jTable1.getValueAt(row,0);
		String id="sj"+id1;
        Object[][] cj;
    	try {
			cj = OperateQuestion.selectAlldajuan(id);//根据试卷名字选出对应试卷
		} catch (Exception e) {
			cj = null;
			e.printStackTrace();
		}
		//根据试卷编号查找对应的考试信息表
         Object[][] cxcj=new Object[cj.length-1][cj[0].length];
			int i,j;
			for (i = 1,j=0; i < cj.length; i++,j++) {
					cxcj[j]=cj[i];
					cxcj[j][2]=cj[i][5];
					cxcj[j][3]=cj[i][3];
				}
			//将学生成绩放在表格中显示
			jTable2.setModel(new javax.swing.table.DefaultTableModel(
				cxcj, new String[] { "学号",
							"姓名", "客观题得分", "总成绩" }));
			jScrollPane2.setViewportView(jTable2);
		}
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JComboBox jComboBox2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTable jTable1;
	private javax.swing.JTable jTable2;

}