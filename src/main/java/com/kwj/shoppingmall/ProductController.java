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

import com.kwj.shoppingmall.dao.BrandDAO;
import com.kwj.shoppingmall.dao.ProductDAO;
import com.kwj.shoppingmall.dao.UserDAO;
import com.kwj.shoppingmall.dao.WishListDAO;
import com.kwj.shoppingmall.vo.BrandVO;
import com.kwj.shoppingmall.vo.ProductVO;
import com.kwj.shoppingmall.vo.UserVO;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes({"sessionId","sessionEmail"})
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
		
		@Autowired
		private ProductDAO productDAO;
		
		@Autowired
		private BrandDAO brandDAO;
		
		@Autowired
		private WishListDAO wishListDAO;
		
		@RequestMapping(value = "/admin/product/list", method = RequestMethod.GET)
			public String list( @ModelAttribute("sessionId") String sessionId
					, @ModelAttribute("sessionEmail") String sessionEmail
					, Model model) {
			List<ProductVO> productList = productDAO.selectList();
			model.addAttribute("productList", productList);
			return "admin/product/list";
		}	
	
		@RequestMapping(value = "/admin/product/add", method = RequestMethod.GET)
			public String add( Model model) {
			List<ProductVO> productList = productDAO.selectList();
			model.addAttribute("productList", productList);
			
			List<BrandVO> brandList = brandDAO.selectList();
			model.addAttribute("brandList",brandList);
	
			return "admin/product/add";
		}
	
		@RequestMapping(value = "/admin/product/info", method = RequestMethod.GET)
			public String info(@ModelAttribute("sessionId") String sessionId,
					@RequestParam("id") int id, Locale locale, Model model) {
			ProductVO product = productDAO.select(id); 
			List<BrandVO> brandList = brandDAO.selectList();
			model.addAttribute("productVO", product);
			return "admin/product/info";
		}
		
		@RequestMapping(value = "/admin/product/doAdd", method = RequestMethod.POST)
		public String doAdd  (
				@RequestParam("file") MultipartFile file,
				@RequestParam(value = "name") String name,
				@RequestParam(value = "brandName") String brandName,
				@RequestParam(value = "amount") int amount,
				@RequestParam(value = "price") float price,
				@RequestParam(value = "color") String color,
				@RequestParam(value = "size") String size,
				@RequestParam(value = "category") String category,
				 Model model) throws IOException {
			
			// Save file on system
		      if (!file.getOriginalFilename().isEmpty()) {
		         BufferedOutputStream outputStream = new BufferedOutputStream(
		               new FileOutputStream(
		                     new File("C:/Users/kimwonjong/pic", file.getOriginalFilename())));
		         outputStream.write(file.getBytes());
		         outputStream.flush();
		         outputStream.close();
		      } 
		    ProductVO productVO = new ProductVO();
		    productVO.setAmount(amount);
		    productVO.setBrandName(brandName);
		    productVO.setCategory(category);
		    productVO.setColor(color);
		    productVO.setName(name);
		    productVO.setSize(size);
		    productVO.setPrice(price);
		    productVO.setImage(file.getOriginalFilename());
		    model.addAttribute("name", name);
		    productDAO.insert(productVO);
		    
			return "admin/product/doAdd";
	
		}
		
		@RequestMapping(value = "/admin/product/delete", method = RequestMethod.GET)
		public String delete(@RequestParam("id") int id, Locale locale, Model model) {
			wishListDAO.delete(id);
			productDAO.delete(id);
			return "admin/product/delete";
		}
	}
