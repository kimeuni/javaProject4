package BoardSw;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import longinSw.UserSwVO;
import longinSw.userlog;

@SuppressWarnings("serial")
public class MainBoards extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	public MainBoards(UserSwVO vo) {
		super("취미모아 게시판");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1050, 650);
		setLocationRelativeTo(null);
		
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pabc = new JPanel();
		pabc.setBackground(Color.WHITE);
		pabc.setBounds(0, 0, 1034, 611);
		contentPane.add(pabc);
		pabc.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 51, 153));
		panel.setBounds(0, 0, 298, 611);
		pabc.add(panel);
		panel.setLayout(null);
		
		JPanel pnNoticesButton = new JPanel();
		pnNoticesButton.setBackground(new Color(51, 102, 204));
		pnNoticesButton.setBounds(0, 160, 298, 53);
		panel.add(pnNoticesButton);
		pnNoticesButton.setLayout(null);
		
		JLabel lblNoticesImg = new JLabel("");
		ImageIcon icon1 = new ImageIcon(AdminMain.class.getResource("/longin/image/megaphone.png"));
		Image img1 =icon1.getImage();
		Image updateImg1 = img1.getScaledInstance(36,33, Image.SCALE_SMOOTH);
		ImageIcon updateIcon1 = new ImageIcon(updateImg1);
		lblNoticesImg.setIcon(updateIcon1);
		
		
		lblNoticesImg.setBounds(34, 10, 36, 33);
		pnNoticesButton.add(lblNoticesImg);
		
		JLabel lblNotices = new JLabel("공지사항");
		lblNotices.setForeground(Color.WHITE);
		lblNotices.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotices.setFont(new Font("굴림", Font.BOLD, 18));
		lblNotices.setBounds(70, 10, 202, 33);
		pnNoticesButton.add(lblNotices);
		
		JLabel lblNewLabel_2 = new JLabel("취미모아");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 24));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 30, 298, 47);
		panel.add(lblNewLabel_2);
		
		JPanel pnHoiwon = new JPanel();
		pnHoiwon.setLayout(null);
		pnHoiwon.setBackground(new Color(5, 58, 163));
		pnHoiwon.setBounds(0, 213, 298, 53);
		panel.add(pnHoiwon);
		
		JLabel lblBoardImg = new JLabel("");
		ImageIcon icon2 = new ImageIcon(AdminMain.class.getResource("/longin/image/board.png"));
		Image img2 =icon2.getImage();
		Image updateImg2 = img2.getScaledInstance(36,33, Image.SCALE_SMOOTH);
		ImageIcon updateIcon2 = new ImageIcon(updateImg2);
		lblBoardImg.setIcon(updateIcon2);
		lblBoardImg.setBounds(34, 10, 36, 33);
		pnHoiwon.add(lblBoardImg);
		
		JLabel lblBoard = new JLabel("게시물");
		lblBoard.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoard.setForeground(Color.WHITE);
		lblBoard.setFont(new Font("굴림", Font.BOLD, 18));
		lblBoard.setBounds(70, 10, 202, 33);
		pnHoiwon.add(lblBoard);
		ImageIcon icon3 = new ImageIcon(AdminMain.class.getResource("/longin/image/singo.png"));
		Image img3 =icon3.getImage();
		Image updateImg3 = img3.getScaledInstance(36,33, Image.SCALE_SMOOTH);
		ImageIcon updateIcon3 = new ImageIcon(updateImg3);
		
		JPanel pnExit = new JPanel();
		pnExit.setLayout(null);
		pnExit.setBackground(new Color(5, 58, 163));
		pnExit.setBounds(0, 558, 298, 53);
		panel.add(pnExit);
		
		JLabel lblExitImg = new JLabel("");
		ImageIcon icon5 = new ImageIcon(AdminMain.class.getResource("/longin/image/exit.png"));
		Image img5 =icon5.getImage();
		Image updateImg5 = img5.getScaledInstance(36,33, Image.SCALE_SMOOTH);
		ImageIcon updateIcon5 = new ImageIcon(updateImg5);
		lblExitImg.setIcon(updateIcon5);
		lblExitImg.setBounds(34, 10, 36, 33);
		pnExit.add(lblExitImg);
		
		JLabel lblExit = new JLabel("종료");
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setForeground(Color.WHITE);
		lblExit.setFont(new Font("굴림", Font.BOLD, 18));
		lblExit.setBounds(70, 10, 202, 33);
		pnExit.add(lblExit);
		
		JPanel pnLogout = new JPanel();
		pnLogout.setLayout(null);
		pnLogout.setBackground(new Color(5, 58, 163));
		pnLogout.setBounds(0, 505, 298, 53);
		panel.add(pnLogout);
		
		JLabel lblLogoutImg = new JLabel("");
		ImageIcon icon4 = new ImageIcon(AdminMain.class.getResource("/longin/image/logout.png"));
		Image img4 =icon4.getImage();
		Image updateImg4 = img4.getScaledInstance(36,33, Image.SCALE_SMOOTH);
		ImageIcon updateIcon4 = new ImageIcon(updateImg4);
		lblLogoutImg.setIcon(updateIcon4);
		lblLogoutImg.setBounds(34, 10, 36, 33);
		pnLogout.add(lblLogoutImg);
		
		JLabel lblLongout = new JLabel("로그아웃");
		lblLongout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLongout.setForeground(Color.WHITE);
		lblLongout.setFont(new Font("굴림", Font.BOLD, 18));
		lblLongout.setBounds(70, 10, 202, 33);
		pnLogout.add(lblLongout);
		
		JPanel pnBack = new JPanel();
		pnBack.setLayout(null);
		pnBack.setBackground(new Color(5, 58, 163));
		pnBack.setBounds(0, 452, 298, 53);
		panel.add(pnBack);
		
		JLabel lblLogoutImg_1 = new JLabel("");
		ImageIcon icon6 = new ImageIcon(AdminMain.class.getResource("/longin/image/logout.png"));
		Image img6 =icon6.getImage();
		Image updateImg6 = img6.getScaledInstance(36,33, Image.SCALE_SMOOTH);
		ImageIcon updateIcon6 = new ImageIcon(updateImg6);
		lblLogoutImg_1.setIcon(updateIcon6);
		lblLogoutImg_1.setBounds(34, 10, 36, 33);
		pnBack.add(lblLogoutImg_1);
		
		JLabel lblLongout_1 = new JLabel("게시판 나가기");
		lblLongout_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLongout_1.setForeground(Color.WHITE);
		lblLongout_1.setFont(new Font("굴림", Font.BOLD, 18));
		lblLongout_1.setBounds(70, 10, 202, 33);
		pnBack.add(lblLongout_1);
		
		JPanel pnW = new JPanel();
		pnW.setBackground(new Color(153, 204, 255));
		pnW.setBounds(298, 21, 736, 53);
		pabc.add(pnW);
		pnW.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel(vo.getNickName() + "님 환영합니다.");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 26));
		lblNewLabel_3.setBounds(0, 10, 736, 33);
		pnW.add(lblNewLabel_3);
		
		JPanel pnNotices = new JPanel();
		pnNotices.setBounds(310, 84, 712, 517);
		pabc.add(pnNotices);
		pnNotices.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 712, 51);
		pnNotices.add(panel_1);
		panel_1.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("굴림", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"제목", "내용"}));
		comboBox.setBounds(12, 10, 81, 33);
		panel_1.add(comboBox);
		
		textField = new JTextField();
		textField.setFont(new Font("굴림", Font.PLAIN, 16));
		textField.setBounds(105, 10, 185, 33);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("검색");
		btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 16));
		btnNewButton_1.setBounds(296, 10, 68, 33);
		panel_1.add(btnNewButton_1);
		
		JPanel pnNoticesBoard = new JPanel();
		pnNoticesBoard.setBounds(0, 61, 712, 395);
		pnNotices.add(pnNoticesBoard);
		pnNoticesBoard.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 712, 395);
		pnNoticesBoard.add(scrollPane);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBounds(0, 466, 712, 51);
		pnNotices.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		JButton btnNewButton = new JButton("글쓰기");
		btnNewButton.setBounds(585, 10, 115, 31);
		panel_1_2.add(btnNewButton);
		
		
		pnNotices.setVisible(false);
		
		/*===========================================================*/
		/*  메인메뉴 관리  */
		//공지사항
		pnNoticesButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnNotices.setVisible(true);
			}
		});
		
		
		// 메인메뉴 게시판 나가기
		pnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				if(vo.getId().equals("admin")) {
					new AdminMain(vo);
				}
				else new UserMain(vo);
			}
		});
		
		// 메인메뉴 로그아웃
		pnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new userlog();
			}
		});
		
		// 메인메뉴 종료
		pnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		// 공지사항 처리
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(vo.getId().equals("admin")) {
					new setUpdatenotices(vo);
				}
				else {
					JOptionPane.showMessageDialog(null, "공지사항은 관리자만 작성할 수 있습니다.");
				}
			}
		});
	}
}
