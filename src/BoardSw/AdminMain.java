package BoardSw;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import longinSw.UserSwDAO;
import longinSw.UserSwVO;
import longinSw.userlog;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

public class AdminMain extends JFrame {

	private JPanel contentPane;
	private JTextField txtHoiwonSearch;
	private JTable uTable, rTable;
	private JComboBox cbHoiwonSearch;
	private Vector hoiwonTitle,userData,reportTitle,reportData;
	private DefaultTableModel uDtm, bDtm;
	private JTextField txtReportCondi;
	private JComboBox cbReportSearch;
	
	UserSwDAO uDAO = new UserSwDAO();
	BoardDAO bDAO = new BoardDAO();
	BoardVO bVO = null;
	int res = 0;

	@SuppressWarnings("unchecked")
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
		
		/*======================================================================================*/
		JPanel pnHoiwonCare = new JPanel();
		pnHoiwonCare.setBounds(310, 84, 712, 517);
		pabc.add(pnHoiwonCare);
		pnHoiwonCare.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 712, 51);
		pnHoiwonCare.add(panel_1);
		panel_1.setLayout(null);
		
		cbHoiwonSearch = new JComboBox();
		cbHoiwonSearch.setFont(new Font("굴림", Font.PLAIN, 16));
		cbHoiwonSearch.setModel(new DefaultComboBoxModel(new String[] {"", "성명", "나이", "성별", "닉네임", "아이디"}));
		cbHoiwonSearch.setBounds(12, 10, 81, 33);
		panel_1.add(cbHoiwonSearch);
		
		JButton btnNewButton_1 = new JButton("검색");
		btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 16));
		btnNewButton_1.setBounds(296, 10, 68, 33);
		panel_1.add(btnNewButton_1);
		
		txtHoiwonSearch = new JTextField();
		txtHoiwonSearch.setFont(new Font("굴림", Font.PLAIN, 16));
		txtHoiwonSearch.setBounds(107, 10, 177, 31);
		panel_1.add(txtHoiwonSearch);
		txtHoiwonSearch.setColumns(10);
		
		JButton btnAllList = new JButton("전체 리스트");
		btnAllList.setBounds(590, 10, 110, 33);
		panel_1.add(btnAllList);
		
		JPanel pnHoiwonBoard = new JPanel();
		pnHoiwonBoard.setBounds(0, 61, 712, 395);
		pnHoiwonCare.add(pnHoiwonBoard);
		pnHoiwonBoard.setLayout(null);
		
		JScrollPane spHoiwon = new JScrollPane();
		spHoiwon.setBounds(0, 0, 712, 395);
		pnHoiwonBoard.add(spHoiwon);
		
		// JTable
		hoiwonTitle = new Vector<>();
		hoiwonTitle.add("번호");
		hoiwonTitle.add("아이디");
		hoiwonTitle.add("성명");
		hoiwonTitle.add("닉네임");
		hoiwonTitle.add("나이");
		hoiwonTitle.add("성별");
		
		userData = uDAO.getUserTableList();
		
		uDtm = new DefaultTableModel(userData, hoiwonTitle);
		
		uTable = new JTable(uDtm);
		
		spHoiwon.setViewportView(uTable);
		
		tableCellAlign(uTable);
		//
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBounds(0, 466, 712, 51);
		pnHoiwonCare.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		JButton btnHoiwonDelete = new JButton("회원삭제");
		btnHoiwonDelete.setBounds(585, 10, 115, 31);
		panel_1_2.add(btnHoiwonDelete);
		
		JButton btnHoiwonDate = new JButton("상세정보");
		btnHoiwonDate.setBounds(458, 10, 115, 31);
		panel_1_2.add(btnHoiwonDate);
		
		JButton btnHoiwonBack = new JButton("나가기");
		btnHoiwonBack.setBounds(331, 10, 115, 31);
		panel_1_2.add(btnHoiwonBack);
		
		/*==========================================*/
		JPanel pnHoiwonReport = new JPanel();
		pnHoiwonReport.setBounds(310, 84, 712, 517);
		pabc.add(pnHoiwonReport);
		pnHoiwonReport.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 712, 51);
		pnHoiwonReport.add(panel_2);
		panel_2.setLayout(null);
		
		cbReportSearch = new JComboBox();
		cbReportSearch.setFont(new Font("굴림", Font.PLAIN, 16));
		cbReportSearch.setModel(new DefaultComboBoxModel(new String[] {"", "제목", "닉네임"}));
		cbReportSearch.setBounds(12, 10, 81, 33);
		panel_2.add(cbReportSearch);
		
		JButton btnNewButton_2 = new JButton("검색");
		btnNewButton_2.setFont(new Font("굴림", Font.PLAIN, 16));
		btnNewButton_2.setBounds(296, 10, 68, 33);
		panel_2.add(btnNewButton_2);
		
		txtReportCondi = new JTextField();
		txtReportCondi.setBounds(107, 10, 177, 31);
		panel_2.add(txtReportCondi);
		txtReportCondi.setColumns(10);
		
		JButton btnNewButton_2_1 = new JButton("전체리스트");
		btnNewButton_2_1.setBounds(590, 10, 110, 33);
		panel_2.add(btnNewButton_2_1);
		
		JPanel pnReportBoard = new JPanel();
		pnReportBoard.setBounds(0, 61, 712, 395);
		pnHoiwonReport.add(pnReportBoard);
		pnReportBoard.setLayout(null);
		
		JScrollPane spReport = new JScrollPane();
		spReport.setBounds(0, 0, 712, 395);
		pnReportBoard.add(spReport);
		
		// JTable
		reportTitle = new Vector<>();
		reportTitle.add("번호");
		reportTitle.add("카테고리");
		reportTitle.add("제목");
		reportTitle.add("작성자");
		reportTitle.add("날짜");
		reportTitle.add("좋아요");
		reportTitle.add("조회수");
		
		reportData = bDAO.getReportTableList("공지사항","Y","Y");
		
		bDtm = new DefaultTableModel(reportData, reportTitle);
		
		rTable = new JTable(bDtm);
		
		spReport.setViewportView(rTable);
		
		tableCellAlign(rTable);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBounds(0, 466, 712, 51);
		pnHoiwonReport.add(panel_1_3);
		panel_1_3.setLayout(null);
		
		JButton btnReportDelete = new JButton("삭제");
		btnReportDelete.setBounds(585, 10, 115, 31);
		panel_1_3.add(btnReportDelete);
		
		JButton btnReportDate = new JButton("상세정보");
		btnReportDate.setBounds(331, 10, 115, 31);
		panel_1_3.add(btnReportDate);
		
		JButton btnReportBack = new JButton("나가기");
		btnReportBack.setBounds(204, 10, 115, 31);
		panel_1_3.add(btnReportBack);
		
		JButton btnReportN = new JButton("문제없음");
		btnReportN.setBounds(458, 10, 115, 31);
		panel_1_3.add(btnReportN);
		
		
		
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
				pnHoiwonReport.setVisible(false);
				
			}
		});
		
		// 신고관리
		pnReport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnHoiwonCare.setVisible(false);
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
		
		/* ==================================================================== */
		/*  회원관리  */
		//나가기
		btnHoiwonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnHoiwonCare.setVisible(false);
				allUserList();
			}
		});
		
		// 상세보기
		btnHoiwonDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = uTable.getSelectedRow();
				int col = uTable.getSelectedColumn();
				
				if(row == -1 || col == -1) {
					JOptionPane.showMessageDialog(null, "회원을 선택해주세요.");
				}
				else {
					String id = uTable.getValueAt(row, 1).toString();
					
					UserSwVO uVO = new UserSwVO();
					uVO = uDAO.getIdSearch(id);
					
					new HoiwonData(uVO);
				}
			}
		});
		
		// 회원 삭제
		btnHoiwonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = uTable.getSelectedRow();
				
				String id = uTable.getValueAt(row, 1).toString();
				
				int ans = JOptionPane.showConfirmDialog(null, id + " 님의 계정을 삭제하시겠습니까?", "회원 삭제창", JOptionPane.YES_NO_OPTION);
				if(ans == 0) {
					res = uDAO.getDeleteHoiwon(id);
					if(res == 0) {
						JOptionPane.showMessageDialog(null, "알 수 없는 오류로 삭제에 실패하였습니다.");
					}
					else JOptionPane.showMessageDialog(null, id + " 님의 계정을 삭제하였습니다.");
					allUserList();
				}
				
			}
		});
		
		// 조건항목 검색버튼
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getHoiwonSearchProcess();
			}
		});
		
		// 조건항목 검색 키보드
		txtHoiwonSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) getHoiwonSearchProcess();
			}
		});
		
		// 전체 리스트
		btnAllList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allUserList();
			}
		});
		
		/* ==================================================================== */
		/*  신고관리  */
		//전체 리스트
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allReportList();
			}
		});
		
		// 나가기
		btnReportBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnHoiwonReport.setVisible(false);
				allReportList();
			}
		});
		
		// 문제없음
		btnReportN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = rTable.getSelectedRow();
				int col = rTable.getSelectedColumn();
				
				if(row == -1 || col == -1) {
					JOptionPane.showMessageDialog(null, "게시글을 선택해주세요.");
				}
				else {
					int idx = (int)rTable.getValueAt(row, 0);
					String nickName = rTable.getValueAt(row, 3).toString();
					
					int ans = JOptionPane.showConfirmDialog(null, "신고된 게시글에 문제가 없습니까?", "문제없음",JOptionPane.YES_NO_OPTION);
					if(ans == 0) {
						res = bDAO.setReportYN("N",idx,nickName);
						if(res == 0) JOptionPane.showMessageDialog(null, "알 수 없는 문제로 처리하지 못하였습니다.");
						else {
							JOptionPane.showMessageDialog(null, "신고가 취소되었습니다.");
							allReportList();
						}
					}
				}
			}
		});
		
		// 상세정보
		btnReportDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = rTable.getSelectedRow();
				int col = rTable.getSelectedColumn();
				
				if(row == -1 || col == -1) {
					JOptionPane.showMessageDialog(null, "게시글을 선택해주세요.");
				}
				else {
					int idx = (int)rTable.getValueAt(row, 0);
					String category = rTable.getValueAt(row, 1).toString();
					String title = rTable.getValueAt(row, 2).toString();
					String nickName = rTable.getValueAt(row, 3).toString();
					int ViewCnt = (int)rTable.getValueAt(row, 6);
					
					bVO = bDAO.getReadBoard(idx,category,title,nickName);
					
					new BoardRead(vo, bVO);
				}
				
			}
		});
		
		//삭제
		btnReportDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = rTable.getSelectedRow();
				
				bVO.setIdx((int)rTable.getValueAt(row, 0));
				bVO.setTitle(rTable.getValueAt(row, 2).toString());
				bVO.setNickName(rTable.getValueAt(row, 3).toString());
				
				int ans = JOptionPane.showConfirmDialog(null,"신고된 게시글을 삭제하시겠습니까?","신고게시판 삭제", JOptionPane.YES_NO_OPTION);
				if(ans == 0) {
					res = bDAO.setBoardDelet(bVO);
					if(res == 0){JOptionPane.showMessageDialog(null, "알 수 없는 오류로 삭제에 실패하였습니다.");
					}
					else JOptionPane.showMessageDialog(null, "신고된 게시글을 삭제했습니다.");
					allReportList();
				}
			}
		});
		
		// 조건항목 검색버튼
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getReportSeatchProcess();
			}
		});
		
		// 조건항목 검색 키보드
		txtReportCondi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) getReportSeatchProcess();
			}
		});
	}
	
	/* ==================================================================== */
	/* 불러와서 사용할 메소드들 */
	// 리스트 가운데로 정렬
	private void tableCellAlign(JTable tbl) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);	
		
		TableColumnModel tcm = tbl.getColumnModel();	
		
		for(int i=0; i<tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);	
		}
	}
	
	// 전체 신고 리스트 출력
	private void allReportList() {
		reportData = bDAO.getReportTableList("공지사항","Y","Y");
		bDtm.setDataVector(reportData, reportTitle);
		tableCellAlign(rTable);
	}
	
	// 전체 유저 리스트 호출
	private void allUserList() {
		userData = uDAO.getUserTableList();
		uDtm.setDataVector(userData, hoiwonTitle);
		tableCellAlign(uTable);
	}
	
	// 조건검색 항목 선택 후 입력필드 작성하면 수행될 내용
	private void getHoiwonSearchProcess() {
		String cbChoice = cbHoiwonSearch.getSelectedItem().toString();
		String txtSearchs = txtHoiwonSearch.getText();
		
		if(cbChoice.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "검색할 항목을 선택해주세요.");
			return;
		}
		else if(txtSearchs.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "검색할 내용을 입력해주세요.");
			return;
		}
		if(cbChoice.equals("성명")) userData = uDAO.getHoiwonSearch("name",txtSearchs);
		else if (cbChoice.equals("나이")) {
			if(!Pattern.matches("^[0-9]*$", txtSearchs)) {
				JOptionPane.showMessageDialog(null, "나이는 숫자로만 입력 가능합니다.");
				txtHoiwonSearch.requestFocus();
			}
			else userData = uDAO.getHoiwonSearch("age",txtSearchs);
		}
		else if(cbChoice.equals("성별")) userData = uDAO.getHoiwonSearch("gender",txtSearchs);
		else if(cbChoice.equals("닉네임")) userData = uDAO.getHoiwonSearch("nickName",txtSearchs);
		else if(cbChoice.equals("아이디")) userData = uDAO.getHoiwonSearch("id",txtSearchs);
		
		uDtm.setDataVector(userData, hoiwonTitle);
		tableCellAlign(uTable);
	}
	
	// 신고관리 조건항목 검색 프로세스
	private void getReportSeatchProcess() {
		String cbChoice = cbReportSearch.getSelectedItem().toString();
		String txtSearchs = txtReportCondi.getText();
		
		if(cbChoice.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "검색할 항목을 선택해주세요.");
			return;
		}
		else if(txtSearchs.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "검색할 내용을 입력해주세요.");
			return;
		}
		if(cbChoice.equals("제목")) reportData = bDAO.getReportCondiSeatch("title", txtSearchs,"Y");
		else if(cbChoice.equals("닉네임")) reportData = bDAO.getReportCondiSeatch("nickName", txtSearchs, "Y");
		bDtm.setDataVector(reportData, reportTitle);
		tableCellAlign(rTable);
	}
}
