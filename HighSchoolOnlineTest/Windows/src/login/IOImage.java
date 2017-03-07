package login;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IOImage {		//IOImage��,��ȡ��������
private java.sql.Connection conn = null;
private java.sql.PreparedStatement pstmt = null;
private ResultSet rs = null;

public int blobInsert(byte[] bytes,String id,int type) throws ClassNotFoundException, SQLException{  //�����������������ݿⷽ��
  	GetConn gc=new GetConn();		//�������ݿ�
    //conn = gc.getConnection();
    pstmt = GetConn.conn.prepareStatement("update questionbank"+type+" set image =? where id=?");		//�������ݿ�,����������д�뵽���ݿ���
    pstmt.setBytes(1, bytes);
    pstmt.setString(2, id);
    int count=pstmt.executeUpdate();
    pstmt.close();
    gc.close();
    return count;		//����count
   }

public byte[] readBolb(String id,int type) throws Exception{		//���������������ݿ��ж���
   java.io.InputStream is = null;
	GetConn gc=new GetConn();		//�������ݿ�
    //conn = gc.getConnection();
    pstmt = GetConn.conn.prepareStatement("select image from questionbank"+type+" where id =?");		//�����ݿ��ж���������������
    pstmt.setString(1, id);
    rs = pstmt.executeQuery();
    rs.next();
    java.sql.Blob blob = rs.getBlob("image");		//�õ����ݿ�����image����
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
    return buffer;			//����һ����������
}
}

