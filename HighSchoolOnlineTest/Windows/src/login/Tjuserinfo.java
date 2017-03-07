
package login;

import javax.swing.JOptionPane;
/** 管理员添加用户面板 */
public class Tjuserinfo extends javax.swing.JFrame {

public Tjuserinfo() {
	initComponents();
	this.setResizable(false); // 不允许用户改变窗口大小
}

private void initComponents() {

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
	jTextFieldmm = new javax.swing.JTextField();
	jScrollPane1 = new javax.swing.JScrollPane();
	jComboBox1 = new javax.swing.JComboBox();
	jComboBox2 = new javax.swing.JComboBox();
	jTextFieldxm = new javax.swing.JTextField();
	jTextFieldid = new javax.swing.JTextField();
	jTextFieldyx = new javax.swing.JTextField();
	jTextFieldbj = new javax.swing.JTextField();
	jButton1 = new javax.swing.JButton();
	jButton2 = new javax.swing.JButton();
	this.setBounds(250, 150, 500, 300);
	setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	setTitle("用户添加");
	jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 18));
	jLabel1.setText("\u6dfb\u52a0\u7528\u6237");

	jLabelsf.setText("\u8eab\u4efd\uff1a");

	jLabelxm.setText("\u7528\u6237\u540d\uff1a");

	jLabelmm.setText("\u5bc6\u7801\uff1a");

	jLabel5.setText("\u59d3\u540d\uff1a");

	jLabelid.setText("\u5b66\u53f7/\u6559\u5de5\u53f7\uff1a");

	jLabelxb.setText("\u6027\u522b\uff1a");

	jLabelyx.setText("\u5E74\u7EA7\uFF1A");

	jLabelbj.setText("\u73ed\u7ea7/\u6388\u8bfe\u73ed\u7ea7\uff1a");
	jTextFieldmm.setText("123456");


	jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
			"管理员", "教师","学生" }));

	jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
			"男", "女" }));

	jButton1.setText("\u786e\u8ba4\u6dfb\u52a0");
	jButton1.addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			try {
				jButton1ActionPerformed(evt);
			} catch (Exception e) {
				// TODO Auto-generated catch block
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

	javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
			getContentPane());
	getContentPane().setLayout(layout);
	layout.setHorizontalGroup(layout
			.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(
					layout.createSequentialGroup()
							.addGap(96, 96, 96)
							.addGroup(
									layout.createParallelGroup(
											javax.swing.GroupLayout.Alignment.LEADING)
											.addComponent(
													jLabel1,
													javax.swing.GroupLayout.PREFERRED_SIZE,
													101,
													javax.swing.GroupLayout.PREFERRED_SIZE)
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
																													jLabelmm)
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
																									javax.swing.GroupLayout.PREFERRED_SIZE)
																							.addPreferredGap(
																									javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																							.addGroup(
																									layout.createParallelGroup(
																											javax.swing.GroupLayout.Alignment.LEADING,
																											false)
																											.addComponent(
																													jTextFieldmm)
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
																					jButton1))
															.addGap(60, 60,
																	60)
															.addGroup(
																	layout.createParallelGroup(
																			javax.swing.GroupLayout.Alignment.LEADING,
																			false)
																			.addComponent(
																					jButton2,
																					javax.swing.GroupLayout.DEFAULT_SIZE,
																					javax.swing.GroupLayout.DEFAULT_SIZE,
																					Short.MAX_VALUE)
																			.addComponent(
																					jLabelid)
																			.addComponent(
																					jLabelxb)
																			.addComponent(
																					jLabel5)
																			.addComponent(
																					jLabelyx)
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
																			.addComponent(
																					jTextFieldbj)
																			.addComponent(
																					jTextFieldyx)
																			.addComponent(
																					jTextFieldid)
																			.addComponent(
																					jTextFieldxm,
																					javax.swing.GroupLayout.DEFAULT_SIZE,
																					84,
																					Short.MAX_VALUE)
																			.addComponent(
																					jComboBox2,
																					0,
																					javax.swing.GroupLayout.DEFAULT_SIZE,
																					Short.MAX_VALUE))))
							.addContainerGap(97, Short.MAX_VALUE)));
	layout.setVerticalGroup(layout
			.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(
					layout.createSequentialGroup()
							.addGroup(
									layout.createParallelGroup(
											javax.swing.GroupLayout.Alignment.LEADING)
											.addGroup(
													layout.createSequentialGroup()
															.addGap(70, 70,
																	70)
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
																													jLabelmm)
																											.addComponent(
																													jTextFieldmm,
																													javax.swing.GroupLayout.PREFERRED_SIZE,
																													javax.swing.GroupLayout.DEFAULT_SIZE,
																													javax.swing.GroupLayout.PREFERRED_SIZE)))
																			.addComponent(
																					jScrollPane1,
																					javax.swing.GroupLayout.PREFERRED_SIZE,
																					javax.swing.GroupLayout.DEFAULT_SIZE,
																					javax.swing.GroupLayout.PREFERRED_SIZE)))
											.addGroup(
													layout.createSequentialGroup()
															.addGap(110,
																	110,
																	110)
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
																					jLabelbj))))
							.addPreferredGap(
									javax.swing.LayoutStyle.ComponentPlacement.RELATED,
									45, Short.MAX_VALUE)
							.addGroup(
									layout.createParallelGroup(
											javax.swing.GroupLayout.Alignment.BASELINE)
											.addComponent(jButton1)
											.addComponent(jButton2))
							.addGap(43, 43, 43)));

	pack();
}
//添加用户
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws Exception {

	int r;
	GetConn gc=new GetConn();
	int User_Identity=jComboBox1.getSelectedIndex();//; 
	String username=jTextFieldyhm.getText();
	String password=jTextFieldmm.getText();
	String Name=jTextFieldxm.getText();
	String id=jTextFieldid.getText();
	int sex=jComboBox2.getSelectedIndex();
	String college=jTextFieldyx.getText();
	String Class=jTextFieldbj.getText();
    String s="男";
	if(sex==0){
		s="男";
	}
	else if (sex==1){
	    s="女";
	}
	//判断输入信息是否合理
	if (username.trim().length() == 0 || password.trim().length() == 0 || id.trim().length() == 0) {  
		JOptionPane.showMessageDialog(Tjuserinfo.this, "用户名，密码，教工号/学号均不能为空",
				"Error!", 1);
		} 
		
	else{
	
	Object[][] User;
	try {
		User = GetData.selectAll();
	} catch (Exception e) {
		User = null;
		e.printStackTrace();
	}

	int i;
		for (i = 0; i < User.length; i++) {
			if (username.equals(User[i][1])) {
				JOptionPane.showMessageDialog(Tjuserinfo.this, "用户名已存在",
						"Error!", 1);
				break;
			}
			else if(id.equals(User[i][4])) {
				JOptionPane.showMessageDialog(Tjuserinfo.this, "该学号/教工号已添加",
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
	r=gc.executeUpdate(str);//添加新用户
	if (r ==1) {

		JOptionPane.showMessageDialog(Tjuserinfo.this, "添加成功!", "欢迎", 1);
		}
	 else {
			JOptionPane.showMessageDialog(Tjuserinfo.this, "添加失败",
					"Error!", 1);
	 }
		}
		

	jTextFieldyhm.setText("");
	jTextFieldmm.setText("123456");
	jTextFieldxm.setText("");
	jTextFieldid.setText("");
	jTextFieldyx.setText("");
	jTextFieldbj.setText("");
}
	}

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
	dispose();//返回
}

private javax.swing.JButton jButton1;
private javax.swing.JButton jButton2;
private javax.swing.JComboBox jComboBox1;
private javax.swing.JComboBox jComboBox2;
private javax.swing.JLabel jLabel1;
private javax.swing.JLabel jLabel5;
private javax.swing.JLabel jLabelbj;
private javax.swing.JLabel jLabelid;
private javax.swing.JLabel jLabelmm;
private javax.swing.JLabel jLabelsf;
private javax.swing.JLabel jLabelxb;
private javax.swing.JLabel jLabelxm;
private javax.swing.JLabel jLabelyx;
private javax.swing.JScrollPane jScrollPane1;
private javax.swing.JTextField jTextFieldbj;
private javax.swing.JTextField jTextFieldid;
private javax.swing.JTextField jTextFieldmm;
private javax.swing.JTextField jTextFieldxm;
private javax.swing.JTextField jTextFieldyhm;
private javax.swing.JTextField jTextFieldyx;
// End of variables declaration//GEN-END:variables

}