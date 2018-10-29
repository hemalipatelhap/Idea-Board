package com.ideaboard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ideaboard.dao.IdeaDao;
import com.ideaboard.dao.UserDao;
import com.ideaboard.model.Idea;
import com.ideaboard.model.User;



public class RegistrationController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
		String netId = request.getParameter("netId");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		registerUser(netId, fname, lname, username, password);
		
		request.setAttribute("registrationSuccessMsg", "registered successfully!");
		RequestDispatcher rd = request.getRequestDispatcher("registrationForm.jsp");
		rd.forward(request, response);
		
	}

	private void registerUser(String netId, String fname, String lname, String username, String password) {
		UserDao userDao = new UserDao();
		User user = new User();
		user.setNetId(netId);
		user.setFirstName(fname);
		user.setLastName(lname);
		user.setUsername(username);
		user.setPassword(password);
		userDao.register(user);
		
	}
	
	
}
