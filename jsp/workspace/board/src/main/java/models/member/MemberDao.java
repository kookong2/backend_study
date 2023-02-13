package models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.mindrot.bcrypt.BCrypt;

@Component
public class MemberDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	// update, query
	
	
	/**
	 * 회원 가입 처리 
	 * 
	 * @param member
	 * @return
	 */
	public boolean register(Member member) {
		
		String userPw = member.getUserPw();
		userPw = BCrypt.hashpw(userPw, BCrypt.gensalt(12));
		
		String sql = "INSERT INTO member (userId, userPw, userNm, email) " +
							" VALUES (?, ?, ?, ?)";
		
		int cnt = jdbcTemplate.update(sql, member.getUserId(),
							userPw, member.getUserNm(), member.getEmail());
		
		return cnt > 0;
	}
	
	/**
	 * 아이디로 회원조회 
	 * 
	 * @param userId
	 * @return
	 */
	public Member get(String userId) {
		String sql = "SELECT * FROM member WHERE userId = ?";
		Member member = null;
		try {
			 member = jdbcTemplate.queryForObject(sql, new RowMapper<Member>() {

				@Override
				public Member mapRow(ResultSet rs, int rowNum) throws SQLException {

					Timestamp _modDt = rs.getTimestamp("modDt");
					LocalDateTime modDt = _modDt == null ? null : _modDt.toLocalDateTime();
					
					Member member = new Member();
					member.setUserNo(rs.getInt("userNo"));
					member.setUserId(rs.getString("userId"));
					member.setUserPw(rs.getString("userPw"));
					member.setUserNm(rs.getString("userNm"));
					member.setEmail(rs.getString("email"));
					member.setUserType(MemberType.valueOf(rs.getString("userType")));
					member.setRegDt(rs.getTimestamp("regDt").toLocalDateTime());
					member.setModDt(modDt);
					
					return member;
				}
			}, userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return member;
	}
}
