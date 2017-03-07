package login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

/*在线练习的设计,在线练习采取完全随机的算法设计,根据指定的要求,采用随机的方法得到合适的题目显示供学生练习*/
public class Practice {


	
	public int[] random(int all) 				//随机数生成函数，可以产生范围在0-all的随机数供调用
	{
		Random ran=new Random();		//随机数类初始化
		int a=0;
		int i;
		int temp;
		int random[]=new int[all];
		for(i=0;i<all;i++)			//将该随机数组初始化
		{
			random[i]=i;
		}
		
		for(i=0;i<all;i++)		//利用随机数生成将该数组打乱，得到真正的随机数组
		{
			a=ran.nextInt(all);
			temp=random[a];
			random[a]=random[i];
			random[i]=temp;
		}
	
		return random;			//返回一个随机数组
	}
	
	
	public Object[] [] practice(int chapter,int difficult,int type)		//在线练习试题生成的函数，假定一次练习5个题
	{
		Object [][]temp=null;				//定义一个临时数组
		int []tempran=null;
		Object [][]allquestion=new Object [5][5];		//定义allquestion数组用于存放选择的试题
		ResultSet rs = null;
		GetConn gc=new GetConn();			//连接数据库
		int i=0;
		int j=0;
		int c=0;
		int number=0;
		switch(type)		//判断该题的题型属性信息,若满足某个章节
		{
			case 0:
				c=0;
				rs=gc.executeQuery("select * from questionbank0 where chapter='"+chapter+"' and difficult='"+difficult+"'");//选择符合章节属性难度属性的试题
				try {
					while(rs.next()){		//得到试题的总题数
						c++;
					}
					temp = new Object[c][5];
					j=0;
					rs=gc.executeQuery("select * from questionbank0 where chapter='"+chapter+"' and difficult='"+difficult+"'");
					while(rs.next()){		//将得到的试题属性存放在temp数组中
						temp[j][0]=rs.getString("id");		//得到试题的Id
						temp[j][1]=rs.getInt("grade");		//得到试题的题型属性
						temp[j][2]=rs.getInt("difficult");	//得到试题的难度属性
						temp[j][3]=rs.getInt("chapter");	//得到试题的章节属性
						temp[j][4]=rs.getInt("flag");
						j=j+1;
						}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			break;
			
			case 1:
				c=0;
				rs=gc.executeQuery("select * from questionbank1 where chapter='"+chapter+"' and difficult='"+difficult+"'");//选择符合章节属性难度属性的试题
				try {
					while(rs.next()){//得到试题的总题数
						c++;
					}
					temp = new Object[c][5];
					j=0;
					rs=gc.executeQuery("select * from questionbank1 where chapter='"+chapter+"' and difficult='"+difficult+"'");
					while(rs.next()){		//将得到的试题属性存放在temp数组中
						temp[j][0]=rs.getString("id");	//得到试题的ID
						temp[j][1]=rs.getInt("grade");	//得到试题的题型属性
						temp[j][2]=rs.getInt("difficult");	//得到试题的难度属性
						temp[j][3]=rs.getInt("chapter");	//得到试题的章节属性
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
				rs=gc.executeQuery("select * from questionbank2 where chapter='"+chapter+"' and difficult='"+difficult+"'");//选择符合章节属性难度属性的试题
				try {
					while(rs.next()){	//将得到的试题属性存放在temp数组中
						c++;
					}
					temp = new Object[c][5];
					j=0;
					rs=gc.executeQuery("select * from questionbank2 where chapter='"+chapter+"' and difficult='"+difficult+"'");
					while(rs.next()){		//	//将得到的试题属性存放在temp数组中
						temp[j][0]=rs.getString("id");//得到试题的ID
						temp[j][1]=rs.getInt("grade");		//得到试题的分数
						temp[j][2]=rs.getInt("difficult");	//得到试题的难度
						temp[j][3]=rs.getInt("chapter");	//得到实体的章节属性信息
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
				rs=gc.executeQuery("select * from questionbank3 where chapter='"+chapter+"' and difficult='"+difficult+"'");//选择符合章节属性难度属性的试题
				try {
					while(rs.next()){//将得到的试题属性存放在temp数组中
						c++;
					}
					temp = new Object[c][5];
					j=0;
					rs=gc.executeQuery("select * from questionbank3 where chapter='"+chapter+"' and difficult='"+difficult+"'");
					while(rs.next()){//	//将得到的试题属性存放在temp数组中
						temp[j][0]=rs.getString("id");//得到试题的ID
						temp[j][1]=rs.getInt("grade");	//得到试题的分数
						temp[j][2]=rs.getInt("difficult");//得到试题的难度
						temp[j][3]=rs.getInt("chapter");	//得到实体的章节属性信息
						temp[j][4]=rs.getInt("flag");
						j=j+1;
						}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			break;
			
			case 4:
				c=0;
				rs=gc.executeQuery("select * from questionbank4 where chapter='"+chapter+"' and difficult='"+difficult+"'");//选择符合章节属性难度属性的试题
				try {
					while(rs.next()){//将得到的试题属性存放在temp数组中
						c++;
					}
					temp = new Object[c][5];
					j=0;
					rs=gc.executeQuery("select * from questionbank4 where chapter='"+chapter+"' and difficult='"+difficult+"'");
					while(rs.next()){		//将得到的试题属性存放在temp数组中
						temp[j][0]=rs.getString("id");		//得到试题的ID
						temp[j][1]=rs.getInt("grade");		//得到试题的分数
						temp[j][2]=rs.getInt("difficult");	//得到试题的难度
						temp[j][3]=rs.getInt("chapter");	//得到实体的章节属性信息
						temp[j][4]=rs.getInt("flag");
						j=j+1;
						}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			break;
			
			case 5:
				c=0;
				rs=gc.executeQuery("select * from questionbank5 where chapter='"+chapter+"' and difficult='"+difficult+"'");//选择符合章节属性难度属性的试题
				try {
					while(rs.next()){//将得到的试题属性存放在temp数组中
						c++;
					}
					temp = new Object[c][5];
					j=0;
					rs=gc.executeQuery("select * from questionbank5 where chapter='"+chapter+"' and difficult='"+difficult+"'");
					while(rs.next()){		//将得到的试题属性存放在temp数组中
						temp[j][0]=rs.getString("id");		//得到试题的ID
						temp[j][1]=rs.getInt("grade");			//得到试题的分数
						temp[j][2]=rs.getInt("difficult");	//得到试题的难度
						temp[j][3]=rs.getInt("chapter");	//得到实体的章节属性信息
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
		for(i=0;i<temp.length;i++)			//将得到的试题随机打乱
		{
			temp1[i]=temp[tempran[i]];
		}
	

		if(temp.length<5) number=temp.length;	//定义显示的试题数,若符合要求的试题总数大于5,则显示5个题,若小于5个题,则显示所有符合要求的试题
		else number=5;
	
		
		for(i=0;i<number;i++)		//将temp数组中得到的随机的number个数的题赋给allquestion
		{
			allquestion[i]=temp1[i];
			
		}

		for(i=0;i<allquestion.length;i++)
		{
		}
		
		return allquestion;		//返回符合要求的试题属性allquestion
	}
	
}