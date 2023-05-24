package com.example.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.board.BoardVO;
import com.example.common.JDBCUtil;

@Repository("boardDAO")
public class BoardDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//JDBC 변수
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	//SQL 명령어
	private final String BOARD_INSERT="insert into board (seq,title,writer,content) values ((select nvl(max(seq),0)+1 from board),?,?,?)";
	//private final String BOARD_INSERT="insert into board (seq,title,writer,content) values (?,?,?,?)";
	private final String BOARD_UPDATE="update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE="delete from board where seq=?";
	private final String BOARD_GET="select * from board where seq=?";
	private final String BOARD_LIST="select * from board order by seq desc";
	private final String BOARD_LIST_TITLE="select * from board where title like '%'||?||'%' order by seq desc";
	private final String BOARD_LIST_CONTENT="select * from board where content like '%'||?||'%' order by seq desc";
	
	//글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("insert board");

		
//		try {
//			conn = JDBCUtil.getConn();
//			ps = conn.prepareStatement(BOARD_INSERT);
//			ps.setString(1, vo.getTitle());
//			ps.setString(2, vo.getWriter());
//			ps.setString(3, vo.getContent());
//			ps.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			JDBCUtil.close(ps, conn);
//		}
		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	
	//글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("update board");
//		try {
//			conn = JDBCUtil.getConn();
//			ps = conn.prepareStatement(BOARD_UPDATE);
//			ps.setString(1, vo.getTitle());
//			ps.setString(2, vo.getContent());
//			ps.setInt(3, vo.getSeq());
//			int i = ps.executeUpdate();
//			if (i!=0) {
//				System.out.println("업뎃 됨");
//			}
//			else {
//				System.out.println("안됨");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			JDBCUtil.close(ps, conn);
//		}
		
		jdbcTemplate.update(BOARD_UPDATE,vo.getTitle(),vo.getContent(),vo.getSeq());
		
	}
	
	public void deleteBoard(String[] adminDelete) {
		int seq;
		try {
			conn = JDBCUtil.getConn();
			
			for(int i=0; i<adminDelete.length; i++) {
				seq = Integer.parseInt(adminDelete[i]);
				ps = conn.prepareStatement(BOARD_DELETE);
				ps.setInt(1, seq);
				ps.executeUpdate();
				ps.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, conn);
		}
	}
	
	//글 삭제
	public void deleteOneBoard(BoardVO vo) {
		System.out.println("delete board");
		
//		try {
//			conn = JDBCUtil.getConn();
//			
//			int seq = vo.getSeq();
//			ps = conn.prepareStatement("delete from board where seq=?");
//			ps.setInt(1, seq);
//			ps.executeUpdate();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			JDBCUtil.close(ps, conn);
//		}
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	}
	
	//글 상세조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("get board");
//		BoardVO board = new BoardVO();
//		try {
//			conn = JDBCUtil.getConn();
//			ps = conn.prepareStatement(BOARD_GET);
//			ps.setInt(1, vo.getSeq());
//			rs = ps.executeQuery();
//			
//			if(rs.next()) {
//				
//				board.setSeq(rs.getInt("seq"));
//				board.setTitle(rs.getString("title"));
//				board.setContent(rs.getString("content"));
//				board.setRegDate(rs.getString("regdate"));
//				board.setWriter(rs.getString("writer"));
//				board.setCnt(rs.getInt("cnt"));
//			}
//			rs.close();
//			
//			ps.close();
//			ps = conn.prepareStatement("update board set cnt=(select cnt+1 from board where seq=?) where seq=?");
//			ps.setInt(1, vo.getSeq());
//			ps.setInt(2, vo.getSeq());
//			ps.executeUpdate();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			JDBCUtil.close(ps, conn);
//		}
//		System.out.println("boardDAO : "+board);
//		return board;
		
		//조회수 상승
		jdbcTemplate.update("update board set cnt=(select cnt+1 from board where seq=?) where seq=?",vo.getSeq(),vo.getSeq());
		
		return jdbcTemplate.queryForObject(BOARD_GET, new BoardRowMapper(),vo.getSeq());
	}
	
	//글 목록조회
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("get boardList");
//		List<BoardVO> boardList = new ArrayList<>();
//		try {
//			conn = JDBCUtil.getConn();
//			if(vo.getSearchCondition().equals("title")) {
//				ps = conn.prepareStatement(BOARD_LIST_TITLE);
//				ps.setString(1, vo.getSearchKeyword());
//			}else if(vo.getSearchCondition().equals("content")) {
//				ps = conn.prepareStatement(BOARD_LIST_CONTENT);
//				ps.setString(1, vo.getSearchKeyword());
//			}else {
//				ps = conn.prepareStatement(BOARD_LIST);
//			}
//			rs = ps.executeQuery();
//			
//			while(rs.next()) {
//				BoardVO board = new BoardVO();
//				board.setSeq(rs.getInt("seq"));
//				board.setTitle(rs.getString("title"));
//				board.setContent(rs.getString("content"));
//				board.setRegDate(rs.getString("regdate"));
//				board.setWriter(rs.getString("writer"));
//				board.setCnt(rs.getInt("cnt"));
//				boardList.add(board);
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			JDBCUtil.close(ps, conn);
//		}
		
		//return boardList;
		Object[] args = {vo.getSearchKeyword()};
		if(vo.getSearchCondition().equals("title")) {
			return jdbcTemplate.query(BOARD_LIST_TITLE, new BoardRowMapper(), args);
		}else if(vo.getSearchCondition().equals("content")) {
			return jdbcTemplate.query(BOARD_LIST_CONTENT, new BoardRowMapper(), args);
		}else {
			return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
		}
	}

}
