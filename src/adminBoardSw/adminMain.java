package adminBoardSw;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import longinSw.UserSwVO;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class adminMain extends JFrame {

	private JPanel contentPane;

	public adminMain(UserSwVO vo) {
		super("관리창");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(850, 600);
		setLocationRelativeTo(null);
		
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnMenu = new JPanel();
		pnMenu.setBackground(new Color(0, 128, 192));
		pnMenu.setBounds(0, 0, 246, 561);
		contentPane.add(pnMenu);
		pnMenu.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("취미모아");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 28));
		lblNewLabel_1.setBounds(12, 23, 222, 40);
		pnMenu.add(lblNewLabel_1);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(SystemColor.inactiveCaption);
		pn1.setBounds(246, 10, 588, 38);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("관리자님 환영합니다.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(12, 0, 564, 38);
		pn1.add(lblNewLabel);
	}
}
