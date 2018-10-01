package com.kwj.shoppingmall;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

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
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kwj.shoppingmall.dao.BrandDAO;
import com.kwj.shoppingmall.dao.ProductDAO;
import com.kwj.shoppingmall.dao.UserDAO;
import com.kwj.shoppingmall.dao.WishListDAO;
import com.kwj.shoppingmall.vo.BrandVO;
import com.kwj.shoppingmall.vo.ProductVO;
import com.kwj.shoppingmall.vo.UserVO;
import com.kwj.shoppingmall.vo.WishListVO;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes({"sessionId","sessionEmail"})
public class HomeController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private BrandDAO brandDAO;
	
	@Autowired
	private WishListDAO wishListDAO;
	/**
	 * Simply selects the home view to render by returning its name.
	 */ 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(@RequestParam(value="name", defaultValue="") String name, Model model) {
		
		if(name.equals("")) {
			List<ProductVO> productList = productDAO.selectList();
			model.addAttribute("productList", productList);
		}
		if(!name.equals("")) {
			model.addAttribute("name", name);
			List<ProductVO> productList = productDAO.selectByName(name);
			model.addAttribute("productList", productList);
			
		}
		List<BrandVO> brandList = brandDAO.selectList();
		model.addAttribute("brandList", brandList);
		return "index";
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String products(Locale locale, Model model) {
		
		return "products";
	}
	
	
	@RequestMapping(value = "/shop", method = RequestMethod.GET)
	public String shop(Locale locale, Model model) {
		
		
		
		return "shop";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		
	
		
		return "login";
	}
	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String cart(@RequestParam(value="id") String id, Model model) {
		List<WishListVO> wishList = wishListDAO.select(id);
		model.addAttribute("wishList", wishList);
		float total = 0;
		for(int i=0; i<wishList.size();i++) {
			total += wishList.get(i).getQuantity()*wishList.get(i).getPrice();
		}
		model.addAttribute("total", total);
		return "cart";
	}
	
	@RequestMapping(value = "/addQuantity", method = RequestMethod.GET)
	public String addQuantity(@RequestParam(value="id") String id,
			@RequestParam(value="productId") int productId,
			Model model) {
		List<WishListVO> wishList = wishListDAO.select(id);
		model.addAttribute("wishList", wishList);
		
		for(int i=0; i<wishList.size();i++) {
			if(wishList.get(i).getProductId() == productId){
				WishListVO wishListVO = wishList.get(i);
				wishListVO.setQuantity(wishListVO.getQuantity()+1);
				wishListDAO.update(wishListVO);
				break;
			}
		}
		return "addQuantity";
	}
	
	@RequestMapping(value = "/minusQuantity", method = RequestMethod.GET)
	public String minusQuantity(@RequestParam(value="id") String id,
			@RequestParam(value="productId") int productId,
			Model model) {
		List<WishListVO> wishList = wishListDAO.select(id);
		model.addAttribute("wishList", wishList);
		
		for(int i=0; i<wishList.size();i++) {
			if(wishList.get(i).getProductId() == productId){
				WishListVO wishListVO = wishList.get(i);
				wishListVO.setQuantity(wishListVO.getQuantity()-1);
				wishListDAO.update(wishListVO);
				break;
			}
		}
		return "minusQuantity";
	}
	
	@RequestMapping(value = "/product-details", method = RequestMethod.GET)
	public String productdetails(@RequestParam(value="productId") int productId, Model model) {
		model.addAttribute("productId", productId);
		ProductVO productVO = productDAO.select(productId);
		model.addAttribute("productVO", productVO);
		return "product-details";
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String checkout(Locale locale, Model model) {
		
		
	
		return "checkout";
	}
	
	@RequestMapping(value = "/contact-us", method = RequestMethod.GET)
	public String contactus(Locale locale, Model model) {
		
		
		
		return "contact-us";
	}
	
	@RequestMapping(value = "/blog-single", method = RequestMethod.GET)
	public String blogsingle(Locale locale, Model model) {
		
	
		
		return "blog-single";
	}
	
	@RequestMapping(value = "/blog", method = RequestMethod.GET)
	public String blog(Locale locale, Model model) {
		
		
		return "blog";
	}
	
	@RequestMapping(value = "/404", method = RequestMethod.GET)
	public String F04(Locale locale, Model model) {
		
	
		
		return "404";
	}
	
	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	
	public String doLogin(
			@SessionAttribute(required=false, value="sessionId") String sessionId,
			@RequestParam(value="id") String id
			, @RequestParam(value="password") String password
			, Model model) {
		UserVO userVO = userDAO.select(id);
		if ( userVO == null ) {
			// 다시 로그인을 하세요.
			return "login";
		}
		if ( userVO.getPasswd().equals(password) ) {
			// 로그인 성공
			model.addAttribute("sessionId", userVO.getId());
			model.addAttribute("sessionEmail", userVO.getEmail());
			
			return "redirect:/";
		} else
		{
			// 로그인 실패: 비밀번호가 다르니까.
			model.addAttribute("sessionId", "");
			model.addAttribute("sessionEmail", "");
		}
		
		
		
		return "redirect:login";
	}
	
	@RequestMapping(value = "/doAdd", method = RequestMethod.POST)
	public String doAdd(@RequestParam(value = "id") String id,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "username") String username,
			@RequestParam(value = "phone") String phone,
			@RequestParam(value = "address") String address,
			@RequestParam(value = "email") String email,
			Model model) {
		Date now = new Date();
		UserVO userVO = new UserVO();
		userVO.setId(id);
		userVO.setUsername(username);
		userVO.setAddress(address);
		userVO.setEmail(email);
		userVO.setPasswd(password);
		userVO.setPhone(phone);
		userVO.setDate(now.toString());
		boolean duplication = false;
		
		
		List<UserVO> userList = userDAO.selectList();
		for(int i=0; i < userList.size(); i++) {
			if(userList.get(i).getId().equals(id)) {
				duplication = true;
				break;
			}
		}
		System.out.println(duplication);
		
		if(duplication)
			return "duplication";
		
		userDAO.insert(userVO);
		model.addAttribute("id", id);
		model.addAttribute("password", password);
		model.addAttribute("username", username);
		model.addAttribute("phone", phone);
		model.addAttribute("address", address);
		model.addAttribute("email", email);
		return "doAdd";
	}
	
	@RequestMapping(value = "/addCart", method = RequestMethod.GET)
	public String addCart(@RequestParam(value = "id") String id,
			@RequestParam(value = "productId") int productId,
			Model model) {
		WishListVO wishListVO = new WishListVO();
		ProductVO productVO = productDAO.select(productId);
		wishListVO.setUserId(id);
		wishListVO.setColor(productVO.getColor());
		wishListVO.setImage(productVO.getImage());
		wishListVO.setPrice(productVO.getPrice());
		wishListVO.setProductId(productId);
		wishListVO.setSize(productVO.getSize());
		List<WishListVO> wishList = wishListDAO.select(id);
		boolean duplication = false;
		for(int i=0; i<wishList.size(); i++) {
			if(wishList.get(i).getProductId() == productId) {
				duplication = true;
				break;
			}
		}
		if(!duplication)
			wishListDAO.insert(wishListVO);
		return "addCart";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("id") int id, Locale locale, Model model) {
		wishListDAO.delete(id);
		return "delete";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@RequestParam(value = "name") String name, 
			Model model) {
		List<ProductVO> productList = productDAO.selectByName(name);
		model.addAttribute("productList", productList);
		
		return "search";
	}
}
