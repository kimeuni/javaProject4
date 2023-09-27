package BoardSw;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import longinSw.UserSwVO;
import longinSw.userlog;

public class AdminMain extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	public AdminMain(UserSwVO vo) {
		super("관리창");
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
		panel.setBackground(new Color(75, 0, 130));
		panel.setBounds(0, 0, 298, 611);
		pabc.add(panel);
		panel.setLayout(null);
		
		JPanel pnMain = new JPanel();
		pnMain.setBackground(new Color(153, 0, 255));
		pnMain.setBounds(0, 160, 298, 53);
		panel.add(pnMain);
		pnMain.setLayout(null);
		
		JLabel lblMainImg = new JLabel("");
		ImageIcon icon1 = new ImageIcon(AdminMain.class.getResource("/longin/image/board.png"));
		Image img1 =icon1.getImage();
		Image updateImg1 = img1.getScaledInstance(36,33, Image.SCALE_SMOOTH);
		ImageIcon updateIcon1 = new ImageIcon(updateImg1);
		lblMainImg.setIcon(updateIcon1);
		
		
		lblMainImg.setBounds(34, 10, 36, 33);
		pnMain.add(lblMainImg);
		
		JLabel lblMain = new JLabel("메인 게시판");
		lblMain.setForeground(Color.WHITE);
		lblMain.setHorizontalAlignment(SwingConstants.CENTER);
		lblMain.setFont(new Font("굴림", Font.BOLD, 18));
		lblMain.setBounds(70, 10, 202, 33);
		pnMain.add(lblMain);
		
