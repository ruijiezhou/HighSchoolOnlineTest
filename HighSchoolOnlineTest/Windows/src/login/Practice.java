package login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

/*������ϰ�����,������ϰ��ȡ��ȫ������㷨���,����ָ����Ҫ��,��������ķ����õ����ʵ���Ŀ��ʾ��ѧ����ϰ*/
public class Practice {


	
	public int[] random(int all) 				//��������ɺ��������Բ�����Χ��0-all�������������
	{
		Random ran=new Random();		//��������ʼ��
		int a=0;
		int i;
		int temp;
		int random[]=new int[all];
		for(i=0;i<all;i++)			//������������ʼ��
		{
			random[i]=i;
		}
		
		for(i=0;i<all;i++)		//������������ɽ���������ң��õ��������������
		{
			a=ran.nextInt(all);
			temp=random[a];
			random[a]=random[i];
			random[i]=temp;
		}
	
		return random;			//����һ���������
	}
	
	
	public Object[] [] practice(int chapter,int difficult,int type)		//������ϰ�������ɵĺ������ٶ�һ����ϰ5����
	{
		Object [][]temp=null;				//����һ����ʱ����
		int []tempran=null;
		Object [][]allquestion=new Object [5][5];		//����allquestion�������ڴ��ѡ�������
		ResultSet rs = null;
		GetConn gc=new GetConn();			//�������ݿ�
		int i=0;
		int j=0;
		int c=0;
		int number=0;
		switch(type)		//�жϸ��������������Ϣ,������ĳ���½�
		{
			case 0:
				c=0;
				rs=gc.executeQuery("select * from questionbank0 where chapter='"+chapter+"' and difficult='"+difficult+"'");//ѡ������½������Ѷ����Ե�����
				try {
					while(rs.next()){		//�õ������������
						c++;
					}
					temp = new Object[c][5];
					j=0;
					rs=gc.executeQuery("select * from questionbank0 where chapter='"+chapter+"' and difficult='"+difficult+"'");
					while(rs.next()){		//���õ����������Դ����temp������
						temp[j][0]=rs.getString("id");		//�õ������Id
						temp[j][1]=rs.getInt("grade");		//�õ��������������
						temp[j][2]=rs.getInt("difficult");	//�õ�������Ѷ�����
						temp[j][3]=rs.getInt("chapter");	//�õ�������½�����
						temp[j][4]=rs.getInt("flag");
						j=j+1;
						}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			break;
			
			case 1:
				c=0;
				rs=gc.executeQuery("select * from questionbank1 where chapter='"+chapter+"' and difficult='"+difficult+"'");//ѡ������½������Ѷ����Ե�����
				try {
					while(rs.next()){//�õ������������
						c++;
					}
					temp = new Object[c][5];
					j=0;
					rs=gc.executeQuery("select * from questionbank1 where chapter='"+chapter+"' and difficult='"+difficult+"'");
					while(rs.next()){		//���õ����������Դ����temp������
						temp[j][0]=rs.getString("id");	//�õ������ID
						temp[j][1]=rs.getInt("grade");	//�õ��������������
						temp[j][2]=rs.getInt("difficult");	//�õ�������Ѷ�����
						temp[j][3]=rs.getInt("chapter");	//�õ�������½�����
						temp[j][4]=rs.getInt("flag");
						j=j+1;
						}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;
			
			case 2:
				c=0;
				rs=gc.executeQuery("select * from questionbank2 where chapter='"+chapter+"' and difficult='"+difficult+"'");//ѡ������½������Ѷ����Ե�����
				try {
					while(rs.next()){	//���õ����������Դ����temp������
						c++;
					}
					temp = new Object[c][5];
					j=0;
					rs=gc.executeQuery("select * from questionbank2 where chapter='"+chapter+"' and difficult='"+difficult+"'");
					while(rs.next()){		//	//���õ����������Դ����temp������
						temp[j][0]=rs.getString("id");//�õ������ID
						temp[j][1]=rs.getInt("grade");		//�õ�����ķ���
						temp[j][2]=rs.getInt("difficult");	//�õ�������Ѷ�
						temp[j][3]=rs.getInt("chapter");	//�õ�ʵ����½�������Ϣ
						temp[j][4]=rs.getInt("flag");
						j=j+1;
						}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;
			
			case 3:
				c=0;
				rs=gc.executeQuery("select * from questionbank3 where chapter='"+chapter+"' and difficult='"+difficult+"'");//ѡ������½������Ѷ����Ե�����
				try {
					while(rs.next()){//���õ����������Դ����temp������
						c++;
					}
					temp = new Object[c][5];
					j=0;
					rs=gc.executeQuery("select * from questionbank3 where chapter='"+chapter+"' and difficult='"+difficult+"'");
					while(rs.next()){//	//���õ����������Դ����temp������
						temp[j][0]=rs.getString("id");//�õ������ID
						temp[j][1]=rs.getInt("grade");	//�õ�����ķ���
						temp[j][2]=rs.getInt("difficult");//�õ�������Ѷ�
						temp[j][3]=rs.getInt("chapter");	//�õ�ʵ����½�������Ϣ
						temp[j][4]=rs.getInt("flag");
						j=j+1;
						}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			break;
			
			case 4:
				c=0;
				rs=gc.executeQuery("select * from questionbank4 where chapter='"+chapter+"' and difficult='"+difficult+"'");//ѡ������½������Ѷ����Ե�����
				try {
					while(rs.next()){//���õ����������Դ����temp������
						c++;
					}
					temp = new Object[c][5];
					j=0;
					rs=gc.executeQuery("select * from questionbank4 where chapter='"+chapter+"' and difficult='"+difficult+"'");
					while(rs.next()){		//���õ����������Դ����temp������
						temp[j][0]=rs.getString("id");		//�õ������ID
						temp[j][1]=rs.getInt("grade");		//�õ�����ķ���
						temp[j][2]=rs.getInt("difficult");	//�õ�������Ѷ�
						temp[j][3]=rs.getInt("chapter");	//�õ�ʵ����½�������Ϣ
						temp[j][4]=rs.getInt("flag");
						j=j+1;
						}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			break;
			
			case 5:
				c=0;
				rs=gc.executeQuery("select * from questionbank5 where chapter='"+chapter+"' and difficult='"+difficult+"'");//ѡ������½������Ѷ����Ե�����
				try {
					while(rs.next()){//���õ����������Դ����temp������
						c++;
					}
					temp = new Object[c][5];
					j=0;
					rs=gc.executeQuery("select * from questionbank5 where chapter='"+chapter+"' and difficult='"+difficult+"'");
					while(rs.next()){		//���õ����������Դ����temp������
						temp[j][0]=rs.getString("id");		//�õ������ID
						temp[j][1]=rs.getInt("grade");			//�õ�����ķ���
						temp[j][2]=rs.getInt("difficult");	//�õ�������Ѷ�
						temp[j][3]=rs.getInt("chapter");	//�õ�ʵ����½�������Ϣ
						temp[j][4]=rs.getInt("flag");
						j=j+1;
						}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;
		}
		Object [][]temp1=new Object[temp.length][5];
		tempran=random(temp.length);
		for(i=0;i<temp.length;i++)			//���õ��������������
		{
			temp1[i]=temp[tempran[i]];
		}
	

		if(temp.length<5) number=temp.length;	//������ʾ��������,������Ҫ���������������5,����ʾ5����,��С��5����,����ʾ���з���Ҫ�������
		else number=5;
	
		
		for(i=0;i<number;i++)		//��temp�����еõ��������number�������⸳��allquestion
		{
			allquestion[i]=temp1[i];
			
		}

		for(i=0;i<allquestion.length;i++)
		{
		}
		
		return allquestion;		//���ط���Ҫ�����������allquestion
	}
	
}