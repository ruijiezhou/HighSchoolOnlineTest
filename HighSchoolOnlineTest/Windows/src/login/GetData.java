package login;

import java.sql.ResultSet;


public class GetData {				//�����ݿ��ȡ���ݣ��õ��û���Ϣ��������

	public static  Object[][] selectAll() throws Exception{
		ResultSet rs = null;
		GetConn gc=new GetConn();			//�������ݿ�
		int c=0;
		int i=0;
		long start=System.currentTimeMillis();
		rs=gc.executeQuery("select id from user");	//ָ�����ݿ��ĳһ��
		while(rs.next()){
			c++;
		}
		Object[][] b=new Object[c][8];
		rs=gc.executeQuery("select * from user ");
			while(rs.next()){
			b[i][0]=rs.getString("User_Identity");		//�õ��û��������
			b[i][1]=rs.getString("username");			//�õ��û��˺���
			b[i][2]=rs.getString("password");			//�õ��û�����
			b[i][3]=rs.getString("name");				//�õ��û�����
			b[i][4]=rs.getString("id");					//��ȡ�û�ѧ�Ż��߽̹���
			b[i][5]=rs.getString("sex");				//��ȡ�û��Ա���Ϣ
			b[i][6]=rs.getString("college");			//��ȡ�û�Ժϵ��Ϣ
			b[i][7]=rs.getString("class");				//��ȡ�û��༶��Ϣ
			i=i+1;
		}
		gc.close();									//�ͷ����ݿ�����
		long end=System.currentTimeMillis();
		long time=end-start;
		System.out.println(time);
		return b;									//���û���Ϣ���鷵��
		}	

	}


