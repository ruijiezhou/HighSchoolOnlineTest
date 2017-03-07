/*
 * teachmain.java
 *
 * Created on __DATE__, __TIME__
 */

package login;

/**
 *
 * @author  教师主面板
 */
public class teachmain extends javax.swing.JFrame {
	login log=new login();
	public static String jsyhm;
	public static String jsxm;
	public static String jsxb;
	public static String jsyx;
	public static String jsskbj;
	public static String jsid;

	/** Creates new form teachmain */
	public teachmain() {
		initComponents();
		this.setResizable(false); // 不允许用户改变窗口大小
	}

	private void initComponents() {
		jButton1 = new javax.swing.JButton();
		jButtonstkgl = new javax.swing.JButton();
		jButtonsjgl = new javax.swing.JButton();
		jButtonyj = new javax.swing.JButton();
		jButtoncjgl = new javax.swing.JButton();
		jButtonxxxg = new javax.swing.JButton();
		jLabeltitle = new javax.swing.JLabel();
		jLabeljsgrxx = new javax.swing.JLabel();
		jLabeljsyhm = new javax.swing.JLabel();
		jLabeljsxm = new javax.swing.JLabel();
		jLabeljsxb = new javax.swing.JLabel();
		jLabeljsyx = new javax.swing.JLabel();
		jLabeljsskbj = new javax.swing.JLabel();
		
		Object[][] Usert;
		try {
			Usert = GetData.selectAll();
		} catch (Exception e) {
			Usert = null;
			e.printStackTrace();
		}

		int i;
			for (i = 0; i < Usert.length; i++) {
				if (log.inputusername.equals(Usert[i][1])) {
					 jsyhm=(String)Usert[i][1];
					 jsxm=(String)Usert[i][3];
					 jsid=(String)Usert[i][4];
					 jsxb=(String)Usert[i][5];
					 jsyx=(String)Usert[i][6];
					 jsskbj=(String)Usert[i][7];
					break;
				}
			}

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("欢迎您，老师"+log.inputusername);
		this.setBounds(250, 150, 500, 300);
		jButtonstkgl.setText("\u8bd5\u9898\u5e93\u7ba1\u7406");
		jButtonstkgl.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonstkglActionPerformed(evt);
			}
		});

		jButtonsjgl.setText("\u8bd5\u5377\u7ba1\u7406");
		jButtonsjgl.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonsjglActionPerformed(evt);
			}
		});

		jButtonyj.setText("\u9605\u5377");
		jButtonyj.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonyjActionPerformed(evt);
			}
		});

		jButtoncjgl.setText("\u6210\u7ee9\u7ba1\u7406");
		jButtoncjgl.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtoncjglActionPerformed(evt);
			}
		});

		jButtonxxxg.setText("\u4fe1\u606f\u4fee\u6539");
		jButtonxxxg.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonxxxgActionPerformed(evt);
			}
		});

		jLabeltitle.setFont(new java.awt.Font("微软雅黑", 0, 36));
		jLabeltitle.setForeground(new java.awt.Color(0, 0, 153));
		jLabeltitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabeltitle
				.setText("\u9AD8\u4E2D\u5316\u5B66\u5728\u7EBF\u8003\u8BD5\u7CFB\u7EDF");

		jLabeljsgrxx.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabeljsgrxx.setText("\u6559\u5e08\u4e2a\u4eba\u4fe1\u606f");

		jLabeljsyhm.setFont(new java.awt.Font("微软雅黑", 0, 14));
		jLabeljsyhm.setText("\u7528\u6237\u540d:"+jsyhm);

		jLabeljsxm.setFont(new java.awt.Font("微软雅黑", 0, 14));
		jLabeljsxm.setText("\u59d3\u540d:"+jsxm);

		jLabeljsxb.setFont(new java.awt.Font("微软雅黑", 0, 14));
		jLabeljsxb.setText("\u6027\u522b:"+jsxb);

		jLabeljsyx.setFont(new java.awt.Font("微软雅黑", 0, 14));
		jLabeljsyx.setText("\u9662\u7cfb:"+jsyx);

		jLabeljsskbj.setFont(new java.awt.Font("微软雅黑", 0, 14));
		jLabeljsskbj.setText("\u6388\u8bfe\u73ed\u7ea7:"+jsskbj);
		
		if(log.choosenum.equals("0")){//区分是否是管理员转到教师
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
				.addComponent(jLabeltitle,
						javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE, 672,
						Short.MAX_VALUE)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(365, Short.MAX_VALUE)
								.addComponent(jLabeljsgrxx)
								.addGap(199, 199, 199))
				.addGroup(
						layout.createSequentialGroup()
								.addGap(102, 102, 102)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING,
												false)
												.addComponent(
														jButton1,
														javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														jButtonxxxg,
														javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														jButtoncjgl,
														javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														jButtonyj,
														javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														jButtonsjgl,
														javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														jButtonstkgl,
														javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE))
								.addGap(150, 150, 150)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabeljsyhm)
												.addComponent(jLabeljsxm)
												.addComponent(jLabeljsxb)
												.addComponent(jLabeljsyx)
												.addComponent(jLabeljsskbj))
								.addContainerGap(271, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addGap(27, 27, 27)
								.addComponent(jLabeltitle,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										43, Short.MAX_VALUE)
								.addGap(18, 18, 18)
								.addComponent(jLabeljsgrxx)
								.addGap(17, 17, 17)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jButtonxxxg)
												.addComponent(jLabeljsyhm))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jButtonstkgl)
												.addComponent(jLabeljsxm))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jButtonsjgl)
												.addComponent(jLabeljsxb))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jButtonyj)
												.addComponent(jLabeljsyx))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jButtoncjgl)
												.addComponent(jLabeljsskbj))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jButton1).addGap(42, 42, 42)));

		pack();
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//注销登录
		if(log.choosenum.equals("0")){
			dispose();//若是管理员,关闭窗口,回到管理员窗口
		}
		else{
		login log =new login();
		log.setVisible(true);
		dispose();//返回,关闭窗口
		}
	}

	private void jButtoncjglActionPerformed(java.awt.event.ActionEvent evt) {
		cjgl y=new cjgl();//成绩管理
		y.setVisible(true);
	}

	private void jButtonyjActionPerformed(java.awt.event.ActionEvent evt) {
		yuejuan y=new yuejuan();//阅卷
		y.setVisible(true);
	}

	private void jButtonstkglActionPerformed(java.awt.event.ActionEvent evt) {
		stgl OperateQuestion = new stgl();//试题库管理
		OperateQuestion.setVisible(true);
	}

	private void jButtonxxxgActionPerformed(java.awt.event.ActionEvent evt) {
		jsxg xg = new jsxg();//教师信息修改
		xg.setVisible(true);
	}

	private void jButtonsjglActionPerformed(java.awt.event.ActionEvent evt) {
		shitiguanli xg1 = new shitiguanli();//组卷和试卷管理
		xg1.setVisible(true);
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButtoncjgl;
	private javax.swing.JButton jButtonsjgl;
	private javax.swing.JButton jButtonstkgl;
	private javax.swing.JButton jButtonxxxg;
	private javax.swing.JButton jButtonyj;
	private javax.swing.JLabel jLabeljsgrxx;
	private javax.swing.JLabel jLabeljsskbj;
	private javax.swing.JLabel jLabeljsxb;
	private javax.swing.JLabel jLabeljsxm;
	private javax.swing.JLabel jLabeljsyhm;
	private javax.swing.JLabel jLabeljsyx;
	private javax.swing.JLabel jLabeltitle;

}