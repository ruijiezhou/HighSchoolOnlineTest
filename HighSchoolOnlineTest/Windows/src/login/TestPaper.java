
package login;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.JOptionPane;

/*����㷨����ƣ����㷨��Ҫ��ȡ���+���ݵķ�������������㷨����ƣ�����������������Ժ��½������Լ��Ѷ����������
���з�Ϊ������ʵ�֣�������Ҫ�����ݿ������͵����Ի�ȡ��Ȼ��������������������������ǣ�����ƥ��������������Ժ�
�½����ԣ����ƥ���Ѷ�����*/
public class TestPaper {			//����㷨����TestPaper


	public  static  Object[][] judgeall() {				//��questionbank0�õ������ж����������Ϣ
		
		//OperateQuestion OperateQuestion=new OperateQuestion();
		ResultSet rs = null;
		GetConn gc=new GetConn();			//�������ݿ�
		int c=0;
		int i=0;
		int flag=0;
		rs=gc.executeQuery("select ID from questionbank0 ");	//ָ�����ݿ���questionbank0
		Object[][] judge=null;
		try {									//�õ�������c
			while(rs.next()){
				c++;
			}
			judge = new Object[c][5];
			rs=gc.executeQuery("select * from questionbank0 ");
			while(rs.next()){					//���ж�������Դ����judge������
			judge[i][0]=rs.getString("ID");		//�õ������ID��
			//String str="update questionbank0 set flag="+flag+" where ID='"+judge[i][0]+"'";
			//gc.executeUpdate(str);
			judge[i][1]=rs.getInt("grade");		//�õ������������Ϣ
			judge[i][2]=rs.getInt("difficult");	//�õ�������Ѷ�����
			judge[i][3]=rs.getInt("chapter");	//�õ�������½�����
			judge[i][4]=rs.getInt("flag");
			

			i=i+1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gc.close();					//�ͷ����ݿ�����
		
		return judge;
	}
		
	public static Object[][] chooseall() {		//�õ�questionbank1������ѡ����������Ϣ

		
		ResultSet rs = null;
		GetConn gc=new GetConn();			//�������ݿ�
		int c=0;
		int i=0;
		int flag=0;
		rs=gc.executeQuery("select ID from questionbank1 ");		//ָ�����ݿ�questionbank1
		Object[][] choose=null;
		try {				//�õ�ѡ�����������c
			while(rs.next()){
				c++;
			}
			choose = new Object[c][5];
			rs=gc.executeQuery("select * from questionbank1 ");
			while(rs.next()){			//���ж�������Դ����choose������
			choose[i][0]=rs.getString("ID");	//�õ������ID
			//String str="update questionbank1 set flag="+flag+" where ID='"+choose[i][0]+"'";
			//gc.executeUpdate(str);
			choose[i][1]=rs.getInt("grade");	//�õ��������������
			choose[i][2]=rs.getInt("difficult");	//�õ�������Ѷ�����
			choose[i][3]=rs.getInt("chapter");		//�õ�������½�ˮϴ�Ǹ�
			choose[i][4]=rs.getInt("flag");		
			i=i+1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gc.close();					//�ͷ����ݵ�����
		return choose;				//����һ��ѡ�������Ե�����
	}
	
	public  static Object[][] blankall() {		//��questionbank2�еõ�������������Ϣ

		
		ResultSet rs = null;
		GetConn gc=new GetConn();				//�������ݿ�
		int c=0;
		int i=0;
		int flag=0;
		rs=gc.executeQuery("select ID from questionbank2 "); 	//ָ�����ݿ���questionbank2
		Object[][] blank=null;
		try {								//�õ�����������������c
			while(rs.next()){
				c++;
			}
			blank = new Object[c][5];
			rs=gc.executeQuery("select * from questionbank2 ");
			while(rs.next()){					//�����������Դ����blank������
			blank[i][0]=rs.getString("ID");		//�õ�������ID
			//String str="update questionbank2 set flag="+flag+" where ID='"+blank[i][0]+"'";
			//gc.executeUpdate(str);
			blank[i][1]=rs.getInt("grade");		//�õ�������������Ϣ
			blank[i][2]=rs.getInt("difficult");	//�õ��������Ѷ�����
			blank[i][3]=rs.getInt("chapter");	//�õ����������½�����
			blank[i][4]=rs.getInt("flag");
			i=i+1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gc.close();						//�ͷ���������
		return blank;					//���ش���������������Ϣ������
	}
	
	public  static Object[][] shortanswerall() {		//�����ݿ�questionbank3�еõ����м�������Ϣ

		
		ResultSet rs = null;
		GetConn gc=new GetConn();			//�������ݿ�
		int c=0;
		int i=0;
		int flag=0;
		rs=gc.executeQuery("select ID from questionbank3 ");
		Object[][] shortanswer=null;
		try {								//�õ�������������
			while(rs.next()){
				c++;
			}
			shortanswer = new Object[c][5];	//����һ��shortanswer��ά�������ڴ�ż������Ϣ
			rs=gc.executeQuery("select * from questionbank3 ");
			while(rs.next()){			//����������Ϣ�����shortanswer������
			shortanswer[i][0]=rs.getString("ID");			//��ȡ�����ID
			//String str="update questionbank3 set flag="+flag+" where ID='"+shortanswer[i][0]+"'";
			//gc.executeUpdate(str);					
			shortanswer[i][1]=rs.getInt("grade");			//��ȡ�����������Ϣ
			shortanswer[i][2]=rs.getInt("difficult");		//��ȡ������Ѷ���Ϣ
			shortanswer[i][3]=rs.getInt("chapter");			//��ȡ�������½���Ϣ
			shortanswer[i][4]=rs.getInt("flag");			
			i=i+1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gc.close();					//�ͷ����ݿ������
		return shortanswer;			//����һ����ż����������Ϣ������
	}
	
	
	public static Object[][] calculationall() {			//��questionbank4�еõ����еļ�������Ϣ

		
		ResultSet rs = null;
		GetConn gc=new GetConn();		//�������ݿ�
		int c=0;
		int i=0;
		int flag=0;
		rs=gc.executeQuery("select ID from questionbank4 ");
		Object[][] calculation=null;
		try {					//�õ��������������
			while(rs.next()){
				c++;
			}
			calculation = new Object[c][5];
			rs=gc.executeQuery("select * from questionbank4  ");
			while(rs.next()){				//���������������Ϣ�����calculation������
			calculation[i][0]=rs.getString("ID");		//�õ��������ID��
			//String str="update questionbank4 set flag="+flag+" where ID='"+calculation[i][0]+"'";
			//gc.executeUpdate(str);
			calculation[i][1]=rs.getInt("grade");		//�õ��������������Ϣ
			calculation[i][2]=rs.getInt("difficult");	//�õ���������Ѷ�������Ϣ
			calculation[i][3]=rs.getInt("chapter");		//�õ���������½�������Ϣ
			calculation[i][4]=rs.getInt("flag");		//
			i=i+1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gc.close();				//�ͷ����ݿ�����
		return calculation;		//����һ����ż�����������Ϣ�Ķ�ά����
	}
	
public  static Object[][] discussall() {		//��questionbank5�еõ����в�������������Ϣ

		
		ResultSet rs = null;
		GetConn gc=new GetConn();			//�������ݿ�
		int c=0;
		int i=0;
		int flag=0;
		rs=gc.executeQuery("select ID from questionbank5 ");
		Object[][] discuss=null;
		try {						//�õ��������������
			while(rs.next()){
				c++;
			}
			discuss = new Object[c][5];  //����һ����ά�����Ų�����������Ϣ
			rs=gc.executeQuery("select * from questionbank5 ");
			while(rs.next()){			//��������������Ϣ�����discuss��ά������
			discuss[i][0]=rs.getString("ID");		//�õ�������ID
			//String str="update questionbank5 set flag="+flag+" where ID='"+discuss[i][0]+"'";
			//gc.executeUpdate(str);					
			discuss[i][1]=rs.getInt("grade");		//�õ��������������Ϣ
			discuss[i][2]=rs.getInt("difficult");	//�õ���������Ѷ�������Ϣ
			discuss[i][3]=rs.getInt("chapter");		//�õ���������½�������Ϣ
			discuss[i][4]=rs.getInt("flag");		//
			i=i+1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gc.close();					//�ͷ����ݿ�����
		return discuss;				//����һ����Ų�����������Ϣ��discuss��ά����
	}
	
	public static int[] random(int all) {		//����������㷨����󷵻�һ��all�������������
		Random ran=new Random();			//��������ʼ��
		int a=0;
		int i;
		int temp;
		int random[]=new int[all];			//����һ�������������
		for(i=0;i<all;i++)					//���������ʼ��Ϊ0~��all-1��
		{
			random[i]=i;
		}
		
		for(i=0;i<all;i++)					//������������ɽ���������ң��õ��������������
		{
			a=ran.nextInt(all);
			temp=random[a];
			random[a]=random[i];
			random[i]=temp;
		}


		return random;					//��������鷵��
	}
	
	
	
	
	
	
	public static Object[][] testpaper(int typescore[],int typenumber[],int chapternumber[], int score,int difficult) {

		Popup pop=new Popup(4);
		JOptionPane.showMessageDialog(null, "����У����Եȣ�","��ӭ��", 1);
		int i=0;
		int j=0;
		int k=0;
		int alldifficult=0;//��ȡ�õ�����Ŀ�����Ѷ�
		int questionnum=0;//���ж�����Ŀ
		Object [][]judge =judgeall();//�����ݿ�õ������������
		Object [][]choose =chooseall();
		Object [][]blank =blankall();
		Object [][]shortanswer =shortanswerall();
		Object [][]calculation =calculationall();
		Object [][]discuss =discussall();

		Object [][]judge1=new Object[typenumber[0]][6];//judge1 �����ŵ���ѡ�񵽵���Ŀ
		Object [][]choose1 =new Object[typenumber[1]][6];
		Object [][]blank1 =new Object[typenumber[2]][6];
		Object [][]shortanswer1 =new Object[typenumber[3]][6];
		Object [][]calculation1 =new Object[typenumber[4]][6];
		Object [][]discuss1 =new Object[typenumber[5]][6];
		
		int judgelen=judge.length;	//�õ��������͵ĸ���
		int chooselen=choose.length;
		int blanklen=blank.length;
		int shortanswerlen=shortanswer.length;
		int calculationlen=calculation.length;
		int discusslen=discuss.length;
		
		int  []judgeran =random(judgelen);	//�����������������
		int  []chooseran=random(chooselen);
		int  []blankran=random(blanklen);
		int  []shortanswerran =random(shortanswerlen);
		int  []calculationran =random(calculationlen);
		int  []discussran =random(discusslen-1);

		
		int []count=new int[9];		//count�������ڴ����ʦָ�����½���Ŀ��
		
		
		for(i=0;i<9;i++)			//���½���Ŀ�������count������
		{
			count[i]=chapternumber[i];
		}
		
	
		j=0;
		// ��������͵������еõ����ѡ�еĸ�����
		for(i=0;i<typenumber[0];i++)	//����õ�����1����Ŀ��
		{
			do{
				for(k=0;k<9;k++)		//��ĳһ�½ڵ���Ŀ����Ϊ0֮�󣬵��Ǹ��Ⲣû�б�ѡ�У�����Ҫ��1�������������ѭ��
				{
					if(count[k]<0)
					{
						count[k]=count[k]+1;
					}
				}
				j++;
				judge1[i]=judge[(judgeran[j%(judgelen-1)])];		//�õ�һ������⸳��judge1[i]
				switch (Integer.parseInt(String.valueOf(judge1[i][3])))		//�жϸ�����½����ԣ���������½ڵ����ԣ����Ӧ���½���Ŀ����1
				{
				case 0:
					count[0]--;
					break;
				case 1:
					count[1]--;
					break;
				case 2:
					count[2]--;
					break;
				case 3:
					count[3]--;
					break;
				case 4:
					count[4]--;
					break;
				case 5:
					count[5]--;
					break;
				case 6:
					count[6]--;
					break;
				case 7:
					count[7]--;
					break;
				case 8:
					count[8]--;
					break;
				}
			}while((count[0]<0)||(count[1]<0)||(count[2]<0)||(count[3]<0)||(count[4]<0)||(count[5]<0)||(count[6]<0)||(count[7]<0)||(count[8]<0));
			//��ĳһ�½ڵ���Ŀ��С��0����ѡ��ʧ�ܣ�����ѡ��
		}
	
		j=0;		
		for(i=0;i<typenumber[1];i++)		//����õ�����Ϊ1����ѡ���⣬
		{
			do{
				j++;
				for(k=0;k<9;k++)		//��ѡ��һ��󣬸��½ڵ���������С��0��������˸��⣬�������ڲ�û��ѡ����⣬��count[k]+1������������ѭ��
				{
					if(count[k]<0)
					{
						count[k]=count[k]+1;
					}
				}
				
				choose1[i]=choose[chooseran[j%(chooselen-1)]];		//����õ�һ������Ϊѡ�������
				
				switch (Integer.parseInt(String.valueOf(choose1[i][3])))	//�жϸ�����½����ԣ���Ϊĳһ���½ڵ��⣬����½ڵ���Ŀ����1
				{
				case 0:
					count[0]--;
					break;
				case 1:
					count[1]--;
					break;
				case 2:
					count[2]--;
					break;
				case 3:
					count[3]--;
					break;
				case 4:
					count[4]--;
					break;
				case 5:
					count[5]--;
					break;
				case 6:
					count[6]--;
					break;
				case 7:
					count[7]--;
					break;
				case 8:
					count[8]--;
					break;
				}
			}while((count[0]<0)||(count[1]<0)||(count[2]<0)||(count[3]<0)||(count[4]<0)||(count[5]<0)||(count[6]<0)||(count[7]<0)||(count[8]<0));
		}//��ĳ���½ڵ���Ŀ������<0ʱ��������������ѡ
	
	
		j=0;
		for(i=0;i<typenumber[2];i++)		//����õ�����Ϊ2��������⣬
		{
			do{
				j++;
				for(k=0;k<9;k++)		//��ѡ��һ��󣬸��½ڵ���������С��0��������˸��⣬�������ڲ�û��ѡ����⣬��count[k]+1������������ѭ��
				{
					if(count[k]<0)
					{
						count[k]=count[k]+1;
					}
				}	
				blank1[i]=blank[blankran[j%(blanklen-1)]];		//����õ�һ������Ϊ��������
				switch (Integer.parseInt(String.valueOf(blank1[i][3])))		//�жϸ�����½����ԣ���Ϊĳһ�½ڵ��⣬����½ڶ�Ӧ����������1
				{
				case 0:
					count[0]--;
					break;
				case 1:
					count[1]--;
					break;
				case 2:
					count[2]--;
					break;
				case 3:
					count[3]--;
					break;
				case 4:
					count[4]--;
					break;
				case 5:
					count[5]--;
					break;
				case 6:
					count[6]--;
					break;
				case 7:
					count[7]--;
					break;
				case 8:
					count[8]--;
					break;
				}
			}while((count[0]<0)||(count[1]<0)||(count[2]<0)||(count[3]<0)||(count[4]<0)||(count[5]<0)||(count[6]<0)||(count[7]<0)||(count[8]<0));
		}	//��ĳһ�½ڵ�����������<0ʱ����������⣬����ѡ��
	
		

		
		for(i=0;i<typenumber[3];i++)		//����õ�����Ϊ3��������⣬
		{
			do{
				j++;
				for(k=0;k<9;k++)		//��ѡ��һ��󣬸��½ڵ���������С��0��������˸��⣬�������ڲ�û��ѡ����⣬��count[k]+1������������ѭ��
				{
					if(count[k]<0)
					{
						count[k]=count[k]+1;
					}
				}
				shortanswer1[i]=shortanswer[shortanswerran[j%(shortanswerlen-1)]];	//����õ�һ������Ϊ��������
				switch (Integer.parseInt(String.valueOf(shortanswer1[i][3])))	//�жϸ�����½����ԣ���ĳ���½ڵ��⣬����½ڶ�Ӧ������������1
				{
				case 0:
					count[0]--;
					break;
				case 1:
					count[1]--;
					break;
				case 2:
					count[2]--;
					break;
				case 3:
					count[3]--;
					break;
				case 4:
					count[4]--;
					break;
				case 5:
					count[5]--;
					break;
				case 6:
					count[6]--;
					break;
				case 7:
					count[7]--;
					break;
				case 8:
					count[8]--;
					break;
				}
			}while((count[0]<0)||(count[1]<0)||(count[2]<0)||(count[3]<0)||(count[4]<0)||(count[5]<0)||(count[6]<0)||(count[7]<0)||(count[8]<0));
		}		//��ĳ�½ڵ���������<0�£���������⣬����ѡ��
		
		for(i=0;i<typenumber[4];i++)	//����õ�����Ϊ4���������⣬
		{
			
			do{
				j++;
				for(k=0;k<9;k++)	//��ѡ��һ��󣬸��½ڵ���������С��0��������˸��⣬�������ڲ�û��ѡ����⣬��count[k]+1������������ѭ��
				{
					if(count[k]<0)
					{
						count[k]=count[k]+1;
					}
				}
				calculation1[i]=calculation[calculationran[j%(calculationlen-1)]];//����õ�һ������Ϊ���������
				switch (Integer.parseInt(String.valueOf(calculation1[i][3])))	//�жϸ�����½����ԣ���ĳ���½ڵ��⣬����½ڶ�Ӧ������������1
				{
				case 0:
					count[0]--;
					break;
				case 1:
					count[1]--;
					break;
				case 2:
					count[2]--;
					break;
				case 3:
					count[3]--;
					break;
				case 4:
					count[4]--;
					break;
				case 5:
					count[5]--;
					break;
				case 6:
					count[6]--;
					break;
				case 7:
					count[7]--;
					break;
				case 8:
					count[8]--;
					break;
				}
			}while((count[0]<0)||(count[1]<0)||(count[2]<0)||(count[3]<0)||(count[4]<0)||(count[5]<0)||(count[6]<0)||(count[7]<0)||(count[8]<0));
		}	//��ĳ�½ڵ���������<0�£���������⣬����ѡ��
	
		for(i=0;i<typenumber[5];i++)		//����õ�����Ϊ5���������⣬
		{
			do{
				j++;
				for(k=0;k<9;k++)		//��ѡ��һ��󣬸��½ڵ���������С��0��������˸��⣬�������ڲ�û��ѡ����⣬��count[k]+1������������ѭ��
				{
					if(count[k]<0)
					{
						count[k]=count[k]+1;
					}
				}
				discuss1[i]=discuss[discussran[j%(discusslen-1)]];			//����õ�һ������Ϊ���������
				switch (Integer.parseInt(String.valueOf(discuss1[i][3])))	//�жϸ�����½����ԣ���ĳ���½ڵ��⣬����½ڶ�Ӧ������������1
				{
				case 0:
					count[0]--;
					break;
				case 1:
					count[1]--;
					break;
				case 2:
					count[2]--;
					break;
				case 3:
					count[3]--;
					break;
				case 4:
					count[4]--;
					break;
				case 5:
					count[5]--;
					break;
				case 6:
					count[6]--;
					break;
				case 7:
					count[7]--;
					break;
				case 8:
					count[8]--;
					break;
				}
			}while((count[0]<0)||(count[1]<0)||(count[2]<0)||(count[3]<0)||(count[4]<0)||(count[5]<0)||(count[6]<0)||(count[7]<0)||(count[8]<0));
		}	//��ĳ�½ڵ���������<0�£���������⣬����ѡ��
	
	
		
		for(i=0;i<6;i++)			//questionnum���ڴ���Ծ����������Ŀ
		{
			questionnum=questionnum+typenumber[i];
		}
	
		
		Object [][]allquestion=new Object[questionnum][6];		//allquestion��ά�������ڴ�������������
		for(i=0;i<typenumber[0];i++)		//������Ϊ�ж������������allquestion������
		{
			allquestion[i]=judge1[i];
		}
			
		for(;i<typenumber[0]+typenumber[1];i++)		//������Ϊѡ�������������allquestion��
		{
			allquestion[i]=choose1[i-(typenumber[0])];
		}
		for(;i<typenumber[0]+typenumber[1]+typenumber[2];i++)		//������Ϊ��������������allquestion
		{
			allquestion[i]=blank1[i-(typenumber[0]+typenumber[1])];
		}
		for(;i<typenumber[0]+typenumber[1]+typenumber[2]+typenumber[3];i++)		//������Ϊ��������������allquestion��
		{
			allquestion[i]=shortanswer1[i-(typenumber[0]+typenumber[1]+typenumber[2])];
		}
		
		for(;i<typenumber[0]+typenumber[1]+typenumber[2]+typenumber[3]+typenumber[4];i++)	//������Ϊ���������������allquestion
		{
			allquestion[i]=calculation1[i-(typenumber[0]+typenumber[1]+typenumber[2]+typenumber[3])];
		}
		for(;i<typenumber[0]+typenumber[1]+typenumber[2]+typenumber[3]+typenumber[4]+typenumber[5];i++)	//������Ϊ���������������allquestion��
		{
			allquestion[i]=discuss1[i-(typenumber[0]+typenumber[1]+typenumber[2]+typenumber[3]+typenumber[4])];
		}
	
		//���ˣ���������Ŀ��������Ϣ��ȫ�������allquestion��ά�����У����濪ʼƥ���Ѷ�����
		for(i=0;i<questionnum;i++)		//������������Ѷ�֮�ͣ����������Ծ��Ѷ�ϵ��
		{
			alldifficult+=(Integer.parseInt(String.valueOf(allquestion[i][2])));

		}
	
		int [] allquestionran=random(questionnum);		//�õ�һ���������allquestionran
		Object [][]temp=null;
		ResultSet rs = null;
		GetConn gc=new GetConn();		//�������ݿ�
		int c=0;
		i=0;
		
		while(alldifficult<(2*questionnum*(difficult)/5))		//�������Ծ���Ѷ�ϵ��С��Ҫ����Ѷȷ�Χ�������Ѷ�ϵ��������滻�Ѷ�ϵ��С����
		{
			i++;
		
			if((Integer.parseInt(String.valueOf(allquestion[(allquestionran[i%questionnum])][2])))<2)//ѡ���Ѷ�ϵ��С��2���⣬�ù��滻
			{
				
				switch(Integer.parseInt(String.valueOf(allquestion[(allquestionran[i%questionnum])][1])))	//�жϸ�����������ԣ��Ա�ȷ�����ĸ����ݿ�ȡ��
				{
					case 0: 		
					c=0;
					rs=gc.executeQuery("select * from questionbank0 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=2");//ѡ�������½����Ժ��Ѷ����Ե�����
					try {
						while(rs.next()){		//�õ���������Ե�������
							c++;
						}
						temp = new Object[c][5];
						j=0;
						rs=gc.executeQuery("select * from questionbank0 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=2");
						while(rs.next()){			//��temp������ѡ�������������ID�����ͣ��Ѷȣ��½ڣ�
							temp[j][0]=rs.getString("ID");		//ѡ�������ID
							temp[j][1]=rs.getInt("grade");		//ѡ�����������
							temp[j][2]=rs.getInt("difficult");	//ѡ��������Ѷ����Դ��
							temp[j][3]=rs.getInt("chapter");	//ѡ��������½����Դ��
							temp[j][4]=rs.getInt("flag");
							j=j+1;
							}
					} catch (SQLException e) {
						e.printStackTrace();
					}
		
			
					int []tempran1=random(c);
					allquestion[(allquestionran[i%questionnum])]=temp[tempran1[i%c]];	//���õ��ķ���Ҫ�������ԭ�⽻��
					alldifficult=0;
					for(k=0;k<questionnum;k++)		//���¼��������Ծ��Ѷȣ��ٴν���ѭ���������������������ٴλ���
					{
						alldifficult+=(Integer.parseInt(String.valueOf(allquestion[k][2])));

					}	
				
					break;
					
					case 1: 	
						c=0;
						rs=gc.executeQuery("select * from questionbank1 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=2");//ѡ�������½����Ժ��Ѷ����Ե�����
						try {
							while(rs.next()){		//�õ�����Ҫ�������������
								c++;
							}
							temp = new Object[c][5];
							j=0;
							rs=gc.executeQuery("select * from questionbank1 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=2");
							while(rs.next()){		//��temp������ѡ�������������ID�����ͣ��Ѷȣ��½ڣ�
								temp[j][0]=rs.getString("ID");		//ȡ������ID
								temp[j][1]=rs.getInt("grade");		//ȡ���������������
								temp[j][2]=rs.getInt("difficult");	//ȡ��������Ѷ�����
								temp[j][3]=rs.getInt("chapter");	//ȡ��������½ڵ�����
								temp[j][4]=rs.getInt("flag");
								j=j+1;
								}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						int []tempran2=random(c);
						allquestion[(allquestionran[i%questionnum])]=temp[tempran2[i%c]];		//���õ��ķ���Ҫ�������ԭ�⻥��
						alldifficult=0;		//���Ծ��Ѷ�ϵ������
						for(k=0;k<questionnum;k++)	//���¼����Ծ���Ѷ�ϵ�����ٴν���ѭ���������������������ٴλ���
						{
							alldifficult+=(Integer.parseInt(String.valueOf(allquestion[k][2])));

						}	
						break;
						

					case 2: 	
						c=0;
						rs=gc.executeQuery("select * from questionbank2 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=2");//ѡ�������½����Ժ��Ѷ����Ե�����
						try {
							while(rs.next()){		//�õ����������������������
								c++;
							}
							temp = new Object[c][5];
							j=0;
							rs=gc.executeQuery("select * from questionbank2 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=2");
							while(rs.next()){	//��temp������ѡ�������������ID�����ͣ��Ѷȣ��½ڣ�
								temp[j][0]=rs.getString("ID");		//ȡ�������ID��
								temp[j][1]=rs.getInt("grade");		//����������½�����
								temp[j][2]=rs.getInt("difficult");	//ȡ��������Ѷ�����
								temp[j][3]=rs.getInt("chapter");	//ȡ��������½�����
								temp[j][4]=rs.getInt("flag");		//
								j=j+1;
								}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						int []tempran3=random(c);
						allquestion[(allquestionran[i%questionnum])]=temp[tempran3[i%c]];	//���õ��ķ���Ҫ���������ԭ�⻥��
						alldifficult=0;		//���������Ѷ�����
						for(k=0;k<questionnum;k++)		////���¼����Ծ���Ѷ�ϵ�����ٴν���ѭ���������������������ٴλ���
						{
							alldifficult+=(Integer.parseInt(String.valueOf(allquestion[k][2])));

						}	
						break;
						

					case 3: 	
						c=0;
						rs=gc.executeQuery("select * from questionbank3 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=2");
						try {
							while(rs.next()){//�õ����������������������
								c++;
							}
							temp = new Object[c][5];
							j=0;
							rs=gc.executeQuery("select * from questionbank3 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=2");
							while(rs.next()){//��temp������ѡ�������������ID�����ͣ��Ѷȣ��½ڣ�
								temp[j][0]=rs.getString("ID");	//ȡ��ʵ���ID��
								temp[j][1]=rs.getInt("grade");	//ȡ���������������
								temp[j][2]=rs.getInt("difficult");	//ȡ��������Ѷ�����
								temp[j][3]=rs.getInt("chapter");	//ȡ��������½�����
								temp[j][4]=rs.getInt("flag");		//
								j=j+1;
								}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						int []tempran4=random(c);	
						allquestion[(allquestionran[i%questionnum])]=temp[tempran4[i%c]];		//���ĵ��·���Ҫ���������ԭ�⻥��
						alldifficult=0;		//���Ծ��Ѷ�����
						for(k=0;k<questionnum;k++)		//���¼����Ծ���Ѷ�ϵ�����ٴν���ѭ���������������������ٴλ���
						{
							alldifficult+=(Integer.parseInt(String.valueOf(allquestion[k][2])));

						}	
						break;
						

					case 4: 	
						c=0;
						rs=gc.executeQuery("select * from questionbank4 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=2");//ѡ�������½����Ժ��Ѷ����Ե�����
						try {
							while(rs.next()){	//�õ�����Ҫ�������������
								c++;
							}
							temp = new Object[c][5];
							j=0;
							rs=gc.executeQuery("select * from questionbank4 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=2");
							while(rs.next()){		//��temp���������������������Ϣ
								temp[j][0]=rs.getString("ID");		//ȡ������ID��
								temp[j][1]=rs.getInt("grade");		//ȡ�������������Ϣ
								temp[j][2]=rs.getInt("difficult");	//ȡ��������Ѷ�������Ϣ
								temp[j][3]=rs.getInt("chapter");	//ȡ��������½�������Ϣ	
								temp[j][4]=rs.getInt("flag");		//
								j=j+1;
								}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						int []tempran5=random(c);
						allquestion[(allquestionran[i%questionnum])]=temp[tempran5[i%c]];	//��ѡ���ķ���Ҫ���������ԭ�⻥��
						alldifficult=0;		//���Ծ��Ѷ�ϵ������
						for(k=0;k<questionnum;k++)	//���¼����Ծ��Ѷȣ��ٴν���ѭ���������������������ٴλ���
						{
							alldifficult+=(Integer.parseInt(String.valueOf(allquestion[k][2])));

						}	
						break;
						
					case 5: 	
						c=0;
						rs=gc.executeQuery("select * from questionbank5 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=2");	//ѡ�������½����Ժ��Ѷ����Ե�����
						try {
							while(rs.next()){		//�������Ҫ�����������������
								c++;
							}
							temp = new Object[c][5];
							j=0;
							rs=gc.executeQuery("select * from questionbank5 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=2");
							while(rs.next()){//��temp������ѡ�������������ID�����ͣ��Ѷȣ��½ڣ�
								temp[j][0]=rs.getString("ID");		//ȡ���õ������ID��
								temp[j][1]=rs.getInt("grade");		//ȡ���õ��������������
								temp[j][2]=rs.getInt("difficult");	//ȡ���õ�������Ѷ�����
								temp[j][3]=rs.getInt("chapter");	//ȡ���õ�ʵ����½�����
								temp[j][4]=rs.getInt("flag");
								j=j+1;
								}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						int []tempran6=random(c);
						allquestion[(allquestionran[i%questionnum])]=temp[tempran6[i%c]];		//���õ��ķ���Ҫ���������ԭ�⻥��
						alldifficult=0;		//���Ծ���Ѷ�ϵ������
						for(k=0;k<questionnum;k++)		//���¼����Ծ��Ѷȣ��ٴν���ѭ���������������������ٴλ���
						{
							alldifficult+=(Integer.parseInt(String.valueOf(allquestion[k][2])));

						}	
						break;
					
						
					
					
				}
				
			}
		}
		
		c=0;
		i=0;
		while(alldifficult>=(2*questionnum*(difficult+1)/5))		//���Ծ�����Ѷȴ���ָ�����Ѷȷ�Χ�������Ѷ�ϵ����С����ȥ�滻�Ѷ�ϵ���ϴ���⣬ֱ���Ծ��Ѷ��ڷ�Χ����
		{
			i++;
		
			if((Integer.parseInt(String.valueOf(allquestion[(allquestionran[i%questionnum])][2])))>0)		//ѡ���������Ѷ�ϵ������0�����⣬�Ա��滻
			{
				
				switch((Integer.parseInt(String.valueOf(allquestion[(allquestionran[i%questionnum])][1]))))		//�жϸ�����������ԣ���ȷ�����ĸ���������л�ȡ����
				{
					case 0: 		
					c=0;
					rs=gc.executeQuery("select * from questionbank0 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=0");	//ѡ�������Ѷ�����Ҫ����½�����Ҫ�������
					try {
						while(rs.next()){		//����õ�����Ҫ���������
							c++;
						}
						temp = new Object[c][5];
						j=0;
						rs=gc.executeQuery("select * from questionbank0 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=0");
						while(rs.next()){		//���õ�������Ҫ�����������temp������
							temp[j][0]=rs.getString("ID");		//�õ�ʵ���ID��
							temp[j][1]=rs.getInt("grade");		//�õ��������������
							temp[j][2]=rs.getInt("difficult");	//�õ�������Ѷ�������Ϣ
							temp[j][3]=rs.getInt("chapter");	//�õ�������½�������Ϣ
							temp[j][4]=rs.getInt("flag");
							j=j+1;
							}
					} catch (SQLException e) {
						e.printStackTrace();
					}
		
			
					int []tempran1=random(c);
					allquestion[(allquestionran[i%questionnum])]=temp[tempran1[i%c]];	//������õ��ķ���Ҫ���ĳ��������ԭ�⻥��
					alldifficult=0;
					for(k=0;k<questionnum;k++)		//���¼����Ծ���Ѷ�ϵ����������ѭ������Ҫ����Ծ��Ѷȷ�Χ�Ƚϣ�������Ҫ�������ɹ��������������
					{
						alldifficult+=(Integer.parseInt(String.valueOf(allquestion[k][2])));

					}	
				
					break;
					
					case 1: 	
						c=0;
						rs=gc.executeQuery("select * from questionbank1 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=0");//ѡ�������Ѷ�����Ҫ����½�����Ҫ�������
						try {
							while(rs.next()){		//�������Ҫ�������������
								c++;
							}
							temp = new Object[c][5];
							j=0;
							rs=gc.executeQuery("select * from questionbank1 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=0");
							while(rs.next()){		//������Ҫ�����������temp������
								temp[j][0]=rs.getString("ID");		//ȡ�������ID��
								temp[j][1]=rs.getInt("grade");		//ȡ�����������������Ϣ
								temp[j][2]=rs.getInt("difficult");	//ȡ��ʵ����Ѷ�������Ϣ
								temp[j][3]=rs.getInt("chapter");	//ȡ��������½�������Ϣ
								temp[j][4]=rs.getInt("flag");
								j=j+1;
								}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						int []tempran2=random(c);
						allquestion[(allquestionran[i%questionnum])]=temp[tempran2[i%c]];		//������õ���һ������Ҫ���������ԭ�⻥��
						alldifficult=0;
						for(k=0;k<questionnum;k++)	//���¼����Ծ�����Ѷ�ϵ����������ѭ������Ҫ����Ծ��Ѷȷ�Χ�Ƚϣ�������Ҫ�������ɹ��������������
						{
							alldifficult+=(Integer.parseInt(String.valueOf(allquestion[k][2])));

						}	
						break;
						

					case 2: 	
						c=0;
						rs=gc.executeQuery("select * from questionbank2 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=0");//ѡ�������Ѷ�����Ҫ����½�����Ҫ�������
						try {
							while(rs.next()){	//�������Ҫ�������������
								c++;
							}
							temp = new Object[c][5];
							j=0;
							rs=gc.executeQuery("select * from questionbank2 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=0");
							while(rs.next()){		//��temp�����ŷ���Ҫ�����������
								temp[j][0]=rs.getString("ID");	//ȡ��ʵ���ID�Ŵ��
								temp[j][1]=rs.getInt("grade");	//ȡ�����������������Ϣ���
								temp[j][2]=rs.getInt("difficult");	//ȡ��������Ѷ���Ϣ�洢
								temp[j][3]=rs.getInt("chapter");	//ȡ��������½�������Ϣ
								temp[j][4]=rs.getInt("flag");
								j=j+1;
								}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						int []tempran3=random(c);
						allquestion[(allquestionran[i%questionnum])]=temp[tempran3[i%c]];		//��ѡ���ķ���Ҫ�����������õ�һ����ԭ�⻥��
						alldifficult=0;		//���Ծ���Ѷ�ϵ������
						for(k=0;k<questionnum;k++)		//���¼����Ծ�����Ѷ�ϵ����������ѭ������Ҫ����Ծ��Ѷȷ�Χ�Ƚϣ�������Ҫ�������ɹ��������������
						{
							alldifficult+=(Integer.parseInt(String.valueOf(allquestion[k][2])));

						}	
						break;
						

					case 3: 	
						c=0;
						rs=gc.executeQuery("select * from questionbank3 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=0");
						try {
							while(rs.next()){		//�������Ҫ��������������
								c++;
							}
							temp = new Object[c][5];
							j=0;
							rs=gc.executeQuery("select * from questionbank3 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=0");
							while(rs.next()){		//��temp�������Ծ��������Ϣ
								temp[j][0]=rs.getString("ID");		//ȡ�������ID��
								temp[j][1]=rs.getInt("grade");		//ȡ�����������������Ϣ
								temp[j][2]=rs.getInt("difficult");	//ȡ��������Ѷ�������Ϣ
								temp[j][3]=rs.getInt("chapter");	//ȡ��������½�������Ϣ
								temp[j][4]=rs.getInt("flag");		//
								j=j+1;
								}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						int []tempran4=random(c);
						allquestion[(allquestionran[i%questionnum])]=temp[tempran4[i%c]];	// ����õ�һ������Ҫ���������ԭ�⻥��
						alldifficult=0;		//���Ծ��Ѷ�ϵ������
						for(k=0;k<questionnum;k++)		////���¼����Ծ�����Ѷ�ϵ����������ѭ������Ҫ����Ծ��Ѷȷ�Χ�Ƚϣ�������Ҫ�������ɹ��������������
						{
							alldifficult+=(Integer.parseInt(String.valueOf(allquestion[k][2])));

						}	
						break;
						

					case 4: 	
						c=0;
						rs=gc.executeQuery("select * from questionbank4 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=0");//ѡ�������Ѷ�����Ҫ����½�����Ҫ�������
						try {
							while(rs.next()){		//���������Ҫ�������������
								c++;
							}
							temp = new Object[c][5];
							j=0;
							rs=gc.executeQuery("select * from questionbank4 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=0");
							while(rs.next()){//��temp�������Ծ��������Ϣ
								temp[j][0]=rs.getString("ID");		//ȡ�������ID��
								temp[j][1]=rs.getInt("grade");		//ȡ�����������������Ϣ
								temp[j][2]=rs.getInt("difficult");	//ȡ��������Ѷ�������Ϣ
								temp[j][3]=rs.getInt("chapter");	//ȡ��������½�������Ϣ
								temp[j][4]=rs.getInt("flag");
								j=j+1;
								}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						int []tempran5=random(c);
						allquestion[(allquestionran[i%questionnum])]=temp[tempran5[i%c]];	//����õ�һ������Ҫ���������ԭ�⻥��
						alldifficult=0;		//���Ծ���Ѷ�ϵ������
						for(k=0;k<questionnum;k++)		//���¼����Ծ�����Ѷ�ϵ����������ѭ������Ҫ����Ծ��Ѷȷ�Χ�Ƚϣ�������Ҫ�������ɹ��������������
						{
							alldifficult+=(Integer.parseInt(String.valueOf(allquestion[k][2])));

						}	
						break;
						
					case 5: 	
						c=0;
						rs=gc.executeQuery("select * from questionbank5 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=0 ");//ѡ�������Ѷ�����Ҫ����½�����Ҫ�������
						try {
							while(rs.next()){		//����õ�����Ҫ�����������Ŀ��
								c++;
							}
							temp = new Object[c][5];		//
							j=0;
							rs=gc.executeQuery("select * from questionbank5 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=0");
							while(rs.next()){			//ȡ������Ҫ����������Դ����temp������
								temp[j][0]=rs.getString("ID");		//ȡ������ID��
								temp[j][1]=rs.getInt("grade");		//ȡ�������������Ϣ
								temp[j][2]=rs.getInt("difficult");	//ȡ������������Ѷ���Ϣ
								temp[j][3]=rs.getInt("chapter");	//ȡ��������½�������Ϣ
								temp[j][4]=rs.getInt("flag");
								j=j+1;
								}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						int []tempran6=random(c);
						allquestion[(allquestionran[i%questionnum])]=temp[tempran6[i%c]];		//����õ�һ������Ҫ���������ԭ�⻥��
						alldifficult=0;		//���Ѷ�ϵ������
						for(k=0;k<questionnum;k++)			//���¼����Ծ�����Ѷ�ϵ����������ѭ������Ҫ����Ծ��Ѷȷ�Χ�Ƚϣ�������Ҫ�������ɹ��������������
						{
							alldifficult+=(Integer.parseInt(String.valueOf(allquestion[k][2])));

						}	
						break;
					
						
					
					
				}
				
			}
		}
	
		pop.dispose();
		return allquestion;		//����ȡ��������Ķ�ά����
		
	}
	
}
	
	
	
	

