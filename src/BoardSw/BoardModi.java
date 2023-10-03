package BoardSw;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class BoardModi extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitle;
	private JTextField txtFileName;
	private JTextArea txtaContent;
	private ImageFileUpdate imageFileUpdate;

	BoardDAO dao = new BoardDAO();
	BoardVO VO = null;
	int res = 0;
	
	public BoardModi(UserSwVO vo, BoardVO bVO) {
		super("게시글 수정");
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
		
		JLabel lblNewLabel = new JLabel("게시글 수정");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		lblNewLabel.setBounds(0, 0, 120, 31);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 29, 484, 49);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		txtTitle = new JTextField();
		txtTitle.setBounds(99, 10, 373, 29);
		panel_2.add(txtTitle);
		txtTitle.setText(bVO.getTitle());
		txtTitle.setColumns(10);
		
		JLabel lblCategory = new JLabel("");
		lblCategory.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategory.setBounds(12, 10, 82, 29);
		lblCategory.setText(bVO.getCategory());
		panel_2.add(lblCategory);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 88, 462, 464);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 462, 464);
		panel_3.add(scrollPane);
		
		txtaContent = new JTextArea();
		txtaContent.setText(bVO.getContent());
		scrollPane.setViewportView(txtaContent);
		
		JPanel pnButton = new JPanel();
		pnButton.setBounds(0, 590, 484, 41);
		panel.add(pnButton);
		pnButton.setLayout(null);
		
		JButton btnFinish = new JButton("수정완료");
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
		txtFileName.setText(bVO.getImage());
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
		
		// 수정완료 버튼
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String category = lblCategory.getText();
				String title = txtTitle.getText();
				String content = txtaContent.getText();
				String image = txtFileName.getText();
				
				if(title.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "수정하실 제목을 적어주세요.");
					txtTitle.setText(bVO.getTitle());
					txtTitle.requestFocus();
				}
				else if(content.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "수정하실 본문을 적어주세요.");
					txtaContent.setText(bVO.getContent());
					txtaContent.requestFocus();
				}
				else {
					int ans = JOptionPane.showConfirmDialog(null, "수정하시겠습니까?", "게시글 수정 확인창",JOptionPane.YES_NO_OPTION);
					if(ans == 0) {
						res = dao.setBoardModi(bVO.getIdx(),bVO.getNickName(),title,content,image);
						if(res == 0) JOptionPane.showMessageDialog(null, "알 수 없는 오류가 발생하여 글을 수정하는 것에 실패했습니다.");
						else {
							JOptionPane.showMessageDialog(null, "게시글을 수정하였습니다.");
							BoardVO bbVO = new BoardVO();
							bbVO = dao.getReadBoard(bVO.getIdx(), category, title, bVO.getNickName());
							dispose();
							new BoardRead(vo, bbVO);
						}
					}
				}
			}
		});
		
		// 취소 버튼
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new BoardRead(vo, bVO);
			}
		});
	}
}