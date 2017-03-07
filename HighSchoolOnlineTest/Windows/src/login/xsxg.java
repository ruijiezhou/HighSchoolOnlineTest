package login;
import javax.swing.JOptionPane;

/**
 *
 * @author  学生修改个人信息
 */
public class xsxg extends javax.swing.JFrame {
	stumain stu=new stumain();
	public xsxg() {
		initComponents();
	}

	private void initComponents() {
		this.setBounds(250, 150, 500, 300);
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable()
		{
			public boolean isCellEditable(int row,int col){
				if(col==0||(col==1&&(row==0||row==4)))
					return false;
				else return true;
			}
		};
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		

		jButton1.setText("\u786e\u8ba4\u4fee\u6539");
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
	//刷新信息
	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
		Object [][] xuesheng;
		try {
			xuesheng = GetData.selectAll();
		} catch (Exception e) {
			xuesheng = null;
			e.printStackTrace();
		}
		int i;
		Object [][] xuesheng1=new Object[xuesheng[0].length][2];
		for (i = 0; i < xuesheng.length; i++) {
			if (stu.stuuser.equals(xuesheng[i][1])) {
				//将学生信息在面板中以表格形式显示
				String cKey = "1234567890abcdef";;
				aes a=new aes();
				String pw=(String)xuesheng[i][2];//显示明文密码方便修改
				String DeString = a.Decrypt(pw.trim(), cKey);
				xuesheng1[1][1]=(String)xuesheng[i][1];
				xuesheng1[3][1]=(String)xuesheng[i][3];
				xuesheng1[5][1]=(String)xuesheng[i][5];
				xuesheng1[6][1]=(String)xuesheng[i][6];
				xuesheng1[7][1]=(String)xuesheng[i][7];
				xuesheng1[2][1]=DeString;
				xuesheng1[4][1]=(String)xuesheng[i][4];
				xuesheng1[0][1]="学生";
				xuesheng1[1][0]="用户名";
				xuesheng1[3][0]="姓名";
				xuesheng1[5][0]="性别";
				xuesheng1[6][0]="年级";
				xuesheng1[7][0]="班级";
				xuesheng1[2][0]="密码";
				xuesheng1[4][0]="学号";
				xuesheng1[0][0]="身份";
				break;
			}
		}
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("欢迎您，学生"+stu.stuname);
		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				xuesheng1, new String[] {"  ","  " }));
		jScrollPane1.setViewportView(jTable1);
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		dispose();//返回
		
	}
	//修改信息
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws Exception {		
		GetConn gc=new GetConn();
		int row;
		Object [][]Userxg=new Object [8][1];
	    for(row=0;row<8;row++){
	    
	    	Userxg[row][0]= jTable1.getValueAt(row,1);
	    	
	    }
		String username=(String)Userxg[1][0];
		String password=(String)Userxg[2][0];
		String Name=(String)Userxg[3][0];
		String id=(String)Userxg[4][0];
		String sex=(String)Userxg[5][0];
		String college=(String)Userxg[6][0];
		String Class=(String)Userxg[7][0];
	    String cKey = "1234567890abcdef";
		
		String enString = aes.Encrypt(password.trim(), cKey);
		String str="update user set username='"+username+"',password='"+enString+"',Name='"+Name+"',sex='"+sex+"',college='"+college+"',Class='"+Class+"'where id='"+id+"'";
	    int result=gc.executeUpdate(str);
		
		if (result == 1) {

			JOptionPane.showMessageDialog(xsxg.this, "全部修改成功!", "欢迎", 1);
			}
		 else 
				JOptionPane.showMessageDialog(xsxg.this, "修改失败",
						"Error!", 1);
		
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;

}