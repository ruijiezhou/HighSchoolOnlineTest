/*
 * reg.java
 *
 * Created on __DATE__, __TIME__
 */

package login;

import javax.swing.JOptionPane;
/**用户注册面板*/
public class reg extends javax.swing.JFrame {
	public reg() {
		initComponents();//初始化面板
		this.setResizable(false); // 不允许用户改变窗口大小
	}

	private void initComponents() {
		//定义控件
		jLabel1 = new javax.swing.JLabel();
		jLabelsf = new javax.swing.JLabel();
		jLabelxm = new javax.swing.JLabel();
		jLabelmm = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabelid = new javax.swing.JLabel();
		jLabelxb = new javax.swing.JLabel();
		jLabelyx = new javax.swing.JLabel();
		jLabelbj = new javax.swing.JLabel();
		jTextFieldyhm = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		jComboBox1 = new javax.swing.JComboBox();
		jComboBox2 = new javax.swing.JComboBox();
		jTextFieldxm = new javax.swing.JTextField();
		jTextFieldid = new javax.swing.JTextField();
		jTextFieldyx = new javax.swing.JTextField();
		jTextFieldbj = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jPasswordField1 = new javax.swing.JPasswordField();
		jLabel2 = new javax.swing.JLabel();
		jPasswordField2 = new javax.swing.JPasswordField();
		setTitle("\u9AD8\u4E2D\u5316\u5B66\u5728\u7EBF\u8003\u8BD5\u7CFB\u7EDF\u5B66\u751F\u6CE8\u518C");
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		this.setBounds(250, 150, 500, 300);
		jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel1.setText("\u6ce8\u518c");

		jLabelsf.setText("\u8eab\u4efd\uff1a");

		jLabelxm.setText("\u7528\u6237\u540d\uff1a");

		jLabelmm.setText("\u5bc6\u7801\uff1a");

		jLabel5.setText("\u59d3\u540d\uff1a");

		jLabelid.setText("\u5b66\u53f7");

		jLabelxb.setText("\u6027\u522b\uff1a");

		jLabelyx.setText("\u5E74\u7EA7\uFF1A");

		jLabelbj.setText("\u73ed\u7ea7");

	

		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"学生" }));

		jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"男", "女"}));

		jButton1.setText("\u786e\u8ba4\u6ce8\u518c");//按键与事件监听器
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton1ActionPerformed(evt);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		jButton2.setText("\u8fd4\u56de\u767b\u5f55");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		jLabel2.setText("\u786e\u8ba4\u5bc6\u7801\uff1a");
		//面板布局代码
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(86, 86, 86)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING)
																												.addComponent(
																														jLabelsf)
																												.addComponent(
																														jLabelxm))
																								.addGap(5,
																										5,
																										5)
																								.addComponent(
																										jScrollPane1,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.PREFERRED_SIZE))
																				.addComponent(
																						jLabelmm)
																				.addComponent(
																						jLabel2))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				false)
																				.addComponent(
																						jPasswordField2,
																						0,
																						0,
																						Short.MAX_VALUE)
																				.addComponent(
																						jPasswordField1,
																						0,
																						0,
																						Short.MAX_VALUE)
																				.addComponent(
																						jComboBox1,
																						0,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(
																						jTextFieldyhm,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						89,
																						javax.swing.GroupLayout.PREFERRED_SIZE)))
												.addComponent(
														jLabel1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														101,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jButton1))
								.addGap(99, 99, 99)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING,
												false)
												.addComponent(
														jButton2,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(jLabelid)
												.addComponent(jLabelxb)
												.addComponent(jLabel5)
												.addComponent(jLabelyx)
												.addComponent(
														jLabelbj,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING,
												false)
												.addComponent(jTextFieldbj)
												.addComponent(jTextFieldyx)
												.addComponent(jTextFieldid)
												.addComponent(
														jTextFieldxm,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														84, Short.MAX_VALUE)
												.addComponent(
														jComboBox2,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(123, 123, 123)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(67, 67, 67)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(36, 36,
																		36)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						jLabel5)
																				.addComponent(
																						jTextFieldxm,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						jLabelid)
																				.addComponent(
																						jTextFieldid,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						jLabelxb)
																				.addComponent(
																						jComboBox2,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						jLabelyx)
																				.addComponent(
																						jTextFieldyx,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jTextFieldbj,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jLabelbj)))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jLabel1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		31,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.BASELINE)
																												.addComponent(
																														jLabelsf)
																												.addComponent(
																														jComboBox1,
																														javax.swing.GroupLayout.PREFERRED_SIZE,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														javax.swing.GroupLayout.PREFERRED_SIZE))
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.BASELINE)
																												.addComponent(
																														jLabelxm)
																												.addComponent(
																														jTextFieldyhm,
																														javax.swing.GroupLayout.PREFERRED_SIZE,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														javax.swing.GroupLayout.PREFERRED_SIZE))
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.BASELINE)
																												.addComponent(
																														jPasswordField1,
																														javax.swing.GroupLayout.PREFERRED_SIZE,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														javax.swing.GroupLayout.PREFERRED_SIZE)
																												.addComponent(
																														jLabelmm)))
																				.addComponent(
																						jScrollPane1,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						jLabel2)
																				.addComponent(
																						jPasswordField2,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		51,
																		Short.MAX_VALUE)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						jButton1)
																				.addComponent(
																						jButton2))
																.addGap(76, 76,
																		76)))));

		pack();
	}
	//确认注册按钮事件
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
		int r;
		GetConn gc=new GetConn();
		char[] pw1 = jPasswordField1.getPassword(); // 得到密码
		char[] pw2 = jPasswordField2.getPassword(); // 得到密码
		String inputpassword1 = new String(pw1);
		String inputpassword2 = new String(pw2);
		int User_Identity=2;//; 权限只能是学生
		String username=jTextFieldyhm.getText();//用户名
		String password=inputpassword1;
		String Name=jTextFieldxm.getText();//姓名
		String id=jTextFieldid.getText();//学号
		int sex=jComboBox2.getSelectedIndex();//性别
		String college=jTextFieldyx.getText();
		String Class=jTextFieldbj.getText();
	    String s="男";
		if(sex==0){
			s="男";
		}
		else if (sex==1){
		    s="女";
		}
		if (Name.trim().length() == 0 ||college.trim().length() == 0 ||Class.trim().length() == 0 ||inputpassword2.trim().length() == 0 ||username.trim().length() == 0 || password.trim().length() == 0 || id.trim().length() == 0) {  
			JOptionPane.showMessageDialog(reg.this, "请将信息填写完整","Error!", 1);
			} //检查信息是否完整
		else{
		Object[][] User;
		try {
			User = GetData.selectAll();
		} catch (Exception e) {
			User = null;
			e.printStackTrace();
		}

		int i;
			for (i = 0; i < User.length; i++) {//检查输入的信息是否合理
				if (username.equals(User[i][1])) {
					JOptionPane.showMessageDialog(reg.this, "用户名已存在",
							"Error!", 1);
					break;
				}
				else if(!(inputpassword1.equals(inputpassword2))) {
					JOptionPane.showMessageDialog(reg.this, "两次输入密码不一致",
							"Error!", 1);
					break;
				}
				else if(id.equals(User[i][4])) {
					JOptionPane.showMessageDialog(reg.this, "该学号已添加",
							"Error!", 1);
					break;
				}
			}
			if (i == User.length) {
				String cKey = "1234567890abcdef";
				
				aes a=new aes();
				String enString = aes.Encrypt(password.trim(), cKey);
		String str="insert into user (User_Identity,username,password,Name,id,sex,college,Class)"+
		"values('"+User_Identity+"','"+username+"','"+enString+"','"+Name+"','"+id+"','"+s+"','"+college+"','"+Class+"')";
		r=gc.executeUpdate(str);//新用户写入数据库
		if (r ==1) {

			JOptionPane.showMessageDialog(reg.this, "注册成功!", "欢迎", 1);
			}
		 else {
				JOptionPane.showMessageDialog(reg.this, "注册失败，请重新注册",
						"Error!", 1);
		 }
			}
			
		jTextFieldyhm.setText("");
		jPasswordField1.setText("");
		jTextFieldxm.setText("");
		jTextFieldid.setText("");
		jTextFieldyx.setText("");
		jTextFieldbj.setText("");
        jPasswordField2.setText("");
	}
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		dispose();//返回登陆界面
		login log =new login();
		log.setVisible(true);
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JComboBox jComboBox2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabelbj;
	private javax.swing.JLabel jLabelid;
	private javax.swing.JLabel jLabelmm;
	private javax.swing.JLabel jLabelsf;
	private javax.swing.JLabel jLabelxb;
	private javax.swing.JLabel jLabelxm;
	private javax.swing.JLabel jLabelyx;
	private javax.swing.JPasswordField jPasswordField1;
	private javax.swing.JPasswordField jPasswordField2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextField jTextFieldbj;
	private javax.swing.JTextField jTextFieldid;
	private javax.swing.JTextField jTextFieldxm;
	private javax.swing.JTextField jTextFieldyhm;
	private javax.swing.JTextField jTextFieldyx;

}