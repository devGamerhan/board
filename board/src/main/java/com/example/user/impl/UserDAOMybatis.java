package com.example.user.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.user.UserVO;

@Repository
public class UserDAOMybatis {
	
	@Autowired
	private SqlSessionTemplate mybatis;
		
	//유저 정보
	public UserVO getUser(UserVO vo) {
		System.out.println("userDAO 의 getUser 실행");
		System.out.println("입력 id : "+vo.getId());
		System.out.println("입력 pw : "+vo.getPassword());

		return mybatis.selectOne("UserDAO.getUser", vo);		
	}
	
	public void insertUser(UserVO vo) {
		mybatis.update("UserDAO.insertUser", vo);
	}
}
