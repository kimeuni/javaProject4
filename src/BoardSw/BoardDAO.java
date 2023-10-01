package BoardSw;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import longinSw.ConnDAO;
import longinSw.UserSwVO;

public class BoardDAO extends ConnDAO {
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "";
	UserSwVO uVO = null;
	BoardVO bVO = null;
	
	 //conn 닫기
	public void connClose() {
		try {
			conn.close();
		} catch (SQLException e) {}
	}
	
	//pstmt 닫기
	public void pstmtClose() {
		try {
			if(pstmt != null) pstmt.close();
		} catch (SQLException e) {}
	}
	
	// rs 닫기
	public void rsClose() {
		try {
			if(rs != null) rs.close();
		} catch (SQLException e) {}
		pstmtClose();
	}

	public int setNoticesUpdate(BoardVO bVO) {
		int res = 0;
		try {
			sql = "insert into boardSw (category,title,content,nickName,image) values (?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bVO.getCategory());
			pstmt.setString(2, bVO.getTitle());
			pstmt.setString(3, bVO.getContent());
			pstmt.setString(4, bVO.getNickName());
			pstmt.setString(5, bVO.getImage());
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 " + e.getMessage());
		} finally {
			pstmtClose();
		}
		
		return res;
	}

	// 선택한 카테고리명 변수(conditions) 작성한 카테고리 변수(condiStr) 리스트에 띄울 것인가 (display)
	// 게시판 리스트 출력
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getBoardList(String conditions, String condiStr, String display) {
		Vector uData = new Vector();
		try {
			sql = "select * from boardSw where " + conditions + " = ? and displayYN = ? order by idx desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, condiStr);
			pstmt.setString(2, display);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("category"));
				vo.add(rs.getString("title"));
				vo.add(rs.getString("nickName"));
				vo.add(rs.getString("writedate").substring(0,10));
				vo.add(rs.getInt("likes"));
				vo.add(rs.getInt("viewCnt"));
				uData.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 " + e.getMessage());
		} finally {
			rsClose();
		}
		
		return uData;
	}

	// 글보기를 눌렀을 때 보든 값 읽어오기
	public BoardVO getReadBoard(int idx, String category, String title, String nickName) {
		BoardVO vo = new BoardVO();
		try {
			sql = "select * from boardSw where idx = ? and category = ? and title = ? and nickName = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.setString(2, category);
			pstmt.setString(3, title);
			pstmt.setString(4, nickName);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setCategory(rs.getString("category"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setDisplayYN(rs.getString("displayYN"));
				vo.setReportYN(rs.getString("reportYN"));
				vo.setLikes(rs.getInt("likes"));
				vo.setWritedate(rs.getString("writedate"));
				vo.setNickName(rs.getString("nickName"));
				vo.setViewCnt(rs.getInt("viewCnt"));
				vo.setImage(rs.getString("image"));
			}
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}

	// 추천버튼 눌렀을 시
	public int getBoardLikecnt(BoardVO bVO) {
		int res = 0;
		try {
			sql = "update boardSw set likes = ? where idx = ? and nickName = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bVO.getLikes()+1);
			pstmt.setInt(2, bVO.getIdx());
			pstmt.setString(3, bVO.getNickName());
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 " + e.getMessage());
		} finally {
			pstmtClose();
		}
		
		return res;
	}

	// 글보기 눌렀을 시 조회수 올리기
	public void getViewCnt(int idx, String category, String title, String nickName, int viewCnt) {
		try {
			sql = "update boardSw set viewCnt = ? where idx = ? and category = ? and title = ? and nickName = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, viewCnt+1);
			pstmt.setInt(2, idx);
			pstmt.setString(3, category);
			pstmt.setString(4, title);
			pstmt.setString(5, nickName);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 " + e.getMessage());
		} finally {
			pstmtClose();
		}
		
	}

	// 작성한 글 삭제
	public int setBoardDelet(BoardVO bVO) {
		int res = 0;
		try {
			sql = "delete from boardSw where idx = ? and nickName = ? and title = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bVO.getIdx());
			pstmt.setString(2, bVO.getNickName());
			pstmt.setString(3, bVO.getTitle());
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 " + e.getMessage());
		} finally {
			pstmtClose();
		}
		
		return res;
	}

	// 작성한 글 수정
	public int setBoardModi(int idx, String nickName, String title, String content, String image) {
		int res = 0;
		try {
			sql = "update boardSw set title = ?, content = ?, image = ? where idx = ? and nickName = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, image);
			pstmt.setInt(4, idx);
			pstmt.setString(5, nickName);
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

	// 신고 게시판 전체 출력
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getReportTableList(String category, String displayYN, String reportYN) {
		Vector rData = new Vector();
		try {
			sql = "select * from boardSw where category != ? and displayYN = ? and reportYN =? order by idx desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
			pstmt.setString(2, displayYN);
			pstmt.setString(3, reportYN);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("category"));
				vo.add(rs.getString("title"));
				vo.add(rs.getString("nickName"));
				vo.add(rs.getString("writedate").substring(0,10));
				vo.add(rs.getInt("likes"));
				vo.add(rs.getInt("viewCnt"));
				rData.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 " + e.getMessage());
		} finally {
			rsClose();
		}
		
		return rData;
	}

	// 나만보기
	public int setDisplayYN(String display, int idx, String nickName) {
		int res = 0;
		try {
			sql = "update boardSw set displayYN = ? where idx = ? and nickName = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, display);
			pstmt.setInt(2, idx);
			pstmt.setString(3, nickName);
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

	// 게시글 신고
	public int setReportYN(String report, int idx, String nickName) {
		int res = 0;
		try {
			sql = "update boardSw set reportYN = ? where idx = ? and nickName = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, report);
			pstmt.setInt(2, idx);
			pstmt.setString(3, nickName);
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
}
