package login;

import java.sql.ResultSet;
import java.sql.SQLException;
/**�����Ծ������,�������ֶ����ݿ�Ĳ�������*/
public class OperateQuestion {
	//������������Ͷ��������͵����������������Ϣ
	public static  Object[][] selectAllQuestion(int type) throws Exception{
		ResultSet rs = null;
		GetConn gc=new GetConn();
		int c=0;
		int i=0;
		rs=gc.executeQuery("select ID from questionbank"+type+" ");
		while(rs.next()){
			c++;//ȷ��������Ŀ
		}
		Object[][] b=new Object[c][8];
		rs=gc.executeQuery("select * from questionbank"+type+" ");
		while(rs.next()){//����������Ϣ
		b[i][0]=rs.getString("ID");
		b[i][2]=rs.getString("difficult");
		b[i][3]=rs.getString("chapter");
		b[i][4]=rs.getString("content");
		b[i][5]=rs.getString("answer");
		b[i][6]=rs.getString("note");
		b[i][1]=rs.getString("grade");
		i=i+1;
		}
		gc.close();
		return b;
		}
	//��ȡ��ϰ��,ֻ���������,�𰸺�ͼƬ
	public static  Object[] lxt(int type,String id) throws Exception{
		ResultSet rs = null;
		GetConn gc=new GetConn();
		Object[] b=new Object[3];
		rs=gc.executeQuery("select * from questionbank"+type+" ");
		while(rs.next()){
			if(id.equals(rs.getString("ID"))){
		b[2]=rs.getString("image");
		b[0]=rs.getString("content");
		b[1]=rs.getString("answer");
			}
		}
		gc.close();
		return b;
		}
	//����������Ծ���,���Ҷ�Ӧ�Ŀ�����Ϣ��,���������Ϣ
	public static  Object[][] selectAlldajuan(String name) throws Exception{
		ResultSet rs = null;
		GetConn gc=new GetConn();
		int c=0;
		int i=0;
		rs=gc.executeQuery("select id from "+name+" ");
		while(rs.next()){
			c++;
		}
		Object[][] b=new Object[c][6];
		rs=gc.executeQuery("select * from "+name+" ");//�ӿ�����Ϣ���ж�ȡ��Ϣ
		while(rs.next()){
		b[i][0]=rs.getString("id");//����ѧ��
		b[i][1]=rs.getString("name");//��������
		b[i][2]=rs.getString("answer");//�������
		b[i][3]=rs.getString("score");//�����ܷ�
		b[i][4]=rs.getString("kgtanswer");//�����͹����,�Զ��ľ��õ�
		b[i][5]=rs.getString("kgtscore");//�����Ŀ͹���÷�,�Զ��ľ����
		i=i+1;
		}
		gc.close();
		return b;
		}
	//ѡ��ָ���ı��ο����Ծ�
	public static  String[] selectflag() throws Exception{
		ResultSet rs = null;
		GetConn gc=new GetConn();
	//	int flag=1;
		String[] b=new String[18];
		rs=gc.executeQuery("select * from shijuan ");
		while(rs.next()){
		if(rs.getString("flag").equals("1")){//ѡ����־λΪ1�ı��ο����Ծ�
			
		b[0]=rs.getString("SJID");//�Ծ���
		b[4]=rs.getString("T0ID");//����0����������������
		b[1]=rs.getString("difficult");//�Ծ��Ѷ�
		b[5]=rs.getString("T1ID");//����1����������������
		b[6]=rs.getString("T2ID");//����2����������������
		b[7]=rs.getString("T3ID");//����3����������������
		b[8]=rs.getString("T4ID");//����4����������������
		b[9]=rs.getString("T5ID");//����5����������������
		b[3]=rs.getString("flag");//��־λ
		b[2]=rs.getString("score");//�Ծ��ܷ�
		b[10]=rs.getString("time");//����ʱ��
		b[11]=rs.getString("score0");//����0����
		b[12]=rs.getString("score1");//����1����
		b[13]=rs.getString("score2");//����2����
		b[14]=rs.getString("score3");//����3����
		b[15]=rs.getString("score4");//����4����
		b[16]=rs.getString("score5");//����5����
		b[17]=rs.getString("kgtscore");//�͹����ܷ�
		}
		}
		gc.close();
		return b;
		}
	//�����Ծ��,�õ������Ծ���Ϣ
	public static  Object[][] selectAllshijuan() throws Exception{
		ResultSet rs = null;
		GetConn gc=new GetConn();
		int c=0;
		int i=0;
		rs=gc.executeQuery("select SJID from shijuan ");
		while(rs.next()){
			c++;
		}
		Object[][] b=new Object[c][18];
		rs=gc.executeQuery("select * from shijuan ");
		while(rs.next()){
		b[i][0]=rs.getString("SJID");//�Ծ���
		b[i][4]=rs.getString("T0ID");//�����͵�������
		b[i][1]=rs.getString("difficult");//�Ѷ�
		b[i][5]=rs.getString("T1ID");
		b[i][6]=rs.getString("T2ID");
		b[i][7]=rs.getString("T3ID");
		b[i][8]=rs.getString("T4ID");
		b[i][9]=rs.getString("T5ID");
		b[i][3]=rs.getString("flag");//�Ƿ�ָ��Ϊ���ο����Ծ�
		b[i][2]=rs.getString("score");//�Ծ��ܷ�
		b[i][10]=rs.getString("time");//����ʱ��
		b[i][11]=rs.getString("score0");//�����ͷ���
		b[i][12]=rs.getString("score1");
		b[i][13]=rs.getString("score2");
		b[i][14]=rs.getString("score3");
		b[i][15]=rs.getString("score4");
		b[i][16]=rs.getString("score5");
		b[i][17]=rs.getString("kgtscore");//�͹����ܷ�
		i=i+1;
		}
		gc.close();
		return b;
		}
	//ɾ��ĳһ����������е���Ŀ
	public static int Delete(int type,String id){
		GetConn gc=new GetConn();
		String str="delete from questionbank"+type+" where id='"+id+"'";
		int result=gc.executeUpdate(str);
		return result;
	}
	//����������������
	public int Add(int type,String id,int grade,int difficult,int chapter,String content,String answer,String note){
		GetConn gc=new GetConn();
		String str="insert into questionbank"+type+" (id,grade,difficult,chapter,content,answer,note)" +
				"values('"+id+"','"+grade+"','"+difficult+"','"+chapter+"','"+content+"','"+answer+"','"+note+"')";
	    int result=gc.executeUpdate(str);
	    return result;
	}
	//����ת���ַ���,�Կո����
    public static String toString(Object[] a) {
        String b=(String)a[0];
   
        for (int i = 1; i<a.length; i++) {
        	if(a[i] != null)
              b=b+" "+a[i];
        }
        return b;
    }
		//���ݸ������Ծ���,�ó������Ծ������,�𰸵���Ϣ
	public static String[] zujuan(String id1,int ti) {
		String [] shijuanchakan=new String[8];
		shijuanchakan[6]="\n";
		
		Object[][] shijuan;
	    try {
				shijuan= OperateQuestion.selectAllshijuan();
		} 
	    catch (Exception e) {
				shijuan = null;
				e.printStackTrace();
		}
			
		String[] cxshiti1=new String[6];
		int i,j;
		for (i = 0,j=0; i < shijuan.length; i++) {
			if (shijuan[i][0].equals(id1)) {//�����ҵ��Ծ��ÿ�����͵�������Ŀ�ı�Ŷ�����
				
			    cxshiti1[0]=(String) shijuan[i][4];
			    cxshiti1[1]= (String)shijuan[i][5];
			    cxshiti1[2]= (String)shijuan[i][6];
			    cxshiti1[3]= (String)shijuan[i][7];
			    cxshiti1[4]= (String)shijuan[i][8];
			    cxshiti1[5]=(String) shijuan[i][9];
			}
		}	
		//cxshiti1���ݱ����˸��Ծ��������������
		System.out.println(cxshiti1[0]);
		
		String[] ty0 =cxshiti1[0].split(" ");//�������ַ�����ԭ������������
		String[] ty1 =cxshiti1[1].split(" ");
		String[] ty2 =cxshiti1[2].split(" ");
		String[] ty3 =cxshiti1[3].split(" ");
		String[] ty4 =cxshiti1[4].split(" ");
		String[] ty5 =cxshiti1[5].split(" ");
	
		for(int heke=0;heke<ty0.length;heke++)
			System.out.println(ty0[heke]);
		
		shijuanchakan[0]= Integer.toString(ty0.length);//�������͵��������
		shijuanchakan[1]= Integer.toString(ty1.length);
		shijuanchakan[2]= Integer.toString(ty2.length);
		shijuanchakan[3]= Integer.toString(ty3.length);
		shijuanchakan[4]= Integer.toString(ty4.length);
		shijuanchakan[5]= Integer.toString(ty5.length);
		

		
	/*	String heke1="select content from questionbank0";
		GetConn gc=new GetConn();
		ResultSet rs=gc.executeQuery(heke1);
		try {
			rs.next();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			System.out.println(rs.getString("content"));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
*/
		
		
		System.out.println(shijuanchakan[0]);
		
		String []kgtdaan=new String[ty0.length+ty1.length];
		
	/*	Object[][] shiti0;
	    try {
			shiti0 = OperateQuestion.selectAllQuestion(0);
		} catch (Exception e) {
			shiti0 = null;
			e.printStackTrace();
		}
	    //t0������������Ϣ
		String t0="\n\nһ���ж���\n\n";
		for(j=0;j<ty0.length;j++){
			for (i = 0; i < shiti0.length; i++) {
				if (shiti0[i][0].equals(ty0[j]))
				{
					t0+=(j+1)+"."+(String) shiti0[i][ti];//��ȡ��Ҫ��������Ŀ���ߴ�
					t0+="\n";
					if(ti==5)
					{
						String ii=(String) shiti0[i][5];//��ȡ�͹����
						kgtdaan[j]=ii.trim();
					}
				}
			}
		}	*/
		long start=System.currentTimeMillis();
		String t0=null,t1=null,t2=null,t3=null,t4=null,t5=null;
		if(ti==4)
		{
			GetConn gc=new GetConn();
			ResultSet rs=null;
			
			String []strTemp=new String[10];
			String str1="select content from questionbank0 where id in(";
			for(j=0;j<ty0.length-1;j++)
			{
				str1+=""+ty0[j]+",";
			}
			str1+=""+ty0[j]+")";
			rs=gc.executeQuery(str1);
			j=0;
			try {
				while(rs.next())
				{
					strTemp[j]=(String)rs.getString("content");
					System.out.println(strTemp[j]);
					j++;
				}
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			t0="\n\nһ���ж���\n\n";
			for(j=0;j<ty0.length;j++)
			{
				t0+=(j+1)+"."+strTemp[j];
				t0+="\n";
	
			}
			//System.out.println(t0);
			
			str1="select content from questionbank1 where id in(";
			for(j=0;j<ty1.length-1;j++)
			{
				str1+=""+ty1[j]+",";
			}
			str1+=""+ty1[j]+")";
			rs=gc.executeQuery(str1);
			j=0;
			try {
				while(rs.next())
				{
					strTemp[j]=(String)rs.getString("content");
					System.out.println(strTemp[j]);
					j++;
				}
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			t1="\n\n����ѡ����\n\n";
			for(j=0;j<ty1.length;j++)
			{
	
				t1+=(j+1)+"."+strTemp[j];
				t1+="\n";
			
			}
			//System.out.println(t1);
			
			
			str1="select content from questionbank2 where id in(";
			for(j=0;j<ty2.length-1;j++)
			{
				str1+=""+ty2[j]+",";
			}
			str1+=""+ty2[j]+")";
			rs=gc.executeQuery(str1);
			j=0;
			try {
				while(rs.next())
				{
					strTemp[j]=(String)rs.getString("content");
					System.out.println(strTemp[j]);
					j++;
				}
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			t2="\n\n���������\n\n";
			for(j=0;j<ty2.length;j++)
			{

				t2+=(j+1)+"."+strTemp[j];
				t2+="\n";
		
			}
			//System.out.println(t2);
			
			
			str1="select content from questionbank3 where id in(";
			for(j=0;j<ty3.length-1;j++)
			{
				str1+=""+ty3[j]+",";
			}
			str1+=""+ty3[j]+")";
			rs=gc.executeQuery(str1);
			j=0;
			try {
				while(rs.next())
				{
					strTemp[j]=(String)rs.getString("content");
					System.out.println(strTemp[j]);
					j++;
				}
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			t3="\n\n�ġ������\n\n";
			for(j=0;j<ty3.length;j++)
			{

				t3+=(j+1)+"."+strTemp[j];
				t3+="\n";

			}
			//System.out.println(t3);
			
			str1="select content from questionbank4 where id in(";
			for(j=0;j<ty4.length-1;j++)
			{
				str1+=""+ty4[j]+",";
			}
			str1+=""+ty4[j]+")";
			rs=gc.executeQuery(str1);
			j=0;
			try {
				while(rs.next())
				{
					strTemp[j]=(String)rs.getString("content");
					System.out.println(strTemp[j]);
					j++;
				}
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			t4="\n\n�塢������\n\n";
			for(j=0;j<ty4.length;j++)
			{

				t4+=(j+1)+"."+strTemp[j];
				t4+="\n";
		
			}
			//System.out.println(t4);
			
			
			str1="select content from questionbank5 where id in(";
			for(j=0;j<ty5.length-1;j++)
			{
				str1+=""+ty5[j]+",";
			}
			str1+=""+ty5[j]+")";
			rs=gc.executeQuery(str1);
			j=0;
			try {
				while(rs.next())
				{
					strTemp[j]=(String)rs.getString("content");
					System.out.println(strTemp[j]);
					j++;
				}
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			t5="\n\n����������\n\n";
			for(j=0;j<ty5.length;j++)
			{
	
				t5+=(j+1)+"."+strTemp[j];
				t5+="\n";
	
			}
			//System.out.println(t5);
		}
		
		if(ti==5)
		{
			GetConn gc=new GetConn();
			ResultSet rs=null;
			
			String []strTemp=new String[10];
			String str1="select answer from questionbank0 where id in(";
			for(j=0;j<ty0.length-1;j++)
			{
				str1+=""+ty0[j]+",";
			}
			str1+=""+ty0[j]+")";
			rs=gc.executeQuery(str1);
			j=0;
			try {
				while(rs.next())
				{
					strTemp[j]=(String)rs.getString("answer");
					System.out.println(strTemp[j]);
					j++;
				}
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			t0="\n\nһ���ж���\n\n";
			for(j=0;j<ty0.length;j++)
			{
				t0+=(j+1)+"."+strTemp[j];
				t0+="\n";
				String ii=(String)strTemp[j];
				kgtdaan[j]=ii.trim();
	
			}
			//System.out.println(t0);
			
			str1="select answer from questionbank1 where id in(";
			for(j=0;j<ty1.length-1;j++)
			{
				str1+=""+ty1[j]+",";
			}
			str1+=""+ty1[j]+")";
			rs=gc.executeQuery(str1);
			j=0;
			try {
				while(rs.next())
				{
					strTemp[j]=(String)rs.getString("answer");
					System.out.println(strTemp[j]);
					j++;
				}
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			t1="\n\n����ѡ����\n\n";
			for(j=0;j<ty1.length;j++)
			{
	
				t1+=(j+1)+"."+strTemp[j];
				t1+="\n";
				String iii=(String) strTemp[j];
				kgtdaan[j+ty0.length]=iii.trim();
			
			}
			//System.out.println(t1);
			
			
			str1="select answer from questionbank2 where id in(";
			for(j=0;j<ty2.length-1;j++)
			{
				str1+=""+ty2[j]+",";
			}
			str1+=""+ty2[j]+")";
			rs=gc.executeQuery(str1);
			j=0;
			try {
				while(rs.next())
				{
					strTemp[j]=(String)rs.getString("answer");
					System.out.println(strTemp[j]);
					j++;
				}
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			t2="\n\n���������\n\n";
			for(j=0;j<ty2.length;j++)
			{

				t2+=(j+1)+"."+strTemp[j];
				t2+="\n";
		
			}
			//System.out.println(t2);
			
			
			str1="select answer from questionbank3 where id in(";
			for(j=0;j<ty3.length-1;j++)
			{
				str1+=""+ty3[j]+",";
			}
			str1+=""+ty3[j]+")";
			rs=gc.executeQuery(str1);
			j=0;
			try {
				while(rs.next())
				{
					strTemp[j]=(String)rs.getString("answer");
					System.out.println(strTemp[j]);
					j++;
				}
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			t3="\n\n�ġ������\n\n";
			for(j=0;j<ty3.length;j++)
			{

				t3+=(j+1)+"."+strTemp[j];
				t3+="\n";

			}
			//System.out.println(t3);
			
			str1="select answer from questionbank4 where id in(";
			for(j=0;j<ty4.length-1;j++)
			{
				str1+=""+ty4[j]+",";
			}
			str1+=""+ty4[j]+")";
			rs=gc.executeQuery(str1);
			j=0;
			try {
				while(rs.next())
				{
					strTemp[j]=(String)rs.getString("answer");
					System.out.println(strTemp[j]);
					j++;
				}
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			t4="\n\n�塢������\n\n";
			for(j=0;j<ty4.length;j++)
			{

				t4+=(j+1)+"."+strTemp[j];
				t4+="\n";
		
			}
			//System.out.println(t4);
			
			
			str1="select answer from questionbank5 where id in(";
			for(j=0;j<ty5.length-1;j++)
			{
				str1+=""+ty5[j]+",";
			}
			str1+=""+ty5[j]+")";
			rs=gc.executeQuery(str1);
			j=0;
			try {
				while(rs.next())
				{
					strTemp[j]=(String)rs.getString("answer");
					System.out.println(strTemp[j]);
					j++;
				}
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			t5="\n\n����������\n\n";
			for(j=0;j<ty5.length;j++)
			{
	
				t5+=(j+1)+"."+strTemp[j];
				t5+="\n";
	
			}
			
		//	System.out.println(t5);
			
			shijuanchakan[7]=toString(kgtdaan);
		}
	/*	Object[][] shiti1;//��������
    	try {
			shiti1 = OperateQuestion.selectAllQuestion(1);
		} catch (Exception e) {
			shiti1 = null;
			e.printStackTrace();
		}
		String t1="\n\n����ѡ����\n\n";
		for(j=0;j<ty1.length;j++){
		for (i = 0; i < shiti1.length; i++) {
			if (shiti1[i][0].equals(ty1[j])) {
				    t1+=(j+1)+"."+(String) shiti1[i][ti];
				    t1+="\n";
				   if(ti==5){
				  String iii=(String) shiti1[i][5];
				  kgtdaan[j+ty0.length]=iii.trim();}
			}
			}
		}	
		Object[][] shiti2;
    	try {
			shiti2 = OperateQuestion.selectAllQuestion(2);
		} catch (Exception e) {
			shiti2 = null;
			e.printStackTrace();
		}
		String t2="\n\n���������\n\n";
		for(j=0;j<ty2.length;j++){
		for (i = 0; i < shiti2.length; i++) {
			if (shiti2[i][0].equals(ty2[j])) {
				    t2+=(j+1)+"."+(String) shiti2[i][ti];
				    t2+="\n";
			}
                   
			}
		}
		Object[][] shiti3;
    	try {
			shiti3 = OperateQuestion.selectAllQuestion(3);
		} catch (Exception e) {
			shiti3 = null;
			e.printStackTrace();
		}
		String t3="\n\n�ġ������\n\n";
		for(j=0;j<ty3.length;j++){
		for (i = 0; i < shiti3.length; i++) {
			if (shiti3[i][0].equals(ty3[j])) {
				    t3+=(j+1)+"."+(String) shiti3[i][ti];
				    t3+="\n";
			}
		}
		}
		Object[][] shiti4;
    	try {
			shiti4 = OperateQuestion.selectAllQuestion(4);
		} catch (Exception e) {
			shiti4 = null;
			e.printStackTrace();
		}
		String t4="\n\n�塢������\n\n";
		for(j=0;j<ty4.length;j++){
		for (i = 0; i < shiti4.length; i++) {
			if (shiti4[i][0].equals(ty4[j])) {
				    t4+=(j+1)+"."+(String) shiti4[i][ti];
                t4+="\n"; 

             
			} 
		}
		}
		Object[][] shiti5;
    	try {
			shiti5 = OperateQuestion.selectAllQuestion(5);
		} catch (Exception e) {
			shiti5 = null;
			e.printStackTrace();
		}
		String t5="\n\n����������\n\n";
		for(j=0;j<ty5.length;j++){
		for (i = 0; i < shiti5.length; i++) {
			if (shiti5[i][0].equals(ty5[j])) {
				    t5+=(j+1)+"."+(String) shiti5[i][ti];
				    t5+="\n";
			}
		}
		}
		*/

		long end=System.currentTimeMillis()-start;
		System.out.println(end);
		
		shijuanchakan[6]=shijuanchakan[6]+t0+t1+t2+t3+t4+t5;//�õ������Ծ�Ĵ�
	//	System.out.println(shijuanchakan[6]);
	    return shijuanchakan;
	}

}
