package com.kwj.shoppingmall.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.kwj.shoppingmall.vo.ReviewVO;

public class ReviewDAO extends SqlSessionDaoSupport{
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insert(ReviewVO reviewVO) {
		getSqlSession().insert("Review.insert" , reviewVO);
	}
	
	public List<ReviewVO> selectList(){
		Map<String, String> paramMap = new HashMap<String, String>();
		return getSqlSession().selectList("Review.selectList" , paramMap);
	}
	
	public void update(ReviewVO reviewVO) {
		getSqlSession().update("Review.update" , reviewVO);
	}
	
	
	public void delete(int id) {
		getSqlSession().delete("Review.delete",id);
	}
}
