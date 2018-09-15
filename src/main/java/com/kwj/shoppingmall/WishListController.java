package com.kwj.shoppingmall;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.kwj.shoppingmall.dao.ProductDAO;
import com.kwj.shoppingmall.dao.UserDAO;
import com.kwj.shoppingmall.dao.WishListDAO;
import com.kwj.shoppingmall.vo.ProductVO;
import com.kwj.shoppingmall.vo.UserVO;
import com.kwj.shoppingmall.vo.WishListVO;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes({"sessionId","sessionUsername"})
public class WishListController {
	
private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private WishListDAO wishListDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value = "/admin/wishlist/list", method = RequestMethod.GET)
		public String list( @RequestParam(value="id") String id,Model model) {
		List<WishListVO> wishList = wishListDAO.selectList();
		model.addAttribute("wishList", wishList);
		return "admin/wishlist/list";
	}	
	
	@RequestMapping(value = "/admin/wishlist/add", method = RequestMethod.GET)
	public String add( @RequestParam(value="id") String id,
			@RequestParam(value="productId") int productId,
			Model model) {
	WishListVO wishListVO = new WishListVO();
	ProductVO productVO = productDAO.select(productId);
	wishListVO.setUserId(id);
	wishListVO.setColor(productVO.getColor());
	wishListVO.setImage(productVO.getImage());
	wishListVO.setPrice(productVO.getPrice());
	wishListVO.setProductId(productId);
	wishListVO.setSize(productVO.getSize());
	wishListDAO.insert(wishListVO);
	return "admin/wishlist/add";
}	

	
}
