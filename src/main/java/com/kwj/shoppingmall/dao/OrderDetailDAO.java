package com.kwj.shoppingmall.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.kwj.shoppingmall.vo.OrderDetailVO;
import com.kwj.shoppingmall.vo.OrderVO;
import com.kwj.shoppingmall.vo.UserVO;

public class OrderDetailDAO extends SqlSessionDaoSupport{
private SqlSessionTemplate sqlSessionTemplate;
	
	public void insert(OrderDetailVO orderVO) {
		getSqlSession().insert("OrderDetail.insert" , orderVO);
	}
	
	public List<OrderDetailVO> selectList(){
		Map<String, String> paramMap = new HashMap<String, String>();
		return getSqlSession().selectList("OrderDetail.selectList" , paramMap);
	}
	
	public void update(OrderDetailVO orderDetailVO) {
		getSqlSession().update("OrderDetail.update" , orderDetailVO);
	}
	
	
	public void delete(int id) {
		getSqlSession().delete("OrderDetail.delete",id);
	}
}
