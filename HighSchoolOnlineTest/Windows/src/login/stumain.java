/*
 * stumain.java
 *
 * Created on __DATE__, __TIME__
 */

package login;

import javax.swing.JOptionPane;

/**
 *
 * @author 学生主面板_
 */
public class stumain extends javax.swing.JFrame {
	public String stuusername;
	public String xuehao;
	public static String stuuser;
	public static String stuname;
	public static String stuid;
	public static String stusex;
	public static String stucollege;
	public static String stuclass;
	login log=new login();
	/** Creates new form stumain */
	public stumain() {
		initComponents();
		this.setResizable(false); // 不允许用户改变窗口大小
	}
	
	private void initComponents() {
		jButton1 = new javax.swing.JButton();
		jButtoninfo = new javax.swing.JButton();
		jButtontrain = new javax.swing.JButton();
		jButtonexam = new javax.swing.JButton();
		jButtonscore = new javax.swing.JButton();
		jLabelinfo = new javax.swing.JLabel();
		jLabeluser = new javax.swing.JLabel();
		jLabelname = new javax.swing.JLabel();
		jLabelstuid = new javax.swing.JLabel();
		jLabelCollege = new javax.swing.JLabel();
		jLabelclass = new javax.swing.JLabel();
		maintitle = new java.awt.Label();
		jLabel1 = new javax.swing.JLabel();
		
		Object[][] User;
		try {
			User = GetData.selectAll();
		} catch (Exception e) {
			User = null;
			e.printStackTrace();
		}

		int i;
			for (i = 0; i < User.length; i++) {
				if (log.inputusername.equals(User[i][1])) {
					 stuuser=(String)User[i][1];
					 stuname=(String)User[i][3];
					 stuid=(String)User[i][4];
					 stusex=(String)User[i][5];
					 stucollege=(String)User[i][6];
					 stuclass=(String)User[i][7];
					 xuehao=stuid;
					break;
				}
			}

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("欢迎您，学生"+log.inputusername);
		this.setBounds(250, 150, 500, 300);
		jButtoninfo.setText("\u4fe1\u606f\u4fee\u6539");
		jButtoninfo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtoninfoActionPerformed(evt);
			}
		});

		jButtontrain.setText("\u5728\u7ebf\u7ec3\u4e60");
		jButtontrain.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtontrainActionPerformed(evt);
			}
		});

		jButtonexam.setText("\u5728\u7ebf\u8003\u8bd5");
		jButtonexam.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonexamActionPerformed(evt);
			}
		});

		jButtonscore.setText("\u6210\u7ee9\u67e5\u8be2");
		jButtonscore.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonscoreActionPerformed(evt);
			}
		});

		jLabelinfo.setFont(new java.awt.Font("宋体", 0, 18));
		jLabelinfo.setText("\u5b66\u751f\u4e2a\u4eba\u4fe1\u606f");

		jLabeluser.setText("用户名："+stuuser);

		jLabelname.setText("姓名："+stuname);

		jLabelstuid.setText("学号："+stuid);

		jLabelCollege.setText("\u5E74\u7EA7\uFF1Anull");

		jLabelclass.setText("班级："+stuclass);

		maintitle.setAlignment(java.awt.Label.CENTER);
		maintitle.setBackground(new java.awt.Color(240, 240, 240));
		maintitle.setFont(new java.awt.Font("宋体", 1, 36));
		maintitle.setForeground(new java.awt.Color(0, 0, 153));
		maintitle.setName("logintitle");
		maintitle.setText("\u9AD8\u4E2D\u5316\u5B66\u5728\u7EBF\u8003\u8BD5\u7CFB\u7EDF");

		jLabel1.setText("性别："+stusex);
		
		if(log.choosenum.equals("0")){//区分是否是管理员转到学生
			jButton1.setText("返回管理员");
		}
		else
		jButton1.setText("\u6ce8\u9500\u767b\u5f55");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
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
								.addContainerGap(396, Short.MAX_VALUE)
								.addComponent(jLabelinfo).addGap(163, 163, 163))
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(maintitle,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										647, Short.MAX_VALUE).addContainerGap())
				.addGroup(
						layout.createSequentialGroup()
								.addGap(75, 75, 75)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING,
												false)
												.addComponent(
														jButton1,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														97, Short.MAX_VALUE)
												.addComponent(
														jButtonscore,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														jButtonexam,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														jButtontrain,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														jButtoninfo,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE))
								.addGap(205, 205, 205)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabelclass)
												.addComponent(jLabelCollege)
												.addComponent(
														jLabeluser,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														146,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabelname)
												.addComponent(jLabelstuid)
												.addComponent(jLabel1))
								.addContainerGap(144, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addComponent(maintitle,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(11, 11, 11)
								.addComponent(jLabelinfo,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										38,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabeluser)
												.addComponent(jButtoninfo))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabelname)
												.addComponent(jButtontrain))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabelstuid)
												.addComponent(jButtonexam))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel1)
												.addComponent(jButtonscore))
								.addGap(10, 10, 10)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(jLabelCollege)
												.addComponent(jButton1))
								.addGap(18, 18, 18).addComponent(jLabelclass)
								.addContainerGap(62, Short.MAX_VALUE)));

		pack();
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// 注销登录
		if(log.choosenum.equals("0")){
			dispose();//若是管理员,关闭窗口,回到管理员窗口
		}
		else{
		login log =new login();
		log.setVisible(true);
		dispose();//学生返回,关闭窗口
		}
	}
    private void jButtoninfoActionPerformed(java.awt.event.ActionEvent evt) {
    	xsxg stu = new xsxg();//用另一个面板创建的对象
		stu.setVisible(true);//打开修改个人信息的面板 
	}
	private void jButtonscoreActionPerformed(java.awt.event.ActionEvent evt) {
	    xscj sj = new xscj();//查看成绩
		sj.setVisible(true);
	}

	private void jButtonexamActionPerformed(java.awt.event.ActionEvent evt) {	
		String[] shijuan;
		try {
			shijuan = OperateQuestion.selectflag();//找到本次考试的指定试卷
		} catch (Exception e) {
			shijuan = null;
			e.printStackTrace();
		}
		String id1=shijuan[0];
		String sjid="sj"+id1;
		 Object[][] cj;
	    	try {
				cj = OperateQuestion.selectAlldajuan(sjid);//根据试卷名字选出对应试卷
			} catch (Exception e) {
				cj = null;
				e.printStackTrace();
			}
			//根据试卷编号查找对应的考试信息
			int i;
				for (i = 0; i < cj.length; i++) {
					String iii=(String)cj[i][0];
					if(iii.equals(stuid)){
						JOptionPane.showMessageDialog(stumain.this, "你已经参加此次考试","Error!", 1);
						break;
					}
					}	
				if(i==cj.length){
	    zxks sj = new zxks();//在线考试
		sj.setVisible(true);}
	}

	private void jButtontrainActionPerformed(java.awt.event.ActionEvent evt) {
	    zxlx sj = new zxlx();//在线练习
		sj.setVisible(true);	
	}
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButtonexam;
	private javax.swing.JButton jButtoninfo;
	private javax.swing.JButton jButtonscore;
	private javax.swing.JButton jButtontrain;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabelCollege;
	private javax.swing.JLabel jLabelclass;
	private javax.swing.JLabel jLabelinfo;
	private javax.swing.JLabel jLabelname;
	private javax.swing.JLabel jLabelstuid;
	private javax.swing.JLabel jLabeluser;
	private java.awt.Label maintitle;
	// End of variables declaration//GEN-END:variables

}