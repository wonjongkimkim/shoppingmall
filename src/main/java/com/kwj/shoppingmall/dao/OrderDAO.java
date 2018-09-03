package com.kwj.shoppingmall.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.kwj.shoppingmall.vo.OrderVO;
import com.kwj.shoppingmall.vo.ReviewVO;
import com.kwj.shoppingmall.vo.UserVO;

public class OrderDAO extends SqlSessionDaoSupport{
private SqlSessionTemplate sqlSessionTemplate;
	
	public void insert(OrderVO orderVO) {
		getSqlSession().insert("Order.insert" , orderVO);
	}
	
	public List<OrderVO> selectList(){
		Map<String, String> paramMap = new HashMap<String, String>();
		return getSqlSession().selectList("Order.selectList" , paramMap);
	}
	
	public void update(OrderVO orderVO) {
		getSqlSession().update("Order.update" , orderVO);
	}
	
	
	public void delete(int id) {
		getSqlSession().delete("Order.delete",id);
	}
}
