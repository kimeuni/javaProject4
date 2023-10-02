package BoardSw;

import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import longinSw.UserSwVO;

public class BoardRead extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitle;
	
	BoardDAO dao = new BoardDAO();
	int res = 0;
	
	public BoardRead(UserSwVO vo, BoardVO bVO) {
		super("게시글 보기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(544, 820);
		setLocationRelativeTo(null);
		
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(0, 0, 530, 783);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 149, 506, 573);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 482, 247);
		panel_1.add(scrollPane);
		
		JTextArea txtaContent = new JTextArea();
		txtaContent.setEditable(false);
		txtaContent.setText(bVO.getContent());
		scrollPane.setViewportView(txtaContent);
		
		JLabel lblImg = new JLabel("");
		ImageIcon icon = new ImageIcon(bVO.getImage());
		Image img = icon.getImage();
		Image updateImg = img.getScaledInstance(482,255, Image.SCALE_SMOOTH);
		ImageIcon updateIcon = new ImageIcon(updateImg);
		lblImg.setIcon(updateIcon);
		lblImg.setBounds(12, 267, 482, 255);
		panel_1.add(lblImg);
		
		JButton btnLikes = new JButton("추천");
		btnLikes.setBounds(12, 532, 79, 31);
		panel_1.add(btnLikes);
		
		JLabel lblLikes = new JLabel("");
		lblLikes.setEnabled(false);
		lblLikes.setHorizontalAlignment(SwingConstants.CENTER);
		lblLikes.setBounds(103, 532, 70, 31);
		lblLikes.setText(bVO.getLikes()+"");
		panel_1.add(lblLikes);
		
		JLabel lblViewCnt = new JLabel("조회수");
		lblViewCnt.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewCnt.setBounds(185, 532, 70, 31);
		panel_1.add(lblViewCnt);
		
		JLabel lblViewCntV = new JLabel("");
		lblViewCntV.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewCntV.setBounds(264, 532, 70, 31);
		lblViewCntV.setText(bVO.getViewCnt()+"");
		panel_1.add(lblViewCntV);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 732, 506, 41);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnBack = new JButton("나가기");
		btnBack.setBounds(399, 10, 95, 23);
		panel_2.add(btnBack);
		
		JButton btnUpdate = new JButton("수정");
		if(vo.getNickName().equals(bVO.getNickName())) {
			btnUpdate.setBounds(292, 10, 95, 23);
			panel_2.add(btnUpdate);
		}
			
		JButton btnDelete = new JButton("삭제");
		if(vo.getNickName().equals(bVO.getNickName())) {
		btnDelete.setBounds(185, 10, 95, 23);
		panel_2.add(btnDelete);
		}
		
		JButton btnDisplay = new JButton("나만보기");
		if(vo.getNickName().equals(bVO.getNickName())) {
		btnDisplay.setBounds(78, 10, 95, 23);
		panel_2.add(btnDisplay);
		}
		
		JButton btnReport = new JButton("신고");
		if(!vo.getNickName().equals(bVO.getNickName()) && !bVO.getCategory().equals("공지사항")) {
			btnReport.setBounds(292, 10, 95, 23);
			panel_2.add(btnReport);
		}
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(12, 10, 506, 129);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblCategory = new JLabel("");
		lblCategory.setFont(new Font("굴림", Font.PLAIN, 16));
		lblCategory.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategory.setBounds(12, 10, 482, 29);
		lblCategory.setText(bVO.getCategory());
		panel_3.add(lblCategory);
		
		txtTitle = new JTextField();
		txtTitle.setBounds(12, 49, 482, 36);
		txtTitle.setEditable(false);
		txtTitle.setText(bVO.getTitle());
		panel_3.add(txtTitle);
		txtTitle.setColumns(10);
		
		JLabel lblNickname = new JLabel("닉네임");
		lblNickname.setHorizontalAlignment(SwingConstants.CENTER);
		lblNickname.setBounds(12, 95, 52, 24);
		panel_3.add(lblNickname);
		
		JLabel lblWritedateMsg = new JLabel("작성일");
		lblWritedateMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblWritedateMsg.setBounds(259, 95, 52, 24);
		panel_3.add(lblWritedateMsg);
		
		JLabel lblWritedate = new JLabel("");
		lblWritedate.setHorizontalAlignment(SwingConstants.CENTER);
		lblWritedate.setBounds(322, 95, 172, 24);
		lblWritedate.setText(bVO.getWritedate().substring(0,19));
		panel_3.add(lblWritedate);
		
		JLabel lblNicknameV = new JLabel("");
		lblNicknameV.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicknameV.setBounds(76, 95, 135, 24);
		lblNicknameV.setText(bVO.getNickName());
		panel_3.add(lblNicknameV);
		
		
		System.out.println("vo" + vo);
		System.out.println("bVO" + bVO);
		
		/* =========================================================== */
		
		// 추천버튼
		btnLikes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				res = dao.getBoardLikecnt(bVO);
				if(res == 0) {
					JOptionPane.showMessageDialog(null, "알 수 없는 문제가 발생하여 추천하지 못했습니다.");
				}
				else {
					lblLikes.setText(bVO.getLikes()+"");
					JOptionPane.showMessageDialog(null, "추천하였습니다.");
				}
			}
		});
		
		//삭제
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ans = JOptionPane.showConfirmDialog(null, "정말로 삭제하시겠습니까?", "공지사항 삭제",JOptionPane.YES_NO_OPTION);
				if(ans == 0) {
					res = dao.setBoardDelet(bVO);
					if(res == 0) JOptionPane.showMessageDialog(null, "알 수 없는 문제로 삭제하지 못하였습니다.");
					else {
						JOptionPane.showMessageDialog(null, "삭제되었습니다.");
						dispose();
						new MainBoards(vo);
					}
				}
			}
		});
		
		// 신고
		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(bVO.getReportYN().equals("Y")) JOptionPane.showMessageDialog(null, "이미 신고된 게시글이며 현재 관리자가 확인중입니다,");
				else if(bVO.getReportYN().equals("N")) {
					int ans = JOptionPane.showConfirmDialog(null, "정말로 신고하시겠습니까?", "게시글 신고",JOptionPane.YES_NO_OPTION);
					if(ans == 0) {
						res = dao.setReportYN("Y",bVO.getIdx(),bVO.getNickName());
						if(res == 0) JOptionPane.showMessageDialog(null, "알 수 없는 문제로 신고하지 못하였습니다.");
						else {
							JOptionPane.showMessageDialog(null, "게시글을 신고하였습니다.");
						}
					}
				}
			}
		});
		
		// 나만보기
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(bVO.getDisplayYN().equals("Y")) {
					int ans = JOptionPane.showConfirmDialog(null, "현재 게시글을 나만보기로 변경하시겠습니까?","나만보기",JOptionPane.YES_NO_OPTION);
					if(ans == 0) {
						res = dao.setDisplayYN("N",bVO.getIdx(),bVO.getNickName());
						if(res == 0) JOptionPane.showMessageDialog(null, "알 수 없는 문제로 변경하지 못하였습니다.");
						else JOptionPane.showMessageDialog(null, "나만보기로 변경하였습니다.");
					}
				}
				else if(bVO.getDisplayYN().equals("N")) {
					int ans = JOptionPane.showConfirmDialog(null, "현재 게시글을 나만보기 취소로 변경하시겠습니까?","나만보기 취소",JOptionPane.YES_NO_OPTION);
					if(ans == 0) {
						res = dao.setDisplayYN("Y",bVO.getIdx(),bVO.getNickName());
						if(res == 0) JOptionPane.showMessageDialog(null, "알 수 없는 문제로 변경하지 못하였습니다.");
						else JOptionPane.showMessageDialog(null, "나만보기가 취소되었습니다.");
					}
				}
			}
		});
		
		// 수정
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new BoardModi(vo, bVO);
			}
		});
		//나가기
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
	}
}
