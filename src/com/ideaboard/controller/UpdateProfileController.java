package com.ideaboard.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ideaboard.dao.UserDao;
import com.ideaboard.model.UserProfile;

public class UpdateProfileController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String netId = request.getSession().getAttribute("netId").toString();
		viewProfile(netId, request);
		RequestDispatcher rd = request.getRequestDispatcher("viewProfile.jsp");
		rd.forward(request, response);
	}
	private void viewProfile(String netId, HttpServletRequest request) {
		UserDao userDao = new UserDao();
		UserProfile profile = userDao.getProfile(netId);
		request.setAttribute("profile", profile);
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String netId = request.getSession().getAttribute("netId").toString();
		updateProfile(netId, request);
		
		request.setAttribute("netId", netId);
		RequestDispatcher rd = request.getRequestDispatcher("viewProfile.jsp");
		rd.forward(request, response);
		
	}

	private void updateProfile(String netId, HttpServletRequest request) {
		UserProfile profile = new UserProfile(netId);
		
		if(request.getParameter("exp") != null) {
		int exp = Integer.parseInt(request.getParameter("exp"));
		profile.setExperience(exp);
		String exp_string = profile.getExperience();
		profile.setExperience(exp_string);
		}
		if(request.getParameterValues("skill")!=null){
		List<String> skills = new ArrayList<String>(Arrays.asList(request.getParameterValues("skill")));
		profile.setSkills(skills);
		}
		if(request.getParameterValues("aoi") != null) {
		List<String> aoiList = new ArrayList<String>(Arrays.asList(request.getParameterValues("aoi")));
		profile.setAoiList(aoiList);
		}
		
		UserDao userDao = new UserDao();
		System.out.println(profile.getExperience());
		userDao.updateProfile(profile);
		
	}
	

}
