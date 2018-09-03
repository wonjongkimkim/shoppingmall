package com.kwj.shoppingmall;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kwj.shoppingmall.bo.UserBO;
import com.kwj.shoppingmall.dao.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context-test.xml"})


public class UserBOTest {
	@Autowired
	protected UserBO userBO;
	
	@Test
	public void delete(String id) {
		userBO.delete(id);
	}
}
