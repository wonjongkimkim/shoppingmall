package com.kwj.shoppingmall;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kwj.shoppingmall.dao.ProductDAO;
import com.kwj.shoppingmall.dao.WishListDAO;
import com.kwj.shoppingmall.vo.ProductVO;
import com.kwj.shoppingmall.vo.WishListVO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context-test.xml"})


public class WishListDAOTest {
	@Autowired
	protected WishListDAO wishListDAO;
	
	@Autowired
	protected ProductDAO productDAO;
	
	@Test
	public void insert() {
		WishListVO wishListVO = new WishListVO();
		ProductVO productVO = new ProductVO();
		productVO = productDAO.select(123457);
		wishListVO.setProductId(productVO.getId());
		wishListVO.setProductId(123457);
		wishListVO.setQuantity(3);
		wishListVO.setUserId("2012003352");
		wishListVO.setColor(productVO.getColor());
		wishListVO.setPrice(productVO.getPrice());
		wishListVO.setImage(productVO.getImage());
		wishListVO.setSize(productVO.getSize());
		wishListVO.setBrandName(productVO.getBrandName());
		wishListDAO.insert(wishListVO);
	}

	@Test
	public void selectList() {
		List<WishListVO> wishListList = wishListDAO.selectList();
		for(WishListVO wishListVO : wishListList) {
			System.out.println(wishListVO.getUserId());
			
		}
	}
	
	@Test
	public void update() {
		WishListVO wishListVO = new WishListVO();
		wishListVO.setProductId(123457);
		wishListVO.setQuantity(100);
		wishListDAO.update(wishListVO);
	}
	
	@Test
	public void delete() {
		wishListDAO.delete(123457);
	}
}
