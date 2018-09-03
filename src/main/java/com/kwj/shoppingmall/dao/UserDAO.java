package com.kwj.shoppingmall.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.kwj.shoppingmall.vo.UserVO;

public class UserDAO extends SqlSessionDaoSupport{

	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insert(UserVO userVO) {
		getSqlSession().insert("User.insert" , userVO);
	}
	
	public List<UserVO> selectList(){
		Map<String, String> paramMap = new HashMap<String, String>();
		return getSqlSession().selectList("User.selectList" , paramMap);
	}
	
	public void update(UserVO userVO) {
		getSqlSession().update("User.update" , userVO);
	}
	
	public void delete(String id) {
		getSqlSession().delete("User.delete",id);
	}
		
		
	
}
