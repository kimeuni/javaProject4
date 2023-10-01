package BoardSw;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import longinSw.UserSwVO;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class HoiwonData extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtPw;
	private JTextField txtEmail;
	private JTextField txtName;
	private JTextField txtNickName;
	private JTextField txtAge;
	private JRadioButton rdMale, rdFemale;
	private ButtonGroup buttonGroup = new ButtonGroup();
	
	
	public HoiwonData(UserSwVO uVO) {
		super("회원 상세정보");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(712, 517);
		setLocationRelativeTo(null);
		
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 698, 480);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(uVO.getName() + " 회원님 정보");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 24));
		lblNewLabel.setBounds(12, 10, 351, 31);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 42, 674, 373);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		if(uVO.getGender().equals("남자")) {
			ImageIcon iconMale = new ImageIcon(UserMain.class.getResource("/longin/image/men.png"));
			Image imgMale =iconMale.getImage();
			Image updateImgMale = imgMale.getScaledInstance(183,169, Image.SCALE_SMOOTH);
			ImageIcon updateIconMale = new ImageIcon(updateImgMale);
			lblNewLabel_1.setIcon(updateIconMale);
			lblNewLabel_1.setBounds(12, 10, 168, 195);
			panel_1.add(lblNewLabel_1);
		}
		else {
			ImageIcon iconFemale = new ImageIcon(UserMain.class.getResource("/longin/image/Wmen.png"));
			Image imgFemale =iconFemale.getImage();
			Image updateImgFemale = imgFemale.getScaledInstance(183,169, Image.SCALE_SMOOTH);
			ImageIcon updateIconFemale = new ImageIcon(updateImgFemale);
			lblNewLabel_1.setIcon(updateIconFemale);
			lblNewLabel_1.setBounds(12, 10, 168, 195);
			panel_1.add(lblNewLabel_1);
		}
			
			JLabel lblId = new JLabel("아이디");
			lblId.setHorizontalAlignment(SwingConstants.CENTER);
			lblId.setFont(new Font("굴림", Font.PLAIN, 18));
			lblId.setBounds(265, 31, 95, 30);
			panel_1.add(lblId);
			
			txtId = new JTextField();
			txtId.setFont(new Font("굴림", Font.PLAIN, 16));
			txtId.setEditable(false);
			txtId.setBounds(376, 31, 215, 30);
			panel_1.add(txtId);
			txtId.setText(uVO.getId());
			txtId.setColumns(10);
			
			JLabel lblPw = new JLabel("비밀번호");
			lblPw.setHorizontalAlignment(SwingConstants.CENTER);
			lblPw.setFont(new Font("굴림", Font.PLAIN, 18));
			lblPw.setBounds(265, 71, 95, 30);
			panel_1.add(lblPw);
			
			txtPw = new JTextField();
			txtPw.setFont(new Font("굴림", Font.PLAIN, 16));
			txtPw.setEditable(false);
			txtPw.setColumns(10);
			txtPw.setBounds(376, 71, 215, 30);
			txtPw.setText(uVO.getPw());
			panel_1.add(txtPw);
			
			JLabel lblEmail = new JLabel("이메일");
			lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
			lblEmail.setFont(new Font("굴림", Font.PLAIN, 18));
			lblEmail.setBounds(265, 111, 95, 30);
			panel_1.add(lblEmail);
			
			txtEmail = new JTextField();
			txtEmail.setFont(new Font("굴림", Font.PLAIN, 16));
			txtEmail.setEditable(false);
			txtEmail.setColumns(10);
			txtEmail.setBounds(376, 111, 215, 30);
			txtEmail.setText(uVO.getEmail());
			panel_1.add(txtEmail);
			
			JLabel lblName = new JLabel("성명");
			lblName.setHorizontalAlignment(SwingConstants.CENTER);
			lblName.setFont(new Font("굴림", Font.PLAIN, 18));
			lblName.setBounds(265, 151, 95, 30);
			panel_1.add(lblName);
			
			txtName = new JTextField();
			txtName.setFont(new Font("굴림", Font.PLAIN, 16));
			txtName.setEditable(false);
			txtName.setColumns(10);
			txtName.setBounds(376, 151, 215, 30);
			txtName.setText(uVO.getName());
			panel_1.add(txtName);
			
			JLabel lblNickName = new JLabel("닉네임");
			lblNickName.setHorizontalAlignment(SwingConstants.CENTER);
			lblNickName.setFont(new Font("굴림", Font.PLAIN, 18));
			lblNickName.setBounds(265, 191, 95, 30);
			panel_1.add(lblNickName);
			
			txtNickName = new JTextField();
			txtNickName.setFont(new Font("굴림", Font.PLAIN, 16));
			txtNickName.setEditable(false);
			txtNickName.setColumns(10);
			txtNickName.setBounds(376, 191, 215, 30);
			txtNickName.setText(uVO.getNickName());
			panel_1.add(txtNickName);
			
			JLabel lblAge = new JLabel("나이");
			lblAge.setHorizontalAlignment(SwingConstants.CENTER);
			lblAge.setFont(new Font("굴림", Font.PLAIN, 18));
			lblAge.setBounds(265, 231, 95, 30);
			panel_1.add(lblAge);
			
			txtAge = new JTextField();
			txtAge.setFont(new Font("굴림", Font.PLAIN, 16));
			txtAge.setEditable(false);
			txtAge.setColumns(10);
			txtAge.setBounds(376, 231, 215, 30);
			txtAge.setText(uVO.getAge()+"");
			panel_1.add(txtAge);
			
			JLabel lblGender = new JLabel("성별");
			lblGender.setHorizontalAlignment(SwingConstants.CENTER);
			lblGender.setFont(new Font("굴림", Font.PLAIN, 18));
			lblGender.setBounds(265, 271, 95, 30);
			panel_1.add(lblGender);
			
			JLabel lblAdress = new JLabel("주소");
			lblAdress.setHorizontalAlignment(SwingConstants.CENTER);
			lblAdress.setFont(new Font("굴림", Font.PLAIN, 18));
			lblAdress.setBounds(265, 311, 95, 30);
			panel_1.add(lblAdress);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(376, 311, 215, 52);
			panel_1.add(scrollPane);
			
			JTextArea txtaAddress = new JTextArea();
			txtaAddress.setEditable(false);
			txtaAddress.setText(uVO.getAddress());
			scrollPane.setViewportView(txtaAddress);
			
			rdMale = new JRadioButton("남자");
			rdMale.setEnabled(false);
			rdMale.setFont(new Font("굴림", Font.PLAIN, 16));
			rdMale.setBounds(376, 267, 101, 30);
			buttonGroup.add(rdMale);
			panel_1.add(rdMale);
			
			rdFemale = new JRadioButton("여자");
			rdFemale.setEnabled(false);
			rdFemale.setFont(new Font("굴림", Font.PLAIN, 16));
			rdFemale.setBounds(490, 267, 101, 30);
			buttonGroup.add(rdMale);
			panel_1.add(rdFemale);
			
			if(uVO.getGender().equals("남자")) rdMale.setSelected(true);
			else rdFemale.setSelected(true);
				
	
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 425, 674, 45);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnBack = new JButton("나가기");
		btnBack.setBounds(567, 10, 95, 23);
		panel_2.add(btnBack);
		
		
		
		/* ================================================================== */
		
		// 나가기
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
