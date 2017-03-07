/*
 * login.java
 *
 * Created on __DATE__, __TIME__
 */

package login;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

/**
 *
 * @author  用户登录主面板
 */
public class login extends javax.swing.JFrame {
	public static String choosenum = "3";//定义变量区分用户身份
	public static String inputusername;

	/**创建用户登录主界面 */
	public login() {
		initComponents();
		this.setResizable(false); // 不允许用户改变窗口大小
	}
	//初始化面板
	private void initComponents() {
		ImageIcon bg=new ImageIcon("background.jpg");
		JLabel label=new JLabel(bg);
		label.setBounds(0,0,bg.getIconWidth(),bg.getIconHeight());
		this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE)); 
		JPanel jp=(JPanel)this.getContentPane();
		jp.setOpaque(false);
		
		choose = new javax.swing.ButtonGroup();
		admin = new javax.swing.JRadioButton();
		admin.setOpaque(false);
		student = new javax.swing.JRadioButton();
		student.setOpaque(false);
		teacher = new javax.swing.JRadioButton();
		teacher.setOpaque(false);
		jTextFieldname = new javax.swing.JTextField();
		jLabelname = new javax.swing.JLabel();
		jLabelpass = new javax.swing.JLabel();
		jButtonlogin = new javax.swing.JButton();
		jButtonlogin.setFocusPainted(false);
		jPasswordField = new javax.swing.JPasswordField();
		jButtonreg = new javax.swing.JButton();
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);//定义关闭窗口事件
		setTitle("\u9AD8\u4E2D\u5316\u5B66\u5728\u7EBF\u8003\u8BD5\u7CFB\u7EDF");//面板标题
		this.setBounds(250, 150, 500, 300);

		choose.add(admin);//三选一身份单选按钮设定及事件监听
		admin.setFont(new java.awt.Font("宋体", 0, 14));
		admin.setText("\u7ba1\u7406\u5458");
		admin.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				adminActionPerformed(evt);
			}
		});

		choose.add(student);
		student.setFont(new java.awt.Font("宋体", 0, 14));
		student.setText("\u5b66\u751f");
		student.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				studentActionPerformed(evt);
			}
		});

		choose.add(teacher);
		teacher.setFont(new java.awt.Font("宋体", 0, 14));
		teacher.setText("\u6559\u5e08");
		teacher.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				teacherActionPerformed(evt);
			}
		});

		jTextFieldname.setFont(new java.awt.Font("宋体", 0, 18));//其余控件属性
		jLabelname.setFont(new java.awt.Font("微软雅黑", 1, 18));
		jLabelname.setText("\u7528\u6237\u540d\uff1a");

		jLabelpass.setFont(new java.awt.Font("微软雅黑", 1, 18));
		jLabelpass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabelpass.setText("\u5bc6\u7801\uff1a");

		jButtonlogin.setFont(new java.awt.Font("微软雅黑", 1, 14));
		jButtonlogin.setText("\u767b        \u5f55");
		
		jButtonlogin.addActionListener(new java.awt.event.ActionListener() {//登录按键定义与事件监听
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButtonloginActionPerformed(evt);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		jPasswordField.setFont(new java.awt.Font("宋体", 0, 18));//密码输入框
		jButtonreg.setFont(new java.awt.Font("微软雅黑", 1, 14));
		jButtonreg.setText("\u6ce8        \u518c");
		jButtonreg.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonregActionPerformed(evt);
			}
		});
		
		JLabel lblNewLabel = new JLabel("\u9AD8\u4E2D\u5316\u5B66\u5728\u7EBF\u8003\u8BD5\u7CFB\u7EDF\u767B\u5F55");
		lblNewLabel.setFont(new Font("隶书", Font.PLAIN, 50));
		//自动生成的面板布局代码
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addGap(192)
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
									.addGap(25)
									.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(jLabelpass, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabelname, Alignment.LEADING))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(jPasswordField)
										.addComponent(jTextFieldname, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)))
								.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
									.addGroup(layout.createSequentialGroup()
										.addComponent(jButtonreg)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jButtonlogin))
									.addGroup(layout.createSequentialGroup()
										.addComponent(admin)
										.addGap(46)
										.addComponent(teacher)
										.addGap(43)
										.addComponent(student)))))
						.addGroup(layout.createSequentialGroup()
							.addGap(35)
							.addComponent(lblNewLabel)))
					.addContainerGap(41, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(31)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(admin)
						.addComponent(student)
						.addComponent(teacher))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabelname)
						.addComponent(jTextFieldname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabelpass)
						.addComponent(jPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jButtonlogin)
						.addComponent(jButtonreg))
					.addContainerGap(106, Short.MAX_VALUE))
		);
		getContentPane().setLayout(layout);

		pack();
	}
	/**各个事件监听器对应的功能代码*/
	private void jButtonregActionPerformed(java.awt.event.ActionEvent evt) {
		dispose();
		reg regnew = new reg();//用另一个面板创建的对象
		regnew.setVisible(true);//打开注册面板 

	}

	private void studentActionPerformed(java.awt.event.ActionEvent evt) {
		choosenum = "2";//身份选择为学生
	}

	private void teacherActionPerformed(java.awt.event.ActionEvent evt) {
		choosenum = "1";//身份选择为教师
	}

	private void adminActionPerformed(java.awt.event.ActionEvent evt) {
		choosenum = "0";//身份选择为管理员
	}

	private void jButtonloginActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
		char[] pw = jPasswordField.getPassword(); // 得到用户输入的密码
		Object[][] User;
		try {
			User = GetData.selectAll();
		} catch (Exception e) {
			User = null;
			e.printStackTrace();
		}
		inputusername = jTextFieldname.getText();
		String inputpassword = new String(pw);
		String inputidentity = choosenum;	
		String cKey = "1234567890abcdef";	
		aes a=new aes();
		String enString = aes.Encrypt(inputpassword.trim(), cKey);//加密后密文匹配

		jTextFieldname.setText("");//输入栏清空
		jPasswordField.setText("");

		int i;
		if (inputidentity.equals("3")) {//没有选择身份类型
			JOptionPane.showMessageDialog(login.this, "请选择身份类型!", "Error!", 1);
		}
		else {
			for (i = 0; i < User.length; i++) {//与所有用户数据一一比对
				if (inputusername.equals(User[i][1])
						&& enString.equals(User[i][2])
						&& inputidentity.equals(User[i][0])) {
					break;//匹配成功
				}
			}
			if (i < User.length) {//根据身份打开面板

				JOptionPane.showMessageDialog(login.this, "登录成功!", "欢迎", 1);
	 
				dispose();
				if (inputidentity.equals("2")) {
					stumain stu = new stumain();
					stu.setVisible(true);//打开学生面板
				}
				if (inputidentity.equals("1")) {
					teachmain tea = new teachmain();
					tea.setVisible(true);//打开教师面板
				}
				if (inputidentity.equals("0")) {
					adminmain admin = new adminmain();
					admin.setVisible(true);//打开管理员面板
				}

			} else {
				JOptionPane.showMessageDialog(login.this, "用户名或密码输入错误!",
						"Error!", 1);
			}
		}

	}

	/**
	 * @param a主函数,开启主登录面板
	 */
	public static void main(String args[]) {

		MyLookAndFeel.setLookAndFeel(MyLookAndFeel.jtattoo_mcwin);
		Popup pop=new Popup(1);
		
		new GetConn();
		
		//pop.setVisible(false);
		pop.dispose();
		if(GetConn.conn!=null)
			JOptionPane.showMessageDialog(null, "接入网络成功，欢迎您！","欢迎!", 1);
		else if(GetConn.conn==null)
			JOptionPane.showMessageDialog(null, "接入网络失败，请检查网络连接!","Error!", 1);
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new login().setVisible(true);
			}
		});
	}

	private javax.swing.JRadioButton admin;//定义控件
	private javax.swing.ButtonGroup choose;
	private javax.swing.JButton jButtonlogin;
	private javax.swing.JButton jButtonreg;
	private javax.swing.JLabel jLabelname;
	private javax.swing.JLabel jLabelpass;
	private javax.swing.JPasswordField jPasswordField;
	private javax.swing.JTextField jTextFieldname;
	private javax.swing.JRadioButton student;
	private javax.swing.JRadioButton teacher;
}