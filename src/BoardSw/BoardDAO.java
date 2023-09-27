package BoardSw;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
