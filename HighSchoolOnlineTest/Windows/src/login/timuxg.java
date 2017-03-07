/*
 * timuxg.java
 *
 * Created on __DATE__, __TIME__
 */

package login;

import javax.swing.JOptionPane;

/**
 *
 * @author  教师试题管理修改题目面板
 */
public class timuxg extends javax.swing.JFrame {
public static String timu1;
	public timuxg() {
		initComponents();
	}
	private void initComponents() {

		jButton1 = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jEditorPane1 = new javax.swing.JEditorPane();
		String timuy=stgl.timu;
		jEditorPane1.setText(timuy);
		
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		this.setBounds(250, 150, 500, 300);
		jButton1.setText("\u786e\u8ba4\u4fee\u6539");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jScrollPane1.setViewportView(jEditorPane1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup().addContainerGap()
								.addComponent(jButton1)
								.addContainerGap(307, Short.MAX_VALUE))
				.addComponent(jScrollPane1,
						javax.swing.GroupLayout.DEFAULT_SIZE, 400,
						Short.MAX_VALUE));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jButton1)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										253, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	//修改试题
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		int type1=stgl.type;
		String idy=stgl.ids;
		GetConn gc=new GetConn();
		timu1=jEditorPane1.getText();//获取新文本

		String str="update questionbank"+type1+" set content='"+timu1+"'where ID='"+idy+"'";
		int res=gc.executeUpdate(str);//更新试题
		if (res==1) {
			JOptionPane.showMessageDialog(timuxg.this, "全部修改成功!", "欢迎", 1);			
			dispose();
			}
		 else 
				JOptionPane.showMessageDialog(timuxg.this, "修改失败",
						"Error!", 1);		
	}


	private javax.swing.JButton jButton1;
	private javax.swing.JEditorPane jEditorPane1;
	private javax.swing.JScrollPane jScrollPane1;

}