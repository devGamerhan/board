package com.example.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.user.UserVO;

@Repository("userDAO")
public class UserDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	//private Connection conn = null;
	//private PreparedStatement ps = null;
	//private ResultSet rs = null;
	UserVO user = null;
	
	//SQL 명령어
	private final String USER_GET="select * from users where id=? and password=?";
	private final String USER_INSERT="insert into users values(?,?,?,?)";
	
	//유저 정보
	public UserVO getUser(UserVO vo) {
		System.out.println("userDAO 의 getUser 실행");
		System.out.println("입력 id : "+vo.getId());
		System.out.println("입력 pw : "+vo.getPassword());
		
//		try {
//			conn = JDBCUtil.getConn();
//			ps = conn.prepareStatement(USER_GET);
//			ps.setString(1, vo.getId());
//			ps.setString(2, vo.getPassword());
//			rs = ps.executeQuery();
//			if(rs.next()) {
//				System.out.println("아이디 비밀번호 일치");
//				user = new UserVO();
//				user.setId(rs.getString("id"));
//				user.setName(rs.getString("name"));
//				user.setRole(rs.getString("role"));
//			}
//			else {
//				System.out.println("아이디 비밀번호 불일치");
//			}
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		} finally {
//			JDBCUtil.close(rs, ps, conn);
//		}
//		return user;
		
		
		Object[] args = {vo.getId(),vo.getPassword()};
		return jdbcTemplate.queryForObject(USER_GET, new UserRowMapper(), args);
		
	}
	
	public void insertUser(UserVO vo) {
		jdbcTemplate.update(USER_INSERT,vo.getId(), vo.getPassword(), vo.getName(), vo.getRole());
	}
}
