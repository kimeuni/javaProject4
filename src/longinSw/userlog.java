package longinSw;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import adminBoardSw.adminMain;
import userboardSw.UserMain;
import javax.swing.JPasswordField;

public class userlog extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JPasswordField txtPw;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userlog frame = new userlog();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public userlog() {
		super("로그인창");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 350);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 484, 252);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		lblNewLabel.setBounds(100, 81, 37, 38);
		pn1.add(lblNewLabel);
		
		JLabel lblPw = new JLabel("PW");
		lblPw.setFont(new Font("굴림", Font.PLAIN, 16));
		lblPw.setBounds(96, 150, 37, 38);
		pn1.add(lblPw);
		
		txtId = new JTextField();
		txtId.setBounds(164, 81, 219, 38);
		pn1.add(txtId);
		txtId.setColumns(10);
		
		txtPw = new JPasswordField();
		txtPw.setBounds(164, 150, 219, 38);
		pn1.add(txtPw);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 262, 484, 49);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JButton btnInput = new JButton("회원가입");
		btnInput.setFont(new Font("굴림", Font.PLAIN, 11));
		btnInput.setBounds(13, 10, 103, 33);
		pn2.add(btnInput);
		
		JButton btnSearch = new JButton("ID/PW 찾기");
		btnSearch.setFont(new Font("굴림", Font.PLAIN, 11));
		btnSearch.setBounds(129, 10, 103, 33);
		pn2.add(btnSearch);
		
		JButton btnLogin = new JButton("로그인");
		btnLogin.setFont(new Font("굴림", Font.PLAIN, 11));
		btnLogin.setBounds(245, 10, 103, 33);
		pn2.add(btnLogin);
		
		JButton btnExit = new JButton("종료");
		btnExit.setFont(new Font("굴림", Font.PLAIN, 11));
		btnExit.setBounds(361, 10, 106, 33);
		pn2.add(btnExit);
		
	
		/* =============================================================== */
		
		// 회원가입
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserInput();
			}
		});
		
		// ID/PW 찾기
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserFindIdPw();
			}
		});
		
		// 로그인
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtId.getText();
				String pw = txtPw.getText();
				UserSwDAO dao = new UserSwDAO();
				UserSwVO vo = dao.getIdSearch(id);
				
				if(id.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.");
					txtId.requestFocus();
				}
				else if(txtPw.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요.");
					txtPw.requestFocus();
				}
				else {
					vo = dao.getIdPwSearch(id,pw);
					if(vo.getId() == null) {
						JOptionPane.showMessageDialog(null, "없는 회원입니다. 아이디 혹은 비밀번호를 확인해주세요.");
						txtId.requestFocus();
						return;
					}
					else {
						if(vo.getAdminYN().equals("Y")) {
							new adminMain(vo);
							txtId.setText("");
							txtPw.setText("");
						}
						else if (vo.getAdminYN().equals("N")) {
							new UserMain(vo);
							txtId.setText("");
							txtPw.setText("");
						}
					}
				}
			}
		});
		
		// 종료버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
