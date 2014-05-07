package cn.edu.zust.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.zust.entity.Admin;
import cn.edu.zust.entity.User;

public class ManagerFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession();
		HttpServletResponse response = (HttpServletResponse) res;
		String path = request.getContextPath();
		String url = request.getRequestURL().toString();
		if (url.contains("/user/")) {
			User user = (User) session.getAttribute("user");
			if (user != null) {
				chain.doFilter(request, response);
			} else {
				response.sendRedirect(path + "/index.jsp");
			}
		} else if (url.contains("/admin/")) {
			Admin admin = (Admin) session.getAttribute("admin");
			if (admin != null) {
				chain.doFilter(request, response);
			} else {
				response.sendRedirect(path + "/adminLogin.jsp");
			}
		} else {
			chain.doFilter(request, response);
		}

	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
