package BoardSw;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import longinSw.UserSwVO;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class setUpdatenotices extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitle;
	private JTextField txtFileName;
	public setUpdatenotices(UserSwVO vo) {
		super("공지사항 글쓰기");
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
		
		JComboBox cbcategory = new JComboBox();
		cbcategory.setModel(new DefaultComboBoxModel(new String[] {"", "공지사항"}));
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
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JPanel pnButton = new JPanel();
		pnButton.setBounds(0, 590, 484, 41);
		panel.add(pnButton);
		pnButton.setLayout(null);
		
		JButton btnNewButton = new JButton("작성완료");
		btnNewButton.setBounds(375, 10, 97, 23);
		pnButton.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("취소");
		btnNewButton_1.setBounds(270, 10, 97, 23);
		pnButton.add(btnNewButton_1);
		
		JPanel pnFile = new JPanel();
		pnFile.setBounds(12, 556, 460, 31);
		panel.add(pnFile);
		pnFile.setLayout(null);
		
		txtFileName = new JTextField();
		txtFileName.setEditable(false);
		txtFileName.setBounds(22, 0, 286, 31);
		pnFile.add(txtFileName);
		txtFileName.setColumns(10);
		
		JButton btnFileUpdate = new JButton("파일 업로드");
		btnFileUpdate.setBounds(330, 4, 118, 23);
		pnFile.add(btnFileUpdate);
		
		/* ================================================= */
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
