package BoardSw;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ButtonGroup;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import longinSw.UserSwVO;
import longinSw.userlog;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class MainBoards extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPaneBo, scrollPaneNot;
	private DefaultTableModel notDtm, boDtm;
	private JTable notTable, boTable;
	private JRadioButton rdAll,rdGame, rdWebt, rdDoll, rdEx, rdPassion;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtBoardCondi, txtNotCondi;
	private JComboBox cbBoardCondi, cbNotChoice;
	
	private Vector noticesTitle, nData, BoardTitle, bData;
	
	BoardDAO dao = new BoardDAO();
	BoardVO bVO = null;
	int btnCheck;
	String cbChoiceB, txtCondiB, cbChoiceN, txtCondiN;

	@SuppressWarnings("unchecked")
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
		pnNoticesButton.setBackground(new Color(5, 58, 163));
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
		
		JLabel lblBoard = new JLabel("게시판");
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
		
		/*===========================================*/
		//공지사항
		JPanel pnNotices = new JPanel();
		pnNotices.setBounds(310, 84, 712, 517);
		pabc.add(pnNotices);
		pnNotices.setLayout(null);
		
		JPanel pnSeatch = new JPanel();
		pnSeatch.setBounds(0, 0, 712, 51);
		pnNotices.add(pnSeatch);
		pnSeatch.setLayout(null);
		
		cbNotChoice = new JComboBox();
		cbNotChoice.setFont(new Font("굴림", Font.PLAIN, 16));
		cbNotChoice.setModel(new DefaultComboBoxModel(new String[] {"", "제목", "닉네임"}));
		cbNotChoice.setBounds(12, 10, 81, 33);
		pnSeatch.add(cbNotChoice);
		
		txtNotCondi = new JTextField();
		txtNotCondi.setFont(new Font("굴림", Font.PLAIN, 16));
		txtNotCondi.setBounds(105, 10, 185, 33);
		pnSeatch.add(txtNotCondi);
		txtNotCondi.setColumns(10);
		
		JButton btnNotSeatch = new JButton("검색");
		btnNotSeatch.setFont(new Font("굴림", Font.PLAIN, 16));
		btnNotSeatch.setBounds(296, 10, 68, 33);
		pnSeatch.add(btnNotSeatch);
		
		JButton btnNotRef = new JButton("새로고침");
		btnNotRef.setFont(new Font("굴림", Font.PLAIN, 16));
		btnNotRef.setBounds(589, 10, 111, 33);
		pnSeatch.add(btnNotRef);
		
		JPanel pnNoticesBoard = new JPanel();
		pnNoticesBoard.setBounds(0, 61, 712, 395);
		pnNotices.add(pnNoticesBoard);
		pnNoticesBoard.setLayout(null);
		
		noticesTitle = new Vector<>();
		noticesTitle.add("번호");
		noticesTitle.add("카테고리");
		noticesTitle.add("제목");
		noticesTitle.add("작성자");
		noticesTitle.add("날짜");
		noticesTitle.add("좋아요");
		noticesTitle.add("조회수");
		
		nData = dao.getNotBoardList("category","공지사항","Y");
		
		notDtm = new DefaultTableModel(nData, noticesTitle);
		
		notTable = new JTable(notDtm);
		
		tableCellAlign(notTable);
		
		notListSize();
		
		scrollPaneNot = new JScrollPane(notTable);
		scrollPaneNot.setBounds(0, 0, 712, 395);
		pnNoticesBoard.add(scrollPaneNot);
		
		JPanel pnButton = new JPanel();
		pnButton.setBounds(0, 466, 712, 51);
		pnNotices.add(pnButton);
		pnButton.setLayout(null);
		
		JButton btnWrite = new JButton("글쓰기");
		btnWrite.setBounds(585, 10, 115, 31);
		pnButton.add(btnWrite);
		
		JButton btnRead = new JButton("글보기");
		btnRead.setBounds(449, 10, 115, 31);
		pnButton.add(btnRead);
		
		JButton btnBack = new JButton("나가기");
		btnBack.setBounds(311, 10, 115, 31);
		pnButton.add(btnBack);
		/*========================================================*/
		// 게시판
		JPanel pnBoard = new JPanel();
		pnBoard.setBounds(310, 84, 712, 517);
		pabc.add(pnBoard);
		pnBoard.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 712, 51);
		pnBoard.add(panel_1);
		panel_1.setLayout(null);
		
		rdAll = new JRadioButton("전체");
		rdAll.setSelected(true);
		rdAll.setBounds(41, 6, 61, 39);
		buttonGroup.add(rdAll);
		panel_1.add(rdAll);
		
		rdGame = new JRadioButton("게임");
		rdGame.setBounds(143, 6, 61, 39);
		buttonGroup.add(rdGame);
		panel_1.add(rdGame);
		
		rdWebt = new JRadioButton("웹툰/소설");
		rdWebt.setBounds(245, 6, 99, 39);
		buttonGroup.add(rdWebt);
		panel_1.add(rdWebt);
		
		rdDoll = new JRadioButton("인형");
		rdDoll.setBounds(385, 6, 67, 39);
		buttonGroup.add(rdDoll);
		panel_1.add(rdDoll);
		
		rdEx = new JRadioButton("운동");
		rdEx.setBounds(493, 6, 67, 39);
		buttonGroup.add(rdEx);
		panel_1.add(rdEx);
		
		rdPassion = new JRadioButton("패션");
		rdPassion.setBounds(601, 6, 67, 39);
		buttonGroup.add(rdPassion);
		panel_1.add(rdPassion);
		
		JPanel pnBoards = new JPanel();
		pnBoards.setBounds(0, 53, 712, 355);
		pnBoard.add(pnBoards);
		pnBoards.setLayout(null);
		
		BoardTitle = new Vector<>();
		BoardTitle.add("번호");
		BoardTitle.add("카테고리");
		BoardTitle.add("제목");
		BoardTitle.add("작성자");
		BoardTitle.add("날짜");
		BoardTitle.add("좋아요");
		BoardTitle.add("조회수");
		
		bData = dao.getBoardList("공지사항","Y");
		
		boDtm = new DefaultTableModel(bData, BoardTitle);
		
		boTable = new JTable(boDtm);
		
		tableCellAlign(boTable);
		
		boardListSize();
		
		scrollPaneBo = new JScrollPane(boTable);
		scrollPaneBo.setBounds(0, 0, 712, 355);
		pnBoards.add(scrollPaneBo);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBounds(0, 466, 712, 51);
		pnBoard.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		JButton btnBoardWrite = new JButton("글쓰기");
		btnBoardWrite.setBounds(585, 10, 115, 31);
		panel_1_2.add(btnBoardWrite);
		
		JButton btnBoardRead = new JButton("글보기");
		btnBoardRead.setBounds(449, 10, 115, 31);
		panel_1_2.add(btnBoardRead);
		
		JButton btnBoardBack = new JButton("나가기");
		btnBoardBack.setBounds(311, 10, 115, 31);
		panel_1_2.add(btnBoardBack);
		
		JButton btnBoardRef = new JButton("새로고침");
		btnBoardRef.setBounds(12, 8, 111, 33);
		panel_1_2.add(btnBoardRef);
		btnBoardRef.setFont(new Font("굴림", Font.PLAIN, 16));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 412, 712, 49);
		pnBoard.add(panel_2);
		panel_2.setLayout(null);
		
		cbBoardCondi = new JComboBox();
		cbBoardCondi.setModel(new DefaultComboBoxModel(new String[] {"", "제목", "닉네임"}));
		cbBoardCondi.setBounds(158, 10, 102, 29);
		panel_2.add(cbBoardCondi);
		
		txtBoardCondi = new JTextField();
		txtBoardCondi.setBounds(272, 10, 177, 29);
		panel_2.add(txtBoardCondi);
		txtBoardCondi.setColumns(10);
		
		JButton btnBoardSearch = new JButton("검색");
		btnBoardSearch.setBounds(461, 11, 87, 26);
		panel_2.add(btnBoardSearch);
		
		
		
		pnNotices.setVisible(false);
		pnBoard.setVisible(false);
		/*===========================================================*/
		/*  메인메뉴 관리  */
		//공지사항
		pnNoticesButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnNotices.setVisible(true);
				pnBoard.setVisible(false);
				setBoardColor(pnNoticesButton);
				refBoardColor(pnHoiwon);
			}
		});
		
		// 게시판
		pnHoiwon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnNotices.setVisible(false);
				pnBoard.setVisible(true);
				refBoardColor(pnNoticesButton);
				setBoardColor(pnHoiwon);
				
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
		
		/*===========================================================*/
		/*  공지사항  */
		// 공지사항 글쓰기 처리
		btnWrite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(vo.getAdminYN().equals("Y")) {
					new setUpdateNotices(vo);
				}
				else {
					JOptionPane.showMessageDialog(null, "공지사항은 관리자만 작성할 수 있습니다.");
				}
			}
		});
		
		// 공지사항 글보기
		// 공지사항 글보기를 눌렀을 시 조회수 올라가기
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = notTable.getSelectedRow();
				int col = notTable.getSelectedColumn();
				
				if(row == -1 || col == -1) {
					JOptionPane.showMessageDialog(null, "게시글을 선택해주세요.");
				}
				else {
					int idx = (int)notTable.getValueAt(row, 0);
					String category = notTable.getValueAt(row, 1).toString();
					String title = notTable.getValueAt(row, 2).toString();
					String nickName = notTable.getValueAt(row, 3).toString();
					int ViewCnt = (int)notTable.getValueAt(row, 6);
					
					dao.getViewCnt(idx,category,title,nickName,ViewCnt); // 글보기 클릭시 조회수 +1
					bVO = dao.getReadBoard(idx,category,title,nickName);
					
					new BoardRead(vo, bVO);
				}
			}
		});
		
		// 나가기
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnNotices.setVisible(false);
				allNoticesList();
				refBoardColor(pnNoticesButton);
				refBoardColor(pnHoiwon);
			}
		});
		
		// 새로고침
		btnNotRef.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allNoticesList();
			}
		});
		
		// 조건항목 검색버튼
		btnNotSeatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getNoticesBoardCondi();
			}
		});
		
		txtNotCondi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) getNoticesBoardCondi();
			}
		});
		
		/*===========================================================*/
		/*  게시판  */
		// 게시판 전체
		rdAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnBoardRef.doClick();
				btnCheck = 0;
			}
		});
		
		// 게시판 게임
		rdGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bData = dao.getBoardCategoryList("게임","Y");
				boDtm.setDataVector(bData, BoardTitle);
				tableCellAlign(boTable);
				boardListSize();
				btnCheck = 1;
			}
		});
		
		// 게시판 웹툰/소설
		rdWebt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bData = dao.getBoardCategoryList("웹툰/소설","Y");
				boDtm.setDataVector(bData, BoardTitle);
				tableCellAlign(boTable);
				boardListSize();
				btnCheck = 2;
			}
		});
		
		// 게시판 인형
		rdDoll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bData = dao.getBoardCategoryList("인형","Y");
				boDtm.setDataVector(bData, BoardTitle);
				tableCellAlign(boTable);
				boardListSize();
				btnCheck = 3;
			}
		});
		
		// 게시판 운동
		rdEx.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bData = dao.getBoardCategoryList("운동","Y");
				boDtm.setDataVector(bData, BoardTitle);
				tableCellAlign(boTable);
				boardListSize();
				btnCheck = 4;
			}
		});
		
		// 게시판 패션
		rdPassion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bData = dao.getBoardCategoryList("패션","Y");
				boDtm.setDataVector(bData, BoardTitle);
				tableCellAlign(boTable);
				boardListSize();
				btnCheck = 5;
			}
		});
		
		// 글쓰기
		btnBoardWrite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new setUpdateBoard(vo);
			}
		});
		
		// 게시판 글보기
		// 게시판 글보기를 눌렀을 시 조회수 올라가기
		btnBoardRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = boTable.getSelectedRow();
				int col = boTable.getSelectedColumn();
				
				if(row == -1 || col == -1) {
					JOptionPane.showMessageDialog(null, "게시글을 선택해주세요.");
				}
				else {
					int idx = (int)boTable.getValueAt(row, 0);
					String category = boTable.getValueAt(row, 1).toString();
					String title = boTable.getValueAt(row, 2).toString();
					String nickName = boTable.getValueAt(row, 3).toString();
					int ViewCnt = (int)boTable.getValueAt(row, 6);
					
					dao.getViewCnt(idx,category,title,nickName,ViewCnt); // 글보기 클릭시 조회수 +1
					bVO = dao.getReadBoard(idx,category,title,nickName);
					
					new BoardRead(vo, bVO);
				}
			}
		});
		
		// 나가기
		btnBoardBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnBoard.setVisible(false);
				rdAll.doClick();
				refBoardColor(pnNoticesButton);
				refBoardColor(pnHoiwon);
			}
		});
		
		//새로고침
		btnBoardRef.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bData = dao.getBoardList("공지사항","Y");
				boDtm.setDataVector(bData, BoardTitle);
				tableCellAlign(boTable);
				boardListSize();
				rdAll.setSelected(true);
			}
		});
		
		// 게시판 조건항목 검색버튼
		btnBoardSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getBoardCondi();
			}
		});
		
		// 게시판 조건항목 키보드
		txtBoardCondi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) getBoardCondi();
			}
		});
	}
	
	/* ==================================================================== */
	/* 불러와서 사용할 메소드들 */
	// 리스트 가운데로 정렬
	private void tableCellAlign(JTable table) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);	
		
		TableColumnModel tcm = table.getColumnModel();	
		
		for(int i=0; i<tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);	
		}
	}
	// 공지사항 전체리스트
	private void allNoticesList() {
		nData = dao.getNotBoardList("category","공지사항","Y");
		notDtm.setDataVector(nData, noticesTitle);
		tableCellAlign(notTable);
		notListSize();
	}
	
	// 게시판 조건검색 항목 선택 후 입력필드 작성하면 수행될 내용
	private void getBoardCondi() {
		cbChoiceB = cbBoardCondi.getSelectedItem().toString();
		txtCondiB = txtBoardCondi.getText();
		
		if(cbChoiceB.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "검색할 항목을 선택해주세요.");
			return;
		}
		else if(txtCondiB.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "검색할 내용을 입력해주세요.");
			return;
		}
		
		switch (btnCheck) {
			case 1:
				if(cbChoiceB.equals("제목")) bData = dao.getBoardCondiSeatch("title", txtCondiB, "게임","Y");
				else if(cbChoiceB.equals("닉네임")) bData = dao.getBoardCondiSeatch("nickName", txtCondiB, "게임","Y");
				boDtm.setDataVector(bData, BoardTitle);
				tableCellAlign(boTable);
				boardListSize();
				break;
			case 2:
				if(cbChoiceB.equals("제목")) bData = dao.getBoardCondiSeatch("title", txtCondiB, "웹툰/소설","Y");
				else if(cbChoiceB.equals("닉네임")) bData = dao.getBoardCondiSeatch("nickName", txtCondiB, "웹툰/소설","Y");
				boDtm.setDataVector(bData, BoardTitle);
				tableCellAlign(boTable);
				boardListSize();
				break;
			case 3:
				if(cbChoiceB.equals("제목")) bData = dao.getBoardCondiSeatch("title", txtCondiB, "인형","Y");
				else if(cbChoiceB.equals("닉네임")) bData = dao.getBoardCondiSeatch("nickName", txtCondiB, "인형","Y");
				boDtm.setDataVector(bData, BoardTitle);
				tableCellAlign(boTable);
				boardListSize();
				break;
			case 4:
				if(cbChoiceB.equals("제목")) bData = dao.getBoardCondiSeatch("title", txtCondiB, "운동","Y");
				else if(cbChoiceB.equals("닉네임")) bData = dao.getBoardCondiSeatch("nickName", txtCondiB, "운동","Y");
				boDtm.setDataVector(bData, BoardTitle);
				tableCellAlign(boTable);
				boardListSize();
				break;
			case 5:
				if(cbChoiceB.equals("제목")) bData = dao.getBoardCondiSeatch("title", txtCondiB, "패션","Y");
				else if(cbChoiceB.equals("닉네임")) bData = dao.getBoardCondiSeatch("nickName", txtCondiB, "패션","Y");
				boDtm.setDataVector(bData, BoardTitle);
				tableCellAlign(boTable);
				boardListSize();
				break;
			default:
				if(cbChoiceB.equals("제목")) bData = dao.getBoardCondiallSeatch("title", txtCondiB,"공지사항", "Y");
				else if(cbChoiceB.equals("닉네임")) bData = dao.getBoardCondiallSeatch("nickName", txtCondiB, "공지사항", "Y");
				boDtm.setDataVector(bData, BoardTitle);
				tableCellAlign(boTable);
				boardListSize();
				break;
		}
	}
	
	// 공지사항 조건검색 항목 선택 후 입력필드 작성하면 수행될 내용
	private void getNoticesBoardCondi() {
		cbChoiceN = cbNotChoice.getSelectedItem().toString();
		txtCondiN = txtNotCondi.getText();
		
		if(cbChoiceN.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "검색할 항목을 선택해주세요.");
			return;
		}
		else if(txtCondiN.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "검색할 내용을 입력해주세요.");
			return;
		}
		if(cbChoiceN.equals("제목")) nData = dao.getNotBoardCondiSeatch("title", txtCondiN ,"공지사항", "Y");
		else if(cbChoiceN.equals("닉네임")) nData = dao.getNotBoardCondiSeatch("nickName", txtCondiN ,"공지사항", "Y");
		notDtm.setDataVector(nData, noticesTitle);
		tableCellAlign(notTable);
		notListSize();
	}
	
	// 공지사항 사이즈 바꾸기
	private void notListSize() {
		notTable.getColumnModel().getColumn(0).setMaxWidth(50);
		notTable.getColumnModel().getColumn(1).setMaxWidth(120);
		notTable.getColumnModel().getColumn(2).setMaxWidth(400);
		notTable.getColumnModel().getColumn(3).setMaxWidth(160);
		notTable.getColumnModel().getColumn(4).setMaxWidth(130);
		notTable.getColumnModel().getColumn(5).setMaxWidth(50);
		notTable.getColumnModel().getColumn(6).setMaxWidth(50);
	}
	
	// 게시판 사이즈 바꾸기
	private void boardListSize() {
		boTable.getColumnModel().getColumn(0).setMaxWidth(50);
		boTable.getColumnModel().getColumn(1).setMaxWidth(120);
		boTable.getColumnModel().getColumn(2).setMaxWidth(400);
		boTable.getColumnModel().getColumn(3).setMaxWidth(160);
		boTable.getColumnModel().getColumn(4).setMaxWidth(130);
		boTable.getColumnModel().getColumn(5).setMaxWidth(50);
		boTable.getColumnModel().getColumn(6).setMaxWidth(50);
	}
	
	// 메인보드 버튼 색 바꾸기
	private void setBoardColor(JPanel jPanel) {
		jPanel.setBackground(new Color(51, 102, 204));
	}
	// 메인보드 버튼 색 원래대로 바꾸기
	private void refBoardColor(JPanel jPanel) {
		jPanel.setBackground(new Color(5, 58, 163));
	}
}
