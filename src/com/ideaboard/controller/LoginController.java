package com.ideaboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ideaboard.dao.UserDao;
import com.ideaboard.model.User;




public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = -7821022867327683414L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String netId = request.getParameter("netId");
		String password = request.getParameter("password");
		String username = userAuthentication(netId, password);
		
		
		if(!username.isEmpty()) {
			request.getSession().setAttribute("username", username);
			request.getSession().setAttribute("netId", netId);
		    RequestDispatcher rd = request.getRequestDispatcher("userHomePage.jsp");
			rd.forward(request, response);
			
		}else {
			request.setAttribute("error", "invalid!");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		
	}

	private String userAuthentication(String netId, String password) {
		UserDao userDao = new UserDao();
		User user = new User();
		user.setNetId(netId);
		user.setPassword(password);
		String username = userDao.validateUser(user);
		return username;
	}
	

}
