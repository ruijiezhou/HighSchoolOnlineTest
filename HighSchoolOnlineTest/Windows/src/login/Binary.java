package login;

import java.awt.event.ActionEvent;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JTextPane;



public class Binary extends JFrame{			//定义Binary类,实现image对象和二进制流之间的转换
	
	
	public Binary() {		//构造方法
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		JLabel lblJfie = new JLabel("jfie");
		lblJfie.setBounds(50, 209, 54, 15);
		panel.add(lblJfie);
		
		
	}
	
	public byte[] ImagetoByte(String sFileName) {		//图像向二进制流转换方法
		if(sFileName.isEmpty()) return null;
		byte[] bytePicture=null;		//定义二进制流bytePicture为null
		try {
			FileInputStream in = new FileInputStream(sFileName);		//将地址sFileName为地址的文件
			bytePicture = new byte[in.available()];
			in.read(bytePicture);
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bytePicture;			//返回二进制流对象
	}
	
	
	
	ImageIcon BytetoImage(byte[] byteimage){		//将二进制流转换为ImageIcon对象方法
		
		ByteArrayInputStream PicStream=new ByteArrayInputStream(byteimage);	//二进制流对象
		ImageIcon PicIcon=null;		//将PicIcon定义为空的ImageIcon对象
		try {
			Image Pic=ImageIO.read(PicStream);	//读出数据		
			PicIcon = new ImageIcon(Pic);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return PicIcon;		//返回ImageIcon对象
	}
	
	
	ImageIcon zoom(ImageIcon icon,int conWidth,int conHeight){		//图片缩放方法,根据固定的宽度和高度来缩放图片
		int imgWidth=icon.getIconWidth();		//得到ImageIcon对象的宽度
		int imgHeight=icon.getIconHeight();		//得到ImageIcon对象的高度
		int reImgWidth;
		int reImgHeight;
		if((double)imgWidth/(double)imgHeight>=(double)conWidth/(double)conHeight){		//若实际宽度和高度与设定宽度不一致
			if(imgWidth>conWidth){		//若实际宽度>设定宽度
				reImgWidth=conWidth;
				reImgHeight=reImgWidth*imgHeight/imgWidth;
			}else{
				reImgWidth=imgWidth;
				reImgHeight=imgHeight;
			} 
		}
		else{  
			if(imgHeight>conHeight){  	//若实际高度大于设定高度
				reImgHeight=conHeight;
				reImgWidth=reImgHeight*imgWidth/imgHeight;  
			}else{  
				reImgWidth=imgWidth;
				reImgHeight=imgHeight;  
			}  
		}  
		ImageIcon NewIcon=new ImageIcon(icon.getImage().getScaledInstance(reImgWidth, reImgHeight, Image.SCALE_SMOOTH));
		return NewIcon;		//返回修改后的ImageIcon对象
	}

	

}





