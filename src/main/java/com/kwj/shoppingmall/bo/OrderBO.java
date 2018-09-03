package com.kwj.shoppingmall.bo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.kwj.shoppingmall.dao.OrderDAO;
import com.kwj.shoppingmall.dao.OrderDetailDAO;
import com.kwj.shoppingmall.dao.ProductDAO;
import com.kwj.shoppingmall.dao.UserDAO;
import com.kwj.shoppingmall.vo.OrderVO;
import com.kwj.shoppingmall.vo.ProductVO;
import com.kwj.shoppingmall.vo.UserVO;

public class OrderBO {
	@Autowired
	protected OrderDAO orderDAO;
	
	@Autowired
	protected UserDAO userDAO;
	
	@Autowired
	protected OrderDetailDAO orderDetailDAO;
	
	@Autowired
	protected ProductDAO productDAO;
	
	public void insertUserInfo(String userId, int productId,int quantity,String memo) {
		UserVO userVO = userDAO.select(userId);
		ProductVO productVO = productDAO.select(productId);
		OrderVO orderVO = new OrderVO();
		
		Date now = new Date();
		
		orderVO.setOrderMemo(memo);
		orderVO.setOrderDate(now.toString());
		orderVO.setAddress(userVO.getAddress());
		orderVO.setName(userVO.getUsername());
		orderVO.setPhone(userVO.getPhone());
		orderVO.setBrandName(productVO.getBrandName());
		orderVO.setUserId(userVO.getId());
		orderVO.setProductName(productVO.getName());
		orderVO.setColor(productVO.getColor());
		orderVO.setSize(productVO.getSize());
		orderVO.setImage(productVO.getImage());
		orderVO.setQuantity(quantity);
		orderDAO.insert(orderVO);
	}

	
	public void delete(int orderId) {
		orderDetailDAO.delete(orderId);
		orderDAO.delete(orderId);
	}
}
