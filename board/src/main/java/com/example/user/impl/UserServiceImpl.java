package com.example.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user.UserService;
import com.example.user.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	//@Autowired
	//private UserDAO userDAO;	//repository("userDAO") 와 매칭됨
	
	@Autowired
	private UserDAOMybatis userDAO;
	
	@Override
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}

	@Override
	public void insertUser(UserVO vo) {
		userDAO.insertUser(vo);
	}
}
