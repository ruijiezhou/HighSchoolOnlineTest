package login;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
/**
 *
 * @author ����Ա�����
 */
public class adminmain extends javax.swing.JFrame {
	login log = new login();

	/** �������**/
	public adminmain() {
		initComponents();
	}
	/**����ʼ��**/
	private void initComponents() {
		jButtonyhcx = new javax.swing.JButton();//�����ؼ�
		jButtonyhtj = new javax.swing.JButton();
		jButtonyhxg = new javax.swing.JButton();
		jButtonyhsc = new javax.swing.JButton();
		jButtonsjbf = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		maintitle = new java.awt.Label();
        jButton1_1 = new javax.swing.JButton();
		jButtonyhtj2 = new javax.swing.JButton();
		jButtonyhtj1 = new javax.swing.JButton();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);//����رմ���
		setTitle("\u6B22\u8FCE\u60A8\uFF0C\u7BA1\u7406\u5458null");//���ô��ڱ���
		this.setBounds(250, 150, 500, 300);//����λ��
		maintitle.setAlignment(java.awt.Label.CENTER);//�ؼ�����,����,λ��,���ݵ�
		maintitle.setBackground(new java.awt.Color(240, 240, 240));
		maintitle.setFont(new java.awt.Font("����", 1, 36));
		maintitle.setForeground(new java.awt.Color(0, 0, 153));
		maintitle.setName("logintitle");
		maintitle.setText("\u9AD8\u4E2D\u5316\u5B66\u5728\u7EBF\u8003\u8BD5\u7CFB\u7EDF");

		jButtonyhcx.setText("\u7528\u6237\u67e5\u8be2");//��ť����
		jButtonyhcx.addActionListener(new java.awt.event.ActionListener() {//��ť�¼�������
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonyhcxActionPerformed(evt);
			}
		});

		jButtonyhtj.setText("\u7528\u6237\u6dfb\u52a0");
		jButtonyhtj.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonyhtjActionPerformed(evt);
			}
		});

		jButtonyhxg.setText("\u7528\u6237\u4fee\u6539");
		jButtonyhxg.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonyhxgActionPerformed(evt);
			}
		});

		jButtonyhsc.setText("\u7528\u6237\u5220\u9664");
		jButtonyhsc.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonyhscActionPerformed(evt);
			}
		});

		jButtonsjbf.setText("�����ѯ");
		jButtonsjbf.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonsjbfActionPerformed(evt);
			}
		});

		jLabel1.setFont(new java.awt.Font("΢���ź�", 0, 18));
		jLabel1.setText("\u7528\u6237\u7ba1\u7406\uff1a");

		jLabel2.setFont(new java.awt.Font("΢���ź�", 0, 18));
		jLabel2.setText("�������");

		jButton1_1.setText("ע����¼");
		jButton1_1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButtonyhtj1.setText("\u8F6C\u5230\u5B66\u751F");
		jButtonyhtj1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonyhtj1ActionPerformed(evt);
			}
		});

		jButtonyhtj2.setText("\u8F6C\u5230\u6559\u5E08");
		jButtonyhtj2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonyhtj2ActionPerformed(evt);
			}
		});
		//ҳ�沼�ִ���,����Զ�����
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addGap(20)
					.addComponent(maintitle, GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(layout.createSequentialGroup()
					.addGap(137)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(jLabel2)
						.addComponent(jLabel1))
					.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(jButtonyhxg, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jButtonyhtj2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jButtonsjbf, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jButtonyhcx, Alignment.TRAILING))
					.addGap(63)
					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(jButtonyhsc, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jButtonyhtj1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jButtonyhtj, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jButton1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(160))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(maintitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jButtonyhtj2)
						.addComponent(jButtonyhtj1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jButtonyhtj)
						.addComponent(jButtonyhcx)
						.addComponent(jLabel1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jButtonyhxg)
						.addComponent(jButtonyhsc))
					.addGap(56)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jButtonsjbf)
						.addComponent(jLabel2)
						.addComponent(jButton1_1))
					.addContainerGap(89, Short.MAX_VALUE))
		);
		getContentPane().setLayout(layout);

		pack();
	}
	/**����ť����**/
	private void jButtonyhtj2ActionPerformed(java.awt.event.ActionEvent evt) {
		teachmain tea =new teachmain();//ת����ʦ
		tea.setVisible(true);
	}

	private void jButtonyhtj1ActionPerformed(java.awt.event.ActionEvent evt) {
		stumain stu =new stumain();//ת��ѧ��
		stu.setVisible(true);
	}


	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		login log =new login();
		log.setVisible(true);
		dispose();//����,�رմ���
	}

	private void jButtonsjbfActionPerformed(java.awt.event.ActionEvent evt) {
		pwgl stu =new pwgl();//�������
		stu.setVisible(true);
		
	}

	private void jButtonyhscActionPerformed(java.awt.event.ActionEvent evt) {
		Xguserinfo Xg =new Xguserinfo();//�û�ɾ��
		Xg.setVisible(true);
	}

	private void jButtonyhtjActionPerformed(java.awt.event.ActionEvent evt) {
		Tjuserinfo tj =new Tjuserinfo();//�û����
		tj.setVisible(true);
	}

	private void jButtonyhxgActionPerformed(java.awt.event.ActionEvent evt) {
		Xguserinfo Xg =new Xguserinfo();//�û��޸�
		Xg.setVisible(true);
	}

	private void jButtonyhcxActionPerformed(java.awt.event.ActionEvent evt) {
		Cxuserinfo cx =new Cxuserinfo();//�û���ѯ
		cx.setVisible(true);

	}
	//����ؼ�
	private javax.swing.JButton jButton1;
	private JButton jButton1_1;
	private javax.swing.JButton jButtonyhtj2;
	private javax.swing.JButton jButtonsjbf;
	private javax.swing.JButton jButtonyhcx;
	private javax.swing.JButton jButtonyhsc;
	private javax.swing.JButton jButtonyhtj;
	private javax.swing.JButton jButtonyhxg;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private java.awt.Label maintitle;
	private javax.swing.JButton jButtonyhtj1;
}