
package login;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.JOptionPane;

/*组卷算法的设计，本算法主要采取随机+回溯的方法来进行组卷算法的设计，根据试题的题型属性和章节属性以及难度属性来组卷
其中分为几步来实现，首先需要将数据库中题型的属性获取，然后根据输入的组卷规则进行组卷，组卷是，优先匹配试题的题型属性和
章节属性，最后匹配难度属性*/
public class TestPaper {			//组卷算法的类TestPaper


	public  static  Object[][] judgeall() {				//从questionbank0得到所有判断题的属性信息
		
		//OperateQuestion OperateQuestion=new OperateQuestion();
		ResultSet rs = null;
		GetConn gc=new GetConn();			//连接数据库
		int c=0;
		int i=0;
		int flag=0;
		rs=gc.executeQuery("select ID from questionbank0 ");	//指向数据库表格questionbank0
		Object[][] judge=null;
		try {									//得到总题数c
			while(rs.next()){
				c++;
			}
			judge = new Object[c][5];
			rs=gc.executeQuery("select * from questionbank0 ");
			while(rs.next()){					//将判断题的属性存放在judge数组中
			judge[i][0]=rs.getString("ID");		//得到试题的ID号
			//String str="update questionbank0 set flag="+flag+" where ID='"+judge[i][0]+"'";
			//gc.executeUpdate(str);
			judge[i][1]=rs.getInt("grade");		//得到试题的题型信息
			judge[i][2]=rs.getInt("difficult");	//得到试题的难度属性
			judge[i][3]=rs.getInt("chapter");	//得到试题的章节属性
			judge[i][4]=rs.getInt("flag");
			

			i=i+1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gc.close();					//释放数据库连接
		
		return judge;
	}
		
	public static Object[][] chooseall() {		//得到questionbank1的所有选择题属性信息

		
		ResultSet rs = null;
		GetConn gc=new GetConn();			//连接数据库
		int c=0;
		int i=0;
		int flag=0;
		rs=gc.executeQuery("select ID from questionbank1 ");		//指向数据库questionbank1
		Object[][] choose=null;
		try {				//得到选择题的总题数c
			while(rs.next()){
				c++;
			}
			choose = new Object[c][5];
			rs=gc.executeQuery("select * from questionbank1 ");
			while(rs.next()){			//将判断题的属性存放在choose数组中
			choose[i][0]=rs.getString("ID");	//得到试题的ID
			//String str="update questionbank1 set flag="+flag+" where ID='"+choose[i][0]+"'";
			//gc.executeUpdate(str);
			choose[i][1]=rs.getInt("grade");	//得到试题的题型属性
			choose[i][2]=rs.getInt("difficult");	//得到试题的难度属性
			choose[i][3]=rs.getInt("chapter");		//得到试题的章节水洗那个
			choose[i][4]=rs.getInt("flag");		
			i=i+1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gc.close();					//释放数据的连接
		return choose;				//返回一个选择题属性的数组
	}
	
	public  static Object[][] blankall() {		//从questionbank2中得到所有填空题的信息

		
		ResultSet rs = null;
		GetConn gc=new GetConn();				//连接数据库
		int c=0;
		int i=0;
		int flag=0;
		rs=gc.executeQuery("select ID from questionbank2 "); 	//指向数据库表格questionbank2
		Object[][] blank=null;
		try {								//得到所有填空题的总题数c
			while(rs.next()){
				c++;
			}
			blank = new Object[c][5];
			rs=gc.executeQuery("select * from questionbank2 ");
			while(rs.next()){					//将填空题的属性存放在blank数组中
			blank[i][0]=rs.getString("ID");		//得到填空题的ID
			//String str="update questionbank2 set flag="+flag+" where ID='"+blank[i][0]+"'";
			//gc.executeUpdate(str);
			blank[i][1]=rs.getInt("grade");		//得到填空题的题型信息
			blank[i][2]=rs.getInt("difficult");	//得到填空题的难度属性
			blank[i][3]=rs.getInt("chapter");	//得到填空题题的章节属性
			blank[i][4]=rs.getInt("flag");
			i=i+1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gc.close();						//释放数据连接
		return blank;					//返回存放填空题题属性信息的数组
	}
	
	public  static Object[][] shortanswerall() {		//从数据库questionbank3中得到所有简答题的信息

		
		ResultSet rs = null;
		GetConn gc=new GetConn();			//连接数据库
		int c=0;
		int i=0;
		int flag=0;
		rs=gc.executeQuery("select ID from questionbank3 ");
		Object[][] shortanswer=null;
		try {								//得到简答题的总题数
			while(rs.next()){
				c++;
			}
			shortanswer = new Object[c][5];	//定义一个shortanswer二维数组用于存放简答题信息
			rs=gc.executeQuery("select * from questionbank3 ");
			while(rs.next()){			//将简答题的信息存放在shortanswer数组中
			shortanswer[i][0]=rs.getString("ID");			//获取试题的ID
			//String str="update questionbank3 set flag="+flag+" where ID='"+shortanswer[i][0]+"'";
			//gc.executeUpdate(str);					
			shortanswer[i][1]=rs.getInt("grade");			//获取试题的题型信息
			shortanswer[i][2]=rs.getInt("difficult");		//获取试题的难度信息
			shortanswer[i][3]=rs.getInt("chapter");			//获取简答题的章节信息
			shortanswer[i][4]=rs.getInt("flag");			
			i=i+1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gc.close();					//释放数据库的连接
		return shortanswer;			//返回一个存放简答题属性信息的数组
	}
	
	
	public static Object[][] calculationall() {			//从questionbank4中得到所有的计算题信息

		
		ResultSet rs = null;
		GetConn gc=new GetConn();		//连接数据库
		int c=0;
		int i=0;
		int flag=0;
		rs=gc.executeQuery("select ID from questionbank4 ");
		Object[][] calculation=null;
		try {					//得到计算题额总题数
			while(rs.next()){
				c++;
			}
			calculation = new Object[c][5];
			rs=gc.executeQuery("select * from questionbank4  ");
			while(rs.next()){				//将计算题的属性信息存放在calculation数组中
			calculation[i][0]=rs.getString("ID");		//得到计算题的ID号
			//String str="update questionbank4 set flag="+flag+" where ID='"+calculation[i][0]+"'";
			//gc.executeUpdate(str);
			calculation[i][1]=rs.getInt("grade");		//得到计算题的题型信息
			calculation[i][2]=rs.getInt("difficult");	//得到计算题的难度属性信息
			calculation[i][3]=rs.getInt("chapter");		//得到计算题的章节属性信息
			calculation[i][4]=rs.getInt("flag");		//
			i=i+1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gc.close();				//释放数据库连接
		return calculation;		//返回一个存放计算题属性信息的二维数组
	}
	
public  static Object[][] discussall() {		//从questionbank5中得到所有操作题打的属性信息

		
		ResultSet rs = null;
		GetConn gc=new GetConn();			//连接数据库
		int c=0;
		int i=0;
		int flag=0;
		rs=gc.executeQuery("select ID from questionbank5 ");
		Object[][] discuss=null;
		try {						//得到操作题的总题数
			while(rs.next()){
				c++;
			}
			discuss = new Object[c][5];  //定义一个二维数组存放操作题属性信息
			rs=gc.executeQuery("select * from questionbank5 ");
			while(rs.next()){			//将操作题属性信息存放在discuss二维数组中
			discuss[i][0]=rs.getString("ID");		//得到操作的ID
			//String str="update questionbank5 set flag="+flag+" where ID='"+discuss[i][0]+"'";
			//gc.executeUpdate(str);					
			discuss[i][1]=rs.getInt("grade");		//得到操作题的题型信息
			discuss[i][2]=rs.getInt("difficult");	//得到操作题的难度属性信息
			discuss[i][3]=rs.getInt("chapter");		//得到操作题的章节属性信息
			discuss[i][4]=rs.getInt("flag");		//
			i=i+1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gc.close();					//释放数据库连接
		return discuss;				//返回一个存放操作题属性信息的discuss二维数组
	}
	
	public static int[] random(int all) {		//随机数生成算法，最后返回一个all数量的随机数组
		Random ran=new Random();			//随机数类初始化
		int a=0;
		int i;
		int temp;
		int random[]=new int[all];			//定义一个数组存放随机数
		for(i=0;i<all;i++)					//将该数组初始化为0~（all-1）
		{
			random[i]=i;
		}
		
		for(i=0;i<all;i++)					//利用随机数生成将该数组打乱，得到真正的随机数组
		{
			a=ran.nextInt(all);
			temp=random[a];
			random[a]=random[i];
			random[i]=temp;
		}


		return random;					//将随机数组返回
	}
	
	
	
	
	
	
	public static Object[][] testpaper(int typescore[],int typenumber[],int chapternumber[], int score,int difficult) {

		Popup pop=new Popup(4);
		JOptionPane.showMessageDialog(null, "组卷中，请稍等！","欢迎！", 1);
		int i=0;
		int j=0;
		int k=0;
		int alldifficult=0;//抽取得到的题目的总难度
		int questionnum=0;//共有多少题目
		Object [][]judge =judgeall();//从数据库得到所有题的属性
		Object [][]choose =chooseall();
		Object [][]blank =blankall();
		Object [][]shortanswer =shortanswerall();
		Object [][]calculation =calculationall();
		Object [][]discuss =discussall();

		Object [][]judge1=new Object[typenumber[0]][6];//judge1 数组存放的是选择到的题目
		Object [][]choose1 =new Object[typenumber[1]][6];
		Object [][]blank1 =new Object[typenumber[2]][6];
		Object [][]shortanswer1 =new Object[typenumber[3]][6];
		Object [][]calculation1 =new Object[typenumber[4]][6];
		Object [][]discuss1 =new Object[typenumber[5]][6];
		
		int judgelen=judge.length;	//得到各个题型的个数
		int chooselen=choose.length;
		int blanklen=blank.length;
		int shortanswerlen=shortanswer.length;
		int calculationlen=calculation.length;
		int discusslen=discuss.length;
		
		int  []judgeran =random(judgelen);	//将各个题型随机打乱
		int  []chooseran=random(chooselen);
		int  []blankran=random(blanklen);
		int  []shortanswerran =random(shortanswerlen);
		int  []calculationran =random(calculationlen);
		int  []discussran =random(discusslen-1);

		
		int []count=new int[9];		//count数组用于存放老师指定的章节题目数
		
		
		for(i=0;i<9;i++)			//将章节题目数存放在count数组中
		{
			count[i]=chapternumber[i];
		}
		
	
		j=0;
		// 想各个题型的数组中得到随机选中的各个题
		for(i=0;i<typenumber[0];i++)	//随机得到题型1的题目数
		{
			do{
				for(k=0;k<9;k++)		//若某一章节的题目数减为0之后，但是该题并没有被选中，故需要加1，否则会陷入死循环
				{
					if(count[k]<0)
					{
						count[k]=count[k]+1;
					}
				}
				j++;
				judge1[i]=judge[(judgeran[j%(judgelen-1)])];		//得到一个随机题赋给judge1[i]
				switch (Integer.parseInt(String.valueOf(judge1[i][3])))		//判断该题的章节属性，若满足该章节的属性，则对应的章节题目数减1
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
			//若某一章节的题目数小于0，则选题失败，重新选题
		}
	
		j=0;		
		for(i=0;i<typenumber[1];i++)		//随机得到题型为1，即选择题，
		{
			do{
				j++;
				for(k=0;k<9;k++)		//若选中一题后，该章节的总试题数小于0，则放弃了该题，但是由于并没有选择该题，故count[k]+1，否则陷入死循环
				{
					if(count[k]<0)
					{
						count[k]=count[k]+1;
					}
				}
				
				choose1[i]=choose[chooseran[j%(chooselen-1)]];		//随机得到一个题型为选择题的题
				
				switch (Integer.parseInt(String.valueOf(choose1[i][3])))	//判断该题的章节属性，若为某一个章节的题，则该章节的题目数减1
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
		}//当某个章节的题目数减到<0时，则该题放弃，重选
	
	
		j=0;
		for(i=0;i<typenumber[2];i++)		//随机得到题型为2，即填空题，
		{
			do{
				j++;
				for(k=0;k<9;k++)		//若选中一题后，该章节的总试题数小于0，则放弃了该题，但是由于并没有选择该题，故count[k]+1，否则陷入死循环
				{
					if(count[k]<0)
					{
						count[k]=count[k]+1;
					}
				}	
				blank1[i]=blank[blankran[j%(blanklen-1)]];		//随机得到一个题型为填空题的题
				switch (Integer.parseInt(String.valueOf(blank1[i][3])))		//判断该题的章节属性，若为某一章节的题，则该章节对应的试题数减1
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
		}	//当某一章节的试题数减到<0时，则放弃该题，重新选题
	
		

		
		for(i=0;i<typenumber[3];i++)		//随机得到题型为3，即简答题，
		{
			do{
				j++;
				for(k=0;k<9;k++)		//若选中一题后，该章节的总试题数小于0，则放弃了该题，但是由于并没有选择该题，故count[k]+1，否则陷入死循环
				{
					if(count[k]<0)
					{
						count[k]=count[k]+1;
					}
				}
				shortanswer1[i]=shortanswer[shortanswerran[j%(shortanswerlen-1)]];	//随机得到一个题型为简答题的题
				switch (Integer.parseInt(String.valueOf(shortanswer1[i][3])))	//判断该题的章节属性，若某个章节的题，则该章节对应的试题总数减1
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
		}		//当某章节的试题总数<0事，则放弃该题，重新选题
		
		for(i=0;i<typenumber[4];i++)	//随机得到题型为4，即计算题，
		{
			
			do{
				j++;
				for(k=0;k<9;k++)	//若选中一题后，该章节的总试题数小于0，则放弃了该题，但是由于并没有选择该题，故count[k]+1，否则陷入死循环
				{
					if(count[k]<0)
					{
						count[k]=count[k]+1;
					}
				}
				calculation1[i]=calculation[calculationran[j%(calculationlen-1)]];//随机得到一个题型为计算题的题
				switch (Integer.parseInt(String.valueOf(calculation1[i][3])))	//判断该题的章节属性，若某个章节的题，则该章节对应的试题总数减1
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
		}	//当某章节的试题总数<0事，则放弃该题，重新选题
	
		for(i=0;i<typenumber[5];i++)		//随机得到题型为5，即操作题，
		{
			do{
				j++;
				for(k=0;k<9;k++)		//若选中一题后，该章节的总试题数小于0，则放弃了该题，但是由于并没有选择该题，故count[k]+1，否则陷入死循环
				{
					if(count[k]<0)
					{
						count[k]=count[k]+1;
					}
				}
				discuss1[i]=discuss[discussran[j%(discusslen-1)]];			//随机得到一个题型为操作题的题
				switch (Integer.parseInt(String.valueOf(discuss1[i][3])))	//判断该题的章节属性，若某个章节的题，则该章节对应的试题总数减1
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
		}	//当某章节的试题总数<0事，则放弃该题，重新选题
	
	
		
		for(i=0;i<6;i++)			//questionnum用于存放试卷的总题数数目
		{
			questionnum=questionnum+typenumber[i];
		}
	
		
		Object [][]allquestion=new Object[questionnum][6];		//allquestion二维数组用于存放所有题的属性
		for(i=0;i<typenumber[0];i++)		//将题型为判断题的试题存放在allquestion数组中
		{
			allquestion[i]=judge1[i];
		}
			
		for(;i<typenumber[0]+typenumber[1];i++)		//将题型为选择题的试题存放在allquestion中
		{
			allquestion[i]=choose1[i-(typenumber[0])];
		}
		for(;i<typenumber[0]+typenumber[1]+typenumber[2];i++)		//将题型为填空题的试题存放在allquestion
		{
			allquestion[i]=blank1[i-(typenumber[0]+typenumber[1])];
		}
		for(;i<typenumber[0]+typenumber[1]+typenumber[2]+typenumber[3];i++)		//将题型为简答题的试题存放在allquestion中
		{
			allquestion[i]=shortanswer1[i-(typenumber[0]+typenumber[1]+typenumber[2])];
		}
		
		for(;i<typenumber[0]+typenumber[1]+typenumber[2]+typenumber[3]+typenumber[4];i++)	//将题型为计算题的试题存放在allquestion
		{
			allquestion[i]=calculation1[i-(typenumber[0]+typenumber[1]+typenumber[2]+typenumber[3])];
		}
		for(;i<typenumber[0]+typenumber[1]+typenumber[2]+typenumber[3]+typenumber[4]+typenumber[5];i++)	//将题型为操作题的试题存放在allquestion中
		{
			allquestion[i]=discuss1[i-(typenumber[0]+typenumber[1]+typenumber[2]+typenumber[3]+typenumber[4])];
		}
	
		//到此，则所有题目的属性信息则全部存放在allquestion二维数组中，下面开始匹配难度属性
		for(i=0;i<questionnum;i++)		//计算所有题的难度之和，则是整套试卷难度系数
		{
			alldifficult+=(Integer.parseInt(String.valueOf(allquestion[i][2])));

		}
	
		int [] allquestionran=random(questionnum);		//得到一个随机数组allquestionran
		Object [][]temp=null;
		ResultSet rs = null;
		GetConn gc=new GetConn();		//连接数据库
		int c=0;
		i=0;
		
		while(alldifficult<(2*questionnum*(difficult)/5))		//若整套试卷的难度系数小于要求的难度范围，则用难度系数大的题替换难度系数小的题
		{
			i++;
		
			if((Integer.parseInt(String.valueOf(allquestion[(allquestionran[i%questionnum])][2])))<2)//选出难度系数小于2的题，用过替换
			{
				
				switch(Integer.parseInt(String.valueOf(allquestion[(allquestionran[i%questionnum])][1])))	//判断该提的题型属性，以便确定从哪个数据库取题
				{
					case 0: 		
					c=0;
					rs=gc.executeQuery("select * from questionbank0 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=2");//选出符合章节属性和难度属性的试题
					try {
						while(rs.next()){		//得到满足该属性的总题数
							c++;
						}
						temp = new Object[c][5];
						j=0;
						rs=gc.executeQuery("select * from questionbank0 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=2");
						while(rs.next()){			//用temp数组存放选出的所有题包括ID，题型，难度，章节，
							temp[j][0]=rs.getString("ID");		//选出试题的ID
							temp[j][1]=rs.getInt("grade");		//选出试题的题型
							temp[j][2]=rs.getInt("difficult");	//选出试题的难度属性存放
							temp[j][3]=rs.getInt("chapter");	//选出试题的章节属性存放
							temp[j][4]=rs.getInt("flag");
							j=j+1;
							}
					} catch (SQLException e) {
						e.printStackTrace();
					}
		
			
					int []tempran1=random(c);
					allquestion[(allquestionran[i%questionnum])]=temp[tempran1[i%c]];	//将得到的符合要求的题与原题交换
					alldifficult=0;
					for(k=0;k<questionnum;k++)		//重新计算整套试卷难度，再次进入循环，若不满足条件，则再次换题
					{
						alldifficult+=(Integer.parseInt(String.valueOf(allquestion[k][2])));

					}	
				
					break;
					
					case 1: 	
						c=0;
						rs=gc.executeQuery("select * from questionbank1 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=2");//选出符合章节属性和难度属性的试题
						try {
							while(rs.next()){		//得到符合要求的试题数总数
								c++;
							}
							temp = new Object[c][5];
							j=0;
							rs=gc.executeQuery("select * from questionbank1 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=2");
							while(rs.next()){		//用temp数组存放选出的所有题包括ID，题型，难度，章节，
								temp[j][0]=rs.getString("ID");		//取出试题ID
								temp[j][1]=rs.getInt("grade");		//取出试题的题型属性
								temp[j][2]=rs.getInt("difficult");	//取出试题的难度属性
								temp[j][3]=rs.getInt("chapter");	//取出试题的章节的属性
								temp[j][4]=rs.getInt("flag");
								j=j+1;
								}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						int []tempran2=random(c);
						allquestion[(allquestionran[i%questionnum])]=temp[tempran2[i%c]];		//将得到的符合要求的题与原题互换
						alldifficult=0;		//将试卷难度系数清零
						for(k=0;k<questionnum;k++)	//重新计算试卷的难度系数，再次进入循环，若不满足条件，则再次换题
						{
							alldifficult+=(Integer.parseInt(String.valueOf(allquestion[k][2])));

						}	
						break;
						

					case 2: 	
						c=0;
						rs=gc.executeQuery("select * from questionbank2 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=2");//选出符合章节属性和难度属性的试题
						try {
							while(rs.next()){		//得到符合条件的试题的总题数
								c++;
							}
							temp = new Object[c][5];
							j=0;
							rs=gc.executeQuery("select * from questionbank2 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=2");
							while(rs.next()){	//用temp数组存放选出的所有题包括ID，题型，难度，章节，
								temp[j][0]=rs.getString("ID");		//取出试题的ID号
								temp[j][1]=rs.getInt("grade");		//趋势试题的章节属性
								temp[j][2]=rs.getInt("difficult");	//取出试题的难度属性
								temp[j][3]=rs.getInt("chapter");	//取出试题的章节属性
								temp[j][4]=rs.getInt("flag");		//
								j=j+1;
								}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						int []tempran3=random(c);
						allquestion[(allquestionran[i%questionnum])]=temp[tempran3[i%c]];	//将得到的符合要求的试题与原题互换
						alldifficult=0;		//将试题总难度清零
						for(k=0;k<questionnum;k++)		////重新计算试卷的难度系数，再次进入循环，若不满足条件，则再次换题
						{
							alldifficult+=(Integer.parseInt(String.valueOf(allquestion[k][2])));

						}	
						break;
						

					case 3: 	
						c=0;
						rs=gc.executeQuery("select * from questionbank3 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=2");
						try {
							while(rs.next()){//得到符合条件的试题的总题数
								c++;
							}
							temp = new Object[c][5];
							j=0;
							rs=gc.executeQuery("select * from questionbank3 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=2");
							while(rs.next()){//用temp数组存放选出的所有题包括ID，题型，难度，章节，
								temp[j][0]=rs.getString("ID");	//取出实体的ID号
								temp[j][1]=rs.getInt("grade");	//取出试题的题型属性
								temp[j][2]=rs.getInt("difficult");	//取出试题的难度属性
								temp[j][3]=rs.getInt("chapter");	//取出试题的章节属性
								temp[j][4]=rs.getInt("flag");		//
								j=j+1;
								}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						int []tempran4=random(c);	
						allquestion[(allquestionran[i%questionnum])]=temp[tempran4[i%c]];		//将的道德符合要求的试题与原题互换
						alldifficult=0;		//将试卷难度清零
						for(k=0;k<questionnum;k++)		//重新计算试卷的难度系数，再次进入循环，若不满足条件，则再次换题
						{
							alldifficult+=(Integer.parseInt(String.valueOf(allquestion[k][2])));

						}	
						break;
						

					case 4: 	
						c=0;
						rs=gc.executeQuery("select * from questionbank4 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=2");//选出符合章节属性和难度属性的试题
						try {
							while(rs.next()){	//得到符合要求的试题总题数
								c++;
							}
							temp = new Object[c][5];
							j=0;
							rs=gc.executeQuery("select * from questionbank4 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=2");
							while(rs.next()){		//用temp数组存放所有试题的属性信息
								temp[j][0]=rs.getString("ID");		//取出试题ID号
								temp[j][1]=rs.getInt("grade");		//取出试题的题型信息
								temp[j][2]=rs.getInt("difficult");	//取出试题的难度属性信息
								temp[j][3]=rs.getInt("chapter");	//取出试题的章节属性信息	
								temp[j][4]=rs.getInt("flag");		//
								j=j+1;
								}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						int []tempran5=random(c);
						allquestion[(allquestionran[i%questionnum])]=temp[tempran5[i%c]];	//将选到的符合要求的试题与原题互换
						alldifficult=0;		//将试卷难度系数清零
						for(k=0;k<questionnum;k++)	//重新计算试卷难度，再次进入循环，若不满足条件，则再次换题
						{
							alldifficult+=(Integer.parseInt(String.valueOf(allquestion[k][2])));

						}	
						break;
						
					case 5: 	
						c=0;
						rs=gc.executeQuery("select * from questionbank5 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=2");	//选出符合章节属性和难度属性的试题
						try {
							while(rs.next()){		//计算符合要求的所有试题总题数
								c++;
							}
							temp = new Object[c][5];
							j=0;
							rs=gc.executeQuery("select * from questionbank5 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=2");
							while(rs.next()){//用temp数组存放选出的所有题包括ID，题型，难度，章节，
								temp[j][0]=rs.getString("ID");		//取出得到试题的ID号
								temp[j][1]=rs.getInt("grade");		//取出得到试题的题型属性
								temp[j][2]=rs.getInt("difficult");	//取出得到试题的难度属性
								temp[j][3]=rs.getInt("chapter");	//取出得到实体的章节属性
								temp[j][4]=rs.getInt("flag");
								j=j+1;
								}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						int []tempran6=random(c);
						allquestion[(allquestionran[i%questionnum])]=temp[tempran6[i%c]];		//将得到的符合要求的试题与原题互换
						alldifficult=0;		//将试卷的难度系数清零
						for(k=0;k<questionnum;k++)		//重新计算试卷难度，再次进入循环，若不满足条件，则再次换题
						{
							alldifficult+=(Integer.parseInt(String.valueOf(allquestion[k][2])));

						}	
						break;
					
						
					
					
				}
				
			}
		}
		
		c=0;
		i=0;
		while(alldifficult>=(2*questionnum*(difficult+1)/5))		//若试卷的总难度大于指定的难度范围，则用难度系数较小的题去替换难度系数较大的题，直到试卷难度在范围以内
		{
			i++;
		
			if((Integer.parseInt(String.valueOf(allquestion[(allquestionran[i%questionnum])][2])))>0)		//选出试题中难度系数大于0的试题，以便替换
			{
				
				switch((Integer.parseInt(String.valueOf(allquestion[(allquestionran[i%questionnum])][1]))))		//判断该题的题型属性，以确定从哪个试题库表格中获取试题
				{
					case 0: 		
					c=0;
					rs=gc.executeQuery("select * from questionbank0 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=0");	//选出符合难度属性要求和章节属性要求的试题
					try {
						while(rs.next()){		//计算得到满足要求的总试题
							c++;
						}
						temp = new Object[c][5];
						j=0;
						rs=gc.executeQuery("select * from questionbank0 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=0");
						while(rs.next()){		//将得到的满足要求的试题存放在temp数组中
							temp[j][0]=rs.getString("ID");		//得到实体的ID号
							temp[j][1]=rs.getInt("grade");		//得到试题的题型属性
							temp[j][2]=rs.getInt("difficult");	//得到试题的难度属性信息
							temp[j][3]=rs.getInt("chapter");	//得到试题的章节属性信息
							temp[j][4]=rs.getInt("flag");
							j=j+1;
							}
					} catch (SQLException e) {
						e.printStackTrace();
					}
		
			
					int []tempran1=random(c);
					allquestion[(allquestionran[i%questionnum])]=temp[tempran1[i%c]];	//随机将得到的符合要求的某个试题与原题互换
					alldifficult=0;
					for(k=0;k<questionnum;k++)		//重新计算试卷的难度系数，并返回循环，与要求的试卷难度范围比较，若满足要求则组卷成功，否则继续换题
					{
						alldifficult+=(Integer.parseInt(String.valueOf(allquestion[k][2])));

					}	
				
					break;
					
					case 1: 	
						c=0;
						rs=gc.executeQuery("select * from questionbank1 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=0");//选出符合难度属性要求和章节属性要求的试题
						try {
							while(rs.next()){		//计算符合要求的试题总题数
								c++;
							}
							temp = new Object[c][5];
							j=0;
							rs=gc.executeQuery("select * from questionbank1 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=0");
							while(rs.next()){		//将符合要求的试题存放在temp数组中
								temp[j][0]=rs.getString("ID");		//取出试题的ID号
								temp[j][1]=rs.getInt("grade");		//取出试题的提醒属性信息
								temp[j][2]=rs.getInt("difficult");	//取出实体的难度属性信息
								temp[j][3]=rs.getInt("chapter");	//取出试题的章节属性信息
								temp[j][4]=rs.getInt("flag");
								j=j+1;
								}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						int []tempran2=random(c);
						allquestion[(allquestionran[i%questionnum])]=temp[tempran2[i%c]];		//随机将得到的一个符合要求的试题与原题互换
						alldifficult=0;
						for(k=0;k<questionnum;k++)	//重新计算试卷的总难度系数，并返回循环，与要求的试卷难度范围比较，若满足要求则组卷成功，否则继续换题
						{
							alldifficult+=(Integer.parseInt(String.valueOf(allquestion[k][2])));

						}	
						break;
						

					case 2: 	
						c=0;
						rs=gc.executeQuery("select * from questionbank2 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=0");//选出符合难度属性要求和章节属性要求的试题
						try {
							while(rs.next()){	//计算符合要求的试题总题数
								c++;
							}
							temp = new Object[c][5];
							j=0;
							rs=gc.executeQuery("select * from questionbank2 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=0");
							while(rs.next()){		//用temp数组存放符合要求的试题属性
								temp[j][0]=rs.getString("ID");	//取出实体的ID号存放
								temp[j][1]=rs.getInt("grade");	//取出试题的题型属性信息存放
								temp[j][2]=rs.getInt("difficult");	//取出试题的难度信息存储
								temp[j][3]=rs.getInt("chapter");	//取出试题的章节属性信息
								temp[j][4]=rs.getInt("flag");
								j=j+1;
								}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						int []tempran3=random(c);
						allquestion[(allquestionran[i%questionnum])]=temp[tempran3[i%c]];		//将选出的符合要求的试题随机得到一个与原题互换
						alldifficult=0;		//将试卷的难度系数清零
						for(k=0;k<questionnum;k++)		//重新计算试卷的总难度系数，并返回循环，与要求的试卷难度范围比较，若满足要求则组卷成功，否则继续换题
						{
							alldifficult+=(Integer.parseInt(String.valueOf(allquestion[k][2])));

						}	
						break;
						

					case 3: 	
						c=0;
						rs=gc.executeQuery("select * from questionbank3 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=0");
						try {
							while(rs.next()){		//计算符合要求的试题的总题数
								c++;
							}
							temp = new Object[c][5];
							j=0;
							rs=gc.executeQuery("select * from questionbank3 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=0");
							while(rs.next()){		//用temp数组存放试卷的属性信息
								temp[j][0]=rs.getString("ID");		//取出试题的ID号
								temp[j][1]=rs.getInt("grade");		//取出试题的题型属性信息
								temp[j][2]=rs.getInt("difficult");	//取出试题的难度属性信息
								temp[j][3]=rs.getInt("chapter");	//取出试题的章节属性信息
								temp[j][4]=rs.getInt("flag");		//
								j=j+1;
								}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						int []tempran4=random(c);
						allquestion[(allquestionran[i%questionnum])]=temp[tempran4[i%c]];	// 随机得到一个符合要求的试题与原题互换
						alldifficult=0;		//将试卷难度系数清零
						for(k=0;k<questionnum;k++)		////重新计算试卷的总难度系数，并返回循环，与要求的试卷难度范围比较，若满足要求则组卷成功，否则继续换题
						{
							alldifficult+=(Integer.parseInt(String.valueOf(allquestion[k][2])));

						}	
						break;
						

					case 4: 	
						c=0;
						rs=gc.executeQuery("select * from questionbank4 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=0");//选出符合难度属性要求和章节属性要求的试题
						try {
							while(rs.next()){		//计算出符合要求的试题总题数
								c++;
							}
							temp = new Object[c][5];
							j=0;
							rs=gc.executeQuery("select * from questionbank4 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=0");
							while(rs.next()){//用temp数组存放试卷的属性信息
								temp[j][0]=rs.getString("ID");		//取出试题的ID号
								temp[j][1]=rs.getInt("grade");		//取出试题的题型属性信息
								temp[j][2]=rs.getInt("difficult");	//取出试题的难度属性信息
								temp[j][3]=rs.getInt("chapter");	//取出试题的章节属性信息
								temp[j][4]=rs.getInt("flag");
								j=j+1;
								}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						int []tempran5=random(c);
						allquestion[(allquestionran[i%questionnum])]=temp[tempran5[i%c]];	//随机得到一个符合要求的试题与原题互换
						alldifficult=0;		//将试卷的难度系数清零
						for(k=0;k<questionnum;k++)		//重新计算试卷的总难度系数，并返回循环，与要求的试卷难度范围比较，若满足要求则组卷成功，否则继续换题
						{
							alldifficult+=(Integer.parseInt(String.valueOf(allquestion[k][2])));

						}	
						break;
						
					case 5: 	
						c=0;
						rs=gc.executeQuery("select * from questionbank5 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=0 ");//选出符合难度属性要求和章节属性要求的试题
						try {
							while(rs.next()){		//计算得到符合要的所有题的题目数
								c++;
							}
							temp = new Object[c][5];		//
							j=0;
							rs=gc.executeQuery("select * from questionbank5 where chapter='"+allquestion[i%questionnum][3]+"' and difficult=0");
							while(rs.next()){			//取出符合要求的试题属性存放在temp数组中
								temp[j][0]=rs.getString("ID");		//取出试题ID号
								temp[j][1]=rs.getInt("grade");		//取出试题的题型信息
								temp[j][2]=rs.getInt("difficult");	//取出试题试题的难度信息
								temp[j][3]=rs.getInt("chapter");	//取出试题的章节属性信息
								temp[j][4]=rs.getInt("flag");
								j=j+1;
								}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						int []tempran6=random(c);
						allquestion[(allquestionran[i%questionnum])]=temp[tempran6[i%c]];		//随机得到一个符合要求的试题与原题互换
						alldifficult=0;		//将难度系数清零
						for(k=0;k<questionnum;k++)			//重新计算试卷的总难度系数，并返回循环，与要求的试卷难度范围比较，若满足要求则组卷成功，否则继续换题
						{
							alldifficult+=(Integer.parseInt(String.valueOf(allquestion[k][2])));

						}	
						break;
					
						
					
					
				}
				
			}
		}
	
		pop.dispose();
		return allquestion;		//返回取到的试题的二维数组
		
	}
	
}
	
	
	
	

