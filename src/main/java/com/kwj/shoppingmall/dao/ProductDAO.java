package com.kwj.shoppingmall.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.kwj.shoppingmall.vo.ProductVO;

public class ProductDAO extends SqlSessionDaoSupport{
	
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insert(ProductVO productVO) {
		getSqlSession().insert("Product.insert" , productVO);
	}
	
	public List<ProductVO> selectList(){
		Map<String, String> paramMap = new HashMap<String, String>();
		return getSqlSession().selectList("Product.selectList" , paramMap);
	}
	
	public ProductVO select(int id) {
		return getSqlSession().selectOne("Product.select", id);
	}
	
	public void update(ProductVO productVO) {
		getSqlSession().update("Product.update" , productVO);
	}
	
	
	public void delete(int id) {
		getSqlSession().delete("Product.delete",id);
	}
}


