package com.kwj.shoppingmall;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kwj.shoppingmall.dao.ReviewDAO;
import com.kwj.shoppingmall.vo.ReviewVO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context-test.xml"})

public class ReviewDAOTest {
	@Autowired
	protected ReviewDAO reviewDAO;
	
	@Test
	public void insert() {
		ReviewVO reviewVO = new ReviewVO();
		reviewVO.setContents("Not good!");
		reviewVO.setUserId("2012003352");
		reviewVO.setProductId(123457);
		reviewDAO.insert(reviewVO);
	}
	
	@Test
	public void selectList() {
		List<ReviewVO> reviewList = reviewDAO.selectList();
		for(ReviewVO reviewVO : reviewList) {
			System.out.println(reviewVO.getUserId());
		}
	}
	
	@Test
	public void update() {
		ReviewVO reviewVO = new ReviewVO();
		reviewVO.setId(2);
		reviewVO.setContents("Good!");
		reviewDAO.update(reviewVO);
	}
	
	@Test
	public void delete() {
		reviewDAO.delete(2);
	}
}