		JLabel lblNewLabel_2 = new JLabel("취미모아");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 24));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 30, 298, 47);
		panel.add(lblNewLabel_2);
		
		JPanel pnHoiwon = new JPanel();
		pnHoiwon.setLayout(null);
		pnHoiwon.setBackground(new Color(80, 4, 135));
		pnHoiwon.setBounds(0, 213, 298, 53);
		panel.add(pnHoiwon);
		
		JLabel lblHoiwonImg = new JLabel("");
		ImageIcon icon2 = new ImageIcon(AdminMain.class.getResource("/longin/image/sarams.png"));
		Image img2 =icon2.getImage();
		Image updateImg2 = img2.getScaledInstance(36,33, Image.SCALE_SMOOTH);
		ImageIcon updateIcon2 = new ImageIcon(updateImg2);
		lblHoiwonImg.setIcon(updateIcon2);
		lblHoiwonImg.setBounds(34, 10, 36, 33);
		pnHoiwon.add(lblHoiwonImg);
		
		JLabel lblHoiwon = new JLabel("회원관리");
		lblHoiwon.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoiwon.setForeground(Color.WHITE);
		lblHoiwon.setFont(new Font("굴림", Font.BOLD, 18));
		lblHoiwon.setBounds(70, 10, 202, 33);
		pnHoiwon.add(lblHoiwon);
		
		JPanel pnReport = new JPanel();
		pnReport.setLayout(null);
		pnReport.setBackground(new Color(80, 4, 135));
		pnReport.setBounds(0, 265, 298, 53);
		panel.add(pnReport);
		
		JLabel lblReportImg = new JLabel("");
		ImageIcon icon3 = new ImageIcon(AdminMain.class.getResource("/longin/image/singo.png"));
		Image img3 =icon3.getImage();
		Image updateImg3 = img3.getScaledInstance(36,33, Image.SCALE_SMOOTH);
		ImageIcon updateIcon3 = new ImageIcon(updateImg3);
		lblReportImg.setIcon(updateIcon3);
		lblReportImg.setBounds(34, 10, 36, 33);
		pnReport.add(lblReportImg);
		
		JLabel lblReport = new JLabel("신고관리");
		lblReport.setHorizontalAlignment(SwingConstants.CENTER);
		lblReport.setForeground(Color.WHITE);
		lblReport.setFont(new Font("굴림", Font.BOLD, 18));
		lblReport.setBounds(70, 10, 202, 33);
		pnReport.add(lblReport);
		
		JPanel pnExit = new JPanel();
		pnExit.setLayout(null);
		pnExit.setBackground(new Color(80, 4, 135));
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
		pnLogout.setBackground(new Color(80, 4, 135));
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
		
		JPanel pninsa = new JPanel();
		pninsa.setBackground(new Color(147, 112, 219));
		pninsa.setBounds(298, 21, 736, 53);
		pabc.add(pninsa);
		pninsa.setLayout(null);
		
		JLabel lblinsa = new JLabel("관리자님 어서오세요.");
		lblinsa.setHorizontalAlignment(SwingConstants.CENTER);
		lblinsa.setForeground(Color.WHITE);
		lblinsa.setFont(new Font("굴림", Font.BOLD, 26));
		lblinsa.setBounds(0, 10, 736, 33);
		pninsa.add(lblinsa);
		
		JPanel pnHoiwonCare = new JPanel();
		pnHoiwonCare.setBounds(310, 84, 712, 517);
		pabc.add(pnHoiwonCare);
		pnHoiwonCare.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 712, 51);
		pnHoiwonCare.add(panel_1);
		panel_1.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("굴림", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "이름", "나이", "성별", "닉네임", "아이디", "이메일", "주소"}));
		comboBox.setBounds(12, 10, 81, 33);
		panel_1.add(comboBox);
		
		JButton btnNewButton_1 = new JButton("검색");
		btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 16));
		btnNewButton_1.setBounds(296, 10, 68, 33);
		panel_1.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setFont(new Font("굴림", Font.PLAIN, 16));
		textField.setBounds(107, 10, 177, 31);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel pnHoiwonBoard = new JPanel();
		pnHoiwonBoard.setBounds(0, 61, 712, 395);
		pnHoiwonCare.add(pnHoiwonBoard);
		pnHoiwonBoard.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 712, 395);
		pnHoiwonBoard.add(scrollPane);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBounds(0, 466, 712, 51);
		pnHoiwonCare.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		JButton btnHoiwonDelete = new JButton("삭제");
		btnHoiwonDelete.setBounds(585, 10, 115, 31);
		panel_1_2.add(btnHoiwonDelete);
		
		JButton btnHoiwonDate = new JButton("상세정보");
		btnHoiwonDate.setBounds(458, 10, 115, 31);
		panel_1_2.add(btnHoiwonDate);
		
		/*==========================================*/
		JPanel pnHoiwonReport = new JPanel();
		pnHoiwonReport.setBounds(310, 84, 712, 517);
		pabc.add(pnHoiwonReport);
		pnHoiwonReport.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 712, 51);
		pnHoiwonReport.add(panel_2);
		panel_2.setLayout(null);
		
		JComboBox cbReportSearch = new JComboBox();
		cbReportSearch.setFont(new Font("굴림", Font.PLAIN, 16));
		cbReportSearch.setModel(new DefaultComboBoxModel(new String[] {"", "이름", "나이", "성별", "닉네임", "아이디", "이메일", "주소"}));
		cbReportSearch.setBounds(12, 10, 81, 33);
		panel_2.add(cbReportSearch);
		
		JButton btnNewButton_2 = new JButton("검색");
		btnNewButton_2.setFont(new Font("굴림", Font.PLAIN, 16));
		btnNewButton_2.setBounds(296, 10, 68, 33);
		panel_2.add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setFont(new Font("굴림", Font.PLAIN, 16));
		textField.setBounds(107, 10, 177, 31);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JPanel pnReportBoard = new JPanel();
		pnReportBoard.setBounds(0, 61, 712, 395);
		pnHoiwonReport.add(pnReportBoard);
		pnReportBoard.setLayout(null);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(0, 0, 712, 395);
		pnReportBoard.add(scrollPane1);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBounds(0, 466, 712, 51);
		pnHoiwonReport.add(panel_1_3);
		panel_1_3.setLayout(null);
		
		JButton btnReportDelete = new JButton("삭제");
		btnReportDelete.setBounds(585, 10, 115, 31);
		panel_1_3.add(btnReportDelete);
		
		JButton btnReportDate = new JButton("상세정보");
		btnReportDate.setBounds(458, 10, 115, 31);
		panel_1_3.add(btnReportDate);
		
		
		
		pnHoiwonCare.setVisible(false);
		pnHoiwonReport.setVisible(false);
		/*===========================================================*/
		/* 메인 메뉴 처리 */
		
		// 게시판 
		pnMain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new MainBoards(vo);
			}
		});
		
		// 회원관리
		pnHoiwon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnHoiwonCare.setVisible(true);
				
			}
		});
		
		// 신고관리
		pnReport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnHoiwonReport.setVisible(true);
			}
		});
		
		// 로그아웃
		pnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new userlog();
			}
		});
		
		// 종료
		pnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnExit.setBackground(new Color(153, 0, 255));
				System.exit(0);
			}
		});
	}
}
