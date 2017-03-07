/*
 * xscj.java
 *
 * Created on __DATE__, __TIME__
 */

package login;

/**
 *
 * @author  学生成绩查询,可查询学生历次考试的信息
 */
public class xscj extends javax.swing.JFrame {

	/** Creates new form xscj */
	public xscj() {
		initComponents();
	}

	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable()
		{
			public boolean isCellEditable(int row,int col){
					return false;
			}
		};
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("\u9AD8\u4E2D\u5316\u5B66\u5728\u7EBF\u8003\u8BD5\u6210\u7EE9\u67E5\u8BE2");
		this.setBounds(250, 150, 500, 300);
		jButton1.setText("\u67e5\u8be2");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
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
				.addComponent(jScrollPane1,
						javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE, 464,
						Short.MAX_VALUE)
				.addGroup(
						layout.createSequentialGroup()
								.addComponent(jButton1)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jButton2).addGap(314, 314, 314)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jButton1)
												.addComponent(jButton2))
								.addGap(4, 4, 4)
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										340,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));

		pack();
	}
	//查询
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		 Object[][] shiti1;
	    	try {
				shiti1 = OperateQuestion.selectAllshijuan();
			} catch (Exception e) {
				shiti1 = null;
				e.printStackTrace();
			}
			int count=0;
			String  []sjbh=new String[shiti1.length];
			Object[][]xuesheng=new Object[shiti1.length][3];
		for(int ii=0;ii<shiti1.length;ii++){
			sjbh[ii]=(String) shiti1[ii][0];		
		Object[][][] cj = new Object [shiti1.length] [][];//从所有的考试信息表中分别查找该学生的信息,将该考生的成绩信息读出在一个表中显示
    	try {
			cj[ii] = OperateQuestion.selectAlldajuan("sj"+sjbh[ii]);
		} catch (Exception e) {
			cj[ii] = null;
			e.printStackTrace();
		}
		if(cj[ii] != null){
			int i;
			for (i = 1; i < cj[ii].length; i++) {
				if(cj[ii][i][0].equals(stumain.stuid)){
					xuesheng[count][0]=sjbh[ii];
					xuesheng[count][1]=cj[ii][i][5];
					xuesheng[count][2]=cj[ii][i][3];
					count++;
				}
				}
		}
		}
		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				xuesheng, new String[] { "考试时间",
							 "客观题得分", "总成绩" }));
			jScrollPane1.setViewportView(jTable1);
		
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		dispose();//返回
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;

}