package login;

import java.sql.*;

public class GetConn {
	static public Connection conn =getConnection();
	public ResultSet rs = null;
	public Statement stmt = null;
	public PreparedStatement pstmt = null;
	
	public GetConn() { // ���췽��
		
	}
	/*
	 * ��ȡ���ݿ����ӷ���
	 */
	

	static public  Connection getConnection() {
		long start=System.currentTimeMillis();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
							//"jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=gbk",
							//"root", "123456"
					"jdbc:mysql://db4free.net:3306/db4freeformysql?useUnicode=true&characterEncoding=gbk",
					"db4freeforheke","123456"
					//"jdbc:mysql://www.freesql.org:3306/freesqlformysql",
					//"freesqlforheke","123456"
					//"jdbc:mysql://mysql1.000webhost.com:3306/a6162114_mysql",
					//"a6162114_heke","heke876144622"
					);
			System.out.println("heke:yes");
			System.out.println("��ô�������Ӱ���");
		} catch (Exception e) {System.out.println("heke:error");return null;}// �쳣����
		long end=System.currentTimeMillis();
		long time=end-start;
		System.out.println(time);
		return conn;// ������Ҫ�󷵻ظ�Connection����
	}
	/*
	 * ���ܣ�ִ�в�ѯ���
	 */
	public ResultSet executeQuery(String sql) {
		try {
			if(conn==null)
				conn=getConnection();
			//conn = getConnection();
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {System.out.println(e);}
		return rs;
	}
	/*
	 * ����:ִ�и��²���
	 */
	public int executeUpdate(String sql) {
		int result = 1;
		System.out.println("heke");
		try {
			if(conn==null)
			{
				System.out.println("���ڸ��µ��������ж�");
				conn=getConnection();
			}
			//conn = getConnection();
			System.out.println("������");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			System.out.println(sql);
			result = stmt.executeUpdate(sql);
		} catch (SQLException ex) {result = 0;}
		try {
			if(conn==null)
				System.out.println("��������");
			//else System.out.println("��������");
			stmt.close();
		} catch (SQLException e) {e.printStackTrace();}
		return result;
	}
	/*
	 * ����:�ر����ݿ������
	 */
	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {e.printStackTrace(System.err);}
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (Exception e) {e.printStackTrace(System.err);}
		try {
			if (conn != null) {
				//conn.close();
			}
		} catch (Exception e) {e.printStackTrace(System.err);}
	}
	/*
	 * ת�뷽��
	 */
	public static String tolatin1(String strvalue){ 
		try{
			if(strvalue==null){
				return "";
			}else{
				strvalue=new String(strvalue.getBytes("UTF-8"),"latin1").trim();
				return strvalue;
			}
		}catch (Exception e){return "";}
		}
	public static String toGBK(String strvalue){
		try{
			if(strvalue==null){
				return "";
			}else{
				strvalue=new String(strvalue.getBytes("latin1"),"GBK").trim();
				return strvalue;
			}
		}catch (Exception e){return "";}
	}
	public static String toDegree(int d){
		try{
			switch(d){
			case 0:{return "��";}
			case 1:{return "�ϼ�";}
			case 2:{return "��";}
			case 3:{return "������";}
			case 4:{return "����";}
			}
		}catch (Exception e){return null;}
		return null;
	}
	public static String toChapter(int c){
		try{
			switch(c){
			case 0:{return "������";}
			case 1:{return "���Ӳ���ԭ��";}
			case 2:{return "���ܷŴ�";}
			case 3:{return "�������";}
			case 4:{return "��·����ԭ��";}
			case 5:{return "����������";}
			case 6:{return "����Ŵ���";}
			case 7:{return "MSIʱ���߼�";}
			case 8:{return "����������";}
			case 9:{return "�˷�Ӧ��";}
			}
		}catch (Exception e){return null;}
		return null;
	}
	public static String toType(int d){
		try{
			switch(d){
			case 0:{return "ѡ����";}
			case 1:{return "�����";}
			case 2:{return "�ж���";}
			case 3:{return "�����";}
			}
		}catch (Exception e){return null;}
		return null;
	}
}




/*import java.sql.*;

public class GetConn {
	public Connection conn = null;
	public ResultSet rs = null;
	public Statement stmt = null;
	public GetConn() { 
	}

	public  Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
							"jdbc:mysql://222.20.74.80:3306/heke?useUnicode=true&characterEncoding=gb2312",
							"root", "002036");
		} catch (Exception e) {System.out.println(e);return null;}// �쳣����
		return conn;// ������Ҫ�󷵻ظ�Connection����
	}	

	public ResultSet executeQuery(String sql) {
		try {
			conn = getConnection();
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);	
		} catch (Exception e) {System.out.println(e);}
		return rs;
	}

	public int executeUpdate(String sql) {
		int result = 0;
		try {
			conn = getConnection();
			//System.out.println(conn==null);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			result = stmt.executeUpdate(sql);
		} catch (SQLException ex) {result = 0;}
			try {
				stmt.close();
			} catch (SQLException e) {e.printStackTrace();}
		return result;
	}
	
	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {e.printStackTrace(System.err);}
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (Exception e) {e.printStackTrace(System.err);}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {e.printStackTrace(System.err);}
	}
	
	public static String tolatin1(String strvalue){ 
		try{
			if(strvalue==null){
				return "";
			}else{
				strvalue=new String(strvalue.getBytes("UTF-8"),"latin1").trim();
				return strvalue;
			}
		}catch (Exception e){return "";}
		}
	public static String toGBK(String strvalue){
		try{
			if(strvalue==null){
				return "";
			}else{
				strvalue=new String(strvalue.getBytes("latin1"),"GBK").trim();
				return strvalue;
			}
		}catch (Exception e){return "";}
	}
}*/





