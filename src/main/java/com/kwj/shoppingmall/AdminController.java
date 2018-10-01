package com.kwj.shoppingmall;

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

import com.kwj.shoppingmall.dao.ProductDAO;
import com.kwj.shoppingmall.dao.UserDAO;
import com.kwj.shoppingmall.vo.ProductVO;
import com.kwj.shoppingmall.vo.UserVO;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes({"sessionId","sessionEmail"})
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private ProductDAO productDAO;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/admin/users/list", method = RequestMethod.GET)
	public String list(@ModelAttribute("sessionId") String sessionId,
			@ModelAttribute("sessionId") String sessionEmail
			, @RequestParam(value="id", defaultValue="") String id
			,Locale locale, 
			Model model) {

		List<UserVO> userList = userDAO.selectList();
		
		model.addAttribute("userList", userList);
		System.out.println(sessionId);
		return "admin/users/list";
	}
	
	@RequestMapping(value = "/admin/users/info", method = RequestMethod.GET)
	public String info(@ModelAttribute("sessionId") String sessionId,
			@RequestParam("id") String id, Locale locale, Model model) {
		UserVO user = userDAO.select(id); 
		model.addAttribute("userVO", user);
		return "admin/users/info";
	}
	
	@RequestMapping(value = "/admin/login/login", method = RequestMethod.GET)
	public String login(
			@SessionAttribute(required=false, value="sessionId") String sessionId
			, Model model) {
	
		System.out.println("["+sessionId+"]");
		if ( sessionId == null || sessionId.equals("") ) {
			// 로그인이 안되어 있는 상
		} else {
			// 로그인이 되어이 있는 상태
			return "redirect:/admin/users/list";
		}
		
		return "admin/login/login";
	}
	
	@RequestMapping(value = "/admin/login/reLogin", method = RequestMethod.GET)
	public String reLogin(
			@SessionAttribute(required=false, value="sessionId") String sessionId
			, Model model) {
	
		
		return "admin/login/reLogin";
	}
	
	@RequestMapping(value = "/admin/login/doLogin", method = RequestMethod.POST)
	public String doLogin(
			@SessionAttribute(required=false, value="sessionId") String sessionId
			, @RequestParam(value="id") String id
			, @RequestParam(value="passwd") String passwd
			, Model model) {
		
		
		UserVO userVO = userDAO.select(id);
	
		if ( userVO == null ) {
			// 다시 로그인을 하세요.
			return "admin/login/reLogin";
		}
		
		if ( userVO.getPasswd().equals(passwd) ) {
			// 로그인 성공
			model.addAttribute("sessionId", userVO.getId());
			model.addAttribute("sessionEmail", userVO.getEmail());
			
			return "redirect:/admin/users/list";
		} else
		{
			// 로그인 실패: 비밀번호가 다르니까.
			model.addAttribute("sessionId", "");
			model.addAttribute("sessionEmail", "");
		}
		
		return "redirect:/admin/login/login";
	}
	
	
	@RequestMapping(value = "/admin/login/logout", method = RequestMethod.GET)
	public String logout(
			@ModelAttribute("sessionId") String sessionId
			, Model model) {
		
		
		model.addAttribute("sessionId", "");
		model.addAttribute("sessionEmail", "");
		
		return "redirect:/admin/login/login";
	}
	

	
	@RequestMapping(value = "/admin/users/register", method = RequestMethod.GET)
	public String register(Locale locale, Model model) {
		
		return "admin/users/register";
	}
	
	@RequestMapping(value = "/admin/users/add", method = RequestMethod.GET)
	public String add(@ModelAttribute("sessionId") String sessionId,
			Model model) {
		
		return "admin/users/add";
	}
	
	@RequestMapping(value = "/admin/users/doAdd", method = RequestMethod.POST)
	public String doAdd(@RequestParam(value = "id") String id,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "username") String username,
			@RequestParam(value = "phone") String phone,
			@RequestParam(value = "address") String address,
			@RequestParam(value = "email") String email,
			Locale locale, Model model) {
		Date now = new Date();
		UserVO userVO = new UserVO();
		userVO.setId(id);
		userVO.setUsername(username);
		userVO.setAddress(address);
		userVO.setEmail(email);
		userVO.setPasswd(password);
		userVO.setPhone(phone);
		userVO.setDate(now.toString());
		userDAO.insert(userVO);
		
		model.addAttribute("id", id);
		model.addAttribute("password", password);
		model.addAttribute("username", username);
		model.addAttribute("phone", phone);
		model.addAttribute("address", address);
		model.addAttribute("email", email);
		return "admin/users/doAdd";
	}
	
	@RequestMapping(value = "/admin/users/update", method = RequestMethod.GET)
	public String update(
			@RequestParam("id") String id, Locale locale, Model model) {
		UserVO user = userDAO.select(id); 
		model.addAttribute("userVO", user);
		return "admin/users/update";
	}
	
	@RequestMapping(value = "/admin/users/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("id") String id, Locale locale, Model model) {
		userDAO.delete(id);
		return "admin/users/delete";
	}
	
	@RequestMapping(value = "/admin/users/doUpdate", method = RequestMethod.POST)
	public String doUpdate(
			@RequestParam(value = "id") String id,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "username") String username,
			@RequestParam(value = "phone") String phone,
			@RequestParam(value = "address") String address,
			@RequestParam(value = "email") String email,
			Locale locale, Model model) {
		Date now = new Date();
		UserVO userVO = new UserVO();
		userVO.setId(id);
		userVO.setUsername(username);
		userVO.setAddress(address);
		userVO.setEmail(email);
		userVO.setPasswd(password);
		userVO.setPhone(phone);
		userVO.setDate(now.toString());
		userDAO.update(userVO);
		model.addAttribute("userVO", userVO);
		model.addAttribute("id", id);
		model.addAttribute("password", password);
		model.addAttribute("username", username);
		model.addAttribute("phone", phone);
		model.addAttribute("address", address);
		model.addAttribute("email", email);
		return "admin/users/doUpdate";
	}
}
