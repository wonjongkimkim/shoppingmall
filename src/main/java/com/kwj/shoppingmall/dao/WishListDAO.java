package com.kwj.shoppingmall.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.kwj.shoppingmall.vo.WishListVO;

public class WishListDAO extends SqlSessionDaoSupport{
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insert(WishListVO wishListVO) {
		getSqlSession().insert("WishList.insert" , wishListVO);
	}
	
	public List<WishListVO> selectList(){
		Map<String, String> paramMap = new HashMap<String, String>();
		return getSqlSession().selectList("WishList.selectList" , paramMap);
	}
	
	public void update(WishListVO wishListVO) {
		getSqlSession().update("WishList.update" , wishListVO);
	}
	
	public void delete(int id) {
		getSqlSession().delete("WishList.delete",id);
	}
		
}
