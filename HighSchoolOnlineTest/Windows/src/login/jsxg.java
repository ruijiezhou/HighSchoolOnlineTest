package login;

import javax.swing.JOptionPane;

/**
 *
 * @author  ��ʦ������Ϣ�޸����
 */
public class jsxg extends javax.swing.JFrame {
	teachmain tea=new teachmain();
	//�½���ʦ������Ϣ�޸����
	public jsxg() {
		initComponents();
	}
	//��ʼ�����
	private void initComponents() {
		this.setBounds(250, 150, 500, 300);//���λ��
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable()
		{
			public boolean isCellEditable(int row,int col){//���õ�Ԫ�񲿷ֿɱ༭
				if(col==0||(col==1&&(row==0||row==4)))
					return false;
				else return true;
			}
		};
		jButton1 = new javax.swing.JButton();//�½��ؼ�
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		

		jButton1.setText("\u786e\u8ba4\u4fee\u6539");//��ť����ť�¼�����������
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton1ActionPerformed(evt);
				} catch (Exception e) {
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

		jButton3.setText("\u5237\u65b0");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton3ActionPerformed(evt);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//��岼�ִ���,����Զ�����
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addGroup(
														layout.createSequentialGroup()
																.addContainerGap()
																.addComponent(
																		jScrollPane1,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		261,
																		Short.MAX_VALUE))
												.addGroup(
														layout.createSequentialGroup()
																.addContainerGap(
																		187,
																		Short.MAX_VALUE)
																.addComponent(
																		jButton2,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		86,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jButton3,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		78,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		114,
																		Short.MAX_VALUE)
																.addComponent(
																		jButton1)))
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jButton1)
												.addComponent(jButton3))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										324, Short.MAX_VALUE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jButton2)));

		pack();
	}
	/**��ť���ܴ����¼�*/
	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
		Object [][] jiaoshi;//��ȡ��ʦ������Ϣ
		try {
			jiaoshi = GetData.selectAll();
		} catch (Exception e) {
			jiaoshi = null;
			e.printStackTrace();
		}
		int i;
		Object [][] jiaoshi1=new Object[jiaoshi[0].length][2];
		for (i = 0; i < jiaoshi.length; i++) {
			if (tea.jsyhm.equals(jiaoshi[i][1])) {
				String cKey = "1234567890abcdef";//������ܺ�������ʾ
				aes a=new aes();
				String pw=(String)jiaoshi[i][2];//����ʦ������Ϣ��ʾ�ڱ����
				String DeString = a.Decrypt(pw.trim(), cKey);
				jiaoshi1[1][1]=(String)jiaoshi[i][1];
				jiaoshi1[3][1]=(String)jiaoshi[i][3];
				jiaoshi1[5][1]=(String)jiaoshi[i][5];
				jiaoshi1[6][1]=(String)jiaoshi[i][6];
				jiaoshi1[7][1]=(String)jiaoshi[i][7];
				jiaoshi1[2][1]=DeString;
				jiaoshi1[4][1]=(String)jiaoshi[i][4];
				jiaoshi1[0][1]="��ʦ";
				jiaoshi1[1][0]="�û���";
				jiaoshi1[3][0]="����";
				jiaoshi1[5][0]="�Ա�";
				jiaoshi1[6][0]="�꼶";
				jiaoshi1[7][0]="�ڿΰ༶";
				jiaoshi1[2][0]="����";
				jiaoshi1[4][0]="�̹���";
				jiaoshi1[0][0]="���";
				break;
			}
		}
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("��ӭ������ʦ"+tea.jsxm);//������
		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				jiaoshi1, new String[] {"  ","  " }));
		jScrollPane1.setViewportView(jTable1);
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		dispose();//���ذ����رմ���
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
		GetConn gc=new GetConn();//�������ݿ�����
		int row;
		Object [][]Userxg=new Object [8][1];
	    for(row=0;row<8;row++){
	    	Userxg[row][0]= jTable1.getValueAt(row,1);//��ȡtable�е�������ֵ
	    }

		String username=(String)Userxg[1][0];
		String password=(String)Userxg[2][0];
		String Name=(String)Userxg[3][0];
		String id=(String)Userxg[4][0];
		String sex=(String)Userxg[5][0];
		String college=(String)Userxg[6][0];
		String Class=(String)Userxg[7][0];
		String cKey = "1234567890abcdef";
		String enString = aes.Encrypt(password.trim(), cKey);//��������ܺ�洢
		String str="update user set username='"+username+"',password='"+enString+"',Name='"+Name+"',sex='"+sex+"',college='"+college+"',Class='"+Class+"'where id='"+id+"'";
	    int result=gc.executeUpdate(str);//�������ݿ��ж�Ӧ��¼
		
		if (result == 1) {
			JOptionPane.showMessageDialog(jsxg.this, "ȫ���޸ĳɹ�!", "��ӭ", 1);//�������ݳɹ�
			}
		 else 
				JOptionPane.showMessageDialog(jsxg.this, "�޸�ʧ��",
						"Error!", 1);
		
	}
	private javax.swing.JButton jButton1;//����Ͽؼ�����
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;

}