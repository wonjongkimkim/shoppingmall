package com.kwj.shoppingmall;



import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kwj.shoppingmall.dao.UserDAO;
import com.kwj.shoppingmall.vo.ProductVO;
import com.kwj.shoppingmall.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context-test.xml"})

public class UserDAOTest {
	@Autowired
	protected UserDAO userDAO;
	
	@Test
	public void insert() {
		Date date = new Date();
		UserVO userVO = new UserVO();
		userVO.setId("2012003357");
		userVO.setUsername("Ronaldo");
		userVO.setEmail("ROnaldo@daum.net");
		userVO.setAddress("portugal");
		userVO.setPasswd("1234");
		userVO.setPhone("010-2017-8406");
		userVO.setCountry("Portugal");
		userVO.setDate(date.toString());
		userDAO.insert(userVO);
	}
	
	@Test
	public void selectList() {
		List<UserVO> userList = userDAO.selectList();
		for(UserVO userVO : userList) {
			if(userVO.getUsername().equals("wonjong")) {
				System.out.println(userVO.getId() +" "+ userVO.getUsername());
			}
		}
	}
	
	@Test
	public void select() {
		UserVO userVO = new UserVO();
		userVO = userDAO.select("2012003350");
		System.out.println(userVO.getUsername());
	}
	
	@Test
	public void update() {
		Date date = new Date();
		UserVO userVO = new UserVO();
		userVO.setId("2012003350");
		userVO.setUsername("UIzo");
		userVO.setEmail("Uizo@daum.net");
		userVO.setAddress("Argen");
		userVO.setPasswd("1234");
		userVO.setPhone("010-2017-8416");
		userVO.setCountry("Argentina");
		userVO.setDate(date.toString());
		userDAO.update(userVO);
	}
	
	@Test
	public void delete() {
		userDAO.delete("2012003350");
	}
}
