package BoardSw;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ImageFileUpdate extends JFrame {

	@SuppressWarnings("rawtypes")
	private Vector title, vData;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel defaultTableModel = new DefaultTableModel();
	private JScrollPane scrollPane;
	private JFileChooser chooser;
	private JLabel lblImg, lblImgInfo;
	
	private Object value;
	private Calendar cl = Calendar.getInstance();
	BoardVO bVO = new BoardVO();
	
	@SuppressWarnings("unchecked")
	public ImageFileUpdate() {
		super("사진파일 가져오기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		setLocationRelativeTo(null);
		
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 586, 363);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 10, 562, 43);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnImgUp = new JButton("사진 가져오기");
		btnImgUp.setBounds(12, 10, 122, 23);
		panel_1.add(btnImgUp);
		
		JButton btnImgDelete = new JButton("삭제");
		btnImgDelete.setBounds(146, 10, 68, 23);
		panel_1.add(btnImgDelete);
		
		JButton btnBack = new JButton("창닫기");
		btnBack.setBounds(468, 10, 82, 23);
		panel_1.add(btnBack);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(12, 62, 562, 254);
		panel.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 10, 177, 234);
		panel_1_1.add(panel_2);
		panel_2.setLayout(null);
		
		
		lblImg = new JLabel("가져온 사진 확인");
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblImg.setBounds(201, 10, 349, 234);
		panel_1_1.add(lblImg);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(SystemColor.inactiveCaption);
		panel_1_2.setBounds(0, 313, 586, 50);
		panel.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		lblImgInfo = new JLabel("선택한 사진 정보");
		lblImgInfo.setEnabled(false);
		lblImgInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblImgInfo.setBounds(12, 10, 562, 30);
		panel_1_2.add(lblImgInfo);
		
		/* JTable 설계 */
		title = new Vector<>();
		title.add("경로/파일명");
		
		// 폴더안의 파일 정보 가져오기
		getFolderInfor();
		
		table = new JTable(defaultTableModel);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 177, 234);
		panel_2.add(scrollPane);
		
		
		/* =============================================================== */
		
		// Jtable 클릭시
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();
				value = table.getValueAt(row, col);
				lblImg.setIcon(new ImageIcon(value.toString()));
				
				ImageIcon icon = new ImageIcon(value.toString());
				
				Image img = icon.getImage();
				
				Image updateImg = img.getScaledInstance(349, 234, Image.SCALE_SMOOTH);
				
				ImageIcon updateIcon = new ImageIcon(updateImg);
				
				lblImg.setIcon(updateIcon);
				
				lblImgInfo.setText(value.toString());
				bVO.setImage(lblImgInfo.getText());
				
			}
		});
		
		// 사진 가져오기
		btnImgUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooser= new JFileChooser(); // 파일 다이얼로그 생성
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF & PNG Images", "jpg", "gif" , "png"); 
				chooser.setFileFilter(filter); // 파일 다이얼로그에 파일 필터 설정
				
				// 파일 다이얼로그 출력
				int ret = chooser.showOpenDialog(null);
				if(ret != JFileChooser.APPROVE_OPTION) { // 사용자가  창을 강제로 닫았거나 취소 버튼을 누른 경우
			    JOptionPane.showMessageDialog(null,"파일을 선택하지 않았습니다", "경고", JOptionPane.WARNING_MESSAGE);
				}
				else {
				  // 사용자가 파일을 선택하고 "열기" 버튼을 누른 경우
				  String filePath = chooser.getSelectedFile().getPath(); // 파일 경로명을 알아온다.
				  lblImg.setIcon(new ImageIcon(filePath)); // 파일을 로딩하여 이미지 레이블에 출력한다.
				  
				  // 파일 업로드하기
				  try {
				  	File imageFile = new File(filePath);	// 파일시스템에서 가져온 정보로 파일객체 생성하기
						String fileName = filePath.substring(filePath.lastIndexOf("\\")+1); // 파일명+확장자 구하기
						String extension = filePath.substring(filePath.lastIndexOf(".")+1); // 확장자 구하기
						
						BufferedImage image = ImageIO.read(imageFile);
						File file = new File("myImage/" + (int)(Math.random()*1000)+1 + fileName);
						if(!file.exists()) { // 해당 경로의 폴더가 존재하지 않을 경우
							file.mkdirs(); // 해당 경로의 폴더 생성
						}
						
						ImageIO.write(image, extension, file); // image를 file로 업로드
						System.out.println("이미지 업로드 완료!");
						JOptionPane.showMessageDialog(null, "이미지 업로드 완료!!");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				  // 폴더안의 그림정보 가져오기
				  getFolderInfor();
				  
				}
			}
		});
		
		// 사진 삭제
		btnImgDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(value != null) {
					int ans = JOptionPane.showConfirmDialog(null, "다음파일을 삭제하시겠습니까?\n"+value,"삭제화면", JOptionPane.YES_NO_OPTION);
					if(ans == 0) {
						File file = new File(value.toString());
						file.delete();
						JOptionPane.showMessageDialog(null, "파일을 삭제처리했습니다.");
						lblImg.setIcon(null);
						getFolderInfor();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "파일을 선택해 주세요.");
				}
			}
		});
		
		// 창닫기
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

	
	/*===========================================================================*/
	public String getImgUP() {
		int row = table.getSelectedRow();
		int col = table.getSelectedColumn();
		if(row != -1 && col != -1) {
			return table.getValueAt(row, col).toString();
		}
		return null;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void getFolderInfor() {
		File folder = new File("myImage");
		  File files[] = folder.listFiles();
			
		  vData = new Vector<>();
		  
		  if(files != null) {
				for(int i=0; i<files.length; i++) {
					System.out.println("files : " + files[i]);
					Vector vo = new Vector<>();
					vo.add(files[i]);
					vData.add(vo);			
				}
				defaultTableModel.setDataVector(vData, title);
		  }
	}
}
