package com.poly;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.Cookie.CookieUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	  String username = CookieUtils.get("username", request);
	  String password = CookieUtils.get("password", request);
	  request.setAttribute("username", username);
	  request.setAttribute("password", password);

		request.getRequestDispatcher("/views/login/login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String remember = req.getParameter("remember");

		if(!username.equalsIgnoreCase("poly")) {
			req.setAttribute("message", "Sai tên đăng nhập!");
			}
			else if(password.length() < 6) {
			req.setAttribute("message", "Sai mật khẩu!");
			}
			else {
			req.setAttribute("message", "Đăng nhập thành công!");
			// ghi nhớ hoặc xóa tài khoản đã ghi nhớ bằng cookie
			int hours = (remember == null) ? 0 : 30*24; // 0 = xóa
			CookieUtils.add("username", username, hours, resp);
			CookieUtils.add("password", password, hours, resp);
			}
		req.getRequestDispatcher("/views/login/login.jsp").forward(req, resp);
	}

}
