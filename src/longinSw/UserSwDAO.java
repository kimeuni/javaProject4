package longinSw;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSwDAO extends ConnDAO {
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "";
	UserSwVO vo = null;
	
	// conn 닫기
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

	// 닉네임 중복 확인
	public UserSwVO getNameSearch(String nickName) {
		vo = new UserSwVO();
		try {
			sql = "select * from userSw where nickName =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nickName);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setEmail(rs.getString("email"));
				vo.setName(rs.getString("name"));
				vo.setNickName(rs.getString("nickName"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setAddress(rs.getString("address"));
				vo.setAddress(rs.getString("adminYN"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}

	// 아이디 중복 확인
	public UserSwVO getIdSearch(String id) {
		vo = new UserSwVO();
		try {
			sql = "select * from userSw where id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setEmail(rs.getString("email"));
				vo.setName(rs.getString("name"));
				vo.setNickName(rs.getString("nickName"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setAddress(rs.getString("address"));
				vo.setAdminYN(rs.getString("adminYN"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}

	// 이메일 중복확인
	public UserSwVO getEmailSearch(String email) {
		vo = new UserSwVO();
		try {
			sql = "select * from userSw where email =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setEmail(rs.getString("email"));
				vo.setName(rs.getString("name"));
				vo.setNickName(rs.getString("nickName"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setAddress(rs.getString("address"));
				vo.setAddress(rs.getString("adminYN"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}

	// 회원가입한 정보 저장
	public int setUserSwInput(UserSwVO vo) {
		int res = 0;
		try {
			sql = "insert into userSw values (default,?,?,?,?,?,?,?,?,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getName());
			pstmt.setString(5, vo.getNickName());
			pstmt.setInt(6, vo.getAge());
			pstmt.setString(7, vo.getGender());
			pstmt.setString(8, vo.getAddress());
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 " + e.getMessage());
		} finally {
			pstmtClose();
		}
		
		return res;
	}

	// 아이디 찾기(성명, 이메일을 통하여)
	public UserSwVO getFindid(String nameId, String emailId) {
		vo = new UserSwVO();
		try {
			sql = "select * from userSw where name = ? and email = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nameId);
			pstmt.setString(2, emailId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setEmail(rs.getString("email"));
				vo.setName(rs.getString("name"));
				vo.setNickName(rs.getString("nickName"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setAddress(rs.getString("address"));
				vo.setAdminYN(rs.getString("adminYN"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}

	// 패스워드 찾기 (아이디,이메일을 통하여)
	public UserSwVO getFindPw(String idPw, String emailPw) {
		vo = new UserSwVO();
		try {
			sql = "select * from userSw where id = ? and email = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, idPw);
			pstmt.setString(2, emailPw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setEmail(rs.getString("email"));
				vo.setName(rs.getString("name"));
				vo.setNickName(rs.getString("nickName"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setAddress(rs.getString("address"));
				vo.setAdminYN(rs.getString("adminYN"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}

	// 아이디, 비번 확인
	public UserSwVO getIdPwSearch(String id, String pw) {
		vo = new UserSwVO();
		try {
			sql = "select * from userSw where id =? and pw = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setEmail(rs.getString("email"));
				vo.setName(rs.getString("name"));
				vo.setNickName(rs.getString("nickName"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setAddress(rs.getString("address"));
				vo.setAdminYN(rs.getString("adminYN"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	} 
}
