package userboardSw;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import longinSw.UserSwVO;

public class UserMain extends JFrame {

	private JPanel contentPane;
	
	
	public UserMain(UserSwVO vo) {
		super("취미모아 게시판");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(850, 600);
		setLocationRelativeTo(null);
		
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnMenu = new JPanel();
		pnMenu.setBackground(new Color(75, 0, 130));
		pnMenu.setBounds(0, 0, 246, 561);
		contentPane.add(pnMenu);
		pnMenu.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("취미모아");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 28));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(12, 23, 222, 40);
		pnMenu.add(lblNewLabel);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(new Color(153, 102, 255));
		pn1.setBounds(246, 10, 588, 38);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel(vo.getNickName() + "님 환영합니다.");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(12, 0, 564, 38);
		pn1.add(lblNewLabel_1);
	}

}
