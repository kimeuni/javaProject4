package BoardSw;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import longinSw.UserSwVO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class setUpdateBoard extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitle;
	private JTextField txtFileName;
	private JComboBox cbcategory;
	private JTextArea txtaContent;
	private ImageFileUpdate imageFileUpdate;
	
	BoardDAO dao = new BoardDAO();
	BoardVO bVO = null;
	int res = 0;
	
	public setUpdateBoard(UserSwVO vo) {
		super("게시판 글쓰기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 670);
		setLocationRelativeTo(null);
		
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 484, 631);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 120, 31);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("글쓰기");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		lblNewLabel.setBounds(0, 0, 120, 31);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 29, 484, 49);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		cbcategory = new JComboBox();
		cbcategory.setModel(new DefaultComboBoxModel(new String[] {"", "게임","웹툰/소설","인형","운동","패션"}));
		cbcategory.setBounds(12, 10, 75, 29);
		panel_2.add(cbcategory);
		
		txtTitle = new JTextField();
		txtTitle.setBounds(99, 10, 373, 29);
		panel_2.add(txtTitle);
		txtTitle.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 88, 462, 464);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 462, 464);
		panel_3.add(scrollPane);
		
		txtaContent = new JTextArea();
		scrollPane.setViewportView(txtaContent);
		
		JPanel pnButton = new JPanel();
		pnButton.setBounds(0, 590, 484, 41);
		panel.add(pnButton);
		pnButton.setLayout(null);
		
		JButton btnFinish = new JButton("작성완료");
		btnFinish.setBounds(375, 10, 97, 23);
		pnButton.add(btnFinish);
		
		JButton btnNewButton_1 = new JButton("취소");
		btnNewButton_1.setBounds(270, 10, 97, 23);
		pnButton.add(btnNewButton_1);
		
		JPanel pnFile = new JPanel();
		pnFile.setBounds(12, 556, 460, 31);
		panel.add(pnFile);
		pnFile.setLayout(null);
		
		txtFileName = new JTextField();
		txtFileName.setBounds(22, 0, 286, 31);
		pnFile.add(txtFileName);
		txtFileName.setColumns(10);
		
		JButton btnFileUpdate = new JButton("파일 업로드");
		btnFileUpdate.setBounds(330, 4, 118, 23);
		pnFile.add(btnFileUpdate);
		
		/* ================================================= */
		
		// 파일 업로드 버튼
		btnFileUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(imageFileUpdate == null) {
					imageFileUpdate = new ImageFileUpdate();
				}
				txtFileName.setText(imageFileUpdate.getImgUP());
				System.out.println(txtFileName.getText());
			}
		});
		
		// 작성완료 버튼
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String boardChoice = cbcategory.getSelectedItem().toString();
				String boardTitle = txtTitle.getText();
				String boardContent = txtaContent.getText();
				String boardImage = txtFileName.getText();
				
				if(boardChoice.trim().equals("")) JOptionPane.showMessageDialog(null, "카테고리를 선택해주세요.");
				else if(boardTitle.trim().equals("")) JOptionPane.showMessageDialog(null, "제목을 작성해주세요.");
				else if(boardContent.trim().equals("")) JOptionPane.showMessageDialog(null, "본문을 작성해주세요.");
				else {
					bVO = new BoardVO();
					bVO.setCategory(boardChoice);
					bVO.setTitle(boardTitle);
					bVO.setContent(boardContent);
					bVO.setNickName(vo.getNickName());
					bVO.setImage(boardImage);
					
					int ans = JOptionPane.showConfirmDialog(null, "작성한 글을 올리시겠습니까?", "작성완료 확인창",JOptionPane.YES_NO_OPTION);
					if(ans == 0) {
						res = dao.setNoticesUpdate(bVO);
						if(res == 0) JOptionPane.showMessageDialog(null, "알 수 없는 오류가 발생하여 글을 올리는 것에 실패했습니다.");
						else {
							JOptionPane.showMessageDialog(null, "작성한 글을 게시하였습니다.");
							dispose();
						}
					}
				}
			}
		});
		
		// 취소 버튼
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
