package login;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.ResultSet;
/**
 *
 * @author  试卷管理面板,包括组卷,查看试卷,指定试卷,删除试卷
 */
public class shitiguanli extends javax.swing.JFrame {
	public static String shijuanchakan="试卷\n";
	public static String shijuandaan="参考答案\n";
	public static String idck;
	public shitiguanli() {
		initComponents();
	}

	private void initComponents() {

		jTabbedPane1 = new javax.swing.JTabbedPane();
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jTextFieldzf = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jComboBox1 = new javax.swing.JComboBox();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		jTextField3 = new javax.swing.JTextField();
		jTextField4 = new javax.swing.JTextField();
		jTextField5 = new javax.swing.JTextField();
		jTextField6 = new javax.swing.JTextField();
		jTextField7 = new javax.swing.JTextField();
		jTextField8 = new javax.swing.JTextField();
		jTextField9 = new javax.swing.JTextField();
		jTextField10 = new javax.swing.JTextField();
		jTextField11 = new javax.swing.JTextField();
		jTextField12 = new javax.swing.JTextField();
		jLabel12 = new javax.swing.JLabel();
		jLabel13 = new javax.swing.JLabel();
		jLabel14 = new javax.swing.JLabel();
		jLabel15 = new javax.swing.JLabel();
		jLabel16 = new javax.swing.JLabel();
		jLabel17 = new javax.swing.JLabel();
		jLabel18 = new javax.swing.JLabel();
		jLabel19 = new javax.swing.JLabel();
		jLabel20 = new javax.swing.JLabel();
		jLabel21 = new javax.swing.JLabel();
		jLabel22 = new javax.swing.JLabel();
		jLabel23 = new javax.swing.JLabel();
		jTextField13 = new javax.swing.JTextField();
		jTextField14 = new javax.swing.JTextField();
		jTextField15 = new javax.swing.JTextField();
		jTextField16 = new javax.swing.JTextField();
		jTextField17 = new javax.swing.JTextField();
		jTextField18 = new javax.swing.JTextField();
		jTextField19 = new javax.swing.JTextField();
		jTextField20 = new javax.swing.JTextField();
		jTextField21 = new javax.swing.JTextField();
		jTextFieldsj = new javax.swing.JTextField();
		jButtonqx = new javax.swing.JButton();
		jButtonqr = new javax.swing.JButton();
		jButtonsc = new javax.swing.JButton();
		jButtonfh = new javax.swing.JButton();
		jPanel2 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable(){
			public boolean isCellEditable(int row,int col){
				return false;
			}
		};
		jComboBox2 = new javax.swing.JComboBox();
		jButtoncx = new javax.swing.JButton();
		jButtonck = new javax.swing.JButton();
		jButtonzd = new javax.swing.JButton();
		jButtonfh2 = new javax.swing.JButton();
		setTitle("\u7EC4\u5377\u4E0E\u8BD5\u5377\u7BA1\u7406");
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		this.setBounds(250, 150, 500, 300);
		jLabel1.setText("\u8bd5\u5377\u603b\u5206\uff1a");

		jLabel2.setText("试卷难度：");

		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"很简单", "简单", "一般", "较难" ,"很难"}));

		jLabel3.setText("\u9898\u578b");

		jLabel4.setText("\u5206\u503c");

		jLabel5.setText("\u9898\u6570");

		jLabel6.setText("\u5224\u65ad\u9898");

		jLabel7.setText("\u9009\u62e9\u9898");

		jLabel8.setText("\u586b\u7a7a\u9898");

		jLabel9.setText("\u7b80\u7b54\u9898");

		jLabel10.setText("\u8ba1\u7b97\u9898");

		jLabel11.setText("\u64cd\u4f5c\u9898");

		jLabel12.setText("\u4E13\u9898");

		jLabel13.setText("\u9898\u6570");

		jLabel14.setText("\u4E13\u9898\u4E00 \u7269\u8D28\u7EC4\u6210\u4E0E\u5206\u7C7B");

		jLabel15.setText("\u4E13\u9898\u4E8C \u6C27\u5316\u8FD8\u539F\u53CD\u5E94");

		jLabel16.setText("\u4E13\u9898\u4E09 \u79BB\u5B50\u53CD\u5E94");

		jLabel17.setText("\u4E13\u9898\u56DB \u5FAE\u7C92\u7ED3\u6784\u4E0E\u5316\u5B66\u952E");

		jLabel18.setText("\u4E13\u9898\u4E94 \u5143\u7D20\u5468\u671F\u5F8B");

		jLabel19.setText("\u4E13\u9898\u516D \u5316\u5B66\u5E73\u8861");

		jLabel20.setText("\u4E13\u9898\u4E03 \u7535\u89E3\u8D28\u6EB6\u6DB2");

		jLabel21.setText("\u4E13\u9898\u516B \u5E38\u89C1\u975E\u91D1\u5C5E\u53CA\u5176\u5316\u5408\u7269");

		jLabel22.setText("\u4E13\u9898\u4E5D \u5E38\u89C1\u6709\u673A\u7269\u53CA\u5E94\u7528");

		jButtonqr.setText("\u786e\u8ba4\u7ec4\u5377");
		jButtonqr.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonqrActionPerformed(evt);
			}
		});

		jButtonfh.setText("\u8fd4\u56de");
		jButtonfh.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonfhActionPerformed(evt);
			}
		});
		jTextField7.setText("5");

		

		jTextField8.setText("5");

		
		jTextField9.setText("5");

		
		jTextField10.setText("2");

		jTextField11.setText("2");

		
		jTextField12.setText("2");

		
		jTextFieldzf.setText("100");

		
		jTextField1.setText("10");

		jTextField2.setText("10");

		
		jTextField3.setText("10");

		
		jTextField4.setText("20");

		jTextField5.setText("20");

		jTextField6.setText("30");

		
		jTextField13.setText("2");

		
		jTextField14.setText("2");

		
		jTextField15.setText("2");

		
		jTextField16.setText("2");

		jTextField17.setText("2");

		jTextField18.setText("2");

		
		jTextField19.setText("2");

		jTextField20.setText("2");

		
		jTextField21.setText("5");

		jLabel23.setText("\u8003\u8bd5\u65f6\u95f4(分钟)：");

		jTextFieldsj.setText("150");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jButtonqr)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabel1)
																						.addComponent(
																								jLabel3)
																						.addComponent(
																								jLabel6)
																						.addComponent(
																								jLabel7)
																						.addComponent(
																								jLabel8)
																						.addComponent(
																								jLabel9)
																						.addComponent(
																								jLabel10)
																						.addComponent(
																								jLabel11)
																						.addComponent(
																								jLabel23))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																						.addComponent(
																								jTextField6)
																						.addComponent(
																								jTextField5)
																						.addComponent(
																								jTextField4)
																						.addComponent(
																								jTextField2)
																						.addComponent(
																								jTextField3)
																						.addComponent(
																								jTextField1,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								65,
																								Short.MAX_VALUE)
																						.addComponent(
																								jTextFieldzf,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								74,
																								Short.MAX_VALUE)
																						.addComponent(
																								jLabel4)
																						.addComponent(
																								jTextFieldsj))))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabel5)
																						.addGroup(
																								jPanel1Layout
																										.createSequentialGroup()
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jLabel2)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jComboBox1,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												75,
																												javax.swing.GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								jPanel1Layout
																										.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.TRAILING,
																												false)
																										.addComponent(
																												jTextField12,
																												javax.swing.GroupLayout.Alignment.LEADING)
																										.addComponent(
																												jTextField11,
																												javax.swing.GroupLayout.Alignment.LEADING)
																										.addComponent(
																												jTextField10,
																												javax.swing.GroupLayout.Alignment.LEADING)
																										.addComponent(
																												jTextField9,
																												javax.swing.GroupLayout.Alignment.LEADING)
																										.addComponent(
																												jTextField7,
																												javax.swing.GroupLayout.Alignment.LEADING)
																										.addComponent(
																												jTextField8,
																												javax.swing.GroupLayout.Alignment.LEADING,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												70,
																												Short.MAX_VALUE)))
																		.addGap(41,
																				41,
																				41)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabel12)
																						.addComponent(
																								jLabel14)
																						.addComponent(
																								jLabel15)
																						.addComponent(
																								jLabel16)
																						.addComponent(
																								jLabel17)
																						.addComponent(
																								jLabel18)
																						.addComponent(
																								jLabel19)
																						.addComponent(
																								jLabel20)
																						.addComponent(
																								jLabel21)
																						.addComponent(
																								jLabel22))
																		.addGap(57,
																				57,
																				57)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jTextField21,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								68,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jTextField20,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								68,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jTextField19,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								68,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jTextField18,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								68,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jTextField17,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								68,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jTextField16,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								68,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jTextField15,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								68,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jTextField14,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								68,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jTextField13,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								68,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jLabel13)))
														.addComponent(
																jButtonfh,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																78,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(140, Short.MAX_VALUE)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addGroup(
																jPanel1Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(
																				jLabel1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				25,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				jTextFieldzf,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				jLabel2)
																		.addComponent(
																				jComboBox1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jPanel1Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(
																				jLabel12)
																		.addComponent(
																				jLabel13)))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel3)
														.addComponent(jLabel4)
														.addComponent(jLabel5)
														.addComponent(jLabel14)
														.addComponent(
																jTextField13,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel6)
														.addComponent(
																jTextField1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jTextField7,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel15)
														.addComponent(
																jTextField14,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel7)
														.addComponent(
																jTextField2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jTextField8,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel16)
														.addComponent(
																jTextField15,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel8)
														.addComponent(
																jTextField3,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jTextField9,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel17)
														.addComponent(
																jTextField16,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel9)
														.addComponent(
																jTextField4,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jTextField10,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel18)
														.addComponent(
																jTextField17,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel10)
														.addComponent(
																jTextField5,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jTextField11,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel19)
														.addComponent(
																jTextField18,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel11)
														.addComponent(
																jTextField6,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jTextField12,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel20)
														.addComponent(
																jTextField19,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel21)
														.addComponent(
																jTextField20,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel22)
														.addComponent(
																jTextField21,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel23)
														.addComponent(
																jTextFieldsj,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												21, Short.MAX_VALUE)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jButtonqr)
														.addComponent(jButtonfh))
										.addContainerGap()));


		jTabbedPane1.addTab("\u7ec4\u5377", jPanel1);



		jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				 "所有", "很简单", "简单", "一般", "较难", "很难"}));

		jButtoncx.setText("\u67e5\u8be2\u8bd5\u5377");
		jButtoncx.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtoncxActionPerformed(evt);
			}
		});

		jButtonck.setText("\u67e5\u770b\u8bd5\u5377");
		jButtonck.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonckActionPerformed(evt);
			}
		});

		jButtonzd.setText("\u6307\u5b9a\u8bd5\u5377");
		jButtonzd.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonzdActionPerformed(evt);
			}
		});

		jButtonfh2.setText("\u8fd4\u56de");
		jButtonfh2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonfh2ActionPerformed(evt);
			}
		});

		jButtonqx.setText("\u53d6\u6d88\u6307\u5b9a");
		jButtonqx.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonqxActionPerformed(evt);
			}
		});

		jButtonsc.setText("\u5220\u9664\u8bd5\u5377");
		jButtonsc.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonscActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout
				.setHorizontalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel2Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												582, Short.MAX_VALUE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																jButtonfh2)
														.addComponent(
																jComboBox2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																109,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jButtoncx)
														.addGroup(
																jPanel2Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				false)
																		.addComponent(
																				jButtonzd,
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				jButtonck,
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE))
														.addComponent(jButtonqx)
														.addComponent(jButtonsc))
										.addContainerGap()));
		jPanel2Layout
				.setVerticalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				jComboBox2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(35,
																				35,
																				35)
																		.addComponent(
																				jButtoncx)
																		.addGap(35,
																				35,
																				35)
																		.addComponent(
																				jButtonck)
																		.addGap(35,
																				35,
																				35)
																		.addComponent(
																				jButtonzd)
																		.addGap(41,
																				41,
																				41)
																		.addComponent(
																				jButtonqx)
																		.addGap(40,
																				40,
																				40)
																		.addComponent(
																				jButtonsc)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				71,
																				Short.MAX_VALUE)
																		.addComponent(
																				jButtonfh2))
														.addComponent(
																jScrollPane1,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																444,
																Short.MAX_VALUE))
										.addContainerGap()));

		jTabbedPane1.addTab("\u8bd5\u5377\u7ba1\u7406", jPanel2);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap()
						.addComponent(jTabbedPane1)));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addContainerGap()
						.addComponent(jTabbedPane1).addContainerGap()));

		pack();
	}
	//删除试卷
	private void jButtonscActionPerformed(java.awt.event.ActionEvent evt) {
		GetConn gc=new GetConn();
		int row=jTable1.getSelectedRow();
		String id1=(String) jTable1.getValueAt(row,0);

	    int r;
			r=gc.executeUpdate("delete from shijuan where SJID="+id1);
			
			if (r ==1) {

				JOptionPane.showMessageDialog(shitiguanli.this, "删除成功!", "欢迎", 1);
				}
			 else 
					JOptionPane.showMessageDialog(shitiguanli.this, "删除失败",
							"Error!", 1);
		
		
		
	}
	//取消指定试卷,将标志位置零
	private void jButtonqxActionPerformed(java.awt.event.ActionEvent evt) {
		GetConn gc=new GetConn();
		int row=jTable1.getSelectedRow();
		String flag1="0";
	    String idst=(String)jTable1.getValueAt(row,0);
		String str="update shijuan set flag='"+flag1+"'where SJID='"+idst+"'";
	    int  result=gc.executeUpdate(str);

		if (result == 1) {

			JOptionPane.showMessageDialog(shitiguanli.this, "取消指定成功!", "欢迎", 1);
			}
		 else 
				JOptionPane.showMessageDialog(shitiguanli.this, "取消指定失败",
						"Error!", 1);
	}
	

	private void jButtonfh2ActionPerformed(java.awt.event.ActionEvent evt) {
		dispose();//返回
	}
	//指定试卷,生成这分试卷的考试信息表
	private void jButtonzdActionPerformed(java.awt.event.ActionEvent evt) {
		GetConn gc=new GetConn();
		Object[][] shitizd;
		try {
			shitizd = OperateQuestion.selectAllshijuan();
		} catch (Exception e) {
			shitizd = null;
			e.printStackTrace();
		}
		int num=0;
		for(int coun=0;coun<shitizd.length;coun++){
			num+=Integer.parseInt(String.valueOf(shitizd[coun][3]));
		}
		if(num==0){
		int row=jTable1.getSelectedRow();
		String flag="1";//标志位置为1
	    String idst=(String)jTable1.getValueAt(row,0);//所指定试卷的编号
	    int score=Integer.parseInt(String.valueOf(jTable1.getValueAt(row,2)));//试卷分数
	    int kgtscore=Integer.parseInt(String.valueOf(jTable1.getValueAt(row,5)));
		String id="sj"+idst;//指定的试卷表名字   
	    String jsid=teachmain.jsid;//出题教师信息
	    String jsxm=teachmain.jsxm;
		String []get11=new String [8];
		get11=OperateQuestion.zujuan(idst,5);
		String shijuandaan1="参考答案\n";
		shijuandaan1+=get11[6];//试卷答案
		String kgtdaan=get11[7];//客观题答案
		//创建这份试卷的考试信息表
	    gc.executeUpdate("CREATE TABLE "+id+ "(id varchar(20), name varchar(20), answer varchar(8000), score int, kgtanswer varchar(2000), kgtscore int, primary key (id))");
	    String str1="insert into "+id+" (id,name,answer,score,kgtanswer,kgtscore)" +"values('"+jsid+"','"+jsxm+"','"+shijuandaan1+"','"+score+"','"+kgtdaan+"','"+kgtscore+"')";
	    int result1=gc.executeUpdate(str1);//添加一条记录,包括出题教师,参考答案等信息
		if (result1==1) {
        String str="update shijuan set flag='"+flag+"'where SJID='"+idst+"'"; 
        int  result11=gc.executeUpdate(str);
			JOptionPane.showMessageDialog(shitiguanli.this, "指定成功!", "欢迎", 1);
			}
		 else 
				JOptionPane.showMessageDialog(shitiguanli.this, "指定失败",
						"Error!", 1);
		}
		else{
			JOptionPane.showMessageDialog(shitiguanli.this, "只能指定一份试卷",
						"Error!", 1);
		}
		
	}
	//查看试卷
	private void jButtonckActionPerformed(java.awt.event.ActionEvent evt) {
		int row=jTable1.getSelectedRow();
		idck=(String) jTable1.getValueAt(row,0);//得到所查看试卷的id
		System.out.println(idck);
		String []get=new String [8];
		//get=OperateQuestion.zujuan(idck,4);
		shijuanchakan+=get[6];
		String []get1=new String [8];
		get1=OperateQuestion.zujuan(idck,5);		
		shijuandaan+=get1[6];
		cksj sj = new cksj();//查看完整试卷，与学生考试时看到的试卷一致
		sj.setVisible(true);
	}
	
	
	//查询试卷,可根据难度查询试卷表中的试卷
	private void jButtoncxActionPerformed(java.awt.event.ActionEvent evt) {
		int difficult=jComboBox2.getSelectedIndex();//根据难度查找试卷
        String d1 = Integer.toString(difficult-1);
         Object[][] shiti1;
    	try {
			shiti1 = OperateQuestion.selectAllshijuan();
		} catch (Exception e) {
			shiti1 = null;
			e.printStackTrace();
		}
		if (shiti1[0][0]==null) {
			JOptionPane.showMessageDialog(shitiguanli.this, "没有找到对应属性的题目",
						"Error!", 1);
		}
		else{
         Object[][] cxshiti1=new Object[shiti1.length][shiti1[0].length];
			int i,j;
			if(difficult==0){				
						cxshiti1=shiti1;
						for (i = 0,j=0; i < shiti1.length; i++) {
								cxshiti1[i][4]=shiti1[i][10];
							     cxshiti1[i][5]=shiti1[i][17];
						}			
				}					
				else{
						for (i = 0,j=0; i < shiti1.length; i++) {
							if (shiti1[i][1].equals(d1)) {
								cxshiti1[j]=shiti1[i];
								cxshiti1[j][4]=shiti1[i][10];
								 cxshiti1[i][5]=shiti1[i][17];
								j++;	
							}
						}
				}
			jTable1.setModel(new javax.swing.table.DefaultTableModel(
					cxshiti1, new String[] { "试卷编号",
							"试卷难度", "总分", "是否选定","考试时间" ,"客观题总分"}));
			jScrollPane1.setViewportView(jTable1);
		}

		
	}

	private void jButtonfhActionPerformed(java.awt.event.ActionEvent evt) {
		dispose();//返回
	}
	//组卷
	private void jButtonqrActionPerformed(java.awt.event.ActionEvent evt) {
		int i=0;
		int typescore[]=new int[6];
		int typenumber[]=new int[6];
		int chapternumber[]=new int[9];
		int score=0;
		int time=0;
		int difficult=0;
		difficult=jComboBox1.getSelectedIndex();	
		try {
			time=Integer.parseInt(jTextFieldsj.getText());//考试时间
			score=Integer.parseInt(jTextFieldzf.getText());	//试卷总分
			typescore[0]=Integer.parseInt(jTextField1.getText());//各题型分数	
			typescore[1]=Integer.parseInt(jTextField2.getText());	
			typescore[2]=Integer.parseInt(jTextField3.getText());	
			typescore[3]=Integer.parseInt(jTextField4.getText());	
			typescore[4]=Integer.parseInt(jTextField5.getText());	
			typescore[5]=Integer.parseInt(jTextField6.getText());	
			typenumber[0]=Integer.parseInt(jTextField7.getText());//各题型试题数	
			typenumber[1]=Integer.parseInt(jTextField8.getText());
			typenumber[2]=Integer.parseInt(jTextField9.getText());
			typenumber[3]=Integer.parseInt(jTextField10.getText());
			typenumber[4]=Integer.parseInt(jTextField11.getText());
			typenumber[5]=Integer.parseInt(jTextField12.getText());
			chapternumber[0]=Integer.parseInt(jTextField13.getText());//各章节试题数
			chapternumber[1]=Integer.parseInt(jTextField14.getText());
			chapternumber[2]=Integer.parseInt(jTextField15.getText());
			chapternumber[3]=Integer.parseInt(jTextField16.getText());
			chapternumber[4]=Integer.parseInt(jTextField17.getText());
			chapternumber[5]=Integer.parseInt(jTextField18.getText());
			chapternumber[6]=Integer.parseInt(jTextField19.getText());
			chapternumber[7]=Integer.parseInt(jTextField20.getText());
			chapternumber[8]=Integer.parseInt(jTextField21.getText());
		} catch (NumberFormatException e1) {//检查参数是否合理
			JOptionPane.showMessageDialog(null, "请输入整数！", "组卷失败", JOptionPane.ERROR_MESSAGE);
			return;
		}
		int alltypescore=0;
		int allchapternumber=0;
		int alltypenumber=0;
		for(i=0;i<6;i++)
		{
			alltypescore=alltypescore+typescore[i];
		}
		if (alltypescore!=score){
			JOptionPane.showMessageDialog(null, "题型分数与总分不一致！请重新输入！", "组卷失败", JOptionPane.ERROR_MESSAGE);
			return;
		}
		for(i=0;i<9;i++)
		{
			allchapternumber=allchapternumber+chapternumber[i];
		}
		for(i=0;i<6;i++)
		{	
			alltypenumber=alltypenumber+typenumber[i];
		}
		if(allchapternumber!=alltypenumber){
		JOptionPane.showMessageDialog(null, "题型题目数与章节题目数不一致！请重新输入！", "组卷失败", JOptionPane.ERROR_MESSAGE);
		return;
		}
		Object [] tscore=new Object [6];

		for(i=0;i<6;i++)
		{
			if((typescore[i]%typenumber[i])!=0){
				JOptionPane.showMessageDialog(null, "题目分数与题目数不匹配！请重新输入！", "组卷失败", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if((typescore[i]%typenumber[i])==0){
				tscore[i]=(typescore[i]/typenumber[i]);
				
			}
		}
		 Object[][] allquestion;//调用组卷算法得到试题的题号
	    	try {
	    		allquestion = TestPaper.testpaper(typescore, typenumber,chapternumber,score,difficult);//调用组卷算法
			} catch (Exception e) {
				allquestion = null;
				e.printStackTrace();
			}			
			Object[][] T=new Object[6][allquestion.length];//按照题型分别记录试卷中的试题
			int num0 = 0,num1=0,num2=0,num3=0,num4=0,num5=0;//记录下各题型的试题数
			for(int j=0;j<allquestion.length;j++){
				if(allquestion[j][1].equals(0)){
					T[0][num0]=allquestion[j][0];
					num0++;					
				}
				else if(allquestion[j][1].equals(1)){
					T[1][num1]=allquestion[j][0];
					num1++;
				}
				else if(allquestion[j][1].equals(2)){
					T[2][num2]=allquestion[j][0];
					num2++;
				}
				else if(allquestion[j][1].equals(3)){
					T[3][num3]=allquestion[j][0];
					num3++;
				}
				else if(allquestion[j][1].equals(4)){
					T[4][num4]=allquestion[j][0];
					num4++;
				}
				else if(allquestion[j][1].equals(5)){
					T[5][num5]=allquestion[j][0];
					num5++;
				}
			}
			String T_0=OperateQuestion.toString(T[0]);//将各题型的试题编号数组转换成字符串
			String T_1=OperateQuestion.toString(T[1]);
			String T_2=OperateQuestion.toString(T[2]);
			String T_3=OperateQuestion.toString(T[3]);
			String T_4=OperateQuestion.toString(T[4]);
			String T_5=OperateQuestion.toString(T[5]);

			
			
			Calendar date=new GregorianCalendar();//生成试卷编号
			int year=date.get(Calendar.YEAR);
			int month=date.get(Calendar.MONTH);
			month=month+1;
			int day=date.get(Calendar.DAY_OF_MONTH);
			int flag0=0;
			int hour=date.get(Calendar.HOUR);
			int minute=date.get(Calendar.MINUTE);
			int second=date.get(Calendar.SECOND);
			new String();
			int kgtscore=typescore[0]+typescore[1];
			String sjid=String.valueOf(year)+String.valueOf(month)+String.valueOf(day)
							+String.valueOf(hour)+String.valueOf(minute)+String.valueOf(second);
			System.out.println(T_0);
			System.out.println(T_1);
			System.out.println(T_2);
			System.out.println(T_3);
			System.out.println(T_4);
			System.out.println(T_5);
			System.out.println(sjid);
			System.out.println(difficult);
			System.out.println(score);
			
			GetConn gc=new GetConn();//往试卷表中添加试卷
			String str="insert into shijuan (SJID,difficult,T0ID,T1ID,T2ID,T3ID,T4ID,T5ID,flag,score,time,score0,score1,score2,score3,score4,score5,kgtscore)" +
					"values('"+sjid+"','"+difficult+"','"+T_0+"','"+T_1+"','"+T_2+"','"+T_3+"','"+T_4+"','"+T_5+"','"+flag0+"','"+score+"','"+time+"','"+tscore[0]+"','"+tscore[1]+"','"+tscore[2]+"','"+tscore[3]+"','"+tscore[4]+"','"+tscore[5]+"','"+kgtscore+"')";
		    int result=gc.executeUpdate(str);
		    if (result==1) {

				JOptionPane.showMessageDialog(shitiguanli.this, "组卷成功!", "欢迎", 1);
				}
			 else {
				JOptionPane.showMessageDialog(shitiguanli.this, "组卷失败","Error!", 1);
			 }
	}

	private javax.swing.JButton jButtonck;
	private javax.swing.JButton jButtoncx;
	private javax.swing.JButton jButtonfh;
	private javax.swing.JButton jButtonfh2;
	private javax.swing.JButton jButtonqr;
	private javax.swing.JButton jButtonqx;
	private javax.swing.JButton jButtonzd;
	private javax.swing.JButton jButtonsc;
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JComboBox jComboBox2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel18;
	private javax.swing.JLabel jLabel19;
	private javax.swing.JLabel jLabel23;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel20;
	private javax.swing.JLabel jLabel21;
	private javax.swing.JLabel jLabel22;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTabbedPane jTabbedPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextFieldsj;
	private javax.swing.JTextField jTextField10;
	private javax.swing.JTextField jTextField11;
	private javax.swing.JTextField jTextField12;
	private javax.swing.JTextField jTextField13;
	private javax.swing.JTextField jTextField14;
	private javax.swing.JTextField jTextField15;
	private javax.swing.JTextField jTextField16;
	private javax.swing.JTextField jTextField17;
	private javax.swing.JTextField jTextField18;
	private javax.swing.JTextField jTextField19;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField20;
	private javax.swing.JTextField jTextField21;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JTextField jTextField5;
	private javax.swing.JTextField jTextField6;
	private javax.swing.JTextField jTextField7;
	private javax.swing.JTextField jTextField8;
	private javax.swing.JTextField jTextField9;
	private javax.swing.JTextField jTextFieldzf;
	// End of variables declaration//GEN-END:variables

}