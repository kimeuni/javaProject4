package BoardSw;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import longinSw.UserSwDAO;
import longinSw.UserSwVO;
import longinSw.userlog;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class UserMain extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtId;
	private JTextField txtBeforePw;
	private JTextField txtAfterPw;
	private JTextField txtNickname;
	private JTextField txtEmail;
	private Vector myAllBoardTitle, myAllData,myDisNoTitle,myDisNoData;
	private JTable mTable, nTable;
	private DefaultTableModel mDtm, nDtm;
	
	
	UserSwDAO uDAO = new UserSwDAO();
	BoardDAO bDAO = new BoardDAO();
	UserSwVO uVO = null;
	BoardVO bVO = null;
	int btnCheck;
	
	int res = 0;

	@SuppressWarnings("unchecked")
	public UserMain(UserSwVO vo) {
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
		
		JPanel pnMain = new JPanel();
		pnMain.setBackground(new Color(51, 102, 204));
		pnMain.setBounds(0, 160, 298, 53);
		panel.add(pnMain);
		pnMain.setLayout(null);
		
		JLabel lblBoardImg = new JLabel("");
		ImageIcon icon1 = new ImageIcon(UserMain.class.getResource("/longin/image/board.png"));
		Image img1 =icon1.getImage();
		Image updateImg1 = img1.getScaledInstance(36,33, Image.SCALE_SMOOTH);
		ImageIcon updateIcon1 = new ImageIcon(updateImg1);
		lblBoardImg.setIcon(updateIcon1);
		
		
		lblBoardImg.setBounds(34, 10, 36, 33);
		pnMain.add(lblBoardImg);
		
		JLabel lblBoard = new JLabel("게시판");
		lblBoard.setForeground(Color.WHITE);
		lblBoard.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoard.setFont(new Font("굴림", Font.BOLD, 18));
		lblBoard.setBounds(70, 10, 202, 33);
		pnMain.add(lblBoard);
		
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
		
		JLabel lblMyPImg = new JLabel("");
		ImageIcon icon2 = new ImageIcon(UserMain.class.getResource("/longin/image/saram.png"));
		Image img2 =icon2.getImage();
		Image updateImg2 = img2.getScaledInstance(36,33, Image.SCALE_SMOOTH);
		ImageIcon updateIcon2 = new ImageIcon(updateImg2);
		lblMyPImg.setIcon(updateIcon2);
		lblMyPImg.setBounds(34, 10, 36, 33);
		pnHoiwon.add(lblMyPImg);
		
		JLabel lblMyP = new JLabel("마이페이지");
		lblMyP.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyP.setForeground(Color.WHITE);
		lblMyP.setFont(new Font("굴림", Font.BOLD, 18));
		lblMyP.setBounds(70, 10, 202, 33);
		pnHoiwon.add(lblMyP);
		
		JPanel pnDisplayBtn = new JPanel();
		pnDisplayBtn.setLayout(null);
		pnDisplayBtn.setBackground(new Color(5, 58, 163));
		pnDisplayBtn.setBounds(0, 265, 298, 53);
		panel.add(pnDisplayBtn);
		
		JLabel lblSecretImg = new JLabel("");
		ImageIcon icon3 = new ImageIcon(UserMain.class.getResource("/longin/image/lock.png"));
		Image img3 =icon3.getImage();
		Image updateImg3 = img3.getScaledInstance(36,33, Image.SCALE_SMOOTH);
		ImageIcon updateIcon3 = new ImageIcon(updateImg3);
		lblSecretImg.setIcon(updateIcon3);
		lblSecretImg.setBounds(34, 10, 36, 33);
		pnDisplayBtn.add(lblSecretImg);
		
		JLabel lblSecret = new JLabel("나만보기");
		lblSecret.setHorizontalAlignment(SwingConstants.CENTER);
		lblSecret.setForeground(Color.WHITE);
		lblSecret.setFont(new Font("굴림", Font.BOLD, 18));
		lblSecret.setBounds(70, 10, 202, 33);
		pnDisplayBtn.add(lblSecret);
		
		JPanel pnExit = new JPanel();
		pnExit.setLayout(null);
		pnExit.setBackground(new Color(5, 58, 163));
		pnExit.setBounds(0, 558, 298, 53);
		panel.add(pnExit);
		
		JLabel lblExitImg = new JLabel("");
		ImageIcon icon5 = new ImageIcon(UserMain.class.getResource("/longin/image/exit.png"));
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
		ImageIcon icon4 = new ImageIcon(UserMain.class.getResource("/longin/image/logout.png"));
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
		
		/*=============================================================*/
		JPanel pnMyP = new JPanel();
		pnMyP.setBounds(310, 84, 712, 517);
		pabc.add(pnMyP);
		pnMyP.setLayout(null);
		
		JLabel lblMyInfo = new JLabel("나의 정보");
		lblMyInfo.setForeground(new Color(0, 102, 255));
		lblMyInfo.setFont(new Font("굴림", Font.BOLD, 24));
		lblMyInfo.setBounds(12, 10, 126, 54);
		pnMyP.add(lblMyInfo);
		
		JPanel pnHoiwonInfo = new JPanel();
		pnHoiwonInfo.setBounds(12, 53, 688, 397);
		pnMyP.add(pnHoiwonInfo);
		pnHoiwonInfo.setLayout(null);
		
		JLabel lblImg = new JLabel("");
		if(vo.getGender().equals("남자")) {
			ImageIcon iconMale = new ImageIcon(UserMain.class.getResource("/longin/image/men.png"));
			Image imgMale =iconMale.getImage();
			Image updateImgMale = imgMale.getScaledInstance(183,169, Image.SCALE_SMOOTH);
			ImageIcon updateIconMale = new ImageIcon(updateImgMale);
			lblImg.setIcon(updateIconMale);
			lblImg.setBounds(12, 10, 183, 169);
			pnHoiwonInfo.add(lblImg);
		}
		else {
			ImageIcon iconFemale = new ImageIcon(UserMain.class.getResource("/longin/image/Wmen.png"));
			Image imgFemale =iconFemale.getImage();
			Image updateImgFemale = imgFemale.getScaledInstance(183,169, Image.SCALE_SMOOTH);
			ImageIcon updateIconFemale = new ImageIcon(updateImgFemale);
			lblImg.setIcon(updateIconFemale);
			lblImg.setBounds(12, 10, 183,169);
			pnHoiwonInfo.add(lblImg);
		}
			
			JLabel lblNewLabel = new JLabel("성명");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("굴림", Font.BOLD, 16));
			lblNewLabel.setBounds(226, 9, 124, 36);
			pnHoiwonInfo.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("아이디");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 16));
			lblNewLabel_1.setBounds(226, 151, 124, 36);
			pnHoiwonInfo.add(lblNewLabel_1);
			
			JLabel lblNewLabel_1_1 = new JLabel("현재 비밀번호");
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 16));
			lblNewLabel_1_1.setBounds(226, 194, 124, 36);
			pnHoiwonInfo.add(lblNewLabel_1_1);
			
			JLabel lblNewLabel_1_1_1 = new JLabel("수정 비밀번호");
			lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_1.setFont(new Font("굴림", Font.BOLD, 16));
			lblNewLabel_1_1_1.setBounds(226, 240, 124, 36);
			pnHoiwonInfo.add(lblNewLabel_1_1_1);
			
			txtName = new JTextField();
			txtName.setFont(new Font("굴림", Font.PLAIN, 16));
			txtName.setBounds(384, 10, 241, 36);
			txtName.setText(vo.getName());
			pnHoiwonInfo.add(txtName);
			txtName.setColumns(10);
			
			txtId = new JTextField();
			txtId.setEditable(false);
			txtId.setFont(new Font("굴림", Font.PLAIN, 16));
			txtId.setColumns(10);
			txtId.setBounds(384, 151, 241, 36);
			txtId.setText(vo.getId());
			pnHoiwonInfo.add(txtId);
			
			txtBeforePw = new JTextField();
			txtBeforePw.setEditable(false);
			txtBeforePw.setFont(new Font("굴림", Font.PLAIN, 16));
			txtBeforePw.setColumns(10);
			txtBeforePw.setBounds(384, 194, 241, 36);
			txtBeforePw.setText(vo.getPw());
			pnHoiwonInfo.add(txtBeforePw);
			
			txtAfterPw = new JTextField();
			txtAfterPw.setFont(new Font("굴림", Font.PLAIN, 16));
			txtAfterPw.setColumns(10);
			txtAfterPw.setBounds(384, 241, 241, 36);
			txtAfterPw.setText(vo.getPw());
			pnHoiwonInfo.add(txtAfterPw);
			
			JLabel lblNewLabel_4 = new JLabel("닉네임");
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 16));
			lblNewLabel_4.setBounds(226, 56, 124, 36);
			pnHoiwonInfo.add(lblNewLabel_4);
			
			txtNickname = new JTextField();
			txtNickname.setEditable(false);
			txtNickname.setFont(new Font("굴림", Font.PLAIN, 16));
			txtNickname.setColumns(10);
			txtNickname.setBounds(384, 57, 241, 36);
			txtNickname.setText(vo.getNickName());
			pnHoiwonInfo.add(txtNickname);
			
			JLabel lblNewLabel_4_1 = new JLabel("주소");
			lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_4_1.setFont(new Font("굴림", Font.BOLD, 16));
			lblNewLabel_4_1.setBounds(226, 287, 124, 36);
			pnHoiwonInfo.add(lblNewLabel_4_1);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(384, 288, 241, 99);
			pnHoiwonInfo.add(scrollPane);
			
			JTextArea txtaAddress = new JTextArea();
			txtaAddress.setText(vo.getAddress());
			scrollPane.setViewportView(txtaAddress);
			
			JLabel lblNewLabel_1_2 = new JLabel("이메일");
			lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_2.setFont(new Font("굴림", Font.BOLD, 16));
			lblNewLabel_1_2.setBounds(226, 105, 124, 36);
			pnHoiwonInfo.add(lblNewLabel_1_2);
			
			txtEmail = new JTextField();
			txtEmail.setText((String) null);
			txtEmail.setFont(new Font("굴림", Font.PLAIN, 16));
			txtEmail.setEditable(false);
			txtEmail.setColumns(10);
			txtEmail.setBounds(384, 105, 241, 36);
			txtEmail.setText(vo.getEmail());
			pnHoiwonInfo.add(txtEmail);
			
			JPanel pnHoiwonButton = new JPanel();
			pnHoiwonButton.setBounds(12, 460, 688, 47);
			pnMyP.add(pnHoiwonButton);
			pnHoiwonButton.setLayout(null);
			
			JButton btnMypDrop = new JButton("회원탈퇴");
			btnMypDrop.setBounds(74, 10, 130, 27);
			pnHoiwonButton.add(btnMypDrop);
			
			JButton btnCancel = new JButton("취소");
			btnCancel.setBounds(482, 12, 130, 27);
			pnHoiwonButton.add(btnCancel);
			
			JButton btnMypUpdate = new JButton("수정");
			btnMypUpdate.setBounds(278, 12, 130, 27);
			pnHoiwonButton.add(btnMypUpdate);
		/*=============================================================*/
		JPanel pnDisplay = new JPanel();
		pnDisplay.setBounds(310, 84, 712, 517);
		pabc.add(pnDisplay);
		pnDisplay.setLayout(null);
		
		JPanel pnLbl = new JPanel();
		pnLbl.setBounds(0, 0, 712, 53);
		pnDisplay.add(pnLbl);
		pnLbl.setLayout(null);
		
		JLabel lblMyMsg = new JLabel("내가 작성한 게시판");
		lblMyMsg.setForeground(SystemColor.textHighlight);
		lblMyMsg.setFont(new Font("굴림", Font.BOLD, 24));
		lblMyMsg.setBounds(12, 0, 324, 53);
		pnLbl.add(lblMyMsg);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 54, 690, 40);
		pnDisplay.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnMyAllBoard = new JButton("내가 작성한 모든 게시판");
		btnMyAllBoard.setBounds(98, 6, 197, 28);
		panel_1.add(btnMyAllBoard);
		
		JButton btnMyDisplayN = new JButton("나만보기 게시판");
		btnMyDisplayN.setBounds(393, 7, 197, 28);
		panel_1.add(btnMyDisplayN);
		
		/*======================================*/
		// 나의 모든 게시판
		JPanel pnMyAllBoard = new JPanel();
		pnMyAllBoard.setBounds(12, 99, 688, 347);
		pnDisplay.add(pnMyAllBoard);
		pnMyAllBoard.setLayout(null);
		
		myAllBoardTitle = new Vector<>();
		myAllBoardTitle.add("번호");
		myAllBoardTitle.add("카테고리");
		myAllBoardTitle.add("제목");
		myAllBoardTitle.add("작성자");
		myAllBoardTitle.add("날짜");
		myAllBoardTitle.add("좋아요");
		myAllBoardTitle.add("조회수");
		
		myAllData = bDAO.getMyAllBoardList("공지사항",vo.getNickName());
		
		mDtm = new DefaultTableModel(myAllData, myAllBoardTitle);
		
		mTable = new JTable(mDtm);
		
		tableCellAlign(mTable);
		
		JScrollPane spMyAllBoard = new JScrollPane(mTable);
		spMyAllBoard.setBounds(0, 0, 688, 347);
		pnMyAllBoard.add(spMyAllBoard);
		/*======================================*/
		// 나만보기 게시판
		JPanel pnMyDisNo = new JPanel();
		pnMyDisNo.setBounds(12, 99, 688, 347);
		pnDisplay.add(pnMyDisNo);
		pnMyDisNo.setLayout(null);
		
		myDisNoTitle = new Vector<>();
		myDisNoTitle.add("번호");
		myDisNoTitle.add("카테고리");
		myDisNoTitle.add("제목");
		myDisNoTitle.add("작성자");
		myDisNoTitle.add("날짜");
		myDisNoTitle.add("좋아요");
		myDisNoTitle.add("조회수");
		
		myDisNoData = bDAO.getMyDisNoList("공지사항",vo.getNickName(),"N");

		nDtm = new DefaultTableModel(myDisNoData, myDisNoTitle);
		
		nTable = new JTable(nDtm);
		
		tableCellAlign(nTable);
		
		JScrollPane spMyDispNo= new JScrollPane(nTable);
		spMyDispNo.setBounds(0, 0, 688, 347);
		pnMyDisNo.add(spMyDispNo);
		
		/*======================================*/
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBounds(0, 445, 712, 72);
		pnDisplay.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("상세보기");
		btnNewButton.setBounds(493, 26, 95, 23);
		panel_2.add(btnNewButton);
		
		JButton btnBoardC = new JButton("선택게시판 나가기");
		btnBoardC.setBounds(335, 26, 148, 23);
		panel_2.add(btnBoardC);
		
		JButton btnBack = new JButton("나가기");
		btnBack.setBounds(600, 26, 95, 23);
		panel_2.add(btnBack);
		
		JButton btnRefresh = new JButton("새로고침");
		btnRefresh.setBounds(228, 26, 95, 23);
		panel_2.add(btnRefresh);
		
		
		pnMyP.setVisible(false);
		pnDisplay.setVisible(false);
		
		/*===========================================================*/
		/*  메인메뉴 관리  */
		// 메인메뉴 마이페이지
		// 게시판 
		pnMain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new MainBoards(vo);
				setUserBoardColor(pnMain);
				refUserBoardColor(pnHoiwon);
				refUserBoardColor(pnDisplayBtn);
			}
		});
		
		// 마이페이지
		pnHoiwon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 비밀번호 확인 후 마이페이지 들어가도록 한다.
				String pw = JOptionPane.showInputDialog(vo.getName() + "님의 비밀번호를 입력해주세요.");
				uVO = new UserSwVO();
				uVO = uDAO.getMyPSearch(vo.getId(),pw);
				if(uVO.getPw() == null) {
					JOptionPane.showMessageDialog(null, "비밀번호를 다시 확인해주세요.");
				}
				else {
					pnMyP.setVisible(true);
					pnDisplay.setVisible(false);
					refUserBoardColor(pnMain);
					setUserBoardColor(pnHoiwon);
					refUserBoardColor(pnDisplayBtn);
				}
			}
		});
		
		// 나만보기
		pnDisplayBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnMyP.setVisible(false);
				pnDisplay.setVisible(true);
				pnMyAllBoard.setVisible(false);
				pnMyDisNo.setVisible(false);
				refUserBoardColor(pnMain);
				refUserBoardColor(pnHoiwon);
				setUserBoardColor(pnDisplayBtn);
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
		/*  마이페이지 관리  */

		// 마이페이지 회원탈퇴
		btnMypDrop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ans = JOptionPane.showConfirmDialog(null, "정말로 회원을 탈퇴하시겠습니까?","회원탈퇴",JOptionPane.YES_NO_OPTION);
				if(ans == 0) {
					res = uDAO.getDeleteHoiwon(vo.getId());
					if(res == 0) {
						JOptionPane.showMessageDialog(null, "문제가 발생하여 회원 삭제를 하지 못했습니다.");
					}
					else {
						JOptionPane.showMessageDialog(null, vo.getName()+"님의 계정을 삭제하였습니다.");
						dispose();
						new userlog();
					}
				}
				else {}
			}
		});
		
		// 마이페이지 수정
		btnMypUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtId.getText();
				String name = txtName.getText();
				String pw = txtAfterPw.getText();
				String address = txtaAddress.getText();
				
				if(name.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "수정할 성명을 입력해주세요.");
				}
				else if(!Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$", pw)) {
					JOptionPane.showMessageDialog(null, "비밀번호는 8~20자 사이, 소문자,대문자,숫자,특수문자를 1개 이상 입력해야 합니다.");
				}
				else {
					int ans = JOptionPane.showConfirmDialog(null, "회원정보를 수정하시겠습니까?","회원수정",JOptionPane.YES_NO_OPTION);
					if(ans == 0) {
						vo.setId(id);
						vo.setName(name);
						vo.setPw(pw);
						vo.setAddress(address);
						res = uDAO.setUpdateHoiwon(vo);
						if(res == 0) {
							JOptionPane.showMessageDialog(null, "문제가 발생하여 회원 수정을 하지 못했습니다.");
						}
						else {
							JOptionPane.showMessageDialog(null, vo.getName()+"님의 계정 정보를 수정하였습니다.");
							btnCancel.doClick();
						}
					}
					else {}
				}
			}
		});
		
		// 마이페이지 취소
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText(vo.getName());
				txtNickname.setText(vo.getNickName());
				txtEmail.setText(vo.getEmail());
				txtId.setText(vo.getId());
				txtBeforePw.setText(vo.getPw());
				txtAfterPw.setText(vo.getPw());
				txtaAddress.setText(vo.getAddress());
				pnMyP.setVisible(false);
				refUserBoardColor(pnMain);
				refUserBoardColor(pnHoiwon);
				refUserBoardColor(pnDisplayBtn);
			}
		});
		
		/*=================================================================*/
		/* 나만보기 관리 */
		
		// 내가 작성한 모든 게시판 버튼
		btnMyAllBoard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnMyAllBoard.setVisible(true);
				pnMyDisNo.setVisible(false);
				
				btnCheck = 1;
			}
		});
		
		// 나만보기 버튼
		btnMyDisplayN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnMyAllBoard.setVisible(false);
				pnMyDisNo.setVisible(true);
				
				btnCheck = 2;
			}
		});
		
		// 나가기
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnDisplay.setVisible(false);
				pnMyAllBoard.setVisible(false);
				pnMyDisNo.setVisible(false);
				refUserBoardColor(pnMain);
				refUserBoardColor(pnHoiwon);
				refUserBoardColor(pnDisplayBtn);
			}
		});
		
		// 상세보기
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnCheck == 1) {
					int row = mTable.getSelectedRow();
					int col = mTable.getSelectedColumn();
					
					if(row == -1 || col == -1) {
						JOptionPane.showMessageDialog(null, "상세보기할 게시글을 선택해주세요.");
					}
					else {
						int idx = (int)mTable.getValueAt(row, 0);
						String category = mTable.getValueAt(row, 1).toString();
						String title = mTable.getValueAt(row, 2).toString();
						String nickName = mTable.getValueAt(row, 3).toString();
						int ViewCnt = (int)mTable.getValueAt(row, 6);
						
						bVO = bDAO.getReadBoard(idx,category,title,nickName);
						
						new BoardRead(vo, bVO);
					}
				}
				if(btnCheck == 2) {
					int row = nTable.getSelectedRow();
					int col = nTable.getSelectedColumn();
					
					if(row == -1 || col == -1) {
						JOptionPane.showMessageDialog(null, "상세보기할 게시글을 선택해주세요.");
					}
					else {
						int idx = (int)nTable.getValueAt(row, 0);
						String category = nTable.getValueAt(row, 1).toString();
						String title = nTable.getValueAt(row, 2).toString();
						String nickName = nTable.getValueAt(row, 3).toString();
						int ViewCnt = (int)nTable.getValueAt(row, 6);
						
						bVO = bDAO.getReadBoard(idx,category,title,nickName);
						
						new BoardRead(vo, bVO);
					}
				}
			}
		});
		
		// 선택게시판 나가기
		btnBoardC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnMyAllBoard.setVisible(false);
				pnMyDisNo.setVisible(false);
				
				if(btnCheck == 1) {
					myAllData = bDAO.getMyAllBoardList("공지사항",vo.getNickName());
					mDtm.setDataVector(myAllData, myAllBoardTitle);
					tableCellAlign(mTable);
				}
				if(btnCheck == 2) {
					myDisNoData = bDAO.getMyDisNoList("공지사항",vo.getNickName(),"N");
					nDtm.setDataVector(myDisNoData, myDisNoTitle);
					tableCellAlign(nTable);
				}
			}
		});
		
		// 새로고침
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnCheck == 1) {
					myAllData = bDAO.getMyAllBoardList("공지사항",vo.getNickName());
					mDtm.setDataVector(myAllData, myAllBoardTitle);
					tableCellAlign(mTable);
				}
				if(btnCheck == 2) {
					myDisNoData = bDAO.getMyDisNoList("공지사항",vo.getNickName(),"N");
					nDtm.setDataVector(myDisNoData, myDisNoTitle);
					tableCellAlign(nTable);
				}
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
	
	// 메인보드 버튼 색 바꾸기
	private void setUserBoardColor(JPanel jPanel) {
		jPanel.setBackground(new Color(51, 102, 204));
	}
	// 메인보드 버튼 색 원래대로 바꾸기
	private void refUserBoardColor(JPanel jPanel) {
		jPanel.setBackground(new Color(5, 58, 163));
	}
}
