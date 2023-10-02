package longinSw;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class UserInput extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtEmail;
	private JTextField txtName;
	private JTextField txtNickName;
	private JTextField txtAge;
	private JRadioButton rdMale, rdFemale;
	
	private JPasswordField txtPw;

	private ButtonGroup buttonGroup = new ButtonGroup();
	
	UserSwVO vo = null;
	UserSwDAO dao = new UserSwDAO();
	int res = 0;

	public UserInput() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(SystemColor.inactiveCaption);
		pn1.setBounds(0, 0, 384, 49);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회원가입");
		lblNewLabel.setForeground(SystemColor.window);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 360, 29);
		pn1.add(lblNewLabel);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 512, 384, 49);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		JButton btnInput = new JButton("가입하기");
		btnInput.setBounds(23, 10, 97, 29);
		pn3.add(btnInput);
		
		JButton btnReset = new JButton("다시입력");
		btnReset.setBounds(143, 10, 97, 29);
		pn3.add(btnReset);
		
		JButton btnExit = new JButton("창닫기");
		btnExit.setBounds(263, 10, 97, 29);
		pn3.add(btnExit);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 53, 384, 455);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lblId = new JLabel("아이디");
		lblId.setFont(new Font("굴림", Font.PLAIN, 14));
		lblId.setBounds(35, 20, 67, 29);
		pn2.add(lblId);
		
		JLabel lblPw = new JLabel("비밀번호");
		lblPw.setFont(new Font("굴림", Font.PLAIN, 14));
		lblPw.setBounds(35, 74, 67, 29);
		pn2.add(lblPw);
		
		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setFont(new Font("굴림", Font.PLAIN, 14));
		lblEmail.setBounds(35, 128, 67, 29);
		pn2.add(lblEmail);
		
		JLabel lblName = new JLabel("성명");
		lblName.setFont(new Font("굴림", Font.PLAIN, 14));
		lblName.setBounds(35, 182, 67, 29);
		pn2.add(lblName);
		
		JLabel lblNickName = new JLabel("닉네임");
		lblNickName.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNickName.setBounds(35, 236, 67, 29);
		pn2.add(lblNickName);
		
		JLabel lblAge = new JLabel("나이");
		lblAge.setFont(new Font("굴림", Font.PLAIN, 14));
		lblAge.setBounds(35, 290, 67, 29);
		pn2.add(lblAge);
		
		JLabel lblAddress = new JLabel("주소");
		lblAddress.setFont(new Font("굴림", Font.PLAIN, 14));
		lblAddress.setBounds(35, 398, 67, 29);
		pn2.add(lblAddress);
		
		txtId = new JTextField();
		txtId.setFont(new Font("굴림", Font.PLAIN, 14));
		txtId.setBounds(128, 20, 209, 29);
		pn2.add(txtId);
		txtId.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("굴림", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(128, 128, 209, 29);
		pn2.add(txtEmail);
		
		txtName = new JTextField();
		txtName.setFont(new Font("굴림", Font.PLAIN, 14));
		txtName.setColumns(10);
		txtName.setBounds(128, 182, 209, 29);
		pn2.add(txtName);
		
		txtNickName = new JTextField();
		txtNickName.setFont(new Font("굴림", Font.PLAIN, 14));
		txtNickName.setColumns(10);
		txtNickName.setBounds(128, 236, 209, 29);
		pn2.add(txtNickName);
		
		txtAge = new JTextField();
		txtAge.setFont(new Font("굴림", Font.PLAIN, 14));
		txtAge.setColumns(10);
		txtAge.setBounds(128, 290, 209, 29);
		pn2.add(txtAge);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(128, 398, 209, 43);
		pn2.add(scrollPane);
		
		JTextArea txtaAddress = new JTextArea();
		scrollPane.setViewportView(txtaAddress);
		
		rdMale = new JRadioButton("남자");
		rdMale.setSelected(true);
		rdMale.setFont(new Font("굴림", Font.PLAIN, 14));
		rdMale.setBounds(128, 344, 80, 29);
		buttonGroup.add(rdMale);
		pn2.add(rdMale);
		
		rdFemale = new JRadioButton("여자");
		rdFemale.setFont(new Font("굴림", Font.PLAIN, 14));
		rdFemale.setBounds(257, 344, 80, 29);
		buttonGroup.add(rdFemale);
		pn2.add(rdFemale);
		
		JLabel lblGender = new JLabel("성별");
		lblGender.setFont(new Font("굴림", Font.PLAIN, 14));
		lblGender.setBounds(35, 344, 67, 29);
		pn2.add(lblGender);
		
		txtPw = new JPasswordField();
		txtPw.setBounds(128, 70, 209, 33);
		pn2.add(txtPw);
		
		/* ===================================================== */
		
		// 가입하기
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtId.getText();
				String pw = txtPw.getText();
				String email = txtEmail.getText();
				String name = txtName.getText();
				String nickName = txtNickName.getText();
				String age = txtAge.getText();
				String gender;
				String address = txtaAddress.getText();
				
				// 유효성 검사
				if(!Pattern.matches("^[a-z0-9]{5,20}$", id)) {
					JOptionPane.showMessageDialog(null, "아이디는 5~20자 사이, 영문소문자와 숫자로만 입력 가능합니다.");
					txtId.requestFocus();
				}
				else if(!Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$", pw)) {
					JOptionPane.showMessageDialog(null, "비밀번호는 8~20자 사이, 소문자,대문자,숫자,특수문자를 1개 이상 입력해야 합니다.");
					txtPw.requestFocus();
				}
				else if(!Pattern.matches("^[a-zA-Z0-9]{3,20}+@[a-z]{2,10}+\\.[a-z]+$", email)) {
					JOptionPane.showMessageDialog(null, "이메일 앞자리는 3~20자 사이로 적으셔야 합니다.(ex)qwer1245@naver.com");
					txtEmail.requestFocus();
				}
				else if(name.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "성명을 적어주세요.");
					txtName.requestFocus();
				}
				else if(nickName.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "닉네임을 입력하세요.");
					txtNickName.requestFocus();
				}
				else if(nickName.length() >=9) {
					JOptionPane.showMessageDialog(null, "닉네임은 최대 8글자까지 작성할 수 있습니다.");
					txtNickName.requestFocus();
				}
				else if(age.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "나이는 숫자로만 입력 가능합니다.");
					txtAge.requestFocus();
				}
				else if(!Pattern.matches("^[0-9]*$", age)) {
					JOptionPane.showMessageDialog(null, "나이는 숫자로만 입력 가능합니다.");
					txtAge.requestFocus();
				}
				else {
					if(rdMale.isSelected()) gender = "남자";
					else gender ="여자";
					
					// 중복 검사
					// 아이디
					vo = dao.getIdSearch(id);
					if(vo.getId() != null) {
						JOptionPane.showMessageDialog(null, "현재 사용중인 아이디 입니다.");
						txtId.requestFocus();
						return;
					}
					// 닉네임
					vo = dao.getNameSearch(nickName);
					if(vo.getNickName() != null) {
						JOptionPane.showMessageDialog(null, "현재 사용중인 닉네임 입니다.");
						txtNickName.requestFocus();
						return;
					}
					vo = dao.getEmailSearch(email);
					if(vo.getEmail() != null) {
						JOptionPane.showMessageDialog(null, "현재 사용중인 이메일 입니다.");
						txtEmail.requestFocus();
					}
					else {
						vo.setId(id);
						vo.setPw(pw);
						vo.setEmail(email);
						vo.setName(name);
						vo.setNickName(nickName);
						vo.setAge(Integer.parseInt(age));
						vo.setGender(gender);
						vo.setAddress(address);
						
						// 유저 테이블에 저장
						res = dao.setUserSwInput(vo);
						if(res == 0) {
							JOptionPane.showMessageDialog(null, "회원가입에 실패했습니다. 다시 확인해주세요.");							
						}
						else {
							JOptionPane.showMessageDialog(null, "회원가입 되었습니다.");
							// 초기화
							btnReset.doClick();
						}
					}
				}
				
			}
		});
		
		// 다시입력
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtId.setText("");
				txtPw.setText("");
				txtEmail.setText("");
				txtName.setText("");
				txtNickName.setText("");
				txtAge.setText("");
				rdMale.setSelected(true);
				txtaAddress.setText("");
			}
		});
		
		// 창닫기
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new userlog();
			}
		});
	}
}
