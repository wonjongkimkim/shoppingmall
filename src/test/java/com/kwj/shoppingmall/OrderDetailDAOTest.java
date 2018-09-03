package com.kwj.shoppingmall;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kwj.shoppingmall.dao.OrderDetailDAO;
import com.kwj.shoppingmall.vo.OrderDetailVO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context-test.xml"})

public class OrderDetailDAOTest {
	@Autowired
	protected OrderDetailDAO orderDetailDAO;
	
	@Test
	public void insert() {
		OrderDetailVO orderVO = new OrderDetailVO();
		orderVO.setOrderId(1);
		orderVO.setProductId(2);
		orderVO.setPrice(100);
		orderVO.setBrandName("samsung");
		orderVO.setProductName("pants");
		orderVO.setColor("red");
		orderVO.setSize("big");
		orderVO.setImage(null);
		orderVO.setQuantity(10000);
		orderDetailDAO.insert(orderVO);
	}
	
	@Test
	public void selectList() {
		List<OrderDetailVO> orderList = orderDetailDAO.selectList();
		for(OrderDetailVO orderVO : orderList) {
			System.out.println(orderVO.getOrderId());
		}
	}
	
	@Test
	public void update() {
		OrderDetailVO orderVO = new OrderDetailVO();
		orderDetailDAO.update(orderVO);
	}
	
	@Test
	public void delete() {
		orderDetailDAO.delete(3);
	}
}
