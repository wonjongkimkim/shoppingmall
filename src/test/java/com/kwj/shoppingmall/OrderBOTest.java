package com.kwj.shoppingmall;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kwj.shoppingmall.bo.OrderBO;
import com.kwj.shoppingmall.dao.OrderDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context-test.xml"})

public class OrderBOTest {
	@Autowired
	protected OrderBO orderBO;
	
	@Test
	public void delete() {
		orderBO.delete(1);
	}
	
	@Test
	public void insert() {
		orderBO.insertUserInfo("2012003350", 2, 100, "fast please");
	}
}
