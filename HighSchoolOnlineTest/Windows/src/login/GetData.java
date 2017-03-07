package login;

import java.sql.ResultSet;


public class GetData {				//从数据库获取数据，得到用户信息留作后用

	public static  Object[][] selectAll() throws Exception{
		ResultSet rs = null;
		GetConn gc=new GetConn();			//连接数据库
		int c=0;
		int i=0;
		long start=System.currentTimeMillis();
		rs=gc.executeQuery("select id from user");	//指向数据库的某一项
		while(rs.next()){
			c++;
		}
		Object[][] b=new Object[c][8];
		rs=gc.executeQuery("select * from user ");
			while(rs.next()){
			b[i][0]=rs.getString("User_Identity");		//得到用户身份类型
			b[i][1]=rs.getString("username");			//得到用户账号名
			b[i][2]=rs.getString("password");			//得到用户密码
			b[i][3]=rs.getString("name");				//得到用户姓名
			b[i][4]=rs.getString("id");					//获取用户学号或者教工号
			b[i][5]=rs.getString("sex");				//获取用户性别信息
			b[i][6]=rs.getString("college");			//获取用户院系信息
			b[i][7]=rs.getString("class");				//获取用户班级信息
			i=i+1;
		}
		gc.close();									//释放数据库连接
		long end=System.currentTimeMillis();
		long time=end-start;
		System.out.println(time);
		return b;									//将用户信息数组返回
		}	

	}


