package login;

import javax.swing.JOptionPane;

/**
 *
 * @author  ��ʦ�ɼ�����
 */
public class cjgl extends javax.swing.JFrame {

	/**������ʦ�ɼ�������� */
	public cjgl() {
		initComponents();
	}
	//����ʼ������
	private void initComponents() {
		jScrollPane1 = new javax.swing.JScrollPane();//����ؼ�
		jTable1 = new javax.swing.JTable()
		{
			public boolean isCellEditable(int row,int col){//����table���ֵ�Ԫ��ɱ༭
					return false;
			}
		};
		jScrollPane2 = new javax.swing.JScrollPane();
		jTable2 = new javax.swing.JTable();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jComboBox1 = new javax.swing.JComboBox();
		jLabel2 = new javax.swing.JLabel();
		jComboBox2 = new javax.swing.JComboBox();
		jButton3 = new javax.swing.JButton();
		this.setBounds(250, 150, 500, 300);//���λ��
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("\u9AD8\u4E2D\u5316\u5B66\u5728\u7EBF\u8003\u8BD5\u7CFB\u7EDF\u6210\u7EE9\u7BA1\u7406");//������
		jButton1.setText("\u8fd4\u56de");//��ť���ֺͼ�����
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		jButton2.setText("\u67e5\u770b\u6210\u7ee9");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		jLabel1.setText("\u67e5\u627e\u8bd5\u5377");
		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {//������ѡ��
				 "����", "�ܼ�", "��", "һ��", "����", "����" }));
		jLabel2.setText("\u67e5\u627e\u5b66\u751f");
		jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"����"}));
		jButton3.setText("\u5237\u65b0");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});
		//��岼�ִ���
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										377,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING,
												false)
												.addComponent(jLabel1)
												.addComponent(jLabel2)
												.addComponent(
														jComboBox2,
														0,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														jButton3,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														jComboBox1,
														0,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														jButton1,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(jButton2))
								.addGap(18, 18, 18)
								.addComponent(jScrollPane2,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										228, Short.MAX_VALUE).addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(
														jScrollPane1,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														374, Short.MAX_VALUE)
												.addComponent(
														jScrollPane2,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														374, Short.MAX_VALUE)
												.addGroup(
														javax.swing.GroupLayout.Alignment.LEADING,
														layout.createSequentialGroup()
																.addComponent(
																		jLabel1)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jComboBox1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(
																		jButton3)
																.addGap(12, 12,
																		12)
																.addComponent(
																		jLabel2)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jComboBox2,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(18, 18,
																		18)
																.addComponent(
																		jButton2)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		159,
																		Short.MAX_VALUE)
																.addComponent(
																		jButton1)))
								.addContainerGap()));

		pack();
	}
	/**��ť�¼���������Ӧ����*/
	//�鿴�Ծ��,ͨ���Ծ��ѡ�������Ծ�鿴��Ӧ�Ծ�ĳɼ����
	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		int difficult=jComboBox1.getSelectedIndex();//�����Ѷ�ѡ���Ծ�
        String d1 = Integer.toString(difficult-1);
        Object[][] shiti1;//��ȡ�Ծ�
    	try {
			shiti1 = OperateQuestion.selectAllshijuan();
		} catch (Exception e) {
			shiti1 = null;
			e.printStackTrace();
		}
		if (shiti1[0][0]==null) {
			JOptionPane.showMessageDialog(cjgl.this, "û���ҵ���Ӧ���Ե��Ծ�",
						"Error!", 1);
		}
		else{
         Object[][] cxshiti1=new Object[shiti1.length][shiti1[0].length];
			int i,j;
			if(difficult==0){
				cxshiti1=shiti1;			
				}		
				else{
						for (i = 0,j=0; i < shiti1.length; i++) {
							if (shiti1[i][1].equals(d1)) {
								cxshiti1[j]=shiti1[i];
								j++;	
							}
						}
				}//�ҵ���Ӧ���Ե��Ծ��ڱ������ʾ
			jTable1.setModel(new javax.swing.table.DefaultTableModel(
					cxshiti1, new String[] { "��������",
							"�Ծ��Ѷ�", "�ܷ�", "�Ƿ�ѡ��" }));
			jScrollPane1.setViewportView(jTable1);
		}
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		dispose();//���ذ���,�رմ���
	}
	//����ѡ����Ծ�鿴��Ӧ������Ϣ����ѧ���ĳɼ�
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		int stu=jComboBox2.getSelectedIndex();//��������ɸѡ��Ҫ�鿴��ѧ��
		int row=jTable1.getSelectedRow();//��ȡѡ����Ծ���
		String id1=(String) jTable1.getValueAt(row,0);
		String id="sj"+id1;
        Object[][] cj;
    	try {
			cj = OperateQuestion.selectAlldajuan(id);//�����Ծ�����ѡ����Ӧ�Ծ�
		} catch (Exception e) {
			cj = null;
			e.printStackTrace();
		}
		//�����Ծ��Ų��Ҷ�Ӧ�Ŀ�����Ϣ��
         Object[][] cxcj=new Object[cj.length-1][cj[0].length];
			int i,j;
			for (i = 1,j=0; i < cj.length; i++,j++) {
					cxcj[j]=cj[i];
					cxcj[j][2]=cj[i][5];
					cxcj[j][3]=cj[i][3];
				}
			//��ѧ���ɼ����ڱ������ʾ
			jTable2.setModel(new javax.swing.table.DefaultTableModel(
				cxcj, new String[] { "ѧ��",
							"����", "�͹���÷�", "�ܳɼ�" }));
			jScrollPane2.setViewportView(jTable2);
		}
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JComboBox jComboBox2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTable jTable1;
	private javax.swing.JTable jTable2;

}