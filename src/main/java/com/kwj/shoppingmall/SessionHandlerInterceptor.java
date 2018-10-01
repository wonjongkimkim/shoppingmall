package com.kwj.shoppingmall;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionHandlerInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		
		if ( session.getAttribute("sessionId") == null 
				|| session.getAttribute("sessionId").equals("")) {
			response.sendRedirect("/admin/login/login");
			return false;
		};
		
		

		return true;
	}

}
