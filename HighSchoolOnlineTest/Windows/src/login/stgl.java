/*
 * stgl.java
 *
 * Created on __DATE__, __TIME__
 */

package login;

import java.sql.SQLException;
import java.util.*;

import javax.swing.table.AbstractTableModel;
import javax.swing.*;

/**
 *
 * @author 试题库管理面板实现试题的添加删除修改
 */
public class stgl extends javax.swing.JFrame {
public static String ids;
public static String timu;
public static int type;
private static byte[] byteimage;
	public stgl() {
		initComponents();
	}

	private void initComponents() {//初始化面板
		this.setBounds(250, 150, 500, 300);
		jTabbedPane1 = new javax.swing.JTabbedPane();
		jPanel2 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable()
		{
			public boolean isCellEditable(int row,int col){
				if(col==0||col==4||col==1)
					return false;
				else return true;
			}
		};
		jComboBoxnd0 = new javax.swing.JComboBox();
		jComboBox1g = new javax.swing.JComboBox();
		jComboBoxtx0 = new javax.swing.JComboBox();
		jComboBoxzj0 = new javax.swing.JComboBox();
		jButtonfh1 = new javax.swing.JButton();
		jButtontp = new javax.swing.JButton();
		
		jPanel3 = new javax.swing.JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTable2 = new javax.swing.JTable()
		{
			public boolean isCellEditable(int row,int col){
				return false;
			}
		};
		jComboBoxnd = new javax.swing.JComboBox();
		jComboBoxtx = new javax.swing.JComboBox();
		jButtonqrxg = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jComboBoxzj = new javax.swing.JComboBox();
		jButtonfh2 = new javax.swing.JButton();
		jButtocx = new javax.swing.JButton();
		jButtonsc = new javax.swing.JButton();
		jButtonscsy = new javax.swing.JButton();
		jPanel4 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		jComboBoxtjzj1 = new javax.swing.JComboBox();
		jLabel3 = new javax.swing.JLabel();
		jComboBoxtjtx = new javax.swing.JComboBox();
		jLabel4 = new javax.swing.JLabel();
		jComboBoxtjnd = new javax.swing.JComboBox();
		jLabel5 = new javax.swing.JLabel();
		jScrollPane3 = new javax.swing.JScrollPane();
		jTextAreatm = new javax.swing.JTextArea();
		jLabel6 = new javax.swing.JLabel();
		jScrollPane4 = new javax.swing.JScrollPane();
		jTextAreada = new javax.swing.JTextArea();
		jLabel7 = new javax.swing.JLabel();
		jScrollPane5 = new javax.swing.JScrollPane();
		jTextAreabz = new javax.swing.JTextArea();
		jLabel8g = new javax.swing.JLabel();
		jScrollPane6 = new javax.swing.JScrollPane();
		jTextPane1 = new javax.swing.JTextPane();
		jLabel9 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jButtonqrtj = new javax.swing.JButton();
        jButtonxzsx = new javax.swing.JButton();
        jButtonqrxg.setVisible(false);
        
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("试题库管理");


		jComboBoxnd0.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "所有",  "简单", "一般","较难" }));


		jComboBoxtx0.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "判断题", "选择题", "填空题", "简答题", "计算题", "操作题" }));

		jComboBoxzj0.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "所有", "第一章", "第二章", "第三章", "第四章", "第五章", "第六章", "第七章", "第八章","第九章" }));
		jButtonfh1.setText("\u8fd4\u56de");
		jButtonfh1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonfh1ActionPerformed(evt);
			}
		});

		jButtonqrxg.setText("修改属性");
		jButtonqrxg.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonqrxgActionPerformed(evt);
			}
		});

		jButtonxzsx.setText("修改题目");
		jButtonxzsx.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonxzsxActionPerformed(evt);
			}
		});

		jButton2.setText("\u67E5\u8BE2\u9898\u76EE");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		//面板布局代码
		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout
				.setHorizontalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												739, Short.MAX_VALUE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								jComboBoxtx0,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jComboBoxzj0,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								jComboBoxnd0,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						))
														.addComponent(
																jButtonxzsx)
														.addComponent(
																jButtonqrxg)
														.addComponent(
																jButtonfh1)
														.addComponent(jButton2))
										.addContainerGap()));
		jPanel2Layout
				.setVerticalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jComboBoxnd0,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jComboBoxtx0,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(27, 27, 27)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														
														.addComponent(
																jComboBoxzj0,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(78, 78, 78)
										.addComponent(jButton2)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(jButtonxzsx)
										.addGap(18, 18, 18)
										.addComponent(jButtonqrxg)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												122, Short.MAX_VALUE)
										.addComponent(jButtonfh1))
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												405, Short.MAX_VALUE)
										.addContainerGap()));

		jTabbedPane1.addTab("\u8bd5\u9898\u4fee\u6539", jPanel2);


		jComboBoxnd.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "所有",  "简单", "一般", "较难" }));

		jComboBoxtx.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "判断题", "选择题", "填空题", "简答题", "计算题", "操作题" }));

		

		jComboBoxzj.setModel(new javax.swing.DefaultComboBoxModel(		
				new String[] { "所有", "第一章", "第二章", "第三章", "第四章", "第五章", "第六章", "第七章", "第八章","第九章" }));


		jButtonfh2.setText("\u8fd4\u56de");
		jButtonfh2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonfh2ActionPerformed(evt);
			}
		});

		jButtocx.setText("\u67e5\u8be2");
		jButtocx.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtocxActionPerformed(evt);
			}
		});

		jButtonsc.setText("\u5220\u9664");
		jButtonsc.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonscActionPerformed(evt);
			}
		});

		jButtonscsy.setText("\u5220\u9664\u6240\u6709");
		jButtonscsy.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonscsyActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
				jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout
				.setHorizontalGroup(jPanel3Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel3Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jScrollPane2,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												744, Short.MAX_VALUE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel3Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																jButtonfh2)
														.addGroup(
																jPanel3Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																		.addGroup(
																				jPanel3Layout
																						.createSequentialGroup()
																						.addComponent(
																								jComboBoxtx,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addGap(7,
																								7,
																								7)
																						.addComponent(
																								jComboBoxnd,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				jPanel3Layout
																						.createSequentialGroup()
																						.addComponent(
																								jComboBoxzj,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(
																								javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																						)
																		.addGroup(
																				jPanel3Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																						.addComponent(
																								jButtocx,
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jButtonsc,
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jButtonscsy,
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE))))
										.addContainerGap()));
		jPanel3Layout
				.setVerticalGroup(jPanel3Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel3Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel3Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jComboBoxnd,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jComboBoxtx,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(28, 28, 28)
										.addGroup(
												jPanel3Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jComboBoxzj,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														)
										.addGap(90, 90, 90)
										.addComponent(jButtocx)
										.addGap(18, 18, 18)
										.addComponent(jButtonsc)
										.addGap(18, 18, 18)
										.addComponent(jButtonscsy)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												105, Short.MAX_VALUE)
										.addComponent(jButtonfh2))
						.addGroup(
								jPanel3Layout
										.createSequentialGroup()
										.addComponent(
												jScrollPane2,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												405, Short.MAX_VALUE)
										.addContainerGap()));

		jTabbedPane1.addTab("\u8bd5\u9898\u67e5\u770b\u5220\u9664", jPanel3);

		jLabel2.setFont(new java.awt.Font("微软雅黑", 0, 14));
		jLabel2.setText("\u7ae0\u8282");

		jComboBoxtjzj1.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "第一章", "第二章", "第三章", "第四章", "第五章", "第六章", "第七章", "第八章" ,"第九章"}));

		jLabel3.setFont(new java.awt.Font("微软雅黑", 0, 14));
		jLabel3.setText("\u9898\u578b");

		jComboBoxtjtx.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "判断题", "选择题", "填空题", "简答题", "计算题", "操作题" }));

		jLabel4.setFont(new java.awt.Font("微软雅黑", 0, 14));
		jLabel4.setText("\u96be\u5ea6");

		jComboBoxtjnd.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] {  "简单", "一般", "较难" }));

		jLabel5.setFont(new java.awt.Font("微软雅黑", 0, 14));
		jLabel5.setText("\u9898\u76ee");

		jTextAreatm.setColumns(20);
		jTextAreatm.setRows(5);
		jScrollPane3.setViewportView(jTextAreatm);

		jLabel6.setFont(new java.awt.Font("微软雅黑", 0, 14));
		jLabel6.setText("\u7b54\u6848");

		jTextAreada.setColumns(20);
		jTextAreada.setRows(5);
		jScrollPane4.setViewportView(jTextAreada);

		jLabel7.setFont(new java.awt.Font("微软雅黑", 0, 14));
		jLabel7.setText("\u5907\u6ce8");
		jLabel8g.setFont(new java.awt.Font("微软雅黑", 0, 14));
		jLabel8g.setText("类型");
		jTextAreabz.setColumns(20);
		jTextAreabz.setRows(5);
		jScrollPane5.setViewportView(jTextAreabz);
		jScrollPane6.setViewportView(jTextPane1);
        
		jComboBox1g.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "考试题",  "练习题"}));
        
        
         
		jLabel8g.setFont(new java.awt.Font("微软雅黑", 0, 14));
	//	jLabel8g.setText("Grade");


		jLabel9.setFont(new java.awt.Font("微软雅黑", 0, 14));
		

		jButton1.setText("\u8fd4\u56de");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		jButtonqrtj.setText("\u786e\u8ba4\u6dfb\u52a0");
		jButtonqrtj.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonqrtjActionPerformed(evt);
			}
		});

		jButtontp.setText("\u6dfb\u52a0\u56fe\u7247");
		jButtontp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtontpActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(
				jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout
				.setHorizontalGroup(jPanel4Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel4Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel4Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel4Layout
																		.createSequentialGroup()
																		.addComponent(
																				jButtonqrtj)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jButton1))
														.addGroup(
																jPanel4Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel4Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								jPanel4Layout
																										.createSequentialGroup()
																										.addGroup(
																												jPanel4Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																jLabel4)
																														.addComponent(
																																jLabel2)
																														.addComponent(
																																jLabel8g)
																														.addComponent(
																																jLabel3))
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addGroup(
																												jPanel4Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																jComboBoxtjtx,
																																0,
																																96,
																																Short.MAX_VALUE)
																														.addGroup(
																																javax.swing.GroupLayout.Alignment.TRAILING,
																																jPanel4Layout
																																		.createSequentialGroup()
																																		.addPreferredGap(
																																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																		.addComponent(
																																				jComboBox1g,
																																				0,
																																				96,
																																				Short.MAX_VALUE))
																														.addComponent(
																																jComboBoxtjzj1,
																																javax.swing.GroupLayout.Alignment.TRAILING,
																																0,
																																96,
																																Short.MAX_VALUE)
																														.addComponent(
																																jComboBoxtjnd,
																																0,
																																96,
																																Short.MAX_VALUE))
																										.addGap(49,
																												49,
																												49))
																						.addGroup(
																								jPanel4Layout
																										.createSequentialGroup()
																										.addComponent(
																												jScrollPane6,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												170,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
																		.addGroup(
																				jPanel4Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addGroup(
																								jPanel4Layout
																										.createSequentialGroup()
																										.addComponent(
																												jLabel5)
																										.addGap(4,
																												4,
																												4))
																						.addComponent(
																								jLabel6)))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																jPanel4Layout
																		.createSequentialGroup()
																		.addComponent(
																				jButtontp)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				101,
																				Short.MAX_VALUE)
																		.addComponent(
																				jLabel7)))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel4Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																jScrollPane4,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																673,
																Short.MAX_VALUE)
														.addComponent(
																jScrollPane5,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																673,
																Short.MAX_VALUE)
														.addComponent(
																jScrollPane3,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																673,
																Short.MAX_VALUE))
										.addContainerGap()));
		jPanel4Layout
				.setVerticalGroup(jPanel4Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel4Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel4Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel4Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel4Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								jPanel4Layout
																										.createSequentialGroup()
																										.addComponent(
																												jScrollPane3,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												237,
																												Short.MAX_VALUE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addGroup(
																												jPanel4Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																jLabel6)
																														.addComponent(
																																jScrollPane4,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																98,
																																javax.swing.GroupLayout.PREFERRED_SIZE))
																										.addGap(8,
																												8,
																												8))
																						.addGroup(
																								jPanel4Layout
																										.createSequentialGroup()
																										.addGroup(
																												jPanel4Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.BASELINE)
																														.addComponent(
																																jLabel3)
																														.addComponent(
																																jLabel5)
																														.addComponent(
																																jComboBoxtjtx,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.PREFERRED_SIZE))
																										.addGap(28,
																												28,
																												28)
																										.addGroup(
																												jPanel4Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.BASELINE)
																														.addComponent(
																																jLabel4)
																														.addComponent(
																																jComboBoxtjnd,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.PREFERRED_SIZE))
																										.addGap(27,
																												27,
																												27)
																										.addGroup(
																												jPanel4Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.BASELINE)
																														.addComponent(
																																jLabel2)
																														.addComponent(
																																jComboBoxtjzj1,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.PREFERRED_SIZE))
																										.addGap(27,
																												27,
																												27)
																										.addGroup(
																												jPanel4Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.BASELINE)
																														.addComponent(
																																jLabel8g)
																														.addComponent(
																																jComboBox1g,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.PREFERRED_SIZE))
																										.addGap(18,
																												18,
																												18)
																										.addComponent(
																												jScrollPane6,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												151,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
																		.addGroup(
																				jPanel4Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabel7)
																						.addGroup(
																								jPanel4Layout
																										.createSequentialGroup()
																										.addGap(32,
																												32,
																												32)
																										.addGroup(
																												jPanel4Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.BASELINE)
																														.addComponent(
																																jButtonqrtj)
																														.addComponent(
																																jButton1)))
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								jPanel4Layout
																										.createSequentialGroup()
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jScrollPane5,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												65,
																												javax.swing.GroupLayout.PREFERRED_SIZE)))
																		.addContainerGap())
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																jPanel4Layout
																		.createSequentialGroup()
																		.addComponent(
																				jButtontp)
																		.addGap(55,
																				55,
																				55)))));

		jTabbedPane1.addTab("\u8bd5\u9898\u6dfb\u52a0", jPanel4);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 917,
				Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 475,
				Short.MAX_VALUE));

		pack();
	}
	//添加试题
	private void jButtonqrtjActionPerformed(java.awt.event.ActionEvent evt) {
		OperateQuestion OperateQuestion=new OperateQuestion();
		Calendar date=new GregorianCalendar();
		int year=date.get(Calendar.YEAR);
		int month=date.get(Calendar.MONTH);
		month=month+1;
		int day=date.get(Calendar.DAY_OF_MONTH);
		int hour=date.get(Calendar.HOUR);
		int minute=date.get(Calendar.MINUTE);
		int second=date.get(Calendar.SECOND);		
		new String();//以时间作为试题编号
		String id=String.valueOf(year)+String.valueOf(month)+String.valueOf(day)
						+String.valueOf(hour)+String.valueOf(minute)+String.valueOf(second);	
		String content=jTextAreatm.getText();//试题内容
		String answer=jTextAreada.getText();//试题答案
		String note=jTextAreabz.getText();	//试题备注
		int type=jComboBoxtjtx.getSelectedIndex();//题型
		int difficult=jComboBoxtjnd.getSelectedIndex();//难度
		int chapter=jComboBoxtjzj1.getSelectedIndex();//章节
        int grade=type;       
		int i=OperateQuestion.Add(type,id,grade,difficult,chapter,content,answer,note);//试题文本和试题属性写入试题库
		System.out.println("还没有开始下次连接");
		if (i ==1) {
  		IOImage ii=new IOImage();
		try {//图片转换成二进制流写入试题库
			ii.blobInsert(byteimage, id, type);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		jTextPane1.setText("");
		byteimage=null;
		System.out.println("还没有开始下次连接");
			JOptionPane.showMessageDialog(stgl.this, "添加成功!", "欢迎", 1);
			}
		 else {
			JOptionPane.showMessageDialog(stgl.this, "添加失败","Error!", 1);
		 }
		
	}

		private void jButtonfh1ActionPerformed(java.awt.event.ActionEvent evt) {
			dispose();//每个选项卡上的返回
		}
	
		private void jButtonfh2ActionPerformed(java.awt.event.ActionEvent evt) {
			dispose();
		}
		private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
			dispose();
		}
		//添加图片
		private void jButtontpActionPerformed(java.awt.event.ActionEvent evt) {
		Binary b=new Binary();
		JFileChooser jfc = new JFileChooser();
		if(jfc.showOpenDialog(stgl.this)==JFileChooser.APPROVE_OPTION ){//弹出目录选择图片
			String imageaddress=jfc.getSelectedFile().getAbsolutePath();
			byteimage=b.ImagetoByte(imageaddress);	//转成二进制流
			ImageIcon imageicon=new ImageIcon(imageaddress);
			ImageIcon img1=b.zoom(imageicon,200,200);//改变尺寸
			jTextPane1.insertIcon(img1);//预览图片	
		}	
	}
	//删除面板上显示所有试题
	private void jButtonscsyActionPerformed(java.awt.event.ActionEvent evt) {
		int r=0,k=0;
		int type=jComboBoxtx.getSelectedIndex();
		GetConn gc=new GetConn();//建立连接
		int rows=jTable2.getRowCount();
		for(int i=0;i<rows;i++){
		String id1=(String) jTable2.getValueAt(i,0);//依次读取Table中的所有试题的ID
		if(id1!=null){
	    r+=gc.executeUpdate("delete from questionbank"+type+" where ID="+id1);//对试题库执行删除语句
		k++;
		}
		}			
			if (r == k) {
				JOptionPane.showMessageDialog(stgl.this, "全部删除成功!", "欢迎", 1);
				}
			 else 
					JOptionPane.showMessageDialog(stgl.this, "删除失败",
							"Error!", 1);
	}
	//删除试题
	private void jButtonscActionPerformed(java.awt.event.ActionEvent evt) {
		int type=jComboBoxtx.getSelectedIndex();
		GetConn gc=new GetConn();//建立连接
		int row=jTable2.getSelectedRow();//读取选定的行号
		String id1=(String) jTable2.getValueAt(row,0);//找到选定题目的ID
		int r;
		r=gc.executeUpdate("delete from questionbank"+type+" where ID="+id1);//删除
			
			if (r ==1) {

				JOptionPane.showMessageDialog(stgl.this, "删除成功!", "欢迎", 1);
				}
			 else 
					JOptionPane.showMessageDialog(stgl.this, "删除失败",
							"Error!", 1);
		
	}
	//跟据下拉框输入的参数查询试题
	private void jButtocxActionPerformed(java.awt.event.ActionEvent evt) {
		int type=jComboBoxtx.getSelectedIndex();//题型
		int difficult=jComboBoxnd.getSelectedIndex();//难度
		int chapter=jComboBoxzj.getSelectedIndex();//章节
        String c = Integer.toString(chapter-1);
        String d = Integer.toString(difficult-1);
         Object[][] shiti;
    	try {
			shiti = OperateQuestion.selectAllQuestion(type);
		} catch (Exception e) {
			shiti = null;
			e.printStackTrace();
		}
		if (shiti[0][0]==null) {
			JOptionPane.showMessageDialog(stgl.this, "没有找到对应属性的题目",
						"Error!", 1);
		}
		else{
         Object[][] cxshiti=new Object[shiti.length][shiti[0].length];
			int i,j;
			if(difficult==0){
				if(chapter==0){
					
						cxshiti=shiti;
				}
					
				else{
						for (i = 0,j=0; i < shiti.length; i++) {
							if (shiti[i][3].equals(c)) {
								cxshiti[j]=shiti[i];
								j++;	
							}
						}
				}
			}
			else {
				if(chapter==0){
					
						for (i = 0,j=0; i < shiti.length; i++) {
							if (shiti[i][2].equals(d)) {
								cxshiti[j]=shiti[i];
								j++;	
							}
						}
					}
				
				else{	
					for (i = 0,j=0; i < shiti.length; i++) {
						if (shiti[i][3].equals(c)&&shiti[i][2].equals(d)) {
							cxshiti[j]=shiti[i];
							j++;	
						}
					}
				}
				
			}
			
			jTable2.setModel(new javax.swing.table.DefaultTableModel(
					cxshiti, new String[] { "试题编号",
							"题型", "难度", "章节", "题目" , "答案" , "备注" }));
			jScrollPane2.setViewportView(jTable2);
        
		}
		
	}
	//查找题目
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		int type=jComboBoxtx0.getSelectedIndex();
		int difficult=jComboBoxnd0.getSelectedIndex();
		int chapter=jComboBoxzj0.getSelectedIndex();
        String c1 = Integer.toString(chapter-1);
        String d1 = Integer.toString(difficult-1);
         Object[][] shiti1;
    	try {
			shiti1 = OperateQuestion.selectAllQuestion(type);
		} catch (Exception e) {
			shiti1 = null;
			e.printStackTrace();
		}
		if (shiti1[0][0]==null) {
			JOptionPane.showMessageDialog(stgl.this, "没有找到对应属性的题目",
						"Error!", 1);
		}
		else{
			Object[][] cxshiti1=new Object[shiti1.length][shiti1[0].length];
			int i,j;
			if(difficult==0)  //选择所有章节、难度的试题
			{
				if(chapter==0)
				{
					
						cxshiti1=shiti1;
				}
					
				else
				{
						for (i = 0,j=0; i < shiti1.length; i++) 
						{
							if (shiti1[i][3].equals(c1)) 
							{
								cxshiti1[j]=shiti1[i];
								j++;	
							}
						}
				}
			}
			else {
				if(chapter==0){
					
						for (i = 0,j=0; i < shiti1.length; i++) {
							if (shiti1[i][2].equals(d1)) {
								cxshiti1[j]=shiti1[i];
								j++;	
							}
						}
					}
				
				else{	
					for (i = 0,j=0; i < shiti1.length; i++) {
						if (shiti1[i][3].equals(c1)&&shiti1[i][2].equals(d1)) {
							cxshiti1[j]=shiti1[i];
							j++;	
						}
					}
				}
				
			}
	
			jTable1.setModel(new javax.swing.table.DefaultTableModel(
					cxshiti1, new String[] { "试题编号",
							"题型", "难度", "章节", "题目" , "答案" , "备注" }));
			jScrollPane1.setViewportView(jTable1);
		}
        
	}
	//修改试题内容
    private void jButtonxzsxActionPerformed(java.awt.event.ActionEvent evt) {
		int row=jTable1.getSelectedRow();
		int type=jComboBoxtx0.getSelectedIndex();
	    timu=(String)jTable1.getValueAt(row,4);//获取选定题目的ID
	    ids=(String)jTable1.getValueAt(row,0);
	    timuxg tmxg = new timuxg();//打开修改题目内容的面板
		tmxg.setVisible(true);
    }
    
    //修改试题属性
	private void jButtonqrxgActionPerformed(java.awt.event.ActionEvent evt) {
		int type=jComboBoxtx0.getSelectedIndex();
		GetConn gc=new GetConn();
		Object[][] shitixg;
		try {
			shitixg = OperateQuestion.selectAllQuestion(type);
		} catch (Exception e) {
			shitixg = null;
			e.printStackTrace();
		}		
		Object[][] shitiall=new Object[shitixg.length][shitixg[0].length-1];
		int row,column;
	    for(row=0;row<shitixg.length;row++){
	    	for(column=0;column<(shitixg[0].length-1);column++){
	    		shitiall[row][column]= jTable1.getValueAt(row,column);   
	    	}
	    }	    
		int result=0;
		int count=0;
		for(int i=0;i<shitixg.length;i++){
		String ID=(String)shitixg[i][0];//; 
		String image=(String)shitiall[i][1];
		String difficult=(String)shitiall[i][2];
		String chapter=(String)shitiall[i][3];
		String content=(String)shitiall[i][4];
		String answer=(String)shitiall[i][5];
		String note=(String)shitiall[i][6];
		String str="update questionbank"+type+" set image='"+image+"',difficult='"+difficult+"',chapter='"+chapter+"',content='"+content+"',answer='"+answer+"',note='"+note+"'where ID='"+ID+"'";
	    result+=gc.executeUpdate(str);
	    count++;
		}	
		if (result == count) {
			JOptionPane.showMessageDialog(stgl.this, "全部修改成功!", "欢迎", 1);
			}
		 else 
				JOptionPane.showMessageDialog(stgl.this, "修改失败",
						"Error!", 1);
	}

	private javax.swing.JButton jButtocx;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButtonfh1;
	private javax.swing.JButton jButtonfh2;
	private javax.swing.JButton jButtonqrtj;
	private javax.swing.JButton jButtonqrxg;
	private javax.swing.JButton jButtonsc;
	private javax.swing.JButton jButtonscsy;
	private javax.swing.JButton jButtonxzsx;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtontp;
	private javax.swing.JComboBox jComboBoxnd;
	private javax.swing.JComboBox jComboBoxnd0;
	private javax.swing.JComboBox jComboBoxtjnd;
	private javax.swing.JComboBox jComboBoxtjtx;
	private javax.swing.JComboBox jComboBoxtjzj1;
	private javax.swing.JComboBox jComboBoxtx;
	private javax.swing.JComboBox jComboBoxtx0;
	private javax.swing.JComboBox jComboBoxzj;
	private javax.swing.JComboBox jComboBoxzj0;
	private javax.swing.JComboBox jComboBox1g;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8g;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JScrollPane jScrollPane4;
	private javax.swing.JScrollPane jScrollPane5;
	private javax.swing.JScrollPane jScrollPane6;
	private javax.swing.JTabbedPane jTabbedPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTable jTable2;
	private javax.swing.JTextArea jTextAreabz;
	private javax.swing.JTextArea jTextAreada;
	private javax.swing.JTextArea jTextAreatm;
	private javax.swing.JTextPane jTextPane1;

}