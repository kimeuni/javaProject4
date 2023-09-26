package longinSw;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class UserFindIdPw extends JFrame {

	private JPanel contentPane;
	
	UserSwVO vo = null;
	UserSwDAO dao = new UserSwDAO();
	int res = 0;
	private JTextField txtNameId;
	private JTextField txtEmailId;
	private JTextField txtIdPw;
	private JTextField txtEmailPw;
	
	private int idPwdCheck = 0;

	public UserFindIdPw() {
		super("아이디/비밀번호 찾기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 500);
		setLocationRelativeTo(null);
		
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(SystemColor.inactiveCaption);
		pn1.setBounds(0, 0, 434, 55);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JButton btnIdFind = new JButton("아이디 찾기");
		btnIdFind.setFont(new Font("굴림", Font.PLAIN, 14));
		btnIdFind.setBounds(36, 10, 163, 36);
		pn1.add(btnIdFind);
		
		JButton btnPwFind = new JButton("비밀번호 찾기");
		btnPwFind.setFont(new Font("굴림", Font.PLAIN, 14));
		btnPwFind.setBounds(235, 10, 163, 36);
		pn1.add(btnPwFind);
		
		JPanel pn2 = new JPanel();
		pn2.setLayout(null);
		pn2.setBackground(SystemColor.control);
		pn2.setBounds(0, 406, 434, 55);
		contentPane.add(pn2);
		
		JButton btnFind = new JButton("찾기");
		btnFind.setFont(new Font("굴림", Font.PLAIN, 14));
		btnFind.setBounds(24, 10, 112, 35);
		pn2.add(btnFind);
		
		JButton btnReset = new JButton("다시입력");
		btnReset.setFont(new Font("굴림", Font.PLAIN, 14));
		btnReset.setBounds(160, 10, 112, 35);
		pn2.add(btnReset);
		
		JButton btnExit = new JButton("창닫기");
		btnExit.setFont(new Font("굴림", Font.PLAIN, 14));
		btnExit.setBounds(296, 10, 112, 35);
		pn2.add(btnExit);
		
		JPanel pnPw = new JPanel();
		pnPw.setBounds(10, 65, 412, 330);
		contentPane.add(pnPw);
		pnPw.setLayout(null);
		
		JLabel lblIdPw = new JLabel("아이디");
		lblIdPw.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdPw.setFont(new Font("굴림", Font.PLAIN, 18));
		lblIdPw.setBounds(72, 51, 60, 53);
		pnPw.add(lblIdPw);
		
		JLabel lblEmailPw = new JLabel("이메일");
		lblEmailPw.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmailPw.setFont(new Font("굴림", Font.PLAIN, 18));
		lblEmailPw.setBounds(72, 138, 60, 53);
		pnPw.add(lblEmailPw);
		
		txtIdPw = new JTextField();
		txtIdPw.setFont(new Font("굴림", Font.PLAIN, 16));
		txtIdPw.setBounds(168, 51, 149, 43);
		pnPw.add(txtIdPw);
		txtIdPw.setColumns(10);
		
		txtEmailPw = new JTextField();
		txtEmailPw.setFont(new Font("굴림", Font.PLAIN, 16));
		txtEmailPw.setColumns(10);
		txtEmailPw.setBounds(168, 138, 149, 43);
		pnPw.add(txtEmailPw);
		
		JLabel lblPwMsg = new JLabel("");
		lblPwMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblPwMsg.setFont(new Font("굴림", Font.PLAIN, 18));
		lblPwMsg.setBounds(12, 238, 388, 53);
		pnPw.add(lblPwMsg);
		
		
		JPanel pnId = new JPanel();
		pnId.setBounds(10, 65, 412, 330);
		contentPane.add(pnId);
		pnId.setLayout(null);
		
		JLabel lblName = new JLabel("성명");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("굴림", Font.PLAIN, 18));
		lblName.setBounds(72, 51, 60, 53);
		pnId.add(lblName);
		
		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("굴림", Font.PLAIN, 18));
		lblEmail.setBounds(72, 138, 60, 53);
		pnId.add(lblEmail);
		
		txtNameId = new JTextField();
		txtNameId.setFont(new Font("굴림", Font.PLAIN, 16));
		txtNameId.setBounds(168, 51, 149, 43);
		pnId.add(txtNameId);
		txtNameId.setColumns(10);
		
		txtEmailId = new JTextField();
		txtEmailId.setFont(new Font("굴림", Font.PLAIN, 16));
		txtEmailId.setColumns(10);
		txtEmailId.setBounds(168, 138, 149, 43);
		pnId.add(txtEmailId);
		
		JLabel lblIdMsg = new JLabel("");
		lblIdMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdMsg.setFont(new Font("굴림", Font.PLAIN, 18));
		lblIdMsg.setBounds(12, 238, 388, 53);
		pnId.add(lblIdMsg);
		
		pnId.setVisible(false);
		pnPw.setVisible(false);
		
		/*============================================================*/
		
		// 아이디 찾기 버튼
		btnIdFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnId.setVisible(true);
				pnPw.setVisible(false);
				idPwdCheck = 1;
			}
		});
		
		// 비밀번호 찾기 버튼
		btnPwFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnId.setVisible(false);
				pnPw.setVisible(true);
				idPwdCheck = 2;
			}
		});
		
		// 찾기 버튼
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameId = txtNameId.getText();
				String emailId = txtEmailId.getText();
				String IdPw = txtIdPw.getText();
				String emailPw = txtEmailPw.getText();
				
				
				if(idPwdCheck == 1) {
					vo = dao.getFindid(nameId,emailId);
					System.out.println("vo : "+ vo);
					if(vo.getName() == null || vo.getEmail() == null) {
						JOptionPane.showMessageDialog(null, "존재하지 않는 회원입니다. 성명 및 이메일을 다시 확인해주세요.");
						btnReset.doClick();
						txtNameId.requestFocus();
						return;
					}
					else if(vo.getName().equals(nameId) && vo.getEmail().equals(emailId)) {
						lblIdMsg.setText(vo.getName() + "님의 아이디는 " + vo.getId() + "입니다.");
						btnReset.doClick();
						return;
					}
				}
				else {
					vo = dao.getFindPw(IdPw,emailPw);
					if(vo.getId() == null || vo.getEmail() == null) {
						JOptionPane.showMessageDialog(null, "존재하지 않는 회원입니다. 아이디 및 이메일을 다시 확인해주세요.");
						btnReset.doClick();
						txtNameId.requestFocus();
						return;
					}
					else if(vo.getId().equals(IdPw) && vo.getEmail().equals(emailPw)) {
						lblPwMsg.setText(vo.getName() + "님의 비밀번호는 " + vo.getPw() + "입니다.");
						btnReset.doClick();
					}
				}
			}
		});
		
		// 다시입력 버튼
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNameId.setText("");
				txtIdPw.setText("");
				txtEmailId.setText("");
				txtEmailPw.setText("");
			}
		});
		
		// 창닫기
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
