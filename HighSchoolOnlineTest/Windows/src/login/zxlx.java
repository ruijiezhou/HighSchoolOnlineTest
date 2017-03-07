/*
 * zxlx.java
 *
 * Created on __DATE__, __TIME__
 */

package login;

import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author  在线练习
 */
public class zxlx extends javax.swing.JFrame {
	public Object [][] allquestion=new Object [5][4];
	public Object [][] lxt=new Object [5][2];
	public int count=0;
	int type=0;
	int flag=0;
	int count1=0;
	public zxlx() {
		initComponents();
	}
	
	public  ImageIcon xstp(String id,int type) {//添加图片方法
	
		byte [] buffer=null;
		IOImage ii=new IOImage();		
		try {
			buffer=ii.readBolb(id,type);  
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(buffer!=null)
		{
			System.out.println(buffer);
			Binary b=new Binary();
			ImageIcon img=b.BytetoImage(buffer);
			ImageIcon img1=b.zoom(img,250,250);
			return img1;
		}
		
		return null;
	}

	private void initComponents() {

		jTabbedPane1 = new javax.swing.JTabbedPane();
		jPanel1 = new javax.swing.JPanel();
		jButtonsyt = new javax.swing.JButton();
		jButtonxyt = new javax.swing.JButton();
		jButtonckda = new javax.swing.JButton();
		jComboBoxtx = new javax.swing.JComboBox();
		jComboBoxzj = new javax.swing.JComboBox();
		jScrollPane1 = new javax.swing.JScrollPane();
		jEditorPanetm = new javax.swing.JTextPane();
		jComboBoxnd = new javax.swing.JComboBox();
		jScrollPane2 = new javax.swing.JScrollPane();
		jEditorPanedj = new javax.swing.JEditorPane();
		jButtonfh = new javax.swing.JButton();
		jScrollPane3 = new javax.swing.JScrollPane();
		jEditorPaneda = new javax.swing.JEditorPane();
		jButtonks = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		this.setBounds(250, 150, 500, 300);
		jButtonsyt.setText("\u4e0a\u4e00\u9898");
		jButtonsyt.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonsytActionPerformed(evt);
			}
		});

		jButtonxyt.setText("\u4e0b\u4e00\u9898");
		jButtonxyt.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonxytActionPerformed(evt);
			}
		});

		jButtonckda.setText("\u67e5\u770b\u7b54\u6848");
		jButtonckda.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonckdaActionPerformed(evt);
			}
		});

		jComboBoxtx.setModel(new javax.swing.DefaultComboBoxModel(				new String[] {"\u5224\u65AD\u9898", "\u9009\u62E9\u9898", "\u586B\u7A7A\u9898", "\u7B80\u7B54\u9898", "\u8BA1\u7B97\u9898", "操作题"}));


		jComboBoxzj.setModel(new DefaultComboBoxModel(new String[] {"\u4E13\u9898\u4E00 \u7269\u8D28\u7EC4\u6210\u4E0E\u5206\u7C7B", "\u4E13\u9898\u4E8C \u6C27\u5316\u8FD8\u539F\u53CD\u5E94", "\u4E13\u9898\u4E09 \u79BB\u5B50\u53CD\u5E94", "\u4E13\u9898\u56DB \u5FAE\u7C92\u7ED3\u6784\u4E0E\u5316\u5B66\u952E", "\u4E13\u9898\u4E94 \u5143\u7D20\u5468\u671F\u5F8B", "\u4E13\u9898\u516D \u5316\u5B66\u5E73\u8861", "\u4E13\u9898\u4E03 \u7535\u89E3\u8D28\u6EB6\u6DB2", "\u4E13\u9898\u516B \u5E38\u89C1\u975E\u91D1\u5C5E\u53CA\u5176\u5316\u5408\u7269", "\u4E13\u9898\u4E5D \u5E38\u89C1\u6709\u673A\u7269\u53CA\u5E94\u7528"}));


		jScrollPane1.setViewportView(jEditorPanetm);

		jComboBoxnd.setModel(new javax.swing.DefaultComboBoxModel(	new String[] {"\u7B80\u5355", "\u4E2D\u7B49", "\u56F0\u96BE"}));
		jScrollPane2.setViewportView(jEditorPanedj);

		jButtonfh.setText("\u8fd4\u56de");
		jButtonfh.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonfhActionPerformed(evt);
			}
		});

		jScrollPane3.setViewportView(jEditorPaneda);

		jButtonks.setText("\u5f00\u59cb");
		jButtonks.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonksActionPerformed(evt);
			}
		});

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
														.addComponent(
																jScrollPane1,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																306,
																Short.MAX_VALUE)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jComboBoxtx,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				76,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jComboBoxzj,
																				0,
																				120,
																				Short.MAX_VALUE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jComboBoxnd,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				96,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addComponent(
																jScrollPane3,
																0, 0,
																Short.MAX_VALUE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				9,
																				Short.MAX_VALUE)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								false)
																						.addComponent(
																								jButtonsyt,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jButtonxyt,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								82,
																								Short.MAX_VALUE))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																						.addComponent(
																								jButtonfh,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jButtonckda,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)))
														.addComponent(
																jButtonks,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																78,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jScrollPane2,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																179,
																Short.MAX_VALUE))
										.addContainerGap()));
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
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jComboBoxzj,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jButtonks))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jScrollPane1,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																195,
																Short.MAX_VALUE)
														.addComponent(
																jScrollPane2,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																195,
																Short.MAX_VALUE))
										.addGap(4, 4, 4)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																		.addGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				jPanel1Layout
																						.createSequentialGroup()
																						.addGroup(
																								jPanel1Layout
																										.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.BASELINE)
																										.addComponent(
																												jButtonckda)
																										.addComponent(
																												jButtonsyt))
																						.addGap(58,
																								58,
																								58))
																		.addGroup(
																				jPanel1Layout
																						.createSequentialGroup()
																						.addComponent(
																								jScrollPane3,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								95,
																								Short.MAX_VALUE)
																						.addContainerGap()))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(70,
																				70,
																				70)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jButtonfh)
																						.addComponent(
																								jButtonxyt))
																		.addContainerGap()))));

		jTabbedPane1.addTab("\u5728\u7ebf\u7ec3\u4e60", jPanel1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 521,
				Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jTabbedPane1));

		pack();
	}

	private void jButtonfhActionPerformed(java.awt.event.ActionEvent evt) {
		dispose();//返回
	}
	//下一题
	private void jButtonxytActionPerformed(java.awt.event.ActionEvent evt) {
		if(flag!=0){
		if(count<lxt.length-1&&count>=0&&count!=count1-1){
			count++;
			String t=(String)lxt[count][0];
			jEditorPanetm.setText((count+1)+"."+t+"\n");
			jEditorPaneda.setText("");
			jEditorPanedj.setText("");
			byte [] buffer=null;
			IOImage ii=new IOImage();		
			try {
				buffer=ii.readBolb((String)allquestion[count][0],type);  
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(buffer!=null)
			{
				Binary b=new Binary();
				ImageIcon img=b.BytetoImage(buffer);
				ImageIcon img1=b.zoom(img,250,250);
				jEditorPanetm.insertIcon(img1);
			}
		}
		else if (count==(lxt.length-1)||count==count1-1)
			JOptionPane.showMessageDialog(zxlx.this, "已到最后一道，请重新开始练习","", 1);
		}
		
	}
	//开始练习,显示第一题
	private void jButtonksActionPerformed(java.awt.event.ActionEvent evt) {
			flag++;
			count=0;
			jEditorPaneda.setText("");
			jEditorPanedj.setText("");
			int chapter=jComboBoxzj.getSelectedIndex();//根据输入的属性确定题目
			int difficult=jComboBoxnd.getSelectedIndex();
			 type=jComboBoxtx.getSelectedIndex();
			Practice p=new Practice();
			allquestion=p.practice(chapter, difficult, type);
			for(int i=0;i<5;i++){
			if(allquestion[i][0]!=null)	{
				count1++;
			}
			}
			
			String idd;
			for(int i=0;i<lxt.length;i++){
				idd=(String)allquestion[i][0];
				
			   	try {
			   		lxt[i]=OperateQuestion.lxt(type,idd );
				} catch (Exception e) {
					lxt[i] = null;
					e.printStackTrace();
				}
			}
			String t=(String)lxt[0][0];
			jEditorPanetm.setText((count+1)+"."+t+"\n");	
			
			ImageIcon img1=xstp((String)allquestion[0][0],type);//试题的图片
			if(img1!=null)
			jEditorPanetm.insertIcon(img1);		
	}
	//上一题
	private void jButtonsytActionPerformed(java.awt.event.ActionEvent evt) {
		if(flag!=0){
		if(count<=lxt.length&&count>0){
			count--;
			String t=(String)lxt[count][0];
			jEditorPanetm.setText((count+1)+"."+t+"\n");
			jEditorPaneda.setText("");
			jEditorPanedj.setText("");
			byte [] buffer=null;
			IOImage ii=new IOImage();		
			try {
				buffer=ii.readBolb((String)allquestion[count][0],type);  
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(buffer!=null)
			{
				Binary b=new Binary();
				ImageIcon img=b.BytetoImage(buffer);
				ImageIcon img1=b.zoom(img,250,250);
				jEditorPanetm.insertIcon(img1);
			}
		}
		else if(count==0)
			JOptionPane.showMessageDialog(zxlx.this, "这是第一道","", 1);
		
		}
	}
	//查看参考答案
	private void jButtonckdaActionPerformed(java.awt.event.ActionEvent evt) {
		if(flag!=0){
			String t=(String)lxt[count][1];
			if(type==0){
				if(t.equals("0"))
					t="对";
				else if(t.equals("1"))
					t="错";
			}
			else if(type==1){
				if(t.equals("0"))
					t="A";
				else if(t.equals("1"))
					t="B";
				else if(t.equals("2"))
					t="C";
				else if(t.equals("3"))
					t="D";
			}
			jEditorPaneda.setText((count+1)+"."+t);
			
		}
	}

	private javax.swing.JButton jButtonckda;
	private javax.swing.JButton jButtonfh;
	private javax.swing.JButton jButtonks;
	private javax.swing.JButton jButtonsyt;
	private javax.swing.JButton jButtonxyt;
	private javax.swing.JComboBox jComboBoxnd;
	private javax.swing.JComboBox jComboBoxtx;
	private javax.swing.JComboBox jComboBoxzj;
	private javax.swing.JEditorPane jEditorPaneda;
	private javax.swing.JEditorPane jEditorPanedj;
	private javax.swing.JTextPane jEditorPanetm;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JTabbedPane jTabbedPane1;
	// End of variables declaration//GEN-END:variables

}