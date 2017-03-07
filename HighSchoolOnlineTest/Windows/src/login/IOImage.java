package login;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IOImage {		//IOImage类,存取二进制流
private java.sql.Connection conn = null;
private java.sql.PreparedStatement pstmt = null;
private ResultSet rs = null;

public int blobInsert(byte[] bytes,String id,int type) throws ClassNotFoundException, SQLException{  //将二进制流存入数据库方法
  	GetConn gc=new GetConn();		//连接数据库
    //conn = gc.getConnection();
    pstmt = GetConn.conn.prepareStatement("update questionbank"+type+" set image =? where id=?");		//更新数据库,将二进制流写入到数据库中
    pstmt.setBytes(1, bytes);
    pstmt.setString(2, id);
    int count=pstmt.executeUpdate();
    pstmt.close();
    gc.close();
    return count;		//返回count
   }

public byte[] readBolb(String id,int type) throws Exception{		//将二进制流从数据库中读出
   java.io.InputStream is = null;
	GetConn gc=new GetConn();		//连接数据库
    //conn = gc.getConnection();
    pstmt = GetConn.conn.prepareStatement("select image from questionbank"+type+" where id =?");		//从数据库中读出二进制流数据
    pstmt.setString(1, id);
    rs = pstmt.executeQuery();
    rs.next();
    java.sql.Blob blob = rs.getBlob("image");		//得到数据库表格中image对象
    try {
		is = blob.getBinaryStream();
	} catch (Exception e) {
		return null;
	}
    byte[] buffer = new byte[is.available()];
    is.read(buffer);
    is.close();
    pstmt.close();
    gc.close();
    return buffer;			//返回一个二进制流
}
}

