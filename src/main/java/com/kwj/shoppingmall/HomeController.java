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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kwj.shoppingmall.dao.UserDAO;
import com.kwj.shoppingmall.vo.UserVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private UserDAO userDAO;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/admin/users/list", method = RequestMethod.GET)
	public String list(Locale locale, Model model) {
		List<UserVO> userList = userDAO.selectList();
		model.addAttribute("userList", userList);
		return "admin/users/list";
	}
	
	@RequestMapping(value = "/admin/users/info", method = RequestMethod.GET)
	public String info(@RequestParam("id") String id, Locale locale, Model model) {
		UserVO user = userDAO.select(id); 
		model.addAttribute("userVO", user);
		return "admin/users/info";
	}
	
	@RequestMapping(value = "/admin/users/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		
		return "admin/users/login";
	}
	
	@RequestMapping(value = "/admin/users/register", method = RequestMethod.GET)
	public String register(Locale locale, Model model) {
		
		return "admin/users/register";
	}
}
