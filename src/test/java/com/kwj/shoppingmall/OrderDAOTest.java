package com.kwj.shoppingmall;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kwj.shoppingmall.dao.OrderDAO;
import com.kwj.shoppingmall.vo.BrandVO;
import com.kwj.shoppingmall.vo.OrderVO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context-test.xml"})

public class OrderDAOTest {
	@Autowired
	protected OrderDAO orderDAO;
	
	@Test
	public void insert() {
		OrderVO orderVO = new OrderVO();
		Date now = new Date();
		
		orderVO.setOrderMemo("aa");
		orderVO.setOrderDate(now.toString());
		orderVO.setAddress(null);
		orderVO.setName(null);
		orderVO.setPhone(null);
		orderVO.setBrandName("samsung");
		orderVO.setUserId("2012003350");
		orderVO.setProductName("pants");
		orderVO.setColor("red");
		orderVO.setSize("big");
		orderVO.setImage(null);
		orderVO.setQuantity(10000);
		orderDAO.insert(orderVO);
	}
	
	@Test
	public void selectList() {
		List<OrderVO> orderList = orderDAO.selectList();
		for(OrderVO orderVO : orderList) {
			System.out.println(orderVO.getName());
		}
	}
	
	@Test
	public void update() {
		OrderVO orderVO = new OrderVO();
		orderDAO.update(orderVO);
	}
	
	@Test
	public void delete() {
		orderDAO.delete(2);
	}
}
