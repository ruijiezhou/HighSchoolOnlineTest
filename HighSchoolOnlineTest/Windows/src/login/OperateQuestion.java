package login;

import java.sql.ResultSet;
import java.sql.SQLException;
/**试题试卷操作类,包含各种对数据库的操作方法*/
public class OperateQuestion {
	//根据输入的题型读出该题型的所有试题的所有信息
	public static  Object[][] selectAllQuestion(int type) throws Exception{
		ResultSet rs = null;
		GetConn gc=new GetConn();
		int c=0;
		int i=0;
		rs=gc.executeQuery("select ID from questionbank"+type+" ");
		while(rs.next()){
			c++;//确定试题数目
		}
		Object[][] b=new Object[c][8];
		rs=gc.executeQuery("select * from questionbank"+type+" ");
		while(rs.next()){//读出试题信息
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
	//读取练习题,只需读出试题,答案和图片
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
	//根据输入的试卷名,查找对应的考试信息表,读处相关信息
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
		rs=gc.executeQuery("select * from "+name+" ");//从考试信息表中读取信息
		while(rs.next()){
		b[i][0]=rs.getString("id");//考生学号
		b[i][1]=rs.getString("name");//考生姓名
		b[i][2]=rs.getString("answer");//考生答卷
		b[i][3]=rs.getString("score");//考生总分
		b[i][4]=rs.getString("kgtanswer");//考生客观题答案,自动阅卷用到
		b[i][5]=rs.getString("kgtscore");//考生的客观题得分,自动阅卷给出
		i=i+1;
		}
		gc.close();
		return b;
		}
	//选出指定的本次考试试卷
	public static  String[] selectflag() throws Exception{
		ResultSet rs = null;
		GetConn gc=new GetConn();
	//	int flag=1;
		String[] b=new String[18];
		rs=gc.executeQuery("select * from shijuan ");
		while(rs.next()){
		if(rs.getString("flag").equals("1")){//选出标志位为1的本次考试试卷
			
		b[0]=rs.getString("SJID");//试卷编号
		b[4]=rs.getString("T0ID");//题型0的所有试题试题编号
		b[1]=rs.getString("difficult");//试卷难度
		b[5]=rs.getString("T1ID");//题型1的所有试题试题编号
		b[6]=rs.getString("T2ID");//题型2的所有试题试题编号
		b[7]=rs.getString("T3ID");//题型3的所有试题试题编号
		b[8]=rs.getString("T4ID");//题型4的所有试题试题编号
		b[9]=rs.getString("T5ID");//题型5的所有试题试题编号
		b[3]=rs.getString("flag");//标志位
		b[2]=rs.getString("score");//试卷总分
		b[10]=rs.getString("time");//考试时间
		b[11]=rs.getString("score0");//题型0分数
		b[12]=rs.getString("score1");//题型1分数
		b[13]=rs.getString("score2");//题型2分数
		b[14]=rs.getString("score3");//题型3分数
		b[15]=rs.getString("score4");//题型4分数
		b[16]=rs.getString("score5");//题型5分数
		b[17]=rs.getString("kgtscore");//客观题总分
		}
		}
		gc.close();
		return b;
		}
	//查找试卷表,得到所有试卷信息
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
		b[i][0]=rs.getString("SJID");//试卷编号
		b[i][4]=rs.getString("T0ID");//各题型的试题编号
		b[i][1]=rs.getString("difficult");//难度
		b[i][5]=rs.getString("T1ID");
		b[i][6]=rs.getString("T2ID");
		b[i][7]=rs.getString("T3ID");
		b[i][8]=rs.getString("T4ID");
		b[i][9]=rs.getString("T5ID");
		b[i][3]=rs.getString("flag");//是否指定为本次考试试卷
		b[i][2]=rs.getString("score");//试卷总分
		b[i][10]=rs.getString("time");//考试时间
		b[i][11]=rs.getString("score0");//各题型分数
		b[i][12]=rs.getString("score1");
		b[i][13]=rs.getString("score2");
		b[i][14]=rs.getString("score3");
		b[i][15]=rs.getString("score4");
		b[i][16]=rs.getString("score5");
		b[i][17]=rs.getString("kgtscore");//客观题总分
		i=i+1;
		}
		gc.close();
		return b;
		}
	//删除某一题型试题表中的题目
	public static int Delete(int type,String id){
		GetConn gc=new GetConn();
		String str="delete from questionbank"+type+" where id='"+id+"'";
		int result=gc.executeUpdate(str);
		return result;
	}
	//向试题表中添加试题
	public int Add(int type,String id,int grade,int difficult,int chapter,String content,String answer,String note){
		GetConn gc=new GetConn();
		String str="insert into questionbank"+type+" (id,grade,difficult,chapter,content,answer,note)" +
				"values('"+id+"','"+grade+"','"+difficult+"','"+chapter+"','"+content+"','"+answer+"','"+note+"')";
	    int result=gc.executeUpdate(str);
	    return result;
	}
	//数组转成字符串,以空格隔开
    public static String toString(Object[] a) {
        String b=(String)a[0];
   
        for (int i = 1; i<a.length; i++) {
        	if(a[i] != null)
              b=b+" "+a[i];
        }
        return b;
    }
		//根据给定的试卷编号,得出整张试卷的试题,答案等信息
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
			if (shijuan[i][0].equals(id1)) {//将所找的试卷的每个题型的所有题目的编号读出来
				
			    cxshiti1[0]=(String) shijuan[i][4];
			    cxshiti1[1]= (String)shijuan[i][5];
			    cxshiti1[2]= (String)shijuan[i][6];
			    cxshiti1[3]= (String)shijuan[i][7];
			    cxshiti1[4]= (String)shijuan[i][8];
			    cxshiti1[5]=(String) shijuan[i][9];
			}
		}	
		//cxshiti1数据保存了该试卷所有试题的数据
		System.out.println(cxshiti1[0]);
		
		String[] ty0 =cxshiti1[0].split(" ");//试题编号字符串还原成试题编号数组
		String[] ty1 =cxshiti1[1].split(" ");
		String[] ty2 =cxshiti1[2].split(" ");
		String[] ty3 =cxshiti1[3].split(" ");
		String[] ty4 =cxshiti1[4].split(" ");
		String[] ty5 =cxshiti1[5].split(" ");
	
		for(int heke=0;heke<ty0.length;heke++)
			System.out.println(ty0[heke]);
		
		shijuanchakan[0]= Integer.toString(ty0.length);//各个题型的试题个数
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
	    //t0保存了试题信息
		String t0="\n\n一、判断题\n\n";
		for(j=0;j<ty0.length;j++){
			for (i = 0; i < shiti0.length; i++) {
				if (shiti0[i][0].equals(ty0[j]))
				{
					t0+=(j+1)+"."+(String) shiti0[i][ti];//读取需要的试题题目或者答案
					t0+="\n";
					if(ti==5)
					{
						String ii=(String) shiti0[i][5];//读取客观题答案
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
			
			t0="\n\n一、判断题\n\n";
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
			
			t1="\n\n二、选择题\n\n";
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
			t2="\n\n三、填空题\n\n";
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
			t3="\n\n四、简答题\n\n";
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
			t4="\n\n五、计算题\n\n";
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
			t5="\n\n六、操作题\n\n";
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
			
			t0="\n\n一、判断题\n\n";
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
			
			t1="\n\n二、选择题\n\n";
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
			t2="\n\n三、填空题\n\n";
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
			t3="\n\n四、简答题\n\n";
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
			t4="\n\n五、计算题\n\n";
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
			t5="\n\n六、操作题\n\n";
			for(j=0;j<ty5.length;j++)
			{
	
				t5+=(j+1)+"."+strTemp[j];
				t5+="\n";
	
			}
			
		//	System.out.println(t5);
			
			shijuanchakan[7]=toString(kgtdaan);
		}
	/*	Object[][] shiti1;//以下类似
    	try {
			shiti1 = OperateQuestion.selectAllQuestion(1);
		} catch (Exception e) {
			shiti1 = null;
			e.printStackTrace();
		}
		String t1="\n\n二、选择题\n\n";
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
		String t2="\n\n三、填空题\n\n";
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
		String t3="\n\n四、简答题\n\n";
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
		String t4="\n\n五、计算题\n\n";
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
		String t5="\n\n六、操作题\n\n";
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
		
		shijuanchakan[6]=shijuanchakan[6]+t0+t1+t2+t3+t4+t5;//得到整份试卷的答案
	//	System.out.println(shijuanchakan[6]);
	    return shijuanchakan;
	}

}
