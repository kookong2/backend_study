package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.PreparableStatement;

import commons.Status;

public class KanbanDao {
	
	private Connection conn;
	
	private Connection getConnection() {
		// 이미 Connection 객체가 있다면 재활용
		if(conn != null) {
			return conn;
		}
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/kanban?user=root&password=aA!123456";
			conn = DriverManager.getConnection(url);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	/**
	 * 추가
	 * 
	 * @param kanban
	 * @return
	 */
	public boolean add(Kanban kanban) {
		
		
		String sql = "INSERT INTO works (status, subject) VALUE(?,?)";
		try(PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
	
			pstmt.setString(1, kanban.getStatus().toString());
			pstmt.setString(2, kanban.getSubject());
			int cnt = pstmt.executeUpdate();
			
			return cnt > 0;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * 수정
	 * 
	 * @param kanban
	 * @return
	 */
	public boolean edit(Kanban kanban) {
		
		String sql = "UPDATE works SET status = ?, subject = ?, modDt = ? WHERE id = ?";
		
		try(PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
			
			pstmt.setString(1, kanban.getStatus().toString());
			pstmt.setString(2, kanban.getSubject());
			pstmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));	// java.sql.Timestamp
			pstmt.setInt(4, kanban.getId());
			
			int cnt = pstmt.executeUpdate();
			
			return cnt > 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * 삭제
	 * 
	 * @param id
	 * @return
	 */
	public boolean delete(int id) {
		
		String sql = "DELETE FROM works WHERE id = ?";
		try (PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
			
			pstmt.setInt(1, id);
			
			int cnt = pstmt.executeUpdate();
			
			return cnt > 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 목록
	 * @return
	 */
	public List<Kanban> gets() {
		
		List<Kanban> kanbans = new ArrayList<>();
		
		String sql = "SELECT * FROM works ORDER BY regDt";
		try (PreparedStatement pstmt = getConnection().prepareStatement(sql)){
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Kanban kanban = getKanban(rs);
				kanbans.add(kanban);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return kanbans;
	}
	
	/**
	 * 개별 조회
	 * 
	 * @param id
	 * @return
	 */
	public Kanban get(int id) {
		
		Kanban kanban = null;
		String sql = "SELECT * FROM works WHERE id = ?";
		try (PreparedStatement pstmt = getConnection().prepareStatement(sql)){
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				kanban = getKanban(rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kanban;
	}
	
	private Kanban getKanban(ResultSet rs) throws SQLException {
		Timestamp _modDt = rs.getTimestamp("modDt");
		LocalDateTime modDt = _modDt == null ? null : _modDt.toLocalDateTime();
		Kanban kanban = Kanban.builder()
								.id(rs.getInt("id"))
								.status(Status.valueOf(rs.getString("status")))
								.subject(rs.getString("subject"))
								.regDt(rs.getTimestamp("regDt").toLocalDateTime())
								.modDt(modDt)
								.build();
		
		return kanban;
	}
}



