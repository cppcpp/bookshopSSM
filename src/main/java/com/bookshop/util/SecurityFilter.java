package com.bookshop.util;


import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookshop.modle.Users;

/**
 * Servlet Filter implementation class SecurityFilter
 */
public class SecurityFilter implements Filter {

   
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse) response;
		String uri= req.getRequestURI();//项目名+请求路径名：/exam-system/login
		System.out.println("uri::"+uri);
		String path=uri.substring(10);
		System.out.println("path:::"+path);
		Users user= (Users) req.getSession().getAttribute("users");
		System.out.println("use:"+user);
		
		//登录页面，放行
		if(path.equals("login.html")) {
			chain.doFilter(request, response);
			return;
		}
		//未登录不能访问的页面--重定向到登录页面
		if(user==null) {
			if(path.equals("admin_manage_bookAdd.html")||
					path.equals("admin_manage_bookQuery.html")||
					path.equals("admin_manage.html")||
					path.equals("cart.html")||
					path.equals("confirmOrder.html")||
					path.equals("mine.html")||
					path.equals("mineAccount.html")||
					path.equals("mineAddress.html")||
					path.equals("mineInfo.html")||
					path.equals("mineOrders.html")) {
				System.out.println("---------------");
				res.sendRedirect("/bookshop/login.html");
				return;
			}
		}
		
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
