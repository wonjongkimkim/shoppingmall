package com.kwj.shoppingmall;



import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kwj.shoppingmall.dao.UserDAO;
import com.kwj.shoppingmall.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context-test.xml"})

public class UserDAOTest {
	@Autowired
	protected UserDAO userDAO;
	
	@Test
	public void insert() {
		UserVO userVO = new UserVO();
		userVO.setId("2012003350");
		userVO.setUsername("messi");
		userVO.setEmail("messi@daum.net");
		userVO.setAddress("Argen");
		userVO.setPasswd("1234");
		userVO.setPhone("010-2017-8416");
		userVO.setCountry("Argentina");
		userVO.setDate("20180123");
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
	public void update() {
		UserVO userVO = new UserVO();
		userVO.setId("2012003355");
		userVO.setUsername("Ronaldo");
		userVO.setEmail("messi@daum.net");
		userVO.setAddress("Argen");
		userVO.setPasswd("1234");
		userVO.setPhone("010-2017-8416");
		userVO.setCountry("Argentina");
		userVO.setDate("20180123");
		userDAO.update(userVO);
	}
	
	@Test
	public void delete() {
		userDAO.delete("2012003352");
	}
}
