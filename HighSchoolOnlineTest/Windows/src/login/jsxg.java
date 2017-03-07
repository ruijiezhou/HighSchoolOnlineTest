package login;

import javax.swing.JOptionPane;

/**
 *
 * @author  教师个人信息修改面板
 */
public class jsxg extends javax.swing.JFrame {
	teachmain tea=new teachmain();
	//新建教师个人信息修改面板
	public jsxg() {
		initComponents();
	}
	//初始化面板
	private void initComponents() {
		this.setBounds(250, 150, 500, 300);//面板位置
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable()
		{
			public boolean isCellEditable(int row,int col){//设置单元格部分可编辑
				if(col==0||(col==1&&(row==0||row==4)))
					return false;
				else return true;
			}
		};
		jButton1 = new javax.swing.JButton();//新建控件
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		

		jButton1.setText("\u786e\u8ba4\u4fee\u6539");//按钮及按钮事件监听器定义
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton1ActionPerformed(evt);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		jButton2.setText("\u8fd4\u56de");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton3.setText("\u5237\u65b0");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton3ActionPerformed(evt);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//面板布局代码,插件自动生成
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
												.addGroup(
														layout.createSequentialGroup()
																.addContainerGap()
																.addComponent(
																		jScrollPane1,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		261,
																		Short.MAX_VALUE))
												.addGroup(
														layout.createSequentialGroup()
																.addContainerGap(
																		187,
																		Short.MAX_VALUE)
																.addComponent(
																		jButton2,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		86,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jButton3,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		78,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		114,
																		Short.MAX_VALUE)
																.addComponent(
																		jButton1)))
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jButton1)
												.addComponent(jButton3))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										324, Short.MAX_VALUE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jButton2)));

		pack();
	}
	/**按钮功能触发事件*/
	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
		Object [][] jiaoshi;//获取教师个人信息
		try {
			jiaoshi = GetData.selectAll();
		} catch (Exception e) {
			jiaoshi = null;
			e.printStackTrace();
		}
		int i;
		Object [][] jiaoshi1=new Object[jiaoshi[0].length][2];
		for (i = 0; i < jiaoshi.length; i++) {
			if (tea.jsyhm.equals(jiaoshi[i][1])) {
				String cKey = "1234567890abcdef";//密码解密后明文显示
				aes a=new aes();
				String pw=(String)jiaoshi[i][2];//将教师个人信息显示在表格中
				String DeString = a.Decrypt(pw.trim(), cKey);
				jiaoshi1[1][1]=(String)jiaoshi[i][1];
				jiaoshi1[3][1]=(String)jiaoshi[i][3];
				jiaoshi1[5][1]=(String)jiaoshi[i][5];
				jiaoshi1[6][1]=(String)jiaoshi[i][6];
				jiaoshi1[7][1]=(String)jiaoshi[i][7];
				jiaoshi1[2][1]=DeString;
				jiaoshi1[4][1]=(String)jiaoshi[i][4];
				jiaoshi1[0][1]="教师";
				jiaoshi1[1][0]="用户名";
				jiaoshi1[3][0]="姓名";
				jiaoshi1[5][0]="性别";
				jiaoshi1[6][0]="年级";
				jiaoshi1[7][0]="授课班级";
				jiaoshi1[2][0]="密码";
				jiaoshi1[4][0]="教工号";
				jiaoshi1[0][0]="身份";
				break;
			}
		}
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("欢迎您，老师"+tea.jsxm);//面板标题
		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				jiaoshi1, new String[] {"  ","  " }));
		jScrollPane1.setViewportView(jTable1);
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		dispose();//返回按键关闭窗口
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
		GetConn gc=new GetConn();//建立数据库连接
		int row;
		Object [][]Userxg=new Object [8][1];
	    for(row=0;row<8;row++){
	    	Userxg[row][0]= jTable1.getValueAt(row,1);//获取table中的所有新值
	    }

		String username=(String)Userxg[1][0];
		String password=(String)Userxg[2][0];
		String Name=(String)Userxg[3][0];
		String id=(String)Userxg[4][0];
		String sex=(String)Userxg[5][0];
		String college=(String)Userxg[6][0];
		String Class=(String)Userxg[7][0];
		String cKey = "1234567890abcdef";
		String enString = aes.Encrypt(password.trim(), cKey);//新密码加密后存储
		String str="update user set username='"+username+"',password='"+enString+"',Name='"+Name+"',sex='"+sex+"',college='"+college+"',Class='"+Class+"'where id='"+id+"'";
	    int result=gc.executeUpdate(str);//更新数据库中对应记录
		
		if (result == 1) {
			JOptionPane.showMessageDialog(jsxg.this, "全部修改成功!", "欢迎", 1);//更新数据成功
			}
		 else 
				JOptionPane.showMessageDialog(jsxg.this, "修改失败",
						"Error!", 1);
		
	}
	private javax.swing.JButton jButton1;//面板上控件定义
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;

}