package com.kwj.shoppingmall;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kwj.shoppingmall.dao.ProductDAO;
import com.kwj.shoppingmall.vo.BrandVO;
import com.kwj.shoppingmall.vo.ProductVO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context-test.xml"})



public class ProductDAOTest {

	@Autowired
	protected ProductDAO productDAO;
	
	@Test
	public void insert() {
		ProductVO productVO = new ProductVO();
		productVO.setName("echo bag");
		productVO.setAmount(1001);
		productVO.setColor("red");
		productVO.setPrice(1000);
		productVO.setImage(null);
		productVO.setCategory("bag");
		productVO.setSize(null);
		productVO.setBrandName("Hyundai");
		productDAO.insert(productVO);
	}
	
	@Test
	public void selectList() {
		List<ProductVO> productList = productDAO.selectList();
		for(ProductVO productVO : productList) {
			System.out.println(productVO.getId());
			
		}
	}
	
	@Test
	public void select() {
		ProductVO productVO = new ProductVO();
		productVO = productDAO.select(123457);
		System.out.println(productVO.getPrice());
	}
	
	@Test
	public void update() {
		ProductVO productVO = new ProductVO();
		productVO.setId(123456);
		productVO.setName("pants");
		productVO.setAmount(1001);
		productVO.setColor("blue");
		productVO.setPrice(1000);
		productVO.setImage(null);
		productVO.setCategory("bag");
		productVO.setSize(null);
		productVO.setBrandName("Hyundai");
		productDAO.update(productVO);
	}
	
	@Test
	public void delete() {
		productDAO.delete(123456);
	}
}
