package com.kwj.shoppingmall.bo;

import org.springframework.beans.factory.annotation.Autowired;

import com.kwj.shoppingmall.dao.ReviewDAO;
import com.kwj.shoppingmall.dao.UserDAO;
import com.kwj.shoppingmall.vo.ReviewVO;
import com.kwj.shoppingmall.vo.UserVO;

public class UserBO {
	@Autowired 
	protected UserDAO userDAO;
	
	@Autowired 
	protected ReviewDAO reviewDAO;
	
	public void delete(String id) {
		userDAO.delete(id);
	}
	
	public void insert(UserVO userVO) {
		userDAO.insert(userVO);
	}
	
	public void update(UserVO userVO) {
		userDAO.update(userVO);
	}
	
	public UserVO select(String id) {
		UserVO userVO = userDAO.select(id);
		return userVO;
	}
	
}
