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



public class Binary extends JFrame{			//����Binary��,ʵ��image����Ͷ�������֮���ת��
	
	
	public Binary() {		//���췽��
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		JLabel lblJfie = new JLabel("jfie");
		lblJfie.setBounds(50, 209, 54, 15);
		panel.add(lblJfie);
		
		
	}
	
	public byte[] ImagetoByte(String sFileName) {		//ͼ�����������ת������
		if(sFileName.isEmpty()) return null;
		byte[] bytePicture=null;		//�����������bytePictureΪnull
		try {
			FileInputStream in = new FileInputStream(sFileName);		//����ַsFileNameΪ��ַ���ļ�
			bytePicture = new byte[in.available()];
			in.read(bytePicture);
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bytePicture;			//���ض�����������
	}
	
	
	
	ImageIcon BytetoImage(byte[] byteimage){		//����������ת��ΪImageIcon���󷽷�
		
		ByteArrayInputStream PicStream=new ByteArrayInputStream(byteimage);	//������������
		ImageIcon PicIcon=null;		//��PicIcon����Ϊ�յ�ImageIcon����
		try {
			Image Pic=ImageIO.read(PicStream);	//��������		
			PicIcon = new ImageIcon(Pic);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return PicIcon;		//����ImageIcon����
	}
	
	
	ImageIcon zoom(ImageIcon icon,int conWidth,int conHeight){		//ͼƬ���ŷ���,���ݹ̶��Ŀ�Ⱥ͸߶�������ͼƬ
		int imgWidth=icon.getIconWidth();		//�õ�ImageIcon����Ŀ��
		int imgHeight=icon.getIconHeight();		//�õ�ImageIcon����ĸ߶�
		int reImgWidth;
		int reImgHeight;
		if((double)imgWidth/(double)imgHeight>=(double)conWidth/(double)conHeight){		//��ʵ�ʿ�Ⱥ͸߶����趨��Ȳ�һ��
			if(imgWidth>conWidth){		//��ʵ�ʿ��>�趨���
				reImgWidth=conWidth;
				reImgHeight=reImgWidth*imgHeight/imgWidth;
			}else{
				reImgWidth=imgWidth;
				reImgHeight=imgHeight;
			} 
		}
		else{  
			if(imgHeight>conHeight){  	//��ʵ�ʸ߶ȴ����趨�߶�
				reImgHeight=conHeight;
				reImgWidth=reImgHeight*imgWidth/imgHeight;  
			}else{  
				reImgWidth=imgWidth;
				reImgHeight=imgHeight;  
			}  
		}  
		ImageIcon NewIcon=new ImageIcon(icon.getImage().getScaledInstance(reImgWidth, reImgHeight, Image.SCALE_SMOOTH));
		return NewIcon;		//�����޸ĺ��ImageIcon����
	}

	

}





