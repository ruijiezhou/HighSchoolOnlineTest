package login;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Popup extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Popup(int type) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("\u6B22\u8FCE\u60A8\uFF01");
		if(type==1)
		{
			
			JLabel lblNewLabel = new JLabel("\u6B63\u5728\u5C1D\u8BD5\u63A5\u5165\u7F51\u7EDC\uFF0C\u8BF7\u8010\u5FC3\u7B49\u5F85\u2026\u2026");
			lblNewLabel.setFont(new Font("隶书", Font.PLAIN, 20));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			getContentPane().add(lblNewLabel, BorderLayout.CENTER);
		}
		
		if(type==2)
		{
			JLabel lblNewLabel_1 = new JLabel("\u6B63\u5728\u63D0\u53D6\u8BD5\u5377\u53CA\u8003\u751F\u7B54\u5377\uFF0C\u8BF7\u7B49\u5F85\u2026\u2026");
			lblNewLabel_1.setFont(new Font("隶书", Font.PLAIN, 20));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			getContentPane().add(lblNewLabel_1, BorderLayout.CENTER);
		}
		
		if(type==3)
		{
			JLabel lblNewLabel_2 = new JLabel("\u6B63\u5728\u63D0\u53D6\u8BD5\u5377\uFF0C\u8BF7\u7A0D\u7B49\u2026\u2026");
			lblNewLabel_2.setFont(new Font("隶书", Font.PLAIN, 24));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			getContentPane().add(lblNewLabel_2, BorderLayout.CENTER);
		}
		
		this.setVisible(true);
		this.setBounds(100, 100, 356, 115);
		this.setLocation(400, 300);
		
		if(type==4)
		{
			JLabel lblNewLabel_3 = new JLabel("\u7EC4\u5377\u4E2D\uFF0C\u8BF7\u7A0D\u7B49\u2026\u2026");
			lblNewLabel_3.setFont(new Font("隶书", Font.PLAIN, 24));
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			getContentPane().add(lblNewLabel_3, BorderLayout.CENTER);
		}


	}

	
}
